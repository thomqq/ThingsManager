package com.tq.thingsmanager.tile;

import java.util.ArrayList;
import java.util.List;

public class TileManager {

    private List<TileContent> tiles;

    public TileManager() {
        tiles = new ArrayList<>();
        for( int i = 8 ; i > 0 ; i --) {
            tiles.add(new TileContent("" + i));
        }

    }

    public int size() {
        return tiles.size();
    }

    public String getText(int i) {
        return tiles.get(i).getText();
    }

    public String getId(int i) {
        return tiles.get(i).getText();
    }
}
