package com.arba.multitypelistview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.arba.multitypelistview.R;
import com.arba.multitypelistview.model.ModelActor;

import java.util.List;

/**
 * Created by Administrator on 2018-01-09.
 */

public class AdapterActor extends ArrayAdapter {


    private final Context context;

    public static final int VIEW_TYPE_ACTOR   = 0;
    public static final int VIEW_TYPE_TITLE   = 1;
    public static final int VIEW_TYPE_MOVIE   = 2;
    public static final int VIEW_TYPE_DRAMA   = 3;
    public static final int VIEW_TYPE_COMMENT = 4;

    public static final int VIEW_TYPE_MAX   = 5;
    private final LayoutInflater inflater;

    // adapter data
    private ModelActor actor;

    public ModelActor getActor() {
        return actor;
    }

    public void setActor(ModelActor actor) {
        this.actor = actor;
        // data change during app running. refresh screen
        notifyDataSetChanged();
    }

    public AdapterActor(@NonNull Context context) {
        super(context, -1);
        this.context = context;
        this.inflater = LayoutInflater.from(context)
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;

        ViewHolder holder = null;

        if (rowView == null) {

            holder = new ViewHolder();

            switch (getItemViewType(position)) {
                case VIEW_TYPE_ACTOR :
                    rowView = inflater.inflate(R.layout.view_actor, parent, false);

                    holder.image_photo      = rowView.findViewById(R.id.image_photo     );
                    holder.text_name        = rowView.findViewById(R.id.text_name       );
                    holder.text_age         = rowView.findViewById(R.id.text_age        );
                    holder.text_description = rowView.findViewById(R.id.text_description);

                    break;

                case VIEW_TYPE_TITLE :
                    rowView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

                    break;

                case VIEW_TYPE_MOVIE :
                    rowView = inflater.inflate(R.layout.view_movie, parent, false);

                    holder.image_picture = rowView.findViewById(R.id.image_picture);
                    holder.text_title    = rowView.findViewById(R.id.text_title   );
                    holder.text_year     = rowView.findViewById(R.id.text_year    );

                    break;

                case VIEW_TYPE_DRAMA :
                    rowView = inflater.inflate(R.layout.view_drama, parent, false);

                    holder.image_picture = rowView.findViewById(R.id.image_picture);
                    holder.text_title    = rowView.findViewById(R.id.text_title);
                    holder.text_interval = rowView.findViewById(R.id.text_interval);

                    break;

                case VIEW_TYPE_COMMENT :
                    rowView = inflater.inflate(R.layout.view_comment, parent, false);

                    holder.text_message = rowView.findViewById(R.id.text_message);
                    holder.text_writer  = rowView.findViewById(R.id.text_writer );

                    break;
            }

        }
        else {

        }

        holder = (ViewHolder) rowView.getTag();

        switch (getItemViewType(position)) {

            case VIEW_TYPE_ACTOR :
                holder.image_photo.setImageDrawable(actor.getImagePhoto());
                break;

            case VIEW_TYPE_TITLE :

                break;

            case VIEW_TYPE_MOVIE :
                break;

            case VIEW_TYPE_DRAMA :
                break;

            case VIEW_TYPE_COMMENT :
                break;
        }

        return super.getView(position, convertView, parent);
    }

    private class ViewHolder {
        // actor
        private ImageView image_photo;
        private TextView  text_name;
        private TextView  text_age;
        private TextView  text_description;

        // movie
        private TextView  text_year;

        // drama
        private TextView  text_interval;

        // comment
        private TextView  text_message;
        private TextView  text_writer;

        // share (movie, drama)
        private ImageView image_picture;
        private TextView  text_title;

    }
    @Override
    public int getItemViewType(int position) {
        int VIEW_TYPE = -1;
        if (position == 0) {
            return VIEW_TYPE_ACTOR;
        }

        position = position - 1; // actor index

        if (actor.getMovies().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }

            position = position - 1; // movie title index

            if( position < actor.getMovies().size()) {
                return VIEW_TYPE_MOVIE;
            }

            position = position - actor.getMovies().size();
        }

        if (actor.getDramas().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }

            position = position - 1; // drama title index

            if( position < actor.getDramas().size()) {
                return VIEW_TYPE_DRAMA;
            }

            position = position - actor.getDramas().size();
        }

        if (actor.getComments().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }

            position = position - 1; // comment title index

            if( position < actor.getComments().size()) {
                return VIEW_TYPE_COMMENT;
            }

            position = position - actor.getComments().size();
        }

        return VIEW_TYPE;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        if (position == 0) {
            return actor;
        }

        position = position - 1;

        if (actor.getMovies().size() > 0) {
            if (position == 0) {
                return "Model ..."; // movie's title
            }

            position = position - 1 ;

            if (position < actor.getMovies().size()) {
                return actor.getMovies().get(position);
            }

            position = position - actor.getMovies().size();
        }

        if (actor.getDramas().size() > 0) {
            if (position == 0) {
                return "Model ..."; // drama's title
            }

            position = position - 1 ;

            if (position < actor.getDramas().size()) {
                return actor.getDramas().get(position);
            }

            position = position - actor.getDramas().size();
        }

        if (actor.getComments().size() > 0) {
            if (position == 0) {
                return "Model ..."; // comment's title
            }

            position = position - 1 ;

            if (position < actor.getComments().size()) {
                return actor.getComments().get(position);
            }

            position = position - actor.getComments().size();
        }
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_MAX;
    }

    @Override
    public int getCount() {
        int count = 0;

        // title 갯수 빼기
        if (actor == null) {
            return 0;
        }
        else {
            count = count + 1;
        }

        if (actor.getComments().size() > 0) {
            // 1 : title 갯수
            count = count + (1 + actor.getComments().size() );
        }

        if (actor.getDramas().size() > 0) {
            // 1 : title 갯수
            count = count + (1 + actor.getDramas().size() );
        }

        if (actor.getMovies().size() > 0) {
            // 1 : title 갯수
            count = count + (1 + actor.getMovies().size() );
        }

        return count;
    }


}
