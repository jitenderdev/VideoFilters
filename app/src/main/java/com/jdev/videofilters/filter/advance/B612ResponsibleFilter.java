package com.jdev.videofilters.filter.advance;

import android.content.Context;

import com.jdev.videofilters.filter.base.OpenGlUtils;

public class B612ResponsibleFilter extends B612BaseFilter {


    public B612ResponsibleFilter(Context context) {
        super(context);
    }

    @Override
    protected int getInputTexture() {
        return OpenGlUtils.loadTexture(mContext, "filter/responsible_new.png");
    }

}
