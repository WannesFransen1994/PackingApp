package bin.wannes.packing.Tasks;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wannes on 31/07/2017.
 */

public class TaskContactServer extends AsyncTask<String, Void, ResponseEntity> {
    final String url = "https://bin-packing-3d-rest.herokuapp.com";
    final RestTemplate restTemplate = new RestTemplate();
    TextView labelContactServer;

    public TaskContactServer(TextView labelContactServer) {
        this.labelContactServer = labelContactServer;
    }

    @Override
    protected void onPostExecute(ResponseEntity responseEntity) {
        if (responseEntity == null) {
            labelContactServer.setText("Not online");
        } else if (responseEntity.getStatusCode().value() == 200) {
            SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss");
            labelContactServer.setText("Last online @ " + sd.format(new Date()));
        }
    }

    @Override
    protected ResponseEntity doInBackground(String... strings) {
        ResponseEntity<String> response;
        try {
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            //restTemplate.exchange()
            //s = restTemplate.getForObject(url, String.class);
            response = restTemplate.getForEntity(url, String.class);
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
            response = null;
        }
        return response;
    }
}