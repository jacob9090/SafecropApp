package com.jacob.fruitoftek.safecrop.sustain.pentry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class PeDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PEnteyDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "PEntryTbl";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_PEQUESTION1 = "pequestion1";
    private static final String COLUMN_PEQUESTION2 = "pequestion2";
    private static final String COLUMN_PEQUESTION3 = "pequestion3";
    private static final String COLUMN_PEQUESTION4 = "pequestion4";
    private static final String COLUMN_PEQUESTION5 = "pequestion5";
    private static final String COLUMN_PEQUESTION6 = "pequestion6";
    private static final String COLUMN_PEQUESTION7 = "pequestion7";
    private static final String COLUMN_PEQUESTION8 = "pequestion8";
    private static final String COLUMN_PEQUESTION9 = "pequestion9";
    private static final String COLUMN_PEQUESTION10 = "pequestion10";
    private static final String COLUMN_PEQUESTION11 = "pequestion11";
    private static final String COLUMN_PEQUESTION12 = "pequestion12";
    private static final String COLUMN_PEQUESTION13 = "pequestion13";
    private static final String COLUMN_PEQUESTION14 = "pequestion14";
    private static final String COLUMN_FARMER_PHOTO = "farmer_photo";
    private static final String COLUMN_USER_FNAME = "user_fname";
    private static final String COLUMN_USER_LNAME = "user_lname";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_ON_CREATE = "on_create";
    private static final String COLUMN_ON_UPDATE = "on_update";

    private Context context;

    public PeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_PEQUESTION1 + " TEXT,"
                + COLUMN_PEQUESTION2 + " TEXT,"
                + COLUMN_PEQUESTION3 + " TEXT,"
                + COLUMN_PEQUESTION4 + " TEXT,"
                + COLUMN_PEQUESTION5 + " TEXT,"
                + COLUMN_PEQUESTION6 + " TEXT,"
                + COLUMN_PEQUESTION7 + " TEXT,"
                + COLUMN_PEQUESTION8 + " TEXT,"
                + COLUMN_PEQUESTION9 + " TEXT,"
                + COLUMN_PEQUESTION10 + " TEXT,"
                + COLUMN_PEQUESTION11 + " TEXT,"
                + COLUMN_PEQUESTION12 + " TEXT,"
                + COLUMN_PEQUESTION13 + " TEXT,"
                + COLUMN_PEQUESTION14 + " TEXT,"
                + COLUMN_FARMER_PHOTO + " TEXT,"
                + COLUMN_USER_FNAME + " TEXT,"
                + COLUMN_USER_LNAME + " TEXT,"
                + COLUMN_USER_EMAIL + " TEXT,"
                + COLUMN_ON_CREATE + " TEXT,"
                + COLUMN_ON_UPDATE + " TEXT"
                + ");";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertPE(String pequestion1, String pequestion2, String pequestion3, String pequestion4,
                            String pequestion5, String pequestion6, String pequestion7, String pequestion8,
                            String pequestion9, String pequestion10, String pequestion11, String pequestion12,
                            String pequestion13, String pequestion14, String farmer_photo, String userFname,
                            String userLname, String userEmail, String onCreate, String onUpdate) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PEQUESTION1, pequestion1);
        values.put(COLUMN_PEQUESTION2, pequestion2);
        values.put(COLUMN_PEQUESTION3, pequestion3);
        values.put(COLUMN_PEQUESTION4, pequestion4);
        values.put(COLUMN_PEQUESTION5, pequestion5);
        values.put(COLUMN_PEQUESTION6, pequestion6);
        values.put(COLUMN_PEQUESTION7, pequestion7);
        values.put(COLUMN_PEQUESTION8, pequestion8);
        values.put(COLUMN_PEQUESTION9, pequestion9);
        values.put(COLUMN_PEQUESTION10, pequestion10);
        values.put(COLUMN_PEQUESTION11, pequestion11);
        values.put(COLUMN_PEQUESTION12, pequestion12);
        values.put(COLUMN_PEQUESTION13, pequestion13);
        values.put(COLUMN_PEQUESTION14, pequestion14);
        values.put(COLUMN_FARMER_PHOTO, farmer_photo);
        values.put(COLUMN_USER_FNAME, userFname);
        values.put(COLUMN_USER_LNAME, userLname);
        values.put(COLUMN_USER_EMAIL, userEmail);
        values.put(COLUMN_ON_CREATE, onCreate);
        values.put(COLUMN_ON_UPDATE, onUpdate);

        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    public boolean updatePE(String id, String pequestion1, String pequestion2, String pequestion3, 
                            String pequestion4, String pequestion5, String pequestion6, String pequestion7, 
                            String pequestion8, String pequestion9, String pequestion10, String pequestion11, 
                            String pequestion12, String pequestion13
                            ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PEQUESTION1, pequestion1);
        values.put(COLUMN_PEQUESTION2, pequestion2);
        values.put(COLUMN_PEQUESTION3, pequestion3);
        values.put(COLUMN_PEQUESTION4, pequestion4);
        values.put(COLUMN_PEQUESTION5, pequestion5);
        values.put(COLUMN_PEQUESTION6, pequestion6);
        values.put(COLUMN_PEQUESTION7, pequestion7);
        values.put(COLUMN_PEQUESTION8, pequestion8);
        values.put(COLUMN_PEQUESTION9, pequestion9);
        values.put(COLUMN_PEQUESTION10, pequestion10);
        values.put(COLUMN_PEQUESTION11, pequestion11);
        values.put(COLUMN_PEQUESTION12, pequestion12);
        values.put(COLUMN_PEQUESTION13, pequestion13);
        
        values.put(COLUMN_ON_UPDATE, System.currentTimeMillis());

        int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{id});
        db.close();

        return rowsUpdated > 0;
    }

    public Cursor getPESurveyData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public List<PeModel> getAllPE() {
        List<PeModel> surveyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String pequestion1 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion1"));
                String pequestion2 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion2"));
                String pequestion3 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion3"));
                String pequestion4 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion4"));
                String pequestion5 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion5"));
                String pequestion6 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion6"));
                String pequestion7 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion7"));
                String pequestion8 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion8"));
                String pequestion9 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion9"));
                String pequestion10 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion10"));
                String pequestion11 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion11"));
                String pequestion12 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion12"));
                String pequestion13 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion13"));
                String pequestion14 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion14"));
                String farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo"));
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                PeModel model = new PeModel(
                        id, pequestion1, pequestion2, pequestion3, pequestion4, pequestion5, pequestion6,
                        pequestion7, pequestion8, pequestion9, pequestion10, pequestion11, pequestion12,
                        pequestion13, pequestion14, farmer_photo != null ? Uri.parse(farmer_photo) : null, userFname,
                        userLname, userEmail, onCreate, onUpdate
                );

                surveyList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return surveyList;
    }

    public PeModel getSurveyDetailsByPEName(String orgquestion7) {
        SQLiteDatabase db = this.getReadableDatabase();
        PeModel orgproModel = null;

        Cursor cursor = db.query(
                "OrganicSurveyTbl",
                null,
                "orgquestion7 = ?",
                new String[]{orgquestion7},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String pequestion1 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion1"));
            String pequestion2 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion2"));
            String pequestion3 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion3"));
            String pequestion4 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion4"));
            String pequestion5 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion5"));
            String pequestion6 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion6"));
            String pequestion7 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion7"));
            String pequestion8 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion8"));
            String pequestion9 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion9"));
            String pequestion10 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion10"));
            String pequestion11 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion11"));
            String pequestion12 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion12"));
            String pequestion13 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion13"));
            String pequestion14 = cursor.getString(cursor.getColumnIndexOrThrow("pequestion14"));
            Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                    ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                    : null;
            String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
            String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
            String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
            String on_create = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
            String on_update = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

            orgproModel = new PeModel(id, pequestion1, pequestion2, pequestion3, pequestion4, pequestion5,
                    pequestion6, pequestion7, pequestion8, pequestion9, pequestion10, pequestion11, pequestion12,
                    pequestion13, pequestion14, farmer_photo, userFname, userLname, userEmail, on_create, on_update);
            cursor.close();
        }
        return orgproModel;
    }
}
