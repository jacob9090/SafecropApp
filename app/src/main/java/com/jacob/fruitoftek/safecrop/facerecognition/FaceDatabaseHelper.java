package com.jacob.fruitoftek.safecrop.facerecognition;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class FaceDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "FaceDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_FACES = "faces";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMBEDDINGS = "embeddings";
    private static final String KEY_IMAGE_PATH = "imagePath";

    public FaceDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FACES_TABLE = "CREATE TABLE " + TABLE_FACES + "(" +
                KEY_NAME + " TEXT PRIMARY KEY," +
                KEY_EMBEDDINGS + " TEXT," +
                KEY_IMAGE_PATH + " TEXT" + ")";
        db.execSQL(CREATE_FACES_TABLE);
    }

    public void addFace(String name, float[] embeddings, String imagePath) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_EMBEDDINGS, floatArrayToString(embeddings));
        values.put(KEY_IMAGE_PATH, imagePath);
        db.insert(TABLE_FACES, null, values);
        db.close();
    }

    public List<FaceModel> getAllFacesWithImages() {
        List<FaceModel> faceList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_FACES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                faceList.add(new FaceModel(
                        cursor.getString(0), // name
                        cursor.getString(2)  // image path
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return faceList;
    }

    public List<SimilarityClassifier.Recognition> getAllFaces() {
        List<SimilarityClassifier.Recognition> faceList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_FACES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                SimilarityClassifier.Recognition recognition = new SimilarityClassifier.Recognition(
                        cursor.getString(0), cursor.getString(0), -1f);
                recognition.setExtra(cursor.getString(1)); // embeddings
                faceList.add(recognition);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return faceList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FACES);
        onCreate(db);
    }

    // Helper methods to convert float[] to String and vice-versa
    private String floatArrayToString(float[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i > 0) sb.append(",");
            sb.append(a[i]);
        }
        return sb.toString();
    }

    private float[] stringToFloatArray(String s) {
        String[] values = s.split(",");
        float[] result = new float[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = Float.parseFloat(values[i]);
        }
        return result;
    }
}
