package bin.wannes.packing.Tasks;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import bin.wannes.packing.Model.BoxSetup;

/**
 * Created by wannes on 1/08/2017.
 */

public class TaskCalculateServer extends AsyncTask<Integer, Void, BoxSetup> {
    final String url = "https://bin-packing-3d-rest.herokuapp.com/api/containersetup?box1Length=120&box1Width=80&box1Height=100&box2Length=150&box2Width=100&box2Height=120&columnLength=60&columnWidth=70&columnHeight=259&pocketsNumber=6&columnAmount=12";
    final RestTemplate restTemplate = new RestTemplate();
    TextView labelResult;

    public TaskCalculateServer(TextView labelResult) {
        this.labelResult = labelResult;
        this.labelResult.setText("Calculating....");
    }

    @Override
    protected void onPostExecute(BoxSetup boxSetup) {
        labelResult.setVisibility(View.INVISIBLE);
        super.onPostExecute(boxSetup);
    }

    @Override
    protected BoxSetup doInBackground(Integer... integers) {
        Integer[] args = integers;
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
