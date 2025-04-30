package com.jacob.fruitoftek.safecrop.comdev.hh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HhDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "HouseholdSurveyDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "HouseholdSurveyTbl";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_HH_NAME = "hh_name";
    private static final String COLUMN_HH_DISTRICT = "hh_district";
    private static final String COLUMN_HH_COMMUNITY = "hh_community";
    private static final String COLUMN_HHQUESTION4 = "hhquestion4";
    private static final String COLUMN_HHQUESTION5 = "hhquestion5";
    private static final String COLUMN_HHQUESTION6 = "hhquestion6";
    private static final String COLUMN_HHQUESTION7 = "hhquestion7";
    private static final String COLUMN_HHQUESTION8 = "hhquestion8";
    private static final String COLUMN_HHQUESTION9 = "hhquestion9";
    private static final String COLUMN_HHQUESTION10 = "hhquestion10";
    private static final String COLUMN_HHQUESTION11 = "hhquestion11";
    private static final String COLUMN_HHQUESTION12 = "hhquestion12";
    private static final String COLUMN_HHQUESTION13 = "hhquestion13";
    private static final String COLUMN_HHQUESTION14 = "hhquestion14";
    private static final String COLUMN_HHQUESTION15 = "hhquestion15";
    private static final String COLUMN_HHQUESTION16 = "hhquestion16";
    private static final String COLUMN_HHQUESTION17 = "hhquestion17";
    private static final String COLUMN_HHQUESTION18 = "hhquestion18";
    private static final String COLUMN_HHQUESTION19 = "hhquestion19";
    private static final String COLUMN_HHQUESTION20 = "hhquestion20";
    private static final String COLUMN_HHQUESTION21 = "hhquestion21";
    private static final String COLUMN_HHQUESTION22 = "hhquestion22";
    private static final String COLUMN_HHQUESTION23 = "hhquestion23";
    private static final String COLUMN_HHQUESTION24 = "hhquestion24";
    private static final String COLUMN_HHQUESTION25 = "hhquestion25";
    private static final String COLUMN_HHQUESTION26 = "hhquestion26";
    private static final String COLUMN_HHQUESTION27 = "hhquestion27";
    private static final String COLUMN_HHQUESTION28 = "hhquestion28";
    private static final String COLUMN_HHQUESTION29 = "hhquestion29";
    private static final String COLUMN_HHQUESTION30 = "hhquestion30";
    private static final String COLUMN_HHQUESTION31 = "hhquestion31";
    private static final String COLUMN_HHQUESTION32 = "hhquestion32";
    private static final String COLUMN_HHQUESTION36 = "hhquestion36";
    private static final String COLUMN_HHQUESTION37 = "hhquestion37";
    private static final String COLUMN_HH_LOCATION = "hh_location";
    private static final String COLUMN_FARMER_PHOTO = "farmer_photo";
    private static final String COLUMN_SIGNATURE = "signature";
    private static final String COLUMN_USER_FNAME = "user_fname";
    private static final String COLUMN_USER_ONAME = "user_oname";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_ON_CREATE = "on_create";
    private static final String COLUMN_ON_UPDATE = "on_update";

    private Context context;

    public HhDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_HH_NAME + " TEXT,"
                + COLUMN_HH_DISTRICT + " TEXT,"
                + COLUMN_HH_COMMUNITY + " TEXT,"
                + COLUMN_HHQUESTION4 + " TEXT,"
                + COLUMN_HHQUESTION5 + " TEXT,"
                + COLUMN_HHQUESTION6 + " TEXT,"
                + COLUMN_HHQUESTION7 + " TEXT,"
                + COLUMN_HHQUESTION8 + " TEXT,"
                + COLUMN_HHQUESTION9 + " TEXT,"
                + COLUMN_HHQUESTION10 + " TEXT,"
                + COLUMN_HHQUESTION11 + " TEXT,"
                + COLUMN_HHQUESTION12 + " TEXT,"
                + COLUMN_HHQUESTION13 + " TEXT,"
                + COLUMN_HHQUESTION14 + " TEXT,"
                + COLUMN_HHQUESTION15 + " TEXT,"
                + COLUMN_HHQUESTION16 + " TEXT,"
                + COLUMN_HHQUESTION17 + " TEXT,"
                + COLUMN_HHQUESTION18 + " TEXT,"
                + COLUMN_HHQUESTION19 + " TEXT,"
                + COLUMN_HHQUESTION20 + " TEXT,"
                + COLUMN_HHQUESTION21 + " TEXT,"
                + COLUMN_HHQUESTION22 + " TEXT,"
                + COLUMN_HHQUESTION23 + " TEXT,"
                + COLUMN_HHQUESTION24 + " TEXT,"
                + COLUMN_HHQUESTION25 + " TEXT,"
                + COLUMN_HHQUESTION26 + " TEXT,"
                + COLUMN_HHQUESTION27 + " TEXT,"
                + COLUMN_HHQUESTION28 + " TEXT,"
                + COLUMN_HHQUESTION29 + " TEXT,"
                + COLUMN_HHQUESTION30 + " TEXT,"
                + COLUMN_HHQUESTION31 + " TEXT,"
                + COLUMN_HHQUESTION32 + " TEXT,"
                + COLUMN_HHQUESTION36 + " TEXT,"
                + COLUMN_HHQUESTION37 + " TEXT,"
                + COLUMN_HH_LOCATION + " TEXT,"
                + COLUMN_FARMER_PHOTO + " TEXT,"
                + COLUMN_SIGNATURE + " TEXT,"
                + COLUMN_USER_FNAME + " TEXT,"
                + COLUMN_USER_ONAME + " TEXT,"
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

//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if (oldVersion < 2) { // Assuming version 2 introduces user_email
//            db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN user_email TEXT DEFAULT '';");
//        }
//    }

    public boolean insertHh(String hh_name, String hh_district, String hh_community,
                            String hhquestion4, String hhquestion5, String hhquestion6, String hhquestion7, String hhquestion8,
                            String hhquestion9, String hhquestion10, String hhquestion11, String hhquestion12, String hhquestion13,
                            String hhquestion14, String hhquestion15, String hhquestion16, String hhquestion17, String hhquestion18,
                            String hhquestion19, String hhquestion20, String hhquestion21, String hhquestion22, String hhquestion23,
                            String hhquestion24, String hhquestion25, String hhquestion26, String hhquestion27, String hhquestion28,
                            String hhquestion29, String hhquestion30, String hhquestion31, String hhquestion32, String hhquestion36,
                            String hhquestion37, String hh_location, String farmer_photo, String signatureBase64,
                                String userFname, String userOname, String user_email, String onCreate, String onUpdate) {
        String signaturePath = null;
        try {
            signaturePath = saveSignatureImage(signatureBase64);
        } catch (IOException e) {
            Log.e("HhDbHelper", "Error saving signature image", e);
            return false; // Return false if signature saving fails
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_HH_NAME, hh_name);
        values.put(COLUMN_HH_DISTRICT, hh_district);
        values.put(COLUMN_HH_COMMUNITY, hh_community);
        values.put(COLUMN_HHQUESTION4, hhquestion4);
        values.put(COLUMN_HHQUESTION5, hhquestion5);
        values.put(COLUMN_HHQUESTION6, hhquestion6);
        values.put(COLUMN_HHQUESTION7, hhquestion7);
        values.put(COLUMN_HHQUESTION8, hhquestion8);
        values.put(COLUMN_HHQUESTION9, hhquestion9);
        values.put(COLUMN_HHQUESTION10, hhquestion10);
        values.put(COLUMN_HHQUESTION11, hhquestion11);
        values.put(COLUMN_HHQUESTION12, hhquestion12);
        values.put(COLUMN_HHQUESTION13, hhquestion13);
        values.put(COLUMN_HHQUESTION14, hhquestion14);
        values.put(COLUMN_HHQUESTION15, hhquestion15);
        values.put(COLUMN_HHQUESTION16, hhquestion16);
        values.put(COLUMN_HHQUESTION17, hhquestion17);
        values.put(COLUMN_HHQUESTION18, hhquestion18);
        values.put(COLUMN_HHQUESTION19, hhquestion19);
        values.put(COLUMN_HHQUESTION20, hhquestion20);
        values.put(COLUMN_HHQUESTION21, hhquestion21);
        values.put(COLUMN_HHQUESTION22, hhquestion22);
        values.put(COLUMN_HHQUESTION23, hhquestion23);
        values.put(COLUMN_HHQUESTION24, hhquestion24);
        values.put(COLUMN_HHQUESTION25, hhquestion25);
        values.put(COLUMN_HHQUESTION26, hhquestion26);
        values.put(COLUMN_HHQUESTION27, hhquestion27);
        values.put(COLUMN_HHQUESTION28, hhquestion28);
        values.put(COLUMN_HHQUESTION29, hhquestion29);
        values.put(COLUMN_HHQUESTION30, hhquestion30);
        values.put(COLUMN_HHQUESTION31, hhquestion31);
        values.put(COLUMN_HHQUESTION32, hhquestion32);
        values.put(COLUMN_HHQUESTION36, hhquestion36);
        values.put(COLUMN_HHQUESTION37, hhquestion37);
        values.put(COLUMN_HH_LOCATION, hh_location);
        values.put(COLUMN_FARMER_PHOTO, farmer_photo);
        values.put(COLUMN_SIGNATURE, signaturePath);
        values.put(COLUMN_USER_FNAME, userFname);
        values.put(COLUMN_USER_ONAME, userOname);
        values.put(COLUMN_USER_EMAIL, user_email);
        values.put(COLUMN_ON_CREATE, onCreate);
        values.put(COLUMN_ON_UPDATE, onUpdate);

        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    private String saveSignatureImage(String signatureBase64) throws IOException {
        if (signatureBase64 == null || !signatureBase64.contains(",")) {
            throw new IOException("Invalid Base64 string");
        }

        try {
            String base64Data = signatureBase64.split(",")[1];
            byte[] decodedBytes = Base64.decode(base64Data, Base64.DEFAULT);

            Bitmap bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
            if (bitmap == null) {
                throw new IOException("Failed to decode bitmap from Base64");
            }

            // Create parent "Signature" directory
            File parentDirectory = new File(context.getExternalFilesDir(null), "Signature");
            if (!parentDirectory.exists() && !parentDirectory.mkdirs()) {
                throw new IOException("Failed to create parent directory");
            }

            // Create child "child-signature" directory
            File directory = new File(parentDirectory, "hh-signature");
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException("Failed to create child directory");
            }

            File signatureFile = new File(directory, "hh_" + System.currentTimeMillis() + ".png");
            try (FileOutputStream fos = new FileOutputStream(signatureFile)) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            }

            Log.d("ChildSurveyDBHelper", "Signature saved at: " + signatureFile.getAbsolutePath());
            return signatureFile.getAbsolutePath();
        } catch (Exception e) {
            Log.e("ChildSurveyDBHelper", "Error saving signature image", e);
            throw new IOException("Failed to save image: " + e.getMessage());
        }
    }

    public boolean updateHh(String id, String hh_name, String hh_district, String hh_community,
                            String hhquestion4, String hhquestion5, String hhquestion6, String hhquestion7, String hhquestion8,
                            String hhquestion9, String hhquestion10, String hhquestion11, String hhquestion12, String hhquestion13,
                            String hhquestion14, String hhquestion15, String hhquestion16, String hhquestion17, String hhquestion18,
                            String hhquestion19, String hhquestion20, String hhquestion21, String hhquestion22, String hhquestion23,
                            String hhquestion24, String hhquestion25, String hhquestion26, String hhquestion27, String hhquestion28,
                            String hhquestion29, String hhquestion30, String hhquestion31, String hhquestion32, String hhquestion36,
                            String hhquestion37, String hh_location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_HH_NAME, hh_name);
        values.put(COLUMN_HH_DISTRICT, hh_district);
        values.put(COLUMN_HH_COMMUNITY, hh_community);
        values.put(COLUMN_HHQUESTION4, hhquestion4);
        values.put(COLUMN_HHQUESTION5, hhquestion5);
        values.put(COLUMN_HHQUESTION6, hhquestion6);
        values.put(COLUMN_HHQUESTION7, hhquestion7);
        values.put(COLUMN_HHQUESTION8, hhquestion8);
        values.put(COLUMN_HHQUESTION9, hhquestion9);
        values.put(COLUMN_HHQUESTION10, hhquestion10);
        values.put(COLUMN_HHQUESTION11, hhquestion11);
        values.put(COLUMN_HHQUESTION12, hhquestion12);
        values.put(COLUMN_HHQUESTION13, hhquestion13);
        values.put(COLUMN_HHQUESTION14, hhquestion14);
        values.put(COLUMN_HHQUESTION15, hhquestion15);
        values.put(COLUMN_HHQUESTION16, hhquestion16);
        values.put(COLUMN_HHQUESTION17, hhquestion17);
        values.put(COLUMN_HHQUESTION18, hhquestion18);
        values.put(COLUMN_HHQUESTION19, hhquestion19);
        values.put(COLUMN_HHQUESTION20, hhquestion20);
        values.put(COLUMN_HHQUESTION21, hhquestion21);
        values.put(COLUMN_HHQUESTION22, hhquestion22);
        values.put(COLUMN_HHQUESTION23, hhquestion23);
        values.put(COLUMN_HHQUESTION24, hhquestion24);
        values.put(COLUMN_HHQUESTION25, hhquestion25);
        values.put(COLUMN_HHQUESTION26, hhquestion26);
        values.put(COLUMN_HHQUESTION27, hhquestion27);
        values.put(COLUMN_HHQUESTION28, hhquestion28);
        values.put(COLUMN_HHQUESTION29, hhquestion29);
        values.put(COLUMN_HHQUESTION30, hhquestion30);
        values.put(COLUMN_HHQUESTION31, hhquestion31);
        values.put(COLUMN_HHQUESTION32, hhquestion32);
        values.put(COLUMN_HHQUESTION36, hhquestion36);
        values.put(COLUMN_HHQUESTION37, hhquestion37);
        values.put(COLUMN_HH_LOCATION, hh_location);
        values.put(COLUMN_ON_UPDATE, System.currentTimeMillis());

        int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{id});
        db.close();

        return rowsUpdated > 0;
    }

    public Cursor getHhSurveyData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public List<HhModel> getAllHh() {
        List<HhModel> surveyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String hh_name = cursor.getString(cursor.getColumnIndexOrThrow("hh_name"));
                String hh_district = cursor.getString(cursor.getColumnIndexOrThrow("hh_district"));
                String hh_community = cursor.getString(cursor.getColumnIndexOrThrow("hh_community"));
                String hhquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion4"));
                String hhquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion5"));
                String hhquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion6"));
                String hhquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion7"));
                String hhquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion8"));
                String hhquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion9"));
                String hhquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion10"));
                String hhquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion11"));
                String hhquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion12"));
                String hhquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion13"));
                String hhquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion14"));
                String hhquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion15"));
                String hhquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion16"));
                String hhquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion17"));
                String hhquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion18"));
                String hhquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion19"));
                String hhquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion20"));
                String hhquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion21"));
                String hhquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion22"));
                String hhquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion23"));
                String hhquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion24"));
                String hhquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion25"));
                String hhquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion26"));
                String hhquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion27"));
                String hhquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion28"));
                String hhquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion29"));
                String hhquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion30"));
                String hhquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion31"));
                String hhquestion32 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion32"));
                String hhquestion36 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion36"));
                String hhquestion37 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion37"));
                String hh_location = cursor.getString(cursor.getColumnIndexOrThrow("hh_location"));
                String farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String userOname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                HhModel model = new HhModel(
                        id, hh_name, hh_district, hh_community,
                        hhquestion4, hhquestion5, hhquestion6, hhquestion7, hhquestion8, hhquestion9, hhquestion10,
                        hhquestion11, hhquestion12, hhquestion13, hhquestion14, hhquestion15, hhquestion16, hhquestion17,
                        hhquestion18, hhquestion19, hhquestion20, hhquestion21, hhquestion22, hhquestion23, hhquestion24,
                        hhquestion25, hhquestion26, hhquestion27, hhquestion28, hhquestion29, hhquestion30, hhquestion31,
                        hhquestion32, hhquestion36, hhquestion37, hh_location,
                        farmer_photo != null ? Uri.parse(farmer_photo) : null,
                        signature, userFname, userOname, user_email, onCreate, onUpdate
                );

                surveyList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return surveyList;
    }

    public HhModel getSurveyDetailsByHhName(String hh_name) {
        SQLiteDatabase db = this.getReadableDatabase();
        HhModel hhModel = null;

        Cursor cursor = db.query(
                "HouseholdSurveyTbl",
                null,
                "hh_name = ?",
                new String[]{hh_name},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String hh_district = cursor.getString(cursor.getColumnIndexOrThrow("hh_district"));
            String hh_community = cursor.getString(cursor.getColumnIndexOrThrow("hh_community"));
            String hhquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion4"));
            String hhquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion5"));
            String hhquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion6"));
            String hhquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion7"));
            String hhquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion8"));
            String hhquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion9"));
            String hhquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion10"));
            String hhquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion11"));
            String hhquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion12"));
            String hhquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion13"));
            String hhquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion14"));
            String hhquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion15"));
            String hhquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion16"));
            String hhquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion17"));
            String hhquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion18"));
            String hhquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion19"));
            String hhquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion20"));
            String hhquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion21"));
            String hhquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion22"));
            String hhquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion23"));
            String hhquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion24"));
            String hhquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion25"));
            String hhquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion26"));
            String hhquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion27"));
            String hhquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion28"));
            String hhquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion29"));
            String hhquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion30"));
            String hhquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion31"));
            String hhquestion32 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion32"));
            String hhquestion36 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion36"));
            String hhquestion37 = cursor.getString(cursor.getColumnIndexOrThrow("hhquestion37"));
            String hh_location = cursor.getString(cursor.getColumnIndexOrThrow("hh_location"));
            Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                    ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                    : null;
            String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
            String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
            String userOname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
            String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
            String on_create = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
            String on_update = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

            hhModel = new HhModel(id, hh_name, hh_district, hh_community,
                    hhquestion4, hhquestion5, hhquestion6, hhquestion7, hhquestion8, hhquestion9, hhquestion10,
                    hhquestion11, hhquestion12, hhquestion13, hhquestion14, hhquestion15, hhquestion16, hhquestion17,
                    hhquestion18, hhquestion19, hhquestion20, hhquestion21, hhquestion22, hhquestion23, hhquestion24,
                    hhquestion25, hhquestion26, hhquestion27, hhquestion28, hhquestion29, hhquestion30, hhquestion31,
                    hhquestion32, hhquestion36, hhquestion37, hh_location, farmer_photo, signature, userFname,
                    userOname, user_email, on_create, on_update);
            cursor.close();
        }
        return hhModel;
    }
}
