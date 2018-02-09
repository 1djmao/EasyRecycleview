package com.idjmao.easyrecycleviewlib;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;

/**
 * Created by 1djmao on 2018/2/9.
 */

public class HeaderGridLayoutManager extends GridLayoutManager {
    public HeaderGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
        init();
    }

    public HeaderGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
        init();
    }

    public HeaderGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }


    private void init(){
        setSpanSizeLookup(new SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position==0){
                    return getSpanCount();
                }
                if (position==getItemCount()-1){
                    return getSpanCount();
                }
                return 1;
            }
        });
    }


}
