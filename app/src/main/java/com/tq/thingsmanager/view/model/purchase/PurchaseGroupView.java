package com.tq.thingsmanager.view.model.purchase;

import java.util.List;

class PurchaseGroupView {
    private long purchaseGroupId;
    private String name;
    private List<PurchaseCategoryView> categories;

    public PurchaseGroupView() {
    }

    public PurchaseGroupView(long purchaseCategoryId, String name) {
        this.purchaseGroupId = purchaseCategoryId;
        this.name = name;
    }

    public long getPurchaseGroupId() {
        return purchaseGroupId;
    }

    public String getName() {
        return name;
    }

    public List<PurchaseCategoryView> getCategories() {
        return categories;
    }

    public void setCategories(List<PurchaseCategoryView> categories) {
        this.categories = categories;
    }

    public void setPurchaseGroupId(long purchaseGroupId) {
        this.purchaseGroupId = purchaseGroupId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
