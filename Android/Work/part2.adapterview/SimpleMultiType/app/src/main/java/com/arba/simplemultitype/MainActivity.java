package com.arba.simplemultitype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview1;

    private List<ModelItem> list;
    private AdapterItem adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview1 = findViewById(R.id.listview1);

        list = makeData();

        adapter = new AdapterItem(MainActivity.this, -1, list);

        listview1.setAdapter(adapter);
    }

    private List<ModelItem> makeData() {
        List<ModelItem> list = new ArrayList<>();
        list.add(new ModelItem("title1", "desc1"));
        list.add(new ModelItem("name1", getResources().getDrawable(R.drawable.sample_1)));
        list.add(new ModelItem("name2", getResources().getDrawable(R.drawable.sample_2)));
        list.add(new ModelItem("title2", "desc2"));
        list.add(new ModelItem("title3", "desc3"));
        list.add(new ModelItem("name3", getResources().getDrawable(R.drawable.sample_3)));
        list.add(new ModelItem("name4", getResources().getDrawable(R.drawable.sample_4)));
        list.add(new ModelItem("title4", "desc4"));
        list.add(new ModelItem("name5", getResources().getDrawable(R.drawable.sample_5)));
        list.add(new ModelItem("title5", "desc5"));

        return list;
    }
}
