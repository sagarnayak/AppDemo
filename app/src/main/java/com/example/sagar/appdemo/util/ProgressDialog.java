package com.example.sagar.appdemo.util;

import android.app.Dialog;
import android.content.Context;

import com.example.sagar.appdemo.R;

@SuppressWarnings("unused")
public class ProgressDialog {

    private Context context;
    private Dialog dialog;

    public ProgressDialog(Context context) {
        this.context = context;
    }

    public void show() {
        dialog = new Dialog(context, R.style.DialogTheme);
        dialog.setContentView(R.layout.progress_dialog);
        dialog.setCancelable(false);
        dialog.show();
    }

    public void hide() {
        if (dialog == null)
            return;
        dialog.dismiss();
    }

}
