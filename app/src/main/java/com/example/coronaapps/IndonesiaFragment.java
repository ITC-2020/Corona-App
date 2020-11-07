package com.example.coronaapps;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.coronaapps.model.ModelDataProvinsi;
import com.example.coronaapps.service.ServiceGlobal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



/**
 * A simple {@link Fragment} subclass.
 */
public class IndonesiaFragment extends Fragment {

    Button mButton;


    public View v;

    public IndonesiaFragment() {
        // Required empty public constructor
    }

    TextView tvPositif,tvSembuh,tvMeniggal,tvLastUpdate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_indonesia, container, false);
        configureImageButton();



        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mButton =v.findViewById(R.id.btnProvince);
        tvPositif=v.findViewById(R.id.tvPositive);
        tvSembuh=v.findViewById(R.id.tvsembuh);
        tvMeniggal=v.findViewById(R.id.tvMeninggal);
        tvLastUpdate=v.findViewById(R.id.tvLastUpdate);


        new ServiceGlobal().getProvinsi(provinsiListener);
        new ServiceGlobal().getProvinsi(dateListener);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getContext(),PopActivity.class);
                startActivity(i);
            }
        });
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

    ApiListenerGlobal<ModelDataProvinsi> provinsiListener = new ApiListenerGlobal<ModelDataProvinsi>() {
        @Override
        public void onSuccess(ModelDataProvinsi items) {
            String positive= String.valueOf(items.getPositif());
            tvPositif.setText(positive);

            String meninggal= String.valueOf(items.getMeninggal());
            tvMeniggal.setText(meninggal);

            String sembuh= String.valueOf(items.getSembuh());
            tvSembuh.setText(sembuh);

//            String update=String.valueOf(items.getUpdate());
//            tvLastUpdate.setText(update);
        }

        @Override
        public void onFailed(String msg) {
            Log.d("ISI ERROR", msg);

        }
    };
    ApiListenerGlobal<ModelDataProvinsi> dateListener= new ApiListenerGlobal<ModelDataProvinsi>() {
        @Override
        public void onSuccess(ModelDataProvinsi items) {

            String value = String.valueOf(items.getUpdate());
            String month;
            int checkMonth = Integer.parseInt(value.substring(5,7));
            switch (checkMonth){
                case 1 : month = "January"; break;
                case 2 : month = "February"; break;
                case 3 : month = "March"; break;
                case 4 : month = "April"; break;
                case 5 : month = "May"; break;
                case 6 : month = "June"; break;
                case 7 : month = "July"; break;
                case 8 : month = "August"; break;
                case 9 : month = "September"; break;
                case 10 : month = "October"; break;
                case 11 : month = "November"; break;
                case 12 : month = "December"; break;
                default: month = "Month";
            }
            String date = "Last Update : " + value.substring(8,10) + " " + month + " " + value.substring(0,4);
            tvLastUpdate.setText(date);
        }

        @Override
        public void onFailed(String msg) {
            Log.d("ISI ERROR", msg);

        }
    };




}
