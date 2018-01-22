package com.arba.st1fragmenttransaction;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {

    public static final String KEY_INPUT = "input";
    private static final int REQUEST_CODE_OTHER_ACTIVITY = 10000;
    private String inputText;
    private EditText inputView;
    private TextView messageView;
    private Button btnSend;
    private Button btnSend2;
    private Button btnSend3;

    public static FragmentTwo newInstance(String input) {
        FragmentTwo fragment = new FragmentTwo();
        Bundle b = new Bundle();
        b.putString(KEY_INPUT, input);
        fragment.setArguments(b);

        return fragment;
    }



    public FragmentTwo() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMessegeCallBack) {
            callback = (OnMessegeCallBack) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getArguments();
        if (b != null) {
            inputText = b.getString(KEY_INPUT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        inputView = view.findViewById(R.id.edit_input);
        messageView = view.findViewById(R.id.text_message);
        btnSend = view.findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = inputView.getText().toString();
                messageView.setText(msg);

                ((MainActivity)getActivity()).update(msg);
            }
        });

        btnSend2 = view.findViewById(R.id.btn_send2);

        btnSend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = inputView.getText().toString();
                messageView.setText(msg);

                if (callback != null) {
                    callback.displayMessage(msg);
                }
            }
        });

        btnSend3 = view.findViewById(R.id.btn_send3);

        btnSend3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), OtherActivity.class);
                startActivityForResult(i, REQUEST_CODE_OTHER_ACTIVITY);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    OnMessegeCallBack callback;

    public interface OnMessegeCallBack {
        public void displayMessage(String message);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE_OTHER_ACTIVITY && resultCode == Activity.RESULT_OK) {
            String result = data.getStringExtra(Common.OTHER_RESULT);
            messageView.setText(result);
        }
    }
}
