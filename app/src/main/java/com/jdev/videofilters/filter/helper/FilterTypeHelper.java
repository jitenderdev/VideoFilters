package com.jdev.videofilters.filter.helper;


import android.content.Context;

import com.jdev.videofilters.R;
import com.jdev.videofilters.filter.advance.Filter04;
import com.jdev.videofilters.filter.advance.Filter03;
import com.jdev.videofilters.filter.advance.Filter07;
import com.jdev.videofilters.filter.advance.Filter09;
import com.jdev.videofilters.filter.advance.Filter10;
import com.jdev.videofilters.filter.advance.Filter05;
import com.jdev.videofilters.filter.advance.Filter01;
import com.jdev.videofilters.filter.advance.Filter02;
import com.jdev.videofilters.filter.advance.Filter06;
import com.jdev.videofilters.filter.advance.Filter08;
import com.jdev.videofilters.filter.advance.Filter11;
import com.jdev.videofilters.filter.advance.Filter12;
import com.jdev.videofilters.filter.advance.FIlter13;
import com.jdev.videofilters.filter.base.GPUImageFilter;
import com.jdev.videofilters.utils.ConfigUtils;

public class FilterTypeHelper {

    public static GPUImageFilter getFilter(Context context) {
        MagicFilterType filterType = ConfigUtils.getInstance().getMagicFilterType();
        return getFilter(filterType, context);
    }

    private static GPUImageFilter getFilter(MagicFilterType filterType, Context context) {
        switch (filterType) {
            case NONE:
                return null;
            case FILTER_1:
                return new Filter01(context);
            case FILTER_2:
                return new Filter02(context);
            case FILTER_3:
                return new Filter03(context);
            case FILTER_4:
                return new Filter04(context);
            case FILTER_5:
                return new Filter05(context);
            case FILTER_6:
                return new Filter06(context);
            case FILTER_7:
                return new Filter07(context);
            case FILTER_8:
                return new Filter08(context);
            case FILTER_9:
                return new Filter09(context);
            case FILTER_10:
                return new Filter10(context);
            case FILTER_11:
                return new Filter11(context);
            case FILTER_12:
                return new Filter12(context);
            case FILTER_13:
                return new FIlter13(context);
            default:
                return null;
        }
    }


    public static int FilterType2Name(MagicFilterType filterType) {
        switch (filterType) {
            case NONE:
                return R.string.filter_none;
            case FILTER_1:
                return R.string.filter_one;
            case FILTER_2:
                return R.string.filter_two;
            case FILTER_3:
                return R.string.filter_three;
            case FILTER_4:
                return R.string.filter_four;
            case FILTER_5:
                return R.string.filter_five;
            case FILTER_6:
                return R.string.filter_six;
            case FILTER_7:
                return R.string.filter_seven;
            case FILTER_8:
                return R.string.filter_eight;
            case FILTER_9:
                return R.string.filter_nine;
            case FILTER_10:
                return R.string.filter_ten;
            case FILTER_11:
                return R.string.filter_eleven;
            case FILTER_12:
                return R.string.filter_twelve;
            case FILTER_13:
                return R.string.filter_thirteen;
            default:
                return R.string.filter_none;
        }
    }

    public static int FilterType2Color(MagicFilterType filterType) {
        switch (filterType) {
            case NONE:
                return R.color.filter_category_greenish_dummy;
            default:
                return R.color.filter_category_greenish_normal;
        }
    }

    public static int FilterType2Thumb(MagicFilterType filterType) {
        switch (filterType) {
            case NONE:
                return R.drawable.ic_launcher;
            default:
                return R.drawable.ic_launcher;
        }
    }
}
