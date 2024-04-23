package org.example;

public class Tile {
    private final int first;
    private final int second;

    public Tile(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}

