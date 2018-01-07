package com.arba.checkablelistview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private Button button_search;
    private EditText edit_search;

    AdapterPerson adapter;
    private ArrayList<ModelPerson> list;
    private int[] imagesIds = {
            R.drawable.sample_0
            , R.drawable.sample_1
            , R.drawable.sample_2
            , R.drawable.sample_3
            , R.drawable.sample_4
            , R.drawable.sample_5
            , R.drawable.sample_6
            , R.drawable.sample_7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);
        listview.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        final View headerView = LayoutInflater.from(MainActivity.this).inflate(R.layout.view_header, null);

        edit_search = headerView.findViewById(R.id.edit_search);
        button_search = headerView.findViewById(R.id.button_search);

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit_search.getText().toString();
                if (!text.isEmpty()) {
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                }
            }
        });

        initData();
        adapter = new AdapterPerson(MainActivity.this, R.layout.view_person, list);

        listview.addHeaderView(headerView);
        listview.setAdapter(adapter);

    }

    private void initData() {
        list = new ArrayList<ModelPerson>();

        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            ModelPerson person = new ModelPerson();
            person.setName("name" + i);
            person.setAge(20 + r.nextInt(30));
            person.setPhoto(getResources().getDrawable(imagesIds[i % imagesIds.length], null));

            list.add(person);
        }
    }
}
