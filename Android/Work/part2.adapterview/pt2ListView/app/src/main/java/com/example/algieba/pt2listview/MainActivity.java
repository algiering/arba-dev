package com.example.algieba.pt2listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtStNum, edtDepart, edtItemNum;
    private Button btnAddSt, btnItemDel, btnItemAllDel, btnItemSort;

    private ListView listView;
    private ListViewAdapter adapter;
    private ArrayList<PersonData> itemList;
    private PersonData p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = new ArrayList<PersonData>();
        adapter = new ListViewAdapter(this, R.layout.view_person, itemList);

        p = new PersonData("aaaa", "1", "aaaa");
        itemList.add(p);
        p = new PersonData("bbbb", "2", "bbbb");
        itemList.add(p);
        p = new PersonData("cccc", "3", "cccc");
        itemList.add(p);
        p = new PersonData("dddd", "4", "dddd");
        itemList.add(p);
        p = new PersonData("eeee", "5", "eeee");
        itemList.add(p);
        p = new PersonData("ffff", "6", "ffff");
        itemList.add(p);
        p = new PersonData("gggg", "7", "gggg");
        itemList.add(p);


        listView = findViewById(R.id.listView);

        listView.setAdapter(adapter);
    }
}
