package com.arba.appprj.article;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.arba.appprj.R;
import com.arba.appprj.model.ModelArticle;

import java.util.List;

/**
 * Created by Administrator on 2018-02-12.
 */

public class AdapterArticle extends ArrayAdapter<ModelArticle> {
    private final LayoutInflater mInflater;
    private final List<ModelArticle> mList;

    public AdapterArticle(@NonNull Context context, int resource, @NonNull List<ModelArticle> objects) {
        super(context, resource, objects);

        this.mInflater = LayoutInflater.from(context);
        mList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;

        ViewHolder holder = null;

        if ( rowView == null ) {
            rowView = mInflater.inflate(R.layout.view_custom, parent, false);

            holder = new ViewHolder();
            holder.custom_no = rowView.findViewById(R.id.custom_no);
            holder.custom_title = rowView.findViewById(R.id.custom_title);
            holder.custom_hit = rowView.findViewById(R.id.custom_hit);
            holder.custom_comment = rowView.findViewById(R.id.custom_comment);

            rowView.setTag(holder);
        }
        else  {
            holder = (ViewHolder) rowView.getTag();
        }

        ModelArticle item = getItem(position);

        holder.custom_no.setText(String.valueOf(item.getArticle_no()));
        holder.custom_title.setText(item.getArticle_title());
        holder.custom_hit.setText(String.valueOf(item.getArticle_hit()));
        holder.custom_comment.setText(String.valueOf("["+item.getArticle_hit())+"]");

        return rowView;
    }

    private class ViewHolder {

        TextView custom_no;
        TextView custom_title;
        TextView custom_hit;
        TextView custom_comment;

    }
}
