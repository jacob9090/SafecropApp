package com.jacob.fruitoftek.safecrop.comdev;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.jacob.fruitoftek.safecrop.comdev.ch.ChildModel;
import com.jacob.fruitoftek.safecrop.comdev.ch.ChildSurveyDBHelper;
import com.jacob.fruitoftek.safecrop.comdev.com.ComDbHelper;
import com.jacob.fruitoftek.safecrop.comdev.com.ComModel;
import com.jacob.fruitoftek.safecrop.comdev.hh.HhDbHelper;
import com.jacob.fruitoftek.safecrop.comdev.hh.HhModel;
import com.jacob.fruitoftek.safecrop.comdev.obs.ObsDbHelper;
import com.jacob.fruitoftek.safecrop.comdev.obs.ObsModel;
import com.jacob.fruitoftek.safecrop.comdev.sch.SchoolDbHelper;
import com.jacob.fruitoftek.safecrop.comdev.sch.SchoolModel;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import android.util.Log;

public class ExportCsvWorker extends Worker {

    private final ComDbHelper comDbHelper;
    private final SchoolDbHelper schoolDbHelper;
    private final HhDbHelper hhDbHelper;
    private final ObsDbHelper obsDbHelper;
    private final ChildSurveyDBHelper chdbHelper;

    public ExportCsvWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
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
        boolean communitySuccess = exportCommunityData();
        boolean schoolSuccess = exportSchoolData();
        boolean hhSuccess = exportHh();
        boolean obsSuccess = exportObs();
        boolean chSuccess = exportCh();

        return (communitySuccess && schoolSuccess && hhSuccess && obsSuccess && chSuccess) ?
                Result.success() : Result.failure();
    }

    private boolean exportCommunityData() {
        try {
            List<ComModel> comList = comDbHelper.getAllCommunities();
            File csvBackupDir = getApplicationContext().getExternalFilesDir("CSVBackup");
            File csvFile = new File(csvBackupDir, "CommunitySurveyBackup_" + System.currentTimeMillis() + ".csv");

            try (FileWriter writer = new FileWriter(csvFile)) {
                writer.append("Commquestion1,Commquestion2,Commquestion3,Commquestion4,Commquestion5,Commquestion6," +
                        "Commquestion7,Commquestion8,Commquestion9,Commquestion10,Commquestion11,Commquestion12," +
                        "Commquestion13,Commquestion14,Commquestion15,Commquestion16,Commquestion17,Commquestion18," +
                        "Commquestion19,Commquestion20,Commquestion21,Commquestion22,Commquestion23,Commquestion24," +
                        "Commquestion25,Commquestion26,Commquestion27,Commquestion28,Commquestion29,Commquestion30," +
                        "Commquestion31,Commquestion32,Commquestion33,Commquestion34,Commquestion35,Commquestion36," +
                        "Commquestion37,Commquestion38,Commquestion39,Commquestion40,Commquestion41,Commquestion42," +
                        "Commquestion43,Commquestion44,Commquestion45,Commquestion46,Commquestion47,Commquestion48," +
                        "Commquestion49,Commquestion50,Commquestion51,Commquestion52,Commquestion53,Commquestion54," +
                        "Commquestion56,Commquestion57,Commquestion58,Commquestion59,Commquestion60,Commquestion61," +
                        "Commquestion62,Commquestion63,Commquestion64,Commquestion65,Commquestion66,Commquestion67," +
                        "Location,Photo,First Name,Last Name,Email,Created,Updated,Signature\n");

                for (ComModel com : comList) {
                    String photoUri = com.getFarmer_photo() != null ?
                            com.getFarmer_photo().toString() : "";
                    writer.append(escapeCSV(com.getCommquestion1())).append(',')
                            .append(escapeCSV(com.getCommquestion2())).append(',')
                            .append(escapeCSV(com.getCommquestion3())).append(',')
                            .append(escapeCSV(com.getCommquestion4())).append(',')
                            .append(escapeCSV(com.getCommquestion5())).append(',')
                            .append(escapeCSV(com.getCommquestion6())).append(',')
                            .append(escapeCSV(com.getCommquestion7())).append(',')
                            .append(escapeCSV(com.getCommquestion8())).append(',')
                            .append(escapeCSV(com.getCommquestion9())).append(',')
                            .append(escapeCSV(com.getCommquestion10())).append(',')
                            .append(escapeCSV(com.getCommquestion11())).append(',')
                            .append(escapeCSV(com.getCommquestion12())).append(',')
                            .append(escapeCSV(com.getCommquestion13())).append(',')
                            .append(escapeCSV(com.getCommquestion14())).append(',')
                            .append(escapeCSV(com.getCommquestion15())).append(',')
                            .append(escapeCSV(com.getCommquestion16())).append(',')
                            .append(escapeCSV(com.getCommquestion17())).append(',')
                            .append(escapeCSV(com.getCommquestion18())).append(',')
                            .append(escapeCSV(com.getCommquestion19())).append(',')
                            .append(escapeCSV(com.getCommquestion20())).append(',')
                            .append(escapeCSV(com.getCommquestion21())).append(',')
                            .append(escapeCSV(com.getCommquestion22())).append(',')
                            .append(escapeCSV(com.getCommquestion23())).append(',')
                            .append(escapeCSV(com.getCommquestion24())).append(',')
                            .append(escapeCSV(com.getCommquestion25())).append(',')
                            .append(escapeCSV(com.getCommquestion26())).append(',')
                            .append(escapeCSV(com.getCommquestion27())).append(',')
                            .append(escapeCSV(com.getCommquestion28())).append(',')
                            .append(escapeCSV(com.getCommquestion29())).append(',')
                            .append(escapeCSV(com.getCommquestion30())).append(',')
                            .append(escapeCSV(com.getCommquestion31())).append(',')
                            .append(escapeCSV(com.getCommquestion32())).append(',')
                            .append(escapeCSV(com.getCommquestion33())).append(',')
                            .append(escapeCSV(com.getCommquestion34())).append(',')
                            .append(escapeCSV(com.getCommquestion35())).append(',')
                            .append(escapeCSV(com.getCommquestion36())).append(',')
                            .append(escapeCSV(com.getCommquestion37())).append(',')
                            .append(escapeCSV(com.getCommquestion38())).append(',')
                            .append(escapeCSV(com.getCommquestion39())).append(',')
                            .append(escapeCSV(com.getCommquestion40())).append(',')
                            .append(escapeCSV(com.getCommquestion41())).append(',')
                            .append(escapeCSV(com.getCommquestion42())).append(',')
                            .append(escapeCSV(com.getCommquestion43())).append(',')
                            .append(escapeCSV(com.getCommquestion44())).append(',')
                            .append(escapeCSV(com.getCommquestion45())).append(',')
                            .append(escapeCSV(com.getCommquestion46())).append(',')
                            .append(escapeCSV(com.getCommquestion47())).append(',')
                            .append(escapeCSV(com.getCommquestion48())).append(',')
                            .append(escapeCSV(com.getCommquestion49())).append(',')
                            .append(escapeCSV(com.getCommquestion50())).append(',')
                            .append(escapeCSV(com.getCommquestion51())).append(',')
                            .append(escapeCSV(com.getCommquestion52())).append(',')
                            .append(escapeCSV(com.getCommquestion53())).append(',')
                            .append(escapeCSV(com.getCommquestion54())).append(',')
                            .append(escapeCSV(com.getCommquestion56())).append(',')
                            .append(escapeCSV(com.getCommquestion57())).append(',')
                            .append(escapeCSV(com.getCommquestion58())).append(',')
                            .append(escapeCSV(com.getCommquestion59())).append(',')
                            .append(escapeCSV(com.getCommquestion60())).append(',')
                            .append(escapeCSV(com.getCommquestion61())).append(',')
                            .append(escapeCSV(com.getCommquestion62())).append(',')
                            .append(escapeCSV(com.getCommquestion63())).append(',')
                            .append(escapeCSV(com.getCommquestion64())).append(',')
                            .append(escapeCSV(com.getCommquestion65())).append(',')
                            .append(escapeCSV(com.getCommquestion66())).append(',')
                            .append(escapeCSV(com.getCommquestion67())).append(',')
                            .append(escapeCSV(com.getCom_location())).append(',')
                            .append(escapeCSV(photoUri)).append(',')
                            .append(escapeCSV(com.getUserFname())).append(',')
                            .append(escapeCSV(com.getUserLname())).append(',')
                            .append(escapeCSV(com.getUserEmail())).append(',')
                            .append(escapeCSV(com.getOnCreate())).append(',')
                            .append(escapeCSV(com.getOnUpdate())).append(',')
                            .append(escapeCSV(com.getSignature())).append('\n');
                }
            }
            return true;
        } catch (Exception e) {
            Log.e("ExportWorker", "Community export failed", e);
            return false;
        }
    }

    private boolean exportSchoolData() {
        try {
            List<SchoolModel> schoolList = schoolDbHelper.getAllSchools();
            File csvBackupDir = getApplicationContext().getExternalFilesDir("CSVBackup");
            File csvFile = new File(csvBackupDir, "SchoolSurveyBackup_" + System.currentTimeMillis() + ".csv");

            try (FileWriter writer = new FileWriter(csvFile)) {
                // School CSV Header
                writer.append("Sch_name,Sch_district,Sch_community,Schquestion4,Schquestion5,Schquestion6," +
                        "Schquestion7,Schquestion8,Schquestion9,Schquestion10,Schquestion11,Schquestion12," +
                        "Schquestion13,Schquestion14,Schquestion15,Schquestion16,Schquestion17,Schquestion18," +
                        "Schquestion19,Schquestion20,Schquestion21,Schquestion22,Schquestion23,Schquestion24," +
                        "Schquestion25,Schquestion26,Schquestion27,Schquestion28,Schquestion29,Schquestion30," +
                        "Schquestion31,Schquestion32,Schquestion33,Schquestion34,Location,Photo," +
                        "First Name,Last Name,Email,Created,Updated,Signature\n");

                for (SchoolModel school : schoolList) {
                    writer.append(escapeCSV(school.getSch_name())).append(',')
                            .append(escapeCSV(school.getSch_district())).append(',')
                            .append(escapeCSV(school.getSch_community())).append(',')
                            .append(escapeCSV(school.getSchquestion4())).append(',')
                            .append(escapeCSV(school.getSchquestion5())).append(',')
                            .append(escapeCSV(school.getSchquestion6())).append(',')
                            .append(escapeCSV(school.getSchquestion7())).append(',')
                            .append(escapeCSV(school.getSchquestion8())).append(',')
                            .append(escapeCSV(school.getSchquestion9())).append(',')
                            .append(escapeCSV(school.getSchquestion10())).append(',')
                            .append(escapeCSV(school.getSchquestion11())).append(',')
                            .append(escapeCSV(school.getSchquestion12())).append(',')
                            .append(escapeCSV(school.getSchquestion13())).append(',')
                            .append(escapeCSV(school.getSchquestion14())).append(',')
                            .append(escapeCSV(school.getSchquestion15())).append(',')
                            .append(escapeCSV(school.getSchquestion16())).append(',')
                            .append(escapeCSV(school.getSchquestion17())).append(',')
                            .append(escapeCSV(school.getSchquestion18())).append(',')
                            .append(escapeCSV(school.getSchquestion19())).append(',')
                            .append(escapeCSV(school.getSchquestion20())).append(',')
                            .append(escapeCSV(school.getSchquestion21())).append(',')
                            .append(escapeCSV(school.getSchquestion22())).append(',')
                            .append(escapeCSV(school.getSchquestion23())).append(',')
                            .append(escapeCSV(school.getSchquestion24())).append(',')
                            .append(escapeCSV(school.getSchquestion25())).append(',')
                            .append(escapeCSV(school.getSchquestion26())).append(',')
                            .append(escapeCSV(school.getSchquestion27())).append(',')
                            .append(escapeCSV(school.getSchquestion28())).append(',')
                            .append(escapeCSV(school.getSchquestion29())).append(',')
                            .append(escapeCSV(school.getSchquestion30())).append(',')
                            .append(escapeCSV(school.getSchquestion31())).append(',')
                            .append(escapeCSV(school.getSchquestion32())).append(',')
                            .append(escapeCSV(school.getSchquestion33())).append(',')
                            .append(escapeCSV(school.getSchquestion34())).append(',')
                            .append(escapeCSV(school.getSch_location())).append(',')
                            .append(escapeCSV(school.getFarmer_photo() != null ?
                                    school.getFarmer_photo().toString() : "")).append(',')
                            .append(escapeCSV(school.getUserFname())).append(',')
                            .append(escapeCSV(school.getUserLname())).append(',')
                            .append(escapeCSV(school.getUserEmail())).append(',')
                            .append(escapeCSV(school.getOnCreate())).append(',')
                            .append(escapeCSV(school.getOnUpdate())).append(',')
                            .append(escapeCSV(school.getSignature())).append('\n');

                }
            }
            return true;
        } catch (Exception e) {
            Log.e("ExportWorker", "School export failed", e);
            return false;
        }
    }


    private boolean exportHh() {
        try {
            List<HhModel> hhList = hhDbHelper.getAllHh();
            File csvBackupDir = getApplicationContext().getExternalFilesDir("CSVBackup");
            File csvFile = new File(csvBackupDir, "HouseholdSurveyBackup_" + System.currentTimeMillis() + ".csv");

            try (FileWriter writer = new FileWriter(csvFile)) {
                // School CSV Header
                writer.append("Hh_name,Hh_district,Hh_community,Hhquestion4,Hhquestion5,Hhquestion6," +
                        "Hhquestion7,Hhquestion8,Hhquestion9,Hhquestion10,Hhquestion11,Hhquestion12," +
                        "Hhquestion13,Hhquestion14,Hhquestion15,Hhquestion16,Hhquestion17,Hhquestion18," +
                        "Hhquestion19,Hhquestion20,Hhquestion21,Hhquestion22,Hhquestion23,Hhquestion24," +
                        "Hhquestion25,Hhquestion26,Hhquestion27,Hhquestion28,Hhquestion29,Hhquestion30," +
                        "Hhquestion31,Hhquestion32,Hhquestion36,Hhquestion37,Location,Photo," +
                        "First Name,Last Name,Email,Created,Updated,Signature\n");

                for (HhModel hh : hhList) {
                    writer.append(escapeCSV(hh.getHh_name())).append(',')
                            .append(escapeCSV(hh.getHh_district())).append(',')
                            .append(escapeCSV(hh.getHh_community())).append(',')
                            .append(escapeCSV(hh.getHhquestion4())).append(',')
                            .append(escapeCSV(hh.getHhquestion5())).append(',')
                            .append(escapeCSV(hh.getHhquestion6())).append(',')
                            .append(escapeCSV(hh.getHhquestion7())).append(',')
                            .append(escapeCSV(hh.getHhquestion8())).append(',')
                            .append(escapeCSV(hh.getHhquestion9())).append(',')
                            .append(escapeCSV(hh.getHhquestion10())).append(',')
                            .append(escapeCSV(hh.getHhquestion11())).append(',')
                            .append(escapeCSV(hh.getHhquestion12())).append(',')
                            .append(escapeCSV(hh.getHhquestion13())).append(',')
                            .append(escapeCSV(hh.getHhquestion14())).append(',')
                            .append(escapeCSV(hh.getHhquestion15())).append(',')
                            .append(escapeCSV(hh.getHhquestion16())).append(',')
                            .append(escapeCSV(hh.getHhquestion17())).append(',')
                            .append(escapeCSV(hh.getHhquestion18())).append(',')
                            .append(escapeCSV(hh.getHhquestion19())).append(',')
                            .append(escapeCSV(hh.getHhquestion20())).append(',')
                            .append(escapeCSV(hh.getHhquestion21())).append(',')
                            .append(escapeCSV(hh.getHhquestion22())).append(',')
                            .append(escapeCSV(hh.getHhquestion23())).append(',')
                            .append(escapeCSV(hh.getHhquestion24())).append(',')
                            .append(escapeCSV(hh.getHhquestion25())).append(',')
                            .append(escapeCSV(hh.getHhquestion26())).append(',')
                            .append(escapeCSV(hh.getHhquestion27())).append(',')
                            .append(escapeCSV(hh.getHhquestion28())).append(',')
                            .append(escapeCSV(hh.getHhquestion29())).append(',')
                            .append(escapeCSV(hh.getHhquestion30())).append(',')
                            .append(escapeCSV(hh.getHhquestion31())).append(',')
                            .append(escapeCSV(hh.getHhquestion32())).append(',')
                            .append(escapeCSV(hh.getHhquestion36())).append(',')
                            .append(escapeCSV(hh.getHhquestion37())).append(',')
                            .append(escapeCSV(hh.getHh_location())).append(',')
                            .append(escapeCSV(hh.getUserFname())).append(',')
                            .append(escapeCSV(hh.getUserLname())).append(',')
                            .append(escapeCSV(hh.getUserEmail())).append(',')
                            .append(escapeCSV(hh.getOnCreate())).append(',')
                            .append(escapeCSV(hh.getOnUpdate())).append(',')
                            .append(escapeCSV(hh.getFarmer_photo() != null ? hh.getFarmer_photo().toString() : "")).append(',')
                            .append(escapeCSV(hh.getSignature())).append('\n');

                }
            }
            return true;
        } catch (Exception e) {
            Log.e("ExportWorker", "Household export failed", e);
            return false;
        }
    }



    private boolean exportObs() {
        try {
            List<ObsModel> obsList = obsDbHelper.getAllObservation();
            File csvBackupDir = getApplicationContext().getExternalFilesDir("CSVBackup");
            File csvFile = new File(csvBackupDir, "ObservationSurveyBackup_" + System.currentTimeMillis() + ".csv");

            try (FileWriter writer = new FileWriter(csvFile)) {
                // School CSV Header
                writer.append("Obs_name,Obs_district,Obs_community,Obsquestion6,Obsquestion7,Obsquestion8," +
                        "Obsquestion9,Obsquestion10,Obsquestion11,Obsquestion12,Obsquestion13," +
                        "Obsquestion14,Obsquestion15,Obsquestion16,Obsquestion17,Obsquestion18," +
                        "Obsquestion19,Obsquestion20,Obsquestion21,Location,Photo," +
                        "First Name,Last Name,Email,Created,Updated,Signature\n");

                for (ObsModel obs : obsList) {
                    writer.append(escapeCSV(obs.getObs_name())).append(',')
                            .append(escapeCSV(obs.getObs_district())).append(',')
                            .append(escapeCSV(obs.getObs_community())).append(',')
                            .append(escapeCSV(obs.getObsquestion6())).append(',')
                            .append(escapeCSV(obs.getObsquestion7())).append(',')
                            .append(escapeCSV(obs.getObsquestion8())).append(',')
                            .append(escapeCSV(obs.getObsquestion9())).append(',')
                            .append(escapeCSV(obs.getObsquestion10())).append(',')
                            .append(escapeCSV(obs.getObsquestion11())).append(',')
                            .append(escapeCSV(obs.getObsquestion12())).append(',')
                            .append(escapeCSV(obs.getObsquestion13())).append(',')
                            .append(escapeCSV(obs.getObsquestion14())).append(',')
                            .append(escapeCSV(obs.getObsquestion15())).append(',')
                            .append(escapeCSV(obs.getObsquestion16())).append(',')
                            .append(escapeCSV(obs.getObsquestion17())).append(',')
                            .append(escapeCSV(obs.getObsquestion18())).append(',')
                            .append(escapeCSV(obs.getObsquestion19())).append(',')
                            .append(escapeCSV(obs.getObsquestion20())).append(',')
                            .append(escapeCSV(obs.getObsquestion21())).append(',')
                            .append(escapeCSV(obs.getObs_location())).append(',')
                            .append(escapeCSV(obs.getUserFname())).append(',')
                            .append(escapeCSV(obs.getUserLname())).append(',')
                            .append(escapeCSV(obs.getUserEmail())).append(',')
                            .append(escapeCSV(obs.getOnCreate())).append(',')
                            .append(escapeCSV(obs.getOnUpdate())).append(',')
                            .append(escapeCSV(obs.getFarmer_photo() != null ? obs.getFarmer_photo().toString() : "")).append(',')
                            .append(escapeCSV(obs.getSignature())).append('\n');

                }
            }
            return true;
        } catch (Exception e) {
            Log.e("ExportWorker", "Observation export failed", e);
            return false;
        }
    }


    private boolean exportCh() {
        try {
            List<ChildModel> childList = chdbHelper.getAllSurveys();
            File csvBackupDir = getApplicationContext().getExternalFilesDir("CSVBackup");
            File csvFile = new File(csvBackupDir, "ChildSurveyBackup_" + System.currentTimeMillis() + ".csv");

            try (FileWriter writer = new FileWriter(csvFile)) {
                // School CSV Header
                writer.append("FarmerId,District,Community,Childquestion4," +
                        "Child1question1,Child1question2,Child1question3,Child1question4,Child1question5,Child1question6,Child1question7,Child1question8,Child1question9,Child1question10," +
                        "Child1question11,Child1question12,Child1question13,Child1question14,Child1question15,Child1question16,Child1question17,Child1question18,Child1question19," +
                        "Child2question1,Child2question2,Child2question3,Child2question4,Child2question5,Child2question6,Child2question7,Child2question8,Child2question9,Child2question10," +
                        "Child2question11,Child2question12,Child2question13,Child2question14,Child2question15,Child2question16,Child2question17,Child2question18,Child2question19," +
                        "Child3question1,Child3question2,Child3question3,Child3question4,Child3question5,Child3question6,Child3question7,Child3question8,Child3question9,Child3question10," +
                        "Child3question11,Child3question12,Child3question13,Child3question14,Child3question15,Child3question16,Child3question17,Child3question18,Child3question19," +
                        "Child4question1,Child4question2,Child4question3,Child4question4,Child4question5,Child4question6,Child4question7,Child4question8,Child4question9,Child4question10," +
                        "Child4question11,Child4question12,Child4question13,Child4question14,Child4question15,Child4question16,Child4question17,Child4question18,Child4question19," +
                        "Child5question1,Child5question2,Child5question3,Child5question4,Child5question5,Child5question6,Child5question7,Child5question8,Child5question9,Child5question10," +
                        "Child5question11,Child5question12,Child5question13,Child5question14,Child5question15,Child5question16,Child5question17,Child5question18,Child5question19," +
                        "Child6question1,Child6question2,Child6question3,Child6question4,Child6question5,Child6question6,Child6question7,Child6question8,Child6question9,Child6question10," +
                        "Child6question11,Child6question12,Child6question13,Child6question14,Child6question15,Child6question16,Child6question17,Child6question18,Child6question19," +
                        "Child7question1,Child7question2,Child7question3,Child7question4,Child7question5,Child7question6,Child7question7,Child7question8,Child7question9,Child7question10," +
                        "Child7question11,Child7question12,Child7question13,Child7question14,Child7question15,Child7question16,Child7question17,Child7question18,Child7question19," +
                        "Child8question1,Child8question2,Child8question3,Child8question4,Child8question5,Child8question6,Child8question7,Child8question8,Child8question9,Child8question10," +
                        "Child8question11,Child8question12,Child8question13,Child8question14,Child8question15,Child8question16,Child8question17,Child8question18,Child8question19," +
                        "Child9question1,Child9question2,Child9question3,Child9question4,Child9question5,Child9question6,Child9question7,Child9question8,Child9question9,Child9question10," +
                        "Child9question11,Child9question12,Child9question13,Child9question14,Child9question15,Child9question16,Child9question17,Child9question18,Child9question19," +
                        "Child10question1,Child10question2,Child10question3,Child10question4,Child10question5,Child10question6,Child10question7,Child10question8,Child10question9,Child10question10," +
                        "Child10question11,Child10question12,Child10question13,Child10question14,Child10question15,Child10question16,Child10question17,Child10question18,Child10question19," +
                        "Childquestion5,Location,First Name,Last Name,Email,Created,Updated,Signature\n");

                for (ChildModel child : childList) {
                    writer.append(escapeCSV(child.getFarmer_id())).append(',')
                            .append(escapeCSV(child.getDistrict())).append(',')
                            .append(escapeCSV(child.getCommunity())).append(',')
                            .append(escapeCSV(child.getChildquestion4())).append(',')
                            .append(escapeCSV(child.getChild1question1())).append(',')
                            .append(escapeCSV(child.getChild1question2())).append(',')
                            .append(escapeCSV(child.getChild1question3())).append(',')
                            .append(escapeCSV(child.getChild1question4())).append(',')
                            .append(escapeCSV(child.getChild1question5())).append(',')
                            .append(escapeCSV(child.getChild1question6())).append(',')
                            .append(escapeCSV(child.getChild1question7())).append(',')
                            .append(escapeCSV(child.getChild1question8())).append(',')
                            .append(escapeCSV(child.getChild1question9())).append(',')
                            .append(escapeCSV(child.getChild1question10())).append(',')
                            .append(escapeCSV(child.getChild1question11())).append(',')
                            .append(escapeCSV(child.getChild1question12())).append(',')
                            .append(escapeCSV(child.getChild1question13())).append(',')
                            .append(escapeCSV(child.getChild1question14())).append(',')
                            .append(escapeCSV(child.getChild1question15())).append(',')
                            .append(escapeCSV(child.getChild1question16())).append(',')
                            .append(escapeCSV(child.getChild1question17())).append(',')
                            .append(escapeCSV(child.getChild1question18())).append(',')
                            .append(escapeCSV(child.getChild1question19())).append(',')

                            .append(escapeCSV(child.getChild2question1())).append(',')
                            .append(escapeCSV(child.getChild2question2())).append(',')
                            .append(escapeCSV(child.getChild2question3())).append(',')
                            .append(escapeCSV(child.getChild2question4())).append(',')
                            .append(escapeCSV(child.getChild2question5())).append(',')
                            .append(escapeCSV(child.getChild2question6())).append(',')
                            .append(escapeCSV(child.getChild2question7())).append(',')
                            .append(escapeCSV(child.getChild2question8())).append(',')
                            .append(escapeCSV(child.getChild2question9())).append(',')
                            .append(escapeCSV(child.getChild2question10())).append(',')
                            .append(escapeCSV(child.getChild2question11())).append(',')
                            .append(escapeCSV(child.getChild2question12())).append(',')
                            .append(escapeCSV(child.getChild2question13())).append(',')
                            .append(escapeCSV(child.getChild2question14())).append(',')
                            .append(escapeCSV(child.getChild2question15())).append(',')
                            .append(escapeCSV(child.getChild2question16())).append(',')
                            .append(escapeCSV(child.getChild2question17())).append(',')
                            .append(escapeCSV(child.getChild2question18())).append(',')
                            .append(escapeCSV(child.getChild2question19())).append(',')

                            .append(escapeCSV(child.getChild3question1())).append(',')
                            .append(escapeCSV(child.getChild3question2())).append(',')
                            .append(escapeCSV(child.getChild3question3())).append(',')
                            .append(escapeCSV(child.getChild3question4())).append(',')
                            .append(escapeCSV(child.getChild3question5())).append(',')
                            .append(escapeCSV(child.getChild3question6())).append(',')
                            .append(escapeCSV(child.getChild3question7())).append(',')
                            .append(escapeCSV(child.getChild3question8())).append(',')
                            .append(escapeCSV(child.getChild3question9())).append(',')
                            .append(escapeCSV(child.getChild3question10())).append(',')
                            .append(escapeCSV(child.getChild3question11())).append(',')
                            .append(escapeCSV(child.getChild3question12())).append(',')
                            .append(escapeCSV(child.getChild3question13())).append(',')
                            .append(escapeCSV(child.getChild3question14())).append(',')
                            .append(escapeCSV(child.getChild3question15())).append(',')
                            .append(escapeCSV(child.getChild3question16())).append(',')
                            .append(escapeCSV(child.getChild3question17())).append(',')
                            .append(escapeCSV(child.getChild3question18())).append(',')
                            .append(escapeCSV(child.getChild3question19())).append(',')

                            .append(escapeCSV(child.getChild4question1())).append(',')
                            .append(escapeCSV(child.getChild4question2())).append(',')
                            .append(escapeCSV(child.getChild4question3())).append(',')
                            .append(escapeCSV(child.getChild4question4())).append(',')
                            .append(escapeCSV(child.getChild4question5())).append(',')
                            .append(escapeCSV(child.getChild4question6())).append(',')
                            .append(escapeCSV(child.getChild4question7())).append(',')
                            .append(escapeCSV(child.getChild4question8())).append(',')
                            .append(escapeCSV(child.getChild4question9())).append(',')
                            .append(escapeCSV(child.getChild4question10())).append(',')
                            .append(escapeCSV(child.getChild4question11())).append(',')
                            .append(escapeCSV(child.getChild4question12())).append(',')
                            .append(escapeCSV(child.getChild4question13())).append(',')
                            .append(escapeCSV(child.getChild4question14())).append(',')
                            .append(escapeCSV(child.getChild4question15())).append(',')
                            .append(escapeCSV(child.getChild4question16())).append(',')
                            .append(escapeCSV(child.getChild4question17())).append(',')
                            .append(escapeCSV(child.getChild4question18())).append(',')
                            .append(escapeCSV(child.getChild4question19())).append(',')

                            .append(escapeCSV(child.getChild5question1())).append(',')
                            .append(escapeCSV(child.getChild5question2())).append(',')
                            .append(escapeCSV(child.getChild5question3())).append(',')
                            .append(escapeCSV(child.getChild5question4())).append(',')
                            .append(escapeCSV(child.getChild5question5())).append(',')
                            .append(escapeCSV(child.getChild5question6())).append(',')
                            .append(escapeCSV(child.getChild5question7())).append(',')
                            .append(escapeCSV(child.getChild5question8())).append(',')
                            .append(escapeCSV(child.getChild5question9())).append(',')
                            .append(escapeCSV(child.getChild5question10())).append(',')
                            .append(escapeCSV(child.getChild5question11())).append(',')
                            .append(escapeCSV(child.getChild5question12())).append(',')
                            .append(escapeCSV(child.getChild5question13())).append(',')
                            .append(escapeCSV(child.getChild5question14())).append(',')
                            .append(escapeCSV(child.getChild5question15())).append(',')
                            .append(escapeCSV(child.getChild5question16())).append(',')
                            .append(escapeCSV(child.getChild5question17())).append(',')
                            .append(escapeCSV(child.getChild5question18())).append(',')
                            .append(escapeCSV(child.getChild5question19())).append(',')

                            .append(escapeCSV(child.getChild6question1())).append(',')
                            .append(escapeCSV(child.getChild6question2())).append(',')
                            .append(escapeCSV(child.getChild6question3())).append(',')
                            .append(escapeCSV(child.getChild6question4())).append(',')
                            .append(escapeCSV(child.getChild6question5())).append(',')
                            .append(escapeCSV(child.getChild6question6())).append(',')
                            .append(escapeCSV(child.getChild6question7())).append(',')
                            .append(escapeCSV(child.getChild6question8())).append(',')
                            .append(escapeCSV(child.getChild6question9())).append(',')
                            .append(escapeCSV(child.getChild6question10())).append(',')
                            .append(escapeCSV(child.getChild6question11())).append(',')
                            .append(escapeCSV(child.getChild6question12())).append(',')
                            .append(escapeCSV(child.getChild6question13())).append(',')
                            .append(escapeCSV(child.getChild6question14())).append(',')
                            .append(escapeCSV(child.getChild6question15())).append(',')
                            .append(escapeCSV(child.getChild6question16())).append(',')
                            .append(escapeCSV(child.getChild6question17())).append(',')
                            .append(escapeCSV(child.getChild6question18())).append(',')
                            .append(escapeCSV(child.getChild6question19())).append(',')

                            .append(escapeCSV(child.getChild7question1())).append(',')
                            .append(escapeCSV(child.getChild7question2())).append(',')
                            .append(escapeCSV(child.getChild7question3())).append(',')
                            .append(escapeCSV(child.getChild7question4())).append(',')
                            .append(escapeCSV(child.getChild7question5())).append(',')
                            .append(escapeCSV(child.getChild7question6())).append(',')
                            .append(escapeCSV(child.getChild7question7())).append(',')
                            .append(escapeCSV(child.getChild7question8())).append(',')
                            .append(escapeCSV(child.getChild7question9())).append(',')
                            .append(escapeCSV(child.getChild7question10())).append(',')
                            .append(escapeCSV(child.getChild7question11())).append(',')
                            .append(escapeCSV(child.getChild7question12())).append(',')
                            .append(escapeCSV(child.getChild7question13())).append(',')
                            .append(escapeCSV(child.getChild7question14())).append(',')
                            .append(escapeCSV(child.getChild7question15())).append(',')
                            .append(escapeCSV(child.getChild7question16())).append(',')
                            .append(escapeCSV(child.getChild7question17())).append(',')
                            .append(escapeCSV(child.getChild7question18())).append(',')
                            .append(escapeCSV(child.getChild7question19())).append(',')

                            .append(escapeCSV(child.getChild8question1())).append(',')
                            .append(escapeCSV(child.getChild8question2())).append(',')
                            .append(escapeCSV(child.getChild8question3())).append(',')
                            .append(escapeCSV(child.getChild8question4())).append(',')
                            .append(escapeCSV(child.getChild8question5())).append(',')
                            .append(escapeCSV(child.getChild8question6())).append(',')
                            .append(escapeCSV(child.getChild8question7())).append(',')
                            .append(escapeCSV(child.getChild8question8())).append(',')
                            .append(escapeCSV(child.getChild8question9())).append(',')
                            .append(escapeCSV(child.getChild8question10())).append(',')
                            .append(escapeCSV(child.getChild8question11())).append(',')
                            .append(escapeCSV(child.getChild8question12())).append(',')
                            .append(escapeCSV(child.getChild8question13())).append(',')
                            .append(escapeCSV(child.getChild8question14())).append(',')
                            .append(escapeCSV(child.getChild8question15())).append(',')
                            .append(escapeCSV(child.getChild8question16())).append(',')
                            .append(escapeCSV(child.getChild8question17())).append(',')
                            .append(escapeCSV(child.getChild8question18())).append(',')
                            .append(escapeCSV(child.getChild8question19())).append(',')

                            .append(escapeCSV(child.getChild9question1())).append(',')
                            .append(escapeCSV(child.getChild9question2())).append(',')
                            .append(escapeCSV(child.getChild9question3())).append(',')
                            .append(escapeCSV(child.getChild9question4())).append(',')
                            .append(escapeCSV(child.getChild9question5())).append(',')
                            .append(escapeCSV(child.getChild9question6())).append(',')
                            .append(escapeCSV(child.getChild9question7())).append(',')
                            .append(escapeCSV(child.getChild9question8())).append(',')
                            .append(escapeCSV(child.getChild9question9())).append(',')
                            .append(escapeCSV(child.getChild9question10())).append(',')
                            .append(escapeCSV(child.getChild9question11())).append(',')
                            .append(escapeCSV(child.getChild9question12())).append(',')
                            .append(escapeCSV(child.getChild9question13())).append(',')
                            .append(escapeCSV(child.getChild9question14())).append(',')
                            .append(escapeCSV(child.getChild9question15())).append(',')
                            .append(escapeCSV(child.getChild9question16())).append(',')
                            .append(escapeCSV(child.getChild9question17())).append(',')
                            .append(escapeCSV(child.getChild9question18())).append(',')
                            .append(escapeCSV(child.getChild9question19())).append(',')

                            .append(escapeCSV(child.getChild10question1())).append(',')
                            .append(escapeCSV(child.getChild10question2())).append(',')
                            .append(escapeCSV(child.getChild10question3())).append(',')
                            .append(escapeCSV(child.getChild10question4())).append(',')
                            .append(escapeCSV(child.getChild10question5())).append(',')
                            .append(escapeCSV(child.getChild10question6())).append(',')
                            .append(escapeCSV(child.getChild10question7())).append(',')
                            .append(escapeCSV(child.getChild10question8())).append(',')
                            .append(escapeCSV(child.getChild10question9())).append(',')
                            .append(escapeCSV(child.getChild10question10())).append(',')
                            .append(escapeCSV(child.getChild10question11())).append(',')
                            .append(escapeCSV(child.getChild10question12())).append(',')
                            .append(escapeCSV(child.getChild10question13())).append(',')
                            .append(escapeCSV(child.getChild10question14())).append(',')
                            .append(escapeCSV(child.getChild10question15())).append(',')
                            .append(escapeCSV(child.getChild10question16())).append(',')
                            .append(escapeCSV(child.getChild10question17())).append(',')
                            .append(escapeCSV(child.getChild10question18())).append(',')
                            .append(escapeCSV(child.getChild10question19())).append(',')

                            .append(escapeCSV(child.getChildquestion5())).append(',')
                            .append(escapeCSV(child.getChildLocation())).append(',')
                            .append(escapeCSV(child.getUserFname())).append(',')
                            .append(escapeCSV(child.getUserLname())).append(',')
                            .append(escapeCSV(child.getUserEmail())).append(',')
                            .append(escapeCSV(child.getOnCreate())).append(',')
                            .append(escapeCSV(child.getOnUpdate())).append(',')
                            .append(escapeCSV(child.getSignature())).append('\n');

                }
            }
            return true;
        } catch (Exception e) {
            Log.e("ExportWorker", "Child export failed", e);
            return false;
        }
    }


    private String escapeCSV(String value) {
        if (value == null) return "";
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }
}
