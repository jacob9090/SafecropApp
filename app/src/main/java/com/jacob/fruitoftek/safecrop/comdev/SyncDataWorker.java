package com.jacob.fruitoftek.safecrop.comdev;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.jacob.fruitoftek.safecrop.comdev.ch.ChildSurveyDBHelper;
import com.jacob.fruitoftek.safecrop.comdev.com.ComDbHelper;
import com.jacob.fruitoftek.safecrop.comdev.hh.HhDbHelper;
import com.jacob.fruitoftek.safecrop.comdev.obs.ObsDbHelper;
import com.jacob.fruitoftek.safecrop.comdev.sch.SchoolDbHelper;

import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

import org.json.JSONException;

import java.util.concurrent.TimeUnit;

public class SyncDataWorker extends Worker {

    private static final int MAX_RETRIES = 3;
    private static final String COMSERVER_URL = "https://app.safecropgh.org/clmrs/auto_com.php";
    private static final String SCHOOLSERVER_URL = "https://app.safecropgh.org/clmrs/auto_school.php";
    private static final String HHSERVER_URL = "https://app.safecropgh.org/clmrs/auto_hh.php";
    private static final String OBSSERVER_URL = "https://app.safecropgh.org/clmrs/auto_obs.php";
    private static final String CHILDSERVER_URL = "https://app.safecropgh.org/clmrs/auto_child.php";

    private final ComDbHelper comDbHelper;
    private final SchoolDbHelper schoolDbHelper;
    private final HhDbHelper hhDbHelper;
    private final ObsDbHelper obsDbHelper;
    private final ChildSurveyDBHelper chdbHelper;

    public SyncDataWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.comDbHelper = new ComDbHelper(context);
        this.schoolDbHelper = new SchoolDbHelper(context);
        this.hhDbHelper = new HhDbHelper(context);
        this.obsDbHelper = new ObsDbHelper(context);
        this.chdbHelper = new ChildSurveyDBHelper(context);
    }

    @NonNull
    @Override
    public Result doWork() {
        boolean comSuccess = syncCommunityData();
        boolean schSuccess = syncSchoolData();
        boolean hhSuccess = syncHhData();
        boolean obsSuccess = syncObsData();
        boolean chSuccess = syncChData();
        return (comSuccess && schSuccess && hhSuccess && obsSuccess && chSuccess) ? Result.success() : Result.retry();
    }

    private boolean syncCommunityData() {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = comDbHelper.getReadableDatabase();
            cursor = db.rawQuery("SELECT commquestion1, commquestion2, commquestion3, commquestion4, commquestion5, commquestion6, commquestion7, commquestion8, commquestion9, commquestion10, commquestion11, commquestion12, commquestion13, commquestion14, commquestion15, commquestion16, commquestion17, commquestion18, commquestion19, commquestion20, commquestion21, commquestion22, commquestion23, commquestion24, commquestion25, commquestion26, commquestion27, commquestion28, commquestion29, commquestion30, commquestion31, commquestion32, commquestion33, commquestion34, commquestion35, commquestion36, commquestion37, commquestion38, commquestion39, commquestion40, commquestion41, commquestion42, commquestion43, commquestion44, commquestion45, commquestion46, commquestion47, commquestion48, commquestion49, commquestion50, commquestion51, commquestion52, commquestion53, commquestion54, commquestion56, commquestion57, commquestion58, commquestion59, commquestion60, commquestion61, commquestion62, commquestion63, commquestion64, commquestion65, commquestion66, commquestion67, com_location, user_fname, user_lname, user_email, on_create, on_update FROM ComSurveyTbl", null);

            if (cursor == null || !cursor.moveToFirst()) {
                Log.i("SyncWorker", "No community data to sync");
                return true;
            }

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(90, TimeUnit.SECONDS)
                    .readTimeout(90, TimeUnit.SECONDS)
                    .build();

            do {
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("commquestion1", getString(cursor, "commquestion1"));
                    jsonObject.put("commquestion2", getString(cursor, "commquestion2"));
                    jsonObject.put("commquestion3", getString(cursor, "commquestion3"));
                    jsonObject.put("commquestion4", getString(cursor, "commquestion4"));
                    jsonObject.put("commquestion5", getString(cursor, "commquestion5"));
                    jsonObject.put("commquestion6", getString(cursor, "commquestion6"));
                    jsonObject.put("commquestion7", getString(cursor, "commquestion7"));
                    jsonObject.put("commquestion8", getString(cursor, "commquestion8"));
                    jsonObject.put("commquestion9", getString(cursor, "commquestion9"));
                    jsonObject.put("commquestion10", getString(cursor, "commquestion10"));
                    jsonObject.put("commquestion11", getString(cursor, "commquestion11"));
                    jsonObject.put("commquestion12", getString(cursor, "commquestion12"));
                    jsonObject.put("commquestion13", getString(cursor, "commquestion13"));
                    jsonObject.put("commquestion14", getString(cursor, "commquestion14"));
                    jsonObject.put("commquestion15", getString(cursor, "commquestion15"));
                    jsonObject.put("commquestion16", getString(cursor, "commquestion16"));
                    jsonObject.put("commquestion17", getString(cursor, "commquestion17"));
                    jsonObject.put("commquestion18", getString(cursor, "commquestion18"));
                    jsonObject.put("commquestion19", getString(cursor, "commquestion19"));
                    jsonObject.put("commquestion20", getString(cursor, "commquestion20"));
                    jsonObject.put("commquestion21", getString(cursor, "commquestion21"));
                    jsonObject.put("commquestion22", getString(cursor, "commquestion22"));
                    jsonObject.put("commquestion23", getString(cursor, "commquestion23"));
                    jsonObject.put("commquestion24", getString(cursor, "commquestion24"));
                    jsonObject.put("commquestion25", getString(cursor, "commquestion25"));
                    jsonObject.put("commquestion26", getString(cursor, "commquestion26"));
                    jsonObject.put("commquestion27", getString(cursor, "commquestion27"));
                    jsonObject.put("commquestion28", getString(cursor, "commquestion28"));
                    jsonObject.put("commquestion29", getString(cursor, "commquestion29"));
                    jsonObject.put("commquestion30", getString(cursor, "commquestion30"));
                    jsonObject.put("commquestion31", getString(cursor, "commquestion31"));
                    jsonObject.put("commquestion32", getString(cursor, "commquestion32"));
                    jsonObject.put("commquestion33", getString(cursor, "commquestion33"));
                    jsonObject.put("commquestion34", getString(cursor, "commquestion34"));
                    jsonObject.put("commquestion35", getString(cursor, "commquestion35"));
                    jsonObject.put("commquestion36", getString(cursor, "commquestion36"));
                    jsonObject.put("commquestion37", getString(cursor, "commquestion37"));
                    jsonObject.put("commquestion38", getString(cursor, "commquestion38"));
                    jsonObject.put("commquestion39", getString(cursor, "commquestion39"));
                    jsonObject.put("commquestion40", getString(cursor, "commquestion40"));
                    jsonObject.put("commquestion41", getString(cursor, "commquestion41"));
                    jsonObject.put("commquestion42", getString(cursor, "commquestion42"));
                    jsonObject.put("commquestion43", getString(cursor, "commquestion43"));
                    jsonObject.put("commquestion44", getString(cursor, "commquestion44"));
                    jsonObject.put("commquestion45", getString(cursor, "commquestion45"));
                    jsonObject.put("commquestion46", getString(cursor, "commquestion46"));
                    jsonObject.put("commquestion47", getString(cursor, "commquestion47"));
                    jsonObject.put("commquestion48", getString(cursor, "commquestion48"));
                    jsonObject.put("commquestion49", getString(cursor, "commquestion49"));
                    jsonObject.put("commquestion50", getString(cursor, "commquestion50"));
                    jsonObject.put("commquestion51", getString(cursor, "commquestion51"));
                    jsonObject.put("commquestion52", getString(cursor, "commquestion52"));
                    jsonObject.put("commquestion53", getString(cursor, "commquestion53"));
                    jsonObject.put("commquestion54", getString(cursor, "commquestion54"));
                    jsonObject.put("commquestion56", getString(cursor, "commquestion56"));
                    jsonObject.put("commquestion57", getString(cursor, "commquestion57"));
                    jsonObject.put("commquestion58", getString(cursor, "commquestion58"));
                    jsonObject.put("commquestion59", getString(cursor, "commquestion59"));
                    jsonObject.put("commquestion60", getString(cursor, "commquestion60"));
                    jsonObject.put("commquestion61", getString(cursor, "commquestion61"));
                    jsonObject.put("commquestion62", getString(cursor, "commquestion62"));
                    jsonObject.put("commquestion63", getString(cursor, "commquestion63"));
                    jsonObject.put("commquestion64", getString(cursor, "commquestion64"));
                    jsonObject.put("commquestion65", getString(cursor, "commquestion65"));
                    jsonObject.put("commquestion66", getString(cursor, "commquestion66"));
                    jsonObject.put("commquestion67", getString(cursor, "commquestion67"));
                    jsonObject.put("com_location", getString(cursor, "com_location"));
                    jsonObject.put("user_fname", getString(cursor, "user_fname"));
                    jsonObject.put("user_lname", getString(cursor, "user_lname"));
                    jsonObject.put("user_email", getString(cursor, "user_email"));
                    jsonObject.put("on_create", getString(cursor, "on_create"));
                    jsonObject.put("on_update", getString(cursor, "on_update"));

                    RequestBody body = RequestBody.create(
                            jsonObject.toString(),
                            MediaType.parse("application/json")
                    );

                    Request request = new Request.Builder()
                            .url(COMSERVER_URL)
                            .post(body)
                            .build();

                    if (!sendRequestWithRetry(client, request)) {
                        Log.e("SyncWorker", "Community sync failed after retries");
                        return false;
                    }
                } catch (JSONException e) {
                    Log.e("SyncWorker", "Community data error", e);
                    return false;
                }
            } while (cursor.moveToNext());

            return true;
        } catch (Exception e) {
            Log.e("SyncWorker", "Community sync failed", e);
            return false;
        } finally {
            if (cursor != null) cursor.close();
            if (db != null) db.close();
        }
    }



    private boolean syncSchoolData() {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = schoolDbHelper.getReadableDatabase();
            cursor = db.rawQuery("SELECT school_name, school_district, school_community, schquestion4, schquestion5, schquestion6, schquestion7, schquestion8, schquestion9, schquestion10, schquestion11, schquestion12, schquestion13, schquestion14, schquestion15, schquestion16, schquestion17, schquestion18, schquestion19, schquestion20, schquestion21, schquestion22, schquestion23, schquestion24, schquestion25, schquestion26, schquestion27, schquestion28, schquestion29, schquestion30, schquestion31, schquestion32, schquestion33, schquestion34, school_location, user_fname, user_lname, user_email, on_create, on_update FROM SchoolSurveyTbl", null);

            if (cursor == null || !cursor.moveToFirst()) {
                Log.i("SyncWorker", "No school data to sync");
                return true;
            }

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(90, TimeUnit.SECONDS)
                    .readTimeout(90, TimeUnit.SECONDS)
                    .build();

            do {
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("school_name", getString(cursor, "school_name"));
                    jsonObject.put("school_district", getString(cursor, "school_district"));
                    jsonObject.put("school_community", getString(cursor, "school_community"));
                    jsonObject.put("schquestion4", getString(cursor, "schquestion4"));
                    jsonObject.put("schquestion5", getString(cursor, "schquestion5"));
                    jsonObject.put("schquestion6", getString(cursor, "schquestion6"));
                    jsonObject.put("schquestion7", getString(cursor, "schquestion7"));
                    jsonObject.put("schquestion8", getString(cursor, "schquestion8"));
                    jsonObject.put("schquestion9", getString(cursor, "schquestion9"));
                    jsonObject.put("schquestion10", getString(cursor, "schquestion10"));
                    jsonObject.put("schquestion11", getString(cursor, "schquestion11"));
                    jsonObject.put("schquestion12", getString(cursor, "schquestion12"));
                    jsonObject.put("schquestion13", getString(cursor, "schquestion13"));
                    jsonObject.put("schquestion14", getString(cursor, "schquestion14"));
                    jsonObject.put("schquestion15", getString(cursor, "schquestion15"));
                    jsonObject.put("schquestion16", getString(cursor, "schquestion16"));
                    jsonObject.put("schquestion17", getString(cursor, "schquestion17"));
                    jsonObject.put("schquestion18", getString(cursor, "schquestion18"));
                    jsonObject.put("schquestion19", getString(cursor, "schquestion19"));
                    jsonObject.put("schquestion20", getString(cursor, "schquestion20"));
                    jsonObject.put("schquestion21", getString(cursor, "schquestion21"));
                    jsonObject.put("schquestion22", getString(cursor, "schquestion22"));
                    jsonObject.put("schquestion23", getString(cursor, "schquestion23"));
                    jsonObject.put("schquestion24", getString(cursor, "schquestion24"));
                    jsonObject.put("schquestion25", getString(cursor, "schquestion25"));
                    jsonObject.put("schquestion26", getString(cursor, "schquestion26"));
                    jsonObject.put("schquestion27", getString(cursor, "schquestion27"));
                    jsonObject.put("schquestion28", getString(cursor, "schquestion28"));
                    jsonObject.put("schquestion29", getString(cursor, "schquestion29"));
                    jsonObject.put("schquestion30", getString(cursor, "schquestion30"));
                    jsonObject.put("schquestion31", getString(cursor, "schquestion31"));
                    jsonObject.put("schquestion32", getString(cursor, "schquestion32"));
                    jsonObject.put("schquestion33", getString(cursor, "schquestion33"));
                    jsonObject.put("schquestion34", getString(cursor, "schquestion34"));
                    jsonObject.put("school_location", getString(cursor, "school_location"));
                    jsonObject.put("user_fname", getString(cursor, "user_fname"));
                    jsonObject.put("user_lname", getString(cursor, "user_lname"));
                    jsonObject.put("user_email", getString(cursor, "user_email"));
                    jsonObject.put("on_create", getString(cursor, "on_create"));
                    jsonObject.put("on_update", getString(cursor, "on_update"));

                    RequestBody body = RequestBody.create(
                            jsonObject.toString(),
                            MediaType.parse("application/json")
                    );

                    Request request = new Request.Builder()
                            .url(SCHOOLSERVER_URL)
                            .post(body)
                            .build();

                    if (!sendRequestWithRetry(client, request)) {
                        Log.e("SyncWorker", "School sync failed after retries");
                        return false;
                    }
                } catch (JSONException e) {
                    Log.e("SyncWorker", "School data error", e);
                    return false;
                }
            } while (cursor.moveToNext());

            return true;
        } catch (Exception e) {
            Log.e("SyncWorker", "School sync failed", e);
            return false;
        } finally {
            if (cursor != null) cursor.close();
            if (db != null) db.close();
        }
    }


    private boolean syncHhData() {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = hhDbHelper.getReadableDatabase();
            cursor = db.rawQuery("SELECT hh_name, hh_district, hh_community, hhquestion4, hhquestion5, hhquestion6, hhquestion7, hhquestion8, hhquestion9, hhquestion10, hhquestion11, hhquestion12, hhquestion13, hhquestion14, hhquestion15, hhquestion16, hhquestion17, hhquestion18, hhquestion19, hhquestion20, hhquestion21, hhquestion22, hhquestion23, hhquestion24, hhquestion25, hhquestion26, hhquestion27, hhquestion28, hhquestion29, hhquestion30, hhquestion31, hhquestion32, hhquestion36, hhquestion37, hh_location, user_fname, user_lname, user_email, on_create, on_update FROM HouseholdSurveyTbl", null);

            if (cursor == null || !cursor.moveToFirst()) {
                Log.i("SyncWorker", "No household data to sync");
                return true;
            }

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(90, TimeUnit.SECONDS)
                    .readTimeout(90, TimeUnit.SECONDS)
                    .build();

            do {
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("hh_name", getString(cursor, "hh_name"));
                    jsonObject.put("hh_district", getString(cursor, "hh_district"));
                    jsonObject.put("hh_community", getString(cursor, "hh_community"));
                    jsonObject.put("hhquestion4", getString(cursor, "hhquestion4"));
                    jsonObject.put("hhquestion5", getString(cursor, "hhquestion5"));
                    jsonObject.put("hhquestion6", getString(cursor, "hhquestion6"));
                    jsonObject.put("hhquestion7", getString(cursor, "hhquestion7"));
                    jsonObject.put("hhquestion8", getString(cursor, "hhquestion8"));
                    jsonObject.put("hhquestion9", getString(cursor, "hhquestion9"));
                    jsonObject.put("hhquestion10", getString(cursor, "hhquestion10"));
                    jsonObject.put("hhquestion11", getString(cursor, "hhquestion11"));
                    jsonObject.put("hhquestion12", getString(cursor, "hhquestion12"));
                    jsonObject.put("hhquestion13", getString(cursor, "hhquestion13"));
                    jsonObject.put("hhquestion14", getString(cursor, "hhquestion14"));
                    jsonObject.put("hhquestion15", getString(cursor, "hhquestion15"));
                    jsonObject.put("hhquestion16", getString(cursor, "hhquestion16"));
                    jsonObject.put("hhquestion17", getString(cursor, "hhquestion17"));
                    jsonObject.put("hhquestion18", getString(cursor, "hhquestion18"));
                    jsonObject.put("hhquestion19", getString(cursor, "hhquestion19"));
                    jsonObject.put("hhquestion20", getString(cursor, "hhquestion20"));
                    jsonObject.put("hhquestion21", getString(cursor, "hhquestion21"));
                    jsonObject.put("hhquestion22", getString(cursor, "hhquestion22"));
                    jsonObject.put("hhquestion23", getString(cursor, "hhquestion23"));
                    jsonObject.put("hhquestion24", getString(cursor, "hhquestion24"));
                    jsonObject.put("hhquestion25", getString(cursor, "hhquestion25"));
                    jsonObject.put("hhquestion26", getString(cursor, "hhquestion26"));
                    jsonObject.put("hhquestion27", getString(cursor, "hhquestion27"));
                    jsonObject.put("hhquestion28", getString(cursor, "hhquestion28"));
                    jsonObject.put("hhquestion29", getString(cursor, "hhquestion29"));
                    jsonObject.put("hhquestion30", getString(cursor, "hhquestion30"));
                    jsonObject.put("hhquestion31", getString(cursor, "hhquestion31"));
                    jsonObject.put("hhquestion32", getString(cursor, "hhquestion32"));
                    jsonObject.put("hhquestion36", getString(cursor, "hhquestion36"));
                    jsonObject.put("hhquestion37", getString(cursor, "hhquestion37"));
                    jsonObject.put("hh_location", getString(cursor, "hh_location"));
                    jsonObject.put("user_fname", getString(cursor, "user_fname"));
                    jsonObject.put("user_lname", getString(cursor, "user_lname"));
                    jsonObject.put("user_email", getString(cursor, "user_email"));
                    jsonObject.put("on_create", getString(cursor, "on_create"));
                    jsonObject.put("on_update", getString(cursor, "on_update"));

                    RequestBody body = RequestBody.create(
                            jsonObject.toString(),
                            MediaType.parse("application/json")
                    );

                    Request request = new Request.Builder()
                            .url(HHSERVER_URL)
                            .post(body)
                            .build();

                    if (!sendRequestWithRetry(client, request)) {
                        Log.e("SyncWorker", "Household sync failed after retries");
                        return false;
                    }
                } catch (JSONException e) {
                    Log.e("SyncWorker", "Household data error", e);
                    return false;
                }
            } while (cursor.moveToNext());

            return true;
        } catch (Exception e) {
            Log.e("SyncWorker", "Household sync failed", e);
            return false;
        } finally {
            if (cursor != null) cursor.close();
            if (db != null) db.close();
        }
    }


    private boolean syncObsData() {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = obsDbHelper.getReadableDatabase();
            cursor = db.rawQuery("SELECT obs_name, obs_district, obs_community, obsquestion6, obsquestion7, obsquestion8, obsquestion9, obsquestion10, obsquestion11, obsquestion12, obsquestion13, obsquestion14, obsquestion15, obsquestion16, obsquestion17, obsquestion18, obsquestion19, obsquestion20, obsquestion21, obs_location, user_fname, user_lname, user_email, on_create, on_update FROM ObservationSurveyTbl", null);

            if (cursor == null || !cursor.moveToFirst()) {
                Log.i("SyncWorker", "No observation data to sync");
                return true;
            }

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(90, TimeUnit.SECONDS)
                    .readTimeout(90, TimeUnit.SECONDS)
                    .build();

            do {
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("obs_name", getString(cursor, "obs_name"));
                    jsonObject.put("obs_district", getString(cursor, "obs_district"));
                    jsonObject.put("obs_community", getString(cursor, "obs_community"));
                    jsonObject.put("obsquestion6", getString(cursor, "obsquestion6"));
                    jsonObject.put("obsquestion7", getString(cursor, "obsquestion7"));
                    jsonObject.put("obsquestion8", getString(cursor, "obsquestion8"));
                    jsonObject.put("obsquestion9", getString(cursor, "obsquestion9"));
                    jsonObject.put("obsquestion10", getString(cursor, "obsquestion10"));
                    jsonObject.put("obsquestion11", getString(cursor, "obsquestion11"));
                    jsonObject.put("obsquestion12", getString(cursor, "obsquestion12"));
                    jsonObject.put("obsquestion13", getString(cursor, "obsquestion13"));
                    jsonObject.put("obsquestion14", getString(cursor, "obsquestion14"));
                    jsonObject.put("obsquestion15", getString(cursor, "obsquestion15"));
                    jsonObject.put("obsquestion16", getString(cursor, "obsquestion16"));
                    jsonObject.put("obsquestion17", getString(cursor, "obsquestion17"));
                    jsonObject.put("obsquestion18", getString(cursor, "obsquestion18"));
                    jsonObject.put("obsquestion19", getString(cursor, "obsquestion19"));
                    jsonObject.put("obsquestion20", getString(cursor, "obsquestion20"));
                    jsonObject.put("obsquestion21", getString(cursor, "obsquestion21"));
                    jsonObject.put("obs_location", getString(cursor, "obs_location"));
                    jsonObject.put("user_fname", getString(cursor, "user_fname"));
                    jsonObject.put("user_lname", getString(cursor, "user_lname"));
                    jsonObject.put("user_email", getString(cursor, "user_email"));
                    jsonObject.put("on_create", getString(cursor, "on_create"));
                    jsonObject.put("on_update", getString(cursor, "on_update"));

                    RequestBody body = RequestBody.create(
                            jsonObject.toString(),
                            MediaType.parse("application/json")
                    );

                    Request request = new Request.Builder()
                            .url(OBSSERVER_URL)
                            .post(body)
                            .build();

                    if (!sendRequestWithRetry(client, request)) {
                        Log.e("SyncWorker", "Observation sync failed after retries");
                        return false;
                    }
                } catch (JSONException e) {
                    Log.e("SyncWorker", "Observation data error", e);
                    return false;
                }
            } while (cursor.moveToNext());

            return true;
        } catch (Exception e) {
            Log.e("SyncWorker", "Observation sync failed", e);
            return false;
        } finally {
            if (cursor != null) cursor.close();
            if (db != null) db.close();
        }
    }

    private boolean syncChData() {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = chdbHelper.getReadableDatabase();
            cursor = db.rawQuery("SELECT farmer_id, district, community, childquestion4, child1question1, child1question2, child1question3, child1question4, child1question5, child1question6, child1question7, child1question8, child1question9, child1question10, child1question11, child1question12, child1question13, child1question14, child1question15, child1question16, child1question17, child1question18, child1question19, child2question1, child2question2, child2question3, child2question4, child2question5, child2question6, child2question7, child2question8, child2question9, child2question10, child2question11, child2question12, child2question13, child2question14, child2question15, child2question16, child2question17, child2question18, child2question19, child3question1, child3question2, child3question3, child3question4, child3question5, child3question6, child3question7, child3question8, child3question9, child3question10, child3question11, child3question12, child3question13, child3question14, child3question15, child3question16, child3question17, child3question18, child3question19, child4question1, child4question2, child4question3, child4question4, child4question5, child4question6, child4question7, child4question8, child4question9, child4question10, child4question11, child4question12, child4question13, child4question14, child4question15, child4question16, child4question17, child4question18, child4question19, child5question1, child5question2, child5question3, child5question4, child5question5, child5question6, child5question7, child5question8, child5question9, child5question10, child5question11, child5question12, child5question13, child5question14, child5question15, child5question16, child5question17, child5question18, child5question19, child6question1, child6question2, child6question3, child6question4, child6question5, child6question6, child6question7, child6question8, child6question9, child6question10, child6question11, child6question12, child6question13, child6question14, child6question15, child6question16, child6question17, child6question18, child6question19, child7question1, child7question2, child7question3, child7question4, child7question5, child7question6, child7question7, child7question8, child7question9, child7question10, child7question11, child7question12, child7question13, child7question14, child7question15, child7question16, child7question17, child7question18, child7question19, child8question1, child8question2, child8question3, child8question4, child8question5, child8question6, child8question7, child8question8, child8question9, child8question10, child8question11, child8question12, child8question13, child8question14, child8question15, child8question16, child8question17, child8question18, child8question19, child9question1, child9question2, child9question3, child9question4, child9question5, child9question6, child9question7, child9question8, child9question9, child9question10, child9question11, child9question12, child9question13, child9question14, child9question15, child9question16, child9question17, child9question18, child9question19, child10question1, child10question2, child10question3, child10question4, child10question5, child10question6, child10question7, child10question8, child10question9, child10question10, child10question11, child10question12, child10question13, child10question14, child10question15, child10question16, child10question17, child10question18, child10question19, childquestion5, child_location, user_fname, user_lname, user_email, on_create, on_update FROM ChildSurveyTbl", null);

            if (cursor == null || !cursor.moveToFirst()) {
                Log.i("SyncWorker", "No child data to sync");
                return true;
            }

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(90, TimeUnit.SECONDS)
                    .readTimeout(90, TimeUnit.SECONDS)
                    .build();

            do {
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("farmer_id", getString(cursor, "farmer_id"));
                    jsonObject.put("district", getString(cursor, "district"));
                    jsonObject.put("community", getString(cursor, "community"));
                    jsonObject.put("childquestion4", getString(cursor, "childquestion4"));
                    jsonObject.put("child1question1", getString(cursor, "child1question1"));
                    jsonObject.put("child1question2", getString(cursor, "child1question2"));
                    jsonObject.put("child1question3", getString(cursor, "child1question3"));
                    jsonObject.put("child1question4", getString(cursor, "child1question4"));
                    jsonObject.put("child1question5", getString(cursor, "child1question5"));
                    jsonObject.put("child1question6", getString(cursor, "child1question6"));
                    jsonObject.put("child1question7", getString(cursor, "child1question7"));
                    jsonObject.put("child1question8", getString(cursor, "child1question8"));
                    jsonObject.put("child1question9", getString(cursor, "child1question9"));
                    jsonObject.put("child1question10", getString(cursor, "child1question10"));
                    jsonObject.put("child1question11", getString(cursor, "child1question11"));
                    jsonObject.put("child1question12", getString(cursor, "child1question12"));
                    jsonObject.put("child1question13", getString(cursor, "child1question13"));
                    jsonObject.put("child1question14", getString(cursor, "child1question14"));
                    jsonObject.put("child1question15", getString(cursor, "child1question15"));
                    jsonObject.put("child1question16", getString(cursor, "child1question16"));
                    jsonObject.put("child1question17", getString(cursor, "child1question17"));
                    jsonObject.put("child1question18", getString(cursor, "child1question18"));
                    jsonObject.put("child1question19", getString(cursor, "child1question19"));
                    jsonObject.put("child2question1", getString(cursor, "child2question1"));
                    jsonObject.put("child2question2", getString(cursor, "child2question2"));
                    jsonObject.put("child2question3", getString(cursor, "child2question3"));
                    jsonObject.put("child2question4", getString(cursor, "child2question4"));
                    jsonObject.put("child2question5", getString(cursor, "child2question5"));
                    jsonObject.put("child2question6", getString(cursor, "child2question6"));
                    jsonObject.put("child2question7", getString(cursor, "child2question7"));
                    jsonObject.put("child2question8", getString(cursor, "child2question8"));
                    jsonObject.put("child2question9", getString(cursor, "child2question9"));
                    jsonObject.put("child2question10", getString(cursor, "child2question10"));
                    jsonObject.put("child2question11", getString(cursor, "child2question11"));
                    jsonObject.put("child2question12", getString(cursor, "child2question12"));
                    jsonObject.put("child2question13", getString(cursor, "child2question13"));
                    jsonObject.put("child2question14", getString(cursor, "child2question14"));
                    jsonObject.put("child2question15", getString(cursor, "child2question15"));
                    jsonObject.put("child2question16", getString(cursor, "child2question16"));
                    jsonObject.put("child2question17", getString(cursor, "child2question17"));
                    jsonObject.put("child2question18", getString(cursor, "child2question18"));
                    jsonObject.put("child2question19", getString(cursor, "child2question19"));
                    jsonObject.put("child3question1", getString(cursor, "child3question1"));
                    jsonObject.put("child3question2", getString(cursor, "child3question2"));
                    jsonObject.put("child3question3", getString(cursor, "child3question3"));
                    jsonObject.put("child3question4", getString(cursor, "child3question4"));
                    jsonObject.put("child3question5", getString(cursor, "child3question5"));
                    jsonObject.put("child3question6", getString(cursor, "child3question6"));
                    jsonObject.put("child3question7", getString(cursor, "child3question7"));
                    jsonObject.put("child3question8", getString(cursor, "child3question8"));
                    jsonObject.put("child3question9", getString(cursor, "child3question9"));
                    jsonObject.put("child3question10", getString(cursor, "child3question10"));
                    jsonObject.put("child3question11", getString(cursor, "child3question11"));
                    jsonObject.put("child3question12", getString(cursor, "child3question12"));
                    jsonObject.put("child3question13", getString(cursor, "child3question13"));
                    jsonObject.put("child3question14", getString(cursor, "child3question14"));
                    jsonObject.put("child3question15", getString(cursor, "child3question15"));
                    jsonObject.put("child3question16", getString(cursor, "child3question16"));
                    jsonObject.put("child3question17", getString(cursor, "child3question17"));
                    jsonObject.put("child3question18", getString(cursor, "child3question18"));
                    jsonObject.put("child3question19", getString(cursor, "child3question19"));
                    jsonObject.put("child4question1", getString(cursor, "child4question1"));
                    jsonObject.put("child4question2", getString(cursor, "child4question2"));
                    jsonObject.put("child4question3", getString(cursor, "child4question3"));
                    jsonObject.put("child4question4", getString(cursor, "child4question4"));
                    jsonObject.put("child4question5", getString(cursor, "child4question5"));
                    jsonObject.put("child4question6", getString(cursor, "child4question6"));
                    jsonObject.put("child4question7", getString(cursor, "child4question7"));
                    jsonObject.put("child4question8", getString(cursor, "child4question8"));
                    jsonObject.put("child4question9", getString(cursor, "child4question9"));
                    jsonObject.put("child4question10", getString(cursor, "child4question10"));
                    jsonObject.put("child4question11", getString(cursor, "child4question11"));
                    jsonObject.put("child4question12", getString(cursor, "child4question12"));
                    jsonObject.put("child4question13", getString(cursor, "child4question13"));
                    jsonObject.put("child4question14", getString(cursor, "child4question14"));
                    jsonObject.put("child4question15", getString(cursor, "child4question15"));
                    jsonObject.put("child4question16", getString(cursor, "child4question16"));
                    jsonObject.put("child4question17", getString(cursor, "child4question17"));
                    jsonObject.put("child4question18", getString(cursor, "child4question18"));
                    jsonObject.put("child4question19", getString(cursor, "child4question19"));
                    jsonObject.put("child5question1", getString(cursor, "child5question1"));
                    jsonObject.put("child5question2", getString(cursor, "child5question2"));
                    jsonObject.put("child5question3", getString(cursor, "child5question3"));
                    jsonObject.put("child5question4", getString(cursor, "child5question4"));
                    jsonObject.put("child5question5", getString(cursor, "child5question5"));
                    jsonObject.put("child5question6", getString(cursor, "child5question6"));
                    jsonObject.put("child5question7", getString(cursor, "child5question7"));
                    jsonObject.put("child5question8", getString(cursor, "child5question8"));
                    jsonObject.put("child5question9", getString(cursor, "child5question9"));
                    jsonObject.put("child5question10", getString(cursor, "child5question10"));
                    jsonObject.put("child5question11", getString(cursor, "child5question11"));
                    jsonObject.put("child5question12", getString(cursor, "child5question12"));
                    jsonObject.put("child5question13", getString(cursor, "child5question13"));
                    jsonObject.put("child5question14", getString(cursor, "child5question14"));
                    jsonObject.put("child5question15", getString(cursor, "child5question15"));
                    jsonObject.put("child5question16", getString(cursor, "child5question16"));
                    jsonObject.put("child5question17", getString(cursor, "child5question17"));
                    jsonObject.put("child5question18", getString(cursor, "child5question18"));
                    jsonObject.put("child5question19", getString(cursor, "child5question19"));
                    jsonObject.put("child6question1", getString(cursor, "child6question1"));
                    jsonObject.put("child6question2", getString(cursor, "child6question2"));
                    jsonObject.put("child6question3", getString(cursor, "child6question3"));
                    jsonObject.put("child6question4", getString(cursor, "child6question4"));
                    jsonObject.put("child6question5", getString(cursor, "child6question5"));
                    jsonObject.put("child6question6", getString(cursor, "child6question6"));
                    jsonObject.put("child6question7", getString(cursor, "child6question7"));
                    jsonObject.put("child6question8", getString(cursor, "child6question8"));
                    jsonObject.put("child6question9", getString(cursor, "child6question9"));
                    jsonObject.put("child6question10", getString(cursor, "child6question10"));
                    jsonObject.put("child6question11", getString(cursor, "child6question11"));
                    jsonObject.put("child6question12", getString(cursor, "child6question12"));
                    jsonObject.put("child6question13", getString(cursor, "child6question13"));
                    jsonObject.put("child6question14", getString(cursor, "child6question14"));
                    jsonObject.put("child6question15", getString(cursor, "child6question15"));
                    jsonObject.put("child6question16", getString(cursor, "child6question16"));
                    jsonObject.put("child6question17", getString(cursor, "child6question17"));
                    jsonObject.put("child6question18", getString(cursor, "child6question18"));
                    jsonObject.put("child6question19", getString(cursor, "child6question19"));
                    jsonObject.put("child7question1", getString(cursor, "child7question1"));
                    jsonObject.put("child7question2", getString(cursor, "child7question2"));
                    jsonObject.put("child7question3", getString(cursor, "child7question3"));
                    jsonObject.put("child7question4", getString(cursor, "child7question4"));
                    jsonObject.put("child7question5", getString(cursor, "child7question5"));
                    jsonObject.put("child7question6", getString(cursor, "child7question6"));
                    jsonObject.put("child7question7", getString(cursor, "child7question7"));
                    jsonObject.put("child7question8", getString(cursor, "child7question8"));
                    jsonObject.put("child7question9", getString(cursor, "child7question9"));
                    jsonObject.put("child7question10", getString(cursor, "child7question10"));
                    jsonObject.put("child7question11", getString(cursor, "child7question11"));
                    jsonObject.put("child7question12", getString(cursor, "child7question12"));
                    jsonObject.put("child7question13", getString(cursor, "child7question13"));
                    jsonObject.put("child7question14", getString(cursor, "child7question14"));
                    jsonObject.put("child7question15", getString(cursor, "child7question15"));
                    jsonObject.put("child7question16", getString(cursor, "child7question16"));
                    jsonObject.put("child7question17", getString(cursor, "child7question17"));
                    jsonObject.put("child7question18", getString(cursor, "child7question18"));
                    jsonObject.put("child7question19", getString(cursor, "child7question19"));
                    jsonObject.put("child8question1", getString(cursor, "child8question1"));
                    jsonObject.put("child8question2", getString(cursor, "child8question2"));
                    jsonObject.put("child8question3", getString(cursor, "child8question3"));
                    jsonObject.put("child8question4", getString(cursor, "child8question4"));
                    jsonObject.put("child8question5", getString(cursor, "child8question5"));
                    jsonObject.put("child8question6", getString(cursor, "child8question6"));
                    jsonObject.put("child8question7", getString(cursor, "child8question7"));
                    jsonObject.put("child8question8", getString(cursor, "child8question8"));
                    jsonObject.put("child8question9", getString(cursor, "child8question9"));
                    jsonObject.put("child8question10", getString(cursor, "child8question10"));
                    jsonObject.put("child8question11", getString(cursor, "child8question11"));
                    jsonObject.put("child8question12", getString(cursor, "child8question12"));
                    jsonObject.put("child8question13", getString(cursor, "child8question13"));
                    jsonObject.put("child8question14", getString(cursor, "child8question14"));
                    jsonObject.put("child8question15", getString(cursor, "child8question15"));
                    jsonObject.put("child8question16", getString(cursor, "child8question16"));
                    jsonObject.put("child8question17", getString(cursor, "child8question17"));
                    jsonObject.put("child8question18", getString(cursor, "child8question18"));
                    jsonObject.put("child8question19", getString(cursor, "child8question19"));
                    jsonObject.put("child9question1", getString(cursor, "child9question1"));
                    jsonObject.put("child9question2", getString(cursor, "child9question2"));
                    jsonObject.put("child9question3", getString(cursor, "child9question3"));
                    jsonObject.put("child9question4", getString(cursor, "child9question4"));
                    jsonObject.put("child9question5", getString(cursor, "child9question5"));
                    jsonObject.put("child9question6", getString(cursor, "child9question6"));
                    jsonObject.put("child9question7", getString(cursor, "child9question7"));
                    jsonObject.put("child9question8", getString(cursor, "child9question8"));
                    jsonObject.put("child9question9", getString(cursor, "child9question9"));
                    jsonObject.put("child9question10", getString(cursor, "child9question10"));
                    jsonObject.put("child9question11", getString(cursor, "child9question11"));
                    jsonObject.put("child9question12", getString(cursor, "child9question12"));
                    jsonObject.put("child9question13", getString(cursor, "child9question13"));
                    jsonObject.put("child9question14", getString(cursor, "child9question14"));
                    jsonObject.put("child9question15", getString(cursor, "child9question15"));
                    jsonObject.put("child9question16", getString(cursor, "child9question16"));
                    jsonObject.put("child9question17", getString(cursor, "child9question17"));
                    jsonObject.put("child9question18", getString(cursor, "child9question18"));
                    jsonObject.put("child9question19", getString(cursor, "child9question19"));
                    jsonObject.put("child10question1", getString(cursor, "child10question1"));
                    jsonObject.put("child10question2", getString(cursor, "child10question2"));
                    jsonObject.put("child10question3", getString(cursor, "child10question3"));
                    jsonObject.put("child10question4", getString(cursor, "child10question4"));
                    jsonObject.put("child10question5", getString(cursor, "child10question5"));
                    jsonObject.put("child10question6", getString(cursor, "child10question6"));
                    jsonObject.put("child10question7", getString(cursor, "child10question7"));
                    jsonObject.put("child10question8", getString(cursor, "child10question8"));
                    jsonObject.put("child10question9", getString(cursor, "child10question9"));
                    jsonObject.put("child10question10", getString(cursor, "child10question10"));
                    jsonObject.put("child10question11", getString(cursor, "child10question11"));
                    jsonObject.put("child10question12", getString(cursor, "child10question12"));
                    jsonObject.put("child10question13", getString(cursor, "child10question13"));
                    jsonObject.put("child10question14", getString(cursor, "child10question14"));
                    jsonObject.put("child10question15", getString(cursor, "child10question15"));
                    jsonObject.put("child10question16", getString(cursor, "child10question16"));
                    jsonObject.put("child10question17", getString(cursor, "child10question17"));
                    jsonObject.put("child10question18", getString(cursor, "child10question18"));
                    jsonObject.put("child10question19", getString(cursor, "child10question19"));
                    jsonObject.put("childquestion5", getString(cursor, "childquestion5"));
                    jsonObject.put("child_location", getString(cursor, "child_location"));
                    jsonObject.put("user_fname", getString(cursor, "user_fname"));
                    jsonObject.put("user_lname", getString(cursor, "user_lname"));
                    jsonObject.put("user_email", getString(cursor, "user_email"));
                    jsonObject.put("on_create", getString(cursor, "on_create"));
                    jsonObject.put("on_update", getString(cursor, "on_update"));

                    RequestBody body = RequestBody.create(
                            jsonObject.toString(),
                            MediaType.parse("application/json")
                    );

                    Request request = new Request.Builder()
                            .url(CHILDSERVER_URL)
                            .post(body)
                            .build();

                    if (!sendRequestWithRetry(client, request)) {
                        Log.e("SyncWorker", "Observation sync failed after retries");
                        return false;
                    }
                } catch (JSONException e) {
                    Log.e("SyncWorker", "Observation data error", e);
                    return false;
                }
            } while (cursor.moveToNext());

            return true;
        } catch (Exception e) {
            Log.e("SyncWorker", "Observation sync failed", e);
            return false;
        } finally {
            if (cursor != null) cursor.close();
            if (db != null) db.close();
        }
    }


    private boolean sendRequestWithRetry(OkHttpClient client, Request request) {
        int attempts = 0;
        while (attempts < MAX_RETRIES) {
            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    Log.i("SyncWorker", "Sync successful");
                    return true;
                }
                Log.w("SyncWorker", "Server error: " + response.code());
            } catch (IOException e) {
                Log.w("SyncWorker", "Network error: " + e.getMessage());
            }

            try {
                Thread.sleep(2000L * (attempts + 1));
            } catch (InterruptedException ignored) {}

            attempts++;
        }
        return false;
    }

    private String getString(Cursor cursor, String column) {
        try {
            return cursor.getString(cursor.getColumnIndexOrThrow(column));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
