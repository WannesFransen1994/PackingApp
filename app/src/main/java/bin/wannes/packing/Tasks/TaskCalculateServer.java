package bin.wannes.packing.Tasks;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import bin.wannes.packing.Fragments.FragResultBoxList;
import bin.wannes.packing.Model.Box;
import bin.wannes.packing.Model.BoxSetup;

/**
 * Created by wannes on 1/08/2017.
 */

public class TaskCalculateServer extends AsyncTask<Integer, Void, BoxSetup> {
    String url = "https://bin-packing-3d-rest.herokuapp.com/api/containersetup?";
    final RestTemplate restTemplate = new RestTemplate();
    TextView labelResult;
    FragResultBoxList fragResultBoxList;

    public TaskCalculateServer(TextView labelResult, FragResultBoxList fragResultBoxList) {
        this.labelResult = labelResult;
        this.labelResult.setText("Calculating....");
        this.fragResultBoxList = fragResultBoxList;
    }

    @Override
    protected void onPostExecute(BoxSetup boxSetup) {
        labelResult.setVisibility(View.INVISIBLE);
        super.onPostExecute(boxSetup);

        for (Box box:boxSetup.getBoxAmount().keySet()) {
            fragResultBoxList.addToListResultBox(box,boxSetup.getBoxAmount().get(box));
        }
    }

    @Override
    protected BoxSetup doInBackground(Integer... integers) {
        Integer[] args = integers;
        //box1Length=120&box1Width=80&box1Height=100&box2Length=150&box2Width=100&box2Height=120&columnLength=60&columnWidth=70&columnHeight=259&pocketsNumber=6&columnAmount=12"
        url+=("box1Length=" + args[0].toString());
        url+=("&box1Width=" + args[1].toString());
        url+=("&box1Height=" + args[2].toString());
        url+=("&box2Length=" + args[3].toString());
        url+=("&box2Width=" + args[4].toString());
        url+=("&box2Height=" + args[5].toString());
        url+=("&columnLength=" + args[6].toString());
        url+=("&columnWidth=" + args[7].toString());
        url+=("&columnHeight=" + args[8].toString());
        url+=("&pocketsNumber=" + args[10].toString());
        url+=("&columnAmount=" + args[9].toString());

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
