package com.arba.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Algieba on 2017-12-28.
 */

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<PersonData> listViewItemList = new ArrayList<PersonData>();

    public ListViewAdapter() {

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.view_person, parent, false);
        }

        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        TextView txtNum = (TextView) convertView.findViewById(R.id.txtNum);
        TextView txtComp = (TextView) convertView.findViewById(R.id.txtComp);

        PersonData listViewItem = listViewItemList.get(position);

        txtName.setText(listViewItem.getName());
        txtNum.setText(listViewItem.getNum());
        txtComp.setText(listViewItem.getDepart());

        return convertView;
    }

    public void addItem(String name, String num, String comp) {
        PersonData item = new PersonData();

        item.setName(name);
        item.setNum(num);
        item.setDepart(comp);

        listViewItemList.add(item);
    }
}
