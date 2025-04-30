package com.jacob.fruitoftek.safecrop.sustain.gmrs;

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

public class GMRDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GMRSurvey.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "GMRSurveyData";
    private static final String COLUMN_FNAME = "user_fname";
    private static final String COLUMN_ONAME = "user_oname";
    private static final String COLUMN_GMRQUESTION1 = "gmrquestion1";
    private static final String COLUMN_GMRQUESTION2 = "gmrquestion2";
    private static final String COLUMN_GMRQUESTION3 = "gmrquestion3";
    private static final String COLUMN_GMRQUESTION4 = "gmrquestion4";
    private static final String COLUMN_GMRQUESTION5 = "gmrquestion5";
    private static final String COLUMN_GMRQUESTION6 = "gmrquestion6";
    private static final String COLUMN_GMRQUESTION7 = "gmrquestion7";
    private static final String COLUMN_GMRQUESTION8 = "gmrquestion8";
    private static final String COLUMN_GMRQUESTION9 = "gmrquestion9";
    private static final String COLUMN_ID_PHOTO = "id_photo";
    private static final String COLUMN_GMRQUESTION11 = "gmrquestion11";
    private static final String COLUMN_GMRQUESTION12 = "gmrquestion12";
    private static final String COLUMN_GMRQUESTION13 = "gmrquestion13";
    private static final String COLUMN_GMRQUESTION14 = "gmrquestion14";
    private static final String COLUMN_GMRQUESTION15 = "gmrquestion15";
    private static final String COLUMN_GMRQUESTION16 = "gmrquestion16";
    private static final String COLUMN_GMRQUESTION17 = "gmrquestion17";
    private static final String COLUMN_GMRQUESTION18 = "gmrquestion18";
    private static final String COLUMN_GMRQUESTION19 = "gmrquestion19";
    private static final String COLUMN_GMRQUESTION20 = "gmrquestion20";
    private static final String COLUMN_GMRQUESTION21 = "gmrquestion21";
    private static final String COLUMN_GMRQUESTION22 = "gmrquestion22";
    private static final String COLUMN_GMRQUESTION23 = "gmrquestion23";
    private static final String COLUMN_GMRQUESTION24 = "gmrquestion24";
    private static final String COLUMN_GMRQUESTION25 = "gmrquestion25";
    private static final String COLUMN_GMRQUESTION26 = "gmrquestion26";
    private static final String COLUMN_GMRQUESTION27 = "gmrquestion27";
    private static final String COLUMN_GMRQUESTION28 = "gmrquestion28";
    private static final String COLUMN_GMRQUESTION29 = "gmrquestion29";
    private static final String COLUMN_GMRQUESTION30 = "gmrquestion30";
    private static final String COLUMN_GMRQUESTION31 = "gmrquestion31";
    private static final String COLUMN_GMRQUESTION32 = "gmrquestion32";
    private static final String COLUMN_GMRQUESTION33 = "gmrquestion33";
    private static final String COLUMN_GMRQUESTION34 = "gmrquestion34";
    private static final String COLUMN_GMRQUESTION35 = "gmrquestion35";
    private static final String COLUMN_GMRQUESTION36 = "gmrquestion36";
    private static final String COLUMN_GMRQUESTION37 = "gmrquestion37";
    private static final String COLUMN_GMRQUESTION38 = "gmrquestion38";
    private static final String COLUMN_GMRQUESTION39 = "gmrquestion39";
    private static final String COLUMN_FARMER_PHOTO = "farmer_photo";
    private static final String COLUMN_TP_PHOTO = "tp_photo";
    private static final String COLUMN_SIGNATURE = "signature";
    private static final String COLUMN_GMRQUESTION43 = "gmrquestion43";
    private static final String COLUMN_ON_CREATE = "on_create";
    private static final String COLUMN_ON_UPDATE = "on_update";

    private Context context;

    public GMRDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_FNAME + " TEXT, " +
                COLUMN_ONAME + " TEXT, " +
                COLUMN_GMRQUESTION1 + " TEXT, " +
                COLUMN_GMRQUESTION2 + " TEXT, " +
                COLUMN_GMRQUESTION3 + " TEXT, " +
                COLUMN_GMRQUESTION4 + " TEXT, " +
                COLUMN_GMRQUESTION5 + " TEXT, " +
                COLUMN_GMRQUESTION6 + " TEXT, " +
                COLUMN_GMRQUESTION7 + " TEXT, " +
                COLUMN_GMRQUESTION8 + " TEXT, " +
                COLUMN_GMRQUESTION9 + " TEXT, " +
                COLUMN_ID_PHOTO + " TEXT, " +
                COLUMN_GMRQUESTION11 + " TEXT, " +
                COLUMN_GMRQUESTION12 + " TEXT, " +
                COLUMN_GMRQUESTION13 + " TEXT, " +
                COLUMN_GMRQUESTION14 + " TEXT, " +
                COLUMN_GMRQUESTION15 + " TEXT, " +
                COLUMN_GMRQUESTION16 + " TEXT, " +
                COLUMN_GMRQUESTION17 + " TEXT, " +
                COLUMN_GMRQUESTION18 + " TEXT, " +
                COLUMN_GMRQUESTION19 + " TEXT, " +
                COLUMN_GMRQUESTION20 + " TEXT, " +
                COLUMN_GMRQUESTION21 + " TEXT, " +
                COLUMN_GMRQUESTION22 + " TEXT, " +
                COLUMN_GMRQUESTION23 + " TEXT, " +
                COLUMN_GMRQUESTION24 + " TEXT, " +
                COLUMN_GMRQUESTION25 + " TEXT, " +
                COLUMN_GMRQUESTION26 + " TEXT, " +
                COLUMN_GMRQUESTION27 + " TEXT, " +
                COLUMN_GMRQUESTION28 + " TEXT, " +
                COLUMN_GMRQUESTION29 + " TEXT, " +
                COLUMN_GMRQUESTION30 + " TEXT, " +
                COLUMN_GMRQUESTION31 + " TEXT, " +
                COLUMN_GMRQUESTION32 + " TEXT, " +
                COLUMN_GMRQUESTION33 + " TEXT, " +
                COLUMN_GMRQUESTION34 + " TEXT, " +
                COLUMN_GMRQUESTION35 + " TEXT, " +
                COLUMN_GMRQUESTION36 + " TEXT, " +
                COLUMN_GMRQUESTION37 + " TEXT, " +
                COLUMN_GMRQUESTION38 + " TEXT, " +
                COLUMN_GMRQUESTION39 + " TEXT, " +
                COLUMN_FARMER_PHOTO + " TEXT, " +
                COLUMN_TP_PHOTO + " TEXT, " +
                COLUMN_SIGNATURE + " TEXT, " +
                COLUMN_GMRQUESTION43 + " TEXT, " +
                COLUMN_ON_CREATE + " TEXT, " +
                COLUMN_ON_UPDATE + " TEXT);";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertSurveyData(String fname, String oname,
                                    String gmrquestion1, String gmrquestion2, String gmrquestion3,
                                    String gmrquestion4, String gmrquestion5, String gmrquestion6,
                                    String gmrquestion7, String gmrquestion8, String gmrquestion9,
                                    String idPhoto, String gmrquestion11, String gmrquestion12,
                                    String gmrquestion13, String gmrquestion14, String gmrquestion15,
                                    String gmrquestion16, String gmrquestion17, String gmrquestion18,
                                    String gmrquestion19, String gmrquestion20, String gmrquestion21,
                                    String gmrquestion22, String gmrquestion23, String gmrquestion24,
                                    String gmrquestion25, String gmrquestion26, String gmrquestion27,
                                    String gmrquestion28, String gmrquestion29, String gmrquestion30,
                                    String gmrquestion31, String gmrquestion32, String gmrquestion33,
                                    String gmrquestion34, String gmrquestion35, String gmrquestion36,
                                    String gmrquestion37, String gmrquestion38, String gmrquestion39,
                                    String farmerPhoto, String tpPhoto, String signatureBase64,
                                    String gmrquestion43, String onCreate, String onUpdate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("user_fname", fname);
        values.put("user_oname", oname);
        values.put("gmrquestion1", gmrquestion1);
        values.put("gmrquestion2", gmrquestion2);
        values.put("gmrquestion3", gmrquestion3);
        values.put("gmrquestion4", gmrquestion4);
        values.put("gmrquestion5", gmrquestion5);
        values.put("gmrquestion6", gmrquestion6);
        values.put("gmrquestion7", gmrquestion7);
        values.put("gmrquestion8", gmrquestion8);
        values.put("gmrquestion9", gmrquestion9);
        values.put("id_photo", idPhoto);
        values.put("gmrquestion11", gmrquestion11);
        values.put("gmrquestion12", gmrquestion12);
        values.put("gmrquestion13", gmrquestion13);
        values.put("gmrquestion14", gmrquestion14);
        values.put("gmrquestion15", gmrquestion15);
        values.put("gmrquestion16", gmrquestion16);
        values.put("gmrquestion17", gmrquestion17);
        values.put("gmrquestion18", gmrquestion18);
        values.put("gmrquestion19", gmrquestion19);
        values.put("gmrquestion20", gmrquestion20);
        values.put("gmrquestion21", gmrquestion21);
        values.put("gmrquestion22", gmrquestion22);
        values.put("gmrquestion23", gmrquestion23);
        values.put("gmrquestion24", gmrquestion24);
        values.put("gmrquestion25", gmrquestion25);
        values.put("gmrquestion26", gmrquestion26);
        values.put("gmrquestion27", gmrquestion27);
        values.put("gmrquestion28", gmrquestion28);
        values.put("gmrquestion29", gmrquestion29);
        values.put("gmrquestion30", gmrquestion30);
        values.put("gmrquestion31", gmrquestion31);
        values.put("gmrquestion32", gmrquestion32);
        values.put("gmrquestion33", gmrquestion33);
        values.put("gmrquestion34", gmrquestion34);
        values.put("gmrquestion35", gmrquestion35);
        values.put("gmrquestion36", gmrquestion36);
        values.put("gmrquestion37", gmrquestion37);
        values.put("gmrquestion38", gmrquestion38);
        values.put("gmrquestion39", gmrquestion39);
        values.put("farmer_photo", farmerPhoto);
        values.put("tp_photo", tpPhoto);
        values.put("gmrquestion43", gmrquestion43);

        // Save signature image from Base64 and get the file path
        try {
            String signaturePath = saveSignatureImage(signatureBase64);
            values.put("signature", signaturePath);
        } catch (IOException e) {
            Log.e("GMRDbHelper", "Error saving signature image", e);
            return false;
        }

        values.put("on_create", onCreate);
        values.put("on_update", onUpdate);

        long result = db.insert("GMRSurveyData", null, values);

        // Log values for debugging
        Log.d("GMRDbHelper", "Insert Data: " + values.toString());
        return result != -1;
    }

    private String saveSignatureImage(String signatureBase64) throws IOException {
        if (signatureBase64 == null || !signatureBase64.contains(",")) {
            throw new IOException("Invalid Base64 string");
        }

        String base64Data = signatureBase64.split(",")[1];
        byte[] decodedBytes = Base64.decode(base64Data, Base64.DEFAULT);

        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
        if (bitmap == null) {
            throw new IOException("Failed to decode bitmap from Base64");
        }

        // Create "Signature" directory
        File directory = new File(context.getExternalFilesDir(null), "Signature/child-signature");
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException("Failed to create directory");
        }

        File signatureFile = new File(directory, "signature_" + System.currentTimeMillis() + ".png");
        try (FileOutputStream fos = new FileOutputStream(signatureFile)) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
        }

        Log.d("GMRDbHelper", "Signature saved at: " + signatureFile.getAbsolutePath());
        return signatureFile.getAbsolutePath();
    }

    public Cursor getSurveyData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public List<GMRModel> getAllSurveys() {
        List<GMRModel> surveyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String userOname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
                String gmrquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion1"));
                String gmrquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion2"));
                String gmrquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion3"));
                String gmrquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion4"));
                String gmrquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion5"));
                String gmrquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion6"));
                String gmrquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion7"));
                String gmrquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion8"));
                String gmrquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion9"));
                String idPhoto = cursor.getString(cursor.getColumnIndexOrThrow("id_photo"));
                String gmrquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion11"));
                String gmrquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion12"));
                String gmrquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion13"));
                String gmrquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion14"));
                String gmrquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion15"));
                String gmrquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion16"));
                String gmrquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion17"));
                String gmrquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion18"));
                String gmrquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion19"));
                String gmrquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion20"));
                String gmrquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion21"));
                String gmrquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion22"));
                String gmrquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion23"));
                String gmrquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion24"));
                String gmrquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion25"));
                String gmrquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion26"));
                String gmrquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion27"));
                String gmrquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion28"));
                String gmrquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion29"));
                String gmrquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion30"));
                String gmrquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion31"));
                String gmrquestion32 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion32"));
                String gmrquestion33 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion33"));
                String gmrquestion34 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion34"));
                String gmrquestion35 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion35"));
                String gmrquestion36 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion36"));
                String gmrquestion37 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion37"));
                String gmrquestion38 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion38"));
                String gmrquestion39 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion39"));
                String gmrquestion43 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion43"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));
                String farmerPhoto = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo"));
                String tpPhoto = cursor.getString(cursor.getColumnIndexOrThrow("tp_photo"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));

                GMRModel model = new GMRModel(
                        userFname,
                        userOname,
                        gmrquestion1,
                        gmrquestion2,
                        gmrquestion3,
                        gmrquestion4,
                        gmrquestion5,
                        gmrquestion6,
                        gmrquestion7,
                        gmrquestion8,
                        gmrquestion9,
                        idPhoto != null ? Uri.parse(idPhoto) : null,
                        gmrquestion11,
                        gmrquestion12,
                        gmrquestion13,
                        gmrquestion14,
                        gmrquestion15,
                        gmrquestion16,
                        gmrquestion17,
                        gmrquestion18,
                        gmrquestion19,
                        gmrquestion20,
                        gmrquestion21,
                        gmrquestion22,
                        gmrquestion23,
                        gmrquestion24,
                        gmrquestion25,
                        gmrquestion26,
                        gmrquestion27,
                        gmrquestion28,
                        gmrquestion29,
                        gmrquestion30,
                        gmrquestion31,
                        gmrquestion32,
                        gmrquestion33,
                        gmrquestion34,
                        gmrquestion35,
                        gmrquestion36,
                        gmrquestion37,
                        gmrquestion38,
                        gmrquestion39,
                        farmerPhoto != null ? Uri.parse(farmerPhoto) : null,
                        tpPhoto != null ? Uri.parse(tpPhoto) : null,
                        signature,
                        gmrquestion43,
                        onCreate,
                        onUpdate
                );

                surveyList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }

        return surveyList;
    }

    public GMRModel getSurveyDetailsByFarmerCode(String gmrquestion5) {
        SQLiteDatabase db = this.getReadableDatabase();
        GMRModel gmrModel = null;

        Cursor cursor = db.query(
                "GMRSurveyData",
                null,
                "farmer_code = ?",
                new String[]{gmrquestion5},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            String fname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
            String oname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
            String gmrquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion1"));
            String gmrquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion2"));
            String gmrquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion3"));
            String gmrquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion4"));
            String gmrquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion6"));
            String gmrquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion7"));
            String gmrquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion8"));
            String gmrquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion9"));
            Uri idPhoto = cursor.getString(cursor.getColumnIndexOrThrow("id_photo")) != null
                    ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("id_photo")))
                    : null;
            String gmrquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion11"));
            String gmrquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion12"));
            String gmrquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion13"));
            String gmrquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion14"));
            String gmrquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion15"));
            String gmrquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion16"));
            String gmrquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion17"));
            String gmrquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion18"));
            String gmrquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion19"));
            String gmrquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion20"));
            String gmrquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion21"));
            String gmrquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion22"));
            String gmrquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion23"));
            String gmrquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion24"));
            String gmrquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion25"));
            String gmrquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion26"));
            String gmrquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion27"));
            String gmrquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion28"));
            String gmrquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion29"));
            String gmrquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion30"));
            String gmrquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion31"));
            String gmrquestion32 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion32"));
            String gmrquestion33 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion33"));
            String gmrquestion34 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion34"));
            String gmrquestion35 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion35"));
            String gmrquestion36 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion36"));
            String gmrquestion37 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion37"));
            String gmrquestion38 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion38"));
            String gmrquestion39 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion39"));
            String gmrquestion43 = cursor.getString(cursor.getColumnIndexOrThrow("gmrquestion43"));
            Uri farmerPhoto = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                    ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                    : null;
            Uri tpPhoto = cursor.getString(cursor.getColumnIndexOrThrow("tp_photo")) != null
                    ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("tp_photo")))
                    : null;
            String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
            String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
            String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

            gmrModel = new GMRModel(fname, oname, gmrquestion1, gmrquestion2, gmrquestion3, gmrquestion4,
                    gmrquestion5, gmrquestion6, gmrquestion7, gmrquestion8, gmrquestion9, idPhoto, gmrquestion11,
                    gmrquestion12, gmrquestion13, gmrquestion14, gmrquestion15, gmrquestion16, gmrquestion17,
                    gmrquestion18, gmrquestion19, gmrquestion20, gmrquestion21, gmrquestion22, gmrquestion23,
                    gmrquestion24, gmrquestion25, gmrquestion26, gmrquestion27, gmrquestion28, gmrquestion29,
                    gmrquestion30, gmrquestion31, gmrquestion32, gmrquestion33, gmrquestion34, gmrquestion35,
                    gmrquestion36, gmrquestion37, gmrquestion38, gmrquestion39, farmerPhoto, tpPhoto,
                    signature, gmrquestion43, onCreate, onUpdate);
            cursor.close();
        }

        return gmrModel;
    }
}