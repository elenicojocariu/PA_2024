package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;
    private List<Tile> tiles = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        running = true;
        while (running && game.isGameRunning()) {
            synchronized (game.getTurnLock()) {
                while (!isMyTurn() && game.isGameRunning()) {
                    try {
                        game.getTurnLock().wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                if (!game.isGameRunning()) break;

                Tile extractedTile;
                synchronized (game.getBag()) {
                    extractedTile = extractValidTile(game.getBag(), tiles);
                    if (extractedTile != null) {
                        tiles.add(extractedTile);
                        System.out.println(name + " extracted tile: " + extractedTile);
                    }
                }

                if (tiles.size() >= game.getN()) {
                    if (checkSequence()) {
                        game.endGame(this);
                        break;
                    }
                }

                game.nextTurn();
                game.getTurnLock().notifyAll();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        running = false;
    }

    private Tile extractValidTile(Bag bag, List<Tile> tiles) {
        int n = game.getN();
        int lastNum;
        if (tiles.isEmpty()) {
            lastNum = 0;
        } else {
            lastNum = tiles.get(tiles.size() - 1).getSecond();
        }
        List<Tile> validTiles = new ArrayList<>();
        for (Tile tile : bag.getTiles()) {
            if ( tile.getFirst() == lastNum) {
                validTiles.add(tile);
            }
        }
        if (!validTiles.isEmpty()) {
            int index = (int) (Math.random() * validTiles.size());
            return validTiles.get(index);
        } else {
            return bag.extractTile();
        }
    }

    private boolean checkSequence() {
        if (tiles.size() != game.getN()) {
            return false;
        }
        Tile firstTile = tiles.get(0);
        Tile lastTile = tiles.get(tiles.size() - 1);
        if (firstTile.getFirst() != lastTile.getSecond()) {
            return false;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (Tile tile : tiles) {
            countMap.put(tile.getFirst(), countMap.getOrDefault(tile.getFirst(), 0) + 1);
            countMap.put(tile.getSecond(), countMap.getOrDefault(tile.getSecond(), 0) + 1);
        }
        for (int count : countMap.values()) {
            if (count != 2) {
                return false;
            }
        }
        return true;
    }

    private boolean isMyTurn() {
        return game.isMyTurn(this);
    }
}
