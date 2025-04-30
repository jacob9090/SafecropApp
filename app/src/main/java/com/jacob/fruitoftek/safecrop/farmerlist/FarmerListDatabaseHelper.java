package com.jacob.fruitoftek.safecrop.farmerlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class FarmerListDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myfarmers.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "myfarmers";
    private static final String COL_FID = "fid";
    private static final String COL_NAME = "name";
    private static final String COL_SURNAME = "surname";
    private static final String COL_PHONE = "phone";
    private static final String COL_DISTRICT = "district";
    private static final String COL_VILLAGE = "village";
    private static final String COL_PHOTO = "photo";

    public FarmerListDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_FID + " TEXT, "
                + COL_NAME + " TEXT, "
                + COL_SURNAME + " TEXT, "
                + COL_PHONE + " TEXT, "
                + COL_DISTRICT + " TEXT, "
                + COL_VILLAGE + " TEXT, "
                + COL_PHOTO + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

//    public void insertFarmer(FarmerListModal farmer) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_PHONE + " = ?", new String[]{farmer.getPhone()});
//        if (cursor.getCount() > 0) {
//            Log.d("FarmerListDatabaseHelper", "Farmer already exists: " + farmer.getName());
//        } else {
//            ContentValues values = new ContentValues();
//            values.put(COL_NAME, farmer.getName());
//            values.put(COL_PHONE, farmer.getPhone());
//            values.put(COL_ADDRESS, farmer.getAddress());
//            values.put(COL_PHOTO, farmer.getPhoto());
//            long result = db.insert(TABLE_NAME, null, values);
//            if (result == -1) {
//                Log.e("FarmerListDatabaseHelper", "Failed to insert farmer: " + farmer.getName());
//            } else {
//                Log.d("FarmerListDatabaseHelper", "Inserted farmer: " + farmer.getName());
//            }
//        }
//        cursor.close();
//        db.close();
//    }

    public void insertFarmer(FarmerListModal farmer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_FID, farmer.getFid());
        values.put(COL_NAME, farmer.getName());
        values.put(COL_SURNAME, farmer.getSurname());
        values.put(COL_PHONE, farmer.getPhone());
        values.put(COL_DISTRICT, farmer.getDistrict());
        values.put(COL_VILLAGE, farmer.getVillage());
        values.put(COL_PHOTO, farmer.getPhoto());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

//    public void updateFarmer(FarmerListModal farmer) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COL_NAME, farmer.getName());
//        values.put(COL_PHONE, farmer.getPhone());
//        values.put(COL_ADDRESS, farmer.getAddress());
//        values.put(COL_PHOTO, farmer.getPhoto());
//        db.update(TABLE_NAME, values, COL_PHONE + " = ?", new String[]{farmer.getPhone()});
//        db.close();
//    }

//    public ArrayList<FarmerListModal> getAllFarmers() {
//        ArrayList<FarmerListModal> farmers = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
//        if (cursor.moveToFirst()) {
//            do {
//                farmers.add(new FarmerListModal(
//                        cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME)),
//                        cursor.getString(cursor.getColumnIndexOrThrow(COL_PHONE)),
//                        cursor.getString(cursor.getColumnIndexOrThrow(COL_ADDRESS)),
//                        cursor.getString(cursor.getColumnIndexOrThrow(COL_PHOTO))
//                ));
//            } while (cursor.moveToNext());
//        } else {
//            Log.e("FarmerListDatabaseHelper", "No farmer found in database.");
//        }
//        cursor.close();
//        db.close();
//        return farmers;
//    }

    public ArrayList<FarmerListModal> getAllFarmers() {
        ArrayList<FarmerListModal> farmers = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                farmers.add(new FarmerListModal(
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_FID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_SURNAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_PHONE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_DISTRICT)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_VILLAGE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_PHOTO))
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return farmers;
    }
}
