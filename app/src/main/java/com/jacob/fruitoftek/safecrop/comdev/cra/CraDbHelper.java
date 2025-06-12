package com.jacob.fruitoftek.safecrop.comdev.cra;

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
import java.util.ArrayList;
import java.util.List;
import android.database.Cursor;

public class CraDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CraSurveyDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "CraSurveyTbl";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CRAQUESTION1 = "craquestion1";
    private static final String COLUMN_CRAQUESTION2 = "craquestion2";
    private static final String COLUMN_CRAQUESTION3 = "craquestion3";
    private static final String COLUMN_CRAQUESTION4 = "craquestion4";
    private static final String COLUMN_CRAQUESTION5 = "craquestion5";
    private static final String COLUMN_CRAQUESTION6 = "craquestion6";
    private static final String COLUMN_CRAQUESTION7 = "craquestion7";
    private static final String COLUMN_CRAQUESTION8 = "craquestion8";
    private static final String COLUMN_CRAQUESTION9 = "craquestion9";
    private static final String COLUMN_CRAQUESTION10 = "craquestion10";
    private static final String COLUMN_CRAQUESTION11 = "craquestion11";
    private static final String COLUMN_CRAQUESTION12 = "craquestion12";
    private static final String COLUMN_CRAQUESTION13 = "craquestion13";
    private static final String COLUMN_CRA_LOCATION = "cra_location";
    private static final String COLUMN_SIGNATURE = "signature";
    private static final String COLUMN_USER_FNAME = "user_fname";
    private static final String COLUMN_USER_LNAME = "user_lname";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_ON_CREATE = "on_create";
    private static final String COLUMN_ON_UPDATE = "on_update";

    private Context context;

    public CraDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_CRAQUESTION1 + " TEXT,"
                + COLUMN_CRAQUESTION2 + " TEXT,"
                + COLUMN_CRAQUESTION3 + " TEXT,"
                + COLUMN_CRAQUESTION4 + " TEXT,"
                + COLUMN_CRAQUESTION5 + " TEXT,"
                + COLUMN_CRAQUESTION6 + " TEXT,"
                + COLUMN_CRAQUESTION7 + " TEXT,"
                + COLUMN_CRAQUESTION8 + " TEXT,"
                + COLUMN_CRAQUESTION9 + " TEXT,"
                + COLUMN_CRAQUESTION10 + " TEXT,"
                + COLUMN_CRAQUESTION11 + " TEXT,"
                + COLUMN_CRAQUESTION12 + " TEXT,"
                + COLUMN_CRAQUESTION13 + " TEXT,"
                + COLUMN_CRA_LOCATION + " TEXT,"
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

    public boolean insertCra(String craquestion1, String craquestion2, String craquestion3, String craquestion4,
                             String craquestion5, String craquestion6, String craquestion7, String craquestion8,
                             String craquestion9, String craquestion10, String craquestion11, String craquestion12,
                             String craquestion13, String cra_location, String signatureBase64, String userFname,
                             String userLname, String userEmail, String onCreate, String onUpdate) {
        String signaturePath = null;
        try {
            signaturePath = saveSignatureImage(signatureBase64);
        } catch (IOException e) {
            Log.e("CraDbHelper", "Error saving signature image", e);
            return false; // Return false if signature saving fails
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CRAQUESTION1, craquestion1);
        values.put(COLUMN_CRAQUESTION2, craquestion2);
        values.put(COLUMN_CRAQUESTION3, craquestion3);
        values.put(COLUMN_CRAQUESTION4, craquestion4);
        values.put(COLUMN_CRAQUESTION5, craquestion5);
        values.put(COLUMN_CRAQUESTION6, craquestion6);
        values.put(COLUMN_CRAQUESTION7, craquestion7);
        values.put(COLUMN_CRAQUESTION8, craquestion8);
        values.put(COLUMN_CRAQUESTION9, craquestion9);
        values.put(COLUMN_CRAQUESTION10, craquestion10);
        values.put(COLUMN_CRAQUESTION11, craquestion11);
        values.put(COLUMN_CRAQUESTION12, craquestion12);
        values.put(COLUMN_CRAQUESTION13, craquestion13);
        values.put(COLUMN_CRA_LOCATION, cra_location);
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
            File directory = new File(parentDirectory, "cra-signature");
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException("Failed to create child directory");
            }

            File signatureFile = new File(directory, "cra_" + System.currentTimeMillis() + ".png");
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

    public boolean updateGra(String id, String craquestion1, String craquestion2, String craquestion3, 
                             String craquestion4, String craquestion5, String craquestion6, String craquestion7,
                             String craquestion8, String craquestion9, String craquestion10, String craquestion11,
                             String craquestion12, String craquestion13, String cra_location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CRAQUESTION1, craquestion1);
        values.put(COLUMN_CRAQUESTION2, craquestion2);
        values.put(COLUMN_CRAQUESTION3, craquestion3);
        values.put(COLUMN_CRAQUESTION4, craquestion4);
        values.put(COLUMN_CRAQUESTION5, craquestion5);
        values.put(COLUMN_CRAQUESTION6, craquestion6);
        values.put(COLUMN_CRAQUESTION7, craquestion7);
        values.put(COLUMN_CRAQUESTION8, craquestion8);
        values.put(COLUMN_CRAQUESTION9, craquestion9);
        values.put(COLUMN_CRAQUESTION10, craquestion10);
        values.put(COLUMN_CRAQUESTION11, craquestion11);
        values.put(COLUMN_CRAQUESTION12, craquestion12);
        values.put(COLUMN_CRAQUESTION13, craquestion13);
        values.put(COLUMN_CRA_LOCATION, cra_location);
        values.put(COLUMN_ON_UPDATE, System.currentTimeMillis());

        int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{id});
        db.close();

        return rowsUpdated > 0;
    }

    public Cursor getGraSurveyData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public List<CraModel> getAllGras() {
        List<CraModel> surveyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String craquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion1"));
                String craquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion2"));
                String craquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion3"));
                String craquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion4"));
                String craquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion5"));
                String craquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion6"));
                String craquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion7"));
                String craquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion8"));
                String craquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion9"));
                String craquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion10"));
                String craquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion11"));
                String craquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion12"));
                String craquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion13"));
                String cra_location = cursor.getString(cursor.getColumnIndexOrThrow("cra_location"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                CraModel model = new CraModel(
                        id, craquestion1, craquestion2, craquestion3, craquestion4, craquestion5, craquestion6,
                        craquestion7, craquestion8, craquestion9, craquestion10, craquestion11, craquestion12,
                        craquestion13, cra_location, signature, userFname, userLname, userEmail, onCreate, onUpdate
                );

                surveyList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return surveyList;
    }

    public CraModel getSurveyDetailsByGraName(String cra_name) {
        SQLiteDatabase db = this.getReadableDatabase();
        CraModel craModel = null;

        Cursor cursor = db.query(
                "CraSurveyTbl",
                null,
                "cra_name = ?",
                new String[]{cra_name},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String craquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion1"));
            String craquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion2"));
            String craquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion3"));
            String craquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion4"));
            String craquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion5"));
            String craquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion6"));
            String craquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion7"));
            String craquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion8"));
            String craquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion9"));
            String craquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion10"));
            String craquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion11"));
            String craquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion12"));
            String craquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("craquestion13"));
            String cra_location = cursor.getString(cursor.getColumnIndexOrThrow("cra_location"));
            String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
            String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
            String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
            String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
            String on_create = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
            String on_update = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

            craModel = new CraModel(id, craquestion1, craquestion2, craquestion3, craquestion4, craquestion5,
                    craquestion6, craquestion7, craquestion8, craquestion9, craquestion10, craquestion11, craquestion12,
                    craquestion13, cra_location, signature, userFname, userLname, userEmail, on_create, on_update);
            cursor.close();
        }
        return craModel;
    }
}
