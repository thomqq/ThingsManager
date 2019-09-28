package com.tq.thingsmanager.db.sqllite.structure;

import android.provider.BaseColumns;

public final class PurchaseGroupStructure {

    private PurchaseGroupStructure() {
    }

    public static class db implements BaseColumns {
        public static final String TABLE_NAME = "purchase_group";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_TAG = "tag";
        public static final String COLUMN_NAME_TILES_PATH = "tiles_path";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + db.TABLE_NAME + " (" +
                    db._ID + " INTEGER PRIMARY KEY," +
                    db.COLUMN_NAME_NAME + " TEXT," +
                    db.COLUMN_NAME_TAG + "  TEXT," +
                    db.COLUMN_NAME_TILES_PATH + " TEXT" +
                    ")";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + db.TABLE_NAME;
}
