package com.tq.thingsmanager.db.model;

public class PurchaseGroup {
    private long id;
    private String name;
    private String tag;
    private String tilePath;

    public PurchaseGroup(long id, String name, String tag, String tilePath) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.tilePath = tilePath;
    }

    public PurchaseGroup(String name, String tag, String tilePath) {
        this.id = -1;
        this.name = name;
        this.tag = tag;
        this.tilePath = tilePath;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public String getTilePath() {
        return tilePath;
    }

    public void setId(long id) {
        this.id = id;
    }
}
