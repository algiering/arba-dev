package com.arba.pt3listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private ListView list_view;

    private EditText edit_name, edit_number, edit_department, edit_item;

    private ArrayList<PersonData> items;
    private ArrayList<PersonData> temp_items;

    private ItemArrayAdaptor adapter;
    private ItemArrayAdaptor temp_adapter;

    private int search_stmt = 0;
    private int radio_stmt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_view = findViewById(R.id.list_view);

        Button btn_add = findViewById(R.id.btn_add);
        Button btn_search = findViewById(R.id.btn_search);
        Button btn_sort = findViewById(R.id.btn_sort);
        Button btn_del = findViewById(R.id.btn_del);
        Button btn_all_del = findViewById(R.id.btn_all_del);
        Button btn_init = findViewById(R.id.btn_init);

        edit_name = findViewById(R.id.edit_name);
        edit_number = findViewById(R.id.edit_number);
        edit_department = findViewById(R.id.edit_department);
        edit_item = findViewById(R.id.edit_item);

        Spinner spinner = findViewById(R.id.spinner);

        RadioGroup radio_sort = findViewById(R.id.radio_sort);

        items = new ArrayList<>();
        adapter = new ItemArrayAdaptor(this, R.layout.view_person, items);

        list_view.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        list_view.setAdapter(adapter);

        for (int i = 0; i < 5; i++) {
            adapter.addItem("aaa " + i, i, "aaa " + i);
        }
        for (int i = 0; i < 5; i++) {
            adapter.addItem("bbb " + i, i, "bbb " + i);
        }

        ArrayAdapter adapter_spinner = ArrayAdapter.createFromResource(this, R.array.str_arrays, android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(adapter_spinner);

        InnerListener il = new InnerListener();
        btn_add.setOnClickListener(il);
        btn_search.setOnClickListener(il);
        btn_del.setOnClickListener(il);
        btn_all_del.setOnClickListener(il);
        btn_sort.setOnClickListener(il);
        btn_init.setOnClickListener(il);

        spinner.setOnItemSelectedListener(il);

        radio_sort.setOnCheckedChangeListener(il);

        list_view.setOnItemLongClickListener(il);

        temp_items = new ArrayList<>();
        temp_adapter = new ItemArrayAdaptor(MainActivity.this, R.layout.view_person, temp_items);

    }


    // Listener Area
    private class InnerListener implements View.OnClickListener, Spinner.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, ListView.OnItemLongClickListener {
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
                    String temp = edit_item.getText().toString();
                    temp_items.clear();

                    if (search_stmt == 0) {
                        int temp_chk = -1;
                        for (int i = 0; i < items.size(); i++) {
                            temp_chk = SearchStudent(i, temp_chk, items.get(i).getName().contains(temp));
                        }
                        if (temp_chk == -1) {
                            Toast.makeText(MainActivity.this, "일치하는 데이터가 없습니다", Toast.LENGTH_SHORT).show();
                        }
                    } else if (search_stmt == 1) {
                        int temp_chk = -1;
                        for (int i = 0; i < items.size(); i++) {
                            temp_chk = SearchStudent(i, temp_chk, String.valueOf(items.get(i).getNumber()).contains(temp));
                        }
                        if (temp_chk == -1) {
                            Toast.makeText(MainActivity.this, "일치하는 데이터가 없습니다", Toast.LENGTH_SHORT).show();
                        }

                    } else if (search_stmt == 2) {
                        int temp_chk = -1;
                        for (int i = 0; i < items.size(); i++) {
                            temp_chk = SearchStudent(i, temp_chk, items.get(i).getDepartment().contains(temp));
                        }
                        if (temp_chk == -1) {
                            Toast.makeText(MainActivity.this, "일치하는 데이터가 없습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;

                case R.id.btn_sort:
                    if (temp_items.isEmpty()) {
                        temp_items.addAll(items);
                    }
                    if (radio_stmt == 0) {
                        Compare compare = new Compare();
                        Collections.sort(temp_items, compare);
                    } else if (radio_stmt == 1) {
                        Compare_Reverse compare_reverse = new Compare_Reverse();
                        Collections.sort(temp_items, compare_reverse);
                    }
                    list_view.setAdapter(temp_adapter);
                    temp_adapter.notifyDataSetChanged();
                    break;

                case R.id.btn_del:
                    SparseBooleanArray check_selected_position = list_view.getCheckedItemPositions();

                    for (int i = items.size()-1; i >= 0; i--) {
                        if (check_selected_position.get(i)) {
                            items.remove(i);
                        }
                    }

                    list_view.clearChoices();
                    adapter.notifyDataSetChanged();
                    break;

                case R.id.btn_all_del:
                    items.clear();
                    adapter.notifyDataSetChanged();
                    break;

                case R.id.btn_init:
                    if (!items.isEmpty()) {
                        list_view.setAdapter(adapter);
                        if (!temp_items.isEmpty()) {
                            temp_items.clear();
                        }
                    }
                    break;
            }
        }

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

    // Custom Method Area

    private int SearchStudent (int i, int temp_chk, boolean searchType) {

        if (searchType) {
            temp_adapter.addItem(items.get(i).getName(), items.get(i).getNumber(), items.get(i).getDepartment());
            list_view.setAdapter(temp_adapter);
            temp_chk = 1;
        }

        return  temp_chk;
    }
}
