package com.tq.thingsmanager.config;

import com.tq.thingsmanager.db.model.PurchaseCategory;
import com.tq.thingsmanager.db.model.PurchaseGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;


public class InitData {

    public static final LinkedHashMap<String, String[]> data = new LinkedHashMap<String, String[]>() {{
        put("11", new String[]{"11-1", "11-2"});
        put("22", new String[]{"22-1", "22-2"});
        put("33", new String[]{"33-1", "33-2"});
        put("44", new String[]{"44-1", "44-2"});
        put("55", new String[]{"55-1", "55-2"});
        put("66", new String[]{"66-1", "66-2"});
        put("77", new String[]{"77-1", "77-2"});
    }};

    public static List<PurchaseGroup> initPurchesGroup() {
        String[] groupName = data.keySet().toArray( new String[] {} );
        List<PurchaseGroup> items = new ArrayList<>();
        items.add(new PurchaseGroup(groupName[0], "11", "11"));
        items.add(new PurchaseGroup(groupName[1], "12", "12"));
        items.add(new PurchaseGroup(groupName[2], "13", "13"));
        items.add(new PurchaseGroup(groupName[3], "14", "14"));
        items.add(new PurchaseGroup(groupName[4], "15", "15"));
        items.add(new PurchaseGroup(groupName[5], "16", "16"));
        items.add(new PurchaseGroup(groupName[6], "17", "17"));
        return items;
    }

    public static List<PurchaseCategory> initPurchaseCategory(List<PurchaseGroup> purchaseGroups) {
        List<PurchaseCategory> items = new ArrayList<>();
        for (PurchaseGroup group : purchaseGroups) {
            String[] categories = data.get(group.getName());
            for (String category : categories) {
                items.add(new PurchaseCategory(group.getId(), category));
            }
        }
        return items;
    }
}
