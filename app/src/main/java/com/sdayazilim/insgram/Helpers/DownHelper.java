package com.sdayazilim.insgram.Helpers;

import android.app.Activity;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Objects;

public class DownHelper {

    Activity mActivity;

    public DownHelper(Activity pActivity){
        this.mActivity = pActivity;
    }

    public void download(String pUrl){
        try{
            String mUrl = prepareUrl(pUrl);
            if(pUrl.isEmpty())
                return;

            String mJson = getSourceCode(mUrl);
            if(mJson.isEmpty())
                return;

            JSONObject jsonObject = new JSONObject(mJson);
            boolean isVideo = jsonObject.getBoolean("is_video");
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String prepareUrl(String pUrl){
        try{
            if(pUrl == null || pUrl.isEmpty())
                return "";

            String mUrl = pUrl.trim();
            mUrl = mUrl.substring(0,mUrl.indexOf('?')) + "?__a=1";

            return mUrl;
        }catch (Exception ex){
            Log.e("checkUrl", ex.getMessage());
            Log.e("checkUrl", ex.getLocalizedMessage());
            return "";
        }
    }

    private @NotNull String getSourceCode(String pUrl){
        try{
            URL url = new URL(pUrl);
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(url.openStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String input = null;
            StringBuilder stringBuffer = new StringBuilder();
            while (true)
            {
                try {
                    if ((input = Objects.requireNonNull(in).readLine()) == null) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stringBuffer.append(input);
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringBuffer.toString();
        }catch (Exception ex){
            App.writeLog("getSourceCode()", ex);
            return "";
        }
    }

}
