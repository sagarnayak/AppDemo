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

/**
 * created by SAGAR KUMAR NAYAK on 31 MAY 2018.
 * splash activity.
 */
public class Splash extends AppCompatActivity {

    private ContentSplashBinding binding;
    private boolean shouldFinishActivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_splash);

        /*
        binding initialisation
         */
        binding = DataBindingUtil.setContentView(this, R.layout.content_splash);

        gotoLoginAfterDelay();
    }

    /**
     * goto login screen after a delay.
     */
    private void gotoLoginAfterDelay() {
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

    /**
     * start login activity.
     */
    private void gotoLoginPage() {
        Intent intent = new Intent(this, Login.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this,
                        binding.AppcompatImageviewLogo,
                        ViewCompat.getTransitionName(binding.AppcompatImageviewLogo));
        startActivity(intent, options.toBundle());
        shouldFinishActivity = true;
    }

    /**
     * stop the activity if the next activity is started already.
     * this is distinguished by the shouldFinishActivity boolean val.
     */
    @Override
    protected void onStop() {
        super.onStop();
        if (
                !shouldFinishActivity
                )
            return;
        finish();
    }
}
