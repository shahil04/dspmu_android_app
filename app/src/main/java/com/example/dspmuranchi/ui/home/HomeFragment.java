package com.example.dspmuranchi.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dspmuranchi.MainActivity;
import com.example.dspmuranchi.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class HomeFragment extends Fragment {
    ProgressBar progressBar;
    WebView wb;
    AdView mAdView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         View root = inflater.inflate(R.layout.fragment_home, container, false);
        progressBar = (ProgressBar)root.findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);
        
        mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        wb=(WebView) root.findViewById(R.id.home_webview);

        wb.loadUrl("http://www.dspmuranchi.ac.in/default.aspx");
        WebSettings webSettings=wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient());



//        wb.getSettings().setLoadWithOverviewMode(true);
//        wb.getSettings().setUseWideViewPort(true);
//        wb.getSettings().setSupportZoom(true);
//        wb.getSettings().setBuiltInZoomControls(true);
//        wb.getSettings().setDisplayZoomControls(false);
//        wb.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
//        wb.setScrollbarFadingEnabled(false);
        setDesktopMode(wb,true);
        wb.getSettings().setDomStorageEnabled(true);
        wb.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                //getSupportActionBar().setTitle("Loading.....Please Wait...");
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                   // getSupportActionBar().setTitle(R.string.app_name);
                }
            }
        });

        wb.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((keyCode==KeyEvent.KEYCODE_BACK)&& wb.canGoBack()){
                    wb.goBack();
                    return true;
                }
                return false;
            }
        });


   return root;
    }
    public void setDesktopMode(WebView webView,boolean enabled) {
        String newUserAgent = webView.getSettings().getUserAgentString();
        if (enabled) {
            try {
                String ua = webView.getSettings().getUserAgentString();
                String androidOSString = webView.getSettings().getUserAgentString().substring(ua.indexOf("("), ua.indexOf(")") + 1);
                newUserAgent = webView.getSettings().getUserAgentString().replace(androidOSString, "(X11; Linux x86_64)");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            newUserAgent = null;
        }

        webView.getSettings().setUserAgentString(newUserAgent);
        webView.getSettings().setUseWideViewPort(enabled);
        webView.getSettings().setLoadWithOverviewMode(enabled);
        webView.reload();
    }
}