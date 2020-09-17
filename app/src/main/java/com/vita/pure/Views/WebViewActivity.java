package com.vita.pure.Views;

import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.vita.pure.Model.WebViewClientImpl;
import com.vita.pure.R;
import com.vita.pure.databinding.ActivityWebViewBinding;

public class WebViewActivity extends Activity {

    private static final String TAG = "web_view_activity";
    private ActivityWebViewBinding webViewBinding;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        webViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_web_view);
        mWebView = webViewBinding.webView;

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        mWebView.setWebViewClient(webViewClient);
        mWebView.loadUrl("http://maneets9.sg-host.com");


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
