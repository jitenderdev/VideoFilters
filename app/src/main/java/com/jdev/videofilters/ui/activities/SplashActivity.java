package com.jdev.videofilters.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.jdev.videofilters.utils.Permissions;

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
        Log.d(LOG_TAG," MODEL is "+ Build.MODEL);
        Log.d(LOG_TAG," MANUF is "+ Build.MANUFACTURER);

        if (Permissions.checkPermissionReadStorage(this)) {
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {

            case Permissions.MY_PERMISSIONS_REQUEST_READ_STORAGE: {

                if (grantResults.length > 0) {
                   startActivity(new Intent(this,MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "Please provide storage permissions", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
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
