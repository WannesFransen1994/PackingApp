package bin.wannes.packing.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import bin.wannes.packing.Model.Box;
import bin.wannes.packing.R;

/**
 * Created by Wannes on 8/08/2017.
 */

public class FragResultBoxList extends Fragment {
    ListView listResultBox;
    List<WrapperObjectBox> list;
    CustomResultListAdapter customAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_result_box_list, container, false);
        listResultBox = (ListView) v.findViewById(R.id.ListviewResultBox);
        list=new ArrayList();
        return v;
    }

    public void addToListResultBox(Box box, Integer amount) {
        list.add(new WrapperObjectBox(box,amount));
    }

    public void updateAdapter(){
        customAdapter = new CustomResultListAdapter(getActivity().getApplicationContext(),list);
        listResultBox.setAdapter(customAdapter);

    }
}
