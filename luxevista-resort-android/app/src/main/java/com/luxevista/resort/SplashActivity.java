package com.luxevista.resort;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ConstraintLayout rootLayout = findViewById(R.id.splash_root);
        // Set deep ocean blue background with gold gradient
        GradientDrawable gradient = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{0xFF0077B6, 0xFFFFD700});
        rootLayout.setBackground(gradient);

        ImageView logo = findViewById(R.id.splash_logo);
        TextView welcomeText = findViewById(R.id.splash_welcome_text);

        // Fade-in animation for logo and text
        AlphaAnimation fadeIn = new AlphaAnimation(0f, 1f);
        fadeIn.setDuration(2000);
        fadeIn.setFillAfter(true);

        logo.startAnimation(fadeIn);
        welcomeText.startAnimation(fadeIn);

        // Navigate to LoginActivity after splash duration
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_DURATION);
    }
}
