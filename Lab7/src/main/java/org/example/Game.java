package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private Bag bag;
    private List<Player> players;
    private boolean gameRunning;
    private Player winner;
    private final int n;
    private final long timeLimitMillis;
    private final long startTime;
    private final Object turnLock = new Object();
    private volatile int currentPlayerIndex = 0;

    public Game(int n, long timeLimitMillis) {
        this.n = n;
        this.timeLimitMillis = timeLimitMillis;
        this.bag = new Bag(createInitialTiles(n));
        this.players = new ArrayList<>();
        this.gameRunning = true;
        this.startTime = System.currentTimeMillis();
    }

    private List<Tile> createInitialTiles(int n) {
        List<Tile> tiles = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    tiles.add(new Tile(i, j));
                }
            }
        }
        Collections.shuffle(tiles);
        return tiles;
    }


    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void play() {
        for (int i = 0; i < players.size(); i++) {
            new Thread(players.get(i)).start();
        }
        new Thread(new TimeKeeper()).start();
    }

    public void endGame(Player winner) {
        synchronized (turnLock) {
            gameRunning = false;
            this.winner = winner;
            turnLock.notifyAll();
        }
        if (winner != null) {
            System.out.println("Game ended. Winner: " + winner.getName());
        } else {
            System.out.println("Game ended. No winner");
        }
    }

    public Bag getBag() {
        return bag;
    }

    public int getN() {
        return n;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

    public long getTimeLimitMillis() {
        return timeLimitMillis;
    }

    public Object getTurnLock() {
        return turnLock;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isMyTurn(Player player) {
        return players.get(currentPlayerIndex) == player;
    }

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    class TimeKeeper implements Runnable {
        @Override
        public void run() {
            while (isGameRunning()) {
                long elapsedTime = getElapsedTime();
                System.out.println("Elapsed Time: " + elapsedTime + " milliseconds");
                if (elapsedTime >= getTimeLimitMillis()) {
                    endGame(null);
                    System.out.println("Time finished!");
                    return;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}