package bin.wannes.packing.Fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bin.wannes.packing.Model.Column;
import bin.wannes.packing.R;

/**
 * Created by wannes on 10-8-2017.
 */

public class CustomResultListAdapter extends ArrayAdapter<WrapperObjectBox> implements View.OnClickListener {
    private List<WrapperObjectBox> dataSet;
    Context context;

    private static class ViewHolder {
        TextView labelBoxResultSize;
        TextView labelBoxResultAmount;
        TextView labelBoxResultColumnPairs;
        TextView labelBoxResultVolumeUtilisation;
    }

    public CustomResultListAdapter(@NonNull Context context, @NonNull List<WrapperObjectBox> objects) {
        super(context, R.layout.result_row_item, objects);
        this.dataSet = objects;
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        WrapperObjectBox box = (WrapperObjectBox) getItem((Integer) view.getTag());
        // TODO: context.startActivity();
        System.out.println(box);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        WrapperObjectBox box = getItem(position);
        ViewHolder viewHolder;


        viewHolder = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.result_row_item, parent, false);
        viewHolder.labelBoxResultSize = (TextView) convertView.findViewById(R.id.LabelBoxResultSize);
        viewHolder.labelBoxResultAmount = (TextView) convertView.findViewById(R.id.LabelBoxResultAmount);
        viewHolder.labelBoxResultColumnPairs = (TextView) convertView.findViewById(R.id.LabelBoxResultColumnPairs);
        viewHolder.labelBoxResultVolumeUtilisation = (TextView) convertView.findViewById(R.id.LabelBoxResultVolumeUtilisation);
        viewHolder.labelBoxResultSize.setText("Box " + box.getBox().getLength() + " * " + box.getBox().getWidth() + " * " + box.getBox().getHeight());
        viewHolder.labelBoxResultAmount.setText("# of boxes: " + box.getAmount());
        viewHolder.labelBoxResultColumnPairs.setText(box.getBox().getAmountOfItems() + "Pairs / " + box.getBox().getAmountOfItems() * 2 + "columns");
        Collection<Column> items = box.getBox().getItems().values();
        List list = new ArrayList(items);
        Column temp = (Column) list.get(0);
        double used = temp.getHeight() * temp.getWidth() * temp.getLength() * box.getBox().getAmountOfItems();
        double volume = box.getBox().getVolume();
        double utilization = used / volume;
        viewHolder.labelBoxResultVolumeUtilisation.setText(Math.round(utilization * 100) + "% Utilized");
        convertView.setTag(viewHolder);
        convertView.setOnClickListener(this);
        convertView.setTag(position);
        return convertView;
    }
}




