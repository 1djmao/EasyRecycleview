package com.idjmao.easyrecycleviewlib;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by 1djmao on 2017/12/18.
 */

public abstract class EasyAdapter<D,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter {
    final int VIEW_TYPE_EMPTY=0;
    final int VIEW_TYPE_HEADER=1;
    final int VIEW_TYPE_NOEMAL=2;
    final int VIEW_TYPE_BOTTOM=3;


    protected Context mContext;
    protected List<D> mList;

    public EasyAdapter(Context context, List<D> list) {
        mContext = context;
        mList = list;
    }


    public int getItemCount() {
        return mList.size();
    }

//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new VH(null);
//    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClick(position);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mOnItemLongCilckListener!=null){
                    return mOnItemLongCilckListener.onItemLongClick(position);
                }
                return false;
            }
        });
    }

    /**
     * 点击事件监听
     */
    public interface OnItemClickListener{
        public void onItemClick(int position);
    }
    OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    /**
     * 长按事件监听
     */
    public interface OnItemLongCilckListener{
        public boolean onItemLongClick(int position);
    }
    OnItemLongCilckListener mOnItemLongCilckListener;

    public void setOnItemLongCilckListener(OnItemLongCilckListener onItemLongCilckListener) {
        mOnItemLongCilckListener = onItemLongCilckListener;
    }

    /**
     * 增加 item
     * @param data
     */
    public void addData(D data){
        mList.add(data);
        notifyDataSetChanged();
    }
    public void addData(D data,int pos){
        mList.add(pos,data);
        notifyDataSetChanged();
    }

//    public class EasyViewHolder extends RecyclerView.ViewHolder{
//        public EasyViewHolder(View itemView) {
//            super(itemView);
//        }
//    }


}
