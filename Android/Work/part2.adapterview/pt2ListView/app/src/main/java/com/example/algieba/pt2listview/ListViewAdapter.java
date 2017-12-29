package com.example.algieba.pt2listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Algieba on 2017-12-28.
 */

public class ListViewAdapter extends ArrayAdapter<PersonData> {

    private ArrayList<PersonData> items;

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<PersonData> objects) {
        super(context, resource, objects);
        this.items = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.view_person, null);
            ViewHolder holder = new ViewHolder();
            holder.txtName = (TextView) v.findViewById(R.id.txtName);
            holder.txtNum = (TextView) v.findViewById(R.id.txtNum);
            holder.txtComp = (TextView) v.findViewById(R.id.txtComp);

            v.setTag(holder);
        }

        PersonData p = items.get(position);

        if (p != null) {
            ViewHolder holder = (ViewHolder) v.getTag();

            holder.txtName.setText(p.getName());
            holder.txtNum.setText(String.valueOf(p.getNum()));
            holder.txtComp.setText(p.getDepart());
        }
        return v;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtNum;
        private TextView txtComp;
    }

    public void addItem(String name, int num, String comp) {
        PersonData item = new PersonData();

        item.setName(name);
        item.setNum(num);
        item.setDepart(comp);

        items.add(item);
    }
}
