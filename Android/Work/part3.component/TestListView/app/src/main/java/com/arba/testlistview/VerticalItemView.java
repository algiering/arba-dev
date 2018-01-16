package com.arba.testlistview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2018-01-16.
 */

public class VerticalItemView extends LinearLayout {
    public VerticalItemView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public VerticalItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public VerticalItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

    }
}
