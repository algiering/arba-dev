package com.arba.pt3listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private ListView list_view;

    private Button btn_add, btn_search, btn_sort, btn_del, btn_all_del, btn_init;
    private EditText edit_name, edit_number, edit_department, edit_item;
    private RadioGroup radio_sort;
    private RadioButton radioButton1, radioButton2;
    private Spinner spinner;

    private ArrayList<PersonData> items;
    private ArrayList<PersonData> temp_items;

    private ArrayAdapter adapter_spinner;

    private ItemArrayAdaptor adapter;

    private int search_stmt = 0;
    private int radio_stmt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_view = findViewById(R.id.list_view);

        btn_add = findViewById(R.id.btn_add);
        btn_search = findViewById(R.id.btn_search);
        btn_sort = findViewById(R.id.btn_sort);
        btn_del = findViewById(R.id.btn_del);
        btn_all_del = findViewById(R.id.btn_all_del);
        btn_init = findViewById(R.id.btn_init);

        edit_name = findViewById(R.id.edit_name);
        edit_number = findViewById(R.id.edit_number);
        edit_department = findViewById(R.id.edit_department);
        edit_item = findViewById(R.id.edit_item);

        spinner = findViewById(R.id.spinner);

        radio_sort = findViewById(R.id.radio_sort);

        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);

        radioButton1.setChecked(true);

        items = new ArrayList<PersonData>();
        adapter = new ItemArrayAdaptor(this, R.layout.view_person, items);

        list_view.setAdapter(adapter);

        for (int i = 0; i < 10; i++) {
            adapter.addItem("aaa " + i, i, "aaa " + i);
        }

        adapter_spinner = ArrayAdapter.createFromResource(this, R.array.str_arrays, android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(adapter_spinner);

        ButtonInner bi = new ButtonInner();
        btn_add.setOnClickListener(bi);
        btn_search.setOnClickListener(bi);
        btn_del.setOnClickListener(bi);
        btn_all_del.setOnClickListener(bi);
        btn_sort.setOnClickListener(bi);
        btn_init.setOnClickListener(bi);

        SpinnerInner si = new SpinnerInner();
        spinner.setOnItemSelectedListener(si);

        RadioInner ri = new RadioInner();
        radio_sort.setOnCheckedChangeListener(ri);

        ListViewInner li = new ListViewInner();
        list_view.setOnItemLongClickListener(li);
    }


    // Listner Area
    private class ButtonInner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_add:

                    if (edit_department.getText().toString().equals("") || edit_number.getText().toString().equals("") || edit_department.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "데이터를 모두 입력해야 합니다", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if (!(edit_number.getText().toString().matches(".*[0-9].*"))) {
                        Toast.makeText(MainActivity.this, "학번에는 숫자만 입력해야 합니다", Toast.LENGTH_SHORT).show();
                        edit_number.setText("");
                        break;
                    } else {
                        String name = edit_name.getText().toString();
                        int number = Integer.parseInt(edit_number.getText().toString());
                        String department = edit_department.getText().toString();
                        items.add(new PersonData(name, number, department));

                        edit_name.setText("");
                        edit_number.setText("");
                        edit_department.setText("");

                        adapter.notifyDataSetChanged();

                        list_view.smoothScrollToPosition(items.size() - 1);

                        break;
                    }

                case R.id.btn_search:
                    // 0이름 1번호 2학과
                    temp_items = new ArrayList<PersonData>();
                    ItemArrayAdaptor temp_adapter = new ItemArrayAdaptor(MainActivity.this, R.layout.view_person, temp_items);
                    PersonData temp_p = new PersonData();

                    if (search_stmt == 0) {
                        int temp_chk = -1;
                        String temp = edit_item.getText().toString();
                        for (int i = 0; i < items.size(); i++) {
                            if (items.get(i).getName().contains(temp)) {
                                temp_adapter.addItem(items.get(i).getName(), items.get(i).getNumber(), items.get(i).getDepartment());
                                list_view.setAdapter(temp_adapter);
                                temp_chk = 1;
                            }
                        }
                        if (temp_chk == -1) {
                            Toast.makeText(MainActivity.this, "일치하는 데이터가 없습니다", Toast.LENGTH_SHORT).show();
                        }
                    } else if (search_stmt == 1) {
                        int temp_chk = -1;
                        String temp = edit_item.getText().toString();
                        for (int i = 0; i < items.size(); i++) {
                            if (String.valueOf(items.get(i).getNumber()).contains(temp)) {
                                temp_adapter.addItem(items.get(i).getName(), items.get(i).getNumber(), items.get(i).getDepartment());
                                list_view.setAdapter(temp_adapter);
                                temp_chk = 1;
                            }
                        }
                        if (temp_chk == -1) {
                            Toast.makeText(MainActivity.this, "일치하는 데이터가 없습니다", Toast.LENGTH_SHORT).show();
                        }

                    } else if (search_stmt == 2) {
                        int temp_chk = -1;
                        String temp = edit_item.getText().toString();
                        for (int i = 0; i < items.size(); i++) {
                            if (items.get(i).getDepartment().contains(temp)) {
                                temp_adapter.addItem(items.get(i).getName(), items.get(i).getNumber(), items.get(i).getDepartment());
                                list_view.setAdapter(temp_adapter);
                                temp_chk = 1;
                            }
                        }
                        if (temp_chk == -1) {
                            Toast.makeText(MainActivity.this, "일치하는 데이터가 없습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;

                case R.id.btn_sort:
                    if (radio_stmt == 0) {
                        Compare compare = new Compare();
                        Collections.sort(items, compare);
                    } else if (radio_stmt == 1) {
                        Compare_Reverse compare_reverse = new Compare_Reverse();
                        Collections.sort(items, compare_reverse);
                    }
                    adapter.notifyDataSetChanged();
                    break;

                case R.id.btn_del:
                    break;

                case R.id.btn_all_del:
                    items.removeAll(items);
                    adapter.notifyDataSetChanged();
                    break;

                case R.id.btn_init:
                    if (!items.isEmpty()) {
                        list_view.setAdapter(adapter);
                        temp_items.removeAll(temp_items);
                    }
                    break;
            }
        }
    }

    private class SpinnerInner implements Spinner.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            // 0이름 1번호 2학과
            switch (position) {
                case 0:
                    search_stmt = 0;
                    break;

                case 1:
                    search_stmt = 1;
                    break;

                case 2:
                    search_stmt = 2;
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class RadioInner implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getCheckedRadioButtonId()) {
                case R.id.radioButton1:
                    radio_stmt = 0;
                    break;

                case R.id.radioButton2:
                    radio_stmt = 1;
                    break;
            }
        }
    }

    private class ListViewInner implements ListView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            items.remove(position);
            adapter.notifyDataSetChanged();
            return false;
        }
    }


//    Object Arraylist Sort Method Area
    private class Compare implements Comparator<PersonData> {

        @Override
        public int compare(PersonData o1, PersonData o2) {

            int t1 = o1.getNumber();
            int t2 = o2.getNumber();

            if (t1 < t2) {
                return -1;
            } else if (t2 > t1) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private class Compare_Reverse implements Comparator<PersonData> {

        @Override
        public int compare(PersonData o1, PersonData o2) {

            int t1 = o1.getNumber();
            int t2 = o2.getNumber();

            if (t1 > t2) {
                return -1;
            } else if (t2 < t1) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
