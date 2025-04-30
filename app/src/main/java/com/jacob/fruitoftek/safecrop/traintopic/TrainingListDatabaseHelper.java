package com.jacob.fruitoftek.safecrop.traintopic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class TrainingListDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "trainingtopic.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "trainingtopic_tbl";
    private static final String COL_TOPIC = "topic";
    private static final String COL_DESCRIPTION = "description";
    
    public TrainingListDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_TOPIC + " TEXT, "
                + COL_DESCRIPTION + " TEXT )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertTraining(TrainingListModal training) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_TOPIC, training.getTopic());
        values.put(COL_DESCRIPTION, training.getDescription());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<TrainingListModal> getAllTraining() {
        ArrayList<TrainingListModal> training = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                training.add(new TrainingListModal(
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_TOPIC)),
                        cursor.getString(cursor.getColumnIndexOrThrow(COL_DESCRIPTION))
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return training;
    }
}
