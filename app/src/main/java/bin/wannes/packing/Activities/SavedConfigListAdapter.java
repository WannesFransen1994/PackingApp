package bin.wannes.packing.Activities;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import bin.wannes.packing.R;

/**
 * Created by wannes on 12-8-2017.
 */

public class SavedConfigListAdapter extends ArrayAdapter<String>{
    private List<String> dataSet;
    Context context;

    public SavedConfigListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.dataSet = objects;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View rowView = inflater.inflate(R.layout.saved_config_row, parent, false);
        TextView rowText = (TextView) rowView.findViewById(R.id.LabelRowSavedConfig);
        rowText.setText(getItem(position));

        return rowView;
    }
}
