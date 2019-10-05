package com.tq.thingsmanager.db;

import com.tq.thingsmanager.config.InitData;
import com.tq.thingsmanager.db.dao.PurchaseDao;
import com.tq.thingsmanager.db.model.PurchaseCategory;
import com.tq.thingsmanager.db.model.PurchaseGroup;
import com.tq.thingsmanager.view.model.tile.CategoryGroupViewModel;
import com.tq.thingsmanager.view.model.tile.CategoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class PurchaseRepo {

    private PurchaseDao purchaseGroupDao;

    public PurchaseRepo(PurchaseDao purchaseGroupDao) {

        this.purchaseGroupDao = purchaseGroupDao;
    }

    public List<CategoryGroupViewModel> loadTiles() {
        List<PurchaseGroup> groups = loadAllPurchaseGroup();
        List<CategoryGroupViewModel> result = new ArrayList<>();

        for (PurchaseGroup purchaseGroup : groups) {
            CategoryGroupViewModel categoryGroupViewModel = new CategoryGroupViewModel(purchaseGroup.getId(), purchaseGroup.getName());
            List< PurchaseCategory> purchaseCategories = loadAllPurchasCategoriesForGroup(categoryGroupViewModel.getPurchaseGroupId());
            for( PurchaseCategory purchaseCategory : purchaseCategories ) {
                categoryGroupViewModel.addCategories( new CategoryViewModel(purchaseCategory.getParchaseGroupId(), purchaseCategory.getName()));
            }
            result.add(categoryGroupViewModel);
        }
        return result;
    }

    private List<PurchaseCategory> loadAllPurchasCategoriesForGroup(Long purchaseGroupId) {
        List<PurchaseCategory> calegories =  purchaseGroupDao.loadAllPurchaseCategoriesForGroup(purchaseGroupId);
        return calegories;
    }

    private List<PurchaseGroup> loadAllPurchaseGroup() {
        List<PurchaseGroup> groups = purchaseGroupDao.loadAllPurchaseGroup();
        return groups;
    }



    private List<Long> insertPurchaseGroup(List<PurchaseGroup> purchaseGroups) {
        List<Long> groupsId = new ArrayList<>();
        for (PurchaseGroup purchaseGroup : purchaseGroups) {
            long groupId = purchaseGroupDao.insertPurchaseGroup(purchaseGroup);
            groupsId.add(groupId);
        }
        return groupsId;
    }

    private List<PurchaseGroup> loadPurchaseCategoryForGroup(long groupID) {
        return null;
    }

    public void initData() {
        insertPurchaseGroup(InitData.initPurchesGroup());
        List<PurchaseGroup> groups = loadAllPurchaseGroup();
        List<PurchaseCategory> purchaseCategories = InitData.initPurchaseCategory(groups);
        for (PurchaseCategory category : purchaseCategories) {
            insertPurchaseCategory(category);
        }
    }

    private void insertPurchaseCategory(PurchaseCategory category) {
        purchaseGroupDao.insertPurchaseCategory(category);
    }
}


