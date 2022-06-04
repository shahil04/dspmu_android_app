package com.example.dspmuranchi.ui.actions;


import android.Manifest;
import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.app.DownloadManager;
import com.example.dspmuranchi.MainActivity;
import com.example.dspmuranchi.R;
import com.example.dspmuranchi.Web_downloading_activity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import static android.content.Context.DOWNLOAD_SERVICE;


public class Examination_updates extends Fragment {

WebView wb;
ProgressBar progressBar;
AdView mAdView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_latest_news, container, false);
        wb=(WebView)view.findViewById(R.id.latest_newsweb);
        progressBar=(ProgressBar)view.findViewById(R.id.progress);

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        wb.loadUrl("http://www.dspmuranchi.ac.in/Examination_news.aspx");
        WebSettings ws=wb.getSettings();
        ws.setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient());
        wb.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(final String url, final String userAgent, final String contentDisposition, final String mimetype, long contentLength) {
                DownloadManager.Request request=new DownloadManager.Request(
                        Uri.parse(url));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                String filename=URLUtil.guessFileName(url,null, MimeTypeMap.getFileExtensionFromUrl(url));
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,filename);
                DownloadManager dm=(DownloadManager)getActivity().getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getContext(),"Downloading file ",Toast.LENGTH_SHORT).show();


            }
        });
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
//

        return view;
    }

}
