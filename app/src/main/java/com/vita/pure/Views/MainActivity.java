package com.vita.pure.Views;

import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.vita.pure.R;
import com.vita.pure.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    private static final String TAG = "MAIN_ACTIVITY";
    private static int DELAY = 2000;
    private ActivityMainBinding mainBinding;
    private ImageView splashImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        splashImageView = mainBinding.splashScreenImageView;
        Log.d(TAG, "onCreate: ");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: ");
                startActivity(new Intent(MainActivity.this, WebViewActivity.class));
            }
        }, DELAY);


    }
}