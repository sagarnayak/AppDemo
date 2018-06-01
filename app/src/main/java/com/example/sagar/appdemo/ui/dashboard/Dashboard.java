package com.example.sagar.appdemo.ui.dashboard;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.OvershootInterpolator;

import com.example.sagar.appdemo.R;
import com.example.sagar.appdemo.databinding.ContentDashboardBinding;
import com.example.sagar.appdemo.ui.dashboard.adapter.GridAdapter;
import com.example.sagar.appdemo.ui.dashboard.adapter.GridSpacingItemDecoration;
import com.example.sagar.appdemo.ui.dashboard.master.GridMaster;
import com.example.sagar.appdemo.ui.login.Login;

public class Dashboard extends AppCompatActivity {

    private ContentDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_dashboard);

        binding = DataBindingUtil.setContentView(this, R.layout.content_dashboard);
        binding.setContext(this);

        setupTickerAndShow();
        animateInitialView();
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        setupGrid();
                    }
                },
                100
        );
    }

    private void animateInitialView() {
        binding.appcompatImageviewBack.setX(-100f);
        binding.appcompatImageviewBack.animate().translationX(0f).setDuration(500)
                .setStartDelay(2000)
                .setInterpolator(
                        new OvershootInterpolator()
                );

        binding.appcompatImageviewLogout.setX(100f);
        binding.appcompatImageviewLogout.animate().translationX(0f).setDuration(500)
                .setStartDelay(2000)
                .setInterpolator(
                        new OvershootInterpolator()
                );
    }

    private void setupTickerAndShow() {
        binding.ticker.setAnimationInterpolator(
                new AccelerateDecelerateInterpolator()
        );
        binding.ticker.setAnimationDuration(1000);
        binding.ticker.setTypeface(
                Typeface.createFromAsset(
                        getAssets(),
                        "Open_Sans/OpenSans-SemiBold.ttf"
                )
        );
        binding.ticker.setText("0");
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        binding.ticker.setText("2,85,509");
                    }
                },
                3000
        );
    }

    private void setupGrid() {
        int spanCount = 3;
        int spacing = 20;
        boolean includeEdge = true;
        binding.recyclerview.setLayoutManager(
                new GridLayoutManager(this, spanCount)
        );
        binding.recyclerview.setAdapter(
                new GridAdapter(
                        GridMaster.getGridItems()
                )
        );
        //noinspection ConstantConditions
        binding.recyclerview.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        int resId = R.anim.recyclerview_animation;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, resId);
        binding.recyclerview.setLayoutAnimation(animation);
    }

    public void onClickLogout(View v) {
        startActivity(
                new Intent(
                        this,
                        Login.class
                )
        );
        finish();
    }
}
