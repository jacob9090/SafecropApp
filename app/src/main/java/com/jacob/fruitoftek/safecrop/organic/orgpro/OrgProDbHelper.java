package com.jacob.fruitoftek.safecrop.organic.orgpro;

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

public class OrgProDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "OrganicSurveyDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "OrganicSurveyTbl";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ORGQUESTION1 = "orgquestion1";
    private static final String COLUMN_ORGQUESTION2 = "orgquestion2";
    private static final String COLUMN_ORGQUESTION3 = "orgquestion3";
    private static final String COLUMN_ORGQUESTION4 = "orgquestion4";
    private static final String COLUMN_ORGQUESTION5 = "orgquestion5";
    private static final String COLUMN_ORGQUESTION6 = "orgquestion6";
    private static final String COLUMN_ORGQUESTION7 = "orgquestion7";
    private static final String COLUMN_ORGQUESTION8 = "orgquestion8";
    private static final String COLUMN_ORGQUESTION9 = "orgquestion9";
    private static final String COLUMN_ORGQUESTION10 = "orgquestion10";
    private static final String COLUMN_ORGQUESTION11 = "orgquestion11";
    private static final String COLUMN_ORGQUESTION12 = "orgquestion12";
    private static final String COLUMN_ORGQUESTION13 = "orgquestion13";
    private static final String COLUMN_ORGQUESTION14 = "orgquestion14";
    private static final String COLUMN_ORGQUESTION15 = "orgquestion15";
    private static final String COLUMN_ORGQUESTION16 = "orgquestion16";
    private static final String COLUMN_ORGQUESTION17 = "orgquestion17";
    private static final String COLUMN_ORGQUESTION19 = "orgquestion19";
    private static final String COLUMN_ORGQUESTION18 = "orgquestion18";
    private static final String COLUMN_ORGQUESTION20 = "orgquestion20";
    private static final String COLUMN_ORGQUESTION21 = "orgquestion21";
    private static final String COLUMN_ORGQUESTION22 = "orgquestion22";
    private static final String COLUMN_ORGQUESTION23 = "orgquestion23";
    private static final String COLUMN_ORGQUESTION24 = "orgquestion24";
    private static final String COLUMN_ORGQUESTION25 = "orgquestion25";
    private static final String COLUMN_ORGQUESTION26 = "orgquestion26";
    private static final String COLUMN_ORGQUESTION27 = "orgquestion27";
    private static final String COLUMN_ORGQUESTION28 = "orgquestion28";
    private static final String COLUMN_ORGQUESTION29 = "orgquestion29";
    private static final String COLUMN_ORGQUESTION30 = "orgquestion30";
    private static final String COLUMN_ORGQUESTION31 = "orgquestion31";
    private static final String COLUMN_ORG_LOCATION = "org_location";
    private static final String COLUMN_FARMER_PHOTO = "farmer_photo";
    private static final String COLUMN_SIGNATURE = "signature";
    private static final String COLUMN_USER_FNAME = "user_fname";
    private static final String COLUMN_USER_ONAME = "user_oname";
    private static final String COLUMN_ON_CREATE = "on_create";
    private static final String COLUMN_ON_UPDATE = "on_update";

    private Context context;

    public OrgProDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_ORGQUESTION1 + " TEXT,"
                + COLUMN_ORGQUESTION2 + " TEXT,"
                + COLUMN_ORGQUESTION3 + " TEXT,"
                + COLUMN_ORGQUESTION4 + " TEXT,"
                + COLUMN_ORGQUESTION5 + " TEXT,"
                + COLUMN_ORGQUESTION6 + " TEXT,"
                + COLUMN_ORGQUESTION7 + " TEXT,"
                + COLUMN_ORGQUESTION8 + " TEXT,"
                + COLUMN_ORGQUESTION9 + " TEXT,"
                + COLUMN_ORGQUESTION10 + " TEXT,"
                + COLUMN_ORGQUESTION11 + " TEXT,"
                + COLUMN_ORGQUESTION12 + " TEXT,"
                + COLUMN_ORGQUESTION13 + " TEXT,"
                + COLUMN_ORGQUESTION14 + " TEXT,"
                + COLUMN_ORGQUESTION15 + " TEXT,"
                + COLUMN_ORGQUESTION16 + " TEXT,"
                + COLUMN_ORGQUESTION17 + " TEXT,"
                + COLUMN_ORGQUESTION19 + " TEXT,"
                + COLUMN_ORGQUESTION18 + " TEXT,"
                + COLUMN_ORGQUESTION20 + " TEXT,"
                + COLUMN_ORGQUESTION21 + " TEXT,"
                + COLUMN_ORGQUESTION22 + " TEXT,"
                + COLUMN_ORGQUESTION23 + " TEXT,"
                + COLUMN_ORGQUESTION24 + " TEXT,"
                + COLUMN_ORGQUESTION25 + " TEXT,"
                + COLUMN_ORGQUESTION26 + " TEXT,"
                + COLUMN_ORGQUESTION27 + " TEXT,"
                + COLUMN_ORGQUESTION28 + " TEXT,"
                + COLUMN_ORGQUESTION29 + " TEXT,"
                + COLUMN_ORGQUESTION30 + " TEXT,"
                + COLUMN_ORGQUESTION31 + " TEXT,"
                + COLUMN_ORG_LOCATION + " TEXT,"
                + COLUMN_FARMER_PHOTO + " TEXT,"
                + COLUMN_SIGNATURE + " TEXT,"
                + COLUMN_USER_FNAME + " TEXT,"
                + COLUMN_USER_ONAME + " TEXT,"
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

    public boolean insertOrgPro(String orgquestion1, String orgquestion2, String orgquestion3,
                                String orgquestion4, String orgquestion5, String orgquestion6, String orgquestion7,
                                String orgquestion8, String orgquestion9, String orgquestion10, String orgquestion11,
                                String orgquestion12, String orgquestion13, String orgquestion14, String orgquestion15,
                                String orgquestion16, String orgquestion17, String orgquestion19, String orgquestion18,
                                String orgquestion20, String orgquestion21, String orgquestion22, String orgquestion23,
                                String orgquestion24, String orgquestion25, String orgquestion26, String orgquestion27,
                                String orgquestion28, String orgquestion29, String orgquestion30, String orgquestion31,
                                String org_location, String farmer_photo, String signatureBase64,
                                String userFname, String userOname, String onCreate, String onUpdate) {
        String signaturePath = null;
        try {
            signaturePath = saveSignatureImage(signatureBase64);
        } catch (IOException e) {
            Log.e("OrgProDbHelper", "Error saving signature image", e);
            return false; // Return false if signature saving fails
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ORGQUESTION1, orgquestion1);
        values.put(COLUMN_ORGQUESTION2, orgquestion2);
        values.put(COLUMN_ORGQUESTION3, orgquestion3);
        values.put(COLUMN_ORGQUESTION4, orgquestion4);
        values.put(COLUMN_ORGQUESTION5, orgquestion5);
        values.put(COLUMN_ORGQUESTION6, orgquestion6);
        values.put(COLUMN_ORGQUESTION7, orgquestion7);
        values.put(COLUMN_ORGQUESTION8, orgquestion8);
        values.put(COLUMN_ORGQUESTION9, orgquestion9);
        values.put(COLUMN_ORGQUESTION10, orgquestion10);
        values.put(COLUMN_ORGQUESTION11, orgquestion11);
        values.put(COLUMN_ORGQUESTION12, orgquestion12);
        values.put(COLUMN_ORGQUESTION13, orgquestion13);
        values.put(COLUMN_ORGQUESTION14, orgquestion14);
        values.put(COLUMN_ORGQUESTION15, orgquestion15);
        values.put(COLUMN_ORGQUESTION16, orgquestion16);
        values.put(COLUMN_ORGQUESTION17, orgquestion17);
        values.put(COLUMN_ORGQUESTION19, orgquestion19);
        values.put(COLUMN_ORGQUESTION18, orgquestion18);
        values.put(COLUMN_ORGQUESTION20, orgquestion20);
        values.put(COLUMN_ORGQUESTION21, orgquestion21);
        values.put(COLUMN_ORGQUESTION22, orgquestion22);
        values.put(COLUMN_ORGQUESTION23, orgquestion23);
        values.put(COLUMN_ORGQUESTION24, orgquestion24);
        values.put(COLUMN_ORGQUESTION25, orgquestion25);
        values.put(COLUMN_ORGQUESTION26, orgquestion26);
        values.put(COLUMN_ORGQUESTION27, orgquestion27);
        values.put(COLUMN_ORGQUESTION28, orgquestion28);
        values.put(COLUMN_ORGQUESTION29, orgquestion29);
        values.put(COLUMN_ORGQUESTION30, orgquestion30);
        values.put(COLUMN_ORGQUESTION31, orgquestion31);
        values.put(COLUMN_ORG_LOCATION, org_location);
        values.put(COLUMN_FARMER_PHOTO, farmer_photo);
        values.put(COLUMN_SIGNATURE, signaturePath);
        values.put(COLUMN_USER_FNAME, userFname);
        values.put(COLUMN_USER_ONAME, userOname);
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
            File directory = new File(parentDirectory, "org-signature");
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException("Failed to create child directory");
            }

            File signatureFile = new File(directory, "orgpro_" + System.currentTimeMillis() + ".png");
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

    public boolean updateOrgPro(String id, String orgquestion1, String orgquestion2, String orgquestion3,
                                String orgquestion4, String orgquestion5, String orgquestion6, String orgquestion7,
                                String orgquestion8, String orgquestion9, String orgquestion10, String orgquestion11,
                                String orgquestion12, String orgquestion13, String orgquestion14, String orgquestion15,
                                String orgquestion16, String orgquestion17, String orgquestion19, String orgquestion18,
                                String orgquestion20, String orgquestion21, String orgquestion22, String orgquestion23,
                                String orgquestion24, String orgquestion25, String orgquestion26, String orgquestion27,
                                String orgquestion28, String orgquestion29, String orgquestion30, String orgquestion31,
                                String org_location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ORGQUESTION1, orgquestion1);
        values.put(COLUMN_ORGQUESTION2, orgquestion2);
        values.put(COLUMN_ORGQUESTION3, orgquestion3);
        values.put(COLUMN_ORGQUESTION4, orgquestion4);
        values.put(COLUMN_ORGQUESTION5, orgquestion5);
        values.put(COLUMN_ORGQUESTION6, orgquestion6);
        values.put(COLUMN_ORGQUESTION7, orgquestion7);
        values.put(COLUMN_ORGQUESTION8, orgquestion8);
        values.put(COLUMN_ORGQUESTION9, orgquestion9);
        values.put(COLUMN_ORGQUESTION10, orgquestion10);
        values.put(COLUMN_ORGQUESTION11, orgquestion11);
        values.put(COLUMN_ORGQUESTION12, orgquestion12);
        values.put(COLUMN_ORGQUESTION13, orgquestion13);
        values.put(COLUMN_ORGQUESTION14, orgquestion14);
        values.put(COLUMN_ORGQUESTION15, orgquestion15);
        values.put(COLUMN_ORGQUESTION16, orgquestion16);
        values.put(COLUMN_ORGQUESTION17, orgquestion17);
        values.put(COLUMN_ORGQUESTION19, orgquestion19);
        values.put(COLUMN_ORGQUESTION18, orgquestion18);
        values.put(COLUMN_ORGQUESTION20, orgquestion20);
        values.put(COLUMN_ORGQUESTION21, orgquestion21);
        values.put(COLUMN_ORGQUESTION22, orgquestion22);
        values.put(COLUMN_ORGQUESTION23, orgquestion23);
        values.put(COLUMN_ORGQUESTION24, orgquestion24);
        values.put(COLUMN_ORGQUESTION25, orgquestion25);
        values.put(COLUMN_ORGQUESTION26, orgquestion26);
        values.put(COLUMN_ORGQUESTION27, orgquestion27);
        values.put(COLUMN_ORGQUESTION28, orgquestion28);
        values.put(COLUMN_ORGQUESTION29, orgquestion29);
        values.put(COLUMN_ORGQUESTION30, orgquestion30);
        values.put(COLUMN_ORGQUESTION31, orgquestion31);
        values.put(COLUMN_ORG_LOCATION, org_location);
        values.put(COLUMN_ON_UPDATE, System.currentTimeMillis());

        int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{id});
        db.close();

        return rowsUpdated > 0;
    }

    public Cursor getOrgProSurveyData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public List<OrgProModel> getAllOrganic() {
        List<OrgProModel> surveyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String orgquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion1"));
                String orgquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion2"));
                String orgquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion3"));
                String orgquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion4"));
                String orgquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion5"));
                String orgquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion6"));
                String orgquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion7"));
                String orgquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion8"));
                String orgquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion9"));
                String orgquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion10"));
                String orgquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion11"));
                String orgquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion12"));
                String orgquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion13"));
                String orgquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion14"));
                String orgquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion15"));
                String orgquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion16"));
                String orgquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion17"));
                String orgquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion19"));
                String orgquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion18"));
                String orgquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion20"));
                String orgquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion21"));
                String orgquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion22"));
                String orgquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion23"));
                String orgquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion24"));
                String orgquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion25"));
                String orgquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion26"));
                String orgquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion27"));
                String orgquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion28"));
                String orgquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion29"));
                String orgquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion30"));
                String orgquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion31"));
                String org_location = cursor.getString(cursor.getColumnIndexOrThrow("org_location"));
                String farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String userOname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                OrgProModel model = new OrgProModel(
                        id, orgquestion1, orgquestion2, orgquestion3, orgquestion4, orgquestion5, orgquestion6,
                        orgquestion7, orgquestion8, orgquestion9, orgquestion10, orgquestion11, orgquestion12, orgquestion13,
                        orgquestion14, orgquestion15, orgquestion16, orgquestion17, orgquestion19, orgquestion18, orgquestion20,
                        orgquestion21, orgquestion22, orgquestion23, orgquestion24, orgquestion25, orgquestion26, orgquestion27,
                        orgquestion28, orgquestion29, orgquestion30, orgquestion31, org_location,
                        farmer_photo != null ? Uri.parse(farmer_photo) : null,
                        signature, userFname, userOname, onCreate, onUpdate
                );

                surveyList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return surveyList;
    }

    public OrgProModel getSurveyDetailsByOrgProName(String orgquestion7) {
        SQLiteDatabase db = this.getReadableDatabase();
        OrgProModel orgproModel = null;

        Cursor cursor = db.query(
                "OrganicSurveyTbl",
                null,
                "orgquestion7 = ?",
                new String[]{orgquestion7},
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String orgquestion1 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion1"));
            String orgquestion2 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion2"));
            String orgquestion3 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion3"));
            String orgquestion4 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion4"));
            String orgquestion5 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion5"));
            String orgquestion6 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion6"));
//            String orgquestion7 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion7"));
            String orgquestion8 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion8"));
            String orgquestion9 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion9"));
            String orgquestion10 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion10"));
            String orgquestion11 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion11"));
            String orgquestion12 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion12"));
            String orgquestion13 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion13"));
            String orgquestion14 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion14"));
            String orgquestion15 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion15"));
            String orgquestion16 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion16"));
            String orgquestion17 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion17"));
            String orgquestion19 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion19"));
            String orgquestion18 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion18"));
            String orgquestion20 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion20"));
            String orgquestion21 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion21"));
            String orgquestion22 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion22"));
            String orgquestion23 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion23"));
            String orgquestion24 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion24"));
            String orgquestion25 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion25"));
            String orgquestion26 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion26"));
            String orgquestion27 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion27"));
            String orgquestion28 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion28"));
            String orgquestion29 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion29"));
            String orgquestion30 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion30"));
            String orgquestion31 = cursor.getString(cursor.getColumnIndexOrThrow("orgquestion31"));
            String org_location = cursor.getString(cursor.getColumnIndexOrThrow("org_location"));
            Uri farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")) != null
                    ? Uri.parse(cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo")))
                    : null;
            String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
            String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
            String userOname = cursor.getString(cursor.getColumnIndexOrThrow("user_oname"));
            String on_create = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
            String on_update = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

            orgproModel = new OrgProModel(id, orgquestion1, orgquestion2, orgquestion3, orgquestion4, orgquestion5,
                    orgquestion6, orgquestion7, orgquestion8, orgquestion9, orgquestion10, orgquestion11, orgquestion12, orgquestion13,
                    orgquestion14, orgquestion15, orgquestion16, orgquestion17, orgquestion19, orgquestion18, orgquestion20, orgquestion21,
                    orgquestion22, orgquestion23, orgquestion24, orgquestion25, orgquestion26, orgquestion27, orgquestion28,
                    orgquestion29, orgquestion30, orgquestion31, org_location, farmer_photo, signature, userFname, userOname,
                    on_create, on_update);
            cursor.close();
        }
        return orgproModel;
    }
}
