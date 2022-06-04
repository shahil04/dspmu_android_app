package com.example.dspmuranchi.ui.administrations;

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

public class Administration extends Fragment {
 public static Administration newInstance() {
        return new Administration();
    }

    ListView adminlist;
    String []administration ={"vc desk","dsw office","registrar","Dean office","finance Officer","Examination Section",
            "Placement-Cell office","list of university officials","list of officials and faculty members"};
AdView mAdView;
    String url;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.administration_fragment, container, false);

        mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        adminlist=(ListView)root.findViewById(R.id.administration_list_view);
        ArrayAdapter arrayAdapter=new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,administration);
        adminlist.setAdapter(arrayAdapter);

        adminlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Studentcorner_links tf=new Studentcorner_links();
//                FragmentManager fm=getFragmentManager();
//
//                FragmentTransaction t=fm.beginTransaction();
//                t.replace(R.id.nav_host_fragment,tf);
                Intent in=new Intent(getContext(), Web_downloading_activity.class);

                if(position==0)
                {
                    url="http://www.dspmuranchi.ac.in/VC-Office.aspx";

                }
                if(position==1)
                {
                    url="http://www.dspmuranchi.ac.in/DSWOffice.aspx";
                }
                if(position==2){
                    url="http://www.dspmuranchi.ac.in/RegistrarOffice.aspx";
                }
                if(position==3){
                    url="http://www.dspmuranchi.ac.in/DeanOffice.aspx";
                }

                if(position==4){
                    url="http://www.dspmuranchi.ac.in/FOOffice.aspx";
                }
                if(position==5){
                    url="http://www.dspmuranchi.ac.in/Controller_of_Examination.aspx";
                }
                if(position==6){
                    url="http://www.dspmuranchi.ac.in/Plcementoffice.aspx";
                }
                if(position==7){
                    url="http://www.dspmuranchi.ac.in/../pdf/Officials List 07.12.2018.pdf";
                }
                if(position==8){
                    url="http://www.dspmuranchi.ac.in/../pdf/List of Officials and Faculty Members.pdf";
                }
                in.putExtra("urls",url);
                in.putExtra("name",administration[position]);
                startActivity(in);

//                MainActivity mn=(MainActivity)getActivity();
//                mn.urlopen(url);
//                t.commit();

            }
        });
        return root;
    }


}
