package com.jacob.fruitoftek.safecrop.sustain.fiis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyFIISDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MY_FIIS_RECORDS_DB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "MY_FIIS_RECORDS_TABLE";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_OTHER_NAMES = "other_names";
    private static final String COLUMN_QUESTIONFIIS1 = "questionfiis1";
    private static final String COLUMN_QUESTIONFIIS2 = "questionfiis2";
    private static final String COLUMN_QUESTIONFIIS3 = "questionfiis3";
    private static final String COLUMN_QUESTIONFIIS4 = "questionfiis4";
    private static final String COLUMN_QUESTIONFIIS5 = "questionfiis5";
    private static final String COLUMN_QUESTIONFIIS6 = "questionfiis6";
    private static final String COLUMN_QUESTIONFIIS7 = "questionfiis7";
    private static final String COLUMN_QUESTIONFIIS8 = "questionfiis8";
    private static final String COLUMN_QUESTIONFIIS9 = "questionfiis9";
    private static final String COLUMN_QUESTIONFIIS10 = "questionfiis10";
    private static final String COLUMN_QUESTIONFIIS11 = "questionfiis11";
    private static final String COLUMN_QUESTIONFIIS12 = "questionfiis12";
    private static final String COLUMN_QUESTIONFIIS13 = "questionfiis13";
    private static final String COLUMN_QUESTIONFIIS14 = "questionfiis14";
    private static final String COLUMN_QUESTIONFIIS15 = "questionfiis15";
    private static final String COLUMN_QUESTIONFIIS16 = "questionfiis16";
    private static final String COLUMN_QUESTIONFIIS17 = "questionfiis17";
    private static final String COLUMN_QUESTIONFIIS18 = "questionfiis18";
    private static final String COLUMN_QUESTIONFIIS19 = "questionfiis19";
    private static final String COLUMN_QUESTIONFIIS20 = "questionfiis20";
    private static final String COLUMN_QUESTIONFIIS21 = "questionfiis21";
    private static final String COLUMN_QUESTIONFIIS22 = "questionfiis22";
    private static final String COLUMN_QUESTIONFIIS23 = "questionfiis23";
    private static final String COLUMN_QUESTIONFIIS24 = "questionfiis24";
    private static final String COLUMN_QUESTIONFIIS25 = "questionfiis25";
    private static final String COLUMN_QUESTIONFIIS26 = "questionfiis26";
    private static final String COLUMN_QUESTIONFIIS27 = "questionfiis27";
    private static final String COLUMN_QUESTIONFIIS28 = "questionfiis28";
    private static final String COLUMN_QUESTIONFIIS29 = "questionfiis29";
    private static final String COLUMN_QUESTIONFIIS30 = "questionfiis30";
    private static final String COLUMN_QUESTIONFIIS31 = "questionfiis31";
    private static final String COLUMN_QUESTIONFIIS32 = "questionfiis32";
    private static final String COLUMN_QUESTIONFIIS33 = "questionfiis33";
    private static final String COLUMN_QUESTIONFIIS34 = "questionfiis34";
    private static final String COLUMN_QUESTIONFIIS35 = "questionfiis35";
    private static final String COLUMN_QUESTIONFIIS36 = "questionfiis36";
    private static final String COLUMN_QUESTIONFIIS37 = "questionfiis37";
    private static final String COLUMN_QUESTIONFIIS38 = "questionfiis38";
    private static final String COLUMN_QUESTIONFIIS39 = "questionfiis39";
    private static final String COLUMN_QUESTIONFIIS40 = "questionfiis40";
    private static final String COLUMN_QUESTIONFIIS41 = "questionfiis41";
    private static final String COLUMN_QUESTIONFIIS42 = "questionfiis42";
    private static final String COLUMN_QUESTIONFIIS43 = "questionfiis43";
    private static final String COLUMN_QUESTIONFIIS44 = "questionfiis44";
    private static final String COLUMN_QUESTIONFIIS45 = "questionfiis45";
    private static final String COLUMN_QUESTIONFIIS46 = "questionfiis46";
    private static final String COLUMN_QUESTIONFIIS47 = "questionfiis47";
    private static final String COLUMN_QUESTIONFIIS48 = "questionfiis48";
    private static final String COLUMN_QUESTIONFIIS49 = "questionfiis49";
    private static final String COLUMN_QUESTIONFIIS50 = "questionfiis50";
    private static final String COLUMN_QUESTIONFIIS51 = "questionfiis51";
    private static final String COLUMN_QUESTIONFIIS52 = "questionfiis52";
    private static final String COLUMN_QUESTIONFIIS53 = "questionfiis53";
    private static final String COLUMN_QUESTIONFIIS54 = "questionfiis54";
    private static final String COLUMN_QUESTIONFIIS55 = "questionfiis55";
    private static final String COLUMN_QUESTIONFIIS56 = "questionfiis56";
    private static final String COLUMN_QUESTIONFIIS57 = "questionfiis57";
    private static final String COLUMN_QUESTIONFIIS58 = "questionfiis58";
    private static final String COLUMN_QUESTIONFIIS59 = "questionfiis59";
    private static final String COLUMN_QUESTIONFIIS60 = "questionfiis60";
    private static final String COLUMN_QUESTIONFIIS61 = "questionfiis61";
    private static final String COLUMN_QUESTIONFIIS62 = "questionfiis62";
    private static final String COLUMN_QUESTIONFIIS63 = "questionfiis63";
    private static final String COLUMN_QUESTIONFIIS64 = "questionfiis64";
    private static final String COLUMN_QUESTIONFIIS65 = "questionfiis65";
    private static final String COLUMN_QUESTIONFIIS66 = "questionfiis66";
    private static final String COLUMN_QUESTIONFIIS67 = "questionfiis67";
    private static final String COLUMN_QUESTIONFIIS68 = "questionfiis68";
    private static final String COLUMN_QUESTIONFIIS69 = "questionfiis69";
    private static final String COLUMN_QUESTIONFIIS70 = "questionfiis70";
    private static final String COLUMN_QUESTIONFIIS71 = "questionfiis71";
    private static final String COLUMN_QUESTIONFIIS72 = "questionfiis72";
    private static final String COLUMN_QUESTIONFIIS73 = "questionfiis73";
    private static final String COLUMN_QUESTIONFIIS74 = "questionfiis74";
    private static final String COLUMN_QUESTIONFIIS75 = "questionfiis75";
    private static final String COLUMN_QUESTIONFIIS76 = "questionfiis76";
    private static final String COLUMN_QUESTIONFIIS77 = "questionfiis77";
    private static final String COLUMN_QUESTIONFIIS78 = "questionfiis78";
    private static final String COLUMN_QUESTIONFIIS79 = "questionfiis79";
    private static final String COLUMN_QUESTIONFIIS80 = "questionfiis80";
    private static final String COLUMN_QUESTIONFIIS81 = "questionfiis81";
    private static final String COLUMN_QUESTIONFIIS82 = "questionfiis82";
    private static final String COLUMN_QUESTIONFIIS83 = "questionfiis83";
    private static final String COLUMN_QUESTIONFIIS84 = "questionfiis84";
    private static final String COLUMN_QUESTIONFIIS85 = "questionfiis85";
    private static final String COLUMN_QUESTIONFIIS86 = "questionfiis86";
    private static final String COLUMN_QUESTIONFIIS87 = "questionfiis87";
    private static final String COLUMN_QUESTIONFIIS88 = "questionfiis88";
    private static final String COLUMN_QUESTIONFIIS89 = "questionfiis89";
    private static final String COLUMN_QUESTIONFIIS90 = "questionfiis90";
    private static final String COLUMN_QUESTIONFIIS91 = "questionfiis91";
    private static final String COLUMN_QUESTIONFIIS92 = "questionfiis92";
    private static final String COLUMN_QUESTIONFIIS93 = "questionfiis93";
    private static final String COLUMN_QUESTIONFIIS94 = "questionfiis94";
    private static final String COLUMN_QUESTIONFIIS95 = "questionfiis95";
    private static final String COLUMN_QUESTIONFIIS96 = "questionfiis96";
    private static final String COLUMN_QUESTIONFIIS97 = "questionfiis97";
    private static final String COLUMN_QUESTIONFIIS98 = "questionfiis98";
    private static final String COLUMN_QUESTIONFIIS99 = "questionfiis99";
    private static final String COLUMN_QUESTIONFIIS100 = "questionfiis100";
    private static final String COLUMN_QUESTIONFIIS101 = "questionfiis101";
    private static final String COLUMN_QUESTIONFIIS102 = "questionfiis102";
    private static final String COLUMN_QUESTIONFIIS103 = "questionfiis103";
    private static final String COLUMN_QUESTIONFIIS104 = "questionfiis104";
    private static final String COLUMN_QUESTIONFIIS105 = "questionfiis105";
    private static final String COLUMN_QUESTIONFIIS106 = "questionfiis106";
    private static final String COLUMN_QUESTIONFIIS107 = "questionfiis107";
    private static final String COLUMN_QUESTIONFIIS108 = "questionfiis108";
    private static final String COLUMN_QUESTIONFIIS109 = "questionfiis109";
    private static final String COLUMN_QUESTIONFIIS110 = "questionfiis110";
    private static final String COLUMN_QUESTIONFIIS111 = "questionfiis111";
    private static final String COLUMN_QUESTIONFIIS112 = "questionfiis112";
    private static final String COLUMN_QUESTIONFIIS113 = "questionfiis113";
    private static final String COLUMN_QUESTIONFIIS114 = "questionfiis114";
    private static final String COLUMN_QUESTIONFIIS115 = "questionfiis115";
    private static final String COLUMN_QUESTIONFIIS116 = "questionfiis116";
    private static final String COLUMN_QUESTIONFIIS117 = "questionfiis117";
    private static final String COLUMN_QUESTIONFIIS118 = "questionfiis118";
    private static final String COLUMN_QUESTIONFIIS119 = "questionfiis119";
    private static final String COLUMN_QUESTIONFIIS120 = "questionfiis120";
    private static final String COLUMN_QUESTIONFIIS121 = "questionfiis121";
    private static final String COLUMN_QUESTIONFIIS122 = "questionfiis122";
    private static final String COLUMN_QUESTIONFIIS123 = "questionfiis123";
    private static final String COLUMN_QUESTIONFIIS124 = "questionfiis124";
    private static final String COLUMN_QUESTIONFIIS125 = "questionfiis125";
    private static final String COLUMN_QUESTIONFIIS126 = "questionfiis126";
    private static final String COLUMN_QUESTIONFIIS127 = "questionfiis127";
    private static final String COLUMN_QUESTIONFIIS128 = "questionfiis128";
    private static final String COLUMN_QUESTIONFIIS129 = "questionfiis129";
    private static final String COLUMN_QUESTIONFIIS130 = "questionfiis130";
    private static final String COLUMN_QUESTIONFIIS131 = "questionfiis131";
    private static final String COLUMN_QUESTIONFIIS132 = "questionfiis132";
    private static final String COLUMN_QUESTIONFIIS133 = "questionfiis133";
    private static final String COLUMN_QUESTIONFIIS134 = "questionfiis134";
    private static final String COLUMN_QUESTIONFIIS135 = "questionfiis135";
    private static final String COLUMN_QUESTIONFIIS136 = "questionfiis136";
    private static final String COLUMN_QUESTIONFIIS137 = "questionfiis137";
    private static final String COLUMN_QUESTIONFIIS138 = "questionfiis138";
    private static final String COLUMN_QUESTIONFIIS139 = "questionfiis139";
    private static final String COLUMN_QUESTIONFIIS140 = "questionfiis140";
    private static final String COLUMN_QUESTIONFIIS141 = "questionfiis141";
    private static final String COLUMN_QUESTIONFIIS142 = "questionfiis142";
    private static final String COLUMN_QUESTIONFIIS143 = "questionfiis143";
    private static final String COLUMN_QUESTIONFIIS144 = "questionfiis144";
    private static final String COLUMN_QUESTIONFIIS145 = "questionfiis145";
    private static final String COLUMN_QUESTIONFIIS146 = "questionfiis146";
    private static final String COLUMN_QUESTIONFIIS147 = "questionfiis147";
    private static final String COLUMN_QUESTIONFIIS148 = "questionfiis148";
    private static final String COLUMN_QUESTIONFIIS149 = "questionfiis149";
    private static final String COLUMN_QUESTIONFIIS150 = "questionfiis150";
    private static final String COLUMN_QUESTIONFIIS151 = "questionfiis151";
    private static final String COLUMN_QUESTIONFIIS152 = "questionfiis152";
    private static final String COLUMN_QUESTIONFIIS153 = "questionfiis153";
    private static final String COLUMN_QUESTIONFIIS154 = "questionfiis154";
    private static final String COLUMN_QUESTIONFIIS155 = "questionfiis155";
    private static final String COLUMN_QUESTIONFIIS156 = "questionfiis156";
    private static final String COLUMN_QUESTIONFIIS157 = "questionfiis157";
    private static final String COLUMN_QUESTIONFIIS158 = "questionfiis158";
    private static final String COLUMN_QUESTIONFIIS159 = "questionfiis159";
    private static final String COLUMN_QUESTIONFIIS160 = "questionfiis160";
    private static final String COLUMN_QUESTIONFIIS161 = "questionfiis161";
    private static final String COLUMN_QUESTIONFIIS162 = "questionfiis162";
    private static final String COLUMN_QUESTIONFIIS163 = "questionfiis163";
    private static final String COLUMN_QUESTIONFIIS164 = "questionfiis164";
    private static final String COLUMN_QUESTIONFIIS165 = "questionfiis165";
    private static final String COLUMN_QUESTIONFIIS166 = "questionfiis166";
    private static final String COLUMN_QUESTIONFIIS167 = "questionfiis167";
    private static final String COLUMN_QUESTIONFIIS168 = "questionfiis168";
    private static final String COLUMN_QUESTIONFIIS169 = "questionfiis169";
    private static final String COLUMN_QUESTIONFIIS170 = "questionfiis170";
    private static final String COLUMN_QUESTIONFIIS171 = "questionfiis171";
    private static final String COLUMN_QUESTIONFIIS172 = "questionfiis172";
    private static final String COLUMN_QUESTIONFIIS173 = "questionfiis173";
    private static final String COLUMN_QUESTIONFIIS174 = "questionfiis174";
    private static final String COLUMN_QUESTIONFIIS175 = "questionfiis175";
    private static final String COLUMN_QUESTIONFIIS176 = "questionfiis176";
    private static final String COLUMN_QUESTIONFIIS177 = "questionfiis177";
    private static final String COLUMN_QUESTIONFIIS178 = "questionfiis178";
    private static final String COLUMN_QUESTIONFIIS179 = "questionfiis179";
    private static final String COLUMN_QUESTIONFIIS180 = "questionfiis180";
    private static final String COLUMN_QUESTIONFIIS181 = "questionfiis181";
    private static final String COLUMN_QUESTIONFIIS182 = "questionfiis182";
    private static final String COLUMN_QUESTIONFIIS183 = "questionfiis183";
    private static final String COLUMN_QUESTIONFIIS184 = "questionfiis184";
    private static final String COLUMN_QUESTIONFIIS185 = "questionfiis185";
    private static final String COLUMN_QUESTIONFIIS186 = "questionfiis186";
    private static final String COLUMN_QUESTIONFIIS187 = "questionfiis187";
    private static final String COLUMN_QUESTIONFIIS188 = "questionfiis188";
    private static final String COLUMN_QUESTIONFIIS189 = "questionfiis189";
    private static final String COLUMN_QUESTIONFIIS190 = "questionfiis190";
    private static final String COLUMN_QUESTIONFIIS191 = "questionfiis191";
    private static final String COLUMN_QUESTIONFIIS192 = "questionfiis192";
    private static final String COLUMN_QUESTIONFIIS193 = "questionfiis193";
    private static final String COLUMN_QUESTIONFIIS194 = "questionfiis194";
    private static final String COLUMN_QUESTIONFIIS195 = "questionfiis195";
    private static final String COLUMN_QUESTIONFIIS196 = "questionfiis196";
    private static final String COLUMN_PROFILE_IMAGE = "profile_image";
    private static final String COLUMN_CREATION_DATE = "creation_date";
    private static final String COLUMN_UPDATE_DATE = "update_date";

    public MyFIISDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_FIRST_NAME + " TEXT, " +
                COLUMN_OTHER_NAMES + " TEXT, " +
                COLUMN_QUESTIONFIIS1 + " TEXT, " +
                COLUMN_QUESTIONFIIS2 + " TEXT, " +
                COLUMN_QUESTIONFIIS3 + " TEXT, " +
                COLUMN_QUESTIONFIIS4 + " TEXT, " +
                COLUMN_QUESTIONFIIS5 + " TEXT, " +
                COLUMN_QUESTIONFIIS6 + " TEXT, " +
                COLUMN_QUESTIONFIIS7 + " TEXT, " +
                COLUMN_QUESTIONFIIS8 + " TEXT, " +
                COLUMN_QUESTIONFIIS9 + " TEXT, " +
                COLUMN_QUESTIONFIIS10 + " TEXT, " +
                COLUMN_QUESTIONFIIS11 + " TEXT, " +
                COLUMN_QUESTIONFIIS12 + " TEXT, " +
                COLUMN_QUESTIONFIIS13 + " TEXT, " +
                COLUMN_QUESTIONFIIS14 + " TEXT, " +
                COLUMN_QUESTIONFIIS15 + " TEXT, " +
                COLUMN_QUESTIONFIIS16 + " TEXT, " +
                COLUMN_QUESTIONFIIS17 + " TEXT, " +
                COLUMN_QUESTIONFIIS18 + " TEXT, " +
                COLUMN_QUESTIONFIIS19 + " TEXT, " +
                COLUMN_QUESTIONFIIS20 + " TEXT, " +
                COLUMN_QUESTIONFIIS21 + " TEXT, " +
                COLUMN_QUESTIONFIIS22 + " TEXT, " +
                COLUMN_QUESTIONFIIS23 + " TEXT, " +
                COLUMN_QUESTIONFIIS24 + " TEXT, " +
                COLUMN_QUESTIONFIIS25 + " TEXT, " +
                COLUMN_QUESTIONFIIS26 + " TEXT, " +
                COLUMN_QUESTIONFIIS27 + " TEXT, " +
                COLUMN_QUESTIONFIIS28 + " TEXT, " +
                COLUMN_QUESTIONFIIS29 + " TEXT, " +
                COLUMN_QUESTIONFIIS30 + " TEXT, " +
                COLUMN_QUESTIONFIIS31 + " TEXT, " +
                COLUMN_QUESTIONFIIS32 + " TEXT, " +
                COLUMN_QUESTIONFIIS33 + " TEXT, " +
                COLUMN_QUESTIONFIIS34 + " TEXT, " +
                COLUMN_QUESTIONFIIS35 + " TEXT, " +
                COLUMN_QUESTIONFIIS36 + " TEXT, " +
                COLUMN_QUESTIONFIIS37 + " TEXT, " +
                COLUMN_QUESTIONFIIS38 + " TEXT, " +
                COLUMN_QUESTIONFIIS39 + " TEXT, " +
                COLUMN_QUESTIONFIIS40 + " TEXT, " +
                COLUMN_QUESTIONFIIS41 + " TEXT, " +
                COLUMN_QUESTIONFIIS42 + " TEXT, " +
                COLUMN_QUESTIONFIIS43 + " TEXT, " +
                COLUMN_QUESTIONFIIS44 + " TEXT, " +
                COLUMN_QUESTIONFIIS45 + " TEXT, " +
                COLUMN_QUESTIONFIIS46 + " TEXT, " +
                COLUMN_QUESTIONFIIS47 + " TEXT, " +
                COLUMN_QUESTIONFIIS48 + " TEXT, " +
                COLUMN_QUESTIONFIIS49 + " TEXT, " +
                COLUMN_QUESTIONFIIS50 + " TEXT, " +
                COLUMN_QUESTIONFIIS51 + " TEXT, " +
                COLUMN_QUESTIONFIIS52 + " TEXT, " +
                COLUMN_QUESTIONFIIS53 + " TEXT, " +
                COLUMN_QUESTIONFIIS54 + " TEXT, " +
                COLUMN_QUESTIONFIIS55 + " TEXT, " +
                COLUMN_QUESTIONFIIS56 + " TEXT, " +
                COLUMN_QUESTIONFIIS57 + " TEXT, " +
                COLUMN_QUESTIONFIIS58 + " TEXT, " +
                COLUMN_QUESTIONFIIS59 + " TEXT, " +
                COLUMN_QUESTIONFIIS60 + " TEXT, " +
                COLUMN_QUESTIONFIIS61 + " TEXT, " +
                COLUMN_QUESTIONFIIS62 + " TEXT, " +
                COLUMN_QUESTIONFIIS63 + " TEXT, " +
                COLUMN_QUESTIONFIIS64 + " TEXT, " +
                COLUMN_QUESTIONFIIS65 + " TEXT, " +
                COLUMN_QUESTIONFIIS66 + " TEXT, " +
                COLUMN_QUESTIONFIIS67 + " TEXT, " +
                COLUMN_QUESTIONFIIS68 + " TEXT, " +
                COLUMN_QUESTIONFIIS69 + " TEXT, " +
                COLUMN_QUESTIONFIIS70 + " TEXT, " +
                COLUMN_QUESTIONFIIS71 + " TEXT, " +
                COLUMN_QUESTIONFIIS72 + " TEXT, " +
                COLUMN_QUESTIONFIIS73 + " TEXT, " +
                COLUMN_QUESTIONFIIS74 + " TEXT, " +
                COLUMN_QUESTIONFIIS75 + " TEXT, " +
                COLUMN_QUESTIONFIIS76 + " TEXT, " +
                COLUMN_QUESTIONFIIS77 + " TEXT, " +
                COLUMN_QUESTIONFIIS78 + " TEXT, " +
                COLUMN_QUESTIONFIIS79 + " TEXT, " +
                COLUMN_QUESTIONFIIS80 + " TEXT, " +
                COLUMN_QUESTIONFIIS81 + " TEXT, " +
                COLUMN_QUESTIONFIIS82 + " TEXT, " +
                COLUMN_QUESTIONFIIS83 + " TEXT, " +
                COLUMN_QUESTIONFIIS84 + " TEXT, " +
                COLUMN_QUESTIONFIIS85 + " TEXT, " +
                COLUMN_QUESTIONFIIS86 + " TEXT, " +
                COLUMN_QUESTIONFIIS87 + " TEXT, " +
                COLUMN_QUESTIONFIIS88 + " TEXT, " +
                COLUMN_QUESTIONFIIS89 + " TEXT, " +
                COLUMN_QUESTIONFIIS90 + " TEXT, " +
                COLUMN_QUESTIONFIIS91 + " TEXT, " +
                COLUMN_QUESTIONFIIS92 + " TEXT, " +
                COLUMN_QUESTIONFIIS93 + " TEXT, " +
                COLUMN_QUESTIONFIIS94 + " TEXT, " +
                COLUMN_QUESTIONFIIS95 + " TEXT, " +
                COLUMN_QUESTIONFIIS96 + " TEXT, " +
                COLUMN_QUESTIONFIIS97 + " TEXT, " +
                COLUMN_QUESTIONFIIS98 + " TEXT, " +
                COLUMN_QUESTIONFIIS99 + " TEXT, " +
                COLUMN_QUESTIONFIIS100 + " TEXT, " +
                COLUMN_QUESTIONFIIS101 + " TEXT, " +
                COLUMN_QUESTIONFIIS102 + " TEXT, " +
                COLUMN_QUESTIONFIIS103 + " TEXT, " +
                COLUMN_QUESTIONFIIS104 + " TEXT, " +
                COLUMN_QUESTIONFIIS105 + " TEXT, " +
                COLUMN_QUESTIONFIIS106 + " TEXT, " +
                COLUMN_QUESTIONFIIS107 + " TEXT, " +
                COLUMN_QUESTIONFIIS108 + " TEXT, " +
                COLUMN_QUESTIONFIIS109 + " TEXT, " +
                COLUMN_QUESTIONFIIS110 + " TEXT, " +
                COLUMN_QUESTIONFIIS111 + " TEXT, " +
                COLUMN_QUESTIONFIIS112 + " TEXT, " +
                COLUMN_QUESTIONFIIS113 + " TEXT, " +
                COLUMN_QUESTIONFIIS114 + " TEXT, " +
                COLUMN_QUESTIONFIIS115 + " TEXT, " +
                COLUMN_QUESTIONFIIS116 + " TEXT, " +
                COLUMN_QUESTIONFIIS117 + " TEXT, " +
                COLUMN_QUESTIONFIIS118 + " TEXT, " +
                COLUMN_QUESTIONFIIS119 + " TEXT, " +
                COLUMN_QUESTIONFIIS120 + " TEXT, " +
                COLUMN_QUESTIONFIIS121 + " TEXT, " +
                COLUMN_QUESTIONFIIS122 + " TEXT, " +
                COLUMN_QUESTIONFIIS123 + " TEXT, " +
                COLUMN_QUESTIONFIIS124 + " TEXT, " +
                COLUMN_QUESTIONFIIS125 + " TEXT, " +
                COLUMN_QUESTIONFIIS126 + " TEXT, " +
                COLUMN_QUESTIONFIIS127 + " TEXT, " +
                COLUMN_QUESTIONFIIS128 + " TEXT, " +
                COLUMN_QUESTIONFIIS129 + " TEXT, " +
                COLUMN_QUESTIONFIIS130 + " TEXT, " +
                COLUMN_QUESTIONFIIS131 + " TEXT, " +
                COLUMN_QUESTIONFIIS132 + " TEXT, " +
                COLUMN_QUESTIONFIIS133 + " TEXT, " +
                COLUMN_QUESTIONFIIS134 + " TEXT, " +
                COLUMN_QUESTIONFIIS135 + " TEXT, " +
                COLUMN_QUESTIONFIIS136 + " TEXT, " +
                COLUMN_QUESTIONFIIS137 + " TEXT, " +
                COLUMN_QUESTIONFIIS138 + " TEXT, " +
                COLUMN_QUESTIONFIIS139 + " TEXT, " +
                COLUMN_QUESTIONFIIS140 + " TEXT, " +
                COLUMN_QUESTIONFIIS141 + " TEXT, " +
                COLUMN_QUESTIONFIIS142 + " TEXT, " +
                COLUMN_QUESTIONFIIS143 + " TEXT, " +
                COLUMN_QUESTIONFIIS144 + " TEXT, " +
                COLUMN_QUESTIONFIIS145 + " TEXT, " +
                COLUMN_QUESTIONFIIS146 + " TEXT, " +
                COLUMN_QUESTIONFIIS147 + " TEXT, " +
                COLUMN_QUESTIONFIIS148 + " TEXT, " +
                COLUMN_QUESTIONFIIS149 + " TEXT, " +
                COLUMN_QUESTIONFIIS150 + " TEXT, " +
                COLUMN_QUESTIONFIIS151 + " TEXT, " +
                COLUMN_QUESTIONFIIS152 + " TEXT, " +
                COLUMN_QUESTIONFIIS153 + " TEXT, " +
                COLUMN_QUESTIONFIIS154 + " TEXT, " +
                COLUMN_QUESTIONFIIS155 + " TEXT, " +
                COLUMN_QUESTIONFIIS156 + " TEXT, " +
                COLUMN_QUESTIONFIIS157 + " TEXT, " +
                COLUMN_QUESTIONFIIS158 + " TEXT, " +
                COLUMN_QUESTIONFIIS159 + " TEXT, " +
                COLUMN_QUESTIONFIIS160 + " TEXT, " +
                COLUMN_QUESTIONFIIS161 + " TEXT, " +
                COLUMN_QUESTIONFIIS162 + " TEXT, " +
                COLUMN_QUESTIONFIIS163 + " TEXT, " +
                COLUMN_QUESTIONFIIS164 + " TEXT, " +
                COLUMN_QUESTIONFIIS165 + " TEXT, " +
                COLUMN_QUESTIONFIIS166 + " TEXT, " +
                COLUMN_QUESTIONFIIS167 + " TEXT, " +
                COLUMN_QUESTIONFIIS168 + " TEXT, " +
                COLUMN_QUESTIONFIIS169 + " TEXT, " +
                COLUMN_QUESTIONFIIS170 + " TEXT, " +
                COLUMN_QUESTIONFIIS171 + " TEXT, " +
                COLUMN_QUESTIONFIIS172 + " TEXT, " +
                COLUMN_QUESTIONFIIS173 + " TEXT, " +
                COLUMN_QUESTIONFIIS174 + " TEXT, " +
                COLUMN_QUESTIONFIIS175 + " TEXT, " +
                COLUMN_QUESTIONFIIS176 + " TEXT, " +
                COLUMN_QUESTIONFIIS177 + " TEXT, " +
                COLUMN_QUESTIONFIIS178 + " TEXT, " +
                COLUMN_QUESTIONFIIS179 + " TEXT, " +
                COLUMN_QUESTIONFIIS180 + " TEXT, " +
                COLUMN_QUESTIONFIIS181 + " TEXT, " +
                COLUMN_QUESTIONFIIS182 + " TEXT, " +
                COLUMN_QUESTIONFIIS183 + " TEXT, " +
                COLUMN_QUESTIONFIIS184 + " TEXT, " +
                COLUMN_QUESTIONFIIS185 + " TEXT, " +
                COLUMN_QUESTIONFIIS186 + " TEXT, " +
                COLUMN_QUESTIONFIIS187 + " TEXT, " +
                COLUMN_QUESTIONFIIS188 + " TEXT, " +
                COLUMN_QUESTIONFIIS189 + " TEXT, " +
                COLUMN_QUESTIONFIIS190 + " TEXT, " +
                COLUMN_QUESTIONFIIS191 + " TEXT, " +
                COLUMN_QUESTIONFIIS192 + " TEXT, " +
                COLUMN_QUESTIONFIIS193 + " TEXT, " +
                COLUMN_QUESTIONFIIS194 + " TEXT, " +
                COLUMN_QUESTIONFIIS195 + " TEXT, " +
                COLUMN_QUESTIONFIIS196 + " TEXT, " +
                COLUMN_PROFILE_IMAGE + " TEXT, " +
                COLUMN_CREATION_DATE + " TEXT, " +
                COLUMN_UPDATE_DATE + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long insertRecord(String firstName, String otherNames, String questionfiis1, String questionfiis2, String questionfiis3, String questionfiis4, String questionfiis5, String questionfiis6, String questionfiis7, String questionfiis8, String questionfiis9, String questionfiis10, String questionfiis11, String questionfiis12, String questionfiis13, String questionfiis14, String questionfiis15, String questionfiis16, String questionfiis17, String questionfiis18, String questionfiis19, String questionfiis20, String questionfiis21, String questionfiis22, String questionfiis23, String questionfiis24, String questionfiis25, String questionfiis26, String questionfiis27, String questionfiis28, String questionfiis29, String questionfiis30, String questionfiis31, String questionfiis32, String questionfiis33, String questionfiis34, String questionfiis35, String questionfiis36, String questionfiis37, String questionfiis38, String questionfiis39, String questionfiis40, String questionfiis41, String questionfiis42, String questionfiis43, String questionfiis44, String questionfiis45, String questionfiis46, String questionfiis47, String questionfiis48, String questionfiis49, String questionfiis50, String questionfiis51, String questionfiis52, String questionfiis53, String questionfiis54, String questionfiis55, String questionfiis56, String questionfiis57, String questionfiis58, String questionfiis59, String questionfiis60, String questionfiis61, String questionfiis62, String questionfiis63, String questionfiis64, String questionfiis65, String questionfiis66, String questionfiis67, String questionfiis68, String questionfiis69, String questionfiis70, String questionfiis71, String questionfiis72, String questionfiis73, String questionfiis74, String questionfiis75, String questionfiis76, String questionfiis77, String questionfiis78, String questionfiis79, String questionfiis80, String questionfiis81, String questionfiis82, String questionfiis83, String questionfiis84, String questionfiis85, String questionfiis86, String questionfiis87, String questionfiis88, String questionfiis89, String questionfiis90, String questionfiis91, String questionfiis92, String questionfiis93, String questionfiis94, String questionfiis95, String questionfiis96, String questionfiis97, String questionfiis98, String questionfiis99, String questionfiis100, String questionfiis101, String questionfiis102, String questionfiis103, String questionfiis104, String questionfiis105, String questionfiis106, String questionfiis107, String questionfiis108, String questionfiis109, String questionfiis110, String questionfiis111, String questionfiis112, String questionfiis113, String questionfiis114, String questionfiis115, String questionfiis116, String questionfiis117, String questionfiis118, String questionfiis119, String questionfiis120, String questionfiis121, String questionfiis122, String questionfiis123, String questionfiis124, String questionfiis125, String questionfiis126, String questionfiis127, String questionfiis128, String questionfiis129, String questionfiis130, String questionfiis131, String questionfiis132, String questionfiis133, String questionfiis134, String questionfiis135, String questionfiis136, String questionfiis137, String questionfiis138, String questionfiis139, String questionfiis140, String questionfiis141, String questionfiis142, String questionfiis143, String questionfiis144, String questionfiis145, String questionfiis146, String questionfiis147, String questionfiis148, String questionfiis149, String questionfiis150, String questionfiis151, String questionfiis152, String questionfiis153, String questionfiis154, String questionfiis155, String questionfiis156, String questionfiis157, String questionfiis158, String questionfiis159, String questionfiis160, String questionfiis161, String questionfiis162, String questionfiis163, String questionfiis164, String questionfiis165, String questionfiis166, String questionfiis167, String questionfiis168, String questionfiis169, String questionfiis170, String questionfiis171, String questionfiis172, String questionfiis173, String questionfiis174, String questionfiis175, String questionfiis176, String questionfiis177, String questionfiis178, String questionfiis179, String questionfiis180, String questionfiis181, String questionfiis182, String questionfiis183, String questionfiis184, String questionfiis185, String questionfiis186, String questionfiis187, String questionfiis188, String questionfiis189, String questionfiis190, String questionfiis191, String questionfiis192, String questionfiis193, String questionfiis194, String questionfiis195, String questionfiis196, String profileImage, String creationDate, String updateDate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, firstName);
        values.put(COLUMN_OTHER_NAMES, otherNames);
        values.put(COLUMN_QUESTIONFIIS1, questionfiis1);
        values.put(COLUMN_QUESTIONFIIS2, questionfiis2);
        values.put(COLUMN_QUESTIONFIIS3, questionfiis3);
        values.put(COLUMN_QUESTIONFIIS4, questionfiis4);
        values.put(COLUMN_QUESTIONFIIS5, questionfiis5);
        values.put(COLUMN_QUESTIONFIIS6, questionfiis6);
        values.put(COLUMN_QUESTIONFIIS7, questionfiis7);
        values.put(COLUMN_QUESTIONFIIS8, questionfiis8);
        values.put(COLUMN_QUESTIONFIIS9, questionfiis9);
        values.put(COLUMN_QUESTIONFIIS10, questionfiis10);
        values.put(COLUMN_QUESTIONFIIS11, questionfiis11);
        values.put(COLUMN_QUESTIONFIIS12, questionfiis12);
        values.put(COLUMN_QUESTIONFIIS13, questionfiis13);
        values.put(COLUMN_QUESTIONFIIS14, questionfiis14);
        values.put(COLUMN_QUESTIONFIIS15, questionfiis15);
        values.put(COLUMN_QUESTIONFIIS16, questionfiis16);
        values.put(COLUMN_QUESTIONFIIS17, questionfiis17);
        values.put(COLUMN_QUESTIONFIIS18, questionfiis18);
        values.put(COLUMN_QUESTIONFIIS19, questionfiis19);
        values.put(COLUMN_QUESTIONFIIS20, questionfiis20);
        values.put(COLUMN_QUESTIONFIIS21, questionfiis21);
        values.put(COLUMN_QUESTIONFIIS22, questionfiis22);
        values.put(COLUMN_QUESTIONFIIS23, questionfiis23);
        values.put(COLUMN_QUESTIONFIIS24, questionfiis24);
        values.put(COLUMN_QUESTIONFIIS25, questionfiis25);
        values.put(COLUMN_QUESTIONFIIS26, questionfiis26);
        values.put(COLUMN_QUESTIONFIIS27, questionfiis27);
        values.put(COLUMN_QUESTIONFIIS28, questionfiis28);
        values.put(COLUMN_QUESTIONFIIS29, questionfiis29);
        values.put(COLUMN_QUESTIONFIIS30, questionfiis30);
        values.put(COLUMN_QUESTIONFIIS31, questionfiis31);
        values.put(COLUMN_QUESTIONFIIS32, questionfiis32);
        values.put(COLUMN_QUESTIONFIIS33, questionfiis33);
        values.put(COLUMN_QUESTIONFIIS34, questionfiis34);
        values.put(COLUMN_QUESTIONFIIS35, questionfiis35);
        values.put(COLUMN_QUESTIONFIIS36, questionfiis36);
        values.put(COLUMN_QUESTIONFIIS37, questionfiis37);
        values.put(COLUMN_QUESTIONFIIS38, questionfiis38);
        values.put(COLUMN_QUESTIONFIIS39, questionfiis39);
        values.put(COLUMN_QUESTIONFIIS40, questionfiis40);
        values.put(COLUMN_QUESTIONFIIS41, questionfiis41);
        values.put(COLUMN_QUESTIONFIIS42, questionfiis42);
        values.put(COLUMN_QUESTIONFIIS43, questionfiis43);
        values.put(COLUMN_QUESTIONFIIS44, questionfiis44);
        values.put(COLUMN_QUESTIONFIIS45, questionfiis45);
        values.put(COLUMN_QUESTIONFIIS46, questionfiis46);
        values.put(COLUMN_QUESTIONFIIS47, questionfiis47);
        values.put(COLUMN_QUESTIONFIIS48, questionfiis48);
        values.put(COLUMN_QUESTIONFIIS49, questionfiis49);
        values.put(COLUMN_QUESTIONFIIS50, questionfiis50);
        values.put(COLUMN_QUESTIONFIIS51, questionfiis51);
        values.put(COLUMN_QUESTIONFIIS52, questionfiis52);
        values.put(COLUMN_QUESTIONFIIS53, questionfiis53);
        values.put(COLUMN_QUESTIONFIIS54, questionfiis54);
        values.put(COLUMN_QUESTIONFIIS55, questionfiis55);
        values.put(COLUMN_QUESTIONFIIS56, questionfiis56);
        values.put(COLUMN_QUESTIONFIIS57, questionfiis57);
        values.put(COLUMN_QUESTIONFIIS58, questionfiis58);
        values.put(COLUMN_QUESTIONFIIS59, questionfiis59);
        values.put(COLUMN_QUESTIONFIIS60, questionfiis60);
        values.put(COLUMN_QUESTIONFIIS61, questionfiis61);
        values.put(COLUMN_QUESTIONFIIS62, questionfiis62);
        values.put(COLUMN_QUESTIONFIIS63, questionfiis63);
        values.put(COLUMN_QUESTIONFIIS64, questionfiis64);
        values.put(COLUMN_QUESTIONFIIS65, questionfiis65);
        values.put(COLUMN_QUESTIONFIIS66, questionfiis66);
        values.put(COLUMN_QUESTIONFIIS67, questionfiis67);
        values.put(COLUMN_QUESTIONFIIS68, questionfiis68);
        values.put(COLUMN_QUESTIONFIIS69, questionfiis69);
        values.put(COLUMN_QUESTIONFIIS70, questionfiis70);
        values.put(COLUMN_QUESTIONFIIS71, questionfiis71);
        values.put(COLUMN_QUESTIONFIIS72, questionfiis72);
        values.put(COLUMN_QUESTIONFIIS73, questionfiis73);
        values.put(COLUMN_QUESTIONFIIS74, questionfiis74);
        values.put(COLUMN_QUESTIONFIIS75, questionfiis75);
        values.put(COLUMN_QUESTIONFIIS76, questionfiis76);
        values.put(COLUMN_QUESTIONFIIS77, questionfiis77);
        values.put(COLUMN_QUESTIONFIIS78, questionfiis78);
        values.put(COLUMN_QUESTIONFIIS79, questionfiis79);
        values.put(COLUMN_QUESTIONFIIS80, questionfiis80);
        values.put(COLUMN_QUESTIONFIIS81, questionfiis81);
        values.put(COLUMN_QUESTIONFIIS82, questionfiis82);
        values.put(COLUMN_QUESTIONFIIS83, questionfiis83);
        values.put(COLUMN_QUESTIONFIIS84, questionfiis84);
        values.put(COLUMN_QUESTIONFIIS85, questionfiis85);
        values.put(COLUMN_QUESTIONFIIS86, questionfiis86);
        values.put(COLUMN_QUESTIONFIIS87, questionfiis87);
        values.put(COLUMN_QUESTIONFIIS88, questionfiis88);
        values.put(COLUMN_QUESTIONFIIS89, questionfiis89);
        values.put(COLUMN_QUESTIONFIIS90, questionfiis90);
        values.put(COLUMN_QUESTIONFIIS91, questionfiis91);
        values.put(COLUMN_QUESTIONFIIS92, questionfiis92);
        values.put(COLUMN_QUESTIONFIIS93, questionfiis93);
        values.put(COLUMN_QUESTIONFIIS94, questionfiis94);
        values.put(COLUMN_QUESTIONFIIS95, questionfiis95);
        values.put(COLUMN_QUESTIONFIIS96, questionfiis96);
        values.put(COLUMN_QUESTIONFIIS97, questionfiis97);
        values.put(COLUMN_QUESTIONFIIS98, questionfiis98);
        values.put(COLUMN_QUESTIONFIIS99, questionfiis99);
        values.put(COLUMN_QUESTIONFIIS100, questionfiis100);
        values.put(COLUMN_QUESTIONFIIS101, questionfiis101);
        values.put(COLUMN_QUESTIONFIIS102, questionfiis102);
        values.put(COLUMN_QUESTIONFIIS103, questionfiis103);
        values.put(COLUMN_QUESTIONFIIS104, questionfiis104);
        values.put(COLUMN_QUESTIONFIIS105, questionfiis105);
        values.put(COLUMN_QUESTIONFIIS106, questionfiis106);
        values.put(COLUMN_QUESTIONFIIS107, questionfiis107);
        values.put(COLUMN_QUESTIONFIIS108, questionfiis108);
        values.put(COLUMN_QUESTIONFIIS109, questionfiis109);
        values.put(COLUMN_QUESTIONFIIS110, questionfiis110);
        values.put(COLUMN_QUESTIONFIIS111, questionfiis111);
        values.put(COLUMN_QUESTIONFIIS112, questionfiis112);
        values.put(COLUMN_QUESTIONFIIS113, questionfiis113);
        values.put(COLUMN_QUESTIONFIIS114, questionfiis114);
        values.put(COLUMN_QUESTIONFIIS115, questionfiis115);
        values.put(COLUMN_QUESTIONFIIS116, questionfiis116);
        values.put(COLUMN_QUESTIONFIIS117, questionfiis117);
        values.put(COLUMN_QUESTIONFIIS118, questionfiis118);
        values.put(COLUMN_QUESTIONFIIS119, questionfiis119);
        values.put(COLUMN_QUESTIONFIIS120, questionfiis120);
        values.put(COLUMN_QUESTIONFIIS121, questionfiis121);
        values.put(COLUMN_QUESTIONFIIS122, questionfiis122);
        values.put(COLUMN_QUESTIONFIIS123, questionfiis123);
        values.put(COLUMN_QUESTIONFIIS124, questionfiis124);
        values.put(COLUMN_QUESTIONFIIS125, questionfiis125);
        values.put(COLUMN_QUESTIONFIIS126, questionfiis126);
        values.put(COLUMN_QUESTIONFIIS127, questionfiis127);
        values.put(COLUMN_QUESTIONFIIS128, questionfiis128);
        values.put(COLUMN_QUESTIONFIIS129, questionfiis129);
        values.put(COLUMN_QUESTIONFIIS130, questionfiis130);
        values.put(COLUMN_QUESTIONFIIS131, questionfiis131);
        values.put(COLUMN_QUESTIONFIIS132, questionfiis132);
        values.put(COLUMN_QUESTIONFIIS133, questionfiis133);
        values.put(COLUMN_QUESTIONFIIS134, questionfiis134);
        values.put(COLUMN_QUESTIONFIIS135, questionfiis135);
        values.put(COLUMN_QUESTIONFIIS136, questionfiis136);
        values.put(COLUMN_QUESTIONFIIS137, questionfiis137);
        values.put(COLUMN_QUESTIONFIIS138, questionfiis138);
        values.put(COLUMN_QUESTIONFIIS139, questionfiis139);
        values.put(COLUMN_QUESTIONFIIS140, questionfiis140);
        values.put(COLUMN_QUESTIONFIIS141, questionfiis141);
        values.put(COLUMN_QUESTIONFIIS142, questionfiis142);
        values.put(COLUMN_QUESTIONFIIS143, questionfiis143);
        values.put(COLUMN_QUESTIONFIIS144, questionfiis144);
        values.put(COLUMN_QUESTIONFIIS145, questionfiis145);
        values.put(COLUMN_QUESTIONFIIS146, questionfiis146);
        values.put(COLUMN_QUESTIONFIIS147, questionfiis147);
        values.put(COLUMN_QUESTIONFIIS148, questionfiis148);
        values.put(COLUMN_QUESTIONFIIS149, questionfiis149);
        values.put(COLUMN_QUESTIONFIIS150, questionfiis150);
        values.put(COLUMN_QUESTIONFIIS151, questionfiis151);
        values.put(COLUMN_QUESTIONFIIS152, questionfiis152);
        values.put(COLUMN_QUESTIONFIIS153, questionfiis153);
        values.put(COLUMN_QUESTIONFIIS154, questionfiis154);
        values.put(COLUMN_QUESTIONFIIS155, questionfiis155);
        values.put(COLUMN_QUESTIONFIIS156, questionfiis156);
        values.put(COLUMN_QUESTIONFIIS157, questionfiis157);
        values.put(COLUMN_QUESTIONFIIS158, questionfiis158);
        values.put(COLUMN_QUESTIONFIIS159, questionfiis159);
        values.put(COLUMN_QUESTIONFIIS160, questionfiis160);
        values.put(COLUMN_QUESTIONFIIS161, questionfiis161);
        values.put(COLUMN_QUESTIONFIIS162, questionfiis162);
        values.put(COLUMN_QUESTIONFIIS163, questionfiis163);
        values.put(COLUMN_QUESTIONFIIS164, questionfiis164);
        values.put(COLUMN_QUESTIONFIIS165, questionfiis165);
        values.put(COLUMN_QUESTIONFIIS166, questionfiis166);
        values.put(COLUMN_QUESTIONFIIS167, questionfiis167);
        values.put(COLUMN_QUESTIONFIIS168, questionfiis168);
        values.put(COLUMN_QUESTIONFIIS169, questionfiis169);
        values.put(COLUMN_QUESTIONFIIS170, questionfiis170);
        values.put(COLUMN_QUESTIONFIIS171, questionfiis171);
        values.put(COLUMN_QUESTIONFIIS172, questionfiis172);
        values.put(COLUMN_QUESTIONFIIS173, questionfiis173);
        values.put(COLUMN_QUESTIONFIIS174, questionfiis174);
        values.put(COLUMN_QUESTIONFIIS175, questionfiis175);
        values.put(COLUMN_QUESTIONFIIS176, questionfiis176);
        values.put(COLUMN_QUESTIONFIIS177, questionfiis177);
        values.put(COLUMN_QUESTIONFIIS178, questionfiis178);
        values.put(COLUMN_QUESTIONFIIS179, questionfiis179);
        values.put(COLUMN_QUESTIONFIIS180, questionfiis180);
        values.put(COLUMN_QUESTIONFIIS181, questionfiis181);
        values.put(COLUMN_QUESTIONFIIS182, questionfiis182);
        values.put(COLUMN_QUESTIONFIIS183, questionfiis183);
        values.put(COLUMN_QUESTIONFIIS184, questionfiis184);
        values.put(COLUMN_QUESTIONFIIS185, questionfiis185);
        values.put(COLUMN_QUESTIONFIIS186, questionfiis186);
        values.put(COLUMN_QUESTIONFIIS187, questionfiis187);
        values.put(COLUMN_QUESTIONFIIS188, questionfiis188);
        values.put(COLUMN_QUESTIONFIIS189, questionfiis189);
        values.put(COLUMN_QUESTIONFIIS190, questionfiis190);
        values.put(COLUMN_QUESTIONFIIS191, questionfiis191);
        values.put(COLUMN_QUESTIONFIIS192, questionfiis192);
        values.put(COLUMN_QUESTIONFIIS193, questionfiis193);
        values.put(COLUMN_QUESTIONFIIS194, questionfiis194);
        values.put(COLUMN_QUESTIONFIIS195, questionfiis195);
        values.put(COLUMN_QUESTIONFIIS196, questionfiis196);
        values.put(COLUMN_PROFILE_IMAGE, profileImage);
        values.put(COLUMN_CREATION_DATE, creationDate);
        values.put(COLUMN_UPDATE_DATE, updateDate);
        return db.insert(TABLE_NAME, null, values);
    }

    public List<ModelRecordFIIS> getAllRecords(String orderBy) {
        List<ModelRecordFIIS> recordsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(ConstansFIIS.TABLE_NAME, null, null, null, null, null, orderBy);

        if (cursor.moveToFirst()) {
            do {
                ModelRecordFIIS record = new ModelRecordFIIS(
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_FIRST_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_OTHER_NAMES)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS1)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS2)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS3)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS4)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS5)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS6)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS7)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS8)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS9)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS10)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS11)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS12)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS13)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS14)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS15)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS16)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS17)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS18)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS19)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS20)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS21)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS22)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS23)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS24)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS25)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS26)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS27)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS28)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS29)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS30)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS31)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS32)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS33)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS34)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS35)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS36)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS37)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS38)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS39)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS40)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS41)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS42)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS43)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS44)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS45)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS46)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS47)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS48)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS49)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS50)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS51)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS52)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS53)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS54)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS55)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS56)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS57)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS58)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS59)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS60)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS61)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS62)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS63)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS64)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS65)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS66)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS67)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS68)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS69)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS70)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS71)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS72)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS73)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS74)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS75)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS76)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS77)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS78)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS79)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS80)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS81)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS82)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS83)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS84)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS85)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS86)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS87)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS88)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS89)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS90)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS91)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS92)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS93)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS94)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS95)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS96)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS97)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS98)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS99)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS100)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS101)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS102)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS103)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS104)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS105)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS106)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS107)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS108)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS109)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS110)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS111)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS112)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS113)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS114)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS115)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS116)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS117)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS118)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS119)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS120)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS121)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS122)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS123)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS124)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS125)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS126)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS127)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS128)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS129)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS130)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS131)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS132)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS133)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS134)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS135)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS136)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS137)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS138)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS139)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS140)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS141)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS142)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS143)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS144)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS145)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS146)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS147)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS148)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS149)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS150)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS151)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS152)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS153)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS154)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS155)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS156)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS157)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS158)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS159)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS160)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS161)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS162)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS163)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS164)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS165)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS166)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS167)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS168)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS169)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS170)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS171)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS172)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS173)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS174)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS175)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS176)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS177)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS178)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS179)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS180)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS181)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS182)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS183)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS184)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS185)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS186)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS187)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS188)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS189)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS190)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS191)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS192)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS193)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS194)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS195)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_QUESTIONFIIS196)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_PROFILE_IMAGE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_CREATION_DATE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ConstansFIIS.COLUMN_UPDATE_DATE))
                );
                recordsList.add(record);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return recordsList;
    }

    public void updateRecord(String id, String questionfiis1, String questionfiis2, String questionfiis3, String questionfiis4, String questionfiis5, String questionfiis6, String questionfiis7, String questionfiis8, String questionfiis9, String questionfiis10, String questionfiis11, String questionfiis12, String questionfiis13, String questionfiis14, String questionfiis15, String questionfiis16, String questionfiis17, String questionfiis18, String questionfiis19, String questionfiis20, String questionfiis21, String questionfiis22, String questionfiis23, String questionfiis24, String questionfiis25, String questionfiis26, String questionfiis27, String questionfiis28, String questionfiis29, String questionfiis30, String questionfiis31, String questionfiis32, String questionfiis33, String questionfiis34, String questionfiis35, String questionfiis36, String questionfiis37, String questionfiis38, String questionfiis39, String questionfiis40, String questionfiis41, String questionfiis42, String questionfiis43, String questionfiis44, String questionfiis45, String questionfiis46, String questionfiis47, String questionfiis48, String questionfiis49, String questionfiis50, String questionfiis51, String questionfiis52, String questionfiis53, String questionfiis54, String questionfiis55, String questionfiis56, String questionfiis57, String questionfiis58, String questionfiis59, String questionfiis60, String questionfiis61, String questionfiis62, String questionfiis63, String questionfiis64, String questionfiis65, String questionfiis66, String questionfiis67, String questionfiis68, String questionfiis69, String questionfiis70, String questionfiis71, String questionfiis72, String questionfiis73, String questionfiis74, String questionfiis75, String questionfiis76, String questionfiis77, String questionfiis78, String questionfiis79, String questionfiis80, String questionfiis81, String questionfiis82, String questionfiis83, String questionfiis84, String questionfiis85, String questionfiis86, String questionfiis87, String questionfiis88, String questionfiis89, String questionfiis90, String questionfiis91, String questionfiis92, String questionfiis93, String questionfiis94, String questionfiis95, String questionfiis96, String questionfiis97, String questionfiis98, String questionfiis99, String questionfiis100, String questionfiis101, String questionfiis102, String questionfiis103, String questionfiis104, String questionfiis105, String questionfiis106, String questionfiis107, String questionfiis108, String questionfiis109, String questionfiis110, String questionfiis111, String questionfiis112, String questionfiis113, String questionfiis114, String questionfiis115, String questionfiis116, String questionfiis117, String questionfiis118, String questionfiis119, String questionfiis120, String questionfiis121, String questionfiis122, String questionfiis123, String questionfiis124, String questionfiis125, String questionfiis126, String questionfiis127, String questionfiis128, String questionfiis129, String questionfiis130, String questionfiis131, String questionfiis132, String questionfiis133, String questionfiis134, String questionfiis135, String questionfiis136, String questionfiis137, String questionfiis138, String questionfiis139, String questionfiis140, String questionfiis141, String questionfiis142, String questionfiis143, String questionfiis144, String questionfiis145, String questionfiis146, String questionfiis147, String questionfiis148, String questionfiis149, String questionfiis150, String questionfiis151, String questionfiis152, String questionfiis153, String questionfiis154, String questionfiis155, String questionfiis156, String questionfiis157, String questionfiis158, String questionfiis159, String questionfiis160, String questionfiis161, String questionfiis162, String questionfiis163, String questionfiis164, String questionfiis165, String questionfiis166, String questionfiis167, String questionfiis168, String questionfiis169, String questionfiis170, String questionfiis171, String questionfiis172, String questionfiis173, String questionfiis174, String questionfiis175, String questionfiis176, String questionfiis177, String questionfiis178, String questionfiis179, String questionfiis180, String questionfiis181, String questionfiis182, String questionfiis183, String questionfiis184, String questionfiis185, String questionfiis186, String questionfiis187, String questionfiis188, String questionfiis189, String questionfiis190, String questionfiis191, String questionfiis192, String questionfiis193, String questionfiis194, String questionfiis195, String questionfiis196, String profileImage, String creationDate, String updateDate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTIONFIIS1, questionfiis1);
        values.put(COLUMN_QUESTIONFIIS2, questionfiis2);
        values.put(COLUMN_QUESTIONFIIS3, questionfiis3);
        values.put(COLUMN_QUESTIONFIIS4, questionfiis4);
        values.put(COLUMN_QUESTIONFIIS5, questionfiis5);
        values.put(COLUMN_QUESTIONFIIS6, questionfiis6);
        values.put(COLUMN_QUESTIONFIIS7, questionfiis7);
        values.put(COLUMN_QUESTIONFIIS8, questionfiis8);
        values.put(COLUMN_QUESTIONFIIS9, questionfiis9);
        values.put(COLUMN_QUESTIONFIIS10, questionfiis10);
        values.put(COLUMN_QUESTIONFIIS11, questionfiis11);
        values.put(COLUMN_QUESTIONFIIS12, questionfiis12);
        values.put(COLUMN_QUESTIONFIIS13, questionfiis13);
        values.put(COLUMN_QUESTIONFIIS14, questionfiis14);
        values.put(COLUMN_QUESTIONFIIS15, questionfiis15);
        values.put(COLUMN_QUESTIONFIIS16, questionfiis16);
        values.put(COLUMN_QUESTIONFIIS17, questionfiis17);
        values.put(COLUMN_QUESTIONFIIS18, questionfiis18);
        values.put(COLUMN_QUESTIONFIIS19, questionfiis19);
        values.put(COLUMN_QUESTIONFIIS20, questionfiis20);
        values.put(COLUMN_QUESTIONFIIS21, questionfiis21);
        values.put(COLUMN_QUESTIONFIIS22, questionfiis22);
        values.put(COLUMN_QUESTIONFIIS23, questionfiis23);
        values.put(COLUMN_QUESTIONFIIS24, questionfiis24);
        values.put(COLUMN_QUESTIONFIIS25, questionfiis25);
        values.put(COLUMN_QUESTIONFIIS26, questionfiis26);
        values.put(COLUMN_QUESTIONFIIS27, questionfiis27);
        values.put(COLUMN_QUESTIONFIIS28, questionfiis28);
        values.put(COLUMN_QUESTIONFIIS29, questionfiis29);
        values.put(COLUMN_QUESTIONFIIS30, questionfiis30);
        values.put(COLUMN_QUESTIONFIIS31, questionfiis31);
        values.put(COLUMN_QUESTIONFIIS32, questionfiis32);
        values.put(COLUMN_QUESTIONFIIS33, questionfiis33);
        values.put(COLUMN_QUESTIONFIIS34, questionfiis34);
        values.put(COLUMN_QUESTIONFIIS35, questionfiis35);
        values.put(COLUMN_QUESTIONFIIS36, questionfiis36);
        values.put(COLUMN_QUESTIONFIIS37, questionfiis37);
        values.put(COLUMN_QUESTIONFIIS38, questionfiis38);
        values.put(COLUMN_QUESTIONFIIS39, questionfiis39);
        values.put(COLUMN_QUESTIONFIIS40, questionfiis40);
        values.put(COLUMN_QUESTIONFIIS41, questionfiis41);
        values.put(COLUMN_QUESTIONFIIS42, questionfiis42);
        values.put(COLUMN_QUESTIONFIIS43, questionfiis43);
        values.put(COLUMN_QUESTIONFIIS44, questionfiis44);
        values.put(COLUMN_QUESTIONFIIS45, questionfiis45);
        values.put(COLUMN_QUESTIONFIIS46, questionfiis46);
        values.put(COLUMN_QUESTIONFIIS47, questionfiis47);
        values.put(COLUMN_QUESTIONFIIS48, questionfiis48);
        values.put(COLUMN_QUESTIONFIIS49, questionfiis49);
        values.put(COLUMN_QUESTIONFIIS50, questionfiis50);
        values.put(COLUMN_QUESTIONFIIS51, questionfiis51);
        values.put(COLUMN_QUESTIONFIIS52, questionfiis52);
        values.put(COLUMN_QUESTIONFIIS53, questionfiis53);
        values.put(COLUMN_QUESTIONFIIS54, questionfiis54);
        values.put(COLUMN_QUESTIONFIIS55, questionfiis55);
        values.put(COLUMN_QUESTIONFIIS56, questionfiis56);
        values.put(COLUMN_QUESTIONFIIS57, questionfiis57);
        values.put(COLUMN_QUESTIONFIIS58, questionfiis58);
        values.put(COLUMN_QUESTIONFIIS59, questionfiis59);
        values.put(COLUMN_QUESTIONFIIS60, questionfiis60);
        values.put(COLUMN_QUESTIONFIIS61, questionfiis61);
        values.put(COLUMN_QUESTIONFIIS62, questionfiis62);
        values.put(COLUMN_QUESTIONFIIS63, questionfiis63);
        values.put(COLUMN_QUESTIONFIIS64, questionfiis64);
        values.put(COLUMN_QUESTIONFIIS65, questionfiis65);
        values.put(COLUMN_QUESTIONFIIS66, questionfiis66);
        values.put(COLUMN_QUESTIONFIIS67, questionfiis67);
        values.put(COLUMN_QUESTIONFIIS68, questionfiis68);
        values.put(COLUMN_QUESTIONFIIS69, questionfiis69);
        values.put(COLUMN_QUESTIONFIIS70, questionfiis70);
        values.put(COLUMN_QUESTIONFIIS71, questionfiis71);
        values.put(COLUMN_QUESTIONFIIS72, questionfiis72);
        values.put(COLUMN_QUESTIONFIIS73, questionfiis73);
        values.put(COLUMN_QUESTIONFIIS74, questionfiis74);
        values.put(COLUMN_QUESTIONFIIS75, questionfiis75);
        values.put(COLUMN_QUESTIONFIIS76, questionfiis76);
        values.put(COLUMN_QUESTIONFIIS77, questionfiis77);
        values.put(COLUMN_QUESTIONFIIS78, questionfiis78);
        values.put(COLUMN_QUESTIONFIIS79, questionfiis79);
        values.put(COLUMN_QUESTIONFIIS80, questionfiis80);
        values.put(COLUMN_QUESTIONFIIS81, questionfiis81);
        values.put(COLUMN_QUESTIONFIIS82, questionfiis82);
        values.put(COLUMN_QUESTIONFIIS83, questionfiis83);
        values.put(COLUMN_QUESTIONFIIS84, questionfiis84);
        values.put(COLUMN_QUESTIONFIIS85, questionfiis85);
        values.put(COLUMN_QUESTIONFIIS86, questionfiis86);
        values.put(COLUMN_QUESTIONFIIS87, questionfiis87);
        values.put(COLUMN_QUESTIONFIIS88, questionfiis88);
        values.put(COLUMN_QUESTIONFIIS89, questionfiis89);
        values.put(COLUMN_QUESTIONFIIS90, questionfiis90);
        values.put(COLUMN_QUESTIONFIIS91, questionfiis91);
        values.put(COLUMN_QUESTIONFIIS92, questionfiis92);
        values.put(COLUMN_QUESTIONFIIS93, questionfiis93);
        values.put(COLUMN_QUESTIONFIIS94, questionfiis94);
        values.put(COLUMN_QUESTIONFIIS95, questionfiis95);
        values.put(COLUMN_QUESTIONFIIS96, questionfiis96);
        values.put(COLUMN_QUESTIONFIIS97, questionfiis97);
        values.put(COLUMN_QUESTIONFIIS98, questionfiis98);
        values.put(COLUMN_QUESTIONFIIS99, questionfiis99);
        values.put(COLUMN_QUESTIONFIIS100, questionfiis100);
        values.put(COLUMN_QUESTIONFIIS101, questionfiis101);
        values.put(COLUMN_QUESTIONFIIS102, questionfiis102);
        values.put(COLUMN_QUESTIONFIIS103, questionfiis103);
        values.put(COLUMN_QUESTIONFIIS104, questionfiis104);
        values.put(COLUMN_QUESTIONFIIS105, questionfiis105);
        values.put(COLUMN_QUESTIONFIIS106, questionfiis106);
        values.put(COLUMN_QUESTIONFIIS107, questionfiis107);
        values.put(COLUMN_QUESTIONFIIS108, questionfiis108);
        values.put(COLUMN_QUESTIONFIIS109, questionfiis109);
        values.put(COLUMN_QUESTIONFIIS110, questionfiis110);
        values.put(COLUMN_QUESTIONFIIS111, questionfiis111);
        values.put(COLUMN_QUESTIONFIIS112, questionfiis112);
        values.put(COLUMN_QUESTIONFIIS113, questionfiis113);
        values.put(COLUMN_QUESTIONFIIS114, questionfiis114);
        values.put(COLUMN_QUESTIONFIIS115, questionfiis115);
        values.put(COLUMN_QUESTIONFIIS116, questionfiis116);
        values.put(COLUMN_QUESTIONFIIS117, questionfiis117);
        values.put(COLUMN_QUESTIONFIIS118, questionfiis118);
        values.put(COLUMN_QUESTIONFIIS119, questionfiis119);
        values.put(COLUMN_QUESTIONFIIS120, questionfiis120);
        values.put(COLUMN_QUESTIONFIIS121, questionfiis121);
        values.put(COLUMN_QUESTIONFIIS122, questionfiis122);
        values.put(COLUMN_QUESTIONFIIS123, questionfiis123);
        values.put(COLUMN_QUESTIONFIIS124, questionfiis124);
        values.put(COLUMN_QUESTIONFIIS125, questionfiis125);
        values.put(COLUMN_QUESTIONFIIS126, questionfiis126);
        values.put(COLUMN_QUESTIONFIIS127, questionfiis127);
        values.put(COLUMN_QUESTIONFIIS128, questionfiis128);
        values.put(COLUMN_QUESTIONFIIS129, questionfiis129);
        values.put(COLUMN_QUESTIONFIIS130, questionfiis130);
        values.put(COLUMN_QUESTIONFIIS131, questionfiis131);
        values.put(COLUMN_QUESTIONFIIS132, questionfiis132);
        values.put(COLUMN_QUESTIONFIIS133, questionfiis133);
        values.put(COLUMN_QUESTIONFIIS134, questionfiis134);
        values.put(COLUMN_QUESTIONFIIS135, questionfiis135);
        values.put(COLUMN_QUESTIONFIIS136, questionfiis136);
        values.put(COLUMN_QUESTIONFIIS137, questionfiis137);
        values.put(COLUMN_QUESTIONFIIS138, questionfiis138);
        values.put(COLUMN_QUESTIONFIIS139, questionfiis139);
        values.put(COLUMN_QUESTIONFIIS140, questionfiis140);
        values.put(COLUMN_QUESTIONFIIS141, questionfiis141);
        values.put(COLUMN_QUESTIONFIIS142, questionfiis142);
        values.put(COLUMN_QUESTIONFIIS143, questionfiis143);
        values.put(COLUMN_QUESTIONFIIS144, questionfiis144);
        values.put(COLUMN_QUESTIONFIIS145, questionfiis145);
        values.put(COLUMN_QUESTIONFIIS146, questionfiis146);
        values.put(COLUMN_QUESTIONFIIS147, questionfiis147);
        values.put(COLUMN_QUESTIONFIIS148, questionfiis148);
        values.put(COLUMN_QUESTIONFIIS149, questionfiis149);
        values.put(COLUMN_QUESTIONFIIS150, questionfiis150);
        values.put(COLUMN_QUESTIONFIIS151, questionfiis151);
        values.put(COLUMN_QUESTIONFIIS152, questionfiis152);
        values.put(COLUMN_QUESTIONFIIS153, questionfiis153);
        values.put(COLUMN_QUESTIONFIIS154, questionfiis154);
        values.put(COLUMN_QUESTIONFIIS155, questionfiis155);
        values.put(COLUMN_QUESTIONFIIS156, questionfiis156);
        values.put(COLUMN_QUESTIONFIIS157, questionfiis157);
        values.put(COLUMN_QUESTIONFIIS158, questionfiis158);
        values.put(COLUMN_QUESTIONFIIS159, questionfiis159);
        values.put(COLUMN_QUESTIONFIIS160, questionfiis160);
        values.put(COLUMN_QUESTIONFIIS161, questionfiis161);
        values.put(COLUMN_QUESTIONFIIS162, questionfiis162);
        values.put(COLUMN_QUESTIONFIIS163, questionfiis163);
        values.put(COLUMN_QUESTIONFIIS164, questionfiis164);
        values.put(COLUMN_QUESTIONFIIS165, questionfiis165);
        values.put(COLUMN_QUESTIONFIIS166, questionfiis166);
        values.put(COLUMN_QUESTIONFIIS167, questionfiis167);
        values.put(COLUMN_QUESTIONFIIS168, questionfiis168);
        values.put(COLUMN_QUESTIONFIIS169, questionfiis169);
        values.put(COLUMN_QUESTIONFIIS170, questionfiis170);
        values.put(COLUMN_QUESTIONFIIS171, questionfiis171);
        values.put(COLUMN_QUESTIONFIIS172, questionfiis172);
        values.put(COLUMN_QUESTIONFIIS173, questionfiis173);
        values.put(COLUMN_QUESTIONFIIS174, questionfiis174);
        values.put(COLUMN_QUESTIONFIIS175, questionfiis175);
        values.put(COLUMN_QUESTIONFIIS176, questionfiis176);
        values.put(COLUMN_QUESTIONFIIS177, questionfiis177);
        values.put(COLUMN_QUESTIONFIIS178, questionfiis178);
        values.put(COLUMN_QUESTIONFIIS179, questionfiis179);
        values.put(COLUMN_QUESTIONFIIS180, questionfiis180);
        values.put(COLUMN_QUESTIONFIIS181, questionfiis181);
        values.put(COLUMN_QUESTIONFIIS182, questionfiis182);
        values.put(COLUMN_QUESTIONFIIS183, questionfiis183);
        values.put(COLUMN_QUESTIONFIIS184, questionfiis184);
        values.put(COLUMN_QUESTIONFIIS185, questionfiis185);
        values.put(COLUMN_QUESTIONFIIS186, questionfiis186);
        values.put(COLUMN_QUESTIONFIIS187, questionfiis187);
        values.put(COLUMN_QUESTIONFIIS188, questionfiis188);
        values.put(COLUMN_QUESTIONFIIS189, questionfiis189);
        values.put(COLUMN_QUESTIONFIIS190, questionfiis190);
        values.put(COLUMN_QUESTIONFIIS191, questionfiis191);
        values.put(COLUMN_QUESTIONFIIS192, questionfiis192);
        values.put(COLUMN_QUESTIONFIIS193, questionfiis193);
        values.put(COLUMN_QUESTIONFIIS194, questionfiis194);
        values.put(COLUMN_QUESTIONFIIS195, questionfiis195);
        values.put(COLUMN_QUESTIONFIIS196, questionfiis196);
        values.put(COLUMN_PROFILE_IMAGE, profileImage);
        values.put(COLUMN_UPDATE_DATE, updateDate);
        db.update(TABLE_NAME, values, COLUMN_ID + "=?", new String[]{id});
    }

    public int getRecordsCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{id});
    }
}
