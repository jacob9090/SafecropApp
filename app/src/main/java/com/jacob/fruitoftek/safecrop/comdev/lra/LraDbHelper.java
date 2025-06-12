package com.jacob.fruitoftek.safecrop.comdev.lra;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class LraDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "LraSurveyDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "LraSurveyTbl";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_LRAQUESTION1 = "lraquestion1";
    private static final String COLUMN_LRAQUESTION2 = "lraquestion2";
    private static final String COLUMN_LRAQUESTION3 = "lraquestion3";
    private static final String COLUMN_LRAQUESTION4 = "lraquestion4";
    private static final String COLUMN_LRAQUESTION5 = "lraquestion5";
    private static final String COLUMN_LRAQUESTION6 = "lraquestion6";
    private static final String COLUMN_LRAQUESTION7 = "lraquestion7";
    private static final String COLUMN_LRAQUESTION8 = "lraquestion8";
    private static final String COLUMN_LRAQUESTION9 = "lraquestion9";
    private static final String COLUMN_LRAQUESTION10 = "lraquestion10";
    private static final String COLUMN_LRA_LOCATION = "lra_location";
    private static final String COLUMN_SIGNATURE = "signature";
    private static final String COLUMN_USER_FNAME = "user_fname";
    private static final String COLUMN_USER_LNAME = "user_lname";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_ON_CREATE = "on_create";
    private static final String COLUMN_ON_UPDATE = "on_update";

    private Context context;

    public LraDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_LRAQUESTION1 + " TEXT,"
                + COLUMN_LRAQUESTION2 + " TEXT,"
                + COLUMN_LRAQUESTION3 + " TEXT,"
                + COLUMN_LRAQUESTION4 + " TEXT,"
                + COLUMN_LRAQUESTION5 + " TEXT,"
                + COLUMN_LRAQUESTION6 + " TEXT,"
                + COLUMN_LRAQUESTION7 + " TEXT,"
                + COLUMN_LRAQUESTION8 + " TEXT,"
                + COLUMN_LRAQUESTION9 + " TEXT,"
                + COLUMN_LRAQUESTION10 + " TEXT,"
                + COLUMN_LRA_LOCATION + " TEXT,"
                + COLUMN_SIGNATURE + " TEXT,"
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

    public boolean insertLra(String lraquestion1, String lraquestion2, String lraquestion3, String lraquestion4,
                             String lraquestion5, String lraquestion6, String lraquestion7, String lraquestion8,
                             String lra_location, String signatureBase64, String userFname,
                             String userLname, String userEmail, String onCreate, String onUpdate) {
        String signaturePath = null;
        try {
            signaturePath = saveSignatureImage(signatureBase64);
        } catch (IOException e) {
            Log.e("LraDbHelper", "Error saving signature image", e);
            return false; // Return false if signature saving fails
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LRAQUESTION1, lraquestion1);
        values.put(COLUMN_LRAQUESTION2, lraquestion2);
        values.put(COLUMN_LRAQUESTION3, lraquestion3);
        values.put(COLUMN_LRAQUESTION4, lraquestion4);
        values.put(COLUMN_LRAQUESTION5, lraquestion5);
        values.put(COLUMN_LRAQUESTION6, lraquestion6);
        values.put(COLUMN_LRAQUESTION7, lraquestion7);
        values.put(COLUMN_LRAQUESTION8, lraquestion8);
        values.put(COLUMN_LRA_LOCATION, lra_location);
        values.put(COLUMN_SIGNATURE, signaturePath);
        values.put(COLUMN_USER_FNAME, userFname);
        values.put(COLUMN_USER_LNAME, userLname);
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
            File directory = new File(parentDirectory, "lra-signature");
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException("Failed to create child directory");
            }

            File signatureFile = new File(directory, "lra_" + System.currentTimeMillis() + ".png");
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

    public boolean updateLra(String id, String lraquestion1, String lraquestion2, String lraquestion3,
                             String lraquestion4, String lraquestion5, String lraquestion6,
                             String lraquestion7, String lraquestion8, String lraquestion9,
                             String lraquestion10, String lra_location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LRAQUESTION1, lraquestion1);
        values.put(COLUMN_LRAQUESTION2, lraquestion2);
        values.put(COLUMN_LRAQUESTION3, lraquestion3);
        values.put(COLUMN_LRAQUESTION4, lraquestion4);
        values.put(COLUMN_LRAQUESTION5, lraquestion5);
        values.put(COLUMN_LRAQUESTION6, lraquestion6);
        values.put(COLUMN_LRAQUESTION7, lraquestion7);
        values.put(COLUMN_LRAQUESTION8, lraquestion8);
        values.put(COLUMN_LRAQUESTION9, lraquestion9);
        values.put(COLUMN_LRAQUESTION10, lraquestion10);
        values.put(COLUMN_LRA_LOCATION, lra_location);
        values.put(COLUMN_ON_UPDATE, System.currentTimeMillis());

        int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{id});
        db.close();

        return rowsUpdated > 0;
    }

    public Cursor getLraSurveyData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public List<LraModel> getAllLras() {
        List<LraModel> surveyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String lraquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion1"));
                String lraquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion2"));
                String lraquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion3"));
                String lraquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion4"));
                String lraquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion5"));
                String lraquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion6"));
                String lraquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion7"));
                String lraquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion8"));
                String lraquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion9"));
                String lraquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion10"));
                String lra_location = cursor.getString(cursor.getColumnIndexOrThrow("lra_location"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                LraModel model = new LraModel(
                        id, lraquestion1, lraquestion2, lraquestion3, lraquestion4, lraquestion5,
                        lraquestion6, lraquestion7, lraquestion8, lraquestion9, lraquestion10,
                        lra_location, signature, userFname, userLname, userEmail, onCreate, onUpdate
                );

                surveyList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return surveyList;
    }

    public LraModel getSurveyDetailsByLraName(String lraquestion1) {
        SQLiteDatabase db = this.getReadableDatabase();
        LraModel LraModel = null;

        Cursor cursor = db.query(
                "LraSurveyTbl",
                null,
                "lraquestion1 = ?",
                new String[]{lraquestion1},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String lraquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion2"));
            String lraquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion3"));
            String lraquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion4"));
            String lraquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion5"));
            String lraquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion6"));
            String lraquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion7"));
            String lraquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion8"));
            String lraquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion9"));
            String lraquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("lraquestion10"));
            String lra_location = cursor.getString(cursor.getColumnIndexOrThrow("lra_location"));
            String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
            String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
            String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
            String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
            String on_create = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
            String on_update = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

            LraModel = new LraModel(id, lraquestion1, lraquestion2, lraquestion3, lraquestion4, lraquestion5,
                    lraquestion6, lraquestion7, lraquestion8, lraquestion9, lraquestion10, lra_location,
                    signature, userFname, userLname, userEmail, on_create, on_update);
            cursor.close();
        }
        return LraModel;
    }
}
