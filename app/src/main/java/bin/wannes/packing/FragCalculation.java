package bin.wannes.packing;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by wannes on 31/07/2017.
 */

public class FragCalculation extends Fragment implements View.OnClickListener{
    View v;
    EditText box1Height;
    EditText box1Width;
    EditText box1Length;
    EditText box2Height;
    EditText box2Width;
    EditText box2Length;
    EditText columnHeight;
    EditText columnWidth;
    EditText columnLength;
    EditText columnpockets;
    EditText columnAmount;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_box_form, container, false);
        initialize();
        return v;
    }

    private void initialize(){
        box1Height = v.findViewById(R.id.EditTextBox1Height);
        box1Length = v.findViewById(R.id.EditTextBox1Length);
        box1Width = v.findViewById(R.id.EditTextBox1Width);
        box2Height = v.findViewById(R.id.EditTextBox2Height);
        box2Length= v.findViewById(R.id.EditTextBox2Length);
        box2Width = v.findViewById(R.id.EditTextBox2Width);
        columnHeight = v.findViewById(R.id.EditTextColumnHeight);
        columnLength = v.findViewById(R.id.EditTextColumnLength);
        columnWidth = v.findViewById(R.id.EditTextColumnWidth);
        columnAmount = v.findViewById(R.id.EditTextColumnAmount);
        columnpockets = v.findViewById(R.id.EditTextColumnPockets);
        box1Height.setMaxWidth(box1Height.getWidth());
        box1Width.setMaxWidth(box1Width.getWidth());
        box1Length.setMaxWidth(box1Length.getWidth());
        box2Height.setMaxWidth(box2Height.getWidth());
        box2Width.setMaxWidth(box2Width.getWidth());
        box2Length.setMaxWidth(box2Length.getWidth());
        columnHeight.setMaxWidth(columnHeight.getWidth());
        columnLength.setMaxWidth(columnLength.getWidth());
        columnWidth.setMaxWidth(columnWidth.getWidth());
        columnAmount.setMaxWidth(columnAmount.getWidth());
        columnpockets.setMaxWidth(columnpockets.getWidth());
    }

    @Override
    public void onClick(View view) {
        }
}
