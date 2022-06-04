package com.example.dspmuranchi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.example.dspmuranchi.ui.actions.Examination_updates;
import com.example.dspmuranchi.ui.actions.Latest_news;
import com.example.dspmuranchi.ui.actions.Readmission;
import com.example.dspmuranchi.ui.student_corner.Studentcorner_links;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent in=new Intent(MainActivity.this,Pdf_show_activity.class);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                startActivity(in);
//
//            }
//        });
        MobileAds.initialize(this,"ca-app-pub-9024797699896095~8998920214");
     //Interstitialad add
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9024797699896095/9395857101");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                finish();
                interstitialAd.loadAd(new AdRequest.Builder().build());


            }
        });

        ////Cheeck the internet connection



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_student_corner,
                R.id.nav_department, R.id.nav_share, R.id.nav_send,R.id.stcorner,
                R.id.nav_guidelines,R.id.nav_administration,R.id.nav_facilties,R.id.nav_actionwebview)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    public boolean onNavigationItemSelected(MenuItem item){

        int id=item.getItemId();
        if (id==R.id.nav_send){
            Toast.makeText(this,"hii",Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item)
//    {
//        FragmentManager fm=getFragmentManager();
//        FragmentTransaction t=fm.beginTransaction();
//        Action_fragment gf=new Action_fragment();
//
        //WebView webView;
//        int ids=item.getItemId();
//        if(ids==R.id.action_latest_news)
//        {
//
//            webView=(WebView)findViewById(R.id.gallary_webView);
//            webView.loadUrl("http://www.dspmuranchi.ac.in/Gallery.aspx");
//
//            WebSettings webSettings=webView.getSettings();
//            webSettings.setJavaScriptEnabled(true);
//            webView.setWebViewClient(new WebViewClient());

//            Toast.makeText(this,"this is link",Toast.LENGTH_LONG).show();
//            t.replace(android.R.id.content,gf);
////                   inflater.inflate(R.layout.fragment_gallery, container, false);
//            t.commit();


    //    }
//        if(ids==R.id.action_readmission){
//            Toast.makeText(this,"this is reaadmission",Toast.LENGTH_SHORT).show();
//        }

//        return true;
//    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    boolean exit=false;
InterstitialAd interstitialAd;

    public void onBackPressed() {
//        tellfragment();
//        super.onBackPressed();}
//
//    private void tellfragment() {
//        List<Fragment> fragments=getSupportFragmentManager().getFragments();
//        for(Fragment f:fragments){
//            if (f!=null && f instanceof BaseFragment)
//                ((BaseFragment)f).onBackPressed();
//        }
//    }

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            int count = getSupportFragmentManager().getBackStackEntryCount();
            if (count == 0) {
                if (exit) {
                finish();
            } else {
                    if(interstitialAd.isLoaded()){
                        interstitialAd.show();
                    }
                    else
                    {
                        Toast.makeText(this, "Tap back buttons to exit", Toast.LENGTH_SHORT).show();
                    }
                }
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        exit = false;

                    }
                }, 2000);
                exit = true;

//                Toast.makeText(this, "Tap back buttons to exit", Toast.LENGTH_SHORT).show();
//                super.onBackPressed();
            } else {
                getSupportFragmentManager().popBackStack();
            }
      }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction t = fm.beginTransaction();

        int ids=item.getItemId();
        if (ids==R.id.refresh){

            finish();
            overridePendingTransition(0,0);
            startActivity(getIntent());
            overridePendingTransition(0,0);
//            Log.i("LOG_TAG","Refresh item selected");
//            SwipeRefreshLayout myswipeRefreshLayout=new SwipeRefreshLayout();
//            myswipeRefreshLayout.setRefreshing(true);
//            myUpdateOperation();
//            return true;
        }

        if(ids==R.id.action_exam_news)
        {
            Fragment frag = new Examination_updates();
            t.replace(R.id.nav_host_fragment, frag);
        }

       if(ids==R.id.action_latest_news)
                {
                Fragment frag = new Latest_news();
                t.replace(R.id.nav_host_fragment, frag);
                }

       if(ids==R.id.action_readmission)
                {
                Fragment frage = new Readmission();
                t.replace(R.id.nav_host_fragment, frage);
            }
       t.addToBackStack(null);
       t.commit();

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


//
//    public static boolean isConnected(Context context){
//        ConnectivityManager cm=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo wifiInfo=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        NetworkInfo mobileInfo=cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//
//        if ((wifiInfo!=null && wifiInfo.isConnected())||(mobileInfo!=null && mobileInfo.isConnected())){
//            return true;
//        }
//        else {
//            showDialog();
//            return false;
//        }
//        private void showDialog() {
//            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
//            builder.setMessage("Connect to wifi or quit").setCancelable(false)
//                    .setPositiveButton("Connect to wifi", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
//                        }
//                    })
//                    .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            MainActivity.this.finish();
//                        }
//                    });
//            AlertDialog alert=builder.create();
//            alert.show();
//        }
//    }


}

