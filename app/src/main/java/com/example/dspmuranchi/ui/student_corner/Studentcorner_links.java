package com.example.dspmuranchi.ui.student_corner;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dspmuranchi.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Studentcorner_links extends Fragment {

     WebView wb;
    String url1;
    TextView tv;
    public Studentcorner_links() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_studentcorner_links, container, false);

        AdView mAdView;
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        tv=(TextView) view.findViewById(R.id.textView);
        Bundle b2=getArguments();
        if(b2!=null)
        {
            url1=b2.getString("url");
           tv.setText(url1);
        }
        wb=(WebView)view.findViewById(R.id.student_corner_webview);
        wb.loadUrl(url1);
        WebSettings ws=wb.getSettings();
        ws.setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient());
    return view;
    }

}
