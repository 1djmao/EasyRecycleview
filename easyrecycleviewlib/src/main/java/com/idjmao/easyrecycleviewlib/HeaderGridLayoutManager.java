package com.idjmao.easyrecycleviewlib;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;

/**
 * Created by 1djmao on 2018/2/9.
 */

public class HeaderGridLayoutManager extends GridLayoutManager {
    EasyAdapter mAdapter;
    public HeaderGridLayoutManager(Context context,EasyAdapter adapter, int spanCount) {
        super(context, spanCount);
        mAdapter=adapter;
        init();
    }

    public HeaderGridLayoutManager(Context context,EasyAdapter adapter, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
        mAdapter=adapter;
        init();
    }

    public HeaderGridLayoutManager(Context context,EasyAdapter adapter, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mAdapter=adapter;
        init();
    }


    private void init(){
        setSpanSizeLookup(new SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mAdapter.mHeaderViewHolder!=null&&position==0){
                    return getSpanCount();
                }
                if (mAdapter.mFooterViewHolder!=null&&position==getItemCount()-1){
                    return getSpanCount();
                }
                return 1;
            }
        });
    }


}
