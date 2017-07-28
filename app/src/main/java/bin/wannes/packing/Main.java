package bin.wannes.packing;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;


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

        initialize();
        initializeOnClickListeners();
    }

    private void initialize() {
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
                new HttpRequestTask().execute();
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

    private class HttpRequestTask extends AsyncTask {
        final String url = "https://bin-packing-3d-rest.herokuapp.com";
        final RestTemplate restTemplate = new RestTemplate();


        @Override
        protected Object doInBackground(Object[] objects) {
            String s;
            try {
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                s = restTemplate.getForObject(url, String.class);
            } catch (Exception e){
                Log.e("MainActivity", e.getMessage(), e);
                s = "";
            }
            return s;
        }

        @Override
        protected void onPostExecute(Object o) {
            TextView labelContactServer = (TextView) findViewById(R.id.LabelContact);
            if (o instanceof String){
                if (((String) o).length()>0){
                    SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss");
                    labelContactServer.setText("Last online @ " + sd.format(new Date()));
                } else {
                    labelContactServer.setText("Not online");
                }
            }
        }
    }
}
