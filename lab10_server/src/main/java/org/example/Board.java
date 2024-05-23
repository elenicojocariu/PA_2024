package org.example;

public class Board {
    private char[][] grid;
    private int size;
    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        initializeBoard();
    }
    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '~'; // Water
            }
        }
    }
    public boolean placeShip(int x, int y, int length, boolean horizontal) {
        // Implementation to place ship
        return true;
    }
    public boolean registerHit(int x, int y) {
        if (grid[x][y] == '~') {
            grid[x][y] = 'M'; // Miss
            return false;
        } else if (grid[x][y] == 'S') {
            grid[x][y] = 'H'; // Hit
            return true;
        }
        return false;
    }
    public boolean areAllShipsSunk() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 'S') {
                    return false;
                }
            }
        }
        return true;
    }


}
