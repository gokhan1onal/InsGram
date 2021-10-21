package com.sdayazilim.insgram.Fragments;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.sdayazilim.insgram.Helpers.DownHelper;
import com.sdayazilim.insgram.R;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class HomeFragment extends Fragment {

    public Activity LV_Activity;

    public static @NotNull Fragment newInstance(Activity pActivity) {
        HomeFragment fragment = new HomeFragment();
        fragment.LV_Activity = pActivity;
        return fragment;
    }

    View mView;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);

        MaterialButton mbDownload = mView.findViewById(R.id.mbDownload);
        TextInputEditText etDownloadUrl = mView.findViewById(R.id.etDownloadUrl);

        mbDownload.setOnClickListener(view -> new DownHelper(LV_Activity).download(Objects.requireNonNull(etDownloadUrl.getText()).toString()));

        return mView;
    }
}