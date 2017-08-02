package bin.wannes.packing;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import bin.wannes.packing.Model.BoxSetup;

/**
 * Created by wannes on 1/08/2017.
 */

public class TaskCalculateServer extends AsyncTask<String, Void, BoxSetup> {
    final String url = "https://bin-packing-3d-rest.herokuapp.com/api/containersetup?box1Length=120&box1Width=80&box1Height=100&box2Length=150&box2Width=100&box2Height=120&columnLength=60&columnWidth=70&columnHeight=259&pocketsNumber=6&columnAmount=12";
    final RestTemplate restTemplate = new RestTemplate();

    @Override
    protected void onPostExecute(BoxSetup boxSetup) {
        super.onPostExecute(boxSetup);
    }

    @Override
    protected BoxSetup doInBackground(String... strings) {
        String[] args = strings;
        BoxSetup boxSetup = null;
        try {
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            String json = restTemplate.getForEntity(url, String.class).getBody();
            boxSetup = new Gson().fromJson(json, BoxSetup.class);
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
            System.out.println(e.getMessage());
        }
        return boxSetup;
    }
}
