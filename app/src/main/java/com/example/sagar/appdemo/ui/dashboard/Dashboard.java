package com.example.sagar.appdemo.ui.dashboard;

import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import com.example.sagar.appdemo.R;
import com.example.sagar.appdemo.databinding.ContentDashboardBinding;
import com.example.sagar.appdemo.ui.dashboard.adapter.GridAdapter;

public class Dashboard extends AppCompatActivity {

    private ContentDashboardBinding binding;
    private int initialValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_dashboard);

        binding = DataBindingUtil.setContentView(this, R.layout.content_dashboard);
        binding.setContext(this);

        setupTickerAndShow();
        animateInitialView();
        setupGrid();
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
        binding.recyclerview.setLayoutManager(
                new GridLayoutManager(this, 3)
        );
        binding.recyclerview.setAdapter(
                new GridAdapter()
        );
    }
}
