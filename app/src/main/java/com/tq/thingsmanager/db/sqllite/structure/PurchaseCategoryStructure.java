package com.tq.thingsmanager.db.sqllite.structure;

import android.provider.BaseColumns;

public final class PurchaseCategoryStructure {

    private PurchaseCategoryStructure() {
    }

    public static class db implements BaseColumns {
        public static final String TABLE_NAME = "purchase_category";
        public static final String COLUMN_NAME_GROUP_ID = "purchase_group_id";
        public static final String COLUMN_NAME_NAME = "name";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + db.TABLE_NAME + " (" +
                    db._ID + " INTEGER PRIMARY KEY," +
                    db.COLUMN_NAME_NAME + " TEXT," +
                    db.COLUMN_NAME_GROUP_ID + "  INTEGER " +
                    ")";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + db.TABLE_NAME;
}
