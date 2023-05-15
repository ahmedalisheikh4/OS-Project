package com.example.sorting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // simulate some work being done
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        // move to the next activity
                        Intent intent = new Intent(Home.this, MainActivity2.class);
                        startActivity(intent);

                    }
                }).start();
            }
        });
    }
}
