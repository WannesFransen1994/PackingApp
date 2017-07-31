package bin.wannes.packing;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wannes on 31/07/2017.
 */

public class ContactServerTask extends AsyncTask {
    final String url = "https://bin-packing-3d-rest.herokuapp.com";
    final RestTemplate restTemplate = new RestTemplate();
    TextView labelContactServer;

    public ContactServerTask(TextView labelContactServer) {
        this.labelContactServer = labelContactServer;
    }

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