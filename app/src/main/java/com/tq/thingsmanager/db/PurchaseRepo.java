package com.tq.thingsmanager.db;

import com.tq.thingsmanager.config.InitData;
import com.tq.thingsmanager.db.dao.PurchaseGroupDao;
import com.tq.thingsmanager.db.model.PurchaseGroup;
import com.tq.thingsmanager.view.model.tile.TileContent;

import java.util.ArrayList;
import java.util.List;

public class PurchaseRepo {

    private PurchaseGroupDao purchaseGroupDao;

    public PurchaseRepo(PurchaseGroupDao purchaseGroupDao) {

        this.purchaseGroupDao = purchaseGroupDao;
    }

    public List<TileContent> loadTiles() {
        List<PurchaseGroup> groups = loadAllPurchaseGroup();
        List<TileContent> result = new ArrayList<>();

        for (PurchaseGroup purchaseGroup : groups) {
            result.add(new TileContent(purchaseGroup.getId(), purchaseGroup.getName()));
        }
        return result;
    }

    private List<PurchaseGroup> loadAllPurchaseGroup() {
        List<PurchaseGroup> groups = purchaseGroupDao.loadAllPurchaseGroup();
        if (groups.isEmpty()) {
            insertPurchaseGroup(InitData.initPurchesGroup());
        }
        groups = purchaseGroupDao.loadAllPurchaseGroup();
        return groups;
    }

    private void insertPurchaseGroup(List<PurchaseGroup> purchaseGroups) {
        for (PurchaseGroup purchaseGroup : purchaseGroups) {
            purchaseGroupDao.insertPurchaseGroup(purchaseGroup);
        }
    }

    public List<PurchaseGroup> loadPurchaseCategoryForGroup(long groupID) {
        return null;
    }

}
