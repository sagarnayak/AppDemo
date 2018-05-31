package com.example.sagar.appdemo.customview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class EditTextRegular extends AppCompatEditText {

    public EditTextRegular(Context context) {
        super(context);
        setUpFont();
    }

    public EditTextRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        setUpFont();
    }

    public EditTextRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpFont();
    }

    private void setUpFont() {
        this.setTypeface(
                Typeface.createFromAsset(
                        getContext().getAssets(),
                        "Open_Sans/OpenSans-Regular.ttf"
                )
        );
    }
}
