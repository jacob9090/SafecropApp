package com.jacob.fruitoftek.safecrop.comdev.obs;

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

public class ObsDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ObservationSurveyDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "ObservationSurveyTbl";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_OBSERVATION_NAME = "obs_name";
    private static final String COLUMN_OBSERVATION_DISTRICT = "obs_district";
    private static final String COLUMN_OBSERVATION_COMMUNITY = "obs_community";
    private static final String COLUMN_OBSQUESTION6 = "obsquestion6";
    private static final String COLUMN_OBSQUESTION7 = "obsquestion7";
    private static final String COLUMN_OBSQUESTION8 = "obsquestion8";
    private static final String COLUMN_OBSQUESTION9 = "obsquestion9";
    private static final String COLUMN_OBSQUESTION10 = "obsquestion10";
    private static final String COLUMN_OBSQUESTION11 = "obsquestion11";
    private static final String COLUMN_OBSQUESTION12 = "obsquestion12";
    private static final String COLUMN_OBSQUESTION13 = "obsquestion13";
    private static final String COLUMN_OBSQUESTION14 = "obsquestion14";
    private static final String COLUMN_OBSQUESTION15 = "obsquestion15";
    private static final String COLUMN_OBSQUESTION16 = "obsquestion16";
    private static final String COLUMN_OBSQUESTION17 = "obsquestion17";
    private static final String COLUMN_OBSQUESTION18 = "obsquestion18";
    private static final String COLUMN_OBSQUESTION19 = "obsquestion19";
    private static final String COLUMN_OBSQUESTION20 = "obsquestion20";
    private static final String COLUMN_OBSQUESTION21 = "obsquestion21";
    private static final String COLUMN_OBSERVATION_LOCATION = "obs_location";
    private static final String COLUMN_FARMER_PHOTO = "farmer_photo";
    private static final String COLUMN_SIGNATURE = "signature";
    private static final String COLUMN_USER_FNAME = "user_fname";
    private static final String COLUMN_USER_ONAME = "user_oname";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_ON_CREATE = "on_create";
    private static final String COLUMN_ON_UPDATE = "on_update";

    private Context context;

    public ObsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_OBSERVATION_NAME + " TEXT,"
                + COLUMN_OBSERVATION_DISTRICT + " TEXT,"
                + COLUMN_OBSERVATION_COMMUNITY + " TEXT,"
                + COLUMN_OBSQUESTION6 + " TEXT,"
                + COLUMN_OBSQUESTION7 + " TEXT,"
                + COLUMN_OBSQUESTION8 + " TEXT,"
                + COLUMN_OBSQUESTION9 + " TEXT,"
                + COLUMN_OBSQUESTION10 + " TEXT,"
                + COLUMN_OBSQUESTION11 + " TEXT,"
                + COLUMN_OBSQUESTION12 + " TEXT,"
                + COLUMN_OBSQUESTION13 + " TEXT,"
                + COLUMN_OBSQUESTION14 + " TEXT,"
                + COLUMN_OBSQUESTION15 + " TEXT,"
                + COLUMN_OBSQUESTION16 + " TEXT,"
                + COLUMN_OBSQUESTION17 + " TEXT,"
                + COLUMN_OBSQUESTION18 + " TEXT,"
                + COLUMN_OBSQUESTION19 + " TEXT,"
                + COLUMN_OBSQUESTION20 + " TEXT,"
                + COLUMN_OBSQUESTION21 + " TEXT,"
                + COLUMN_OBSERVATION_LOCATION + " TEXT,"
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


    public boolean insertObs(String obs_name, String obs_district, String obs_community,
                             String obsquestion6, String obsquestion7, String obsquestion8, String obsquestion9,
                             String obsquestion10, String obsquestion11, String obsquestion12, String obsquestion13,
                             String obsquestion14, String obsquestion15, String obsquestion16, String obsquestion17,
                             String obsquestion18, String obsquestion19, String obsquestion20, String obsquestion21,
                             String obs_location, String farmer_photo, String signatureBase64,
                                String userFname, String userOname, String user_email, String onCreate, String onUpdate) {
        String signaturePath = null;
        try {
            signaturePath = saveSignatureImage(signatureBase64);
        } catch (IOException e) {
            Log.e("ObsDbHelper", "Error saving signature image", e);
            return false; // Return false if signature saving fails
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_OBSERVATION_NAME, obs_name);
        values.put(COLUMN_OBSERVATION_DISTRICT, obs_district);
        values.put(COLUMN_OBSERVATION_COMMUNITY, obs_community);
        values.put(COLUMN_OBSQUESTION6, obsquestion6);
        values.put(COLUMN_OBSQUESTION7, obsquestion7);
        values.put(COLUMN_OBSQUESTION8, obsquestion8);
        values.put(COLUMN_OBSQUESTION9, obsquestion9);
        values.put(COLUMN_OBSQUESTION10, obsquestion10);
        values.put(COLUMN_OBSQUESTION11, obsquestion11);
        values.put(COLUMN_OBSQUESTION12, obsquestion12);
        values.put(COLUMN_OBSQUESTION13, obsquestion13);
        values.put(COLUMN_OBSQUESTION14, obsquestion14);
        values.put(COLUMN_OBSQUESTION15, obsquestion15);
        values.put(COLUMN_OBSQUESTION16, obsquestion16);
        values.put(COLUMN_OBSQUESTION17, obsquestion17);
        values.put(COLUMN_OBSQUESTION18, obsquestion18);
        values.put(COLUMN_OBSQUESTION19, obsquestion19);
        values.put(COLUMN_OBSQUESTION20, obsquestion20);
        values.put(COLUMN_OBSQUESTION21, obsquestion21);
        values.put(COLUMN_OBSERVATION_LOCATION, obs_location);
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
            File directory = new File(parentDirectory, "obs-signature");
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException("Failed to create child directory");
            }

            File signatureFile = new File(directory, "obs_" + System.currentTimeMillis() + ".png");
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

    public boolean updateObs(String id, String obs_name, String obs_district, String obs_community,
                             String obsquestion6, String obsquestion7, String obsquestion8, String obsquestion9,
                             String obsquestion10, String obsquestion11, String obsquestion12, String obsquestion13,
                             String obsquestion14, String obsquestion15, String obsquestion16, String obsquestion17,
                             String obsquestion18, String obsquestion19, String obsquestion20, String obsquestion21,
                             String obs_location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_OBSERVATION_NAME, obs_name);
        values.put(COLUMN_OBSERVATION_DISTRICT, obs_district);
        values.put(COLUMN_OBSERVATION_COMMUNITY, obs_community);
        values.put(COLUMN_OBSQUESTION6, obsquestion6);
        values.put(COLUMN_OBSQUESTION7, obsquestion7);
        values.put(COLUMN_OBSQUESTION8, obsquestion8);
        values.put(COLUMN_OBSQUESTION9, obsquestion9);
        values.put(COLUMN_OBSQUESTION10, obsquestion10);
        values.put(COLUMN_OBSQUESTION11, obsquestion11);
        values.put(COLUMN_OBSQUESTION12, obsquestion12);
        values.put(COLUMN_OBSQUESTION13, obsquestion13);
        values.put(COLUMN_OBSQUESTION14, obsquestion14);
        values.put(COLUMN_OBSQUESTION15, obsquestion15);
        values.put(COLUMN_OBSQUESTION16, obsquestion16);
        values.put(COLUMN_OBSQUESTION17, obsquestion17);
        values.put(COLUMN_OBSQUESTION18, obsquestion18);
        values.put(COLUMN_OBSQUESTION19, obsquestion19);
        values.put(COLUMN_OBSQUESTION20, obsquestion20);
        values.put(COLUMN_OBSQUESTION21, obsquestion21);
        values.put(COLUMN_OBSERVATION_LOCATION, obs_location);
        values.put(COLUMN_ON_UPDATE, System.currentTimeMillis());

        int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{id});
        db.close();

        return rowsUpdated > 0;
    }

    public Cursor getObsSurveyData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public List<ObsModel> getAllObservation() {
        List<ObsModel> surveyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String obs_name = cursor.getString(cursor.getColumnIndexOrThrow("obs_name"));
                String obs_district = cursor.getString(cursor.getColumnIndexOrThrow("obs_district"));
                String obs_community = cursor.getString(cursor.getColumnIndexOrThrow("obs_community"));
                String obsquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion6"));
                String obsquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion7"));
                String obsquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion8"));
                String obsquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion9"));
                String obsquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion10"));
                String obsquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion11"));
                String obsquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion12"));
                String obsquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion13"));
                String obsquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion14"));
                String obsquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion15"));
                String obsquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion16"));
                String obsquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion17"));
                String obsquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion18"));
                String obsquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion19"));
                String obsquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion20"));
                String obsquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion21"));
                String obs_location = cursor.getString(cursor.getColumnIndexOrThrow("obs_location"));
                String farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String userOname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                ObsModel model = new ObsModel(
                        id, obs_name, obs_district, obs_community,
                        obsquestion6, obsquestion7, obsquestion8, obsquestion9, obsquestion10, obsquestion11,
                        obsquestion12, obsquestion13, obsquestion14, obsquestion15, obsquestion16, obsquestion17,
                        obsquestion18, obsquestion19, obsquestion20, obsquestion21, obs_location,
                        farmer_photo != null ? Uri.parse(farmer_photo) : null,
                        signature, userFname, userOname, user_email, onCreate, onUpdate
                );

                surveyList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return surveyList;
    }

    public ObsModel getSurveyDetailsByObsName(String obs_name) {
        SQLiteDatabase db = this.getReadableDatabase();
        ObsModel obsModel = null;

        Cursor cursor = db.query(
                "ObservationSurveyTbl",
                null,
                "obs_name = ?",
                new String[]{obs_name},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String obs_district = cursor.getString(cursor.getColumnIndexOrThrow("obs_district"));
            String obs_community = cursor.getString(cursor.getColumnIndexOrThrow("obs_community"));
            String obsquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion6"));
            String obsquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion7"));
            String obsquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion8"));
            String obsquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion9"));
            String obsquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion10"));
            String obsquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion11"));
            String obsquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion12"));
            String obsquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion13"));
            String obsquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion14"));
            String obsquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion15"));
            String obsquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion16"));
            String obsquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion17"));
            String obsquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion18"));
            String obsquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion19"));
            String obsquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion20"));
            String obsquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("obsquestion21"));
            String obs_location = cursor.getString(cursor.getColumnIndexOrThrow("obs_location"));
            Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                    ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                    : null;
            String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
            String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
            String userOname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
            String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
            String on_create = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
            String on_update = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

            obsModel = new ObsModel(id, obs_name, obs_district, obs_community,
                    obsquestion6, obsquestion7, obsquestion8, obsquestion9, obsquestion10, obsquestion11,
                    obsquestion12, obsquestion13, obsquestion14, obsquestion15, obsquestion16, obsquestion17,
                    obsquestion18, obsquestion19, obsquestion20, obsquestion21, obs_location,
                    farmer_photo, signature, userFname, userOname, userEmail, on_create, on_update);
            cursor.close();
        }
        return obsModel;
    }
}
