package com.example.sagar.appdemo.ui.splash;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.sagar.appdemo.R;
import com.example.sagar.appdemo.databinding.ContentSplashBinding;
import com.example.sagar.appdemo.ui.login.Login;

public class Splash extends AppCompatActivity {

    private ContentSplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_splash);

        binding = DataBindingUtil.setContentView(this, R.layout.content_splash);

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        gotoLoginPage();
                    }
                },
                3000
        );
    }

    private void gotoLoginPage() {
        Intent intent = new Intent(this, Login.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this,
                        binding.AppcompatImageviewLogo,
                        ViewCompat.getTransitionName(binding.AppcompatImageviewLogo));
        startActivity(intent, options.toBundle());
    }
}
