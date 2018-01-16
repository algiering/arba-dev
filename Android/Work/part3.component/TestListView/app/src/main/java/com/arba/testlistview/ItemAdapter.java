package com.arba.testlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2018-01-16.
 */

public class ItemAdapter extends ArrayAdapter {
    private final Context context;
    private Inflater inflater;

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if(v == null) {

        }

        return super.getView(position, convertView, parent);
    }
}
