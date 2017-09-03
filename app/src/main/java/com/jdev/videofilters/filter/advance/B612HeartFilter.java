package com.jdev.videofilters.filter.advance;


import android.content.Context;

import com.jdev.videofilters.filter.base.OpenGlUtils;

public class B612HeartFilter extends B612BaseFilter {


    public B612HeartFilter(Context context) {
        super(context);
    }

    @Override
    protected int getInputTexture() {
        return OpenGlUtils.loadTexture(mContext, "filter/heart_new.png");
    }


}
