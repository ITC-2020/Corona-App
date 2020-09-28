package com.example.coronaapps;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class IndonesiaFragment extends Fragment {


    public View v;

    public IndonesiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_indonesia, container, false);
        configureImageButton();
        return v;
    }

    public void configureImageButton() {
        // TODO Auto-generated method stub
        ImageButton btn = (ImageButton) v.findViewById(R.id.buttonLove);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getActivity(), PrevCountryProvince.class);
                startActivity(mIntent);
            }
        });
    }
}
