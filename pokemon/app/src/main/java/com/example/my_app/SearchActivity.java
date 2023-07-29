package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class SearchActivity extends AppCompatActivity {

    private SearchView searchview;
    private String search_txt;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchview = findViewById(R.id.searchView);
        webview = findViewById(R.id.webview);
//跳转百度
        findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TurntoWeb();
            }
        });

        //后退
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (webview.canGoBack())
                    webview.goBack();
                else
                    webview.loadUrl("https://www.baidu.com");
            }
        });

        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                TurntoWeb();
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        //向前
        findViewById(R.id.forward).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (webview.canGoForward())
                    webview.goForward();
            }
        });
        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                webview.reload();
            }
        });
        findViewById(R.id.top).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                webview.reload();  // 将网页滚动到顶部
            }
        });
        findViewById(R.id.backhome).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                webview.loadUrl("https://www.baidu.com");
            }
        });

        //返回
        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void TurntoWeb() {
        search_txt = searchview.getQuery().toString();
        //声明WebSettings子类
        WebSettings webSettings = webview.getSettings();

        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        // 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量）
        // 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可


        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

        webview.loadUrl("https://www.baidu.com/s?wd=" + search_txt);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });
    }
}