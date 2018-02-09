package com.idjmao.easyrecycleview;

import android.content.Context;
import android.view.ViewGroup;

import com.idjmao.easyrecycleviewlib.EasyAdapter;
import com.idjmao.easyrecycleviewlib.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Created by 1djmao on 2017/12/18.
 */

public class MyAdapter extends EasyAdapter<String> {

    public MyAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public BaseViewHolder onCreateEasyViewHolder(ViewGroup parent, int viewType) {
        return new TTViewHolder(parent);
    }

    @Override
    public void onBindEasyViewHolder(BaseViewHolder holder, int position) {
        TTViewHolder ttViewHolder= (TTViewHolder) holder;
        ttViewHolder.mTextView1.setText(mList.get(position)+"item text1");
        ttViewHolder.mTextView2.setText(mList.get(position)+"item text2");
    }


}
