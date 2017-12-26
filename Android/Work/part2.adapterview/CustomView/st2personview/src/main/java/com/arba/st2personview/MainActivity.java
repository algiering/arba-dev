package com.arba.st2personview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private PersonView personview1;
    private ImageView imageSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personview1 = findViewById(R.id.view_person);
        imageSelect = findViewById(R.id.image_select);

        personview1.setOnImageClickListener(new PersonView.OnImageClickListener() {
            @Override
            public void onImageClick(PersonView view, PersonData person) {
                    imageSelect.setImageDrawable(person.getPhoto());
                    imageSelect.setVisibility(View.VISIBLE);
            }
        });

        imageSelect.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageSelect.setVisibility(View.GONE);
            }
        });
    }
}
