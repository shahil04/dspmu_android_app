package com.example.dspmuranchi.ui.departments;

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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.dspmuranchi.MainActivity;
import com.example.dspmuranchi.R;
import com.example.dspmuranchi.Web_downloading_activity;
import com.example.dspmuranchi.ui.student_corner.Studentcorner_links;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class DepartmentFragment extends Fragment {


    String []department={"Ph.D","Humanities  (UG)","Humanities  (PG)","Science  (UG)","Science  (PG)","Social Science  (UG)",
            "Social Science  (PG)","Vocational  (UG)","Vocational  (PG)","Certificate","Diploma"};
    ListView ls,sls;
    String url,str;
    int pos;
AdView mAdView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_departments, container, false);
        ls=(ListView)root.findViewById(R.id.department_list);

        mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ArrayAdapter array=new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,department);
        ls.setAdapter(array);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment tf=new Subject_list();
                Bundle args=new Bundle();

                if(position==0){
                    //phd
                    pos=position;
                    args.putInt("position",pos);
                    args.putString("name",department[pos]);
                }
                    //Ph.D in Bengali
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1086
                    //Ph.D in English
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1087
                    //16
                    //Ph.D in Hindi
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1088
                    //17
                    //Ph.D in Sanskrit
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1089
                    //18
                    //Ph.D in TRL
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1090
                    //19
                    //Ph.D in Urdu
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1091
                    //20
                    //Ph.D in Botany
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1092
                    //21
                    //Ph.D in Chemistry
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1093
                    //22
                    //Ph.D in Geology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1094
                    //23
                    //Ph.D in Mathematics
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1095
                    //24
                    //Ph.D in Physics
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1096
                    //25
                    //Ph.D in Zoology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1097
                    //26
                    //Ph.D in Anthropology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1098
                    //27
                    //Ph.D in Economics
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1099
                    //28
                    //Ph.D in Geography
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1100
                    //29
                    //Ph.D in History
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1101
                    //30
                    //Ph.D in Philosophy
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1102
                    //31
                    //Ph.D in Pol. Science
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1103
                    //32
                    //Ph.D in Psychology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1104
                    //33
                    //Ph.D in Environmental Science
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1105
                    //34
                    //Ph.D in Microbiology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1106
                    //35
                    //Ph.D in MCA & M.Sc. (IT)
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1107
                    //36

                if(position==1){
                    //humanities ug
                   pos=position;
                   args.putInt("position",pos);
                    args.putString("name",department[pos]);
                    //Bengali
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1
                    //61
                    //
                    //
                    //English
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=3
                    //62
                    //
                    //
                    //Hindi
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=5
                    //63
                    //
                    //
                    //Ho
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1082
                    //64
                    //
                    //
                    //Kharia
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1038
                    //65
                    //
                    //
                    //Khortha
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1039
                    //66
                    //
                    //
                    //Kurmali
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=7
                    //67
                    //
                    //
                    //Kurux
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=8
                    //68
                    //
                    //
                    //Mundari
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=9
                    //69
                    //
                    //
                    //Nagpuri
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=10
                    //70
                    //
                    //
                    //PanchPargania
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1075
                    //71
                    //
                    //
                    //Odia
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1037
                    //72
                    //
                    //
                    //Philosophy
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1036
                    //73
                    //
                    //
                    //Sanskrit
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=13
                    //74
                    //
                    //
                    //Santhali
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1077
                    //75
                    //
                    //
                    //Urdu
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=14
                    //76
                    }
                if (position==2){
                    //humanities pg
                    pos=position;
                    args.putInt("position",pos);
//                    Bengali
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1068
//                    78
//
//
//                    English
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1069
//                    79
//
//
//                    Hindi
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1048
//                    80
//
//
//                    Ho
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1084
//                    81
//
//
//                    Kharia
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1061
//                    82
//
//
//                    Khortha
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1062
//                    83
//
//
//                    Kurmali
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1063
//                    84
//
//
//                    Kurux
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1058
//                    85
//
//
//                    Mundari
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1059
//                    86
//
//
//                    Nagpuri
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1060
//                    87
//
//
//                    PanchPargania
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1076
//                    88
//
//
//                    Odia
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1050
//                    89
//
//
//                    Philosophy
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1070
//                    90
//
//
//                    Sanskrit
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1071
//                    91
//
//
//                    Santhali
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1078
//                    92
//
//
//                    Urdu
//                    http://www.dspmuranchi.ac.in/Departments.aspx?pid=1055
//                    93

                }

                if(position==3){
                    //science ug
                    pos=position;
                    args.putInt("position",pos);
                    //Botany
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=16
                    //162
                    //
                    //
                    //Chemistry
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=17
                    //163
                    //
                    //
                    //Geology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1040
                    //164
                    //
                    //
                    //Mathematics
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=18
                    //165
                    //
                    //
                    //Physics
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=19
                    //166
                    //
                    //
                    //Zoology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=20
                    //167
                }
                if (position==4){
                    //science pg
                    pos=position;
                    args.putInt("position",pos);
                    args.putString("name",department[pos]);
                    //Botany
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1041
                    //169
                    //
                    //
                    //Chemistry
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1042
                    //170
                    //
                    //
                    //Mathematics
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1043
                    //171
                    //
                    //
                    //Physics
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1044
                    //172
                    //
                    //
                    //Geology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1085
                    //173
                    //
                    //
                    //Zoology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1045
                    //174

                }
                if(position==5){
                 //sst ug
                    pos=position;
                    args.putInt("position",pos);
                    args.putString("name",department[pos]);
                    //Anthropology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1035
                    //203
                    //
                    //
                    //Economics
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=2
                    //204
                    //
                    //
                    //Geography
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=4
                    //205
                    //
                    //
                    //History
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=6
                    //206
                    //
                    //
                    //Mathematics (Arts)
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1064
                    //207
                    //
                    //
                    //Political Science
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=11
                    //208
                    //
                    //
                    //Psychology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=12
                    //209
                    //
                    //
                    //Sociology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1066
                    //210
                }
                if (position==6){
                    //sst pg
                    pos=position;
                    args.putInt("position",pos);
                    args.putString("name",department[pos]);
                    //Anthropology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1057
                    //212
                    //
                    //
                    //Economics
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1046
                    //213
                    //
                    //
                    //Geography
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1047
                    //214
                    //
                    //
                    //History
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1049
                    //215
                    //
                    //
                    //Mathematics
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1065
                    //216
                    //
                    //
                    //Political Science
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1051
                    //217
                    //
                    //
                    //Psychology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1056
                    //218
                    //
                    //
                    //Sociology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1067
                    //219
                }
                if(position==7){
                    //vocational ug
                    pos=position;
                    args.putInt("position",pos);
                    args.putString("name",department[pos]);
                    //B.Sc. Computer Application
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1028
                    //256
                    //
                    //
                    //B.Sc. Information Technology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1029
                    //257
                    //
                    //
                    //B.Sc. Electronics
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1032
                    //258
                    //
                    //
                    //B.Sc. Environmental Science
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1031
                    //259
                    //
                    //
                    //B.Sc. Microbiology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1027
                    //260
                    //
                    //
                    //B.Sc. Nano Science &Nano Technology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1074
                    //261
                    //
                    //
                    //BBA
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1026
                    //262
                    //
                    //
                    //Bachelor Programme in Film Making
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1123
                    //263
                    //
                    //
                    //Bachelor Programme in Journalism and Mass Communication
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1124
                    //264
                }
                if (position==8){
                    //vocational pg
                    pos=position;
                    args.putInt("position",pos);
                    args.putString("name",department[pos]);
                    //vocational pg
                    //MCA
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=22
                    //266
                    //
                    //
                    //M.Sc. Information Technology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1023
                    //267
                    //
                    //
                    //LL.M.
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1024
                    //268
                    //
                    //
                    //M.Sc. Environmental Science
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1025
                    //269
                    //
                    //
                    //M.Sc. Microbiology
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1073
                    //270
                    //
                    //
                    //B.Ed.
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1052
                    //271
                    //
                    //
                    //MBA
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1022
                    //272
                    //
                    //
                    //M.A-Rural Development
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1118
                    //273
                    //
                    //
                    //M.A-Public Administration
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1119
                    //274
                }
                if(position==9){
                    //certificate
                    pos=position;
                    args.putInt("position",pos);
                    args.putString("name",department[pos]);
                    //Amanat
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1034
                    //314
                    //
                    //
                    //TDM
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1079
                    //315
                    //
                    //
                    //Certificate in Office Automation
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1108
                    //316
                    //
                    //
                    //Certificate in Web Designing
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1109
                    //317
                    //
                    //
                    //Certificate in Multimedia Development
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1110
                    //318
                    //
                    //
                    //Certificate in PC-Hardware & Networking(A+,N+)
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1111
                    //319
                    //
                    //
                    //Certificate in ASP.Net with C#
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1112
                    //320
                    //
                    //
                    //certificate in Advanced Development using PHP
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1113
                    //321
                    //
                    //
                    //certificate in Network Administratation
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1114
                    //322
                    //
                    //
                    //certificate in Advanced JAVA(J2EE)
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1115
                    //323
                    //
                    //
                    //certificate in Information Security & Cyber LAW
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1116
                    //324
                    //
                    //
                    //certificate in Oracle SQL & PL/SQL
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1117
                    //325
                    //
                    //
                    //Certificate in Journalism and Mass Communication
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1121
                    //326
                }
                if(position==10){
                    //diploma
                    pos=position;
                    args.putInt("position",pos);
                    args.putString("name",department[pos]);
                    //GIS
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1033
                    //341
                    //
                    //
                    //PG Diploma in Hospital Management
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1080
                    //342
                    //
                    //
                    //PG Diploma in Counselling Guidance & Re-habilitation
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1081
                    //343
                    //
                    //
                    //Diploma in Journalism and Mass Communication
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1122
                    //344
                    //
                    //
                    //PG Diploma in Performing Arts
                    //http://www.dspmuranchi.ac.in/Departments.aspx?pid=1120
                    //345
                }
                tf.setArguments(args);
                FragmentManager fm=getFragmentManager();
                FragmentTransaction t=fm.beginTransaction();
                t.replace(R.id.nav_host_fragment,tf);
                t.addToBackStack(null);
                t.commit();


            }
        });

        return root;
    }
}