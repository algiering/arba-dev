package com.arba.st2preference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnsave;
    private EditText edtNumber;
    private EditText edtText;
    private CheckBox chkSound;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave = findViewById(R.id.btnSave);
        edtNumber = findViewById(R.id.edtNumber);
        edtText = findViewById(R.id.edtText);
        chkSound = findViewById(R.id.chkSound);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();

                editor.putBoolean("SOUND_SET", chkSound.isChecked());
                editor.putInt("TEXT_NUMBER", Integer.parseInt(edtNumber.getText().toString()));
                editor.putString("TEXT_String", edtText.getText().toString());
                editor.apply();
            }
        });

        // Preference 객체 얻기
        pref = getSharedPreferences("settings", MODE_PRIVATE);

        Boolean chk = pref.getBoolean("SOUND_SET", false);
        chkSound.setChecked(chk);

        Integer number = pref.getInt("TEXT_NUMBER", -1);
        edtNumber.setText(number.toString());

        String txt = pref.getString("TEXT_String", "");
        edtText.setText(txt);
    }
}
