package com.jdev.videofilters.filter.helper;


import android.content.Context;

import com.jdev.videofilters.R;
import com.jdev.videofilters.filter.advance.AmberFilter;
import com.jdev.videofilters.filter.advance.B612AdoreFilter;
import com.jdev.videofilters.filter.advance.B612HeartFilter;
import com.jdev.videofilters.filter.advance.B612PerfumeFilter;
import com.jdev.videofilters.filter.advance.B612ResponsibleFilter;
import com.jdev.videofilters.filter.advance.FilmStockFilter;
import com.jdev.videofilters.filter.advance.Filter01;
import com.jdev.videofilters.filter.advance.Filter02;
import com.jdev.videofilters.filter.advance.FoggyNightFilter;
import com.jdev.videofilters.filter.advance.HeheFilter;
import com.jdev.videofilters.filter.advance.SunsetFilter;
import com.jdev.videofilters.filter.advance.WarmingFilter;
import com.jdev.videofilters.filter.advance.WildbirdFilter;
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
            case ADORE:
                return new B612AdoreFilter(context);
            case AMBER:
                return new AmberFilter(context);
            case HEART:
                return new B612HeartFilter(context);
            case PERFUME:
                return new B612PerfumeFilter(context);
            case RESPONSIBLE:
                return new B612ResponsibleFilter(context);
            case FILMSTOCK:
                return new FilmStockFilter(context);
            case FILTER_01:
                return new Filter01(context);
            case FILTER_02:
                return new Filter02(context);
            case FOGGYNIGHT:
                return new FoggyNightFilter(context);
            case HEHE:
                return new HeheFilter(context);
            case SUNSET:
                return new SunsetFilter(context);
            case WARMING:
                return new WarmingFilter(context);
            case WILDBIRD:
                return new WildbirdFilter(context);


            default:
                return null;
        }
    }


    public static int FilterType2Name(MagicFilterType filterType) {
        switch (filterType) {
            case NONE:
                return R.string.filter_none;
            case ADORE:
                return R.string.filter_adore;
            case HEART:
                return R.string.filter_heart;
            case PERFUME:
                return R.string.filter_perfume;
            case RESPONSIBLE:
                return R.string.filter_responsible;
            case FILMSTOCK:
                return R.string.filter_filmstock;
            case FILTER_01:
                return R.string.filter_01;
            case FILTER_02:
                return R.string.filter_02;
            case FOGGYNIGHT:
                return R.string.filter_foggy_night;
            case HEHE:
                return R.string.filter_hehe;
            case SUNSET:
                return R.string.filter_sunset;
            case WARMING:
                return R.string.filter_warming;
            case WILDBIRD:
                return R.string.filter_wildbird;
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
