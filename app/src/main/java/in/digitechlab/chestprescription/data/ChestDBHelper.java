package in.digitechlab.chestprescription.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import in.digitechlab.chestprescription.R;

/**
 * Created by DELL on 12/3/2017.
 */

public class ChestDBHelper extends SQLiteOpenHelper {
    private static final String TAG = ChestDBHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "chest.db";
    private static final int DATABASE_VERSION = 1;

    //Used to read data from res/ and assets/
    private Resources mResources;

    private JSONArray mInsects = null;

    public ChestDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        mResources = context.getResources();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO: Create and fill the database

        final String SQL_CREATE_COMPLAINT_TABLE =

                "CREATE TABLE " + ChestContract.ChestEntry.TABLE_COMPLAINTS + " (" +

                        ChestContract.ChestEntry.COMPLAINTS_ID       + " INTEGER, "+

                        ChestContract.ChestEntry.COMPLAINT_NAME + " TEXT, "        +

                        ChestContract.ChestEntry.COMPLAINT_CATEGORY + " INTEGER, " +

                        ChestContract.ChestEntry.COMPLAINT_STATUS  + " INTEGER)";

        final String SQL_CREATE_DIAGNOSIS_TABLE =

                "CREATE TABLE " + ChestContract.ChestEntry.TABLE_DIAGNOSIS + " (" +

                        ChestContract.ChestEntry.DIAGNOSIS_ID       + " INTEGER, "+

                        ChestContract.ChestEntry.DIAGNOSIS_NAME + " TEXT, "       +

                        ChestContract.ChestEntry.INVESTIGATION_NAME + " TEXT, "   +

                        ChestContract.ChestEntry.TREATMENT_NAME + " TEXT, "       +

                        ChestContract.ChestEntry.DIAGNOSIS_STATUS  + " INTEGER)";

        db.execSQL(SQL_CREATE_COMPLAINT_TABLE);
        db.execSQL(SQL_CREATE_DIAGNOSIS_TABLE);

        try {
            readEntryFromResources(db);
            readDataFromResources(db);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        } catch (JSONException e) {
            Log.e(TAG, e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO: Handle database version upgrades
        db.execSQL("DROP TABLE IF EXISTS " + ChestContract.ChestEntry.TABLE_COMPLAINTS);
        db.execSQL("DROP TABLE IF EXISTS " + ChestContract.ChestEntry.TABLE_DIAGNOSIS);
        onCreate(db);
    }

    private void readEntryFromResources(SQLiteDatabase db) throws IOException, JSONException {

                ContentValues cv = new ContentValues();

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 1);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc1));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 1);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 2);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc2));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 1);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 3);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc3));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 2);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 4);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc4));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 1);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 5);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc5));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 1);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 6);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc6));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 3);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 7);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc7));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 3);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 8);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc8));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 2);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 9);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc9));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 1);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 10);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc10));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 1);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 11);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc11));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 1);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 12);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc12));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 2);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 13);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc13));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 2);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 14);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc14));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 2);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 15);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc15));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 1);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 16);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc16));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 1);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 17);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc17));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 1);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 18);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc18));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 1);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 19);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc19));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 2);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 20);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc20));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 1);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 21);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cp1));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 3);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 22);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cp2));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 3);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 23);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cp3));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 3);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 24);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cp4));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 3);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 25);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cp5));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 3);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 26);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cp6));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 4);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 27);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc21));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 2);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 28);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc22));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 2);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 29);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc23));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 4);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

                cv.put(ChestContract.ChestEntry.COMPLAINTS_ID, 30);
                cv.put(ChestContract.ChestEntry.COMPLAINT_NAME, mResources.getString(R.string.cc24));
                cv.put(ChestContract.ChestEntry.COMPLAINT_CATEGORY, 4);
                cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
                db.insert(ChestContract.ChestEntry.TABLE_COMPLAINTS, null, cv);

            }


    private void readDataFromResources(SQLiteDatabase db) throws IOException, JSONException {

        ContentValues cv = new ContentValues();

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 1);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg1));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, mResources.getString(R.string.iv1));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "TREATMENT FOR PEPTIC ULCER:\n1. "+mResources.getString(R.string.tm21)+"\n2. "+mResources.getString(R.string.tm22)+"\n3. "+mResources.getString(R.string.tm23));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 2);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg2));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, mResources.getString(R.string.iv2));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "TREATMENT FOR MUSCULOSKELETAL DISEASE:\n1. "+mResources.getString(R.string.tm24)+"\n2. "+mResources.getString(R.string.tm26)+"\n3. "+mResources.getString(R.string.tm25));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 3);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg3));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, mResources.getString(R.string.iv14));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, mResources.getString(R.string.tm31));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 4);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg4));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, mResources.getString(R.string.iv15));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "TREATMENT FOR BRONCHIAL ASTHMA:\n1. "+mResources.getString(R.string.tm8)+"\n2. "+mResources.getString(R.string.tm9)+"\n3. "+mResources.getString(R.string.tm10)+"\n4. "+mResources.getString(R.string.tm11)+"\n5. "+mResources.getString(R.string.tm12));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 5);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg5));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, "1. "+mResources.getString(R.string.iv3)+"\n2. "+mResources.getString(R.string.iv4)+"\n3. "+mResources.getString(R.string.iv6));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, mResources.getString(R.string.tm32));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 6);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg6));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, "1. "+mResources.getString(R.string.iv3)+"\n2. "+mResources.getString(R.string.iv5));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "TREATMENT FOR ISCHEMIC HEART DISEASE:\n"+mResources.getString(R.string.tm32));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 7);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg7));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, mResources.getString(R.string.iv2));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "TREATMENT FOR BRONCHOGENIC CARCINOMA:\n1. "+mResources.getString(R.string.tm13)+"\n2. "+mResources.getString(R.string.tm14)+"\n3. "+mResources.getString(R.string.tm15));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 8);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg8));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, mResources.getString(R.string.iv15));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "TREATMENT FOR PNEUMONIA:\n1. "+mResources.getString(R.string.tm1)+"\n2. "+mResources.getString(R.string.tm2));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 9);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg9));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, mResources.getString(R.string.iv15));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "TREATMENT FOR PULMONARY TB:\n1. "+mResources.getString(R.string.tm3)+"\n2. "+mResources.getString(R.string.tm4)+"\n3. "+mResources.getString(R.string.tm5)+"\n4. "+mResources.getString(R.string.tm6)+"\n5. "+mResources.getString(R.string.tm7));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 10);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg10));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, mResources.getString(R.string.iv15));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "TREATMENT FOR COPD:\n1. "+mResources.getString(R.string.tm16)+"\n2. "+mResources.getString(R.string.tm17)+"\n3. "+mResources.getString(R.string.tm18)+"\n4. "+mResources.getString(R.string.tm33));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 11);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg11));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, "1. "+mResources.getString(R.string.iv2)+"\n2. "+mResources.getString(R.string.iv12)+"\n3. "+mResources.getString(R.string.iv13));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "TREATMENT FOR PLEURAL EFFUSION:\n1. "+mResources.getString(R.string.tm28)+"\n2. "+mResources.getString(R.string.tm29)+"\n3. "+mResources.getString(R.string.tm30));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 12);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg12));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, mResources.getString(R.string.iv15));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "TREATMENT FOR ILD:\n1. "+mResources.getString(R.string.tm19)+"\n2. "+mResources.getString(R.string.tm20));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 13);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg13));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, "1. "+mResources.getString(R.string.iv3)+"\n2. "+mResources.getString(R.string.iv4)+"\n3. "+mResources.getString(R.string.iv6));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "TREATMENT FOR RHYTHM DISORDER:\n"+mResources.getString(R.string.tm32));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 14);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg14));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, "CHANCE OF HEART FAILURE:\n"+mResources.getString(R.string.iv14));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "CHANCE OF HEART FAILURE:\n"+mResources.getString(R.string.tm31));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 15);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg15));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, "CHANCE OF HEART FAILURE:\n"+mResources.getString(R.string.iv14));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "CHANCE OF HEART FAILURE:\n"+mResources.getString(R.string.tm31));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 16);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg16));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, "CHANCE OF HEART FAILURE:\n"+mResources.getString(R.string.iv14));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "CHANCE OF HEART FAILURE:\n"+mResources.getString(R.string.tm31));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 17);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg17));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, "CHANCE OF HEART FAILURE:\n"+mResources.getString(R.string.iv14));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, "CHANCE OF HEART FAILURE:\n"+mResources.getString(R.string.tm31));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 18);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, mResources.getString(R.string.dg18));
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, mResources.getString(R.string.iv14));
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, mResources.getString(R.string.tm31));
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        db.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

    }


}
