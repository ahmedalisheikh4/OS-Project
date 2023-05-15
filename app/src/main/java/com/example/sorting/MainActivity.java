package com.example.sorting;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);

        progressBar.setMax(100);
        progressBar.setScaleY(2f);

        progressAnimation();
    }

    private void progressAnimation(){
        ProgressAnimation animation = new ProgressAnimation(this, textView, progressBar, 0f, 100f);
        animation.setDuration(3000);
        progressBar.setAnimation(animation);
    }
}