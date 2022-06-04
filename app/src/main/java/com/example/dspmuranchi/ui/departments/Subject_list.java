package com.example.dspmuranchi.ui.departments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dspmuranchi.R;
import com.example.dspmuranchi.Web_downloading_activity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class Subject_list extends Fragment {
AdView mAdView;
    String phd[] = {"Ph.D in Bengali", "Ph.D in English", "Ph.D in Hindi", "Ph.D in Sanskrit",
            "Ph.D in TRL", "Ph.D in Urdu", "Ph.D in Botany", "Ph.D in Chemistry", "Ph.D in Geology",
            "Ph.D in Mathematics", "Ph.D in Physics", "Ph.D in Zoology", "Ph.D in Anthropology",
            "Ph.D in Economics", "Ph.D in Geography", "Ph.D in History", "Ph.D in Philosophy",
            "Ph.D in Pol. Science", "Ph.D in Psychology", "Ph.D in Environmental Science",
            "Ph.D in Microbiology", "Ph.D in MCA & M.Sc. (IT)"};

    String phd_url[]={"1086","1087","1088","1089","1090","1091","1092","1093","1094",
            "1095","1096","1097","1098","1099","1100","1101","1102","1103","1104","1105","1106","1107"};

    //humanities
    String hug[]={"Bengali","English","Hindi","Ho","Kharia","Khortha","Kurmali",
            "Kurux","Mundari","Nagpuri","PanchPargania","Odia","Philosophy",
            "Sanskrit","Santhali","Urdu"};
    String hug_url[]={"1","3","5","1082","1038","1039","7","8","9","10","1075","1037","1036","13","1077","14"};

    //humanities
    String hpg[]={"Bengali","English","Hindi","Ho","Kharia","Khortha","Kurmali",
            "Kurux","Mundari","Nagpuri","PanchPargania","Odia","Philosophy",
            "Sanskrit","Santhali","Urdu"};
    String hpg_url[]={"1068","1069","1048","1084","1061","1062","1063","1058","1059","1060","1076","1050","1070","1071","1078","1055"};

    //science
    String sug[]={"Botany","Chemistry","Mathematics","Physics","Geology","Zoology"};
    String sug_url[]={"16","17","18","19","1040","20"};

    //science
    String spg[]={"Botany","Chemistry","Mathematics","Physics","Geology","Zoology"};
    String spg_url[]={"1041","1042","1043","1044","1085","1045"};

    //sst
    String ssug[]={"Anthropology","Economics","Geography","History","Mathematics (Arts)",
            "Political Science","Psychology","Sociology"};
    String ssug_url[]={"1035","2","4","6","1064","11","12","1066"};
    //sst
    String sspg[]={"Anthropology","Economics","Geography","History","Mathematics (Arts)",
            "Political Science","Psychology","Sociology"};
    String sspg_url[]={"1057","1046","1047","1049","1065","1051","1056","1067"};
    //vocational
    String vug[]={"B.Sc. Computer Application","B.Sc. Information Technology","B.Sc. Electronics",
            "B.Sc. Environmental Science","B.Sc. Microbiology","B.Sc. Nano Science &Nano Technology","BBA",
            "Bachelor Programme in Film Making","Bachelor Programme in Journalism and Mass Communication"};
    String vug_url[]={"1028","1029","1032","1031","1027","1074","1026","1123","1124"};
    //vocational
    String vpg[]={"B.Sc. Computer Application","B.Sc. Information Technology","B.Sc. Electronics",
            "B.Sc. Environmental Science","B.Sc. Microbiology","B.Sc. Nano Science &Nano Technology","BBA",
            "Bachelor Programme in Film Making","Bachelor Programme in Journalism and Mass Communication"};
    String vpg_url[]={"22","1023","1024","1025","1073","1052","1022","1118","1119"};

    //certificate
    String certifiate[]={"Amanat","TDM","Certificate in Office Automation","Certificate in Web Designing",
            "Certificate in Multimedia Development","Certificate in PC-Hardware & Networking(A+,N+)",
            "Certificate in ASP.Net with C#","certificate in Advanced Development using PHP",
            "certificate in Network Administratation","certificate in Advanced JAVA(J2EE)",
            "certificate in Information Security & Cyber LAW",
            "certificate in Oracle SQL & PL/SQL","Certificate in Journalism and Mass Communication"};
    String certifiate_url[]={"1034","1079","1108","1109","1110","1111","1112","1113","1114","1115","1116","1117","1121"};
    //diploma
    String diploma[]={"GIS","PG Diploma in Hospital Management","PG Diploma in Counselling Guidance & Re-habilitation",
            "Diploma in Journalism and Mass Communication","PG Diploma in Performing Arts"};
    String diploma_url[]={"1033","1080","1081","1122","1120"};




    ListView lv;
String  url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subject_list, container, false);

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        lv = (ListView) view.findViewById(R.id.subject_list);

        String str=getArguments().getString("str");
        Integer value = getArguments().getInt("position");

            if (value==0) {
                //phd
                ArrayAdapter array = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, phd);
                lv.setAdapter(array);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent in = new Intent(getContext(), Web_downloading_activity.class);
                        if ((position == 0)||(position ==1)||(position == 2)||(position == 3)||(position == 4)
                                ||(position == 5)||(position == 6)||(position == 7)||(position == 8)||(position == 9)
                                ||(position ==10)||(position ==11)||(position ==12)||(position ==13)||(position ==14)
                                ||(position ==15)||(position ==16)||(position ==17)||(position ==18)||(position ==19)
                                ||(position ==20)||(position ==21))
                        {
                            url ="http://www.dspmuranchi.ac.in/Departments.aspx?pid="+phd_url[position];
                        }
                        in.putExtra("urls", url);
                        in.putExtra("name",phd[position]);
                        startActivity(in);
                    }
                });
            }
            //end phd

            else if (value==1){
                //humanities
                ArrayAdapter array = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,hug);
                lv.setAdapter(array);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent in = new Intent(getContext(), Web_downloading_activity.class);
                        if ((position == 0)||(position ==1)||(position == 2)||(position == 3)||(position == 4)
                                ||(position == 5)||(position == 6)||(position == 7)||(position == 8)||(position == 9)
                                ||(position ==10)||(position ==11)||(position ==12)||(position ==13)||(position ==14)
                                ||(position ==15))
                        {
                            url ="http://www.dspmuranchi.ac.in/Departments.aspx?pid="+hug_url[position];
                        }
                        in.putExtra("urls", url);
                        in.putExtra("name",hug[position]);
                        startActivity(in);
                    }
                });
            }
            else if (value==2){
                ArrayAdapter array = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,hpg);
                lv.setAdapter(array);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent in = new Intent(getContext(), Web_downloading_activity.class);
                        if ((position == 0)||(position ==1)||(position == 2)||(position == 3)||(position == 4)
                                ||(position == 5)||(position == 6)||(position == 7)||(position == 8)||(position == 9)
                                ||(position ==10)||(position ==11)||(position ==12)||(position ==13)||(position ==14)
                                ||(position ==15))
                        {
                            url ="http://www.dspmuranchi.ac.in/Departments.aspx?pid="+hpg_url[position];
                        }
                        in.putExtra("urls", url);
                        in.putExtra("name",hpg[position]);
                        startActivity(in);
                    }
                });
            }
            else if (value==3){
                ArrayAdapter array = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,sug);
                lv.setAdapter(array);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent in = new Intent(getContext(), Web_downloading_activity.class);
                        if ((position == 0)||(position ==1)||(position == 2)||(position == 3)||(position == 4)
                                ||(position == 5))
                        {
                            url ="http://www.dspmuranchi.ac.in/Departments.aspx?pid="+sug_url[position];
                        }
                        in.putExtra("urls", url);
                        in.putExtra("name",sug[position]);
                        startActivity(in);
                    }
                });
            }
            else if (value==4){
                ArrayAdapter array = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,spg);
                lv.setAdapter(array);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent in = new Intent(getContext(), Web_downloading_activity.class);
                        if ((position == 0)||(position ==1)||(position == 2)||(position == 3)||(position == 4)
                                ||(position == 5))
                        {
                            url ="http://www.dspmuranchi.ac.in/Departments.aspx?pid="+spg_url[position];
                        }
                        in.putExtra("urls", url);
                        in.putExtra("name",spg[position]);
                        startActivity(in);
                    }
                });
            }
            else if (value==5){
                ArrayAdapter array = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,ssug);
                lv.setAdapter(array);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent in = new Intent(getContext(), Web_downloading_activity.class);
                        if ((position == 0)||(position ==1)||(position == 2)||(position == 3)||(position == 4)
                                ||(position == 5)||(position == 6)||(position == 7))
                        {
                            url ="http://www.dspmuranchi.ac.in/Departments.aspx?pid="+ssug_url[position];
                        }
                        in.putExtra("urls", url);
                        in.putExtra("name",ssug[position]);
                        startActivity(in);
                    }
                });
            }
            else if (value==6){
                ArrayAdapter array = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,sspg);
                lv.setAdapter(array);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent in = new Intent(getContext(), Web_downloading_activity.class);
                        if ((position == 0)||(position ==1)||(position == 2)||(position == 3)||(position == 4)
                                ||(position == 5)||(position == 6)||(position == 7))
                        {
                            url ="http://www.dspmuranchi.ac.in/Departments.aspx?pid="+sspg_url[position];
                        }
                        in.putExtra("urls", url);
                        in.putExtra("name",sspg[position]);
                        startActivity(in);
                    }
                });
            }
            else if (value==7){
                ArrayAdapter array = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,vug);
                lv.setAdapter(array);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent in = new Intent(getContext(), Web_downloading_activity.class);
                        if ((position == 0)||(position ==1)||(position == 2)||(position == 3)||(position == 4)
                                ||(position == 5)||(position == 6)||(position == 7)||(position == 8))
                        {
                            url ="http://www.dspmuranchi.ac.in/Departments.aspx?pid="+vug_url[position];
                        }
                        in.putExtra("urls", url);
                        in.putExtra("name",vug[position]);
                        startActivity(in);
                    }
                });
            }
            else if (value==8){
                ArrayAdapter array = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,vpg);
                lv.setAdapter(array);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent in = new Intent(getContext(), Web_downloading_activity.class);
                        if ((position == 0)||(position ==1)||(position == 2)||(position == 3)||(position == 4)
                                ||(position == 5)||(position == 6)||(position == 7)||(position == 8))
                        {
                            url ="http://www.dspmuranchi.ac.in/Departments.aspx?pid="+vpg_url[position];
                        }
                        in.putExtra("urls", url);
                        in.putExtra("name",vpg[position]);
                        startActivity(in);
                    }
                });
            }
            else if (value==9){
                ArrayAdapter array = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,certifiate);
                lv.setAdapter(array);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent in = new Intent(getContext(), Web_downloading_activity.class);
                        if ((position == 0)||(position ==1)||(position == 2)||(position == 3)||(position == 4)
                                ||(position == 5)||(position == 6)||(position == 7)||(position == 8)||(position == 9)
                                ||(position ==10)||(position ==11)||(position ==12))
                        {
                            url ="http://www.dspmuranchi.ac.in/Departments.aspx?pid="+certifiate_url[position];
                        }
                        in.putExtra("urls", url);
                        in.putExtra("name",certifiate[position]);
                        startActivity(in);
                    }
                });
            }
            else if (value==10){
                ArrayAdapter array = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,diploma);
                lv.setAdapter(array);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent in = new Intent(getContext(), Web_downloading_activity.class);
                        if ((position == 0)||(position ==1)||(position == 2)||(position == 3)||(position == 4))
                        {
                            url ="http://www.dspmuranchi.ac.in/Departments.aspx?pid="+diploma_url[position];
                        }
                        in.putExtra("urls", url);
                        in.putExtra("name",diploma[position]);
                        startActivity(in);
                    }
                });
            }
            return view;

            }


    }



