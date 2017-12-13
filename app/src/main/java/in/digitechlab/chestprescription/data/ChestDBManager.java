package in.digitechlab.chestprescription.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import in.digitechlab.chestprescription.R;

/**
 * Created by DELL on 12/3/2017.
 */

public class ChestDBManager {

    private static ChestDBManager sInstance;
    SQLiteDatabase mDb;

    public static synchronized ChestDBManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new ChestDBManager(context.getApplicationContext());
        }

        return sInstance;
    }

    private ChestDBHelper mChestDBHelper;

    private ChestDBManager(Context context) {
        mChestDBHelper = new ChestDBHelper(context);
        mDb = mChestDBHelper.getWritableDatabase();
    }

    public void close(){
        mDb.close();
    }

    public boolean addPrescription(String dn, String in, String tn){
        ContentValues cv = new ContentValues();
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_ID, 1);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_NAME, dn);
        cv.put(ChestContract.ChestEntry.INVESTIGATION_NAME, in);
        cv.put(ChestContract.ChestEntry.TREATMENT_NAME, tn);
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 1);

        long insertedRow = mDb.insert(ChestContract.ChestEntry.TABLE_DIAGNOSIS, null, cv);

        if(insertedRow > 0){
            return true;
        }else{
            return false;
        }
    }

    public Cursor queryAllActivePrescription() {
        return mDb.query(
                ChestContract.ChestEntry.TABLE_DIAGNOSIS,
                null,
                ChestContract.ChestEntry.DIAGNOSIS_STATUS+" = "+1,
                null,
                null,
                null,
                null
        );
    }

    public Cursor queryAllActiveComplaints() {
        return mDb.query(
                ChestContract.ChestEntry.TABLE_COMPLAINTS,
                null,
                ChestContract.ChestEntry.COMPLAINT_STATUS+" = "+1,
                null,
                null,
                null,
                null
        );
    }

    public void ResetAllComplaints() {
        ContentValues cv = new ContentValues();
        cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
        mDb.update(ChestContract.ChestEntry.TABLE_COMPLAINTS, cv, ChestContract.ChestEntry.COMPLAINT_STATUS+" = "+1, null);
    }

    public void ResetAllDiagnosis() {
        ContentValues cv = new ContentValues();
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 0);
        mDb.update(ChestContract.ChestEntry.TABLE_DIAGNOSIS, cv, ChestContract.ChestEntry.DIAGNOSIS_STATUS+" = "+1, null);
    }


    public void UpdateSingleComplaint(int id) {
        ContentValues cv = new ContentValues();
        cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 1);
        mDb.update(ChestContract.ChestEntry.TABLE_COMPLAINTS, cv, ChestContract.ChestEntry.COMPLAINTS_ID+" = "+id, null);
    }

    public void ResetSingleComplaint(int id) {
        ContentValues cv = new ContentValues();
        cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
        mDb.update(ChestContract.ChestEntry.TABLE_COMPLAINTS, cv, ChestContract.ChestEntry.COMPLAINTS_ID+" = "+id, null);
    }

    public void ResetAllRespitory() {
        ContentValues cv = new ContentValues();
        cv.put(ChestContract.ChestEntry.COMPLAINT_STATUS, 0);
        mDb.update(ChestContract.ChestEntry.TABLE_COMPLAINTS, cv, ChestContract.ChestEntry.COMPLAINT_CATEGORY+" = "+2, null);
    }

    public int CheckComplaintStatus(int complaint_id) {

        int checkId = 0;

        Cursor cursor = mDb.query(
                ChestContract.ChestEntry.TABLE_COMPLAINTS,
                null,
                ChestContract.ChestEntry.COMPLAINT_STATUS+" = "+1,
                null,
                null,
                null,
                null
        );

        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            for(int i = 0; i < cursor.getCount(); i++){
                int id = cursor.getInt(cursor.getColumnIndex(ChestContract.ChestEntry.COMPLAINTS_ID));
                if(id==complaint_id){
                    checkId =1;
                }
                cursor.moveToNext();
            }
        }
        //cursor.close();
        return checkId;
    }

    public ArrayList<String> ComplaintByCategory(int category_id) {

        String WHERE =  ChestContract.ChestEntry.COMPLAINT_CATEGORY+" = "+category_id+" AND "+ChestContract.ChestEntry.COMPLAINT_STATUS+" = "+1;

        ArrayList<String> names = new ArrayList<>();

        Cursor cursor = mDb.query(
                ChestContract.ChestEntry.TABLE_COMPLAINTS,
                null,
                WHERE,
                null,
                null,
                null,
                null
        );

        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            for(int i = 0; i < cursor.getCount(); i++){
                String name = cursor.getString(cursor.getColumnIndex(ChestContract.ChestEntry.COMPLAINT_NAME));
                names.add(name);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return names;
    }

    public ArrayList<String> QueryAllActiveDiagnosis() {

        ArrayList<String> dgs = new ArrayList<>();

        Cursor cursor = mDb.query(
                ChestContract.ChestEntry.TABLE_DIAGNOSIS,
                null,
                ChestContract.ChestEntry.DIAGNOSIS_STATUS+" = "+1,
                null,
                null,
                null,
                null
        );

        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            for(int i = 0; i < cursor.getCount(); i++){
                String name = cursor.getString(cursor.getColumnIndex(ChestContract.ChestEntry.DIAGNOSIS_NAME));
                dgs.add(name);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return dgs;
    }

    public ArrayList<String> QueryAllActiveTreatment() {

        ArrayList<String> tms = new ArrayList<>();

        Cursor cursor = mDb.query(
                ChestContract.ChestEntry.TABLE_DIAGNOSIS,
                null,
                ChestContract.ChestEntry.DIAGNOSIS_STATUS+" = "+1,
                null,
                null,
                null,
                null
        );

        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            for(int i = 0; i < cursor.getCount(); i++){
                String name = cursor.getString(cursor.getColumnIndex(ChestContract.ChestEntry.TREATMENT_NAME));
                tms.add(name);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return tms;
    }

    public ArrayList<String> QueryAllActiveInvestigation() {

        ArrayList<String> ivs = new ArrayList<>();

        Cursor cursor = mDb.query(
                ChestContract.ChestEntry.TABLE_DIAGNOSIS,
                null,
                ChestContract.ChestEntry.DIAGNOSIS_STATUS+" = "+1,
                null,
                null,
                null,
                null
        );

        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            for(int i = 0; i < cursor.getCount(); i++){
                String name = cursor.getString(cursor.getColumnIndex(ChestContract.ChestEntry.INVESTIGATION_NAME));
                ivs.add(name);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return ivs;
    }


    public void UpdateSingleDiagnosis(int id) {
        ContentValues cv = new ContentValues();
        cv.put(ChestContract.ChestEntry.DIAGNOSIS_STATUS, 1);
        mDb.update(ChestContract.ChestEntry.TABLE_DIAGNOSIS, cv, ChestContract.ChestEntry.DIAGNOSIS_ID+" = "+id, null);
    }
}
