package com.sdayazilim.insgram.Helpers;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import org.jetbrains.annotations.NotNull;

public class PermissionHelper {

    public static final int StoragePerssionRequestCode = 1234;
    public static final String[] StoragePerssions = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static boolean storagePerssionGranted(Context pContext){
        for (String permissions : StoragePerssions){
            return ActivityCompat.checkSelfPermission(pContext, permissions) == PackageManager.PERMISSION_GRANTED;   // İzin verilmiş mi? True = Evet, False = Hayır
        }
        return false;
    }

    public static void requestStoragePermission(Activity pActivity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            pActivity.requestPermissions(StoragePerssions, StoragePerssionRequestCode);
        }
    }
}
