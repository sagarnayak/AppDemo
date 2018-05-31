package com.example.sagar.appdemo.ui.login;

import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sagar.appdemo.R;
import com.example.sagar.appdemo.databinding.ContentLoginBinding;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);

        binding = DataBindingUtil.setContentView(this, R.layout.content_login);
        binding.setContext(this);

        animateBackground();
        initialisePasswordShowHideLottieView();
    }

    private void animateBackground() {
        Animatable animatable = (Animatable) binding.appcompatimageviewTriangleOne.getDrawable();
        animatable.start();
        binding.appcompatimageviewTriangleOne.setAlpha(0f);
        binding.appcompatimageviewTriangleOne.animate().alpha(1f).setDuration(1000);
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
}
