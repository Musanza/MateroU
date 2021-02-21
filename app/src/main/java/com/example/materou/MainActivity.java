package com.example.materou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = PathInterpolatorCompat.MAX_NUM_POINTS;
    private ImageView icon;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        getSupportActionBar().hide();
        this.icon = (ImageView) findViewById(R.id.imageView);
        this.icon.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));
        new Handler().postDelayed(new Runnable() {
            public void run() {
                MainActivity.this.startActivity(new Intent(MainActivity.this, UtilityActivity.class));
                MainActivity.this.finish();
            }
        }, (long) SPLASH_TIME_OUT);
    }
}