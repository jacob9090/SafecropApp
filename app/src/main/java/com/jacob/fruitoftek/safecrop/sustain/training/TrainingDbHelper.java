package com.jacob.fruitoftek.safecrop.sustain.training;

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

public class TrainingDbHelper extends SQLiteOpenHelper {
    
    private static final String DATABASE_NAME = "TrainingDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "TrainingTbl";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TRAINING_CODE = "training_code";
    private static final String COLUMN_DISTRICT = "district";
    private static final String COLUMN_COMMUNITY = "community";
    private static final String COLUMN_TRAIN_QUESTION1 = "training_question1";
    private static final String COLUMN_TRAIN_QUESTION2 = "training_question2";
    private static final String COLUMN_TRAIN_QUESTION3 = "training_question3";
    private static final String COLUMN_TRAIN_QUESTION4 = "training_question4";
    private static final String COLUMN_TRAIN_QUESTION5 = "training_question5";
    private static final String COLUMN_TRAIN_QUESTION6 = "training_question6";
    private static final String COLUMN_TRAIN_QUESTION7 = "training_question7";
    private static final String COLUMN_TRAIN_QUESTION8 = "training_question8";
    private static final String COLUMN_TRAIN_QUESTION9 = "training_question9";
    private static final String COLUMN_TRAIN_QUESTION10 = "training_question10";
    private static final String COLUMN_TRAIN_QUESTION11 = "training_question11";
    private static final String COLUMN_TRAIN_QUESTION12 = "training_question12";
    private static final String COLUMN_TRAIN_QUESTION13 = "training_question13";
    private static final String COLUMN_TRAIN_QUESTION14 = "training_question14";
    private static final String COLUMN_TRAIN_QUESTION15 = "training_question15";
    private static final String COLUMN_TRAINING_LOCATION = "training_location";
    private static final String COLUMN_FARMER_PHOTO = "farmer_photo";
    private static final String COLUMN_SIGNATURE = "signature";
    private static final String COLUMN_IS_SYNC = "is_sync";
    private static final String COLUMN_IS_DRAFT = "is_draft";
    private static final String COLUMN_USER_FNAME = "user_fname";
    private static final String COLUMN_USER_LNAME = "user_lname";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_ON_CREATE = "on_create";
    private static final String COLUMN_ON_UPDATE = "on_update";

    private Context context;

    public TrainingDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_TRAINING_CODE + " TEXT,"
                + COLUMN_DISTRICT + " TEXT,"
                + COLUMN_COMMUNITY + " TEXT,"
                + COLUMN_TRAIN_QUESTION1 + " TEXT,"
                + COLUMN_TRAIN_QUESTION2 + " TEXT,"
                + COLUMN_TRAIN_QUESTION3 + " TEXT,"
                + COLUMN_TRAIN_QUESTION4 + " TEXT,"
                + COLUMN_TRAIN_QUESTION5 + " TEXT,"
                + COLUMN_TRAIN_QUESTION6 + " TEXT,"
                + COLUMN_TRAIN_QUESTION7 + " TEXT,"
                + COLUMN_TRAIN_QUESTION8 + " TEXT,"
                + COLUMN_TRAIN_QUESTION9 + " TEXT,"
                + COLUMN_TRAIN_QUESTION10 + " TEXT,"
                + COLUMN_TRAIN_QUESTION11 + " TEXT,"
                + COLUMN_TRAIN_QUESTION12 + " TEXT,"
                + COLUMN_TRAIN_QUESTION13 + " TEXT,"
                + COLUMN_TRAIN_QUESTION14 + " TEXT,"
                + COLUMN_TRAIN_QUESTION15 + " TEXT,"
                + COLUMN_TRAINING_LOCATION + " TEXT,"
                + COLUMN_FARMER_PHOTO + " TEXT,"
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

    public boolean insertOrUpdateTraining(String training_code, String district, String community,
                                          String training_question1, String training_question2, String training_question3, 
                                          String training_question4, String training_question5, String training_question6, 
                                          String training_question7, String training_question8, String training_question9,
                                          String training_question10, String training_question11, String training_question12, 
                                          String training_question13, String training_question14, String training_question15,
                                          String training_location, String farmer_photo, String signatureBase64, String is_sync,
                                          String is_draft, String userFname, String userLname, String user_email,
                                          String onCreate, String onUpdate) {

        String signaturePath = null;
        if (signatureBase64 != null && signatureBase64.startsWith("data:image")) {
            try {
                signaturePath = saveSignatureImage(signatureBase64);
            } catch (IOException e) {
                Log.e("TrainingDbHelper", "Error saving signature image", e);
                return false; // Signature failed to save
            }
        } else if (signatureBase64 != null && !signatureBase64.isEmpty()) {
            // If it's an existing path (from update), use as is
            signaturePath = signatureBase64;
        }

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TRAINING_CODE, training_code);
        values.put(COLUMN_DISTRICT, district);
        values.put(COLUMN_COMMUNITY, community);
        values.put(COLUMN_TRAIN_QUESTION1, training_question1);
        values.put(COLUMN_TRAIN_QUESTION2, training_question2);
        values.put(COLUMN_TRAIN_QUESTION3, training_question3);
        values.put(COLUMN_TRAIN_QUESTION4, training_question4);
        values.put(COLUMN_TRAIN_QUESTION5, training_question5);
        values.put(COLUMN_TRAIN_QUESTION6, training_question6);
        values.put(COLUMN_TRAIN_QUESTION7, training_question7);
        values.put(COLUMN_TRAIN_QUESTION8, training_question8);
        values.put(COLUMN_TRAIN_QUESTION9, training_question9);
        values.put(COLUMN_TRAIN_QUESTION10, training_question10);
        values.put(COLUMN_TRAIN_QUESTION11, training_question11);
        values.put(COLUMN_TRAIN_QUESTION12, training_question12);
        values.put(COLUMN_TRAIN_QUESTION13, training_question13);
        values.put(COLUMN_TRAIN_QUESTION14, training_question14);
        values.put(COLUMN_TRAIN_QUESTION15, training_question15);
        values.put(COLUMN_TRAINING_LOCATION, training_location);
        values.put(COLUMN_FARMER_PHOTO, farmer_photo);
        values.put(COLUMN_SIGNATURE, signaturePath);
        values.put(COLUMN_IS_SYNC, is_sync);
        values.put(COLUMN_IS_DRAFT, is_draft);
        values.put(COLUMN_USER_FNAME, userFname);
        values.put(COLUMN_USER_LNAME, userLname);
        values.put(COLUMN_USER_EMAIL, user_email);
        values.put(COLUMN_ON_UPDATE, onUpdate);

        // Check if record exists (by training_code)
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_TRAINING_CODE + "=?", new String[]{training_code}, null, null, null);

        boolean success;
        if (cursor != null && cursor.moveToFirst()) {
            // Update existing
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
            cursor.close();
            values.put(COLUMN_ON_CREATE, cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ON_CREATE)));
            int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_TRAINING_CODE + " = ?", new String[]{training_code});
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

            // Create training-signature" directory
            File directory = new File(parentDirectory, "training-signature");
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException("Failed to create training directory");
            }

            File signatureFile = new File(directory, "training_" + System.currentTimeMillis() + ".png");
            try (FileOutputStream fos = new FileOutputStream(signatureFile)) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            }

            Log.d("TrainingDbHelper", "Signature saved at: " + signatureFile.getAbsolutePath());
            return signatureFile.getAbsolutePath();
        } catch (Exception e) {
            Log.e("TrainingDbHelper", "Error saving signature image", e);
            throw new IOException("Failed to save image: " + e.getMessage());
        }
    }

    public boolean updateTraining(String id, String training_code, String district, String community,
                                    String training_question1, String training_question2, String training_question3, String training_question4,
                                    String training_question5, String training_question6, String training_question7, String training_question8,
                                    String training_question9, String training_question10, String training_question11, String training_question12,
                                    String training_question13, String training_question14, String training_question15, String training_location,
                                    String farmer_photo, String signature, String is_sync, String is_draft) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TRAINING_CODE, training_code);
        values.put(COLUMN_DISTRICT, district);
        values.put(COLUMN_COMMUNITY, community);
        values.put(COLUMN_TRAIN_QUESTION1, training_question1);
        values.put(COLUMN_TRAIN_QUESTION2, training_question2);
        values.put(COLUMN_TRAIN_QUESTION3, training_question3);
        values.put(COLUMN_TRAIN_QUESTION4, training_question4);
        values.put(COLUMN_TRAIN_QUESTION5, training_question5);
        values.put(COLUMN_TRAIN_QUESTION6, training_question6);
        values.put(COLUMN_TRAIN_QUESTION7, training_question7);
        values.put(COLUMN_TRAIN_QUESTION8, training_question8);
        values.put(COLUMN_TRAIN_QUESTION9, training_question9);
        values.put(COLUMN_TRAIN_QUESTION10, training_question10);
        values.put(COLUMN_TRAIN_QUESTION11, training_question11);
        values.put(COLUMN_TRAIN_QUESTION12, training_question12);
        values.put(COLUMN_TRAIN_QUESTION13, training_question13);
        values.put(COLUMN_TRAIN_QUESTION14, training_question14);
        values.put(COLUMN_TRAIN_QUESTION15, training_question15);
        values.put(COLUMN_TRAINING_LOCATION, training_location);
        values.put(COLUMN_FARMER_PHOTO, farmer_photo);
        values.put(COLUMN_IS_SYNC, is_sync);
        values.put(COLUMN_IS_DRAFT, is_draft);
        values.put(COLUMN_ON_UPDATE, System.currentTimeMillis());

        String signaturePath = signature;

        // Detect if signature is new base64 image or existing path
        if (signature != null && signature.startsWith("data:image")) {
            try {
                signaturePath = saveSignatureImage(signature);
            } catch (IOException e) {
                Log.e("TrainingDbHelper", "Error saving signature image on update", e);
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

    public Cursor getInspectopnSurveyData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public List<TrainingModel> getAllTraining() {
        List<TrainingModel> surveyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String training_code = cursor.getString(cursor.getColumnIndexOrThrow("training_code"));
                String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
                String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
                String training_question1 = cursor.getString(cursor.getColumnIndexOrThrow("training_question1"));
                String training_question2 = cursor.getString(cursor.getColumnIndexOrThrow("training_question2"));
                String training_question3 = cursor.getString(cursor.getColumnIndexOrThrow("training_question3"));
                String training_question4 = cursor.getString(cursor.getColumnIndexOrThrow("training_question4"));
                String training_question5 = cursor.getString(cursor.getColumnIndexOrThrow("training_question5"));
                String training_question6 = cursor.getString(cursor.getColumnIndexOrThrow("training_question6"));
                String training_question7 = cursor.getString(cursor.getColumnIndexOrThrow("training_question7"));
                String training_question8 = cursor.getString(cursor.getColumnIndexOrThrow("training_question8"));
                String training_question9 = cursor.getString(cursor.getColumnIndexOrThrow("training_question9"));
                String training_question10 = cursor.getString(cursor.getColumnIndexOrThrow("training_question10"));
                String training_question11 = cursor.getString(cursor.getColumnIndexOrThrow("training_question11"));
                String training_question12 = cursor.getString(cursor.getColumnIndexOrThrow("training_question12"));
                String training_question13 = cursor.getString(cursor.getColumnIndexOrThrow("training_question13"));
                String training_question14 = cursor.getString(cursor.getColumnIndexOrThrow("training_question14"));
                String training_question15 = cursor.getString(cursor.getColumnIndexOrThrow("training_question15"));
                String training_location = cursor.getString(cursor.getColumnIndexOrThrow("training_location"));
                String farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String is_sync = cursor.getString(cursor.getColumnIndexOrThrow("is_sync"));
                String is_draft = cursor.getString(cursor.getColumnIndexOrThrow("is_draft"));
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                TrainingModel model = new TrainingModel( id, training_code, district, community,
                        training_question1, training_question2, training_question3, training_question4,
                        training_question5, training_question6, training_question7, training_question8,
                        training_question9, training_question10, training_question11, training_question12,
                        training_question13, training_question14, training_question15, training_location,
                        farmer_photo != null ? Uri.parse(farmer_photo) : null, signature,
                        is_sync, is_draft, userFname, userLname, user_email, onCreate, onUpdate
                );

                surveyList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return surveyList;
    }

    public TrainingModel getSurveyDetailsByTrainingName(String training_code) {
        SQLiteDatabase db = this.getReadableDatabase();
        TrainingModel trainingModel = null;

        Cursor cursor = db.query(
                "TrainingTbl",
                null,
                "training_code = ?",
                new String[]{training_code},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
            String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
            String training_question1 = cursor.getString(cursor.getColumnIndexOrThrow("training_question1"));
            String training_question2 = cursor.getString(cursor.getColumnIndexOrThrow("training_question2"));
            String training_question3 = cursor.getString(cursor.getColumnIndexOrThrow("training_question3"));
            String training_question4 = cursor.getString(cursor.getColumnIndexOrThrow("training_question4"));
            String training_question5 = cursor.getString(cursor.getColumnIndexOrThrow("training_question5"));
            String training_question6 = cursor.getString(cursor.getColumnIndexOrThrow("training_question6"));
            String training_question7 = cursor.getString(cursor.getColumnIndexOrThrow("training_question7"));
            String training_question8 = cursor.getString(cursor.getColumnIndexOrThrow("training_question8"));
            String training_question9 = cursor.getString(cursor.getColumnIndexOrThrow("training_question9"));
            String training_question10 = cursor.getString(cursor.getColumnIndexOrThrow("training_question10"));
            String training_question11 = cursor.getString(cursor.getColumnIndexOrThrow("training_question11"));
            String training_question12 = cursor.getString(cursor.getColumnIndexOrThrow("training_question12"));
            String training_question13 = cursor.getString(cursor.getColumnIndexOrThrow("training_question13"));
            String training_question14 = cursor.getString(cursor.getColumnIndexOrThrow("training_question14"));
            String training_question15 = cursor.getString(cursor.getColumnIndexOrThrow("training_question15"));
            String training_location = cursor.getString(cursor.getColumnIndexOrThrow("training_location"));
            Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                    ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                    : null;
            String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
            String is_sync = cursor.getString(cursor.getColumnIndexOrThrow("is_sync"));
            String is_draft = cursor.getString(cursor.getColumnIndexOrThrow("is_draft"));
            String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
            String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
            String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
            String on_create = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
            String on_update = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

            trainingModel = new TrainingModel(id, training_code, district, community, training_question1,
                    training_question2, training_question3, training_question4, training_question5, training_question6,
                    training_question7, training_question8, training_question9, training_question10, training_question11,
                    training_question12, training_question13, training_question14, training_question15, training_location,
                    farmer_photo, signature, is_sync, is_draft, userFname, userLname, user_email, on_create, on_update);
            cursor.close();
        }
        return trainingModel;
    }

    public List<TrainingModel> getUnsyncedTrainings() {
        List<TrainingModel> unsyncedList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TrainingTbl WHERE is_sync = '0'", null);
        while (cursor.moveToNext()) {
            unsyncedList.add(TrainingModel.fromCursor(cursor));
        }
        cursor.close();
        db.close();
        return unsyncedList;
    }

    // Mark one as synced
    public void markAsSynced(String training_code) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("is_sync", "1");
        db.update("TrainingTbl", values, "training_code = ?", new String[]{training_code});
        db.close();
    }

    // (Optional) Mark multiple as synced in a batch
    public void markBatchAsSynced(List<TrainingModel> trainings) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (TrainingModel training : trainings) {
            ContentValues values = new ContentValues();
            values.put("is_sync", "1");
            db.update("TrainingTbl", values, "training_code = ?", new String[]{training.getTraining_code()});
        }
        db.close();
    }
}
