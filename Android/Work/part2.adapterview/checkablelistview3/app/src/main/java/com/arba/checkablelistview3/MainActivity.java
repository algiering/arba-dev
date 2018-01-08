package com.arba.checkablelistview3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list_view;
    private AdapterPerson adapter;
    private List<ModelPerson> list;
    private int[] images = {
             R.drawable.sample_0
            ,R.drawable.sample_1
            ,R.drawable.sample_2
            ,R.drawable.sample_3
            ,R.drawable.sample_4
            ,R.drawable.sample_5
            ,R.drawable.sample_6
            ,R.drawable.sample_7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_view = findViewById(R.id.list_view);

        list = makeData();

        adapter = new AdapterPerson(MainActivity.this, R.layout.view_person, list);

        list_view.setAdapter(adapter);

    }

    private List<ModelPerson> makeData() {
        List<ModelPerson> items = new ArrayList<>();

        ModelPerson person;
        for ( int i = 0; i <20; i++) {
            person = new ModelPerson();
            person.setImageCheck(false);
            person.setTextName("name"+i);
            person.setTextAge(i+"");
            person.setImagePhoto(getResources().getDrawable(images[i%images.length]));

            items.add(person);
        }
        return items;
    }
}
