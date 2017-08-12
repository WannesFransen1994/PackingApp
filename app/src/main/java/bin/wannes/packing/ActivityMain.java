package bin.wannes.packing;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import bin.wannes.packing.Activities.ActivityCalculation;
import bin.wannes.packing.Activities.ActivityLoadConfiguration;


public class ActivityMain extends AppCompatActivity {
    Button whatsItFor;
    Button calculation;
    Button loadConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        initializeOnClickListeners();
    }

    private void initialize() {
        whatsItFor = (Button) findViewById(R.id.ButtonWhatsitfor);
        calculation = (Button) findViewById(R.id.ButtonCalculate);
        loadConfig = (Button) findViewById(R.id.ButtonLoadConfig);

    }

    private void initializeOnClickListeners() {
        whatsItFor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMain.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_whats_it_for, null);
                Button gotIt = dialogView.findViewById(R.id.ButtonGotIt);
                builder.setView(dialogView);
                final AlertDialog dialog = builder.create();
                gotIt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        calculation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ActivityCalculation.class));
            }
        });
        loadConfig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ActivityLoadConfiguration.class));
            }
        });
    }

}
