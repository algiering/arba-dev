package com.arba.checkablelistview2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-01-05.
 */

public class AdapterPerson extends ArrayAdapter<ModelPerson> {
    private List<ModelPerson> list;

    public AdapterPerson(@NonNull Context context, int resource, @NonNull ArrayList<ModelPerson> objects) {
        super(context, resource, objects);
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (convertView == null) {

            v = new ViewPerson(getContext());

            final ViewHolder holder = new ViewHolder();

            holder.img_photo = v.findViewById(R.id.img_photo);
            holder.text_name = v.findViewById(R.id.text_name);
            holder.text_age = v.findViewById(R.id.text_age);
            holder.checkBox = v.findViewById(R.id.checkBox);
            holder.custom_Linear = v.findViewById(R.id.custom_linear);

            v.setTag(holder);
        }

        ModelPerson p = getItem(position);

        if (p != null) {
            ViewHolder holder = (ViewHolder) v.getTag();

            holder.img_photo.setImageDrawable(p.getPhoto());
            holder.text_name.setText(p.getName());
            holder.text_age.setText(String.valueOf(p.getAge()));
            holder.checkBox.setVisibility(View.INVISIBLE);

            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getItem(position).isCheck()) {
                        getItem(position).setCheck(false);
                    }
                    else {
                        getItem(position).setCheck(true);
                    }
                    notifyDataSetChanged();
                }
            });

            holder.checkBox.setChecked(getItem(position).isCheck());
            if (getItem(position).isCheck()) {
                holder.custom_Linear.setBackground(v.getResources().getDrawable(R.color.colorPrimary));
            } else {
                holder.custom_Linear.setBackground(v.getResources().getDrawable(R.color.transparent));
            }

            if (getItem(position).isCheck_visible_stmt()) {
                holder.checkBox.setVisibility(View.VISIBLE);
            }
            else {
                holder.checkBox.setVisibility(View.INVISIBLE);
            }
        }
        return v;
    }

    private class ViewHolder {

        private ImageView img_photo;
        private TextView text_name, text_age;
        private CheckBox checkBox;

        private LinearLayout custom_Linear;
    }

    public ArrayList<ModelPerson> getList() {
        ArrayList<ModelPerson> p = new ArrayList<>();
        for (int i = 0; i < getCount(); i++) {
            p.add(getItem(i));
        }

        return p;
    }
}
