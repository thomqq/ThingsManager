package com.tq.thingsmanager.config;

import com.tq.thingsmanager.db.model.PurchaseGroup;

import java.util.ArrayList;
import java.util.List;

public class InitData {
    public static List<PurchaseGroup> initPurchesGroup() {
        List< PurchaseGroup > items = new ArrayList<>();
        items.add(new PurchaseGroup("11", "11", "11"));
        items.add(new PurchaseGroup("12", "12", "12"));
        items.add(new PurchaseGroup("13", "13", "13"));
        items.add(new PurchaseGroup("14", "14", "14"));
        items.add(new PurchaseGroup("15", "15", "15"));
        items.add(new PurchaseGroup("16", "16", "16"));
        items.add(new PurchaseGroup("17", "17", "17"));
        return items;
    }
}
