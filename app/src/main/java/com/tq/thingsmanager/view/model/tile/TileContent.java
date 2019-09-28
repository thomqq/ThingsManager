package com.tq.thingsmanager.view.model.tile;

public class TileContent {
    private long purchaseGroupId;
    private String text;

    public TileContent(long purchaseGroupId, String text) {
        this.purchaseGroupId = purchaseGroupId;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public long getPurchaseGroupId() {
        return purchaseGroupId;
    }
}
