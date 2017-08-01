package bin.wannes.packing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityCalculation extends AppCompatActivity {
    Button buttonQuickView;
    Button buttonCompleteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        initialize();
        initializeOnClickListeners();
    }

    private void initialize(){
        buttonQuickView = (Button) findViewById(R.id.ButtonQuickView);
        buttonCompleteView = (Button) findViewById(R.id.ButtonCompleteView);
    }

    private void initializeOnClickListeners(){
        buttonQuickView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent nextActivity = new Intent(getApplicationContext(),ActivityQuickView.class);
                //nextActivity.putExtra("id",5);
                startActivity(nextActivity);
            }
        });
        buttonCompleteView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent nextActivity = new Intent(getApplicationContext(),ActivityCompleteView.class);
                //nextActivity.putExtra("id",5);
                startActivity(nextActivity);
            }
        });
    }

}
