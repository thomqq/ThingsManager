package com.tq.thingsmanager.view;

import com.tq.thingsmanager.view.model.tile.TileContent;

import java.util.List;

public class TileManager {

    private List<TileContent> tiles;

    public TileManager(List<TileContent> tiles) {
        this.tiles = tiles;
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
