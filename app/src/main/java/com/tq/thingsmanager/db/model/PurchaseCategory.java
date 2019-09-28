package com.tq.thingsmanager.db.model;

public class PurchaseCategory {
    private long id;
    private long parchaseGroupId;
    private String name;

    public PurchaseCategory(long id, long parchaseGroupId, String name) {
        this.id = id;
        this.parchaseGroupId = parchaseGroupId;
        this.name = name;
    }

    public PurchaseCategory(long parchaseGroupId, String name) {
        this.id = -1;
        this.parchaseGroupId = parchaseGroupId;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public long getParchaseGroupId() {
        return parchaseGroupId;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }
}
