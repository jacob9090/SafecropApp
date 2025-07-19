package com.jacob.fruitoftek.safecrop.farmerlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class FarmerListDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "farmerlist.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "farmerlist";
    private static final String COL_DISTRICT = "district";
    private static final String COL_COMMUNITY = "community";
    private static final String COL_FARMER_ID = "farmer_id";
    private static final String COL_FARMER_NAME = "farmer_name";
    private static final String COL_GHANA_CARD = "ghana_card";
    private static final String COL_FARMER_YOB = "farmer_yob";
    private static final String COL_FARMER_PHONE = "farmer_phone";
    private static final String COL_FARMER_GENDER = "farmer_gender";
    private static final String COL_PHOTO = "photo";

    public FarmerListDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_DISTRICT + " TEXT, "
                + COL_COMMUNITY + " TEXT, "
                + COL_FARMER_ID + " TEXT, "
                + COL_FARMER_NAME + " TEXT, "
                + COL_GHANA_CARD + " TEXT, "
                + COL_FARMER_YOB + " TEXT, "
                + COL_FARMER_PHONE + " TEXT, "
                + COL_FARMER_GENDER + " TEXT, "
                + COL_PHOTO + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertFarmer(FarmerListModal farmer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_DISTRICT, farmer.getDistrict());
        values.put(COL_COMMUNITY, farmer.getCommunity());
        values.put(COL_FARMER_ID, farmer.getFarmer_id());
        values.put(COL_FARMER_NAME, farmer.getFarmer_name());
        values.put(COL_GHANA_CARD, farmer.getGhana_card());
        values.put(COL_FARMER_YOB, farmer.getFarmer_yob());
        values.put(COL_FARMER_PHONE, farmer.getFarmer_phone());
        values.put(COL_FARMER_GENDER, farmer.getFarmer_gender());
        values.put(COL_PHOTO, farmer.getPhoto());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<FarmerListModal> getAllFarmers() {
        ArrayList<FarmerListModal> farmers = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                farmers.add(new FarmerListModal(
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_DISTRICT)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_COMMUNITY)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_FARMER_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_FARMER_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_GHANA_CARD)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_FARMER_YOB)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_FARMER_PHONE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_FARMER_GENDER)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_PHOTO))
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return farmers;
    }
}
