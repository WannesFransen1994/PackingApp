package bin.wannes.packing.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import bin.wannes.packing.R;
import bin.wannes.packing.Tasks.TaskContactServer;

/**
 * Created by wannes on 31/07/2017.
 */

public class FragContactServer extends Fragment implements View.OnClickListener{
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
        new TaskContactServer(labelContactServer).execute();
    }
}
