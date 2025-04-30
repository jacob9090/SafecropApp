package com.jacob.fruitoftek.safecrop.comdev.com;

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

public class ComDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ComSurveyDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "ComSurveyTbl";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_COMMQUESTION1 = "commquestion1";
    private static final String COLUMN_COMMQUESTION2 = "commquestion2";
    private static final String COLUMN_COMMQUESTION3 = "commquestion3";
    private static final String COLUMN_COMMQUESTION4 = "commquestion4";
    private static final String COLUMN_COMMQUESTION5 = "commquestion5";
    private static final String COLUMN_COMMQUESTION6 = "commquestion6";
    private static final String COLUMN_COMMQUESTION7 = "commquestion7";
    private static final String COLUMN_COMMQUESTION8 = "commquestion8";
    private static final String COLUMN_COMMQUESTION9 = "commquestion9";
    private static final String COLUMN_COMMQUESTION10 = "commquestion10";
    private static final String COLUMN_COMMQUESTION11 = "commquestion11";
    private static final String COLUMN_COMMQUESTION12 = "commquestion12";
    private static final String COLUMN_COMMQUESTION13 = "commquestion13";
    private static final String COLUMN_COMMQUESTION14 = "commquestion14";
    private static final String COLUMN_COMMQUESTION15 = "commquestion15";
    private static final String COLUMN_COMMQUESTION16 = "commquestion16";
    private static final String COLUMN_COMMQUESTION17 = "commquestion17";
    private static final String COLUMN_COMMQUESTION18 = "commquestion18";
    private static final String COLUMN_COMMQUESTION19 = "commquestion19";
    private static final String COLUMN_COMMQUESTION20 = "commquestion20";
    private static final String COLUMN_COMMQUESTION21 = "commquestion21";
    private static final String COLUMN_COMMQUESTION22 = "commquestion22";
    private static final String COLUMN_COMMQUESTION23 = "commquestion23";
    private static final String COLUMN_COMMQUESTION24 = "commquestion24";
    private static final String COLUMN_COMMQUESTION25 = "commquestion25";
    private static final String COLUMN_COMMQUESTION26 = "commquestion26";
    private static final String COLUMN_COMMQUESTION27 = "commquestion27";
    private static final String COLUMN_COMMQUESTION28 = "commquestion28";
    private static final String COLUMN_COMMQUESTION29 = "commquestion29";
    private static final String COLUMN_COMMQUESTION30 = "commquestion30";
    private static final String COLUMN_COMMQUESTION31 = "commquestion31";
    private static final String COLUMN_COMMQUESTION32 = "commquestion32";
    private static final String COLUMN_COMMQUESTION33 = "commquestion33";
    private static final String COLUMN_COMMQUESTION34 = "commquestion34";
    private static final String COLUMN_COMMQUESTION35 = "commquestion35";
    private static final String COLUMN_COMMQUESTION36 = "commquestion36";
    private static final String COLUMN_COMMQUESTION37 = "commquestion37";
    private static final String COLUMN_COMMQUESTION38 = "commquestion38";
    private static final String COLUMN_COMMQUESTION39 = "commquestion39";
    private static final String COLUMN_COMMQUESTION40 = "commquestion40";
    private static final String COLUMN_COMMQUESTION41 = "commquestion41";
    private static final String COLUMN_COMMQUESTION42 = "commquestion42";
    private static final String COLUMN_COMMQUESTION43 = "commquestion43";
    private static final String COLUMN_COMMQUESTION44 = "commquestion44";
    private static final String COLUMN_COMMQUESTION45 = "commquestion45";
    private static final String COLUMN_COMMQUESTION46 = "commquestion46";
    private static final String COLUMN_COMMQUESTION47 = "commquestion47";
    private static final String COLUMN_COMMQUESTION48 = "commquestion48";
    private static final String COLUMN_COMMQUESTION49 = "commquestion49";
    private static final String COLUMN_COMMQUESTION50 = "commquestion50";
    private static final String COLUMN_COMMQUESTION51 = "commquestion51";
    private static final String COLUMN_COMMQUESTION52 = "commquestion52";
    private static final String COLUMN_COMMQUESTION53 = "commquestion53";
    private static final String COLUMN_COMMQUESTION54 = "commquestion54";
    private static final String COLUMN_COMMQUESTION56 = "commquestion56";
    private static final String COLUMN_COMMQUESTION57 = "commquestion57";
    private static final String COLUMN_COMMQUESTION58 = "commquestion58";
    private static final String COLUMN_COMMQUESTION59 = "commquestion59";
    private static final String COLUMN_COMMQUESTION60 = "commquestion60";
    private static final String COLUMN_COMMQUESTION61 = "commquestion61";
    private static final String COLUMN_COMMQUESTION62 = "commquestion62";
    private static final String COLUMN_COMMQUESTION63 = "commquestion63";
    private static final String COLUMN_COMMQUESTION64 = "commquestion64";
    private static final String COLUMN_COMMQUESTION65 = "commquestion65";
    private static final String COLUMN_COMMQUESTION66 = "commquestion66";
    private static final String COLUMN_COMMQUESTION67 = "commquestion67";
    private static final String COLUMN_COM_LOCATION = "com_location";
    private static final String COLUMN_FARMER_PHOTO = "farmer_photo";
    private static final String COLUMN_SIGNATURE = "signature";
    private static final String COLUMN_USER_FNAME = "user_fname";
    private static final String COLUMN_USER_ONAME = "user_oname";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_ON_CREATE = "on_create";
    private static final String COLUMN_ON_UPDATE = "on_update";

    private Context context;

    public ComDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_COMMQUESTION1 + " TEXT,"
                + COLUMN_COMMQUESTION2 + " TEXT,"
                + COLUMN_COMMQUESTION3 + " TEXT,"
                + COLUMN_COMMQUESTION4 + " TEXT,"
                + COLUMN_COMMQUESTION5 + " TEXT,"
                + COLUMN_COMMQUESTION6 + " TEXT,"
                + COLUMN_COMMQUESTION7 + " TEXT,"
                + COLUMN_COMMQUESTION8 + " TEXT,"
                + COLUMN_COMMQUESTION9 + " TEXT,"
                + COLUMN_COMMQUESTION10 + " TEXT,"
                + COLUMN_COMMQUESTION11 + " TEXT,"
                + COLUMN_COMMQUESTION12 + " TEXT,"
                + COLUMN_COMMQUESTION13 + " TEXT,"
                + COLUMN_COMMQUESTION14 + " TEXT,"
                + COLUMN_COMMQUESTION15 + " TEXT,"
                + COLUMN_COMMQUESTION16 + " TEXT,"
                + COLUMN_COMMQUESTION17 + " TEXT,"
                + COLUMN_COMMQUESTION18 + " TEXT,"
                + COLUMN_COMMQUESTION19 + " TEXT,"
                + COLUMN_COMMQUESTION20 + " TEXT,"
                + COLUMN_COMMQUESTION21 + " TEXT,"
                + COLUMN_COMMQUESTION22 + " TEXT,"
                + COLUMN_COMMQUESTION23 + " TEXT,"
                + COLUMN_COMMQUESTION24 + " TEXT,"
                + COLUMN_COMMQUESTION25 + " TEXT,"
                + COLUMN_COMMQUESTION26 + " TEXT,"
                + COLUMN_COMMQUESTION27 + " TEXT,"
                + COLUMN_COMMQUESTION28 + " TEXT,"
                + COLUMN_COMMQUESTION29 + " TEXT,"
                + COLUMN_COMMQUESTION30 + " TEXT,"
                + COLUMN_COMMQUESTION31 + " TEXT,"
                + COLUMN_COMMQUESTION32 + " TEXT,"
                + COLUMN_COMMQUESTION33 + " TEXT,"
                + COLUMN_COMMQUESTION34 + " TEXT,"
                + COLUMN_COMMQUESTION35 + " TEXT,"
                + COLUMN_COMMQUESTION36 + " TEXT,"
                + COLUMN_COMMQUESTION37 + " TEXT,"
                + COLUMN_COMMQUESTION38 + " TEXT,"
                + COLUMN_COMMQUESTION39 + " TEXT,"
                + COLUMN_COMMQUESTION40 + " TEXT,"
                + COLUMN_COMMQUESTION41 + " TEXT,"
                + COLUMN_COMMQUESTION42 + " TEXT,"
                + COLUMN_COMMQUESTION43 + " TEXT,"
                + COLUMN_COMMQUESTION44 + " TEXT,"
                + COLUMN_COMMQUESTION45 + " TEXT,"
                + COLUMN_COMMQUESTION46 + " TEXT,"
                + COLUMN_COMMQUESTION47 + " TEXT,"
                + COLUMN_COMMQUESTION48 + " TEXT,"
                + COLUMN_COMMQUESTION49 + " TEXT,"
                + COLUMN_COMMQUESTION50 + " TEXT,"
                + COLUMN_COMMQUESTION51 + " TEXT,"
                + COLUMN_COMMQUESTION52 + " TEXT,"
                + COLUMN_COMMQUESTION53 + " TEXT,"
                + COLUMN_COMMQUESTION54 + " TEXT,"
                + COLUMN_COMMQUESTION56 + " TEXT,"
                + COLUMN_COMMQUESTION57 + " TEXT,"
                + COLUMN_COMMQUESTION58 + " TEXT,"
                + COLUMN_COMMQUESTION59 + " TEXT,"
                + COLUMN_COMMQUESTION60 + " TEXT,"
                + COLUMN_COMMQUESTION61 + " TEXT,"
                + COLUMN_COMMQUESTION62 + " TEXT,"
                + COLUMN_COMMQUESTION63 + " TEXT,"
                + COLUMN_COMMQUESTION64 + " TEXT,"
                + COLUMN_COMMQUESTION65 + " TEXT,"
                + COLUMN_COMMQUESTION66 + " TEXT,"
                + COLUMN_COMMQUESTION67 + " TEXT,"
                + COLUMN_COM_LOCATION + " TEXT,"
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

    public boolean insertCom(String commquestion1, String commquestion2, String commquestion3, String commquestion4,
                             String commquestion5, String commquestion6, String commquestion7, String commquestion8,
                             String commquestion9, String commquestion10, String commquestion11, String commquestion12,
                             String commquestion13, String commquestion14, String commquestion15, String commquestion16,
                             String commquestion17, String commquestion18, String commquestion19, String commquestion20,
                             String commquestion21, String commquestion22, String commquestion23, String commquestion24,
                             String commquestion25, String commquestion26, String commquestion27, String commquestion28,
                             String commquestion29, String commquestion30, String commquestion31, String commquestion32,
                             String commquestion33, String commquestion34, String commquestion35, String commquestion36,
                             String commquestion37, String commquestion38, String commquestion39, String commquestion40,
                             String commquestion41, String commquestion42, String commquestion43, String commquestion44,
                             String commquestion45, String commquestion46, String commquestion47, String commquestion48,
                             String commquestion49, String commquestion50, String commquestion51, String commquestion52,
                             String commquestion53, String commquestion54, String commquestion56, String commquestion57,
                             String commquestion58, String commquestion59, String commquestion60, String commquestion61,
                             String commquestion62, String commquestion63, String commquestion64, String commquestion65,
                             String commquestion66, String commquestion67, String com_location, String farmer_photo,
                             String signatureBase64, String userFname, String userOname, String userEmail,
                             String onCreate, String onUpdate) {
        String signaturePath = null;
        try {
            signaturePath = saveSignatureImage(signatureBase64);
        } catch (IOException e) {
            Log.e("ComDbHelper", "Error saving signature image", e);
            return false; // Return false if signature saving fails
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_COMMQUESTION1, commquestion1);
        values.put(COLUMN_COMMQUESTION2, commquestion2);
        values.put(COLUMN_COMMQUESTION3, commquestion3);
        values.put(COLUMN_COMMQUESTION4, commquestion4);
        values.put(COLUMN_COMMQUESTION5, commquestion5);
        values.put(COLUMN_COMMQUESTION6, commquestion6);
        values.put(COLUMN_COMMQUESTION7, commquestion7);
        values.put(COLUMN_COMMQUESTION8, commquestion8);
        values.put(COLUMN_COMMQUESTION9, commquestion9);
        values.put(COLUMN_COMMQUESTION10, commquestion10);
        values.put(COLUMN_COMMQUESTION11, commquestion11);
        values.put(COLUMN_COMMQUESTION12, commquestion12);
        values.put(COLUMN_COMMQUESTION13, commquestion13);
        values.put(COLUMN_COMMQUESTION14, commquestion14);
        values.put(COLUMN_COMMQUESTION15, commquestion15);
        values.put(COLUMN_COMMQUESTION16, commquestion16);
        values.put(COLUMN_COMMQUESTION17, commquestion17);
        values.put(COLUMN_COMMQUESTION18, commquestion18);
        values.put(COLUMN_COMMQUESTION19, commquestion19);
        values.put(COLUMN_COMMQUESTION20, commquestion20);
        values.put(COLUMN_COMMQUESTION21, commquestion21);
        values.put(COLUMN_COMMQUESTION22, commquestion22);
        values.put(COLUMN_COMMQUESTION23, commquestion23);
        values.put(COLUMN_COMMQUESTION24, commquestion24);
        values.put(COLUMN_COMMQUESTION25, commquestion25);
        values.put(COLUMN_COMMQUESTION26, commquestion26);
        values.put(COLUMN_COMMQUESTION27, commquestion27);
        values.put(COLUMN_COMMQUESTION28, commquestion28);
        values.put(COLUMN_COMMQUESTION29, commquestion29);
        values.put(COLUMN_COMMQUESTION30, commquestion30);
        values.put(COLUMN_COMMQUESTION31, commquestion31);
        values.put(COLUMN_COMMQUESTION32, commquestion32);
        values.put(COLUMN_COMMQUESTION33, commquestion33);
        values.put(COLUMN_COMMQUESTION34, commquestion34);
        values.put(COLUMN_COMMQUESTION35, commquestion35);
        values.put(COLUMN_COMMQUESTION36, commquestion36);
        values.put(COLUMN_COMMQUESTION37, commquestion37);
        values.put(COLUMN_COMMQUESTION38, commquestion38);
        values.put(COLUMN_COMMQUESTION39, commquestion39);
        values.put(COLUMN_COMMQUESTION40, commquestion40);
        values.put(COLUMN_COMMQUESTION41, commquestion41);
        values.put(COLUMN_COMMQUESTION42, commquestion42);
        values.put(COLUMN_COMMQUESTION43, commquestion43);
        values.put(COLUMN_COMMQUESTION44, commquestion44);
        values.put(COLUMN_COMMQUESTION45, commquestion45);
        values.put(COLUMN_COMMQUESTION46, commquestion46);
        values.put(COLUMN_COMMQUESTION47, commquestion47);
        values.put(COLUMN_COMMQUESTION48, commquestion48);
        values.put(COLUMN_COMMQUESTION49, commquestion49);
        values.put(COLUMN_COMMQUESTION50, commquestion50);
        values.put(COLUMN_COMMQUESTION51, commquestion51);
        values.put(COLUMN_COMMQUESTION52, commquestion52);
        values.put(COLUMN_COMMQUESTION53, commquestion53);
        values.put(COLUMN_COMMQUESTION54, commquestion54);
        values.put(COLUMN_COMMQUESTION56, commquestion56);
        values.put(COLUMN_COMMQUESTION57, commquestion57);
        values.put(COLUMN_COMMQUESTION58, commquestion58);
        values.put(COLUMN_COMMQUESTION59, commquestion59);
        values.put(COLUMN_COMMQUESTION60, commquestion60);
        values.put(COLUMN_COMMQUESTION61, commquestion61);
        values.put(COLUMN_COMMQUESTION62, commquestion62);
        values.put(COLUMN_COMMQUESTION63, commquestion63);
        values.put(COLUMN_COMMQUESTION64, commquestion64);
        values.put(COLUMN_COMMQUESTION65, commquestion65);
        values.put(COLUMN_COMMQUESTION66, commquestion66);
        values.put(COLUMN_COMMQUESTION67, commquestion67);
        values.put(COLUMN_COM_LOCATION, com_location);
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
            File directory = new File(parentDirectory, "com-signature");
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException("Failed to create child directory");
            }

            File signatureFile = new File(directory, "com_" + System.currentTimeMillis() + ".png");
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

    public boolean updateCom(String id, String commquestion1, String commquestion2, String commquestion3, String commquestion4,
                             String commquestion5, String commquestion6, String commquestion7, String commquestion8,
                             String commquestion9, String commquestion10, String commquestion11, String commquestion12,
                             String commquestion13, String commquestion14, String commquestion15, String commquestion16,
                             String commquestion17, String commquestion18, String commquestion19, String commquestion20,
                             String commquestion21, String commquestion22, String commquestion23, String commquestion24,
                             String commquestion25, String commquestion26, String commquestion27, String commquestion28,
                             String commquestion29, String commquestion30, String commquestion31, String commquestion32,
                             String commquestion33, String commquestion34, String commquestion35, String commquestion36,
                             String commquestion37, String commquestion38, String commquestion39, String commquestion40,
                             String commquestion41, String commquestion42, String commquestion43, String commquestion44,
                             String commquestion45, String commquestion46, String commquestion47, String commquestion48,
                             String commquestion49, String commquestion50, String commquestion51, String commquestion52,
                             String commquestion53, String commquestion54, String commquestion56, String commquestion57,
                             String commquestion58, String commquestion59, String commquestion60, String commquestion61,
                             String commquestion62, String commquestion63, String commquestion64, String commquestion65,
                             String commquestion66, String commquestion67, String com_location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_COMMQUESTION1, commquestion1);
        values.put(COLUMN_COMMQUESTION2, commquestion2);
        values.put(COLUMN_COMMQUESTION3, commquestion3);
        values.put(COLUMN_COMMQUESTION4, commquestion4);
        values.put(COLUMN_COMMQUESTION5, commquestion5);
        values.put(COLUMN_COMMQUESTION6, commquestion6);
        values.put(COLUMN_COMMQUESTION7, commquestion7);
        values.put(COLUMN_COMMQUESTION8, commquestion8);
        values.put(COLUMN_COMMQUESTION9, commquestion9);
        values.put(COLUMN_COMMQUESTION10, commquestion10);
        values.put(COLUMN_COMMQUESTION11, commquestion11);
        values.put(COLUMN_COMMQUESTION12, commquestion12);
        values.put(COLUMN_COMMQUESTION13, commquestion13);
        values.put(COLUMN_COMMQUESTION14, commquestion14);
        values.put(COLUMN_COMMQUESTION15, commquestion15);
        values.put(COLUMN_COMMQUESTION16, commquestion16);
        values.put(COLUMN_COMMQUESTION17, commquestion17);
        values.put(COLUMN_COMMQUESTION18, commquestion18);
        values.put(COLUMN_COMMQUESTION19, commquestion19);
        values.put(COLUMN_COMMQUESTION20, commquestion20);
        values.put(COLUMN_COMMQUESTION21, commquestion21);
        values.put(COLUMN_COMMQUESTION22, commquestion22);
        values.put(COLUMN_COMMQUESTION23, commquestion23);
        values.put(COLUMN_COMMQUESTION24, commquestion24);
        values.put(COLUMN_COMMQUESTION25, commquestion25);
        values.put(COLUMN_COMMQUESTION26, commquestion26);
        values.put(COLUMN_COMMQUESTION27, commquestion27);
        values.put(COLUMN_COMMQUESTION28, commquestion28);
        values.put(COLUMN_COMMQUESTION29, commquestion29);
        values.put(COLUMN_COMMQUESTION30, commquestion30);
        values.put(COLUMN_COMMQUESTION31, commquestion31);
        values.put(COLUMN_COMMQUESTION32, commquestion32);
        values.put(COLUMN_COMMQUESTION33, commquestion33);
        values.put(COLUMN_COMMQUESTION34, commquestion34);
        values.put(COLUMN_COMMQUESTION35, commquestion35);
        values.put(COLUMN_COMMQUESTION36, commquestion36);
        values.put(COLUMN_COMMQUESTION37, commquestion37);
        values.put(COLUMN_COMMQUESTION38, commquestion38);
        values.put(COLUMN_COMMQUESTION39, commquestion39);
        values.put(COLUMN_COMMQUESTION40, commquestion40);
        values.put(COLUMN_COMMQUESTION41, commquestion41);
        values.put(COLUMN_COMMQUESTION42, commquestion42);
        values.put(COLUMN_COMMQUESTION43, commquestion43);
        values.put(COLUMN_COMMQUESTION44, commquestion44);
        values.put(COLUMN_COMMQUESTION45, commquestion45);
        values.put(COLUMN_COMMQUESTION46, commquestion46);
        values.put(COLUMN_COMMQUESTION47, commquestion47);
        values.put(COLUMN_COMMQUESTION48, commquestion48);
        values.put(COLUMN_COMMQUESTION49, commquestion49);
        values.put(COLUMN_COMMQUESTION50, commquestion50);
        values.put(COLUMN_COMMQUESTION51, commquestion51);
        values.put(COLUMN_COMMQUESTION52, commquestion52);
        values.put(COLUMN_COMMQUESTION53, commquestion53);
        values.put(COLUMN_COMMQUESTION54, commquestion54);
        values.put(COLUMN_COMMQUESTION56, commquestion56);
        values.put(COLUMN_COMMQUESTION57, commquestion57);
        values.put(COLUMN_COMMQUESTION58, commquestion58);
        values.put(COLUMN_COMMQUESTION59, commquestion59);
        values.put(COLUMN_COMMQUESTION60, commquestion60);
        values.put(COLUMN_COMMQUESTION61, commquestion61);
        values.put(COLUMN_COMMQUESTION62, commquestion62);
        values.put(COLUMN_COMMQUESTION63, commquestion63);
        values.put(COLUMN_COMMQUESTION64, commquestion64);
        values.put(COLUMN_COMMQUESTION65, commquestion65);
        values.put(COLUMN_COMMQUESTION66, commquestion66);
        values.put(COLUMN_COMMQUESTION67, commquestion67);
        values.put(COLUMN_COM_LOCATION, com_location);
        values.put(COLUMN_ON_UPDATE, System.currentTimeMillis());

        int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{id});
        db.close();

        return rowsUpdated > 0;
    }

    public Cursor getComSurveyData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

//    public List<ComModel> getAllCommunities() {
//        List<ComModel> surveyList = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        try (Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null)) {
//            if (cursor.moveToFirst()) {
//                int idIndex = cursor.getColumnIndexOrThrow(COLUMN_ID);
//                int q1Index = cursor.getColumnIndexOrThrow(COLUMN_COMMQUESTION1);
//                int q2Index = cursor.getColumnIndexOrThrow(COLUMN_COMMQUESTION2);
//                int q3Index = cursor.getColumnIndexOrThrow(COLUMN_COMMQUESTION3);
//                int photoIndex = cursor.getColumnIndexOrThrow(COLUMN_FARMER_PHOTO);
//                int sigIndex = cursor.getColumnIndexOrThrow(COLUMN_SIGNATURE);
//
//                do {
//                    // Extract values with null protection
//                    int id = cursor.getInt(idIndex);
//                    String commquestion1 = cursor.getString(q1Index);
//                    String commquestion2 = cursor.getString(q2Index);
//                    String commquestion3 = cursor.getString(q3Index);
//                    String photoPath = cursor.getString(photoIndex);
//                    String signature = cursor.getString(sigIndex);
//
//                    // Convert photo path to URI only if valid
//                    Uri photoUri = null;
//                    if (photoPath != null && !photoPath.isEmpty()) {
//                        try {
//                            photoUri = Uri.parse(photoPath);
//                        } catch (Exception e) {
//                            Log.e("DBHelper", "Invalid URI: " + photoPath, e);
//                        }
//                    }
//
//                    surveyList.add(new ComModel(
//                            id,
//                            commquestion1 != null ? commquestion1 : "",
//                            commquestion2 != null ? commquestion2 : "",
//                            commquestion3 != null ? commquestion3 : "",
//                            photoUri,
//                            signature != null ? signature : ""
//                    ));
//                } while (cursor.moveToNext());
//            }
//        } catch (Exception e) {
//            Log.e("DBHelper", "Error getting communities", e);
//        }
//        return surveyList;
//    }

    public List<ComModel> getAllCommunities() {
        List<ComModel> surveyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String commquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion1"));
                String commquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion2"));
                String commquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion3"));
                String commquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion4"));
                String commquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion5"));
                String commquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion6"));
                String commquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion7"));
                String commquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion8"));
                String commquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion9"));
                String commquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion10"));
                String commquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion11"));
                String commquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion12"));
                String commquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion13"));
                String commquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion14"));
                String commquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion15"));
                String commquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion16"));
                String commquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion17"));
                String commquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion18"));
                String commquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion19"));
                String commquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion20"));
                String commquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion21"));
                String commquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion22"));
                String commquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion23"));
                String commquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion24"));
                String commquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion25"));
                String commquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion26"));
                String commquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion27"));
                String commquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion28"));
                String commquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion29"));
                String commquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion30"));
                String commquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion31"));
                String commquestion32 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion32"));
                String commquestion33 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion33"));
                String commquestion34 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion34"));
                String commquestion35 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion35"));
                String commquestion36 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion36"));
                String commquestion37 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion37"));
                String commquestion38 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion38"));
                String commquestion39 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion39"));
                String commquestion40 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion40"));
                String commquestion41 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion41"));
                String commquestion42 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion42"));
                String commquestion43 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion43"));
                String commquestion44 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion44"));
                String commquestion45 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion45"));
                String commquestion46 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion46"));
                String commquestion47 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion47"));
                String commquestion48 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion48"));
                String commquestion49 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion49"));
                String commquestion50 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion50"));
                String commquestion51 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion51"));
                String commquestion52 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion52"));
                String commquestion53 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion53"));
                String commquestion54 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion54"));
                String commquestion56 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion56"));
                String commquestion57 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion57"));
                String commquestion58 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion58"));
                String commquestion59 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion59"));
                String commquestion60 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion60"));
                String commquestion61 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion61"));
                String commquestion62 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion62"));
                String commquestion63 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion63"));
                String commquestion64 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion64"));
                String commquestion65 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion65"));
                String commquestion66 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion66"));
                String commquestion67 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion67"));
                String com_location = cursor.getString(cursor.getColumnIndexOrThrow("com_location"));
                String farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String userOname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
                String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                ComModel model = new ComModel(
                        id, commquestion1, commquestion2, commquestion3, commquestion4, commquestion5, commquestion6,
                        commquestion7, commquestion8, commquestion9, commquestion10, commquestion11, commquestion12,
                        commquestion13, commquestion14, commquestion15, commquestion16, commquestion17, commquestion18,
                        commquestion19, commquestion20, commquestion21, commquestion22, commquestion23, commquestion24,
                        commquestion25, commquestion26, commquestion27, commquestion28, commquestion29, commquestion30,
                        commquestion31, commquestion32, commquestion33, commquestion34, commquestion35, commquestion36,
                        commquestion37, commquestion38, commquestion39, commquestion40, commquestion41, commquestion42,
                        commquestion43, commquestion44, commquestion45, commquestion46, commquestion47, commquestion48,
                        commquestion49, commquestion50, commquestion51, commquestion52, commquestion53, commquestion54,
                        commquestion56, commquestion57, commquestion58, commquestion59, commquestion60, commquestion61,
                        commquestion62, commquestion63, commquestion64, commquestion65, commquestion66, commquestion67,
                        com_location, farmer_photo != null ? Uri.parse(farmer_photo) : null,
                        signature, userFname, userOname, userEmail, onCreate, onUpdate
                );

                surveyList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return surveyList;
    }

    public ComModel getSurveyDetailsByComName(String commquestion1) {
        SQLiteDatabase db = this.getReadableDatabase();
        ComModel comModel = null;

        Cursor cursor = db.query(
                "ComSurveyTbl",
                null,
                "commquestion1 = ?",
                new String[]{commquestion1},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            //String commquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion1"));
            String commquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion2"));
            String commquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion3"));
            String commquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion4"));
            String commquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion5"));
            String commquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion6"));
            String commquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion7"));
            String commquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion8"));
            String commquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion9"));
            String commquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion10"));
            String commquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion11"));
            String commquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion12"));
            String commquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion13"));
            String commquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion14"));
            String commquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion15"));
            String commquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion16"));
            String commquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion17"));
            String commquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion18"));
            String commquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion19"));
            String commquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion20"));
            String commquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion21"));
            String commquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion22"));
            String commquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion23"));
            String commquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion24"));
            String commquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion25"));
            String commquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion26"));
            String commquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion27"));
            String commquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion28"));
            String commquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion29"));
            String commquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion30"));
            String commquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion31"));
            String commquestion32 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion32"));
            String commquestion33 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion33"));
            String commquestion34 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion34"));
            String commquestion35 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion35"));
            String commquestion36 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion36"));
            String commquestion37 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion37"));
            String commquestion38 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion38"));
            String commquestion39 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion39"));
            String commquestion40 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion40"));
            String commquestion41 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion41"));
            String commquestion42 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion42"));
            String commquestion43 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion43"));
            String commquestion44 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion44"));
            String commquestion45 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion45"));
            String commquestion46 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion46"));
            String commquestion47 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion47"));
            String commquestion48 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion48"));
            String commquestion49 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion49"));
            String commquestion50 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion50"));
            String commquestion51 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion51"));
            String commquestion52 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion52"));
            String commquestion53 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion53"));
            String commquestion54 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion54"));
            String commquestion56 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion56"));
            String commquestion57 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion57"));
            String commquestion58 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion58"));
            String commquestion59 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion59"));
            String commquestion60 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion60"));
            String commquestion61 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion61"));
            String commquestion62 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion62"));
            String commquestion63 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion63"));
            String commquestion64 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion64"));
            String commquestion65 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion65"));
            String commquestion66 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion66"));
            String commquestion67 = cursor.getString(cursor.getColumnIndexOrThrow("commquestion67"));
            String com_location = cursor.getString(cursor.getColumnIndexOrThrow("com_location"));
            Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                    ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                    : null;
            String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
            String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
            String userOname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
            String userEmail = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
            String on_create = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
            String on_update = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

            comModel = new ComModel(id, commquestion1, commquestion2, commquestion3, commquestion4, commquestion5, commquestion6,
                    commquestion7, commquestion8, commquestion9, commquestion10, commquestion11, commquestion12,
                    commquestion13, commquestion14, commquestion15, commquestion16, commquestion17, commquestion18,
                    commquestion19, commquestion20, commquestion21, commquestion22, commquestion23, commquestion24,
                    commquestion25, commquestion26, commquestion27, commquestion28, commquestion29, commquestion30,
                    commquestion31, commquestion32, commquestion33, commquestion34, commquestion35, commquestion36,
                    commquestion37, commquestion38, commquestion39, commquestion40, commquestion41, commquestion42,
                    commquestion43, commquestion44, commquestion45, commquestion46, commquestion47, commquestion48,
                    commquestion49, commquestion50, commquestion51, commquestion52, commquestion53, commquestion54,
                    commquestion56, commquestion57, commquestion58, commquestion59, commquestion60, commquestion61,
                    commquestion62, commquestion63, commquestion64, commquestion65, commquestion66, commquestion67,
                    com_location, farmer_photo, signature, userFname, userOname, userEmail, on_create, on_update);
            cursor.close();
        }
        return comModel;
    }

}
