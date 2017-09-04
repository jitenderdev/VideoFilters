package com.jdev.videofilters.filter.advance;

import android.content.Context;

import com.jdev.videofilters.filter.base.OpenGlUtils;

public class ResponsibleFilter extends BaseFilter {


    public ResponsibleFilter(Context context) {
        super(context);
    }

    @Override
    protected int getInputTexture() {
        return OpenGlUtils.loadTexture(mContext, "filter/responsible_new.png");
    }

}
