package com.arba.multitypelistview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arba.multitypelistview.R;
import com.arba.multitypelistview.model.ModelComment;

/**
 * Created by Administrator on 2018-01-09.
 */

public class CommentView extends RelativeLayout {

    private TextView text_message;
    private TextView text_writer;

    public CommentView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CommentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CommentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        View rowView = LayoutInflater.from(context).inflate(R.layout.view_comment,this, true);

        text_message = rowView.findViewById(R.id.text_message);
        text_writer  = rowView.findViewById(R.id.text_writer);
    }

    private ModelComment comment;

    public ModelComment getComment() {
        return comment;
    }

    public void setComment(ModelComment comment) {
        this.comment = comment;

        text_message.setText(comment.getTextMessage());
        text_writer.setText(comment.getTextWriter());
    }
}
