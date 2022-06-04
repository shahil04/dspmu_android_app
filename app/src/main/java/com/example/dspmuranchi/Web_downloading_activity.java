package com.example.dspmuranchi;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DownloadManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class Web_downloading_activity extends AppCompatActivity
{
    WebView wb;
    ProgressBar progressBar;
    private String url1 ,subtitle;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);
        MobileAds.initialize(this,"ca-app-pub-9024797699896095~8998920214");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        Intent in = getIntent();
        Bundle b = in.getExtras();
        url1 = b.getString("urls");
        subtitle=b.getString("name");
        wb = (WebView) findViewById(R.id.web_activity_view);
//         url1="http://www.dspmuranchi.ac.in/News.aspx";

        wb.loadUrl(url1);
        WebSettings ws = wb.getSettings();
        ws.setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient());

        wb.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(final String url, final String userAgent, final String contentDisposition, final String mimetype, long contentLength) {
                Dexter.withActivity(Web_downloading_activity.this)
                        .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {
                                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                                request.setMimeType(mimetype);

                                String cookies = CookieManager.getInstance().getCookie(url);
                                request.addRequestHeader("cookie", cookies);
                                request.addRequestHeader("User-Agent", userAgent);
                                request.setDescription("downlading files");
                                request.setTitle(URLUtil.guessFileName(url, userAgent, contentDisposition));
                                request.allowScanningByMediaScanner();
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                request.setDestinationInExternalPublicDir(
                                        Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(
                                                url, contentDisposition, mimetype));
                                DownloadManager dowloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                                dowloadManager.enqueue(request);
                                Toast.makeText(Web_downloading_activity.this, "Start downloading....", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                                token.continuePermissionRequest();
                            }
                        }).check();

            }
        });

        wb.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                getSupportActionBar().setTitle("Loading   Please Wait...");
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                    getSupportActionBar().setTitle(subtitle);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
    int count=getSupportFragmentManager().getBackStackEntryCount();
    if (count==0){
        super.onBackPressed();
    }
    else {
        getSupportFragmentManager().popBackStack();
    }
    }

    //Check internet connection and wifi connectio
//    private  boolean haveNetworkConnection(){
//        boolean haveConnectedwifi=false;
//        boolean haveConnectedMobile=false;
//        ConnectivityManager cm=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo[] netInfo=cm.getAllNetworkInfo();
//        for (NetworkInfo ni :netInfo){
//         if (ni.getTypeName().equalsIgnoreCase("WIFI"))
//             if (ni.isConnected())
//                 haveConnectedwifi=true;
//
//         if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
//             if (ni.isConnected())
//                 haveConnectedMobile=true;
//        }
//        return haveConnectedwifi||haveConnectedMobile;
//    }
}
