package com.arba.checkablelistview3;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
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
        // return getViewHolder(position, convertView, parent);
        return getViewClass(position, convertView, parent);
    }

    @NonNull
    public View getViewHolder(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;

        ViewHolder holder = new ViewHolder();

        if (rowView == null) {

            rowView = LayoutInflater.from(this.context).inflate(R.layout.view_person, parent, false);


            holder.image_photo = rowView.findViewById(R.id.image_photo);
            holder.text_name = rowView.findViewById(R.id.text_name);
            holder.text_age = rowView.findViewById(R.id.text_age);
            holder.image_check = rowView.findViewById(R.id.image_check);

            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        final ModelPerson p = getItem(position);

        if (p != null) {

            holder.image_photo.setImageDrawable(p.getImagePhoto());
            holder.text_name.setText(p.getTextName());
            holder.text_age.setText(p.getTextAge());
            holder.image_check.setChecked(p.getImageCheck());

            final View finalRowView = rowView;
            holder.image_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    p.setImageCheck(!p.getImageCheck());

                    redraw(finalRowView, p);
                }
            });

            redraw(rowView, p);
        }

        return rowView;
    }

    private void redraw(View rowView, ModelPerson p) {
        if (p.getImageCheck()) {
            rowView.setBackgroundColor(Color.GRAY);
        } else {
            rowView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private class ViewHolder {
        private ImageView image_photo;
        private TextView text_name;
        private TextView text_age;
        private CheckBox image_check;
    }

    
    @NonNull
    public View getViewClass(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewPerson rowView = (ViewPerson) convertView;

        if(rowView == null) {
            rowView = new ViewPerson(parent.getContext());
        }

        ModelPerson p = list.get(position);

        rowView.setPerson(p);

        return rowView;
    }

}
