package com.example.dspmuranchi.ui.student_corner;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.dspmuranchi.MainActivity;
import com.example.dspmuranchi.R;
import com.example.dspmuranchi.Web_downloading_activity;
import com.example.dspmuranchi.ui.gallery.GalleryFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Student_cornerFragment extends Fragment {

    String url;
    ListView list;
    String[]subtitle={"Admission","Syllabus","Examination","Results","Facilities","Scholarship","Placement Details","Career","NCC","NSS","Student Union"};
    TextView tvs;
    WebView b;
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState)
    {
        final View root = inflater.inflate(R.layout.fragment_student_corner, container, false);

        AdView mAdView;
        mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        list=(ListView)root.findViewById(R.id.listview);
        ArrayAdapter listarray=new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,subtitle);
        list.setAdapter(listarray);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Studentcorner_links tf=new Studentcorner_links();
//                FragmentManager fm=getFragmentManager();
//                FragmentTransaction t=fm.beginTransaction();
//                t.replace(R.id.nav_student_corner,tf);
                Intent in= new Intent(getContext(), Web_downloading_activity.class);

                if(position==0)
                {
                    url="http://www.dspmuranchi.ac.in/Admission.aspx";

                }
                if(position==1)
                {
                    url="http://www.dspmuranchi.ac.in/Syllabus.aspx";
                }
                if(position==2){
                    url="http://www.dspmuranchi.ac.in/Examination_news.aspx";
                }
                if(position==3){
                    url="http://www.dspmuranchi.ac.in/Result.aspx";
                }

                if(position==4){
                    url="http://www.dspmuranchi.ac.in/Facilities.aspx#Hostel";
                }
                if(position==5){
                    url="http://www.dspmuranchi.ac.in/../pdf/Post Matric (Within State and Outside State )2019-20 Advt (Lt. no. 902 Dt. 12.07.2019) .pdf";
                }
                if(position==6){
                    url="http://www.dspmuranchi.ac.in/#/team-listing/";
                }
                if(position==7){
                    url="http://www.dspmuranchi.ac.in/#/team-listing/";
                }
                if(position==8){
                    url="http://www.dspmuranchi.ac.in//NCC/ncc_home.aspx";
                }
                if(position==9){
                    url="http://www.dspmuranchi.ac.in/../pdf/NSSBlood.pdf";
                }
                if(position==10){
                    url="http://www.dspmuranchi.ac.in/../StudentsUnionElection.aspx";
                }

                in.putExtra("urls",url);
                in.putExtra("name",subtitle[position]);
                startActivity(in);
//                MainActivity mn=(MainActivity)getActivity();
//                mn.urlopen(url);
//                t.commit();


            }
        });
        return root;
    }
}

