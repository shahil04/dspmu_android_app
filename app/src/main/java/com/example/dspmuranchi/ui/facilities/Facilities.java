package com.example.dspmuranchi.ui.facilities;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dspmuranchi.MainActivity;
import com.example.dspmuranchi.R;
import com.example.dspmuranchi.Web_downloading_activity;
import com.example.dspmuranchi.ui.student_corner.Studentcorner_links;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Facilities extends Fragment {

   String facilities[] = {"library","hostels","canteen","medical aid","helth club","wi-fi campus"};
   ListView listView;
   String url;
    public static Facilities newInstance() {
        return new Facilities();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.facilities_fragment, container, false);
        AdView mAdView;
        mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        listView=(ListView) root.findViewById(R.id.facilities_list);
        ArrayAdapter arrayAdapter=new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,facilities);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
//                Studentcorner_links tf=new Studentcorner_links();
//                FragmentManager fm=getFragmentManager();
//                FragmentTransaction t=fm.beginTransaction();
//                t.replace(R.id.nav_host_fragment,tf);
                Intent in=new Intent(getContext(), Web_downloading_activity.class);
                if(position==0)
                {
                    url="http://www.dspmuranchi.ac.in/Facilities.aspx#Library";

                }
                if(position==1)
                {
                    url="http://www.dspmuranchi.ac.in/Facilities.aspx#Hostels";
                }
                if(position==2){
                    url="http://www.dspmuranchi.ac.in/Facilities.aspx#Canteen";
                }
                if(position==3){
                    url="http://www.dspmuranchi.ac.in/Facilities.aspx#Medical";
                }

                if(position==4){
                    url="http://www.dspmuranchi.ac.in/Facilities.aspx#Health";
                }
                if(position==5){
                    url="http://www.dspmuranchi.ac.in/Facilities.aspx#Campus";
                }
                in.putExtra("urls",url);
                in.putExtra("name",facilities[position]);
                startActivity(in);
//
//                MainActivity mn=(MainActivity)getActivity();
//                mn.urlopen(url);
//                t.commit();
            }
        });
        return root;
    }


}
