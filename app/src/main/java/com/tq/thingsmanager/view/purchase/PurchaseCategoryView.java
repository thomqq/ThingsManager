package com.tq.thingsmanager.view.purchase;

class PurchaseCategoryView {
    private long purchaseCategoryId;
    private String name;

    public PurchaseCategoryView(long purchaseCategoryId, String name) {
        this.purchaseCategoryId = purchaseCategoryId;
        this.name = name;
    }

    public long getPurchaseCategoryId() {
        return purchaseCategoryId;
    }

    public String getName() {
        return name;
    }
}
