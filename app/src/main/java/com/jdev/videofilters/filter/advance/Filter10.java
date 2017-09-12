package com.jdev.videofilters.filter.advance;

import android.content.Context;

import com.jdev.videofilters.filter.base.OpenGlUtils;

public class Filter10 extends BaseFilter {


    public Filter10(Context context) {
        super(context);
    }

    @Override
    protected int getInputTexture() {
        return OpenGlUtils.loadTexture(mContext, "filter/filter_10.png");
    }

}
