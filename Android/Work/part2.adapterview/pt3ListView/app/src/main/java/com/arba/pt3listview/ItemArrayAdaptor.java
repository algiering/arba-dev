package com.arba.pt3listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-12-29.
 */

public class ItemArrayAdaptor extends ArrayAdapter<PersonData> {

    ArrayList<PersonData> items;

    public ItemArrayAdaptor(@NonNull Context context, int resource, @NonNull ArrayList<PersonData> objects) {
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
            holder.txtName = v.findViewById(R.id.txtName);
            holder.txtNum = v.findViewById(R.id.txtNum);
            holder.txtDept = v.findViewById(R.id.txtDept);
            holder.checkBox = v.findViewById(R.id.custom_checkbox);

            v.setTag(holder);
        }

        PersonData p = items.get(position);

        if(p != null) {
            ViewHolder holder = (ViewHolder) v.getTag();

            holder.txtName.setText(p.getName());
            holder.txtNum.setText(String.valueOf(p.getNumber()));
            holder.txtDept.setText(p.getDepartment());
        }
        return v;
    }

    public void addItem(String name, int number, String department, int ukey) {
        PersonData item = new PersonData();

        item.setName(name);
        item.setNumber(number);
        item.setDepartment(department);
        item.setUkey(ukey);

        items.add(item);
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtNum;
        private TextView txtDept;
        private CheckBox checkBox;
    }


}
