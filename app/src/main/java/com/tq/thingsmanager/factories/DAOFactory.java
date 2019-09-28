package com.tq.thingsmanager.factories;

import android.content.Context;

import com.tq.thingsmanager.db.SQLLiteHelper;
import com.tq.thingsmanager.db.dao.PurchaseGroupDao;
import com.tq.thingsmanager.db.dao.PurchaseGroupDaoImpl;

public class DAOFactory {
    public static PurchaseGroupDao getPurchaseGroupDao(Context context) {
        return new PurchaseGroupDaoImpl(new SQLLiteHelper(context));
    }
}
