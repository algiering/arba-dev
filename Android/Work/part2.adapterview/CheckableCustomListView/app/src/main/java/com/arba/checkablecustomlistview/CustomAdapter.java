package com.arba.checkablecustomlistview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018-01-04.
 */

public class CustomAdapter extends ArrayAdapter<ModelDog> {

    ArrayList<ModelDog> list;
    LayoutInflater inflater;


    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ModelDog> objects) {
        super(context, resource, objects);
        this.list = objects;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            v = inflater.inflate(R.layout.view_custom, null, false);

            ViewHolder holder = new ViewHolder();
            holder.text_name = v.findViewById(R.id.text_name);
            holder.text_age = v.findViewById(R.id.text_age);
            holder.img_photo = v.findViewById(R.id.img_photo);
            holder.img_check = v.findViewById(R.id.img_check);
            holder.custom_linear = v.findViewById(R.id.custom_linear);

            holder.img_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!v.isSelected()) {
                        v.setSelected(true);
                        getItem(position).setCheck(true);
                    } else {
                        v.setSelected(false);
                        getItem(position).setCheck(false);
                    }
                }
            });

            v.setTag(holder);
        }

        ModelDog dog = list.get(position);

        if (dog != null) {
            ViewHolder holder = (ViewHolder) v.getTag();

            holder.text_name.setText(dog.getName());
            holder.text_age.setText(String.valueOf(dog.getAge()));
            holder.img_photo.setImageDrawable(dog.getPhoto());

            if (dog.isCheck()) {
                holder.img_check.setSelected(true);
            } else {
                holder.img_check.setSelected(false);
            }
        }
        return v;
    }

    private class ViewHolder {
        private TextView text_name, text_age;
        private ImageView img_photo, img_check;
        private LinearLayout custom_linear;
    }
}