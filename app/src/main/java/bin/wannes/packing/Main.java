package bin.wannes.packing;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {
    Button whatsItFor;
    Button contactServer;
    Button quickView;
    Button completeView;
    Button loadConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeButtons();
        initializeOnClickListeners();
    }

    private void initializeButtons() {
        whatsItFor = (Button) findViewById(R.id.ButtonWhatsitfor);
        contactServer = (Button) findViewById(R.id.ButtonContactServer);
        quickView = (Button) findViewById(R.id.ButtonQuickView);
        completeView = (Button) findViewById(R.id.ButtonCompleteView);
        loadConfig = (Button) findViewById(R.id.ButtonLoadConfig);
    }

    private void initializeOnClickListeners() {
        whatsItFor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main.this);
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_whats_it_for,null);
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
        contactServer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //TODO: Write code
            }
        });
        quickView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //TODO: Write code
            }
        });
        completeView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //TODO: Write code
            }
        });
        loadConfig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //TODO: Write code
            }
        });
    }
}
