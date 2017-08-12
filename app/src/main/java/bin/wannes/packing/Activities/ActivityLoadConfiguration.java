package bin.wannes.packing.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bin.wannes.packing.DB.BoxRequestDbContract;
import bin.wannes.packing.DB.BoxRequestDbHelper;
import bin.wannes.packing.R;

public class ActivityLoadConfiguration extends AppCompatActivity {

    BoxRequestDbHelper dbHelper;
    SQLiteDatabase database;
    ListView savedConfigsList;
    List<String> savedRequestConfigs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_configuration);
        initialize();
        initializeListener();
        loadConfigs();

        SavedConfigListAdapter adapter = new SavedConfigListAdapter(getApplicationContext(),
                R.layout.saved_config_row,savedRequestConfigs);
        savedConfigsList.setAdapter(adapter);

    }

    private void initialize(){
        dbHelper = new BoxRequestDbHelper(getApplicationContext());
        database = dbHelper.getReadableDatabase();
        savedConfigsList = (ListView) findViewById(R.id.ListviewLoadConfiguration);
    }

    private void loadConfigs(){
        String[] projection = {BoxRequestDbContract.BoxRequestEntry.REQUEST_NAME};
        Cursor cursor = database.query(BoxRequestDbContract.BoxRequestEntry.TABLE_NAME, projection, null, null, null, null, null);

        savedRequestConfigs = new ArrayList<>();
        while (cursor.moveToNext()) {
            savedRequestConfigs.add(cursor.getString(cursor.getColumnIndex(BoxRequestDbContract.BoxRequestEntry.REQUEST_NAME)));
        }
        cursor.close();
    }

    private void initializeListener(){
        savedConfigsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int box1Length, box1Width, box1Height,
                        box2Length, box2Width, box2Height,
                        columnLength, columnWidth, columnHeight, columnAmount, columnPockets;
                String labelClickedItem = ((TextView)view.findViewById(R.id.LabelRowSavedConfig)).getText().toString();
                String[] projection = { "*" };
                String[] selectionArgs = { labelClickedItem };
                String selection = BoxRequestDbContract.BoxRequestEntry.REQUEST_NAME+ " = ?";
                Cursor cursor = database.query(BoxRequestDbContract.BoxRequestEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
                cursor.moveToFirst();
                box1Length = cursor.getInt(cursor.getColumnIndexOrThrow(BoxRequestDbContract.BoxRequestEntry.BOX1_LENGTH));
                box1Width = cursor.getInt(cursor.getColumnIndexOrThrow(BoxRequestDbContract.BoxRequestEntry.BOX1_WIDTH));
                box1Height = cursor.getInt(cursor.getColumnIndexOrThrow(BoxRequestDbContract.BoxRequestEntry.BOX1_HEIGHT));
                box2Length = cursor.getInt(cursor.getColumnIndexOrThrow(BoxRequestDbContract.BoxRequestEntry.BOX2_LENGTH));
                box2Width = cursor.getInt(cursor.getColumnIndexOrThrow(BoxRequestDbContract.BoxRequestEntry.BOX2_WIDTH));
                box2Height = cursor.getInt(cursor.getColumnIndexOrThrow(BoxRequestDbContract.BoxRequestEntry.BOX2_HEIGHT));
                columnLength = cursor.getInt(cursor.getColumnIndexOrThrow(BoxRequestDbContract.BoxRequestEntry.COLUMN_LENGTH));
                columnWidth = cursor.getInt(cursor.getColumnIndexOrThrow(BoxRequestDbContract.BoxRequestEntry.COLUMN_WIDTH));
                columnHeight = cursor.getInt(cursor.getColumnIndexOrThrow(BoxRequestDbContract.BoxRequestEntry.COLUMN_HEIGHT));
                columnPockets = cursor.getInt(cursor.getColumnIndexOrThrow(BoxRequestDbContract.BoxRequestEntry.COLUMN_POCKETS));
                columnAmount = cursor.getInt(cursor.getColumnIndexOrThrow(BoxRequestDbContract.BoxRequestEntry.COLUMN_AMOUNT));
                cursor.close();
                Intent nextActivity = new Intent(getApplicationContext(),ActivityViewResults.class);
                nextActivity.putExtra("box1Length",box1Length);
                nextActivity.putExtra("box1Width",box1Width);
                nextActivity.putExtra("box1Height",box1Height);
                nextActivity.putExtra("box2Length",box2Length);
                nextActivity.putExtra("box2Width",box2Width);
                nextActivity.putExtra("box2Height",box2Height);
                nextActivity.putExtra("columnLength",columnLength);
                nextActivity.putExtra("columnWidth",columnWidth);
                nextActivity.putExtra("columnHeight",columnHeight);
                nextActivity.putExtra("columnPockets",columnPockets);
                nextActivity.putExtra("columnAmount",columnAmount);
                startActivity(nextActivity);
            }
        });
    }
}
