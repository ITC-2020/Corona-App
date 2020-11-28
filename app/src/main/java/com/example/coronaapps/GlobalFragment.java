package com.example.coronaapps;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.coronaapps.detail.DetailCountry;
import com.example.coronaapps.model.ModelDataCountries1;
import com.example.coronaapps.model.ModelDataGlobal1;
import com.example.coronaapps.service.ServiceGlobal;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

public class GlobalFragment extends Fragment {


    public View v;
    Button btnDetGlobal;
    private List<ModelDataCountries1> items = new ArrayList<>();
    TextView tvTotalConfirmed, tvTotalRecovered, tvTotalDeath, tvLastUpdate,tvGlobalSpinner;
    private ArrayList<String> CountryCode;
    String URL = "https://api.covid19api.com/summary",date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_global, container, false);



        //untuk tampilan jumlah data
        tvTotalConfirmed = v.findViewById(R.id.tv_TotalConfirmed);
        tvTotalDeath = v.findViewById(R.id.tv_TotalDeath);
        tvTotalRecovered = v.findViewById(R.id.tv_TotalRecovered);
        tvLastUpdate = v.findViewById(R.id.tv_LastUpdate);
        tvGlobalSpinner = v.findViewById(R.id.spinnerText);
        btnDetGlobal = v.findViewById(R.id.btn_DetGlobal);



        btnDetGlobal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getContext(), PopUpCountries.class);
                mIntent.putExtra(DetailCountry.EXTRA_DATE, date);
                startActivity(mIntent);

            }
        });

        new ServiceGlobal().getGlobal(globalListener);
        new ServiceGlobal().getCountry(dateListener);
        return v;

    }


    ApiListenerGlobal<ModelDataGlobal1> globalListener = new ApiListenerGlobal<ModelDataGlobal1>() {
        @Override
        public void onSuccess(ModelDataGlobal1 items) {
            String confirmed = String.valueOf(items.getTotalConfirmed());
            tvTotalConfirmed.setText(confirmed);
            String recovered = String.valueOf(items.getTotalRecovered());
            tvTotalRecovered.setText(recovered);
            String death = String.valueOf(items.getTotalDeaths());
            tvTotalDeath.setText(death);
        }

        @Override
        public void onFailed(String msg) {
            Log.d("ISI ERROR", msg);
        }
    };

    ApiListenerGlobal<List<ModelDataCountries1>> dateListener = new ApiListenerGlobal<List<ModelDataCountries1>>() {
        @Override
        public void onSuccess(List<ModelDataCountries1> items) {
            String value = String.valueOf(items.get(0).getDate());
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

