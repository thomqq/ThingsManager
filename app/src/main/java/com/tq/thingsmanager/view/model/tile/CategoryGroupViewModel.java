package com.tq.thingsmanager.view.model.tile;

import com.tq.thingsmanager.db.model.PurchaseCategory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryGroupViewModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long purchaseGroupId;
    private String text;
    private List<CategoryViewModel> purchaseCategoryList = new ArrayList<>();

    public CategoryGroupViewModel() {
    }

    public CategoryGroupViewModel(long purchaseGroupId, String text) {
        this.purchaseGroupId = purchaseGroupId;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Long getPurchaseGroupId() {
        return purchaseGroupId;
    }

    public void addCategories(CategoryViewModel categoryGroupViewModel) {
        purchaseCategoryList.add(categoryGroupViewModel);
    }

    public void setPurchaseGroupId(Long purchaseGroupId) {
        this.purchaseGroupId = purchaseGroupId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<CategoryViewModel> getPurchaseCategoryList() {
        return purchaseCategoryList;
    }

    public void setPurchaseCategoryList(List<CategoryViewModel> purchaseCategoryList) {
        this.purchaseCategoryList = purchaseCategoryList;
    }
}
