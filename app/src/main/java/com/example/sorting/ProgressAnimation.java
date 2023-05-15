package com.example.sorting;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressAnimation extends Animation{

    private final Context context;
    private TextView textView;
    private ProgressBar progressBar;
    private float from;
    private float to;

    //alt + ins default const builder
    public ProgressAnimation(Context context, TextView textView, ProgressBar progressBar, float from, float to) {
        this.context = context;
        this.textView = textView;
        this.progressBar = progressBar;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;

        progressBar.setProgress((int) value);
        textView.setText((int) value+"%");

        if (value == to){
            context.startActivity(new Intent(context, Home.class));
        }

    }
}
