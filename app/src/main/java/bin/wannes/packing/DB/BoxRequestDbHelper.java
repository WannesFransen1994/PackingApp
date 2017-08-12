package bin.wannes.packing.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wannes on 11-8-2017.
 */

public class BoxRequestDbHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            BoxRequestDbContract.BoxRequestEntry.TABLE_NAME + " ( " +
            BoxRequestDbContract.BoxRequestEntry.REQUEST_NAME + " TEXT PRIMARY KEY, " +
            BoxRequestDbContract.BoxRequestEntry.BOX1_LENGTH + " INTEGER, " +
            BoxRequestDbContract.BoxRequestEntry.BOX1_WIDTH + " INTEGER, " +
            BoxRequestDbContract.BoxRequestEntry.BOX1_HEIGHT + " INTEGER, " +
            BoxRequestDbContract.BoxRequestEntry.BOX2_LENGTH + " INTEGER, " +
            BoxRequestDbContract.BoxRequestEntry.BOX2_WIDTH + " INTEGER, " +
            BoxRequestDbContract.BoxRequestEntry.BOX2_HEIGHT + " INTEGER, " +
            BoxRequestDbContract.BoxRequestEntry.COLUMN_LENGTH + " INTEGER, " +
            BoxRequestDbContract.BoxRequestEntry.COLUMN_WIDTH + " INTEGER, " +
            BoxRequestDbContract.BoxRequestEntry.COLUMN_HEIGHT + " INTEGER, " +
            BoxRequestDbContract.BoxRequestEntry.COLUMN_POCKETS + " INTEGER, " +
            BoxRequestDbContract.BoxRequestEntry.COLUMN_AMOUNT + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " +
            BoxRequestDbContract.BoxRequestEntry.TABLE_NAME;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BoxRequest.db";

    public BoxRequestDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
