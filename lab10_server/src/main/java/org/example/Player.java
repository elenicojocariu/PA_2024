package org.example;



public class Player {

    private String name;
    private Board board;
    private int remainingTime;

    public Player(String name, int boardSize, int initialTime) {
        this.name = name;
        this.board = new Board(boardSize);
        this.remainingTime = initialTime;
    }
    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }
    public int getRemainingTime() {
        return remainingTime;
    }
    public void decrementTime(int seconds) {
        remainingTime -= seconds;
    }

    public boolean isAllShipsSunk() {
        return board.areAllShipsSunk();
    }

}
