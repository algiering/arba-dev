package com.arba.ad33_01fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentThr extends Fragment {

    String[] imageTitle = { "Dream 01", "Dream 02", "Dream 03" };
    int[] imageDrawable = {R.drawable.rabbit, R.drawable.cat, R.drawable.dog};

    public FragmentThr() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thr, container, false);
    }

    public void update(int index) {
        TextView textTitle = getView().findViewById(R.id.text_title);
        ImageView imageView = getView().findViewById(R.id.imageview);

        textTitle.setText(imageTitle[index]);
        imageView.setImageDrawable(getResources().getDrawable(imageDrawable[index]));
    }

}
