package com.idjmao.easyrecycleviewlib.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.idjmao.easyrecycleviewlib.R;

/**
 * Created by 1djmao on 2017/12/20.
 */

public class ImgViewHolder extends BaseViewHolder {
    public ImageView mImageView;

    public ImgViewHolder(ViewGroup view, int src) {
        super(view,R.layout.img_view_holder);
        mImageView=itemView.findViewById(R.id.iv_img_view_holder);
        mImageView.setImageResource(src);
    }
}
