package com.idjmao.easyrecycleviewlib.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.idjmao.easyrecycleviewlib.R;

/**
 * Created by 1djmao on 2017/12/20.
 */

public class TextViewHolder extends BaseViewHolder {
    public TextView mTextView;

    public TextViewHolder(ViewGroup view, String text) {
        super(view,R.layout.text_view_holder);
        mTextView=itemView.findViewById(R.id.tv_text_view_holder);
        mTextView.setText(text);
    }

}
