package com.idjmao.easyrecycleviewlib;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 1djmao on 2017/12/18.
 *
 * 注意： viewtype 1000,1001,1002 都已经被占用，如果需要自定义请避开这三个数
 *
 */

public abstract class EasyAdapter<D, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter <VH>{
    public final int VIEW_TYPE_EMPTY=1000;
    public final int VIEW_TYPE_HEADER=1001;
    public final int VIEW_TYPE_BOTTOM=1002;

    RecyclerView.ViewHolder mEmptyViewholder;
    RecyclerView.ViewHolder mHeaderViewHolder;
    RecyclerView.ViewHolder mBottomViewHolder;


    protected Context mContext;
    protected List<D> mList;

    public EasyAdapter(Context context, List<D> list) {
        mContext = context;
        mList = list;
    }


    public int getItemCount() {
        if (mList.size()==0&&mEmptyViewholder!=null){
            return 1;
        }
        int n=mList.size();
        if (mHeaderViewHolder!=null){
            n++;
        }
        if (mBottomViewHolder!=null){
            n++;
        }
        return n;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.size()==0&&mEmptyViewholder!=null){
            return VIEW_TYPE_EMPTY;
        }

        if (mHeaderViewHolder!=null&&position==0){
            return VIEW_TYPE_HEADER;
        }

        if (mBottomViewHolder!=null&&position==getItemCount()-1){
            return VIEW_TYPE_BOTTOM;
        }
        return super.getItemViewType(position);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEW_TYPE_EMPTY:

                return null;
            case VIEW_TYPE_HEADER:

                return null;
            case VIEW_TYPE_BOTTOM:

                return null;
            default:

                return onCreatMyViewHolder(parent,viewType);
        }
    }

    public abstract VH onCreatMyViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(VH holder, final int position) {
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



}
