package com.sdayazilim.insgram.Activitys;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextPaint;
import android.widget.TextView;
import android.widget.Toolbar;
import com.google.android.material.tabs.TabLayout;
import org.jetbrains.annotations.NotNull;
import com.sdayazilim.insgram.Fragments.DownloadsFragment;
import com.sdayazilim.insgram.Fragments.HomeFragment;
import com.sdayazilim.insgram.Helpers.PermissionHelper;
import com.sdayazilim.insgram.R;

import java.util.Objects;

public class MainActivity extends FragmentActivity {

    TabLayout tabLayout;
    private static final int NUM_PAGES = 2;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!PermissionHelper.storagePerssionGranted(this))
            PermissionHelper.requestStoragePermission(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Toolbar toolbar = findViewById(R.id.materialToolbarMA);
        toolbar.setTitle("");
        setActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayoutMA);
        tabLayout.addTab(tabLayout.newTab().setText("Ana Sayfa"));
        tabLayout.addTab(tabLayout.newTab().setText("İndirilenler"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tabLayout.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager = findViewById(R.id.viewPagerMA);
        FragmentStateAdapter pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
              TabLayout.Tab tab = tabLayout.getTabAt(position);
              if(tab != null)
                  tabLayout.selectTab(tab);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PermissionHelper.StoragePerssionRequestCode && grantResults.length>0){
            if (!PermissionHelper.storagePerssionGranted(this)){
                ((ActivityManager) Objects.requireNonNull(this.getSystemService(ACTIVITY_SERVICE))).clearApplicationUserData();
                recreate();
            }
        }
    }

    private static class ScreenSlidePagerAdapter extends FragmentStateAdapter {

        Activity mActivity;

        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
            mActivity = fa;
        }

        @Override
        public @NotNull Fragment createFragment(int position) {
            if(position == 0){
                return HomeFragment.newInstance(mActivity);
            }else {
                return new DownloadsFragment();
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}