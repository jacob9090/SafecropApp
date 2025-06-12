package com.jacob.fruitoftek.safecrop.comdev.ch;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

public class ChildSurveyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ChildSurveyDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "ChildSurveyTbl";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_FARMER_ID = "farmer_id";
    private static final String COLUMN_FARMER_DISTRICT = "farmer_district";
    private static final String COLUMN_FARMER_VILLAGE = "farmer_village";
    private static final String COLUMN_CHILDQUESTION4 = "childquestion4";
    private static final String COLUMN_CHILD1QUESTION1 = "child1question1";
    private static final String COLUMN_CHILD1QUESTION2 = "child1question2";
    private static final String COLUMN_CHILD1QUESTION3 = "child1question3";
    private static final String COLUMN_CHILD1QUESTION4 = "child1question4";
    private static final String COLUMN_CHILD1QUESTION5 = "child1question5";
    private static final String COLUMN_CHILD1QUESTION6 = "child1question6";
    private static final String COLUMN_CHILD1QUESTION7 = "child1question7";
    private static final String COLUMN_CHILD1QUESTION8 = "child1question8";
    private static final String COLUMN_CHILD1QUESTION9 = "child1question9";
    private static final String COLUMN_CHILD1QUESTION10 = "child1question10";
    private static final String COLUMN_CHILD1QUESTION11 = "child1question11";
    private static final String COLUMN_CHILD1QUESTION12 = "child1question12";
    private static final String COLUMN_CHILD1QUESTION13 = "child1question13";
    private static final String COLUMN_CHILD1QUESTION14 = "child1question14";
    private static final String COLUMN_CHILD1QUESTION15 = "child1question15";
    private static final String COLUMN_CHILD1QUESTION16 = "child1question16";
    private static final String COLUMN_CHILD1QUESTION17 = "child1question17";
    private static final String COLUMN_CHILD1QUESTION18 = "child1question18";
    private static final String COLUMN_CHILD1QUESTION19 = "child1question19";
    private static final String COLUMN_CHILD2QUESTION1 = "child2question1";
    private static final String COLUMN_CHILD2QUESTION2 = "child2question2";
    private static final String COLUMN_CHILD2QUESTION3 = "child2question3";
    private static final String COLUMN_CHILD2QUESTION4 = "child2question4";
    private static final String COLUMN_CHILD2QUESTION5 = "child2question5";
    private static final String COLUMN_CHILD2QUESTION6 = "child2question6";
    private static final String COLUMN_CHILD2QUESTION7 = "child2question7";
    private static final String COLUMN_CHILD2QUESTION8 = "child2question8";
    private static final String COLUMN_CHILD2QUESTION9 = "child2question9";
    private static final String COLUMN_CHILD2QUESTION10 = "child2question10";
    private static final String COLUMN_CHILD2QUESTION11 = "child2question11";
    private static final String COLUMN_CHILD2QUESTION12 = "child2question12";
    private static final String COLUMN_CHILD2QUESTION13 = "child2question13";
    private static final String COLUMN_CHILD2QUESTION14 = "child2question14";
    private static final String COLUMN_CHILD2QUESTION15 = "child2question15";
    private static final String COLUMN_CHILD2QUESTION16 = "child2question16";
    private static final String COLUMN_CHILD2QUESTION17 = "child2question17";
    private static final String COLUMN_CHILD2QUESTION18 = "child2question18";
    private static final String COLUMN_CHILD2QUESTION19 = "child2question19";
    private static final String COLUMN_CHILD3QUESTION1 = "child3question1";
    private static final String COLUMN_CHILD3QUESTION2 = "child3question2";
    private static final String COLUMN_CHILD3QUESTION3 = "child3question3";
    private static final String COLUMN_CHILD3QUESTION4 = "child3question4";
    private static final String COLUMN_CHILD3QUESTION5 = "child3question5";
    private static final String COLUMN_CHILD3QUESTION6 = "child3question6";
    private static final String COLUMN_CHILD3QUESTION7 = "child3question7";
    private static final String COLUMN_CHILD3QUESTION8 = "child3question8";
    private static final String COLUMN_CHILD3QUESTION9 = "child3question9";
    private static final String COLUMN_CHILD3QUESTION10 = "child3question10";
    private static final String COLUMN_CHILD3QUESTION11 = "child3question11";
    private static final String COLUMN_CHILD3QUESTION12 = "child3question12";
    private static final String COLUMN_CHILD3QUESTION13 = "child3question13";
    private static final String COLUMN_CHILD3QUESTION14 = "child3question14";
    private static final String COLUMN_CHILD3QUESTION15 = "child3question15";
    private static final String COLUMN_CHILD3QUESTION16 = "child3question16";
    private static final String COLUMN_CHILD3QUESTION17 = "child3question17";
    private static final String COLUMN_CHILD3QUESTION18 = "child3question18";
    private static final String COLUMN_CHILD3QUESTION19 = "child3question19";
    private static final String COLUMN_CHILD4QUESTION1 = "child4question1";
    private static final String COLUMN_CHILD4QUESTION2 = "child4question2";
    private static final String COLUMN_CHILD4QUESTION3 = "child4question3";
    private static final String COLUMN_CHILD4QUESTION4 = "child4question4";
    private static final String COLUMN_CHILD4QUESTION5 = "child4question5";
    private static final String COLUMN_CHILD4QUESTION6 = "child4question6";
    private static final String COLUMN_CHILD4QUESTION7 = "child4question7";
    private static final String COLUMN_CHILD4QUESTION8 = "child4question8";
    private static final String COLUMN_CHILD4QUESTION9 = "child4question9";
    private static final String COLUMN_CHILD4QUESTION10 = "child4question10";
    private static final String COLUMN_CHILD4QUESTION11 = "child4question11";
    private static final String COLUMN_CHILD4QUESTION12 = "child4question12";
    private static final String COLUMN_CHILD4QUESTION13 = "child4question13";
    private static final String COLUMN_CHILD4QUESTION14 = "child4question14";
    private static final String COLUMN_CHILD4QUESTION15 = "child4question15";
    private static final String COLUMN_CHILD4QUESTION16 = "child4question16";
    private static final String COLUMN_CHILD4QUESTION17 = "child4question17";
    private static final String COLUMN_CHILD4QUESTION18 = "child4question18";
    private static final String COLUMN_CHILD4QUESTION19 = "child4question19";
    private static final String COLUMN_CHILD5QUESTION1 = "child5question1";
    private static final String COLUMN_CHILD5QUESTION2 = "child5question2";
    private static final String COLUMN_CHILD5QUESTION3 = "child5question3";
    private static final String COLUMN_CHILD5QUESTION4 = "child5question4";
    private static final String COLUMN_CHILD5QUESTION5 = "child5question5";
    private static final String COLUMN_CHILD5QUESTION6 = "child5question6";
    private static final String COLUMN_CHILD5QUESTION7 = "child5question7";
    private static final String COLUMN_CHILD5QUESTION8 = "child5question8";
    private static final String COLUMN_CHILD5QUESTION9 = "child5question9";
    private static final String COLUMN_CHILD5QUESTION10 = "child5question10";
    private static final String COLUMN_CHILD5QUESTION11 = "child5question11";
    private static final String COLUMN_CHILD5QUESTION12 = "child5question12";
    private static final String COLUMN_CHILD5QUESTION13 = "child5question13";
    private static final String COLUMN_CHILD5QUESTION14 = "child5question14";
    private static final String COLUMN_CHILD5QUESTION15 = "child5question15";
    private static final String COLUMN_CHILD5QUESTION16 = "child5question16";
    private static final String COLUMN_CHILD5QUESTION17 = "child5question17";
    private static final String COLUMN_CHILD5QUESTION18 = "child5question18";
    private static final String COLUMN_CHILD5QUESTION19 = "child5question19";
    private static final String COLUMN_CHILD6QUESTION1 = "child6question1";
    private static final String COLUMN_CHILD6QUESTION2 = "child6question2";
    private static final String COLUMN_CHILD6QUESTION3 = "child6question3";
    private static final String COLUMN_CHILD6QUESTION4 = "child6question4";
    private static final String COLUMN_CHILD6QUESTION5 = "child6question5";
    private static final String COLUMN_CHILD6QUESTION6 = "child6question6";
    private static final String COLUMN_CHILD6QUESTION7 = "child6question7";
    private static final String COLUMN_CHILD6QUESTION8 = "child6question8";
    private static final String COLUMN_CHILD6QUESTION9 = "child6question9";
    private static final String COLUMN_CHILD6QUESTION10 = "child6question10";
    private static final String COLUMN_CHILD6QUESTION11 = "child6question11";
    private static final String COLUMN_CHILD6QUESTION12 = "child6question12";
    private static final String COLUMN_CHILD6QUESTION13 = "child6question13";
    private static final String COLUMN_CHILD6QUESTION14 = "child6question14";
    private static final String COLUMN_CHILD6QUESTION15 = "child6question15";
    private static final String COLUMN_CHILD6QUESTION16 = "child6question16";
    private static final String COLUMN_CHILD6QUESTION17 = "child6question17";
    private static final String COLUMN_CHILD6QUESTION18 = "child6question18";
    private static final String COLUMN_CHILD6QUESTION19 = "child6question19";
    private static final String COLUMN_CHILD7QUESTION1 = "child7question1";
    private static final String COLUMN_CHILD7QUESTION2 = "child7question2";
    private static final String COLUMN_CHILD7QUESTION3 = "child7question3";
    private static final String COLUMN_CHILD7QUESTION4 = "child7question4";
    private static final String COLUMN_CHILD7QUESTION5 = "child7question5";
    private static final String COLUMN_CHILD7QUESTION6 = "child7question6";
    private static final String COLUMN_CHILD7QUESTION7 = "child7question7";
    private static final String COLUMN_CHILD7QUESTION8 = "child7question8";
    private static final String COLUMN_CHILD7QUESTION9 = "child7question9";
    private static final String COLUMN_CHILD7QUESTION10 = "child7question10";
    private static final String COLUMN_CHILD7QUESTION11 = "child7question11";
    private static final String COLUMN_CHILD7QUESTION12 = "child7question12";
    private static final String COLUMN_CHILD7QUESTION13 = "child7question13";
    private static final String COLUMN_CHILD7QUESTION14 = "child7question14";
    private static final String COLUMN_CHILD7QUESTION15 = "child7question15";
    private static final String COLUMN_CHILD7QUESTION16 = "child7question16";
    private static final String COLUMN_CHILD7QUESTION17 = "child7question17";
    private static final String COLUMN_CHILD7QUESTION18 = "child7question18";
    private static final String COLUMN_CHILD7QUESTION19 = "child7question19";
    private static final String COLUMN_CHILD8QUESTION1 = "child8question1";
    private static final String COLUMN_CHILD8QUESTION2 = "child8question2";
    private static final String COLUMN_CHILD8QUESTION3 = "child8question3";
    private static final String COLUMN_CHILD8QUESTION4 = "child8question4";
    private static final String COLUMN_CHILD8QUESTION5 = "child8question5";
    private static final String COLUMN_CHILD8QUESTION6 = "child8question6";
    private static final String COLUMN_CHILD8QUESTION7 = "child8question7";
    private static final String COLUMN_CHILD8QUESTION8 = "child8question8";
    private static final String COLUMN_CHILD8QUESTION9 = "child8question9";
    private static final String COLUMN_CHILD8QUESTION10 = "child8question10";
    private static final String COLUMN_CHILD8QUESTION11 = "child8question11";
    private static final String COLUMN_CHILD8QUESTION12 = "child8question12";
    private static final String COLUMN_CHILD8QUESTION13 = "child8question13";
    private static final String COLUMN_CHILD8QUESTION14 = "child8question14";
    private static final String COLUMN_CHILD8QUESTION15 = "child8question15";
    private static final String COLUMN_CHILD8QUESTION16 = "child8question16";
    private static final String COLUMN_CHILD8QUESTION17 = "child8question17";
    private static final String COLUMN_CHILD8QUESTION18 = "child8question18";
    private static final String COLUMN_CHILD8QUESTION19 = "child8question19";
    private static final String COLUMN_CHILD9QUESTION1 = "child9question1";
    private static final String COLUMN_CHILD9QUESTION2 = "child9question2";
    private static final String COLUMN_CHILD9QUESTION3 = "child9question3";
    private static final String COLUMN_CHILD9QUESTION4 = "child9question4";
    private static final String COLUMN_CHILD9QUESTION5 = "child9question5";
    private static final String COLUMN_CHILD9QUESTION6 = "child9question6";
    private static final String COLUMN_CHILD9QUESTION7 = "child9question7";
    private static final String COLUMN_CHILD9QUESTION8 = "child9question8";
    private static final String COLUMN_CHILD9QUESTION9 = "child9question9";
    private static final String COLUMN_CHILD9QUESTION10 = "child9question10";
    private static final String COLUMN_CHILD9QUESTION11 = "child9question11";
    private static final String COLUMN_CHILD9QUESTION12 = "child9question12";
    private static final String COLUMN_CHILD9QUESTION13 = "child9question13";
    private static final String COLUMN_CHILD9QUESTION14 = "child9question14";
    private static final String COLUMN_CHILD9QUESTION15 = "child9question15";
    private static final String COLUMN_CHILD9QUESTION16 = "child9question16";
    private static final String COLUMN_CHILD9QUESTION17 = "child9question17";
    private static final String COLUMN_CHILD9QUESTION18 = "child9question18";
    private static final String COLUMN_CHILD9QUESTION19 = "child9question19";
    private static final String COLUMN_CHILD10QUESTION1 = "child10question1";
    private static final String COLUMN_CHILD10QUESTION2 = "child10question2";
    private static final String COLUMN_CHILD10QUESTION3 = "child10question3";
    private static final String COLUMN_CHILD10QUESTION4 = "child10question4";
    private static final String COLUMN_CHILD10QUESTION5 = "child10question5";
    private static final String COLUMN_CHILD10QUESTION6 = "child10question6";
    private static final String COLUMN_CHILD10QUESTION7 = "child10question7";
    private static final String COLUMN_CHILD10QUESTION8 = "child10question8";
    private static final String COLUMN_CHILD10QUESTION9 = "child10question9";
    private static final String COLUMN_CHILD10QUESTION10 = "child10question10";
    private static final String COLUMN_CHILD10QUESTION11 = "child10question11";
    private static final String COLUMN_CHILD10QUESTION12 = "child10question12";
    private static final String COLUMN_CHILD10QUESTION13 = "child10question13";
    private static final String COLUMN_CHILD10QUESTION14 = "child10question14";
    private static final String COLUMN_CHILD10QUESTION15 = "child10question15";
    private static final String COLUMN_CHILD10QUESTION16 = "child10question16";
    private static final String COLUMN_CHILD10QUESTION17 = "child10question17";
    private static final String COLUMN_CHILD10QUESTION18 = "child10question18";
    private static final String COLUMN_CHILD10QUESTION19 = "child10question19";
    private static final String COLUMN_CHILDQUESTION5 = "childquestion5";
    private static final String COLUMN_CHILD_LOCATION = "child_location";
    private static final String COLUMN_SIGNATURE = "signature";
    private static final String COLUMN_USER_FNAME = "user_fname";
    private static final String COLUMN_USER_LNAME = "user_lname";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_ON_CREATE = "on_create";
    private static final String COLUMN_ON_UPDATE = "on_update";

    private Context context; // Add this line

    public ChildSurveyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context; // Initialize the context
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_FARMER_ID + " TEXT,"
                + COLUMN_FARMER_DISTRICT + " TEXT,"
                + COLUMN_FARMER_VILLAGE + " TEXT,"
                + COLUMN_CHILDQUESTION4 + " TEXT,"
                + COLUMN_CHILD1QUESTION1 + " TEXT,"
                + COLUMN_CHILD1QUESTION2 + " TEXT,"
                + COLUMN_CHILD1QUESTION3 + " TEXT,"
                + COLUMN_CHILD1QUESTION4 + " TEXT,"
                + COLUMN_CHILD1QUESTION5 + " TEXT,"
                + COLUMN_CHILD1QUESTION6 + " TEXT,"
                + COLUMN_CHILD1QUESTION7 + " TEXT,"
                + COLUMN_CHILD1QUESTION8 + " TEXT,"
                + COLUMN_CHILD1QUESTION9 + " TEXT,"
                + COLUMN_CHILD1QUESTION10 + " TEXT,"
                + COLUMN_CHILD1QUESTION11 + " TEXT,"
                + COLUMN_CHILD1QUESTION12 + " TEXT,"
                + COLUMN_CHILD1QUESTION13 + " TEXT,"
                + COLUMN_CHILD1QUESTION14 + " TEXT,"
                + COLUMN_CHILD1QUESTION15 + " TEXT,"
                + COLUMN_CHILD1QUESTION16 + " TEXT,"
                + COLUMN_CHILD1QUESTION17 + " TEXT,"
                + COLUMN_CHILD1QUESTION18 + " TEXT,"
                + COLUMN_CHILD1QUESTION19 + " TEXT,"
                + COLUMN_CHILD2QUESTION1 + " TEXT,"
                + COLUMN_CHILD2QUESTION2 + " TEXT,"
                + COLUMN_CHILD2QUESTION3 + " TEXT,"
                + COLUMN_CHILD2QUESTION4 + " TEXT,"
                + COLUMN_CHILD2QUESTION5 + " TEXT,"
                + COLUMN_CHILD2QUESTION6 + " TEXT,"
                + COLUMN_CHILD2QUESTION7 + " TEXT,"
                + COLUMN_CHILD2QUESTION8 + " TEXT,"
                + COLUMN_CHILD2QUESTION9 + " TEXT,"
                + COLUMN_CHILD2QUESTION10 + " TEXT,"
                + COLUMN_CHILD2QUESTION11 + " TEXT,"
                + COLUMN_CHILD2QUESTION12 + " TEXT,"
                + COLUMN_CHILD2QUESTION13 + " TEXT,"
                + COLUMN_CHILD2QUESTION14 + " TEXT,"
                + COLUMN_CHILD2QUESTION15 + " TEXT,"
                + COLUMN_CHILD2QUESTION16 + " TEXT,"
                + COLUMN_CHILD2QUESTION17 + " TEXT,"
                + COLUMN_CHILD2QUESTION18 + " TEXT,"
                + COLUMN_CHILD2QUESTION19 + " TEXT,"
                + COLUMN_CHILD3QUESTION1 + " TEXT,"
                + COLUMN_CHILD3QUESTION2 + " TEXT,"
                + COLUMN_CHILD3QUESTION3 + " TEXT,"
                + COLUMN_CHILD3QUESTION4 + " TEXT,"
                + COLUMN_CHILD3QUESTION5 + " TEXT,"
                + COLUMN_CHILD3QUESTION6 + " TEXT,"
                + COLUMN_CHILD3QUESTION7 + " TEXT,"
                + COLUMN_CHILD3QUESTION8 + " TEXT,"
                + COLUMN_CHILD3QUESTION9 + " TEXT,"
                + COLUMN_CHILD3QUESTION10 + " TEXT,"
                + COLUMN_CHILD3QUESTION11 + " TEXT,"
                + COLUMN_CHILD3QUESTION12 + " TEXT,"
                + COLUMN_CHILD3QUESTION13 + " TEXT,"
                + COLUMN_CHILD3QUESTION14 + " TEXT,"
                + COLUMN_CHILD3QUESTION15 + " TEXT,"
                + COLUMN_CHILD3QUESTION16 + " TEXT,"
                + COLUMN_CHILD3QUESTION17 + " TEXT,"
                + COLUMN_CHILD3QUESTION18 + " TEXT,"
                + COLUMN_CHILD3QUESTION19 + " TEXT,"
                + COLUMN_CHILD4QUESTION1 + " TEXT,"
                + COLUMN_CHILD4QUESTION2 + " TEXT,"
                + COLUMN_CHILD4QUESTION3 + " TEXT,"
                + COLUMN_CHILD4QUESTION4 + " TEXT,"
                + COLUMN_CHILD4QUESTION5 + " TEXT,"
                + COLUMN_CHILD4QUESTION6 + " TEXT,"
                + COLUMN_CHILD4QUESTION7 + " TEXT,"
                + COLUMN_CHILD4QUESTION8 + " TEXT,"
                + COLUMN_CHILD4QUESTION9 + " TEXT,"
                + COLUMN_CHILD4QUESTION10 + " TEXT,"
                + COLUMN_CHILD4QUESTION11 + " TEXT,"
                + COLUMN_CHILD4QUESTION12 + " TEXT,"
                + COLUMN_CHILD4QUESTION13 + " TEXT,"
                + COLUMN_CHILD4QUESTION14 + " TEXT,"
                + COLUMN_CHILD4QUESTION15 + " TEXT,"
                + COLUMN_CHILD4QUESTION16 + " TEXT,"
                + COLUMN_CHILD4QUESTION17 + " TEXT,"
                + COLUMN_CHILD4QUESTION18 + " TEXT,"
                + COLUMN_CHILD4QUESTION19 + " TEXT,"
                + COLUMN_CHILD5QUESTION1 + " TEXT,"
                + COLUMN_CHILD5QUESTION2 + " TEXT,"
                + COLUMN_CHILD5QUESTION3 + " TEXT,"
                + COLUMN_CHILD5QUESTION4 + " TEXT,"
                + COLUMN_CHILD5QUESTION5 + " TEXT,"
                + COLUMN_CHILD5QUESTION6 + " TEXT,"
                + COLUMN_CHILD5QUESTION7 + " TEXT,"
                + COLUMN_CHILD5QUESTION8 + " TEXT,"
                + COLUMN_CHILD5QUESTION9 + " TEXT,"
                + COLUMN_CHILD5QUESTION10 + " TEXT,"
                + COLUMN_CHILD5QUESTION11 + " TEXT,"
                + COLUMN_CHILD5QUESTION12 + " TEXT,"
                + COLUMN_CHILD5QUESTION13 + " TEXT,"
                + COLUMN_CHILD5QUESTION14 + " TEXT,"
                + COLUMN_CHILD5QUESTION15 + " TEXT,"
                + COLUMN_CHILD5QUESTION16 + " TEXT,"
                + COLUMN_CHILD5QUESTION17 + " TEXT,"
                + COLUMN_CHILD5QUESTION18 + " TEXT,"
                + COLUMN_CHILD5QUESTION19 + " TEXT,"
                + COLUMN_CHILD6QUESTION1 + " TEXT,"
                + COLUMN_CHILD6QUESTION2 + " TEXT,"
                + COLUMN_CHILD6QUESTION3 + " TEXT,"
                + COLUMN_CHILD6QUESTION4 + " TEXT,"
                + COLUMN_CHILD6QUESTION5 + " TEXT,"
                + COLUMN_CHILD6QUESTION6 + " TEXT,"
                + COLUMN_CHILD6QUESTION7 + " TEXT,"
                + COLUMN_CHILD6QUESTION8 + " TEXT,"
                + COLUMN_CHILD6QUESTION9 + " TEXT,"
                + COLUMN_CHILD6QUESTION10 + " TEXT,"
                + COLUMN_CHILD6QUESTION11 + " TEXT,"
                + COLUMN_CHILD6QUESTION12 + " TEXT,"
                + COLUMN_CHILD6QUESTION13 + " TEXT,"
                + COLUMN_CHILD6QUESTION14 + " TEXT,"
                + COLUMN_CHILD6QUESTION15 + " TEXT,"
                + COLUMN_CHILD6QUESTION16 + " TEXT,"
                + COLUMN_CHILD6QUESTION17 + " TEXT,"
                + COLUMN_CHILD6QUESTION18 + " TEXT,"
                + COLUMN_CHILD6QUESTION19 + " TEXT,"
                + COLUMN_CHILD7QUESTION1 + " TEXT,"
                + COLUMN_CHILD7QUESTION2 + " TEXT,"
                + COLUMN_CHILD7QUESTION3 + " TEXT,"
                + COLUMN_CHILD7QUESTION4 + " TEXT,"
                + COLUMN_CHILD7QUESTION5 + " TEXT,"
                + COLUMN_CHILD7QUESTION6 + " TEXT,"
                + COLUMN_CHILD7QUESTION7 + " TEXT,"
                + COLUMN_CHILD7QUESTION8 + " TEXT,"
                + COLUMN_CHILD7QUESTION9 + " TEXT,"
                + COLUMN_CHILD7QUESTION10 + " TEXT,"
                + COLUMN_CHILD7QUESTION11 + " TEXT,"
                + COLUMN_CHILD7QUESTION12 + " TEXT,"
                + COLUMN_CHILD7QUESTION13 + " TEXT,"
                + COLUMN_CHILD7QUESTION14 + " TEXT,"
                + COLUMN_CHILD7QUESTION15 + " TEXT,"
                + COLUMN_CHILD7QUESTION16 + " TEXT,"
                + COLUMN_CHILD7QUESTION17 + " TEXT,"
                + COLUMN_CHILD7QUESTION18 + " TEXT,"
                + COLUMN_CHILD7QUESTION19 + " TEXT,"
                + COLUMN_CHILD8QUESTION1 + " TEXT,"
                + COLUMN_CHILD8QUESTION2 + " TEXT,"
                + COLUMN_CHILD8QUESTION3 + " TEXT,"
                + COLUMN_CHILD8QUESTION4 + " TEXT,"
                + COLUMN_CHILD8QUESTION5 + " TEXT,"
                + COLUMN_CHILD8QUESTION6 + " TEXT,"
                + COLUMN_CHILD8QUESTION7 + " TEXT,"
                + COLUMN_CHILD8QUESTION8 + " TEXT,"
                + COLUMN_CHILD8QUESTION9 + " TEXT,"
                + COLUMN_CHILD8QUESTION10 + " TEXT,"
                + COLUMN_CHILD8QUESTION11 + " TEXT,"
                + COLUMN_CHILD8QUESTION12 + " TEXT,"
                + COLUMN_CHILD8QUESTION13 + " TEXT,"
                + COLUMN_CHILD8QUESTION14 + " TEXT,"
                + COLUMN_CHILD8QUESTION15 + " TEXT,"
                + COLUMN_CHILD8QUESTION16 + " TEXT,"
                + COLUMN_CHILD8QUESTION17 + " TEXT,"
                + COLUMN_CHILD8QUESTION18 + " TEXT,"
                + COLUMN_CHILD8QUESTION19 + " TEXT,"
                + COLUMN_CHILD9QUESTION1 + " TEXT,"
                + COLUMN_CHILD9QUESTION2 + " TEXT,"
                + COLUMN_CHILD9QUESTION3 + " TEXT,"
                + COLUMN_CHILD9QUESTION4 + " TEXT,"
                + COLUMN_CHILD9QUESTION5 + " TEXT,"
                + COLUMN_CHILD9QUESTION6 + " TEXT,"
                + COLUMN_CHILD9QUESTION7 + " TEXT,"
                + COLUMN_CHILD9QUESTION8 + " TEXT,"
                + COLUMN_CHILD9QUESTION9 + " TEXT,"
                + COLUMN_CHILD9QUESTION10 + " TEXT,"
                + COLUMN_CHILD9QUESTION11 + " TEXT,"
                + COLUMN_CHILD9QUESTION12 + " TEXT,"
                + COLUMN_CHILD9QUESTION13 + " TEXT,"
                + COLUMN_CHILD9QUESTION14 + " TEXT,"
                + COLUMN_CHILD9QUESTION15 + " TEXT,"
                + COLUMN_CHILD9QUESTION16 + " TEXT,"
                + COLUMN_CHILD9QUESTION17 + " TEXT,"
                + COLUMN_CHILD9QUESTION18 + " TEXT,"
                + COLUMN_CHILD9QUESTION19 + " TEXT,"
                + COLUMN_CHILD10QUESTION1 + " TEXT,"
                + COLUMN_CHILD10QUESTION2 + " TEXT,"
                + COLUMN_CHILD10QUESTION3 + " TEXT,"
                + COLUMN_CHILD10QUESTION4 + " TEXT,"
                + COLUMN_CHILD10QUESTION5 + " TEXT,"
                + COLUMN_CHILD10QUESTION6 + " TEXT,"
                + COLUMN_CHILD10QUESTION7 + " TEXT,"
                + COLUMN_CHILD10QUESTION8 + " TEXT,"
                + COLUMN_CHILD10QUESTION9 + " TEXT,"
                + COLUMN_CHILD10QUESTION10 + " TEXT,"
                + COLUMN_CHILD10QUESTION11 + " TEXT,"
                + COLUMN_CHILD10QUESTION12 + " TEXT,"
                + COLUMN_CHILD10QUESTION13 + " TEXT,"
                + COLUMN_CHILD10QUESTION14 + " TEXT,"
                + COLUMN_CHILD10QUESTION15 + " TEXT,"
                + COLUMN_CHILD10QUESTION16 + " TEXT,"
                + COLUMN_CHILD10QUESTION17 + " TEXT,"
                + COLUMN_CHILD10QUESTION18 + " TEXT,"
                + COLUMN_CHILD10QUESTION19 + " TEXT,"
                + COLUMN_CHILDQUESTION5 + " TEXT,"
                + COLUMN_CHILD_LOCATION + " TEXT,"
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

//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if (oldVersion < 2) { // Assuming version 2 introduces new columns
//            db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN child10question15 TEXT DEFAULT '';");
//            db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN user_email TEXT DEFAULT '';");
//        }
//    }

    public void insertSurveyData(String farmerId, String farmerDistrict, String farmerVillage,
                                 String childquestion4, String child1question1, String child1question2, String child1question3,
                                 String child1question4, String child1question5, String child1question6, String child1question7,
                                 String child1question8, String child1question9, String child1question10, String child1question11,
                                 String child1question12, String child1question13, String child1question14, String child1question15,
                                 String child1question16, String child1question17, String child1question18, String child1question19,
                                 String child2question1, String child2question2, String child2question3, String child2question4,
                                 String child2question5, String child2question6, String child2question7, String child2question8,
                                 String child2question9, String child2question10, String child2question11, String child2question12,
                                 String child2question13, String child2question14, String child2question15, String child2question16,
                                 String child2question17, String child2question18, String child2question19, String child3question1,
                                 String child3question2, String child3question3, String child3question4, String child3question5,
                                 String child3question6, String child3question7, String child3question8, String child3question9,
                                 String child3question10, String child3question11, String child3question12, String child3question13,
                                 String child3question14, String child3question15, String child3question16, String child3question17,
                                 String child3question18, String child3question19, String child4question1, String child4question2,
                                 String child4question3, String child4question4, String child4question5, String child4question6,
                                 String child4question7, String child4question8, String child4question9, String child4question10,
                                 String child4question11, String child4question12, String child4question13, String child4question14,
                                 String child4question15, String child4question16, String child4question17, String child4question18,
                                 String child4question19, String child5question1, String child5question2, String child5question3,
                                 String child5question4, String child5question5, String child5question6, String child5question7,
                                 String child5question8, String child5question9, String child5question10, String child5question11,
                                 String child5question12, String child5question13, String child5question14, String child5question15,
                                 String child5question16, String child5question17, String child5question18, String child5question19,
                                 String child6question1, String child6question2, String child6question3, String child6question4,
                                 String child6question5, String child6question6, String child6question7, String child6question8,
                                 String child6question9, String child6question10, String child6question11, String child6question12,
                                 String child6question13, String child6question14, String child6question15, String child6question16,
                                 String child6question17, String child6question18, String child6question19, String child7question1,
                                 String child7question2, String child7question3, String child7question4, String child7question5,
                                 String child7question6, String child7question7, String child7question8, String child7question9,
                                 String child7question10, String child7question11, String child7question12, String child7question13,
                                 String child7question14, String child7question15, String child7question16, String child7question17,
                                 String child7question18, String child7question19, String child8question1, String child8question2,
                                 String child8question3, String child8question4, String child8question5, String child8question6,
                                 String child8question7, String child8question8, String child8question9, String child8question10,
                                 String child8question11, String child8question12, String child8question13, String child8question14,
                                 String child8question15, String child8question16, String child8question17, String child8question18,
                                 String child8question19, String child9question1, String child9question2, String child9question3,
                                 String child9question4, String child9question5, String child9question6, String child9question7,
                                 String child9question8, String child9question9, String child9question10, String child9question11,
                                 String child9question12, String child9question13, String child9question14, String child9question15,
                                 String child9question16, String child9question17, String child9question18, String child9question19,
                                 String child10question1, String child10question2, String child10question3, String child10question4,
                                 String child10question5, String child10question6, String child10question7, String child10question8,
                                 String child10question9, String child10question10, String child10question11, String child10question12,
                                 String child10question13, String child10question14, String child10question15, String child10question16,
                                 String child10question17, String child10question18, String child10question19, String childquestion5,
                                 String childLocation, String signatureBase64, String userFname, String userLname, String userEmail,
                                 String onCreate, String onUpdate) {
        String signaturePath = null;
        try {
            signaturePath = saveSignatureImage(signatureBase64);
        } catch (IOException e) {
            Log.e("ChildSurveyDBHelper", "Error saving signature image", e);
        }

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FARMER_ID, farmerId);
        values.put(COLUMN_FARMER_DISTRICT, farmerDistrict);
        values.put(COLUMN_FARMER_VILLAGE, farmerVillage);
        values.put(COLUMN_CHILDQUESTION4, childquestion4);
        values.put(COLUMN_CHILD1QUESTION1, child1question1);
        values.put(COLUMN_CHILD1QUESTION2, child1question2);
        values.put(COLUMN_CHILD1QUESTION3, child1question3);
        values.put(COLUMN_CHILD1QUESTION4, child1question4);
        values.put(COLUMN_CHILD1QUESTION5, child1question5);
        values.put(COLUMN_CHILD1QUESTION6, child1question6);
        values.put(COLUMN_CHILD1QUESTION7, child1question7);
        values.put(COLUMN_CHILD1QUESTION8, child1question8);
        values.put(COLUMN_CHILD1QUESTION9, child1question9);
        values.put(COLUMN_CHILD1QUESTION10, child1question10);
        values.put(COLUMN_CHILD1QUESTION11, child1question11);
        values.put(COLUMN_CHILD1QUESTION12, child1question12);
        values.put(COLUMN_CHILD1QUESTION13, child1question13);
        values.put(COLUMN_CHILD1QUESTION14, child1question14);
        values.put(COLUMN_CHILD1QUESTION15, child1question15);
        values.put(COLUMN_CHILD1QUESTION16, child1question16);
        values.put(COLUMN_CHILD1QUESTION17, child1question17);
        values.put(COLUMN_CHILD1QUESTION18, child1question18);
        values.put(COLUMN_CHILD1QUESTION19, child1question19);
        values.put(COLUMN_CHILD2QUESTION1, child2question1);
        values.put(COLUMN_CHILD2QUESTION2, child2question2);
        values.put(COLUMN_CHILD2QUESTION3, child2question3);
        values.put(COLUMN_CHILD2QUESTION4, child2question4);
        values.put(COLUMN_CHILD2QUESTION5, child2question5);
        values.put(COLUMN_CHILD2QUESTION6, child2question6);
        values.put(COLUMN_CHILD2QUESTION7, child2question7);
        values.put(COLUMN_CHILD2QUESTION8, child2question8);
        values.put(COLUMN_CHILD2QUESTION9, child2question9);
        values.put(COLUMN_CHILD2QUESTION10, child2question10);
        values.put(COLUMN_CHILD2QUESTION11, child2question11);
        values.put(COLUMN_CHILD2QUESTION12, child2question12);
        values.put(COLUMN_CHILD2QUESTION13, child2question13);
        values.put(COLUMN_CHILD2QUESTION14, child2question14);
        values.put(COLUMN_CHILD2QUESTION15, child2question15);
        values.put(COLUMN_CHILD2QUESTION16, child2question16);
        values.put(COLUMN_CHILD2QUESTION17, child2question17);
        values.put(COLUMN_CHILD2QUESTION18, child2question18);
        values.put(COLUMN_CHILD2QUESTION19, child2question19);
        values.put(COLUMN_CHILD3QUESTION1, child3question1);
        values.put(COLUMN_CHILD3QUESTION2, child3question2);
        values.put(COLUMN_CHILD3QUESTION3, child3question3);
        values.put(COLUMN_CHILD3QUESTION4, child3question4);
        values.put(COLUMN_CHILD3QUESTION5, child3question5);
        values.put(COLUMN_CHILD3QUESTION6, child3question6);
        values.put(COLUMN_CHILD3QUESTION7, child3question7);
        values.put(COLUMN_CHILD3QUESTION8, child3question8);
        values.put(COLUMN_CHILD3QUESTION9, child3question9);
        values.put(COLUMN_CHILD3QUESTION10, child3question10);
        values.put(COLUMN_CHILD3QUESTION11, child3question11);
        values.put(COLUMN_CHILD3QUESTION12, child3question12);
        values.put(COLUMN_CHILD3QUESTION13, child3question13);
        values.put(COLUMN_CHILD3QUESTION14, child3question14);
        values.put(COLUMN_CHILD3QUESTION15, child3question15);
        values.put(COLUMN_CHILD3QUESTION16, child3question16);
        values.put(COLUMN_CHILD3QUESTION17, child3question17);
        values.put(COLUMN_CHILD3QUESTION18, child3question18);
        values.put(COLUMN_CHILD3QUESTION19, child3question19);
        values.put(COLUMN_CHILD4QUESTION1, child4question1);
        values.put(COLUMN_CHILD4QUESTION2, child4question2);
        values.put(COLUMN_CHILD4QUESTION3, child4question3);
        values.put(COLUMN_CHILD4QUESTION4, child4question4);
        values.put(COLUMN_CHILD4QUESTION5, child4question5);
        values.put(COLUMN_CHILD4QUESTION6, child4question6);
        values.put(COLUMN_CHILD4QUESTION7, child4question7);
        values.put(COLUMN_CHILD4QUESTION8, child4question8);
        values.put(COLUMN_CHILD4QUESTION9, child4question9);
        values.put(COLUMN_CHILD4QUESTION10, child4question10);
        values.put(COLUMN_CHILD4QUESTION11, child4question11);
        values.put(COLUMN_CHILD4QUESTION12, child4question12);
        values.put(COLUMN_CHILD4QUESTION13, child4question13);
        values.put(COLUMN_CHILD4QUESTION14, child4question14);
        values.put(COLUMN_CHILD4QUESTION15, child4question15);
        values.put(COLUMN_CHILD4QUESTION16, child4question16);
        values.put(COLUMN_CHILD4QUESTION17, child4question17);
        values.put(COLUMN_CHILD4QUESTION18, child4question18);
        values.put(COLUMN_CHILD4QUESTION19, child4question19);
        values.put(COLUMN_CHILD5QUESTION1, child5question1);
        values.put(COLUMN_CHILD5QUESTION2, child5question2);
        values.put(COLUMN_CHILD5QUESTION3, child5question3);
        values.put(COLUMN_CHILD5QUESTION4, child5question4);
        values.put(COLUMN_CHILD5QUESTION5, child5question5);
        values.put(COLUMN_CHILD5QUESTION6, child5question6);
        values.put(COLUMN_CHILD5QUESTION7, child5question7);
        values.put(COLUMN_CHILD5QUESTION8, child5question8);
        values.put(COLUMN_CHILD5QUESTION9, child5question9);
        values.put(COLUMN_CHILD5QUESTION10, child5question10);
        values.put(COLUMN_CHILD5QUESTION11, child5question11);
        values.put(COLUMN_CHILD5QUESTION12, child5question12);
        values.put(COLUMN_CHILD5QUESTION13, child5question13);
        values.put(COLUMN_CHILD5QUESTION14, child5question14);
        values.put(COLUMN_CHILD5QUESTION15, child5question15);
        values.put(COLUMN_CHILD5QUESTION16, child5question16);
        values.put(COLUMN_CHILD5QUESTION17, child5question17);
        values.put(COLUMN_CHILD5QUESTION18, child5question18);
        values.put(COLUMN_CHILD5QUESTION19, child5question19);
        values.put(COLUMN_CHILD6QUESTION1, child6question1);
        values.put(COLUMN_CHILD6QUESTION2, child6question2);
        values.put(COLUMN_CHILD6QUESTION3, child6question3);
        values.put(COLUMN_CHILD6QUESTION4, child6question4);
        values.put(COLUMN_CHILD6QUESTION5, child6question5);
        values.put(COLUMN_CHILD6QUESTION6, child6question6);
        values.put(COLUMN_CHILD6QUESTION7, child6question7);
        values.put(COLUMN_CHILD6QUESTION8, child6question8);
        values.put(COLUMN_CHILD6QUESTION9, child6question9);
        values.put(COLUMN_CHILD6QUESTION10, child6question10);
        values.put(COLUMN_CHILD6QUESTION11, child6question11);
        values.put(COLUMN_CHILD6QUESTION12, child6question12);
        values.put(COLUMN_CHILD6QUESTION13, child6question13);
        values.put(COLUMN_CHILD6QUESTION14, child6question14);
        values.put(COLUMN_CHILD6QUESTION15, child6question15);
        values.put(COLUMN_CHILD6QUESTION16, child6question16);
        values.put(COLUMN_CHILD6QUESTION17, child6question17);
        values.put(COLUMN_CHILD6QUESTION18, child6question18);
        values.put(COLUMN_CHILD6QUESTION19, child6question19);
        values.put(COLUMN_CHILD7QUESTION1, child7question1);
        values.put(COLUMN_CHILD7QUESTION2, child7question2);
        values.put(COLUMN_CHILD7QUESTION3, child7question3);
        values.put(COLUMN_CHILD7QUESTION4, child7question4);
        values.put(COLUMN_CHILD7QUESTION5, child7question5);
        values.put(COLUMN_CHILD7QUESTION6, child7question6);
        values.put(COLUMN_CHILD7QUESTION7, child7question7);
        values.put(COLUMN_CHILD7QUESTION8, child7question8);
        values.put(COLUMN_CHILD7QUESTION9, child7question9);
        values.put(COLUMN_CHILD7QUESTION10, child7question10);
        values.put(COLUMN_CHILD7QUESTION11, child7question11);
        values.put(COLUMN_CHILD7QUESTION12, child7question12);
        values.put(COLUMN_CHILD7QUESTION13, child7question13);
        values.put(COLUMN_CHILD7QUESTION14, child7question14);
        values.put(COLUMN_CHILD7QUESTION15, child7question15);
        values.put(COLUMN_CHILD7QUESTION16, child7question16);
        values.put(COLUMN_CHILD7QUESTION17, child7question17);
        values.put(COLUMN_CHILD7QUESTION18, child7question18);
        values.put(COLUMN_CHILD7QUESTION19, child7question19);
        values.put(COLUMN_CHILD8QUESTION1, child8question1);
        values.put(COLUMN_CHILD8QUESTION2, child8question2);
        values.put(COLUMN_CHILD8QUESTION3, child8question3);
        values.put(COLUMN_CHILD8QUESTION4, child8question4);
        values.put(COLUMN_CHILD8QUESTION5, child8question5);
        values.put(COLUMN_CHILD8QUESTION6, child8question6);
        values.put(COLUMN_CHILD8QUESTION7, child8question7);
        values.put(COLUMN_CHILD8QUESTION8, child8question8);
        values.put(COLUMN_CHILD8QUESTION9, child8question9);
        values.put(COLUMN_CHILD8QUESTION10, child8question10);
        values.put(COLUMN_CHILD8QUESTION11, child8question11);
        values.put(COLUMN_CHILD8QUESTION12, child8question12);
        values.put(COLUMN_CHILD8QUESTION13, child8question13);
        values.put(COLUMN_CHILD8QUESTION14, child8question14);
        values.put(COLUMN_CHILD8QUESTION15, child8question15);
        values.put(COLUMN_CHILD8QUESTION16, child8question16);
        values.put(COLUMN_CHILD8QUESTION17, child8question17);
        values.put(COLUMN_CHILD8QUESTION18, child8question18);
        values.put(COLUMN_CHILD8QUESTION19, child8question19);
        values.put(COLUMN_CHILD9QUESTION1, child9question1);
        values.put(COLUMN_CHILD9QUESTION2, child9question2);
        values.put(COLUMN_CHILD9QUESTION3, child9question3);
        values.put(COLUMN_CHILD9QUESTION4, child9question4);
        values.put(COLUMN_CHILD9QUESTION5, child9question5);
        values.put(COLUMN_CHILD9QUESTION6, child9question6);
        values.put(COLUMN_CHILD9QUESTION7, child9question7);
        values.put(COLUMN_CHILD9QUESTION8, child9question8);
        values.put(COLUMN_CHILD9QUESTION9, child9question9);
        values.put(COLUMN_CHILD9QUESTION10, child9question10);
        values.put(COLUMN_CHILD9QUESTION11, child9question11);
        values.put(COLUMN_CHILD9QUESTION12, child9question12);
        values.put(COLUMN_CHILD9QUESTION13, child9question13);
        values.put(COLUMN_CHILD9QUESTION14, child9question14);
        values.put(COLUMN_CHILD9QUESTION15, child9question15);
        values.put(COLUMN_CHILD9QUESTION16, child9question16);
        values.put(COLUMN_CHILD9QUESTION17, child9question17);
        values.put(COLUMN_CHILD9QUESTION18, child9question18);
        values.put(COLUMN_CHILD9QUESTION19, child9question19);
        values.put(COLUMN_CHILD10QUESTION1, child10question1);
        values.put(COLUMN_CHILD10QUESTION2, child10question2);
        values.put(COLUMN_CHILD10QUESTION3, child10question3);
        values.put(COLUMN_CHILD10QUESTION4, child10question4);
        values.put(COLUMN_CHILD10QUESTION5, child10question5);
        values.put(COLUMN_CHILD10QUESTION6, child10question6);
        values.put(COLUMN_CHILD10QUESTION7, child10question7);
        values.put(COLUMN_CHILD10QUESTION8, child10question8);
        values.put(COLUMN_CHILD10QUESTION9, child10question9);
        values.put(COLUMN_CHILD10QUESTION10, child10question10);
        values.put(COLUMN_CHILD10QUESTION11, child10question11);
        values.put(COLUMN_CHILD10QUESTION12, child10question12);
        values.put(COLUMN_CHILD10QUESTION13, child10question13);
        values.put(COLUMN_CHILD10QUESTION14, child10question14);
        values.put(COLUMN_CHILD10QUESTION15, child10question15);
        values.put(COLUMN_CHILD10QUESTION16, child10question16);
        values.put(COLUMN_CHILD10QUESTION17, child10question17);
        values.put(COLUMN_CHILD10QUESTION18, child10question18);
        values.put(COLUMN_CHILD10QUESTION19, child10question19);
        values.put(COLUMN_CHILDQUESTION5, childquestion5);
        values.put(COLUMN_CHILD_LOCATION, childLocation);
        values.put(COLUMN_SIGNATURE, signaturePath);
        values.put(COLUMN_USER_FNAME, userFname);
        values.put(COLUMN_USER_LNAME, userLname);
        values.put(COLUMN_USER_EMAIL, userEmail);
        values.put(COLUMN_ON_CREATE, onCreate);
        values.put(COLUMN_ON_UPDATE, onUpdate);

        db.insert(TABLE_NAME, null, values);
        db.close();
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
            File directory = new File(parentDirectory, "child-signature");
            if (!directory.exists() && !directory.mkdirs()) {
                throw new IOException("Failed to create child directory");
            }

            File signatureFile = new File(directory, "signature_" + System.currentTimeMillis() + ".png");
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

    public void updateSurveyData(String farmerId, String farmerDistrict, String farmerVillage,
                                 String childquestion4, String child1question1, String child1question2, String child1question3,
                                 String child1question4, String child1question5, String child1question6, String child1question7,
                                 String child1question8, String child1question9, String child1question10, String child1question11,
                                 String child1question12, String child1question13, String child1question14, String child1question15,
                                 String child1question16, String child1question17, String child1question18, String child1question19,
                                 String child2question1, String child2question2, String child2question3, String child2question4,
                                 String child2question5, String child2question6, String child2question7, String child2question8,
                                 String child2question9, String child2question10, String child2question11, String child2question12,
                                 String child2question13, String child2question14, String child2question15, String child2question16,
                                 String child2question17, String child2question18, String child2question19, String child3question1,
                                 String child3question2, String child3question3, String child3question4, String child3question5,
                                 String child3question6, String child3question7, String child3question8, String child3question9,
                                 String child3question10, String child3question11, String child3question12, String child3question13,
                                 String child3question14, String child3question15, String child3question16, String child3question17,
                                 String child3question18, String child3question19, String child4question1, String child4question2,
                                 String child4question3, String child4question4, String child4question5, String child4question6,
                                 String child4question7, String child4question8, String child4question9, String child4question10,
                                 String child4question11, String child4question12, String child4question13, String child4question14,
                                 String child4question15, String child4question16, String child4question17, String child4question18,
                                 String child4question19, String child5question1, String child5question2, String child5question3,
                                 String child5question4, String child5question5, String child5question6, String child5question7,
                                 String child5question8, String child5question9, String child5question10, String child5question11,
                                 String child5question12, String child5question13, String child5question14, String child5question15,
                                 String child5question16, String child5question17, String child5question18, String child5question19,
                                 String child6question1, String child6question2, String child6question3, String child6question4,
                                 String child6question5, String child6question6, String child6question7, String child6question8,
                                 String child6question9, String child6question10, String child6question11, String child6question12,
                                 String child6question13, String child6question14, String child6question15, String child6question16,
                                 String child6question17, String child6question18, String child6question19, String child7question1,
                                 String child7question2, String child7question3, String child7question4, String child7question5,
                                 String child7question6, String child7question7, String child7question8, String child7question9,
                                 String child7question10, String child7question11, String child7question12, String child7question13,
                                 String child7question14, String child7question15, String child7question16, String child7question17,
                                 String child7question18, String child7question19, String child8question1, String child8question2,
                                 String child8question3, String child8question4, String child8question5, String child8question6,
                                 String child8question7, String child8question8, String child8question9, String child8question10,
                                 String child8question11, String child8question12, String child8question13, String child8question14,
                                 String child8question15, String child8question16, String child8question17, String child8question18,
                                 String child8question19, String child9question1, String child9question2, String child9question3,
                                 String child9question4, String child9question5, String child9question6, String child9question7,
                                 String child9question8, String child9question9, String child9question10, String child9question11,
                                 String child9question12, String child9question13, String child9question14, String child9question15,
                                 String child9question16, String child9question17, String child9question18, String child9question19,
                                 String child10question1, String child10question2, String child10question3, String child10question4,
                                 String child10question5, String child10question6, String child10question7, String child10question8,
                                 String child10question9, String child10question10, String child10question11, String child10question12,
                                 String child10question13, String child10question14, String child10question15, String child10question16, String child10question17,
                                 String child10question18, String child10question19, String childquestion5, String childLocation) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("farmer_district", farmerDistrict);
        values.put("farmer_village", farmerVillage);
        values.put("childquestion4", childquestion4);
        values.put("child1question1", child1question1);
        values.put("child1question2", child1question2);
        values.put("child1question3", child1question3);
        values.put("child1question4", child1question4);
        values.put("child1question5", child1question5);
        values.put("child1question6", child1question6);
        values.put("child1question7", child1question7);
        values.put("child1question8", child1question8);
        values.put("child1question9", child1question9);
        values.put("child1question10", child1question10);
        values.put("child1question11", child1question11);
        values.put("child1question12", child1question12);
        values.put("child1question13", child1question13);
        values.put("child1question14", child1question14);
        values.put("child1question15", child1question15);
        values.put("child1question16", child1question16);
        values.put("child1question17", child1question17);
        values.put("child1question18", child1question18);
        values.put("child1question19", child1question19);
        values.put("child2question1", child2question1);
        values.put("child2question2", child2question2);
        values.put("child2question3", child2question3);
        values.put("child2question4", child2question4);
        values.put("child2question5", child2question5);
        values.put("child2question6", child2question6);
        values.put("child2question7", child2question7);
        values.put("child2question8", child2question8);
        values.put("child2question9", child2question9);
        values.put("child2question10", child2question10);
        values.put("child2question11", child2question11);
        values.put("child2question12", child2question12);
        values.put("child2question13", child2question13);
        values.put("child2question14", child2question14);
        values.put("child2question15", child2question15);
        values.put("child2question16", child2question16);
        values.put("child2question17", child2question17);
        values.put("child2question18", child2question18);
        values.put("child2question19", child2question19);
        values.put("child3question1", child3question1);
        values.put("child3question2", child3question2);
        values.put("child3question3", child3question3);
        values.put("child3question4", child3question4);
        values.put("child3question5", child3question5);
        values.put("child3question6", child3question6);
        values.put("child3question7", child3question7);
        values.put("child3question8", child3question8);
        values.put("child3question9", child3question9);
        values.put("child3question10", child3question10);
        values.put("child3question11", child3question11);
        values.put("child3question12", child3question12);
        values.put("child3question13", child3question13);
        values.put("child3question14", child3question14);
        values.put("child3question15", child3question15);
        values.put("child3question16", child3question16);
        values.put("child3question17", child3question17);
        values.put("child3question18", child3question18);
        values.put("child3question19", child3question19);
        values.put("child4question1", child4question1);
        values.put("child4question2", child4question2);
        values.put("child4question3", child4question3);
        values.put("child4question4", child4question4);
        values.put("child4question5", child4question5);
        values.put("child4question6", child4question6);
        values.put("child4question7", child4question7);
        values.put("child4question8", child4question8);
        values.put("child4question9", child4question9);
        values.put("child4question10", child4question10);
        values.put("child4question11", child4question11);
        values.put("child4question12", child4question12);
        values.put("child4question13", child4question13);
        values.put("child4question14", child4question14);
        values.put("child4question15", child4question15);
        values.put("child4question16", child4question16);
        values.put("child4question17", child4question17);
        values.put("child4question18", child4question18);
        values.put("child4question19", child4question19);
        values.put("child5question1", child5question1);
        values.put("child5question2", child5question2);
        values.put("child5question3", child5question3);
        values.put("child5question4", child5question4);
        values.put("child5question5", child5question5);
        values.put("child5question6", child5question6);
        values.put("child5question7", child5question7);
        values.put("child5question8", child5question8);
        values.put("child5question9", child5question9);
        values.put("child5question10", child5question10);
        values.put("child5question11", child5question11);
        values.put("child5question12", child5question12);
        values.put("child5question13", child5question13);
        values.put("child5question14", child5question14);
        values.put("child5question15", child5question15);
        values.put("child5question16", child5question16);
        values.put("child5question17", child5question17);
        values.put("child5question18", child5question18);
        values.put("child5question19", child5question19);
        values.put("child6question1", child6question1);
        values.put("child6question2", child6question2);
        values.put("child6question3", child6question3);
        values.put("child6question4", child6question4);
        values.put("child6question5", child6question5);
        values.put("child6question6", child6question6);
        values.put("child6question7", child6question7);
        values.put("child6question8", child6question8);
        values.put("child6question9", child6question9);
        values.put("child6question10", child6question10);
        values.put("child6question11", child6question11);
        values.put("child6question12", child6question12);
        values.put("child6question13", child6question13);
        values.put("child6question14", child6question14);
        values.put("child6question15", child6question15);
        values.put("child6question16", child6question16);
        values.put("child6question17", child6question17);
        values.put("child6question18", child6question18);
        values.put("child6question19", child6question19);
        values.put("child7question1", child7question1);
        values.put("child7question2", child7question2);
        values.put("child7question3", child7question3);
        values.put("child7question4", child7question4);
        values.put("child7question5", child7question5);
        values.put("child7question6", child7question6);
        values.put("child7question7", child7question7);
        values.put("child7question8", child7question8);
        values.put("child7question9", child7question9);
        values.put("child7question10", child7question10);
        values.put("child7question11", child7question11);
        values.put("child7question12", child7question12);
        values.put("child7question13", child7question13);
        values.put("child7question14", child7question14);
        values.put("child7question15", child7question15);
        values.put("child7question16", child7question16);
        values.put("child7question17", child7question17);
        values.put("child7question18", child7question18);
        values.put("child7question19", child7question19);
        values.put("child8question1", child8question1);
        values.put("child8question2", child8question2);
        values.put("child8question3", child8question3);
        values.put("child8question4", child8question4);
        values.put("child8question5", child8question5);
        values.put("child8question6", child8question6);
        values.put("child8question7", child8question7);
        values.put("child8question8", child8question8);
        values.put("child8question9", child8question9);
        values.put("child8question10", child8question10);
        values.put("child8question11", child8question11);
        values.put("child8question12", child8question12);
        values.put("child8question13", child8question13);
        values.put("child8question14", child8question14);
        values.put("child8question15", child8question15);
        values.put("child8question16", child8question16);
        values.put("child8question17", child8question17);
        values.put("child8question18", child8question18);
        values.put("child8question19", child8question19);
        values.put("child9question1", child9question1);
        values.put("child9question2", child9question2);
        values.put("child9question3", child9question3);
        values.put("child9question4", child9question4);
        values.put("child9question5", child9question5);
        values.put("child9question6", child9question6);
        values.put("child9question7", child9question7);
        values.put("child9question8", child9question8);
        values.put("child9question9", child9question9);
        values.put("child9question10", child9question10);
        values.put("child9question11", child9question11);
        values.put("child9question12", child9question12);
        values.put("child9question13", child9question13);
        values.put("child9question14", child9question14);
        values.put("child9question15", child9question15);
        values.put("child9question16", child9question16);
        values.put("child9question17", child9question17);
        values.put("child9question18", child9question18);
        values.put("child9question19", child9question19);
        values.put("child10question1", child10question1);
        values.put("child10question2", child10question2);
        values.put("child10question3", child10question3);
        values.put("child10question4", child10question4);
        values.put("child10question5", child10question5);
        values.put("child10question6", child10question6);
        values.put("child10question7", child10question7);
        values.put("child10question8", child10question8);
        values.put("child10question9", child10question9);
        values.put("child10question10", child10question10);
        values.put("child10question11", child10question11);
        values.put("child10question12", child10question12);
        values.put("child10question13", child10question13);
        values.put("child10question14", child10question14);
        values.put("child10question15", child10question15);
        values.put("child10question16", child10question16);
        values.put("child10question17", child10question17);
        values.put("child10question18", child10question18);
        values.put("child10question19", child10question19);
        values.put("childquestion5", childquestion5);
        values.put("child_location", childLocation);

        db.update(TABLE_NAME, values, "farmer_id = ?", new String[]{farmerId});
        db.close();
    }

    public List<ChildModel> getAllSurveys() {
        List<ChildModel> childList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String farmerId = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FARMER_ID));
                String farmerDistrict = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FARMER_DISTRICT));
                String farmerVillage = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FARMER_VILLAGE));
                String childquestion4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILDQUESTION4));
                String child1question1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION1));
                String child1question2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION2));
                String child1question3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION3));
                String child1question4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION4));
                String child1question5 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION5));
                String child1question6 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION6));
                String child1question7 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION7));
                String child1question8 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION8));
                String child1question9 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION9));
                String child1question10 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION10));
                String child1question11 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION11));
                String child1question12 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION12));
                String child1question13 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION13));
                String child1question14 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION14));
                String child1question15 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION15));
                String child1question16 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION16));
                String child1question17 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION17));
                String child1question18 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION18));
                String child1question19 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD1QUESTION19));
                String child2question1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION1));
                String child2question2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION2));
                String child2question3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION3));
                String child2question4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION4));
                String child2question5 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION5));
                String child2question6 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION6));
                String child2question7 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION7));
                String child2question8 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION8));
                String child2question9 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION9));
                String child2question10 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION10));
                String child2question11 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION11));
                String child2question12 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION12));
                String child2question13 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION13));
                String child2question14 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION14));
                String child2question15 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION15));
                String child2question16 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION16));
                String child2question17 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION17));
                String child2question18 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION18));
                String child2question19 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD2QUESTION19));
                String child3question1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION1));
                String child3question2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION2));
                String child3question3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION3));
                String child3question4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION4));
                String child3question5 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION5));
                String child3question6 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION6));
                String child3question7 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION7));
                String child3question8 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION8));
                String child3question9 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION9));
                String child3question10 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION10));
                String child3question11 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION11));
                String child3question12 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION12));
                String child3question13 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION13));
                String child3question14 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION14));
                String child3question15 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION15));
                String child3question16 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION16));
                String child3question17 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION17));
                String child3question18 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION18));
                String child3question19 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD3QUESTION19));
                String child4question1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION1));
                String child4question2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION2));
                String child4question3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION3));
                String child4question4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION4));
                String child4question5 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION5));
                String child4question6 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION6));
                String child4question7 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION7));
                String child4question8 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION8));
                String child4question9 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION9));
                String child4question10 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION10));
                String child4question11 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION11));
                String child4question12 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION12));
                String child4question13 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION13));
                String child4question14 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION14));
                String child4question15 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION15));
                String child4question16 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION16));
                String child4question17 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION17));
                String child4question18 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION18));
                String child4question19 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD4QUESTION19));
                String child5question1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION1));
                String child5question2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION2));
                String child5question3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION3));
                String child5question4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION4));
                String child5question5 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION5));
                String child5question6 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION6));
                String child5question7 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION7));
                String child5question8 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION8));
                String child5question9 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION9));
                String child5question10 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION10));
                String child5question11 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION11));
                String child5question12 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION12));
                String child5question13 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION13));
                String child5question14 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION14));
                String child5question15 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION15));
                String child5question16 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION16));
                String child5question17 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION17));
                String child5question18 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION18));
                String child5question19 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD5QUESTION19));
                String child6question1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION1));
                String child6question2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION2));
                String child6question3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION3));
                String child6question4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION4));
                String child6question5 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION5));
                String child6question6 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION6));
                String child6question7 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION7));
                String child6question8 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION8));
                String child6question9 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION9));
                String child6question10 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION10));
                String child6question11 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION11));
                String child6question12 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION12));
                String child6question13 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION13));
                String child6question14 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION14));
                String child6question15 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION15));
                String child6question16 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION16));
                String child6question17 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION17));
                String child6question18 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION18));
                String child6question19 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD6QUESTION19));
                String child7question1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION1));
                String child7question2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION2));
                String child7question3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION3));
                String child7question4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION4));
                String child7question5 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION5));
                String child7question6 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION6));
                String child7question7 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION7));
                String child7question8 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION8));
                String child7question9 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION9));
                String child7question10 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION10));
                String child7question11 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION11));
                String child7question12 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION12));
                String child7question13 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION13));
                String child7question14 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION14));
                String child7question15 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION15));
                String child7question16 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION16));
                String child7question17 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION17));
                String child7question18 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION18));
                String child7question19 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD7QUESTION19));
                String child8question1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION1));
                String child8question2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION2));
                String child8question3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION3));
                String child8question4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION4));
                String child8question5 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION5));
                String child8question6 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION6));
                String child8question7 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION7));
                String child8question8 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION8));
                String child8question9 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION9));
                String child8question10 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION10));
                String child8question11 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION11));
                String child8question12 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION12));
                String child8question13 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION13));
                String child8question14 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION14));
                String child8question15 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION15));
                String child8question16 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION16));
                String child8question17 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION17));
                String child8question18 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION18));
                String child8question19 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD8QUESTION19));
                String child9question1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION1));
                String child9question2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION2));
                String child9question3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION3));
                String child9question4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION4));
                String child9question5 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION5));
                String child9question6 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION6));
                String child9question7 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION7));
                String child9question8 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION8));
                String child9question9 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION9));
                String child9question10 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION10));
                String child9question11 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION11));
                String child9question12 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION12));
                String child9question13 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION13));
                String child9question14 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION14));
                String child9question15 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION15));
                String child9question16 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION16));
                String child9question17 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION17));
                String child9question18 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION18));
                String child9question19 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD9QUESTION19));
                String child10question1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION1));
                String child10question2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION2));
                String child10question3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION3));
                String child10question4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION4));
                String child10question5 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION5));
                String child10question6 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION6));
                String child10question7 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION7));
                String child10question8 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION8));
                String child10question9 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION9));
                String child10question10 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION10));
                String child10question11 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION11));
                String child10question12 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION12));
                String child10question13 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION13));
                String child10question14 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION14));
                String child10question15 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION15));
                String child10question16 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION16));
                String child10question17 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION17));
                String child10question18 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION18));
                String child10question19 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD10QUESTION19));
                String childquestion5 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILDQUESTION5));
                String childLocation = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHILD_LOCATION));
                String signature = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_SIGNATURE));
                String userFname = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USER_FNAME));
                String userLname = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USER_LNAME));
                String userEmail = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USER_EMAIL));
                String onCreate = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ON_CREATE));
                String onUpdate = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ON_UPDATE));

                ChildModel child = new ChildModel(farmerId, farmerDistrict, farmerVillage,
                        childquestion4, child1question1, child1question2, child1question3, child1question4,
                        child1question5, child1question6, child1question7, child1question8, child1question9,
                        child1question10, child1question11, child1question12, child1question13, child1question14,
                        child1question15, child1question16, child1question17, child1question18, child1question19,
                        child2question1, child2question2, child2question3, child2question4, child2question5,
                        child2question6, child2question7, child2question8, child2question9, child2question10,
                        child2question11, child2question12, child2question13, child2question14, child2question15,
                        child2question16, child2question17, child2question18, child2question19, child3question1,
                        child3question2, child3question3, child3question4, child3question5, child3question6,
                        child3question7, child3question8, child3question9, child3question10, child3question11,
                        child3question12, child3question13, child3question14, child3question15, child3question16,
                        child3question17, child3question18, child3question19, child4question1, child4question2,
                        child4question3, child4question4, child4question5, child4question6, child4question7,
                        child4question8, child4question9, child4question10, child4question11, child4question12,
                        child4question13, child4question14, child4question15, child4question16, child4question17,
                        child4question18, child4question19, child5question1, child5question2, child5question3,
                        child5question4, child5question5, child5question6, child5question7, child5question8,
                        child5question9, child5question10, child5question11, child5question12, child5question13,
                        child5question14, child5question15, child5question16, child5question17, child5question18,
                        child5question19, child6question1, child6question2, child6question3, child6question4,
                        child6question5, child6question6, child6question7, child6question8, child6question9,
                        child6question10, child6question11, child6question12, child6question13, child6question14,
                        child6question15, child6question16, child6question17, child6question18, child6question19,
                        child7question1, child7question2, child7question3, child7question4, child7question5,
                        child7question6, child7question7, child7question8, child7question9, child7question10,
                        child7question11, child7question12, child7question13, child7question14, child7question15,
                        child7question16, child7question17, child7question18, child7question19, child8question1,
                        child8question2, child8question3, child8question4, child8question5, child8question6,
                        child8question7, child8question8, child8question9, child8question10, child8question11,
                        child8question12, child8question13, child8question14, child8question15, child8question16,
                        child8question17, child8question18, child8question19, child9question1, child9question2,
                        child9question3, child9question4, child9question5, child9question6, child9question7,
                        child9question8, child9question9, child9question10, child9question11, child9question12,
                        child9question13, child9question14, child9question15, child9question16, child9question17,
                        child9question18, child9question19, child10question1, child10question2, child10question3,
                        child10question4, child10question5, child10question6, child10question7, child10question8,
                        child10question9, child10question10, child10question11, child10question12, child10question13,
                        child10question14, child10question15, child10question16, child10question17, child10question18, child10question19,
                        childquestion5, childLocation, signature, userFname, userLname, userEmail, onCreate, onUpdate);
                childList.add(child);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return childList;
    }
}
