package com.arba.simplemultitype;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018-01-10.
 */

public class AdapterItem extends ArrayAdapter<ModelItem> {

    // View Type
    public static final int ITEM_VIEW_TYPE_TEXT  = 0;
    public static final int ITEM_VIEW_TYPE_IMAGE = 1;
    public static final int ITEM_VIEW_TYPE_MAX   = 2;

    private final Context context;
    private final List<ModelItem> datas;
    private final LayoutInflater inflater;

    public AdapterItem(@NonNull Context context, int resource, @NonNull List<ModelItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.datas   = objects;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        
        int viewType = getItemViewType(position);

        ViewHolder holder = null;

        ModelItem item = datas.get(position);

        if (rowView == null) {
            holder = new ViewHolder();

            switch (viewType) {
                case ITEM_VIEW_TYPE_TEXT:
                    rowView = inflater.inflate(R.layout.listview_item1, parent, false);

                    holder.title = rowView.findViewById(R.id.title);
                    holder.desc  = rowView.findViewById(R.id.desc );

                    break;

                case ITEM_VIEW_TYPE_IMAGE:
                    rowView = inflater.inflate(R.layout.listview_item2, parent, false);

                    holder.image = rowView.findViewById(R.id.image);
                    holder.name  = rowView.findViewById(R.id.name );

                    break;
            }

            rowView.setTag(holder);
        }
        else {
            holder = (ViewHolder) rowView.getTag();
        }

        switch (viewType) {
            case ITEM_VIEW_TYPE_TEXT:

                holder.title.setText(item.getTitle());
                holder.desc .setText(item.getDesc() );

                break;

            case ITEM_VIEW_TYPE_IMAGE:

                holder.image.setImageDrawable(item.getImage());
                holder.name .setText         (item.getName() );

                break;
        }

        return rowView;
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }

    @Override
    public int getViewTypeCount() {
        return ITEM_VIEW_TYPE_MAX;
    }

    private class ViewHolder {
        // type 1
        TextView  title ;
        TextView  desc  ;

        // type 2
        ImageView image ;
        TextView  name  ;
    }
}
