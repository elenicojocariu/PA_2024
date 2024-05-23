package org.example;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private static final int BOARD_SIZE = 10;
    private static final int inital_Time = 300;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean isGameStarted;
    private Map<String, Player> players;

    public Game() {
        this.players = new HashMap<>();
        this.isGameStarted = false;
    }

    public boolean addPlayer(String playerName){
        if(players.size() >= 2){
            return false;
        }
        Player player = new Player(playerName, BOARD_SIZE, inital_Time);
        players.put(playerName, player);
        if(players.size() == 1){
            player1 = player;
        }
        else{
            player2=player;
        }
        return true;
    }

    public boolean startGame() {
        if (players.size() == 2) {
            isGameStarted = true;
            currentPlayer = player1;
            return true;
        }
        return false;
    }
    public synchronized boolean submitMove(String playerName, int x, int y) {
        if (!isGameStarted || !currentPlayer.getName().equals(playerName)) {
            return false;
        }
        Player opponent = (currentPlayer == player1) ? player2 : player1;
        boolean hit = opponent.getBoard().registerHit(x, y);
        currentPlayer = opponent; // Switch turns
        return hit;
    }
    public boolean isPlayerTimeOut(Player player) {
        return player.getRemainingTime() <= 0;
    }
    public boolean isGameOver() {
        return player1.isAllShipsSunk() || player2.isAllShipsSunk() || isPlayerTimeOut(player1) || isPlayerTimeOut(player2);
    }
    public String getWinner() {
        if (player1.isAllShipsSunk() || isPlayerTimeOut(player1)) {
            return player2.getName();
        }
        if (player2.isAllShipsSunk() || isPlayerTimeOut(player2)) {
            return player1.getName();
        }
        return null;
    }
}
