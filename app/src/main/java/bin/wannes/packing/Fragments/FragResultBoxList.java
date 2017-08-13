package bin.wannes.packing.Fragments;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bin.wannes.packing.DB.BoxRequestDbContract;
import bin.wannes.packing.DB.BoxRequestDbHelper;
import bin.wannes.packing.Model.Box;
import bin.wannes.packing.R;

/**
 * Created by Wannes on 8/08/2017.
 */

public class FragResultBoxList extends Fragment implements View.OnClickListener {
    ListView listResultBox;
    List<WrapperObjectBox> list;
    CustomResultListAdapter customAdapter;
    Button buttonSaveResultDialog;
    BoxRequestDbHelper boxRequestDbHelper;
    EditText nameConfiguration;
    Dialog alertDialog;
    Bundle bundle;

    @TargetApi(23)
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_result_box_list, container, false);
        initialize(v);
        boxRequestDbHelper = new BoxRequestDbHelper(getContext());
        return v;
    }

    private void initialize(View view) {
        list = new ArrayList();
        listResultBox = (ListView) view.findViewById(R.id.ListviewResultBox);
        buttonSaveResultDialog = (Button) view.findViewById(R.id.ButtonSaveResult);
        buttonSaveResultDialog.setOnClickListener(this);
    }

    public void addToListResultBox(Box box, Integer amount) {
        list.add(new WrapperObjectBox(box, amount));
    }

    public void updateAdapter() {
        customAdapter = new CustomResultListAdapter(getActivity().getApplicationContext(), list);
        listResultBox.setAdapter(customAdapter);

    }

    @Override
    public void onClick(View view) {

        View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_save_result, null);
        nameConfiguration = (EditText) dialogView.findViewById(R.id.EditTextNameResult);
        Button buttonSaveConfirm = dialogView.findViewById(R.id.ButtonSaveResultConfirm);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(dialogView);
        alertDialog = builder.create();
        nameConfiguration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameConfiguration.setText("");
            }
        });
        buttonSaveConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkIfExistsInDb(boxRequestDbHelper.getReadableDatabase())) {
                    writeToDb(boxRequestDbHelper.getWritableDatabase());
                }
                try {

                } catch (Exception exception) {
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Error: Is the name the same?", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        alertDialog.show();
    }

    private boolean checkIfExistsInDb(SQLiteDatabase readDb) {
        String name = nameConfiguration.getText().toString();
        if (name.length() <= 3) {
            showToast("Name too short! (+3 chars)");
            return true;
        }
        String[] projection = {BoxRequestDbContract.BoxRequestEntry.REQUEST_NAME};
        String selection = BoxRequestDbContract.BoxRequestEntry.REQUEST_NAME+ " = ?";
        String[] selectionArgs = { name };
        Cursor cursor = readDb.query(BoxRequestDbContract.BoxRequestEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        if (count != 0) {
            showToast("Name already exists!");
            return true;
        }
        return false;
    }

    private void writeToDb(SQLiteDatabase writeDb) {
        Bundle formData = this.bundle;
        String requestName = nameConfiguration.getText().toString();

        ContentValues values = new ContentValues();
        values.put(BoxRequestDbContract.BoxRequestEntry.REQUEST_NAME, requestName);
        values.put(BoxRequestDbContract.BoxRequestEntry.BOX1_LENGTH, formData.getInt("box1Length"));
        values.put(BoxRequestDbContract.BoxRequestEntry.BOX1_WIDTH, formData.getInt("box1Width"));
        values.put(BoxRequestDbContract.BoxRequestEntry.BOX1_HEIGHT, formData.getInt("box1Height"));
        values.put(BoxRequestDbContract.BoxRequestEntry.BOX2_LENGTH, formData.getInt("box2Length"));
        values.put(BoxRequestDbContract.BoxRequestEntry.BOX2_WIDTH, formData.getInt("box2Width"));
        values.put(BoxRequestDbContract.BoxRequestEntry.BOX2_HEIGHT, formData.getInt("box2Height"));
        values.put(BoxRequestDbContract.BoxRequestEntry.COLUMN_LENGTH, formData.getInt("columnLength"));
        values.put(BoxRequestDbContract.BoxRequestEntry.COLUMN_WIDTH, formData.getInt("columnWidth"));
        values.put(BoxRequestDbContract.BoxRequestEntry.COLUMN_HEIGHT, formData.getInt("columnHeight"));
        values.put(BoxRequestDbContract.BoxRequestEntry.COLUMN_POCKETS, formData.getInt("columnPockets"));
        values.put(BoxRequestDbContract.BoxRequestEntry.COLUMN_AMOUNT, formData.getInt("columnAmount"));

        writeDb.insert(BoxRequestDbContract.BoxRequestEntry.TABLE_NAME, null, values);

        alertDialog.dismiss();
        FragResultBoxList.this.getActivity().finish();
        showToast("Result Saved!");
    }

    public void customBundleSaver(Bundle bundle) {
        this.bundle = bundle;
    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
