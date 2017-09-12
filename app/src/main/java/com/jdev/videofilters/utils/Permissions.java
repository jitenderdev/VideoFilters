package com.jdev.videofilters.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

public class Permissions {

    public static final int MY_PERMISSIONS_REQUEST_ALL = 0;
    public static final int MY_PERMISSIONS_REQUEST_WRITE_READ = 1;
    public static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 2;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 3;
    public static final int MY_PERMISSIONS_REQUEST_READ_STORAGE = 4;

    public static Boolean checkPermissionStorage(Activity activity) {
        Boolean res = false;
        if (Build.VERSION.SDK_INT >= 23) {
            // Marshmallow+
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_READ);
            } else {
                res = true;
            }
        } else {
            // Pre-Marshmallow
            res = true;
        }


        return res;
    }

    public static Boolean checkPermissionReadStorage(Activity activity) {
        Boolean res = false;
        if (Build.VERSION.SDK_INT >= 23) {
            // Marshmallow+
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_STORAGE);
            } else {
                res = true;
            }
        } else {
            // Pre-Marshmallow
            res = true;
        }


        return res;
    }

    public static Boolean checkPermissionCamera(Activity activity) {
        Boolean res = false;
        if (Build.VERSION.SDK_INT >= 23) {
            // Marshmallow+
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
            } else {
                res = true;
            }
        } else {
            // Pre-Marshmallow
            res = true;
        }


        return res;
    }

    public static Boolean checkPermissionReadContacts(Activity activity) {
        Boolean res = false;
        if (Build.VERSION.SDK_INT >= 23) {
            // Marshmallow+
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            } else {
                res = true;
            }
        } else {
            // Pre-Marshmallow
            res = true;
        }


        return res;
    }


    public static Boolean requestAllPermissions(Activity activity) {
        Boolean res = false;
        if (Build.VERSION.SDK_INT >= 23) {
            // Marshmallow+
            if (
                    (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                    && (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                    && (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
                    //&& (ContextCompat.checkSelfPermission(activity, Manifest.permission.SYSTEM_ALERT_WINDOW) != PackageManager.PERMISSION_GRANTED)
                    && (ContextCompat.checkSelfPermission(activity, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
                    && (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
                    && (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED)

                    ) {
                activity.requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.RECORD_AUDIO,Manifest.permission.READ_CALENDAR,Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_ALL);
            } else {
                res = true;
            }
        } else {
            // Pre-Marshmallow
            res = true;
        }


        return res;
    }

}
