package com.sdayazilim.insgram.Helpers;

import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.Snackbar;
import com.sdayazilim.insgram.R;

import org.jetbrains.annotations.NotNull;

public class App {

    public static void showSnackBar(View pView, String pMessage, @NonNull String pAction, int pDuration){
        try{
            Snackbar snackbar = Snackbar.make(pView, pMessage, pDuration);
            if(!pAction.isEmpty())
                snackbar.setAction(pAction, v -> {});
            snackbar.setBackgroundTint(pView.getContext().getResources().getColor(R.color.primaryColor));
            snackbar.setTextColor(pView.getContext().getResources().getColor(R.color.primaryTextColor));
            snackbar.setActionTextColor(pView.getContext().getResources().getColor(R.color.primaryTextColor));
            snackbar.show();
        }catch (Exception ex){
            writeLog("showSnackBar", ex);
            Toast.makeText(pView.getContext(), pMessage, Toast.LENGTH_SHORT).show();
        }
    }

    public static void writeLog(String tag, @NotNull Throwable throwable){
        Log.e(tag, throwable.getMessage());
    }
}
