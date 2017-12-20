package com.idjmao.easyrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.idjmao.easyrecycleviewlib.EasyAdapter;

import java.util.List;

/**
 * Created by 1djmao on 2017/12/18.
 */

public class MyAdapter extends EasyAdapter<String,MyAdapter.MyViewHolder> {

    public MyAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public MyViewHolder onCreatMyViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_text,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        super.onBindViewHolder(holder,position);
        Log.i("hhh", "onBindViewHolder: "+holder.getClass());
        holder.mTextView.setText(mList.get(position)+"FAJL");
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView=itemView.findViewById(R.id.mmtext);

        }
    }



}
