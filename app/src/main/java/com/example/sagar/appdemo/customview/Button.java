package com.example.sagar.appdemo.customview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * created by SAGAR KUMAR NAYAK on 31 MAY 2018.
 * custom button with OpenSans semi bold font.
 */
@SuppressWarnings("unused")
public class Button extends AppCompatButton {
    public Button(Context context) {
        super(context);
        setUpFont();
    }

    public Button(Context context, AttributeSet attrs) {
        super(context, attrs);
        setUpFont();
    }

    public Button(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpFont();
    }

    private void setUpFont() {
        this.setTypeface(
                Typeface.createFromAsset(
                        getContext().getAssets(),
                        "Open_Sans/OpenSans-SemiBold.ttf"
                )
        );
    }
}
