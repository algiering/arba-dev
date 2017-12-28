package com.arba.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtStNum, edtDepart, edtItemNum;
    private Button btnAddSt, btnItemDel, btnItemAllDel, btnItemSort;
    private ListView listView;

    private List<>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtStNum = findViewById(R.id.edtStNum);
        edtDepart = findViewById(R.id.edtDepart);
        edtItemNum = findViewById(R.id.edtItemNum);

        btnAddSt = findViewById(R.id.btnAddSt);
        btnItemDel = findViewById(R.id.btnItemDel);
        btnItemAllDel = findViewById(R.id.btnItemAllDel);
        btnItemSort = findViewById(R.id.btnItemSort);

        listView = findViewById(R.id.listView);



    }
}
