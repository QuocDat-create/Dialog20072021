package com.quocdat.dialog20072021;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RatingBar;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRatingBar;

public class AppDialog {
    private static float star = -1f;

    public static void createDialogRating(Context context, OnListenerRating onListenerRating){
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_rating);
        dialog.setCancelable(false);

        //Xu li ve mat kich thuoc
        Window window = dialog.getWindow();
        if (window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = Gravity.CENTER;

        AppCompatRatingBar ratingBar = dialog.findViewById(R.id.Rating);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                star = rating;
            }
        });

        AppCompatButton button = dialog.findViewById(R.id.btnRating);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListenerRating.onRatingChanges(star);
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
