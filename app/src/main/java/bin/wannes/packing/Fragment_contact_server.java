package bin.wannes.packing;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wannes on 31/07/2017.
 */

public class Fragment_contact_server extends Fragment implements View.OnClickListener{
    TextView labelContactServer;
    Button buttonContactServer;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_contact_server, container, false);
        labelContactServer =  v.findViewById(R.id.LabelContact);
        buttonContactServer = v.findViewById(R.id.ButtonContactServer);
        buttonContactServer.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        labelContactServer.setText("Contacting");
        new ContactServerTask(labelContactServer).execute();
    }
}
