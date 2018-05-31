package com.example.sagar.appdemo.ui.login;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.example.sagar.appdemo.R;
import com.example.sagar.appdemo.databinding.ContentLoginBinding;
import com.example.sagar.appdemo.ui.dashboard.Dashboard;
import com.example.sagar.appdemo.util.ProgressDialog;
import com.example.sagar.appdemo.util.UiUtil;

public class Login extends AppCompatActivity {

    private enum PasswordViewState {
        SHOWING,
        HIDING
    }

    private enum InputType {
        PASSWORD(225),
        TEXT(1);
        private int code;

        InputType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    private ContentLoginBinding binding;
    private PasswordViewState passwordViewState = PasswordViewState.HIDING;
    private ProgressDialog progressDialog;
    private boolean shouldFinishActivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);

        binding = DataBindingUtil.setContentView(this, R.layout.content_login);
        binding.setContext(this);

        progressDialog = new ProgressDialog(this);

        animateBackground();
        animateFields();
        initialisePasswordShowHideLottieView();
        setupPasswordEdittextKeyListener();
    }

    private void animateBackground() {
        Animatable animatable = (Animatable) binding.appcompatimageviewTriangleOne.getDrawable();
        animatable.start();
        binding.appcompatimageviewTriangleOne.setAlpha(0f);
        binding.appcompatimageviewTriangleOne.animate().alpha(1f).setDuration(2000);
    }

    private void animateFields() {
        binding.edittextUserName.setY(-40);
        binding.edittextUserName.setAlpha(0f);
        binding.edittextUserName.animate().translationY(0).alpha(1f).setDuration(1500).setInterpolator(
                new AccelerateDecelerateInterpolator()
        );

        binding.edittextPassword.setY(-40);
        binding.edittextPassword.setAlpha(0f);
        binding.edittextPassword.animate().translationY(0).alpha(1f).setDuration(1500).setInterpolator(
                new AccelerateDecelerateInterpolator()
        );

        binding.buttonLogin.setY(-40);
        binding.buttonLogin.setAlpha(0f);
        binding.buttonLogin.animate().translationY(0).alpha(1f).setDuration(1500).setInterpolator(
                new AccelerateDecelerateInterpolator()
        );
    }

    private void initialisePasswordShowHideLottieView() {
        binding.lottiePasswordHideShow.setProgress(.5f);
    }

    public void onClickPasswordHideShow(View v) {
        switch (passwordViewState) {
            case HIDING:
                passwordViewState = PasswordViewState.SHOWING;
                break;
            case SHOWING:
                passwordViewState = PasswordViewState.HIDING;
                break;
        }
        updateTextOnPasswordView();
        updatePasswordEye();
    }

    private void updateTextOnPasswordView() {
        switch (passwordViewState) {
            case HIDING:
                binding.edittextPassword.setInputType(android.text.InputType.TYPE_CLASS_TEXT | InputType.PASSWORD.getCode());
                break;
            case SHOWING:
                binding.edittextPassword.setInputType(android.text.InputType.TYPE_CLASS_TEXT | InputType.TEXT.getCode());
                break;
        }
        binding.edittextPassword.setSelection(
                binding.edittextPassword.getText().toString().length()
        );
        binding.edittextPassword.setTypeface(
                binding.edittextUserName.getTypeface()
        );
    }

    private void updatePasswordEye() {
        ValueAnimator animator = null;
        switch (passwordViewState) {
            case HIDING:
                animator = ValueAnimator.ofFloat(0.0f, 0.5f);
                break;
            case SHOWING:
                animator = ValueAnimator.ofFloat(0.5f, 1.0f);
        }
        animator.setDuration(1000);
        animator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        binding.lottiePasswordHideShow.setProgress(
                                (Float) valueAnimator.getAnimatedValue()
                        );
                    }
                }
        );
        animator.start();
    }

    public void onClickLogin(View v) {
        UiUtil.hideSoftKeyboard(this);
        progressDialog.show();
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.hide();
                        gotoDashboard();
                    }
                },
                5000
        );
    }

    private void setupPasswordEdittextKeyListener() {
        binding.edittextPassword.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    UiUtil.hideSoftKeyboard(Login.this);
                    binding.buttonLogin.performClick();
                    return true;
                }
                return false;
            }
        });

    }

    private void gotoDashboard() {
        Intent intent = new Intent(this, Dashboard.class);
        Pair<View, String> pairAppName = new Pair<>(
                (View) binding.textviewAppName,
                binding.textviewAppName.getTransitionName()
        );
        Pair<View, String> pairLogo = new Pair<>(
                (View) binding.AppcompatImageviewLogo,
                ViewCompat.getTransitionName(binding.AppcompatImageviewLogo)
        );
        @SuppressWarnings("unchecked")
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this,
                        pairAppName, pairLogo
                );
        startActivity(intent, options.toBundle());
        shouldFinishActivity = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!shouldFinishActivity)
            return;
        finish();
    }
}
