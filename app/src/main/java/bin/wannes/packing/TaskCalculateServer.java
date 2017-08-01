package bin.wannes.packing;

import android.os.AsyncTask;
import android.util.Log;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import bin.wannes.packing.Model.Box;
import bin.wannes.packing.Model.BoxSetup;

/**
 * Created by wannes on 1/08/2017.
 */

public class TaskCalculateServer extends AsyncTask<String, Void, ResponseEntity> {
    final String url = "https://bin-packing-3d-rest.herokuapp.com/api/containersetup?box1Length=120&box1Width=80&box1Height=100&box2Length=150&box2Width=100&box2Height=120&columnLength=60&columnWidth=70&columnHeight=259&pocketsNumber=6&columnAmount=12";
    final RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void onPostExecute(ResponseEntity boxMap) {
        super.onPostExecute(boxMap);
    }

    @Override
    protected ResponseEntity doInBackground(String... strings) {
        ResponseEntity<String> response=null;
        BoxSetup temp = null;
        try {
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            //restTemplate.exchange()
            //s = restTemplate.getForObject(url, String.class);
            response = restTemplate.getForEntity(url, String.class);
            String json = response.getBody();
            temp = new Gson().fromJson(json, BoxSetup.class);
            System.out.println(temp);
            //}
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
            System.out.println(e.getMessage());
        }
        return response;
    }
}
