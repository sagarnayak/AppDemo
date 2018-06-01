package com.example.sagar.appdemo.customview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * created by SAGAR KUMAR NAYAK on 31 MAY 2018.
 * custom textview with OpenSans bold font.
 */
@SuppressWarnings("unused")
public class TextViewBold extends AppCompatTextView {
    public TextViewBold(Context context) {
        super(context);
        setUpFont();
    }

    public TextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        setUpFont();
    }

    public TextViewBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpFont();
    }

    private void setUpFont(){
        this.setTypeface(
                Typeface.createFromAsset(
                        getContext().getAssets(),
                        "Open_Sans/OpenSans-Bold.ttf"
                )
        );}
}
