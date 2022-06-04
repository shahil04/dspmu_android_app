package com.example.dspmuranchi.ui.guidlines;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dspmuranchi.MainActivity;
import com.example.dspmuranchi.R;
import com.example.dspmuranchi.Web_downloading_activity;
import com.example.dspmuranchi.ui.student_corner.Studentcorner_links;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class GuidlinesFragment extends Fragment {

   String guidlines[]={"fill admission form online(offers courses and details)","INSTRUCTIONS AND PROCEDURE FOR SUBMISSION OF ONLINE APPLICATION FORM",
           "subjects offers","ONLINE APPLICATION FEES PAYMENT TERMS & CONDITION","total student catagorywise",
           "total form sale Details","total student in deptament","chancellor portal"};

   ListView listView;
   String url;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       final View root = inflater.inflate(R.layout.fragment_guidlines, container, false);

        AdView mAdView;
        mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        listView=(ListView)root.findViewById(R.id.guidlines_listview);
        ArrayAdapter arrayAdapter=new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,guidlines);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
//                Studentcorner_links tf=new Studentcorner_links();
//                FragmentManager fm=getFragmentManager();
//                FragmentTransaction t=fm.beginTransaction();
//                t.replace(R.id.nav_host_fragment,tf);
                Intent in=new Intent(getContext(),Web_downloading_activity.class);
                if(position==0)
                {
                    url="http://www.dspmuranchi.ac.in/GuidelineForApplicationForm.aspx";

                }
                if(position==1)
                {
                    url="http://www.dspmuranchi.ac.in/InstructionForApplicationForm.aspx#Fees";
                }
                if(position==2){
                    url="http://www.dspmuranchi.ac.in/pdf/subject%20Offered.pdf";
                }
                if(position==3){
                    url="http://www.dspmuranchi.ac.in/TermsAndConditions.aspx";
                }

                if(position==4){
                    url="http://www.dspmuranchi.ac.in/TotalStudentCategoryWise.aspx";
                }
                if(position==5){
                    url="http://www.dspmuranchi.ac.in/TotalFormSaleDetails.aspx";
                }
                if(position==6){
                    url="http://www.dspmuranchi.ac.in/TotalStudentinDept.aspx";
                }
                if(position==7){
                    url="https://jharkhanduniversities.nic.in/home";
                }
                in.putExtra("urls",url);
                in.putExtra("name",guidlines[position]);
                startActivity(in);
//                MainActivity mn=(MainActivity)getActivity();
//                mn.urlopen(url);
//                t.commit();
            }
        });
        return root;
    }
}