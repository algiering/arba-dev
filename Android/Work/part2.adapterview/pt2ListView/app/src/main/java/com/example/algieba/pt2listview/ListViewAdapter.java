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

    public ListViewAdapter(@NonNull Context context, int textViewResourceId, @NonNull ArrayList<PersonData> items) {
        super(context, textViewResourceId, items);
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if(v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.view_person, null);
        }
        PersonData p = items.get(position);

        if (p != null) {
            TextView txtName = (TextView) v.findViewById(R.id.txtName);
            TextView txtNum = (TextView) v.findViewById(R.id.txtNum);
            TextView txtComp = (TextView) v.findViewById(R.id.txtComp);

            txtName.setText(p.getName());
            txtNum.setText(p.getNum());
            txtComp.setText(p.getDepart());
        }
        return v;
    }

    public void addItem(String name, String num, String comp) {
        PersonData item = new PersonData();

        item.setName(name);
        item.setNum(num);
        item.setDepart(comp);

        items.add(item);
    }
}
