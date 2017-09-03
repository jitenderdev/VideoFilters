package com.jdev.videofilters.filter.advance;


import android.content.Context;

import com.jdev.videofilters.filter.base.OpenGlUtils;

public class WildbirdFilter extends B612BaseFilter {


    public WildbirdFilter(Context context) {
        super(context);
    }

    @Override
    protected int getInputTexture() {
        return OpenGlUtils.loadTexture(mContext, "filter/wildbird.png");
    }


}
