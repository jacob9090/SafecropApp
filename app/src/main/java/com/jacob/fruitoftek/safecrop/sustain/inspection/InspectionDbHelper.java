package com.jacob.fruitoftek.safecrop.sustain.inspection;

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

public class InspectionDbHelper extends SQLiteOpenHelper {
    
    private static final String DATABASE_NAME = "InspectionDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "InspectionTbl";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FARMER_ID = "farmer_id";
    private static final String COLUMN_FARMER_NAME = "farmer_name";
    private static final String COLUMN_DISTRICT = "district";
    private static final String COLUMN_COMMUNITY = "community";
    private static final String COLUMN_INSPECTION_QUESTION1 = "inspection_question1";
    private static final String COLUMN_INSPECTION_QUESTION2 = "inspection_question2";
    private static final String COLUMN_INSPECTION_QUESTION3 = "inspection_question3";
    private static final String COLUMN_INSPECTION_QUESTION4 = "inspection_question4";
    private static final String COLUMN_INSPECTION_QUESTION5 = "inspection_question5";
    private static final String COLUMN_INSPECTION_QUESTION6 = "inspection_question6";
    private static final String COLUMN_INSPECTION_QUESTION7 = "inspection_question7";
    private static final String COLUMN_INSPECTION_QUESTION8 = "inspection_question8";
    private static final String COLUMN_INSPECTION_QUESTION9 = "inspection_question9";
    private static final String COLUMN_INSPECTION_QUESTION10 = "inspection_question10";
    private static final String COLUMN_INSPECTION_QUESTION11 = "inspection_question11";
    private static final String COLUMN_INSPECTION_QUESTION12 = "inspection_question12";
    private static final String COLUMN_INSPECTION_QUESTION13 = "inspection_question13";
    private static final String COLUMN_INSPECTION_QUESTION14 = "inspection_question14";
    private static final String COLUMN_INSPECTION_QUESTION15 = "inspection_question15";
    private static final String COLUMN_INSPECTION_QUESTION16 = "inspection_question16";
    private static final String COLUMN_INSPECTION_QUESTION17 = "inspection_question17";
    private static final String COLUMN_INSPECTION_QUESTION18 = "inspection_question18";
    private static final String COLUMN_INSPECTION_QUESTION19 = "inspection_question19";
    private static final String COLUMN_INSPECTION_QUESTION20 = "inspection_question20";
    private static final String COLUMN_INSPECTION_QUESTION21 = "inspection_question21";
    private static final String COLUMN_INSPECTION_QUESTION22 = "inspection_question22";
    private static final String COLUMN_INSPECTION_QUESTION23 = "inspection_question23";
    private static final String COLUMN_INSPECTION_QUESTION24 = "inspection_question24";
    private static final String COLUMN_INSPECTION_QUESTION25 = "inspection_question25";
    private static final String COLUMN_INSPECTION_QUESTION26 = "inspection_question26";
    private static final String COLUMN_INSPECTION_QUESTION27 = "inspection_question27";
    private static final String COLUMN_INSPECTION_QUESTION28 = "inspection_question28";
    private static final String COLUMN_INSPECTION_QUESTION29 = "inspection_question29";
    private static final String COLUMN_INSPECTION_QUESTION30 = "inspection_question30";
    private static final String COLUMN_INSPECTION_QUESTION31 = "inspection_question31";
    private static final String COLUMN_INSPECTION_QUESTION32 = "inspection_question32";
    private static final String COLUMN_INSPECTION_QUESTION33 = "inspection_question33";
    private static final String COLUMN_INSPECTION_QUESTION34 = "inspection_question34";
    private static final String COLUMN_INSPECTION_QUESTION35 = "inspection_question35";
    private static final String COLUMN_INSPECTION_QUESTION36 = "inspection_question36";
    private static final String COLUMN_INSPECTION_QUESTION37 = "inspection_question37";
    private static final String COLUMN_INSPECTION_QUESTION38 = "inspection_question38";
    private static final String COLUMN_INSPECTION_QUESTION39 = "inspection_question39";
    private static final String COLUMN_INSPECTION_QUESTION40 = "inspection_question40";
    private static final String COLUMN_INSPECTION_QUESTION41 = "inspection_question41";
    private static final String COLUMN_INSPECTION_QUESTION42 = "inspection_question42";
    private static final String COLUMN_INSPECTION_QUESTION43 = "inspection_question43";
    private static final String COLUMN_INSPECTION_QUESTION44 = "inspection_question44";
    private static final String COLUMN_INSPECTION_QUESTION45 = "inspection_question45";
    private static final String COLUMN_INSPECTION_QUESTION46 = "inspection_question46";
    private static final String COLUMN_INSPECTION_QUESTION47 = "inspection_question47";
    private static final String COLUMN_INSPECTION_QUESTION48 = "inspection_question48";
    private static final String COLUMN_INSPECTION_QUESTION49 = "inspection_question49";
    private static final String COLUMN_INSPECTION_QUESTION50 = "inspection_question50";
    private static final String COLUMN_INSPECTION_QUESTION51 = "inspection_question51";
    private static final String COLUMN_INSPECTION_QUESTION52 = "inspection_question52";
    private static final String COLUMN_INSPECTION_QUESTION53 = "inspection_question53";
    private static final String COLUMN_INSPECTION_QUESTION54 = "inspection_question54";
    private static final String COLUMN_INSPECTION_QUESTION55 = "inspection_question55";
    private static final String COLUMN_INSPECTION_QUESTION56 = "inspection_question56";
    private static final String COLUMN_INSPECTION_QUESTION57 = "inspection_question57";
    private static final String COLUMN_INSPECTION_QUESTION58 = "inspection_question58";
    private static final String COLUMN_INSPECTION_QUESTION59 = "inspection_question59";
    private static final String COLUMN_INSPECTION_QUESTION60 = "inspection_question60";
    private static final String COLUMN_INSPECTION_QUESTION61 = "inspection_question61";
    private static final String COLUMN_INSPECTION_QUESTION62 = "inspection_question62";
    private static final String COLUMN_INSPECTION_QUESTION63 = "inspection_question63";
    private static final String COLUMN_INSPECTION_QUESTION64 = "inspection_question64";
    private static final String COLUMN_INSPECTION_QUESTION65 = "inspection_question65";
    private static final String COLUMN_INSPECTION_QUESTION66 = "inspection_question66";
    private static final String COLUMN_INSPECTION_QUESTION67 = "inspection_question67";
    private static final String COLUMN_INSPECTION_QUESTION68 = "inspection_question68";
    private static final String COLUMN_INSPECTION_LOCATION = "inspection_location";
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

    public InspectionDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_FARMER_ID + " TEXT UNIQUE,"
                + COLUMN_FARMER_NAME + " TEXT,"
                + COLUMN_DISTRICT + " TEXT,"
                + COLUMN_COMMUNITY + " TEXT,"
                + COLUMN_INSPECTION_QUESTION1 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION2 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION3 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION4 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION5 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION6 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION7 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION8 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION9 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION10 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION11 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION12 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION13 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION14 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION15 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION16 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION17 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION18 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION19 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION20 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION21 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION22 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION23 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION24 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION25 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION26 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION27 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION28 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION29 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION30 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION31 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION32 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION33 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION34 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION35 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION36 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION37 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION38 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION39 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION40 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION41 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION42 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION43 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION44 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION45 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION46 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION47 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION48 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION49 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION50 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION51 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION52 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION53 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION54 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION55 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION56 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION57 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION58 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION59 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION60 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION61 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION62 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION63 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION64 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION65 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION66 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION67 + " TEXT,"
                + COLUMN_INSPECTION_QUESTION68 + " TEXT,"
                + COLUMN_INSPECTION_LOCATION + " TEXT,"
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

    public boolean insertOrUpdateInspection(String farmer_id, String farmer_name, String district, String community,
                                            String inspection_question1, String inspection_question2, String inspection_question3,
                                            String inspection_question4, String inspection_question5, String inspection_question6,
                                            String inspection_question7, String inspection_question8, String inspection_question9,
                                            String inspection_question10, String inspection_question11, String inspection_question12,
                                            String inspection_question13, String inspection_question14,
                                            String inspection_question15, String inspection_question16, String inspection_question17,
                                            String inspection_question18, String inspection_question19, String inspection_question20,
                                            String inspection_question21, String inspection_question22, String inspection_question23,
                                            String inspection_question24, String inspection_question25, String inspection_question26,
                                            String inspection_question27, String inspection_question28, String inspection_question29,
                                            String inspection_question30, String inspection_question31, String inspection_question32,
                                            String inspection_question33, String inspection_question34, String inspection_question35,
                                            String inspection_question36, String inspection_question37, String inspection_question38,
                                            String inspection_question39, String inspection_question40, String inspection_question41,
                                            String inspection_question42, String inspection_question43, String inspection_question44,
                                            String inspection_question45, String inspection_question46, String inspection_question47,
                                            String inspection_question48, String inspection_question49, String inspection_question50,
                                            String inspection_question51, String inspection_question52, String inspection_question53,
                                            String inspection_question54, String inspection_question55, String inspection_question56,
                                            String inspection_question57, String inspection_question58, String inspection_question59,
                                            String inspection_question60, String inspection_question61, String inspection_question62,
                                            String inspection_question63, String inspection_question64, String inspection_question65,
                                            String inspection_question66, String inspection_question67, String inspection_question68,
                                            String inspection_location, String farmer_photo, String signatureBase64, String is_sync,
                                            String is_draft, String userFname, String userLname, String user_email, String onCreate,
                                            String onUpdate) {

        String signaturePath = null;
        if (signatureBase64 != null && signatureBase64.startsWith("data:image")) {
            try {
                signaturePath = saveSignatureImage(signatureBase64);
            } catch (IOException e) {
                Log.e("InspectionDbHelper", "Error saving signature image", e);
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
        values.put(COLUMN_DISTRICT, district);
        values.put(COLUMN_COMMUNITY, community);
        values.put(COLUMN_INSPECTION_QUESTION1, inspection_question1);
        values.put(COLUMN_INSPECTION_QUESTION2, inspection_question2);
        values.put(COLUMN_INSPECTION_QUESTION3, inspection_question3);
        values.put(COLUMN_INSPECTION_QUESTION4, inspection_question4);
        values.put(COLUMN_INSPECTION_QUESTION5, inspection_question5);
        values.put(COLUMN_INSPECTION_QUESTION6, inspection_question6);
        values.put(COLUMN_INSPECTION_QUESTION7, inspection_question7);
        values.put(COLUMN_INSPECTION_QUESTION8, inspection_question8);
        values.put(COLUMN_INSPECTION_QUESTION9, inspection_question9);
        values.put(COLUMN_INSPECTION_QUESTION10, inspection_question10);
        values.put(COLUMN_INSPECTION_QUESTION11, inspection_question11);
        values.put(COLUMN_INSPECTION_QUESTION12, inspection_question12);
        values.put(COLUMN_INSPECTION_QUESTION13, inspection_question13);
        values.put(COLUMN_INSPECTION_QUESTION14, inspection_question14);
        values.put(COLUMN_INSPECTION_QUESTION15, inspection_question15);
        values.put(COLUMN_INSPECTION_QUESTION16, inspection_question16);
        values.put(COLUMN_INSPECTION_QUESTION17, inspection_question17);
        values.put(COLUMN_INSPECTION_QUESTION18, inspection_question18);
        values.put(COLUMN_INSPECTION_QUESTION19, inspection_question19);
        values.put(COLUMN_INSPECTION_QUESTION20, inspection_question20);
        values.put(COLUMN_INSPECTION_QUESTION21, inspection_question21);
        values.put(COLUMN_INSPECTION_QUESTION22, inspection_question22);
        values.put(COLUMN_INSPECTION_QUESTION23, inspection_question23);
        values.put(COLUMN_INSPECTION_QUESTION24, inspection_question24);
        values.put(COLUMN_INSPECTION_QUESTION25, inspection_question25);
        values.put(COLUMN_INSPECTION_QUESTION26, inspection_question26);
        values.put(COLUMN_INSPECTION_QUESTION27, inspection_question27);
        values.put(COLUMN_INSPECTION_QUESTION28, inspection_question28);
        values.put(COLUMN_INSPECTION_QUESTION29, inspection_question29);
        values.put(COLUMN_INSPECTION_QUESTION30, inspection_question30);
        values.put(COLUMN_INSPECTION_QUESTION31, inspection_question31);
        values.put(COLUMN_INSPECTION_QUESTION32, inspection_question32);
        values.put(COLUMN_INSPECTION_QUESTION33, inspection_question33);
        values.put(COLUMN_INSPECTION_QUESTION34, inspection_question34);
        values.put(COLUMN_INSPECTION_QUESTION35, inspection_question35);
        values.put(COLUMN_INSPECTION_QUESTION36, inspection_question36);
        values.put(COLUMN_INSPECTION_QUESTION37, inspection_question37);
        values.put(COLUMN_INSPECTION_QUESTION38, inspection_question38);
        values.put(COLUMN_INSPECTION_QUESTION39, inspection_question39);
        values.put(COLUMN_INSPECTION_QUESTION40, inspection_question40);
        values.put(COLUMN_INSPECTION_QUESTION41, inspection_question41);
        values.put(COLUMN_INSPECTION_QUESTION42, inspection_question42);
        values.put(COLUMN_INSPECTION_QUESTION43, inspection_question43);
        values.put(COLUMN_INSPECTION_QUESTION44, inspection_question44);
        values.put(COLUMN_INSPECTION_QUESTION45, inspection_question45);
        values.put(COLUMN_INSPECTION_QUESTION46, inspection_question46);
        values.put(COLUMN_INSPECTION_QUESTION47, inspection_question47);
        values.put(COLUMN_INSPECTION_QUESTION48, inspection_question48);
        values.put(COLUMN_INSPECTION_QUESTION49, inspection_question49);
        values.put(COLUMN_INSPECTION_QUESTION50, inspection_question50);
        values.put(COLUMN_INSPECTION_QUESTION51, inspection_question51);
        values.put(COLUMN_INSPECTION_QUESTION52, inspection_question52);
        values.put(COLUMN_INSPECTION_QUESTION53, inspection_question53);
        values.put(COLUMN_INSPECTION_QUESTION54, inspection_question54);
        values.put(COLUMN_INSPECTION_QUESTION55, inspection_question55);
        values.put(COLUMN_INSPECTION_QUESTION56, inspection_question56);
        values.put(COLUMN_INSPECTION_QUESTION57, inspection_question57);
        values.put(COLUMN_INSPECTION_QUESTION58, inspection_question58);
        values.put(COLUMN_INSPECTION_QUESTION59, inspection_question59);
        values.put(COLUMN_INSPECTION_QUESTION60, inspection_question60);
        values.put(COLUMN_INSPECTION_QUESTION61, inspection_question61);
        values.put(COLUMN_INSPECTION_QUESTION62, inspection_question62);
        values.put(COLUMN_INSPECTION_QUESTION63, inspection_question63);
        values.put(COLUMN_INSPECTION_QUESTION64, inspection_question64);
        values.put(COLUMN_INSPECTION_QUESTION65, inspection_question65);
        values.put(COLUMN_INSPECTION_QUESTION66, inspection_question66);
        values.put(COLUMN_INSPECTION_QUESTION67, inspection_question67);
        values.put(COLUMN_INSPECTION_QUESTION68, inspection_question68);
        values.put(COLUMN_INSPECTION_LOCATION, inspection_location);
        values.put(COLUMN_FARMER_PHOTO, farmer_photo);
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

            // Create inspection-signature" directory
            File directory = new File(parentDirectory, "inspection-signature");
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException("Failed to create inspection directory");
            }

            File signatureFile = new File(directory, "inspection_" + System.currentTimeMillis() + ".png");
            try (FileOutputStream fos = new FileOutputStream(signatureFile)) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            }

            Log.d("InspectionDbHelper", "Signature saved at: " + signatureFile.getAbsolutePath());
            return signatureFile.getAbsolutePath();
        } catch (Exception e) {
            Log.e("InspectionDbHelper", "Error saving signature image", e);
            throw new IOException("Failed to save image: " + e.getMessage());
        }
    }

    public boolean updateInspection(String id, String farmer_id, String farmer_name, String district, String community,
                                    String inspection_question1, String inspection_question2, String inspection_question3,
                                    String inspection_question4, String inspection_question5,
                                    String inspection_question6, String inspection_question7, String inspection_question8,
                                    String inspection_question9, String inspection_question10, String inspection_question11,
                                    String inspection_question12, String inspection_question13, String inspection_question14,
                                    String inspection_question15, String inspection_question16, String inspection_question17,
                                    String inspection_question18, String inspection_question19, String inspection_question20,
                                    String inspection_question21, String inspection_question22, String inspection_question23,
                                    String inspection_question24, String inspection_question25, String inspection_question26,
                                    String inspection_question27, String inspection_question28, String inspection_question29,
                                    String inspection_question30, String inspection_question31, String inspection_question32,
                                    String inspection_question33, String inspection_question34, String inspection_question35,
                                    String inspection_question36, String inspection_question37, String inspection_question38,
                                    String inspection_question39, String inspection_question40, String inspection_question41,
                                    String inspection_question42, String inspection_question43, String inspection_question44,
                                    String inspection_question45, String inspection_question46, String inspection_question47,
                                    String inspection_question48, String inspection_question49, String inspection_question50,
                                    String inspection_question51, String inspection_question52, String inspection_question53,
                                    String inspection_question54, String inspection_question55, String inspection_question56,
                                    String inspection_question57, String inspection_question58, String inspection_question59,
                                    String inspection_question60, String inspection_question61, String inspection_question62,
                                    String inspection_question63, String inspection_question64, String inspection_question65,
                                    String inspection_question66, String inspection_question67, String inspection_question68,
                                    String inspection_location,
                                    String farmer_photo, String signature, String is_sync, String is_draft) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FARMER_ID, farmer_id);
        values.put(COLUMN_FARMER_NAME, farmer_name);
        values.put(COLUMN_DISTRICT, district);
        values.put(COLUMN_COMMUNITY, community);
        values.put(COLUMN_INSPECTION_QUESTION1, inspection_question1);
        values.put(COLUMN_INSPECTION_QUESTION2, inspection_question2);
        values.put(COLUMN_INSPECTION_QUESTION3, inspection_question3);
        values.put(COLUMN_INSPECTION_QUESTION4, inspection_question4);
        values.put(COLUMN_INSPECTION_QUESTION5, inspection_question5);
        values.put(COLUMN_INSPECTION_QUESTION6, inspection_question6);
        values.put(COLUMN_INSPECTION_QUESTION7, inspection_question7);
        values.put(COLUMN_INSPECTION_QUESTION8, inspection_question8);
        values.put(COLUMN_INSPECTION_QUESTION9, inspection_question9);
        values.put(COLUMN_INSPECTION_QUESTION10, inspection_question10);
        values.put(COLUMN_INSPECTION_QUESTION11, inspection_question11);
        values.put(COLUMN_INSPECTION_QUESTION12, inspection_question12);
        values.put(COLUMN_INSPECTION_QUESTION13, inspection_question13);
        values.put(COLUMN_INSPECTION_QUESTION14, inspection_question14);
        values.put(COLUMN_INSPECTION_QUESTION15, inspection_question15);
        values.put(COLUMN_INSPECTION_QUESTION16, inspection_question16);
        values.put(COLUMN_INSPECTION_QUESTION17, inspection_question17);
        values.put(COLUMN_INSPECTION_QUESTION18, inspection_question18);
        values.put(COLUMN_INSPECTION_QUESTION19, inspection_question19);
        values.put(COLUMN_INSPECTION_QUESTION20, inspection_question20);
        values.put(COLUMN_INSPECTION_QUESTION21, inspection_question21);
        values.put(COLUMN_INSPECTION_QUESTION22, inspection_question22);
        values.put(COLUMN_INSPECTION_QUESTION23, inspection_question23);
        values.put(COLUMN_INSPECTION_QUESTION24, inspection_question24);
        values.put(COLUMN_INSPECTION_QUESTION25, inspection_question25);
        values.put(COLUMN_INSPECTION_QUESTION26, inspection_question26);
        values.put(COLUMN_INSPECTION_QUESTION27, inspection_question27);
        values.put(COLUMN_INSPECTION_QUESTION28, inspection_question28);
        values.put(COLUMN_INSPECTION_QUESTION29, inspection_question29);
        values.put(COLUMN_INSPECTION_QUESTION30, inspection_question30);
        values.put(COLUMN_INSPECTION_QUESTION31, inspection_question31);
        values.put(COLUMN_INSPECTION_QUESTION32, inspection_question32);
        values.put(COLUMN_INSPECTION_QUESTION33, inspection_question33);
        values.put(COLUMN_INSPECTION_QUESTION34, inspection_question34);
        values.put(COLUMN_INSPECTION_QUESTION35, inspection_question35);
        values.put(COLUMN_INSPECTION_QUESTION36, inspection_question36);
        values.put(COLUMN_INSPECTION_QUESTION37, inspection_question37);
        values.put(COLUMN_INSPECTION_QUESTION38, inspection_question38);
        values.put(COLUMN_INSPECTION_QUESTION39, inspection_question39);
        values.put(COLUMN_INSPECTION_QUESTION40, inspection_question40);
        values.put(COLUMN_INSPECTION_QUESTION41, inspection_question41);
        values.put(COLUMN_INSPECTION_QUESTION42, inspection_question42);
        values.put(COLUMN_INSPECTION_QUESTION43, inspection_question43);
        values.put(COLUMN_INSPECTION_QUESTION44, inspection_question44);
        values.put(COLUMN_INSPECTION_QUESTION45, inspection_question45);
        values.put(COLUMN_INSPECTION_QUESTION46, inspection_question46);
        values.put(COLUMN_INSPECTION_QUESTION47, inspection_question47);
        values.put(COLUMN_INSPECTION_QUESTION48, inspection_question48);
        values.put(COLUMN_INSPECTION_QUESTION49, inspection_question49);
        values.put(COLUMN_INSPECTION_QUESTION50, inspection_question50);
        values.put(COLUMN_INSPECTION_QUESTION51, inspection_question51);
        values.put(COLUMN_INSPECTION_QUESTION52, inspection_question52);
        values.put(COLUMN_INSPECTION_QUESTION53, inspection_question53);
        values.put(COLUMN_INSPECTION_QUESTION54, inspection_question54);
        values.put(COLUMN_INSPECTION_QUESTION55, inspection_question55);
        values.put(COLUMN_INSPECTION_QUESTION56, inspection_question56);
        values.put(COLUMN_INSPECTION_QUESTION57, inspection_question57);
        values.put(COLUMN_INSPECTION_QUESTION58, inspection_question58);
        values.put(COLUMN_INSPECTION_QUESTION59, inspection_question59);
        values.put(COLUMN_INSPECTION_QUESTION60, inspection_question60);
        values.put(COLUMN_INSPECTION_QUESTION61, inspection_question61);
        values.put(COLUMN_INSPECTION_QUESTION62, inspection_question62);
        values.put(COLUMN_INSPECTION_QUESTION63, inspection_question63);
        values.put(COLUMN_INSPECTION_QUESTION64, inspection_question64);
        values.put(COLUMN_INSPECTION_QUESTION65, inspection_question65);
        values.put(COLUMN_INSPECTION_QUESTION66, inspection_question66);
        values.put(COLUMN_INSPECTION_QUESTION67, inspection_question67);
        values.put(COLUMN_INSPECTION_QUESTION68, inspection_question68);
        values.put(COLUMN_INSPECTION_LOCATION, inspection_location);
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
                Log.e("InspectionDbHelper", "Error saving signature image on update", e);
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

    public List<InspectionModel> getAllInspection() {
        List<InspectionModel> surveyList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String farmer_id = cursor.getString(cursor.getColumnIndexOrThrow("farmer_id"));
                String farmer_name = cursor.getString(cursor.getColumnIndexOrThrow("farmer_name"));
                String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
                String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
                String inspection_question1 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question1"));
                String inspection_question2 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question2"));
                String inspection_question3 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question3"));
                String inspection_question4 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question4"));
                String inspection_question5 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question5"));
                String inspection_question6 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question6"));
                String inspection_question7 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question7"));
                String inspection_question8 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question8"));
                String inspection_question9 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question9"));
                String inspection_question10 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question10"));
                String inspection_question11 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question11"));
                String inspection_question12 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question12"));
                String inspection_question13 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question13"));
                String inspection_question14 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question14"));
                String inspection_question15 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question15"));
                String inspection_question16 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question16"));
                String inspection_question17 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question17"));
                String inspection_question18 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question18"));
                String inspection_question19 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question19"));
                String inspection_question20 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question20"));
                String inspection_question21 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question21"));
                String inspection_question22 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question22"));
                String inspection_question23 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question23"));
                String inspection_question24 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question24"));
                String inspection_question25 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question25"));
                String inspection_question26 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question26"));
                String inspection_question27 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question27"));
                String inspection_question28 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question28"));
                String inspection_question29 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question29"));
                String inspection_question30 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question30"));
                String inspection_question31 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question31"));
                String inspection_question32 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question32"));
                String inspection_question33 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question33"));
                String inspection_question34 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question34"));
                String inspection_question35 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question35"));
                String inspection_question36 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question36"));
                String inspection_question37 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question37"));
                String inspection_question38 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question38"));
                String inspection_question39 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question39"));
                String inspection_question40 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question40"));
                String inspection_question41 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question41"));
                String inspection_question42 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question42"));
                String inspection_question43 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question43"));
                String inspection_question44 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question44"));
                String inspection_question45 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question45"));
                String inspection_question46 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question46"));
                String inspection_question47 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question47"));
                String inspection_question48 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question48"));
                String inspection_question49 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question49"));
                String inspection_question50 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question50"));
                String inspection_question51 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question51"));
                String inspection_question52 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question52"));
                String inspection_question53 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question53"));
                String inspection_question54 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question54"));
                String inspection_question55 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question55"));
                String inspection_question56 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question56"));
                String inspection_question57 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question57"));
                String inspection_question58 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question58"));
                String inspection_question59 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question59"));
                String inspection_question60 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question60"));
                String inspection_question61 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question61"));
                String inspection_question62 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question62"));
                String inspection_question63 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question63"));
                String inspection_question64 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question64"));
                String inspection_question65 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question65"));
                String inspection_question66 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question66"));
                String inspection_question67 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question67"));
                String inspection_question68 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question68"));
                String inspection_location = cursor.getString(cursor.getColumnIndexOrThrow("inspection_location"));
                String farmer_photo = cursor.getString(cursor.getColumnIndexOrThrow("farmer_photo"));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow("signature"));
                String is_sync = cursor.getString(cursor.getColumnIndexOrThrow("is_sync"));
                String is_draft = cursor.getString(cursor.getColumnIndexOrThrow("is_draft"));
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow("user_fname"));
                String userLname = cursor.getString(cursor.getColumnIndexOrThrow("user_lname"));
                String user_email = cursor.getString(cursor.getColumnIndexOrThrow("user_email"));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow("on_create"));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow("on_update"));

                InspectionModel model = new InspectionModel(
                        id, farmer_id, farmer_name, district, community, inspection_question1,
                        inspection_question2, inspection_question3, inspection_question4, inspection_question5,
                        inspection_question6, inspection_question7, inspection_question8, inspection_question9,
                        inspection_question10, inspection_question11, inspection_question12, inspection_question13,
                        inspection_question14, inspection_question15, inspection_question16, inspection_question17,
                        inspection_question18, inspection_question19, inspection_question20, inspection_question21,
                        inspection_question22, inspection_question23, inspection_question24, inspection_question25,
                        inspection_question26, inspection_question27, inspection_question28, inspection_question29,
                        inspection_question30, inspection_question31, inspection_question32, inspection_question33,
                        inspection_question34, inspection_question35, inspection_question36, inspection_question37,
                        inspection_question38, inspection_question39, inspection_question40, inspection_question41,
                        inspection_question42, inspection_question43, inspection_question44, inspection_question45,
                        inspection_question46, inspection_question47, inspection_question48, inspection_question49,
                        inspection_question50, inspection_question51, inspection_question52, inspection_question53,
                        inspection_question54, inspection_question55, inspection_question56, inspection_question57,
                        inspection_question58, inspection_question59, inspection_question60, inspection_question61,
                        inspection_question62, inspection_question63, inspection_question64, inspection_question65,
                        inspection_question66, inspection_question67, inspection_question68,
                        inspection_location, farmer_photo != null ? Uri.parse(farmer_photo) : null,
                        signature, is_sync, is_draft, userFname, userLname, user_email, onCreate, onUpdate
                );

                surveyList.add(model);
            } while (cursor.moveToNext());

            cursor.close();
        }
        return surveyList;
    }

    public InspectionModel getSurveyDetailsByInspectionName(String farmer_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        InspectionModel inspectionModel = null;

        Cursor cursor = db.query(
                "InspectionTbl",
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
            String district = cursor.getString(cursor.getColumnIndexOrThrow("district"));
            String community = cursor.getString(cursor.getColumnIndexOrThrow("community"));
            String inspection_question1 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question1"));
            String inspection_question2 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question2"));
            String inspection_question3 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question3"));
            String inspection_question4 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question4"));
            String inspection_question5 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question5"));
            String inspection_question6 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question6"));
            String inspection_question7 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question7"));
            String inspection_question8 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question8"));
            String inspection_question9 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question9"));
            String inspection_question10 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question10"));
            String inspection_question11 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question11"));
            String inspection_question12 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question12"));
            String inspection_question13 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question13"));
            String inspection_question14 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question14"));
            String inspection_question15 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question15"));
            String inspection_question16 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question16"));
            String inspection_question17 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question17"));
            String inspection_question18 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question18"));
            String inspection_question19 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question19"));
            String inspection_question20 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question20"));
            String inspection_question21 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question21"));
            String inspection_question22 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question22"));
            String inspection_question23 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question23"));
            String inspection_question24 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question24"));
            String inspection_question25 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question25"));
            String inspection_question26 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question26"));
            String inspection_question27 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question27"));
            String inspection_question28 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question28"));
            String inspection_question29 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question29"));
            String inspection_question30 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question30"));
            String inspection_question31 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question31"));
            String inspection_question32 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question32"));
            String inspection_question33 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question33"));
            String inspection_question34 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question34"));
            String inspection_question35 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question35"));
            String inspection_question36 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question36"));
            String inspection_question37 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question37"));
            String inspection_question38 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question38"));
            String inspection_question39 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question39"));
            String inspection_question40 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question40"));
            String inspection_question41 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question41"));
            String inspection_question42 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question42"));
            String inspection_question43 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question43"));
            String inspection_question44 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question44"));
            String inspection_question45 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question45"));
            String inspection_question46 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question46"));
            String inspection_question47 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question47"));
            String inspection_question48 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question48"));
            String inspection_question49 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question49"));
            String inspection_question50 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question50"));
            String inspection_question51 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question51"));
            String inspection_question52 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question52"));
            String inspection_question53 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question53"));
            String inspection_question54 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question54"));
            String inspection_question55 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question55"));
            String inspection_question56 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question56"));
            String inspection_question57 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question57"));
            String inspection_question58 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question58"));
            String inspection_question59 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question59"));
            String inspection_question60 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question60"));
            String inspection_question61 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question61"));
            String inspection_question62 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question62"));
            String inspection_question63 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question63"));
            String inspection_question64 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question64"));
            String inspection_question65 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question65"));
            String inspection_question66 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question66"));
            String inspection_question67 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question67"));
            String inspection_question68 = cursor.getString(cursor.getColumnIndexOrThrow("inspection_question68"));
            String inspection_location = cursor.getString(cursor.getColumnIndexOrThrow("inspection_location"));
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

            inspectionModel = new InspectionModel(id, farmer_id, farmer_name, district, community,
                    inspection_question1, inspection_question2, inspection_question3, inspection_question4,
                    inspection_question5, inspection_question6, inspection_question7, inspection_question8,
                    inspection_question9, inspection_question10, inspection_question11, inspection_question12,
                    inspection_question13, inspection_question14, inspection_question15, inspection_question16,
                    inspection_question17, inspection_question18, inspection_question19, inspection_question20,
                    inspection_question21, inspection_question22, inspection_question23, inspection_question24,
                    inspection_question25, inspection_question26, inspection_question27, inspection_question28,
                    inspection_question29, inspection_question30, inspection_question31, inspection_question32,
                    inspection_question33, inspection_question34, inspection_question35, inspection_question36,
                    inspection_question37, inspection_question38, inspection_question39, inspection_question40,
                    inspection_question41, inspection_question42, inspection_question43, inspection_question44,
                    inspection_question45, inspection_question46, inspection_question47, inspection_question48,
                    inspection_question49, inspection_question50, inspection_question51, inspection_question52,
                    inspection_question53, inspection_question54, inspection_question55, inspection_question56,
                    inspection_question57, inspection_question58, inspection_question59, inspection_question60,
                    inspection_question61, inspection_question62, inspection_question63, inspection_question64,
                    inspection_question65, inspection_question66, inspection_question67, inspection_question68,
                    inspection_location, farmer_photo, signature, is_sync, is_draft,
                    userFname, userLname, user_email, on_create, on_update);
            cursor.close();
        }
        return inspectionModel;
    }

    public List<InspectionModel> getUnsyncedInspections() {
        List<InspectionModel> unsyncedList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM InspectionTbl WHERE is_sync = '0'", null);
        while (cursor.moveToNext()) {
            unsyncedList.add(InspectionModel.fromCursor(cursor));
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
        db.update("InspectionTbl", values, "farmer_id = ?", new String[]{farmer_id});
        db.close();
    }

    // (Optional) Mark multiple as synced in a batch
    public void markBatchAsSynced(List<InspectionModel> inspections) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (InspectionModel inspection : inspections) {
            ContentValues values = new ContentValues();
            values.put("is_sync", "1");
            db.update("InspectionTbl", values, "farmer_id = ?", new String[]{inspection.getFarmer_id()});
        }
        db.close();
    }
}