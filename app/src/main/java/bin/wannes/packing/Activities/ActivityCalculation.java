package bin.wannes.packing.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Map;

import bin.wannes.packing.Fragments.FragCalculation;
import bin.wannes.packing.R;

public class ActivityCalculation extends AppCompatActivity {
    Button buttonCalculate;
    FragCalculation fragmentCalculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        fragmentCalculation = (FragCalculation) getFragmentManager().findFragmentById(R.id.FragmentCalculation);

        initialize();
        initializeOnClickListeners();
    }

    private void initialize(){
        buttonCalculate = (Button) findViewById(R.id.ButtonCalculate);
    }

    private void initializeOnClickListeners(){
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent nextActivity = new Intent(getApplicationContext(),ActivityViewResults.class);
                Map<String,Integer> boxFormData = fragmentCalculation.getFieldData();
                for (String key: boxFormData.keySet()) {
                       nextActivity.putExtra(key,boxFormData.get(key));
                }
                startActivity(nextActivity);
            }
        });
    }

}
