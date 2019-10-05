package com.tq.thingsmanager.view;

import com.tq.thingsmanager.view.model.tile.CategoryGroupViewModel;

import java.util.List;

public class TileManager {

    private List<CategoryGroupViewModel> tiles;

    public TileManager(List<CategoryGroupViewModel> tiles) {
        this.tiles = tiles;
    }


    public int size() {
        return tiles.size();
    }

    public String getText(int i) {
        return tiles.get(i).getText();
    }

    public Long getId(int i) {
        return tiles.get(i).getPurchaseGroupId() ;
    }
}
