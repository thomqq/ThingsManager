package com.tq.thingsmanager.db.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.tq.thingsmanager.db.sqllite.structure.PurchaseCategoryStructure;
import com.tq.thingsmanager.db.sqllite.structure.PurchaseGroupStructure;

public class SQLLiteHelper extends SQLiteOpenHelper  {

    public static final int DATABASE_VERSION = 9;
    public static final String DATABASE_NAME = "Purchases.db";


    public SQLLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PurchaseGroupStructure.SQL_CREATE_ENTRIES);
        db.execSQL(PurchaseCategoryStructure.SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PurchaseGroupStructure.SQL_DELETE_ENTRIES);
        db.execSQL(PurchaseCategoryStructure.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
