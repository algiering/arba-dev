package com.arba.multitypelistview.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.arba.multitypelistview.R;
import com.arba.multitypelistview.adapter.AdapterActor;
import com.arba.multitypelistview.model.ModelActor;
import com.arba.multitypelistview.model.ModelComment;
import com.arba.multitypelistview.model.ModelDrama;
import com.arba.multitypelistview.model.ModelMovie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private AdapterActor adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        ModelActor datas = makeData();

        adapter = new AdapterActor(MainActivity.this);

        adapter.setActor(datas);

        listView.setAdapter(adapter);
    }

    private ModelActor makeData() {
        ModelActor actor = new ModelActor();

        actor.setImagePhoto(getResources().getDrawable(R.drawable.sample_0));
        actor.setTextAge("42");
        actor.setTextName("ysi");
        actor.setTextDescription("desc.......");

        List<ModelMovie> movies = new ArrayList<>();
        movies.add(new ModelMovie(getResources().getDrawable(R.drawable.sample_1), "movie title 1", "2015"));
        movies.add(new ModelMovie(getResources().getDrawable(R.drawable.sample_2), "movie title 2", "2016"));
        movies.add(new ModelMovie(getResources().getDrawable(R.drawable.sample_3), "movie title 3", "2017"));
        actor.setMovies(movies);

        List<ModelDrama> dramas = new ArrayList<>();
        dramas.add(new ModelDrama(getResources().getDrawable(R.drawable.sample_4), "drama title 4", "1-2"));
        dramas.add(new ModelDrama(getResources().getDrawable(R.drawable.sample_5), "drama title 5", "1-3"));
        actor.setDramas(dramas);

        List<ModelComment> comments = new ArrayList<>();
        comments.add(new ModelComment("comments ... 1", "writer 1"));
        comments.add(new ModelComment("comments ... 1", "writer 1"));
        actor.setComments(comments);

        return actor;
    }
}
