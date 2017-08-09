package bin.wannes.packing.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import bin.wannes.packing.Model.Box;
import bin.wannes.packing.R;

/**
 * Created by Wannes on 8/08/2017.
 */

public class FragResultBoxList extends Fragment {
    ListView listResultBox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_result_box_list, container, false);
        return v;
    }

    public ListView getListResultBox() {
        return this.getView().findViewById(R.id.ListviewResultBox);
    }

    public void addToListResultBox(Box box, Integer amount) {
        Box b = box;
        int i = amount;
        //TODO: add to list
    }
}
