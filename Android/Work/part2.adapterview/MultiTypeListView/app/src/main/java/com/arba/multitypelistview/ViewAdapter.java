package com.arba.multitypelistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018-01-09.
 */

public class ViewAdapter extends ArrayAdapter {

    Context context;

    public ViewAdapter(@NonNull Context context, int resource, @NonNull ArrayAdapter<Object> objects) {
        super(context, resource, (List) objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;

        return super.getView(position, convertView, parent);
    }
}
