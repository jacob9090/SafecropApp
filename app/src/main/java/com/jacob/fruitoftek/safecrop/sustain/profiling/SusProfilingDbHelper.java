package com.jacob.fruitoftek.safecrop.sustain.profiling;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SusProfilingDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SusProfilingDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "SusProfilingTbl";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FARMER_ID = "farmer_id";
    private static final String COLUMN_FARMER_NAME = "farmer_name";
    private static final String COLUMN_FARMER_GENDER = "farmer_gender";
    private static final String COLUMN_DISTRICT = "district";
    private static final String COLUMN_COMMUNITY = "community";
    private static final String COLUMN_FARMER_DOB = "farmer_dob";
    private static final String COLUMN_GHANA_CARD = "ghana_card";
    private static final String COLUMN_SUSPRO_QUESTION1 = "suspro_question1";
    private static final String COLUMN_SUSPRO_QUESTION2 = "suspro_question2";
    private static final String COLUMN_SUSPRO_QUESTION3 = "suspro_question3";
    private static final String COLUMN_SUSPRO_QUESTION4 = "suspro_question4";
    private static final String COLUMN_SUSPRO_QUESTION5 = "suspro_question5";
    private static final String COLUMN_SUSPRO_QUESTION6 = "suspro_question6";
    private static final String COLUMN_SUSPRO_QUESTION7 = "suspro_question7";
    private static final String COLUMN_SUSPRO_QUESTION8 = "suspro_question8";
    private static final String COLUMN_SUSPRO_QUESTION9 = "suspro_question9";
    private static final String COLUMN_SUSPRO_QUESTION10 = "suspro_question10";
    private static final String COLUMN_SUSPRO_QUESTION11 = "suspro_question11";
    private static final String COLUMN_SUSPRO_QUESTION12 = "suspro_question12";
    private static final String COLUMN_SUSPRO_QUESTION13 = "suspro_question13";
    private static final String COLUMN_SUSPRO_QUESTION14 = "suspro_question14";
    private static final String COLUMN_SUSPRO_QUESTION15 = "suspro_question15";
    private static final String COLUMN_SUSPRO_QUESTION16 = "suspro_question16";
    private static final String COLUMN_SUSPRO_QUESTION17 = "suspro_question17";
    private static final String COLUMN_SUSPRO_QUESTION18 = "suspro_question18";
    private static final String COLUMN_SUSPRO_QUESTION19 = "suspro_question19";
    private static final String COLUMN_SUSPRO_QUESTION20 = "suspro_question20";
    private static final String COLUMN_SUSPRO_QUESTION21 = "suspro_question21";
    private static final String COLUMN_SUSPRO_QUESTION22 = "suspro_question22";
    private static final String COLUMN_SUSPRO_QUESTION23 = "suspro_question23";
    private static final String COLUMN_SUSPRO_QUESTION24 = "suspro_question24";
    private static final String COLUMN_SUSPRO_QUESTION25 = "suspro_question25";
    private static final String COLUMN_SIGNATURE = "signature";
    private static final String COLUMN_IS_SYNC = "is_sync";
    private static final String COLUMN_IS_DRAFT = "is_draft";
    private static final String COLUMN_USER_FNAME = "user_fname";
    private static final String COLUMN_USER_LNAME = "user_lname";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_ON_CREATE = "on_create";
    private static final String COLUMN_ON_UPDATE = "on_update";

    private Context context;

    public SusProfilingDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_FARMER_ID + " TEXT UNIQUE,"
                + COLUMN_FARMER_NAME + " TEXT,"
                + COLUMN_FARMER_GENDER + " TEXT,"
                + COLUMN_DISTRICT + " TEXT,"
                + COLUMN_COMMUNITY + " TEXT,"
                + COLUMN_FARMER_DOB + " TEXT,"
                + COLUMN_GHANA_CARD + " TEXT,"
                + COLUMN_SUSPRO_QUESTION1 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION2 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION3 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION4 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION5 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION6 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION7 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION8 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION9 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION10 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION11 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION12 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION13 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION14 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION15 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION16 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION17 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION18 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION19 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION20 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION21 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION22 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION23 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION24 + " TEXT,"
                + COLUMN_SUSPRO_QUESTION25 + " TEXT,"
                + COLUMN_SIGNATURE + " TEXT,"
                + COLUMN_IS_SYNC + " INTEGER DEFAULT 0,"
                + COLUMN_IS_DRAFT + " INTEGER DEFAULT 0,"
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

    public boolean insertOrUpdateSusProfiling(String farmer_id, String farmer_name, String farmer_gender, String district, String community,
                                              String farmer_dob, String ghana_card, String suspro_question1, String suspro_question2, 
                                              String suspro_question3, String suspro_question4, String suspro_question5, String suspro_question6, 
                                              String suspro_question7, String suspro_question8, String suspro_question9, String suspro_question10,
                                              String suspro_question11, String suspro_question12, String suspro_question13, String suspro_question14,
                                              String suspro_question15, String suspro_question16, String suspro_question17, String suspro_question18,
                                              String suspro_question19, String suspro_question20, String suspro_question21, String suspro_question22,
                                              String suspro_question23, String suspro_question24, String suspro_question25, String signatureBase64, 
                                              String is_sync, String is_draft, String userFname, String userLname, String user_email, String onCreate, 
                                              String onUpdate) {

        String signaturePath = null;
        if (signatureBase64 != null && signatureBase64.startsWith("data:image")) {
            try {
                signaturePath = saveSignatureImage(signatureBase64);
            } catch (IOException e) {
                Log.e("SusProfilingDbHelper", "Error saving signature image", e);
                return false; // Signature failed to save
            }
        } else if (signatureBase64 != null && !signatureBase64.isEmpty()) {
            // If it's an existing path (from update), use as is
            signaturePath = signatureBase64;
        }

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FARMER_ID, farmer_id);
        values.put(COLUMN_FARMER_NAME, farmer_name);
        values.put(COLUMN_FARMER_GENDER, farmer_gender);
        values.put(COLUMN_DISTRICT, district);
        values.put(COLUMN_COMMUNITY, community);
        values.put(COLUMN_FARMER_DOB, farmer_dob);
        values.put(COLUMN_GHANA_CARD, ghana_card);
        values.put(COLUMN_SUSPRO_QUESTION1, suspro_question1);
        values.put(COLUMN_SUSPRO_QUESTION2, suspro_question2);
        values.put(COLUMN_SUSPRO_QUESTION3, suspro_question3);
        values.put(COLUMN_SUSPRO_QUESTION4, suspro_question4);
        values.put(COLUMN_SUSPRO_QUESTION5, suspro_question5);
        values.put(COLUMN_SUSPRO_QUESTION6, suspro_question6);
        values.put(COLUMN_SUSPRO_QUESTION7, suspro_question7);
        values.put(COLUMN_SUSPRO_QUESTION8, suspro_question8);
        values.put(COLUMN_SUSPRO_QUESTION9, suspro_question9);
        values.put(COLUMN_SUSPRO_QUESTION10, suspro_question10);
        values.put(COLUMN_SUSPRO_QUESTION11, suspro_question11);
        values.put(COLUMN_SUSPRO_QUESTION12, suspro_question12);
        values.put(COLUMN_SUSPRO_QUESTION13, suspro_question13);
        values.put(COLUMN_SUSPRO_QUESTION14, suspro_question14);
        values.put(COLUMN_SUSPRO_QUESTION15, suspro_question15);
        values.put(COLUMN_SUSPRO_QUESTION16, suspro_question16);
        values.put(COLUMN_SUSPRO_QUESTION17, suspro_question17);
        values.put(COLUMN_SUSPRO_QUESTION18, suspro_question18);
        values.put(COLUMN_SUSPRO_QUESTION19, suspro_question19);
        values.put(COLUMN_SUSPRO_QUESTION20, suspro_question20);
        values.put(COLUMN_SUSPRO_QUESTION21, suspro_question21);
        values.put(COLUMN_SUSPRO_QUESTION22, suspro_question22);
        values.put(COLUMN_SUSPRO_QUESTION23, suspro_question23);
        values.put(COLUMN_SUSPRO_QUESTION24, suspro_question24);
        values.put(COLUMN_SUSPRO_QUESTION25, suspro_question25);
        values.put(COLUMN_SIGNATURE, signaturePath);
        values.put(COLUMN_IS_SYNC, is_sync);
        values.put(COLUMN_IS_DRAFT, is_draft);
        values.put(COLUMN_USER_FNAME, userFname);
        values.put(COLUMN_USER_LNAME, userLname);
        values.put(COLUMN_USER_EMAIL, user_email);
        values.put(COLUMN_ON_UPDATE, onUpdate);

        // Check if record exists (by farmer_id)
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_FARMER_ID + "=?", new String[]{farmer_id}, null, null, null);

        boolean success;
        if (cursor != null && cursor.moveToFirst()) {
            // Update existing
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
            cursor.close();
            values.put(COLUMN_ON_CREATE, cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ON_CREATE)));
            int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_FARMER_ID + " = ?", new String[]{farmer_id});
            success = rowsUpdated > 0;
        } else {
            // Insert new
            values.put(COLUMN_ON_CREATE, onCreate);
            long result = db.insert(TABLE_NAME, null, values);
            success = result != -1;
            if (cursor != null) cursor.close();
        }

        db.close();
        return success;
    }

    private String saveSignatureImage(String signatureBase64) throws IOException {
        if (signatureBase64 == null || !signatureBase64.startsWith("data:image") || !signatureBase64.contains(",")) {
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

            // Create profiling-signature" directory
            File directory = new File(parentDirectory, "susprofiling-signature");
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException("Failed to create susprofiling directory");
            }

            File signatureFile = new File(directory, "susprofiling_" + System.currentTimeMillis() + ".png");
            try (FileOutputStream fos = new FileOutputStream(signatureFile)) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            }

            Log.d("SusProfilingDbHelper", "Signature saved at: " + signatureFile.getAbsolutePath());
            return signatureFile.getAbsolutePath();
        } catch (Exception e) {
            Log.e("SusProfilingDbHelper", "Error saving signature image", e);
            throw new IOException("Failed to save image: " + e.getMessage());
        }
    }

    public boolean updateSusProfiling(String id, String farmer_id, String farmer_name, String farmer_gender, String district, String community,
                                    String farmer_dob, String ghana_card, String suspro_question1, String suspro_question2, String suspro_question3,
                                    String suspro_question4, String suspro_question5, String suspro_question6, String suspro_question7,
                                    String suspro_question8, String suspro_question9, String suspro_question10, String suspro_question11,
                                    String suspro_question12, String suspro_question13, String suspro_question14, String suspro_question15,
                                    String suspro_question16, String suspro_question17, String suspro_question18, String suspro_question19,
                                    String suspro_question20, String suspro_question21, String suspro_question22, String suspro_question23,
                                    String suspro_question24, String suspro_question25, String signature, String is_sync, String is_draft) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FARMER_ID, farmer_id);
        values.put(COLUMN_FARMER_NAME, farmer_name);
        values.put(COLUMN_FARMER_GENDER, farmer_gender);
        values.put(COLUMN_DISTRICT, district);
        values.put(COLUMN_COMMUNITY, community);
        values.put(COLUMN_FARMER_DOB, farmer_dob);
        values.put(COLUMN_GHANA_CARD, ghana_card);
        values.put(COLUMN_SUSPRO_QUESTION1, suspro_question1);
        values.put(COLUMN_SUSPRO_QUESTION2, suspro_question2);
        values.put(COLUMN_SUSPRO_QUESTION3, suspro_question3);
        values.put(COLUMN_SUSPRO_QUESTION4, suspro_question4);
        values.put(COLUMN_SUSPRO_QUESTION5, suspro_question5);
        values.put(COLUMN_SUSPRO_QUESTION6, suspro_question6);
        values.put(COLUMN_SUSPRO_QUESTION7, suspro_question7);
        values.put(COLUMN_SUSPRO_QUESTION8, suspro_question8);
        values.put(COLUMN_SUSPRO_QUESTION9, suspro_question9);
        values.put(COLUMN_SUSPRO_QUESTION10, suspro_question10);
        values.put(COLUMN_SUSPRO_QUESTION11, suspro_question11);
        values.put(COLUMN_SUSPRO_QUESTION12, suspro_question12);
        values.put(COLUMN_SUSPRO_QUESTION13, suspro_question13);
        values.put(COLUMN_SUSPRO_QUESTION14, suspro_question14);
        values.put(COLUMN_SUSPRO_QUESTION15, suspro_question15);
        values.put(COLUMN_SUSPRO_QUESTION16, suspro_question16);
        values.put(COLUMN_SUSPRO_QUESTION17, suspro_question17);
        values.put(COLUMN_SUSPRO_QUESTION18, suspro_question18);
        values.put(COLUMN_SUSPRO_QUESTION19, suspro_question19);
        values.put(COLUMN_SUSPRO_QUESTION20, suspro_question20);
        values.put(COLUMN_SUSPRO_QUESTION21, suspro_question21);
        values.put(COLUMN_SUSPRO_QUESTION22, suspro_question22);
        values.put(COLUMN_SUSPRO_QUESTION23, suspro_question23);
        values.put(COLUMN_SUSPRO_QUESTION24, suspro_question24);
        values.put(COLUMN_SUSPRO_QUESTION25, suspro_question25);
        values.put(COLUMN_IS_SYNC, is_sync);
        values.put(COLUMN_IS_DRAFT, is_draft);
        values.put(COLUMN_ON_UPDATE, System.currentTimeMillis());

        String signaturePath = signature;

        // Detect if signature is new base64 image or existing path
        if (signature != null && signature.startsWith("data:image")) {
            try {
                signaturePath = saveSignatureImage(signature);
            } catch (IOException e) {
                Log.e("SusProfilingDbHelper", "Error saving signature image on update", e);
                // Keep old value if fails
            }
        } else if (signature == null || signature.isEmpty()) {
            // If blank, keep old signature path (read it from DB)
            signaturePath = getCurrentSignaturePath(id);
        }
        values.put(COLUMN_SIGNATURE, signaturePath);

        int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{id});
        db.close();
        return rowsUpdated > 0;
    }

    // Helper to get the current signature file path for this record (by id)
    private String getCurrentSignaturePath(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String currentSignature = null;
        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_SIGNATURE},
                COLUMN_ID + " = ?", new String[]{id}, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                currentSignature = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SIGNATURE));
            }
            cursor.close();
        }
        return currentSignature;
    }

    public Cursor getSusProfilingSurveyData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public List<SusProfilingModel> getAllSusProfiling() {
        List<SusProfilingModel> surveyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String farmer_id = cursor.getString(cursor.getColumnIndexOrThrow("farmer_id"));
                String farmer_name = cursor.getString(cursor.getColumnIndexOrThrow("farmer_name"));
                String farmer_gender = cursor.getString(cursor.getColumnIndexOrThrow("farmer_gender"));
                String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
                String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
                String farmer_dob = cursor.getString(cursor.getColumnIndexOrThrow("farmer_dob"));
                String ghana_card = cursor.getString(cursor.getColumnIndexOrThrow("ghana_card"));
                String suspro_question1 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question1"));
                String suspro_question2 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question2"));
                String suspro_question3 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question3"));
                String suspro_question4 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question4"));
                String suspro_question5 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question5"));
                String suspro_question6 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question6"));
                String suspro_question7 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question7"));
                String suspro_question8 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question8"));
                String suspro_question9 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question9"));
                String suspro_question10 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question10"));
                String suspro_question11 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question11"));
                String suspro_question12 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question12"));
                String suspro_question13 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question13"));
                String suspro_question14 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question14"));
                String suspro_question15 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question15"));
                String suspro_question16 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question16"));
                String suspro_question17 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question17"));
                String suspro_question18 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question18"));
                String suspro_question19 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question19"));
                String suspro_question20 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question20"));
                String suspro_question21 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question21"));
                String suspro_question22 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question22"));
                String suspro_question23 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question23"));
                String suspro_question24 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question24"));
                String suspro_question25 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question25"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String is_sync = cursor.getString(cursor.getColumnIndexOrThrow("is_sync"));
                String is_draft = cursor.getString(cursor.getColumnIndexOrThrow("is_draft"));
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                SusProfilingModel model = new SusProfilingModel( id, farmer_id, farmer_name, farmer_gender,
                        district, community, farmer_dob, ghana_card, suspro_question1, suspro_question2,
                        suspro_question3, suspro_question4, suspro_question5, suspro_question6, suspro_question7,
                        suspro_question8, suspro_question9, suspro_question10, suspro_question11, suspro_question12,
                        suspro_question13, suspro_question14, suspro_question15, suspro_question16, suspro_question17,
                        suspro_question18, suspro_question19, suspro_question20, suspro_question21, suspro_question22,
                        suspro_question23, suspro_question24, suspro_question25, signature, is_sync, is_draft,
                        userFname, userLname, user_email, onCreate, onUpdate
                );

                surveyList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return surveyList;
    }

    public SusProfilingModel getSurveyDetailsBySusProfilingName(String farmer_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        SusProfilingModel susProfilingModel = null;

        Cursor cursor = db.query(
                "SusProfilingTbl",
                null,
                "farmer_id = ?",
                new String[]{farmer_id},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String farmer_name = cursor.getString(cursor.getColumnIndexOrThrow("farmer_name"));
            String farmer_gender = cursor.getString(cursor.getColumnIndexOrThrow("farmer_gender"));
            String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
            String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
            String farmer_dob = cursor.getString(cursor.getColumnIndexOrThrow("farmer_dob"));
            String ghana_card = cursor.getString(cursor.getColumnIndexOrThrow("ghana_card"));
            String suspro_question1 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question1"));
            String suspro_question2 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question2"));
            String suspro_question3 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question3"));
            String suspro_question4 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question4"));
            String suspro_question5 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question5"));
            String suspro_question6 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question6"));
            String suspro_question7 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question7"));
            String suspro_question8 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question8"));
            String suspro_question9 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question9"));
            String suspro_question10 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question10"));
            String suspro_question11 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question11"));
            String suspro_question12 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question12"));
            String suspro_question13 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question13"));
            String suspro_question14 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question14"));
            String suspro_question15 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question15"));
            String suspro_question16 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question16"));
            String suspro_question17 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question17"));
            String suspro_question18 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question18"));
            String suspro_question19 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question19"));
            String suspro_question20 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question20"));
            String suspro_question21 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question21"));
            String suspro_question22 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question22"));
            String suspro_question23 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question23"));
            String suspro_question24 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question24"));
            String suspro_question25 = cursor.getString(cursor.getColumnIndexOrThrow("suspro_question25"));
            String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
            String is_sync = cursor.getString(cursor.getColumnIndexOrThrow("is_sync"));
            String is_draft = cursor.getString(cursor.getColumnIndexOrThrow("is_draft"));
            String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
            String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
            String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
            String on_create = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
            String on_update = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

            susProfilingModel = new SusProfilingModel(id, farmer_id, farmer_name, farmer_gender, district, community, farmer_dob, ghana_card,
                    suspro_question1, suspro_question2, suspro_question3, suspro_question4, suspro_question5, suspro_question6, suspro_question7,
                    suspro_question8, suspro_question9, suspro_question10, suspro_question11, suspro_question12, suspro_question13, suspro_question14,
                    suspro_question15, suspro_question16, suspro_question17, suspro_question18, suspro_question19, suspro_question20, suspro_question21,
                    suspro_question22, suspro_question23, suspro_question24, suspro_question25, signature, is_sync, is_draft, userFname, userLname, 
                    user_email, on_create, on_update);
            cursor.close();
        }
        return susProfilingModel;
    }

    public List<SusProfilingModel> getUnsyncedSusProfiling() {
        List<SusProfilingModel> unsyncedList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SusProfilingTbl WHERE is_sync = '0'", null);
        while (cursor.moveToNext()) {
            unsyncedList.add(SusProfilingModel.fromCursor(cursor));
        }
        cursor.close();
        db.close();
        return unsyncedList;
    }

    // Mark one as synced
    public void markAsSynced(String farmer_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("is_sync", "1");
        db.update("SusProfilingTbl", values, "farmer_id = ?", new String[]{farmer_id});
        db.close();
    }

    // (Optional) Mark multiple as synced in a batch
    public void markBatchAsSynced(List<SusProfilingModel> susprofiling) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (SusProfilingModel inspection : susprofiling) {
            ContentValues values = new ContentValues();
            values.put("is_sync", "1");
            db.update("SusProfilingTbl", values, "farmer_id = ?", new String[]{inspection.getFarmer_id()});
        }
        db.close();
    }
}
