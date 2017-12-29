package com.arba.listviewsample;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private EditText editText1;
    private Button button1;
    private ListView listView1;
    private List<String> items;
    private ArrayAdapter<String> adapterList;

    private EditText edtValue;
    private Button btnAdd;
    private Button btnModify;
    private Button btnDelete;

    private String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        editText1 = findViewById(R.id.editText1);
        button1 = findViewById(R.id.button1);
        listView1 = findViewById(R.id.listView1);

        items = new ArrayList<>();
        items.addAll(Arrays.asList(getResources().getStringArray(R.array.items)));
        adapterList = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_multiple_choice, items);

        listView1.setAdapter(adapterList);
        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView1.setDivider(new ColorDrawable(Color.GRAY));
        listView1.setDividerHeight(3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = editText1.getText().toString();
                if (!TextUtils.isEmpty(temp)) {
                    adapterList.add(temp);
                    listView1.smoothScrollToPosition(items.size() - 1);
                }
            }
        });

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView1.setText(((TextView) view).getText().toString());
            }
        });

        //

        edtValue = findViewById(R.id.edtValue);
        btnAdd = findViewById(R.id.btnAdd);
        btnModify = findViewById(R.id.btnModify);
        btnDelete = findViewById(R.id.btnDelete);

        ButtonInner bi = new ButtonInner();

        button1.setOnClickListener(bi);
        btnAdd.setOnClickListener(bi);
        btnModify.setOnClickListener(bi);
        btnDelete.setOnClickListener(bi);
    }

    private class ButtonInner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    temp = editText1.getText().toString();
                    if (!TextUtils.isEmpty(temp)) {
                        adapterList.add(temp);
                        listView1.smoothScrollToPosition(items.size() - 1);
                    }
                    break;

                case R.id.btnAdd:
                    temp = edtValue.getText().toString();
                    if (!TextUtils.isEmpty(temp)) {
                        items.add(temp);
                        adapterList.notifyDataSetChanged();
                        listView1.smoothScrollToPosition(items.size() - 1);
                    }
                    break;

                case R.id.btnModify:
                    temp = edtValue.getText().toString();
                    if (!TextUtils.isEmpty(temp)) {
                        SparseBooleanArray chktemp = listView1.getCheckedItemPositions();
                        for (int i = items.size()-1; i >= 0 ; i--) {
                            if(chktemp.get(i)==true) {
                                items.set(i, temp);
                            }
                        }
                    }
                    adapterList.notifyDataSetChanged();
                    break;

                case R.id.btnDelete: {
                    if(!items.isEmpty()) {
                        SparseBooleanArray chktemp = listView1.getCheckedItemPositions();
                        for (int i = items.size()-1; i >= 0 ; i--) {
                            if(chktemp.get(i)==true) {
                                items.remove(i);
                            }
                        }
                        listView1.clearChoices();
                        adapterList.notifyDataSetChanged();
                    }
                    break;
                }
            }
        }
    }
}
