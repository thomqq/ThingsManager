package com.tq.thingsmanager.db.dao;

import com.tq.thingsmanager.db.model.PurchaseGroup;

import java.util.List;

public interface PurchaseGroupDao {
    List<PurchaseGroup> loadAllPurchaseGroup();

    long insertPurchaseGroup(PurchaseGroup purchaseGroup);
}
