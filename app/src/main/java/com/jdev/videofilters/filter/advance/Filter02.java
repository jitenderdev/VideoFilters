package com.jdev.videofilters.filter.advance;


import android.content.Context;

import com.jdev.videofilters.filter.base.OpenGlUtils;

public class Filter02 extends B612BaseFilter {


    public Filter02(Context context) {
        super(context);
    }

    @Override
    protected int getInputTexture() {
        return OpenGlUtils.loadTexture(mContext, "filter/filter_face02.png");
    }


}
