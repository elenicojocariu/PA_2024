package org.example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Bag {
    private List<Tile> tiles;

    public Bag(List<Tile> initialTiles) {
        this.tiles = new LinkedList<>(initialTiles);
        Collections.shuffle(this.tiles);
    }

    public synchronized boolean isEmpty() {
        return this.tiles.isEmpty();
    }

    public synchronized Tile extractTile() {
        if (!this.tiles.isEmpty()) {
            return this.tiles.remove(0);
        }
        return null;
    }
    public List<Tile> getTiles() {
        return tiles;
    }
}
