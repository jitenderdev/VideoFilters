package com.jdev.videofilters.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;

/**
 * Created by jitenderdev on 2/9/17.
 */

public class SplashActivity extends AppCompatActivity {

    int REQUESTCODE_PICK_VIDEO = 100;
    String LOG_TAG = "SplashActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pickFile();
    }


    void pickFile() {
        Intent mediaIntent = new Intent(Intent.ACTION_GET_CONTENT);
        mediaIntent.setType("video/*"); //set mime type as per requirement
        startActivityForResult(mediaIntent, REQUESTCODE_PICK_VIDEO);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE_PICK_VIDEO
                && resultCode == Activity.RESULT_OK) {
            Uri videoUri = data.getData();
            Log.d(LOG_TAG, "Video URI= " + videoUri);
            Log.d(LOG_TAG, "Video Path= " + videoUri.getPath());
            File myFile = new File(videoUri.getPath());
            Log.d(LOG_TAG, "Video Absolute path  " + myFile.getAbsolutePath());
            // 1 - https://github.com/myandy/VideoFilter
            // 2 - https://github.com/wysaid/android-gpuimage-plus
            // 3 - https://github.com/proghjy/android-gpuimage-videorecording
            // 4 - https://github.com/Windsander/Android-UltimateGPUImage
        }
    }

}
