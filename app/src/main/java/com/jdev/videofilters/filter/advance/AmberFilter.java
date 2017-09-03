package com.jdev.videofilters.filter.advance;


import android.content.Context;

import com.jdev.videofilters.filter.base.OpenGlUtils;

public class AmberFilter extends B612BaseFilter {


    public AmberFilter(Context context) {
        super(context);
    }

    @Override
    protected int getInputTexture() {
        return OpenGlUtils.loadTexture(mContext, "filter/edgy_amber.png");
    }


}
