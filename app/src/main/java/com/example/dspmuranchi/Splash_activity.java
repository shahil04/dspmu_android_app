package com.example.dspmuranchi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.DexterActivity;

public class Splash_activity extends AppCompatActivity {
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activity);
        MobileAds.initialize(this,"ca-app-pub-9024797699896095~8998920214");

        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9024797699896095/9395857101");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                dofunc();
                interstitialAd.loadAd(new AdRequest.Builder().build());


            }
        });
        getSupportActionBar().hide();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) { }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }
                else
                {
                    dofunc();
                }


            }
        },4500);
        }
    private void dofunc() {
        Intent i=new Intent(Splash_activity.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}


