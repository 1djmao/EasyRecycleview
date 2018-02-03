package com.idjmao.easyrecycleview;

import android.view.ViewGroup;
import android.widget.TextView;

import com.idjmao.easyrecycleviewlib.viewholder.BaseViewHolder;

/**
 * Created by 1djmao on 2018/2/3.
 */

public class TTViewHolder extends BaseViewHolder {

    TextView mTextView1;
    TextView mTextView2;

    public TTViewHolder(ViewGroup view) {
        super(view, R.layout.item_tt);
        mTextView1=itemView.findViewById(R.id.tt1);
        mTextView2=itemView.findViewById(R.id.tt2);
    }
}
