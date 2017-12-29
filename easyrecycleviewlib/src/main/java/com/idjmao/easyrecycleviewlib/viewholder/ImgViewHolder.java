package com.idjmao.easyrecycleviewlib.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.idjmao.easyrecycleviewlib.R;

/**
 * Created by 1djmao on 2017/12/20.
 */

public class ImgViewHolder extends RecyclerView.ViewHolder {
    public ImageView mImageView;

    public ImgViewHolder(Context context,RecyclerView view,int src) {
        super(LayoutInflater.from(context).inflate(R.layout.img_view_holder,view,false));
        mImageView=itemView.findViewById(R.id.iv_img_view_holder);
        mImageView.setImageResource(src);
    }
}
