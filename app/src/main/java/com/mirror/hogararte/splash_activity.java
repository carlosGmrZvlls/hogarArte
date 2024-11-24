package com.mirror.hogararte;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splash_activity extends AppCompatActivity {

    private final int DURACION = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);

        // Ocultar el actionBar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_splash_activity);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(splash_activity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        }, DURACION);

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}