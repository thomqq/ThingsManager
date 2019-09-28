package com.tq.thingsmanager.db.sqllite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.tq.thingsmanager.db.dao.PurchaseGroupDao;
import com.tq.thingsmanager.db.model.PurchaseGroup;
import com.tq.thingsmanager.db.sqllite.structure.PurchaseGroupStructure;

import java.util.ArrayList;
import java.util.List;

public class PurchaseGroupDaoSQLLite implements PurchaseGroupDao {

    private SQLLiteHelper dbHelper;

    public PurchaseGroupDaoSQLLite(SQLLiteHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public List<PurchaseGroup> loadAllPurchaseGroup() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                BaseColumns._ID,
                PurchaseGroupStructure.db.COLUMN_NAME_NAME,
                PurchaseGroupStructure.db.COLUMN_NAME_TAG,
                PurchaseGroupStructure.db.COLUMN_NAME_TILES_PATH
        };

        Cursor cursor = db.query(
                PurchaseGroupStructure.db.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        List< PurchaseGroup > items = new ArrayList<>();
        while ( cursor.moveToNext() ) {
            long id = cursor.getLong(cursor.getColumnIndexOrThrow(PurchaseGroupStructure.db._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(PurchaseGroupStructure.db.COLUMN_NAME_NAME));
            String tilePath = cursor.getString(cursor.getColumnIndexOrThrow(PurchaseGroupStructure.db.COLUMN_NAME_TILES_PATH));
            String tag = cursor.getString(cursor.getColumnIndexOrThrow(PurchaseGroupStructure.db.COLUMN_NAME_TAG));
            PurchaseGroup purchaseGroup = new PurchaseGroup(id, name, tag, tilePath);

            items.add(purchaseGroup);
        }

        dbHelper.close();
        return items;
    }


    @Override
    public long insertPurchaseGroup(PurchaseGroup purchaseGroup) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PurchaseGroupStructure.db.COLUMN_NAME_NAME, purchaseGroup.getName());
        values.put(PurchaseGroupStructure.db.COLUMN_NAME_TAG, purchaseGroup.getTag());
        values.put(PurchaseGroupStructure.db.COLUMN_NAME_TILES_PATH, purchaseGroup.getTilePath());

        long newId = db.insert(PurchaseGroupStructure.db.TABLE_NAME, null, values);
        purchaseGroup.setId(newId);

        return newId;
    }

}
