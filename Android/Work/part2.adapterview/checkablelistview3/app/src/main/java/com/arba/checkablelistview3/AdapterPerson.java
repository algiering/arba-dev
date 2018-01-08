package com.arba.checkablelistview3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-01-08.
 */

public class AdapterPerson extends ArrayAdapter<ModelPerson> {

    private Context context;
    private List<ModelPerson> list;

    public AdapterPerson(@NonNull Context context, int resource, @NonNull List<ModelPerson> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {

            v = LayoutInflater.from(this.context).inflate(R.layout.view_person, parent, false);

            ViewHolder holder = new ViewHolder();
            holder.image_photo = v.findViewById(R.id.image_photo);
            holder.text_name = v.findViewById(R.id.text_name);
            holder.text_age = v.findViewById(R.id.text_age);
            holder.image_check = v.findViewById(R.id.image_check);

            v.setTag(holder);
        } else {

        }

        ModelPerson p = getItem(position);

        if (p != null) {
            final ViewHolder holder = (ViewHolder) v.getTag();

            holder.image_photo.setImageDrawable(p.getImagePhoto());
            holder.text_name.setText(p.getTextName());
            holder.text_age.setText(p.getTextAge());
            holder.image_check.setChecked(p.getImageCheck());

            holder.image_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        list.get(position).setImageCheck(true);
                    } else {
                        list.get(position).setImageCheck(false);
                    }
                }
            });

            if (list.get(position).getImageCheck()) {
                holder.image_check.setChecked(true);
            } else {
                holder.image_check.setChecked(false);
            }
        }

        return v;
    }

    private class ViewHolder {
        private ImageView image_photo;
        private TextView text_name;
        private TextView text_age;
        private CheckBox image_check;
    }
}
