package com.arba.adapterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textview1;
    private Spinner spinner1;
    private AutoCompleteTextView autocomplete;
    private ListView listview1;
    private String[] items = {"1", "2", "3", "4", "5"};
    private String[] months = {"January", "February", "March", "April", "May", "June" ,
            "July", "August", "September", "October", "November", "December"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview1 = findViewById(R.id.textview1);
        spinner1 = findViewById(R.id.spinner1);
        autocomplete = findViewById(R.id.autocomplete1);
        listview1 = findViewById(R.id.listview1);

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, items);

        spinner1.setAdapter(adapterSpinner);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = items[position];
                textview1.setText(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adapterAuto = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, months);
        autocomplete.setAdapter(adapterAuto);
        autocomplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView)view).getText().toString();
                textview1.setText(selectedItem);
            }
        });

        final String[] itemsListView = {"aaaa", "bbbb", "cccc", "dddd", "eeee"};
        ArrayAdapter<String> adapterList = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, itemsListView);

        listview1.setAdapter(adapterList);
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = itemsListView[position];
                textview1.setText(selectedItem);
            }
        });
    }
}
