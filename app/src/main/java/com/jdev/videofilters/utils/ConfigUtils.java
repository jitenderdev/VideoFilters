package com.jdev.videofilters.utils;

import android.media.MediaFormat;
import android.os.Environment;
import android.util.Log;
import com.jdev.videofilters.filter.helper.MagicFilterType;
import java.io.File;

public class ConfigUtils {
    String LOG_TAG = "ConfigUtils";
    private static ConfigUtils mInstance;

    public static ConfigUtils getInstance() {
        if (mInstance == null) {
            synchronized (ConfigUtils.class) {
                if (mInstance == null) {
                    mInstance = new ConfigUtils();
                }
            }
        }
        return mInstance;
    }

    private ConfigUtils() {
    }

    private String mVideoPath;


    private MediaFormat mMediaFormat;

    public MediaFormat getMediaFormat() {
        return mMediaFormat;
    }

    public MagicFilterType getMagicFilterType() {
        return mMagicFilterType;
    }

    public void setMagicFilterType(MagicFilterType magicFilterType) {
        mMagicFilterType = magicFilterType;
    }

    private MagicFilterType mMagicFilterType = MagicFilterType.NONE;

    public int getFrameInterval() {
        return mFrameInterval;
    }

    public void setFrameInterval(int frameInterval) {
        mFrameInterval = frameInterval;
    }

    private int mFrameInterval;

    public String getVideoPath() {
        return mVideoPath;
    }

    public void setVideoPath(String videoPath) {
        mVideoPath = videoPath;
        mMediaFormat = VideoInfoUtils.getVideoInfo(mVideoPath);
    }


}