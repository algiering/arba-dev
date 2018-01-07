package com.arba.checkablelistview2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018-01-05.
 */

public class AdapterPerson extends ArrayAdapter<ModelPerson> {

    public AdapterPerson(@NonNull Context context, int resource, @NonNull ArrayList<ModelPerson> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.view_person, null);

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
        }
        return v;
    }

    private class ViewHolder {

        private ImageView img_photo;
        private TextView text_name, text_age;
        private CheckBox checkBox;

        private LinearLayout custom_Linear;
    }

    // 1 인터페이스 선언
    public static interface OnClickedListener {
        void onClickedListener(View v);
    }

    // 2 리스너 선언
    private OnClickedListener clickedListener;
    public void setClickedListener(OnClickedListener listener) {
        this.clickedListener = listener;
    }

}
