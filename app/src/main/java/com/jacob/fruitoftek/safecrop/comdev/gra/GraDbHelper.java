package com.jacob.fruitoftek.safecrop.comdev.gra;

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

public class GraDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GraSurveyDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "GraSurveyTbl";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_GRAQUESTION1 = "graquestion1";
    private static final String COLUMN_GRAQUESTION2 = "graquestion2";
    private static final String COLUMN_GRAQUESTION3 = "graquestion3";
    private static final String COLUMN_GRAQUESTION4 = "graquestion4";
    private static final String COLUMN_GRAQUESTION5 = "graquestion5";
    private static final String COLUMN_GRAQUESTION6 = "graquestion6";
    private static final String COLUMN_GRAQUESTION7 = "graquestion7";
    private static final String COLUMN_GRAQUESTION8 = "graquestion8";
    private static final String COLUMN_GRA_LOCATION = "gra_location";
    private static final String COLUMN_FARMER_PHOTO = "farmer_photo";
    private static final String COLUMN_SIGNATURE = "signature";
    private static final String COLUMN_USER_FNAME = "user_fname";
    private static final String COLUMN_USER_LNAME = "user_lname";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_ON_CREATE = "on_create";
    private static final String COLUMN_ON_UPDATE = "on_update";

    private Context context;

    public GraDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_GRAQUESTION1 + " TEXT,"
                + COLUMN_GRAQUESTION2 + " TEXT,"
                + COLUMN_GRAQUESTION3 + " TEXT,"
                + COLUMN_GRAQUESTION4 + " TEXT,"
                + COLUMN_GRAQUESTION5 + " TEXT,"
                + COLUMN_GRAQUESTION6 + " TEXT,"
                + COLUMN_GRAQUESTION7 + " TEXT,"
                + COLUMN_GRAQUESTION8 + " TEXT,"
                + COLUMN_GRA_LOCATION + " TEXT,"
                + COLUMN_FARMER_PHOTO + " TEXT,"
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

    public boolean insertGra(String graquestion1, String graquestion2, String graquestion3,
                                String graquestion4, String graquestion5, String graquestion6, 
                                String graquestion7, String graquestion8, String gra_location,
                                String farmer_photo, String signatureBase64, String userFname, 
                             String userLname, String userEmail, String onCreate, String onUpdate) {
        String signaturePath = null;
        try {
            signaturePath = saveSignatureImage(signatureBase64);
        } catch (IOException e) {
            Log.e("GraDbHelper", "Error saving signature image", e);
            return false; // Return false if signature saving fails
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_GRAQUESTION1, graquestion1);
        values.put(COLUMN_GRAQUESTION2, graquestion2);
        values.put(COLUMN_GRAQUESTION3, graquestion3);
        values.put(COLUMN_GRAQUESTION4, graquestion4);
        values.put(COLUMN_GRAQUESTION5, graquestion5);
        values.put(COLUMN_GRAQUESTION6, graquestion6);
        values.put(COLUMN_GRAQUESTION7, graquestion7);
        values.put(COLUMN_GRAQUESTION8, graquestion8);
        values.put(COLUMN_GRA_LOCATION, gra_location);
        values.put(COLUMN_FARMER_PHOTO, farmer_photo);
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
            File directory = new File(parentDirectory, "gra-signature");
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException("Failed to create child directory");
            }

            File signatureFile = new File(directory, "gra_" + System.currentTimeMillis() + ".png");
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

    public boolean updateGra(String id, String graquestion1, String graquestion2, String graquestion3,
                             String graquestion4, String graquestion5, String graquestion6, 
                             String graquestion7, String graquestion8, String gra_location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_GRAQUESTION1, graquestion1);
        values.put(COLUMN_GRAQUESTION2, graquestion2);
        values.put(COLUMN_GRAQUESTION3, graquestion3);
        values.put(COLUMN_GRAQUESTION4, graquestion4);
        values.put(COLUMN_GRAQUESTION5, graquestion5);
        values.put(COLUMN_GRAQUESTION6, graquestion6);
        values.put(COLUMN_GRAQUESTION7, graquestion7);
        values.put(COLUMN_GRAQUESTION8, graquestion8);
        values.put(COLUMN_GRA_LOCATION, gra_location);
        values.put(COLUMN_ON_UPDATE, System.currentTimeMillis());

        int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{id});
        db.close();

        return rowsUpdated > 0;
    }

    public Cursor getGraSurveyData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public List<GraModel> getAllGras() {
        List<GraModel> surveyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String graquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion1"));
                String graquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion2"));
                String graquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion3"));
                String graquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion4"));
                String graquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion5"));
                String graquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion6"));
                String graquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion7"));
                String graquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion8"));
                String gra_location = cursor.getString(cursor.getColumnIndexOrThrow("gra_location"));
                String farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                GraModel model = new GraModel(
                        id, graquestion1, graquestion2, graquestion3, graquestion4, graquestion5,
                        graquestion6, graquestion7, graquestion8,
                        gra_location, farmer_photo != null ? Uri.parse(farmer_photo) : null,
                        signature, userFname, userLname, userEmail, onCreate, onUpdate
                );

                surveyList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return surveyList;
    }

    public GraModel getSurveyDetailsByGraName(String graquestion1) {
        SQLiteDatabase db = this.getReadableDatabase();
        GraModel graModel = null;

        Cursor cursor = db.query(
                "GraSurveyTbl",
                null,
                "graquestion1 = ?",
                new String[]{graquestion1},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String graquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion2"));
            String graquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion3"));
            String graquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion4"));
            String graquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion5"));
            String graquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion6"));
            String graquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion7"));
            String graquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("graquestion8"));
            String gra_location = cursor.getString(cursor.getColumnIndexOrThrow("gra_location"));
            Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                    ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                    : null;
            String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
            String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
            String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
            String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
            String on_create = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
            String on_update = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

            graModel = new GraModel(id, graquestion1, graquestion2, graquestion3, graquestion4, graquestion5,
                    graquestion6, graquestion7, graquestion8, gra_location, farmer_photo, signature, userFname,
                    userLname, userEmail, on_create, on_update);
            cursor.close();
        }
        return graModel;
    }
}
