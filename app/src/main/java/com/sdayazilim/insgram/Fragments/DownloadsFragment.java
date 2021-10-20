package com.sdayazilim.insgram.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sdayazilim.insgram.R;
import org.jetbrains.annotations.NotNull;

public class DownloadsFragment extends Fragment {

    View mView;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_downloads, container, false);


        return mView;
    }
}