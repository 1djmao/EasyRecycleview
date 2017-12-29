package com.idjmao.easyrecycleviewlib;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 1djmao on 2017/12/18.
 *
 * 注意： viewType 1000,1001,1002 都已经被占用，如果需要自定义请避开这三个数
 *
 */

public abstract class EasyAdapter<D, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter <RecyclerView.ViewHolder>{
    //三个 viewtype
    public final int VIEW_TYPE_EMPTY=1000;       //数据为空时
    public final int VIEW_TYPE_HEADER=1001;      //头部
    public final int VIEW_TYPE_BOTTOM=1002;      //底部
    //三个 viewtype 对应的 viewholder
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

    /**
     * 因为 getItemCount 获取的是包括 HeaderViewholder 和 BottomViewHolder 的，
     * 所以添加一个新的方法用于获取数据的数量
     * @return
     */
    public int getDataCout(){
        if (mList==null){
            return 0;
        }
        return mList.size();
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case VIEW_TYPE_EMPTY:

                return mEmptyViewholder;
            case VIEW_TYPE_HEADER:

                return mHeaderViewHolder;
            case VIEW_TYPE_BOTTOM:

                return mBottomViewHolder;
            default:

                return onCreateEasyViewHolder(parent,viewType);
        }
    }

    public abstract VH onCreateEasyViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (mEmptyViewholder!=null&&getDataCout()==0){
            return;
        }
        if (mHeaderViewHolder!=null&&position==0){
            return;
        }
        if (mBottomViewHolder!=null&&position==getItemCount()-1){
            return;
        }

        //监听和初始化 ViewHolder 时要使用数据的位置，如果存在 HeaderViewHolder 则要把 position 减 1
        int datePos=position;
        if (mHeaderViewHolder!=null){
            datePos--;
        }

        final int finalDatePos = datePos;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClick(finalDatePos);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mOnItemLongCilckListener!=null){
                    return mOnItemLongCilckListener.onItemLongClick(finalDatePos);
                }
                return false;
            }
        });

        onBindEasyViewHolder((VH) holder,datePos);

    }

    public abstract void onBindEasyViewHolder(VH holder, int dataPos);


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

    /**
     * 删除数据
     * @param pos
     */
    public void removeData(int pos){
        mList.remove(pos);
        notifyDataSetChanged();
    }
    public void removeData(D date){
        mList.remove(date);
        notifyDataSetChanged();
    }

    /**
     * 设置三个 ViewHolder
     * @param emptyViewholder
     */
    public void setEmptyViewholder(RecyclerView.ViewHolder emptyViewholder) {
        mEmptyViewholder = emptyViewholder;
    }

    public void setHeaderViewHolder(RecyclerView.ViewHolder headerViewHolder) {
        mHeaderViewHolder = headerViewHolder;
    }

    public void setBottomViewHolder(RecyclerView.ViewHolder bottomViewHolder) {
        mBottomViewHolder = bottomViewHolder;
    }

    /**
     * 三个viewholder点击监听
     * @param clickListener
     */
    public void setEmptyViewClickListener(View.OnClickListener clickListener){
        if (mEmptyViewholder==null){
            return;
        }
        mEmptyViewholder.itemView.setOnClickListener(clickListener);
    }
    public void setHeaderViewClickListener(View.OnClickListener clickListener){
        if (mHeaderViewHolder==null){
            return;
        }
        mHeaderViewHolder.itemView.setOnClickListener(clickListener);
    }
    public void setBottomViewClickListener(View.OnClickListener clickListener){
        if (mBottomViewHolder==null){
            return;
        }
        mBottomViewHolder.itemView.setOnClickListener(clickListener);
    }



}
