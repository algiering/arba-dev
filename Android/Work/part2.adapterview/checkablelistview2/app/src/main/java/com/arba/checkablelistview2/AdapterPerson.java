package com.arba.checkablelistview2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018-01-05.
 */

public class AdapterPerson extends ArrayAdapter<ModelPerson> {
    private final Context context;

    public AdapterPerson(@NonNull Context context, int resource, @NonNull ArrayList<ModelPerson> objects) {
        super(context, resource, objects);

        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewPerson view = null;

        if (convertView == null) {
            view = new ViewPerson(context);
            view.setOnCheckedChangedListener(new ViewPerson.OnCheckedChangedListener() {
                @Override
                public void onCheckedChangedListener(View checkableView, boolean isChecked) {
                    ((ViewPerson)checkableView).toggle();
                }
            });
        }
        else  {
            view = (ViewPerson) convertView;
        }

        view.setPerson(getItem(position));
        return view;
    }
}
