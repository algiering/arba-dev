package com.example.algieba.pt2listview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtStNum, edtDepart, edtItemNum;
    private Button btnAddSt, btnItemDel, btnItemAllDel, btnItemSort;

    private ListView listView;
    private ListViewAdapter adapter;
    private ArrayList<PersonData> itemList;

    private int temp = 0;

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

        itemList = new ArrayList<PersonData>();
        adapter = new ListViewAdapter(this, R.layout.view_person, itemList);

        listView = findViewById(R.id.listView);

        listView.setAdapter(adapter);

        listView.setDivider(new ColorDrawable(Color.GRAY));
        listView.setDividerHeight(3);

        ButtonInner bi = new ButtonInner();

        btnAddSt.setOnClickListener(bi);
        btnItemDel.setOnClickListener(bi);
        btnItemAllDel.setOnClickListener(bi);
        btnItemSort.setOnClickListener(bi);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                temp = position;
                edtItemNum.setText(String.valueOf(temp));
            }
        });
    }

    private class ButtonInner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAddSt:
                    String name;
                    int num;
                    String comp;

                    if (edtName.getText().toString().equals("")||edtStNum.getText().toString().equals("")||edtDepart.getText().toString().equals("")) {
                        break;
                    }

                    name = edtName.getText().toString();
                    num = Integer.parseInt(edtStNum.getText().toString());
                    comp = edtDepart.getText().toString();

                    edtName.setText("");
                    edtStNum.setText("");
                    edtDepart.setText("");

                    adapter.addItem(name, num, comp);
                    adapter.notifyDataSetChanged();
                    break;

                case R.id.btnItemDel:
                    if(edtItemNum.getText().toString().isEmpty()) {
                        break;
                    }
                    temp = Integer.parseInt(edtItemNum.getText().toString());
                    if(temp!=1) {
                        temp = temp -1;
                    }
                    else if(temp == 1) {
                        temp = 0;
                    }
                    itemList.remove(temp);
                    edtItemNum.setText("");
                    adapter.notifyDataSetChanged();
                    temp = -1;
                    break;

                case R.id.btnItemAllDel:
                    itemList.removeAll(itemList);
                    edtItemNum.setText("");
                    adapter.notifyDataSetChanged();
                    break;

                case R.id.btnItemSort:
                    Compare compare = new Compare();
                    Collections.sort(itemList, compare);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }

    private class Compare implements Comparator<PersonData> {

        @Override
        public int compare(PersonData o1, PersonData o2) {
            int t1 = o1.getNum();
            int t2 = o2.getNum();

            if (t1 < t2) {
                return -1;
            } else if (t2 > t1) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
