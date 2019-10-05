package com.tq.thingsmanager.db.dao;

import com.tq.thingsmanager.db.model.PurchaseCategory;
import com.tq.thingsmanager.db.model.PurchaseGroup;

import java.util.List;

public interface PurchaseDao {
    List<PurchaseGroup> loadAllPurchaseGroup();
    long insertPurchaseGroup(PurchaseGroup purchaseGroup);
    long insertPurchaseCategory(PurchaseCategory category);

    List<PurchaseCategory> loadAllPurchaseCategoriesForGroup(Long purchaseGroupId);
}
