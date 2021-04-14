package com.ymars.poj.base.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.ImmersionBar;
import com.ymars.poj.base.R;
import com.ymars.poj.base.databinding.ActivityMywebviewBinding;
import com.ymars.poj.comutils.LogTools;
import com.ymars.poj.comutils.StringTools;

import static android.view.KeyEvent.KEYCODE_BACK;

@Route(path = "/base/MyWebViewActivity")
public class MyWebViewActivity extends BaseActivity<ActivityMywebviewBinding> {
    private WebView webView;
    private ProgressBar loadingPb;
    private String url = null;

    @Override
    protected int setLayoutId(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_mywebview;
    }

    @Override
    protected void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.transparent).statusBarDarkFont(true).init();
        webView = viewBinding.webView;
        loadingPb = viewBinding.loadingPb;
        url = getIntent().getStringExtra("url");
        initWebView();
        loadUrl();
    }

    private void initWebView() {
        if (webView != null) {
            WebSettings webSettings = webView.getSettings();

            webSettings.setJavaScriptEnabled(true); //是否开启JS支持
//            webSettings.setPluginsEnabled(true); //是否开启插件支持
            webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //是否允许JS打开新窗口

            webSettings.setUseWideViewPort(true); //缩放至屏幕大小
            webSettings.setLoadWithOverviewMode(true); //缩放至屏幕大小
            webSettings.setSupportZoom(true); //是否支持缩放
            webSettings.setBuiltInZoomControls(true); //是否支持缩放变焦，前提是支持缩放
            webSettings.setDisplayZoomControls(false); //是否隐藏缩放控件

            webSettings.setAllowFileAccess(true); //是否允许访问文件
            webSettings.setDomStorageEnabled(true); //是否节点缓存
            webSettings.setDatabaseEnabled(true); //是否数据缓存
            webSettings.setAppCacheEnabled(true); //是否应用缓存
//            webSettings.setAppCachePath(uri); //设置缓存路径

            webSettings.setMediaPlaybackRequiresUserGesture(false); //是否要手势触发媒体
            webSettings.setStandardFontFamily("sans-serif"); //设置字体库格式
            webSettings.setFixedFontFamily("monospace"); //设置字体库格式
            webSettings.setSansSerifFontFamily("sans-serif"); //设置字体库格式
            webSettings.setSerifFontFamily("sans-serif"); //设置字体库格式
            webSettings.setCursiveFontFamily("cursive"); //设置字体库格式
            webSettings.setFantasyFontFamily("fantasy"); //设置字体库格式
            webSettings.setTextZoom(100); //设置文本缩放的百分比
            webSettings.setMinimumFontSize(8); //设置文本字体的最小值(1~72)
            webSettings.setDefaultFontSize(16); //设置文本字体默认的大小

            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); //按规则重新布局
            webSettings.setLoadsImagesAutomatically(false); //是否自动加载图片
            webSettings.setDefaultTextEncodingName("UTF-8"); //设置编码格式
            webSettings.setNeedInitialFocus(true); //是否需要获取焦点
            webSettings.setGeolocationEnabled(false); //设置开启定位功能
            webSettings.setBlockNetworkLoads(false); //是否从网络获取资源

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    LogTools.i(TAG, "加载onPageStarted");
                    LogTools.i(TAG, "加载url" + url);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    LogTools.i(TAG, "加载onPageFinished");
                }

                @Override
                public void onLoadResource(WebView view, String url) {
                    super.onLoadResource(view, url);
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true; // 消费事件终止传递
                }

                @Override
                public void onReceivedError(WebView view, int errorCode,
                                            String description, String failingUrl) {
                    view.loadUrl("file:///android_assets/error.html"); //assets目录下放置文件
                }
            });

            webView.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    super.onProgressChanged(view, newProgress);
                    LogTools.i(TAG, String.format("加载进度:%s", newProgress));
                    loadingPb.setProgress(newProgress);
                    if (newProgress < 80) {
                        loadingPb.setVisibility(View.VISIBLE);
                    } else {
                        loadingPb.setVisibility(View.GONE);
                    }
                }
            });
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        } else {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void loadUrl() {
        if (StringTools.strIsNotNull(url) && webView != null) {
            webView.loadUrl(url);
        }
    }
}
