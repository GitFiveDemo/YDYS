package ydys.jinou.com.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import ydys.jinou.com.R;

public class WebActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);



        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar1);

        String sharedUrl = getIntent().getStringExtra("shared");
        if (sharedUrl!=null){
            webView.setWebViewClient(new WebViewClient());
            WebSettings seting = webView.getSettings();
            seting.setJavaScriptEnabled(true);//设置webview支持javascript脚本
            webView.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onProgressChanged(WebView view, int newProgress) {

                    if (newProgress == 100) {
                        progressBar.setVisibility(View.GONE);//加载完网页进度条消失
                    } else {
                        progressBar.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                        progressBar.setProgress(newProgress);//设置进度值
                    }

                }
            });
        }else {
            Toast.makeText(this, "找不到资源", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.loadUrl(null);
        webView.removeAllViews();
        webView.destroy();
    }
}
