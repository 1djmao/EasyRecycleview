package com.idjmao.easyrecycleviewlib.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by 1djmao on 2018/2/3.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {


    public BaseViewHolder(ViewGroup view, int layout) {
        super(LayoutInflater.from(view.getContext()).inflate(layout,view,false));
    }
}
