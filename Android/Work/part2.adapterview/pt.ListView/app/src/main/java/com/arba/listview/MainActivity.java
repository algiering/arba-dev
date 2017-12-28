package com.arba.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtStNum, edtDepart, edtItemNum;
    private Button btnAddSt, btnItemDel, btnItemAllDel, btnItemSort;
    private ListView listView;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ListViewAdapter();

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        edtName = findViewById(R.id.edtName);
        edtStNum = findViewById(R.id.edtStNum);
        edtDepart = findViewById(R.id.edtDepart);
        edtItemNum = findViewById(R.id.edtItemNum);

        btnAddSt = findViewById(R.id.btnAddSt);
        btnItemDel = findViewById(R.id.btnItemDel);
        btnItemAllDel = findViewById(R.id.btnItemAllDel);
        btnItemSort = findViewById(R.id.btnItemSort);

        adapter.addItem("aaaa", "1", "aaaa");
        adapter.addItem("bbbb", "2", "bbbb");
        adapter.addItem("cccc", "3", "cccc");
        adapter.addItem("dddd", "4", "dddd");
        adapter.addItem("eeee", "5", "eeee");
        adapter.addItem("ffff", "6", "ffff");
        adapter.addItem("gggg", "7", "gggg");
    }
}
