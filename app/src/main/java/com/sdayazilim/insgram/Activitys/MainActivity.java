package com.sdayazilim.insgram.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.sdayazilim.insgram.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.materialToolbarMA);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tabLayoutMA);
        tabLayout.addTab(tabLayout.newTab().setText("Ana Sayfa"));
        tabLayout.addTab(tabLayout.newTab().setText("İndirilenler"));
    }
}