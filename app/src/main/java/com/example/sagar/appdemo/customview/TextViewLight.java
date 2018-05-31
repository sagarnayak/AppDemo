package com.example.sagar.appdemo.customview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TextViewLight extends AppCompatTextView {
    public TextViewLight(Context context) {
        super(context);
        setUpFont();
    }

    public TextViewLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        setUpFont();
    }

    public TextViewLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpFont();
    }

    private void setUpFont(){
        this.setTypeface(
                Typeface.createFromAsset(
                        getContext().getAssets(),
                        "Open_Sans/OpenSans-Light.ttf"
                )
        );}
}
