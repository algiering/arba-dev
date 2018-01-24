package com.arba.tabandfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Tab2Fragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View mInflatedView;

    private Button mBtnAdd   ;
    private Button mBtnModify;
    private Button mBtnDelete;

    private EditText mEditInput;

    private List<String> mData;
    private ArrayAdapter mAdapter;

    private ListView mListview;

    public Tab2Fragment() {
    }

    public static Tab2Fragment newInstance(String param1, String param2) {
        Tab2Fragment fragment = new Tab2Fragment();
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
        mInflatedView = inflater.inflate(R.layout.fragment_tab2, container, false);

        return mInflatedView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mListview = mInflatedView.findViewById(R.id.list_view);

        mData = makeData();
        mAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_multiple_choice, mData);

        mListview.setAdapter(mAdapter);
        mListview.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        mBtnAdd = mInflatedView.findViewById(R.id.btn_add);
        mBtnModify = mInflatedView.findViewById(R.id.btn_modify);
        mBtnDelete = mInflatedView.findViewById(R.id.btn_delete);

        ButtonListener bl = new ButtonListener();

        mBtnAdd.setOnClickListener(bl);
        mBtnModify.setOnClickListener(bl);
        mBtnDelete.setOnClickListener(bl);

        mEditInput = mInflatedView.findViewById(R.id.edit_input);

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

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            SparseBooleanArray position;

            switch (v.getId()) {
                case R.id.btn_add:
                    mData.add(mEditInput.getText().toString());
                    mAdapter.notifyDataSetChanged();
                    mListview.smoothScrollToPosition(mAdapter.getCount() -1 - mListview.getHeaderViewsCount());
                    break;

                case R.id.btn_modify:
                    position = mListview.getCheckedItemPositions();
                    for (int i = mListview.getCount()-1 ; i>=0 ; i--) {
                        if (position.get(i)) {
                            mData.set(i - mListview.getHeaderViewsCount(), mEditInput.getText().toString());
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                    break;

                case R.id.btn_delete:
                    position = mListview.getCheckedItemPositions();
                    for (int i = mListview.getCount()-1 ; i>=0 ; i--) {
                        if (position.get(i)) {
                            mData.remove(i - mListview.getHeaderViewsCount());
                        }
                    }
                    mAdapter.notifyDataSetChanged();
                    mListview.clearChoices();
                    break;
            }
        }
    }
}
