package com.arba.tabandfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Tab1Fragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View inflatedView;

    private Button btnAdd;
    private EditText editInput;

    private List<String> mData;
    private ArrayAdapter<String> mAdapter;
    private ListView mListview;


    public Tab1Fragment() {
    }

    public static Tab1Fragment newInstance(String param1, String param2) {
        Tab1Fragment fragment = new Tab1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflatedView = inflater.inflate(R.layout.fragment_tab1, container, false);

        return inflatedView;
    }

    // Configration ListView
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mData = makeData();

        // Find ListView
        mListview = inflatedView.findViewById(R.id.list_view);

        // Create ArrayAdapter
        mAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mData);

        // Connect ListView and ArrayAdapter
        mListview.setAdapter(mAdapter);


        editInput = inflatedView.findViewById(R.id.edit_input);
        btnAdd = inflatedView.findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.add(editInput.getText().toString());
                mAdapter.notifyDataSetChanged();
                mListview.smoothScrollToPosition(mAdapter.getCount() - 1 - mListview.getHeaderViewsCount());

            }
        });
    }

    private List<String> makeData() {
        List<String> data = new ArrayList<>();

        data.add("item 01");
        data.add("item 02");
        data.add("item 03");
        data.add("item 04");
        data.add("item 05");
        data.add("item 06");
        data.add("item 07");
        data.add("item 08");
        data.add("item 09");
        data.add("item 10");
        data.add("item 11");
        data.add("item 12");
        data.add("item 13");
        data.add("item 14");
        data.add("item 15");
        data.add("item 16");
        data.add("item 17");
        data.add("item 18");
        data.add("item 19");
        data.add("item 20");

        return data;
    }

}
