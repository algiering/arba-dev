package com.arba.checkablecustomlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ModelDog> list;
    private CustomAdapter adapter;

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);

        list = new ArrayList<>();

        View header = getLayoutInflater().inflate(R.layout.view_header, null, false);

        listview.addHeaderView(header);

        adapter = new CustomAdapter(this, R.layout.view_custom, list);

        for (int i = 0; i < 20; i++) {
            adapter.add(new ModelDog("abo"+i, i, getResources().getDrawable(R.drawable.pic1),false));
        }

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), String.valueOf(list.get(position-listview.getHeaderViewsCount()).isCheck()), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
