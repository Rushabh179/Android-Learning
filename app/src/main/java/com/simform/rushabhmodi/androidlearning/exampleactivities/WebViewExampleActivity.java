package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;

public class WebViewExampleActivity extends BaseExampleActivity {

    private WebView webView;
    private EditText webViewEditText;
    private Button webViewSearchBtn;
    private String webViewUrlString;

    @SuppressLint("SetJavaScriptEnabled")//TODO:review
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_example);

        webView = findViewById(R.id.webview_example);
        webViewEditText = findViewById(R.id.edittext_webview);
        webViewSearchBtn = findViewById(R.id.btn_webview_search);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient());
    }

    public void webViewButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_webview_1:
                webViewUrlString = "https://www.google.com";
                break;
            case R.id.btn_webview_2:
                webViewUrlString = "https://www.youtube.com";
                break;
            case R.id.btn_webview_3:
                webViewUrlString = "https://github.com/Rushabh179/Android-Learning/blob/master/app/src/main/java/com/simform/rushabhmodi/androidlearning/examples/WebViewExampleActivity.java";
                break;
            case R.id.btn_webview_4:
                if (webViewEditText.getVisibility() == View.VISIBLE && webViewSearchBtn.getVisibility() == View.VISIBLE) {
                    webViewEditText.setVisibility(View.GONE);
                    webViewSearchBtn.setVisibility(View.GONE);
                } else {
                    webViewEditText.setVisibility(View.VISIBLE);
                    webViewSearchBtn.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_webview_search:
                webViewUrlString = webViewEditText.getText().toString();
                break;

        }
        if (webViewUrlString != null)
            webView.loadUrl(webViewUrlString);
        else
            Toast.makeText(this, "No URL found", Toast.LENGTH_SHORT).show();
    }

}
