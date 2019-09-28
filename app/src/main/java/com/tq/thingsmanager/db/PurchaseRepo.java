package com.tq.thingsmanager.db;

import com.tq.thingsmanager.config.InitData;
import com.tq.thingsmanager.db.dao.PurchaseGroupDao;
import com.tq.thingsmanager.db.model.PurchaseGroup;

import java.util.List;

public class PurchaseRepo {

    private PurchaseGroupDao purchaseGroupDao;

    public PurchaseRepo(PurchaseGroupDao purchaseGroupDao) {

        this.purchaseGroupDao = purchaseGroupDao;
    }

    public List<PurchaseGroup> loadPurchaseCategoryForGroup(long groupID) {
        return null;
    }

    public List<PurchaseGroup> loadAllPurchaseGroup() {
        List<PurchaseGroup> groups = purchaseGroupDao.loadAllPurchaseGroup();
        if( groups == null ) {
            insertPurchaseGroup(InitData.initPurchesGroup());
        }
        groups = purchaseGroupDao.loadAllPurchaseGroup();
        return groups;
    }

    public void insertPurchaseGroup(List<PurchaseGroup> purchaseGroups) {
        for( PurchaseGroup purchaseGroup : purchaseGroups ) {
            purchaseGroupDao.insertPurchaseGroup(purchaseGroup);
        }
    }
}
