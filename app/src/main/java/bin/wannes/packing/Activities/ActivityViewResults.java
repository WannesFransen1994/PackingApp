package bin.wannes.packing.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import bin.wannes.packing.Fragments.FragResultBoxList;
import bin.wannes.packing.R;
import bin.wannes.packing.Tasks.TaskCalculateServer;

public class ActivityViewResults extends AppCompatActivity {
    TextView labelResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);

        labelResult = (TextView) findViewById(R.id.LabelResultPlaceholder);
        labelResult.setVisibility(View.VISIBLE);

        int box1Length, box1Width, box1Height,
                box2Length, box2Width, box2Height,
                columnLength, columnWidth, columnHeight, columnAmount, columnPockets;

        Bundle extras = getIntent().getExtras();
        box1Length = extras.getInt("box1Length");
        box1Width = extras.getInt("box1Width");
        box1Height = extras.getInt("box1Height");
        box2Length = extras.getInt("box2Length");
        box2Width = extras.getInt("box2Width");
        box2Height = extras.getInt("box2Height");
        columnLength = extras.getInt("columnLength");
        columnWidth = extras.getInt("columnWidth");
        columnHeight = extras.getInt("columnHeight");
        columnAmount = extras.getInt("columnAmount");
        columnPockets = extras.getInt("columnPockets");

        new TaskCalculateServer(labelResult, (FragResultBoxList)
                getFragmentManager().findFragmentById(R.id.FragmentResultBoxList)).execute(
                box1Length, box1Width, box1Height,
                box2Length, box2Width, box2Height,
                columnLength, columnWidth, columnHeight, columnAmount, columnPockets);
    }

}
