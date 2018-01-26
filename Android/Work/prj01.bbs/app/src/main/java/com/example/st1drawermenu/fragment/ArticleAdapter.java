package com.example.st1drawermenu.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.st1drawermenu.R;
import com.example.st1drawermenu.model.ModelArticle;

/**
 * Created by Administrator on 2018-01-26.
 */

class ArticleAdapter<T> extends ArrayAdapter<ModelArticle>{

    private final LayoutInflater mInflater;
    private final ModelArticle[] mList;

    public ArticleAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull ModelArticle[] objects) {
        super(context, resource, textViewResourceId, objects);

        this.mInflater = LayoutInflater.from(context);
        this.mList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;

        ViewHolder holder = null;

        if (rowView == null) { // inflation
            rowView = mInflater.inflate(R.layout.listview_customview_article, parent, false);

            holder = new ViewHolder();
            holder.no = rowView.findViewById(R.id.no);
            holder.title = rowView.findViewById(R.id.title);
            holder.hit = rowView.findViewById(R.id.hit);
            holder.content = rowView.findViewById(R.id.content);

            rowView.setTag(holder);
        }
        else {
            holder = (ViewHolder) rowView.getTag();
        }

        // 화면에 표시될 데이터 관련 설정
        ModelArticle item = getItem(position);

        holder.no.setText(item.getArticleno());
        holder.title.setText(item.getTitle());
        holder.hit.setText(item.getHit()+"");
        holder.content.setText(item.getContent());

        return rowView;
    }

    private class ViewHolder {

        private TextView no;
        private TextView title;
        private TextView hit;
        private TextView content;

    }
}
