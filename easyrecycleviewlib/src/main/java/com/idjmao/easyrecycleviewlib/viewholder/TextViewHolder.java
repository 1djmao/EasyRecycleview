package com.idjmao.easyrecycleviewlib.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.idjmao.easyrecycleviewlib.R;

/**
 * Created by 1djmao on 2017/12/20.
 */

public class TextViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextView;

    public TextViewHolder(Context context,RecyclerView view,String text) {
        super(LayoutInflater.from(context).inflate(R.layout.text_view_holder,view,false));
        mTextView=itemView.findViewById(R.id.tv_text_view_holder);
        mTextView.setText(text);
    }

}
