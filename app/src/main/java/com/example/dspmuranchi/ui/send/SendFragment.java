package com.example.dspmuranchi.ui.send;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dspmuranchi.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class SendFragment extends Fragment {
    EditText name,email,subject,message;
    Button button;
public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_send, container, false);

    name=(EditText) root.findViewById(R.id.edit);
//    email=(EditText)root.findViewById(R.id.edit1);
    subject=(EditText)root.findViewById(R.id.edit3);
    message=(EditText)root.findViewById(R.id.edit2);
    button=(Button)root.findViewById(R.id.button);

    AdView mAdView;
    mAdView = root.findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

    button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String names=name.getText().toString();
        String emails="easy4solution@gmail.com";
        String subjects=subject.getText().toString();
        String messages=message.getText().toString();

        Intent emailss=new Intent(Intent.ACTION_SEND);
        emailss.putExtra(Intent.EXTRA_TEXT,names);
        emailss.putExtra(Intent.EXTRA_EMAIL,new String[]{emails});
        emailss.putExtra(Intent.EXTRA_SUBJECT,subjects);
        emailss.putExtra(Intent.EXTRA_TEXT,messages);
        emailss.setType("message/rfc822");
        startActivity(Intent.createChooser(emailss,"Select Gmail option :"));
    }
});
    return root;
    }
}