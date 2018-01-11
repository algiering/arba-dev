package com.arba.multitypelistview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arba.multitypelistview.model.ModelActor;
import com.arba.multitypelistview.model.ModelComment;
import com.arba.multitypelistview.model.ModelDrama;
import com.arba.multitypelistview.model.ModelMovie;
import com.arba.multitypelistview.view.ActorView;
import com.arba.multitypelistview.view.CommentView;
import com.arba.multitypelistview.view.DramaView;
import com.arba.multitypelistview.view.MovieView;

import java.util.List;

/**
 * Created by Administrator on 2018-01-09.
 */

public class AdapterActor extends ArrayAdapter {


    private final Context context;
    private final LayoutInflater inflater;

    public static final int VIEW_TYPE_ACTOR = 0;
    public static final int VIEW_TYPE_TITLE = 1;
    public static final int VIEW_TYPE_MOVIE = 2;
    public static final int VIEW_TYPE_DRAMA = 3;
    public static final int VIEW_TYPE_COMMENT = 4;

    public static final int VIEW_TYPE_MAX = 5;

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
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (position == 0) {
            ActorView view = null;
            // convertView와 ActorView의 타입이 같은지 검증
            if (convertView != null && convertView instanceof ActorView) {
                view = (ActorView) convertView;
            } else {
                view = new ActorView(parent.getContext());
            }

            view.setActor(actor);

            return view;
        }

        position = position - 1;

        if (actor.getMovies().size() > 0) {
            if (position == 0) { // title
                TextView view = null;
                if (convertView != null && convertView instanceof TextView) {
                    view = (TextView) convertView;
                } else {
                    view = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                }
                view.setText("Movies ...");
                return view;
            }

            position = position - 1;

            if (position < actor.getMovies().size()) {
                MovieView view = null;

                if (convertView != null && convertView instanceof MovieView) {
                    view = (MovieView) convertView;
                } else {
                    view = new MovieView(parent.getContext());
                }

                ModelMovie m = actor.getMovies().get(position);
                view.setMovie(m);

                return view;
            }

            position = position - actor.getMovies().size();
        }


        if (actor.getDramas().size() > 0) {
            if (position == 0) { // title
                TextView view = null;
                if (convertView != null && convertView instanceof TextView) {
                    view = (TextView) convertView;
                } else {
                    view = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
                }
                view.setText("Dramas ...");
                return view;
            }

            position = position - 1;

            if (position < actor.getDramas().size()) {
                DramaView view = null;

                if (convertView != null && convertView instanceof DramaView) {
                    view = (DramaView) convertView;
                } else {
                    view = new DramaView(parent.getContext());
                }

                ModelDrama d = actor.getDramas().get(position);
                view.setDrama(d);

                return view;
            }

            position = position - actor.getDramas().size();
        }

        if (actor.getComments().size() > 0) {
            if (position == 0) { // title
                TextView view = null;

                if (convertView != null && convertView instanceof TextView) {
                    view = (TextView) convertView;

                    }
                else {
//                    view = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
//                    view.setText("Comments ...");

                    view = new TextView(parent.getContext());

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    view.setLayoutParams(params);
                    view.setGravity(Gravity.CENTER_VERTICAL);
                }
                view.setText("Comments ...");
                return view;
            }

            position = position - 1;

            if (position < actor.getComments().size()) {
                CommentView view = null;

                if (convertView != null && convertView instanceof CommentView) {
                    view = (CommentView) convertView;
                }
                else {
                    view = new CommentView(parent.getContext());
                }

                ModelComment c = actor.getComments().get(position);
                view.setComment(c);

                return view;
            }

            position = position - actor.getComments().size();
        }

        throw  new IllegalArgumentException("Invalid position");
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

            if (position < actor.getMovies().size()) {
                return VIEW_TYPE_MOVIE;
            }

            position = position - actor.getMovies().size();
        }

        if (actor.getDramas().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }

            position = position - 1; // drama title index

            if (position < actor.getDramas().size()) {
                return VIEW_TYPE_DRAMA;
            }

            position = position - actor.getDramas().size();
        }

        if (actor.getComments().size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_TITLE;
            }

            position = position - 1; // comment title index

            if (position < actor.getComments().size()) {
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

            position = position - 1;

            if (position < actor.getMovies().size()) {
                return actor.getMovies().get(position);
            }

            position = position - actor.getMovies().size();
        }

        if (actor.getDramas().size() > 0) {
            if (position == 0) {
                return "Model ..."; // drama's title
            }

            position = position - 1;

            if (position < actor.getDramas().size()) {
                return actor.getDramas().get(position);
            }

            position = position - actor.getDramas().size();
        }

        if (actor.getComments().size() > 0) {
            if (position == 0) {
                return "Model ..."; // comment's title
            }

            position = position - 1;

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
        } else {
            count = count + 1;
        }

        if (actor.getComments().size() > 0) {
            // 1 : title 갯수
            count = count + (1 + actor.getComments().size());
        }

        if (actor.getDramas().size() > 0) {
            // 1 : title 갯수
            count = count + (1 + actor.getDramas().size());
        }

        if (actor.getMovies().size() > 0) {
            // 1 : title 갯수
            count = count + (1 + actor.getMovies().size());
        }

        return count;
    }


}
