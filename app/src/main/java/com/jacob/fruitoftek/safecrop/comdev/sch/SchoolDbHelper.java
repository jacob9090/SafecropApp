package com.jacob.fruitoftek.safecrop.comdev.sch;

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

public class SchoolDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SchoolSurveyDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "SchoolSurveyTbl";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SCHOOL_NAME = "school_name";
    private static final String COLUMN_SCHOOL_DISTRICT = "school_district";
    private static final String COLUMN_SCHOOL_COMMUNITY = "school_community";
    private static final String COLUMN_SCHQUESTION4 = "schquestion4";
    private static final String COLUMN_SCHQUESTION5 = "schquestion5";
    private static final String COLUMN_SCHQUESTION6 = "schquestion6";
    private static final String COLUMN_SCHQUESTION7 = "schquestion7";
    private static final String COLUMN_SCHQUESTION8 = "schquestion8";
    private static final String COLUMN_SCHQUESTION9 = "schquestion9";
    private static final String COLUMN_SCHQUESTION10 = "schquestion10";
    private static final String COLUMN_SCHQUESTION11 = "schquestion11";
    private static final String COLUMN_SCHQUESTION12 = "schquestion12";
    private static final String COLUMN_SCHQUESTION13 = "schquestion13";
    private static final String COLUMN_SCHQUESTION14 = "schquestion14";
    private static final String COLUMN_SCHQUESTION15 = "schquestion15";
    private static final String COLUMN_SCHQUESTION16 = "schquestion16";
    private static final String COLUMN_SCHQUESTION17 = "schquestion17";
    private static final String COLUMN_SCHQUESTION18 = "schquestion18";
    private static final String COLUMN_SCHQUESTION19 = "schquestion19";
    private static final String COLUMN_SCHQUESTION20 = "schquestion20";
    private static final String COLUMN_SCHQUESTION21 = "schquestion21";
    private static final String COLUMN_SCHQUESTION22 = "schquestion22";
    private static final String COLUMN_SCHQUESTION23 = "schquestion23";
    private static final String COLUMN_SCHQUESTION24 = "schquestion24";
    private static final String COLUMN_SCHQUESTION25 = "schquestion25";
    private static final String COLUMN_SCHQUESTION26 = "schquestion26";
    private static final String COLUMN_SCHQUESTION27 = "schquestion27";
    private static final String COLUMN_SCHQUESTION28 = "schquestion28";
    private static final String COLUMN_SCHQUESTION29 = "schquestion29";
    private static final String COLUMN_SCHQUESTION30 = "schquestion30";
    private static final String COLUMN_SCHQUESTION31 = "schquestion31";
    private static final String COLUMN_SCHQUESTION32 = "schquestion32";
    private static final String COLUMN_SCHQUESTION33 = "schquestion33";
    private static final String COLUMN_SCHQUESTION34 = "schquestion34";
    private static final String COLUMN_SCHOOL_LOCATION = "school_location";
    private static final String COLUMN_FARMER_PHOTO = "farmer_photo";
    private static final String COLUMN_SIGNATURE = "signature";
    private static final String COLUMN_USER_FNAME = "user_fname";
    private static final String COLUMN_USER_ONAME = "user_oname";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_ON_CREATE = "on_create";
    private static final String COLUMN_ON_UPDATE = "on_update";

    private Context context;

    public SchoolDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SCHOOL_NAME + " TEXT,"
                + COLUMN_SCHOOL_DISTRICT + " TEXT,"
                + COLUMN_SCHOOL_COMMUNITY + " TEXT,"
                + COLUMN_SCHQUESTION4 + " TEXT,"
                + COLUMN_SCHQUESTION5 + " TEXT,"
                + COLUMN_SCHQUESTION6 + " TEXT,"
                + COLUMN_SCHQUESTION7 + " TEXT,"
                + COLUMN_SCHQUESTION8 + " TEXT,"
                + COLUMN_SCHQUESTION9 + " TEXT,"
                + COLUMN_SCHQUESTION10 + " TEXT,"
                + COLUMN_SCHQUESTION11 + " TEXT,"
                + COLUMN_SCHQUESTION12 + " TEXT,"
                + COLUMN_SCHQUESTION13 + " TEXT,"
                + COLUMN_SCHQUESTION14 + " TEXT,"
                + COLUMN_SCHQUESTION15 + " TEXT,"
                + COLUMN_SCHQUESTION16 + " TEXT,"
                + COLUMN_SCHQUESTION17 + " TEXT,"
                + COLUMN_SCHQUESTION18 + " TEXT,"
                + COLUMN_SCHQUESTION19 + " TEXT,"
                + COLUMN_SCHQUESTION20 + " TEXT,"
                + COLUMN_SCHQUESTION21 + " TEXT,"
                + COLUMN_SCHQUESTION22 + " TEXT,"
                + COLUMN_SCHQUESTION23 + " TEXT,"
                + COLUMN_SCHQUESTION24 + " TEXT,"
                + COLUMN_SCHQUESTION25 + " TEXT,"
                + COLUMN_SCHQUESTION26 + " TEXT,"
                + COLUMN_SCHQUESTION27 + " TEXT,"
                + COLUMN_SCHQUESTION28 + " TEXT,"
                + COLUMN_SCHQUESTION29 + " TEXT,"
                + COLUMN_SCHQUESTION30 + " TEXT,"
                + COLUMN_SCHQUESTION31 + " TEXT,"
                + COLUMN_SCHQUESTION32 + " TEXT,"
                + COLUMN_SCHQUESTION33 + " TEXT,"
                + COLUMN_SCHQUESTION34 + " TEXT,"
                + COLUMN_SCHOOL_LOCATION + " TEXT,"
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

    public boolean insertSchool(String sch_name, String sch_district, String sch_community,
                                String schquestion4, String schquestion5, String schquestion6, String schquestion7,
                                String schquestion8, String schquestion9, String schquestion10, String schquestion11,
                                String schquestion12, String schquestion13, String schquestion14, String schquestion15,
                                String schquestion16, String schquestion17, String schquestion18, String schquestion19,
                                String schquestion20, String schquestion21, String schquestion22, String schquestion23,
                                String schquestion24, String schquestion25, String schquestion26, String schquestion27,
                                String schquestion28, String schquestion29, String schquestion30, String schquestion31,
                                String schquestion32, String schquestion33, String schquestion34, String sch_location,
                                String farmer_photo, String signatureBase64,
                                String userFname, String userOname, String userEmail, String onCreate, String onUpdate) {
        String signaturePath = null;
        try {
            signaturePath = saveSignatureImage(signatureBase64);
        } catch (IOException e) {
            Log.e("SchoolDbHelper", "Error saving signature image", e);
            return false; // Return false if signature saving fails
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SCHOOL_NAME, sch_name);
        values.put(COLUMN_SCHOOL_DISTRICT, sch_district);
        values.put(COLUMN_SCHOOL_COMMUNITY, sch_community);
        values.put(COLUMN_SCHQUESTION4, schquestion4);
        values.put(COLUMN_SCHQUESTION5, schquestion5);
        values.put(COLUMN_SCHQUESTION6, schquestion6);
        values.put(COLUMN_SCHQUESTION7, schquestion7);
        values.put(COLUMN_SCHQUESTION8, schquestion8);
        values.put(COLUMN_SCHQUESTION9, schquestion9);
        values.put(COLUMN_SCHQUESTION10, schquestion10);
        values.put(COLUMN_SCHQUESTION11, schquestion11);
        values.put(COLUMN_SCHQUESTION12, schquestion12);
        values.put(COLUMN_SCHQUESTION13, schquestion13);
        values.put(COLUMN_SCHQUESTION14, schquestion14);
        values.put(COLUMN_SCHQUESTION15, schquestion15);
        values.put(COLUMN_SCHQUESTION16, schquestion16);
        values.put(COLUMN_SCHQUESTION17, schquestion17);
        values.put(COLUMN_SCHQUESTION18, schquestion18);
        values.put(COLUMN_SCHQUESTION19, schquestion19);
        values.put(COLUMN_SCHQUESTION20, schquestion20);
        values.put(COLUMN_SCHQUESTION21, schquestion21);
        values.put(COLUMN_SCHQUESTION22, schquestion22);
        values.put(COLUMN_SCHQUESTION23, schquestion23);
        values.put(COLUMN_SCHQUESTION24, schquestion24);
        values.put(COLUMN_SCHQUESTION25, schquestion25);
        values.put(COLUMN_SCHQUESTION26, schquestion26);
        values.put(COLUMN_SCHQUESTION27, schquestion27);
        values.put(COLUMN_SCHQUESTION28, schquestion28);
        values.put(COLUMN_SCHQUESTION29, schquestion29);
        values.put(COLUMN_SCHQUESTION30, schquestion30);
        values.put(COLUMN_SCHQUESTION31, schquestion31);
        values.put(COLUMN_SCHQUESTION32, schquestion32);
        values.put(COLUMN_SCHQUESTION33, schquestion33);
        values.put(COLUMN_SCHQUESTION34, schquestion34);
        values.put(COLUMN_SCHOOL_LOCATION, sch_location);
        values.put(COLUMN_FARMER_PHOTO, farmer_photo);
        values.put(COLUMN_SIGNATURE, signaturePath);
        values.put(COLUMN_USER_FNAME, userFname);
        values.put(COLUMN_USER_ONAME, userOname);
        values.put(COLUMN_USER_EMAIL, userEmail);
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
            File directory = new File(parentDirectory, "school-signature");
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException("Failed to create child directory");
            }

            File signatureFile = new File(directory, "school_" + System.currentTimeMillis() + ".png");
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

    public boolean updateSchool(String id, String sch_name, String sch_district, String sch_community, String sch_location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SCHOOL_NAME, sch_name);
        values.put(COLUMN_SCHOOL_DISTRICT, sch_district);
        values.put(COLUMN_SCHOOL_COMMUNITY, sch_community);
        values.put(COLUMN_SCHOOL_LOCATION, sch_location);
        values.put(COLUMN_ON_UPDATE, System.currentTimeMillis());

        int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{id});
        db.close();

        return rowsUpdated > 0;
    }

    public Cursor getSchSurveyData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public List<SchoolModel> getAllSchools() {
        List<SchoolModel> surveyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String school_name = cursor.getString(cursor.getColumnIndexOrThrow("school_name"));
                String school_district = cursor.getString(cursor.getColumnIndexOrThrow("school_district"));
                String school_community = cursor.getString(cursor.getColumnIndexOrThrow("school_community"));
                String schquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion4"));
                String schquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion5"));
                String schquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion6"));
                String schquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion7"));
                String schquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion8"));
                String schquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion9"));
                String schquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion10"));
                String schquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion11"));
                String schquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion12"));
                String schquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion13"));
                String schquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion14"));
                String schquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion15"));
                String schquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion16"));
                String schquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion17"));
                String schquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion18"));
                String schquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion19"));
                String schquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion20"));
                String schquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion21"));
                String schquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion22"));
                String schquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion23"));
                String schquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion24"));
                String schquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion25"));
                String schquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion26"));
                String schquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion27"));
                String schquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion28"));
                String schquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion29"));
                String schquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion30"));
                String schquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion31"));
                String schquestion32 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion32"));
                String schquestion33 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion33"));
                String schquestion34 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion34"));
                String school_location = cursor.getString(cursor.getColumnIndexOrThrow("school_location"));
                String farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String userOname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
                String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                SchoolModel model = new SchoolModel(
                        id, school_name, school_district, school_community,
                        schquestion4, schquestion5, schquestion6, schquestion7, schquestion8, schquestion9,
                        schquestion10, schquestion11, schquestion12, schquestion13, schquestion14, schquestion15,
                        schquestion16, schquestion17, schquestion18, schquestion19, schquestion20, schquestion21,
                        schquestion22, schquestion23, schquestion24, schquestion25, schquestion26, schquestion27,
                        schquestion28, schquestion29, schquestion30, schquestion31, schquestion32, schquestion33,
                        schquestion34, school_location,
                        farmer_photo != null ? Uri.parse(farmer_photo) : null,
                        signature, userFname, userOname, userEmail, onCreate, onUpdate
                );

                surveyList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return surveyList;
    }

    public SchoolModel getSurveyDetailsBySchoolName(String school_name) {
        SQLiteDatabase db = this.getReadableDatabase();
        SchoolModel schoolModel = null;

        Cursor cursor = db.query(
                "SchoolSurveyTbl",
                null,
                "school_name = ?",
                new String[]{school_name},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String school_district = cursor.getString(cursor.getColumnIndexOrThrow("school_district"));
            String school_community = cursor.getString(cursor.getColumnIndexOrThrow("school_community"));
            String schquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion4"));
            String schquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion5"));
            String schquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion6"));
            String schquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion7"));
            String schquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion8"));
            String schquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion9"));
            String schquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion10"));
            String schquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion11"));
            String schquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion12"));
            String schquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion13"));
            String schquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion14"));
            String schquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion15"));
            String schquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion16"));
            String schquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion17"));
            String schquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion18"));
            String schquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion19"));
            String schquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion20"));
            String schquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion21"));
            String schquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion22"));
            String schquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion23"));
            String schquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion24"));
            String schquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion25"));
            String schquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion26"));
            String schquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion27"));
            String schquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion28"));
            String schquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion29"));
            String schquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion30"));
            String schquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion31"));
            String schquestion32 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion32"));
            String schquestion33 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion33"));
            String schquestion34 = cursor.getString(cursor.getColumnIndexOrThrow("schquestion34"));
            String school_location = cursor.getString(cursor.getColumnIndexOrThrow("school_location"));
            Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                    ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                    : null;
            String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
            String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
            String userOname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
            String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
            String on_create = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
            String on_update = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

            schoolModel = new SchoolModel(id, school_name, school_district, school_community,
                    schquestion4, schquestion5, schquestion6, schquestion7, schquestion8, schquestion9,
                    schquestion10, schquestion11, schquestion12, schquestion13, schquestion14, schquestion15,
                    schquestion16, schquestion17, schquestion18, schquestion19, schquestion20, schquestion21,
                    schquestion22, schquestion23, schquestion24, schquestion25, schquestion26, schquestion27,
                    schquestion28, schquestion29, schquestion30, schquestion31, schquestion32, schquestion33,
                    schquestion34, school_location, farmer_photo, signature, userFname, userOname, userEmail,
                    on_create, on_update);
            cursor.close();
        }
        return schoolModel;
    }
}
