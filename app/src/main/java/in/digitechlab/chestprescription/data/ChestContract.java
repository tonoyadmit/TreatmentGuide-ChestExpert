package in.digitechlab.chestprescription.data;

import android.database.Cursor;
import android.provider.BaseColumns;

/**
 * Created by DELL on 12/3/2017.
 */

public class ChestContract {

    public static final class ChestEntry implements BaseColumns {

        //Database schema information

        //public static final String TABLE_PRESCRIPTION = "prescription_table";

        public static final String TABLE_COMPLAINTS = "complaints_table";

        public static final String TABLE_DIAGNOSIS = "diagnosis_table";

        public static final String COMPLAINTS_ID = "id_complaints";

        public static final String DIAGNOSIS_ID = "id_diagnosis";

        public static final String COMPLAINT_NAME = "name_complaint";

        public static final String COMPLAINT_STATUS = "status_complaint";

        public static final String COMPLAINT_CATEGORY = "category_complaint";

        public static final String DIAGNOSIS_NAME = "name_diagnosis";

        public static final String DIAGNOSIS_STATUS = "status_diagnosis";

        public static final String TREATMENT_NAME = "name_treatment";

        public static final String INVESTIGATION_NAME = "name_investigation";

        //public static final String PRESCRIPTION_STATUS = "status_investigation";

    }

    /* Helpers to retrieve column values */
    public static String getColumnString(Cursor cursor, String columnName) {
        return cursor.getString( cursor.getColumnIndex(columnName) );
    }

    public static int getColumnInt(Cursor cursor, String columnName) {
        return cursor.getInt( cursor.getColumnIndex(columnName) );
    }


}
