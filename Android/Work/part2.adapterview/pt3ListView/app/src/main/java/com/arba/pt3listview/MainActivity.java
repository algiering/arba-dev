package com.arba.pt3listview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView list_view;

    private EditText edit_name, edit_number, edit_department, edit_item;

    private ArrayList<PersonData> items;
    private ArrayList<PersonData> temp_items;

    private ItemArrayAdaptor adapter;
    private ItemArrayAdaptor temp_adapter;

    private int search_stmt = 0;
    private int radio_stmt = 0;

    private int ukey = 1;

    private Spinner spinner;

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

        spinner = findViewById(R.id.spinner);

        RadioGroup radio_sort = findViewById(R.id.radio_sort);

        items = new ArrayList<>();
        adapter = new ItemArrayAdaptor(this, R.layout.view_person, items);

        list_view.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        list_view.setAdapter(adapter);

        for (int i = 0; i < 7; i++) {
            adapter.addItem("aaa " + i, i, "aaa " + i, ukey);
            ukey++;
        }
        for (int i = 0; i < 7; i++) {
            adapter.addItem("bbb " + i, i, "bbb " + i, ukey);
            ukey++;
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
                        items.add(new PersonData(name, number, department, ukey));
                        ukey++;

                        edit_name.setText("");
                        edit_number.setText("");
                        edit_department.setText("");

                        adapter.notifyDataSetChanged();

                        list_view.smoothScrollToPosition(items.size() - 1);

                        break;
                    }

                case R.id.btn_search:
                    // 0이름 1번호 2학과
                    String searchitem = getFieldName(spinner.getSelectedItem().toString());
                    String searchvalue = edit_item.getText().toString();
//
//                    PersonData.MyPredicateContains predicate = new PersonData.MyPredicateContains(searchitem, searchvalue);
//                    List<PersonData> result = (List<PersonData>) CollectionUtils.select(items, predicate);
//                    adapter.clear();
//                    adapter.addAll(result);

                    final String search = edit_item.getText().toString();
                    List<PersonData> result = new ArrayList<>();
                    for (PersonData e : items) {
                        if (e.getName().contains(search)) {
                            result.add(e);
                        }
                    }

                    adapter.clear();
                    adapter.addAll(result);

                    temp_items.clear();
                    PersonData.MyPredicateContains predicate = new PersonData.MyPredicateContains(searchitem, searchvalue);
                    temp_items.addAll((ArrayList<PersonData>) CollectionUtils.select(items, predicate));
                    list_view.setAdapter(temp_adapter);
                    temp_adapter.notifyDataSetChanged();
                    break;

                case R.id.btn_sort:
                    // 0이름 1번호 2학과
                    if (temp_items.isEmpty()) {
                        temp_items.addAll(items);
                    }

                    boolean mode = false;

                    if (radio_stmt == 0) {
                        mode = false;
                    } else if (radio_stmt == 1) {
                        mode = true;
                    }

                    if (search_stmt == 0) {
                        PersonData.NameCompare compare = new PersonData.NameCompare(mode);
                        Collections.sort(temp_items, compare);
                    } else if (search_stmt == 1) {
                        PersonData.NumberCompare compare = new PersonData.NumberCompare(mode);
                        Collections.sort(temp_items, compare);
                    } else if (search_stmt == 2) {
                        PersonData.DeptCompare compare = new PersonData.DeptCompare(mode);
                        Collections.sort(temp_items, compare);
                    }
                    list_view.setAdapter(temp_adapter);
                    temp_adapter.notifyDataSetChanged();
                    break;

                case R.id.btn_del:

                    if (temp_items.size() > 0) {
                        SparseBooleanArray check_selected_position_temp = list_view.getCheckedItemPositions();

                        for (int i = temp_items.size() - 1; i >= 0; i--) {
                            if (check_selected_position_temp.get(i)) {
                                for (int j = items.size() - 1; j >= 0; j--) {
                                    if (temp_items.get(i).getUkey() == items.get(j).getUkey()) {
                                        items.remove(j);
                                    }
                                }
                                temp_items.remove(i);
                            }
                        }
                    } else {

                        SparseBooleanArray check_selected_position = list_view.getCheckedItemPositions();

                        for (int i = items.size() - 1; i >= 0; i--) {
                            if (check_selected_position.get(i)) {
                                items.remove(i);
                            }
                        }
                    }

                    list_view.clearChoices();
                    adapter.notifyDataSetChanged();
                    temp_adapter.notifyDataSetChanged();
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
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("삭제");
            alert.setMessage("정말로 삭제하시겠습니까?");
            alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (!temp_items.isEmpty()) {
                        for (int i = items.size() - 1; i >= 0; i--) {
                            if (temp_items.get(position).getUkey() == items.get(i).getUkey()) {
                                temp_items.remove(i);
                                items.remove(i);
                            }
                        }
                    } else {
                        items.remove(position);
                    }
                    adapter.notifyDataSetChanged();
                    temp_adapter.notifyDataSetChanged();
                    list_view.clearChoices();
                }
            }).setNegativeButton("취소", null);
            alert.show();


            adapter.notifyDataSetChanged();
            temp_adapter.notifyDataSetChanged();
            return false;
        }
    }

    // Custom Method Area

    private int SearchStudent(int i, int temp_chk, boolean searchType) {

        if (searchType) {
            temp_adapter.addItem(items.get(i).getName(), items.get(i).getNumber(), items.get(i).getDepartment(), items.get(i).getUkey());
            list_view.setAdapter(temp_adapter);
            temp_chk = 1;
        }

        return temp_chk;
    }

    private String getFieldName(String selectedItem) {
        if (selectedItem.equals("이름")) {
            return "name";
        } else if (selectedItem.equals("학번")) {
            return "number";
        } else if (selectedItem.equals("학과")) {
            return "department";
        } else return "";
    }
}
