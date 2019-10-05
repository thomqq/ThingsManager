package com.tq.thingsmanager.factories;

import android.content.Context;

import com.tq.thingsmanager.db.PurchaseRepo;
import com.tq.thingsmanager.db.sqllite.SQLLiteHelper;
import com.tq.thingsmanager.db.sqllite.PurchaseDaoSQLLite;

public class DAOFactory {
    private static PurchaseRepo purchaseRepo;
    public static PurchaseRepo getPurchaseRepo(Context context) {
        if( purchaseRepo == null ) {
            purchaseRepo = new PurchaseRepo(new PurchaseDaoSQLLite(new SQLLiteHelper(context)));
        }
        return purchaseRepo;
    }
}
