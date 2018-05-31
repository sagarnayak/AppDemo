package com.example.sagar.appdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintSet;
import android.support.transition.ChangeBounds;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;

import com.example.sagar.appdemo.databinding.ContentLoginBinding;

public class Login extends AppCompatActivity {

    private ContentLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);

        binding = DataBindingUtil.setContentView(this, R.layout.content_login);

        /*ConstraintSet constraintSetOne = new ConstraintSet();
        constraintSetOne.clone(binding.root);

        final ConstraintSet constraintSetTwo = new ConstraintSet();
        constraintSetTwo.clone(this, R.layout.content_login_second);

        final ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(600);
        changeBounds.setInterpolator(new BounceInterpolator());

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        TransitionManager.beginDelayedTransition(binding.root, changeBounds);
                        constraintSetTwo.applyTo(binding.root);
                    }
                },
                4000
        );*/
    }
}
