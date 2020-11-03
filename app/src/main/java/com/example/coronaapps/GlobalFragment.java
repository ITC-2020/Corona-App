package com.example.coronaapps;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.coronaapps.model.ModelDataCountries;
import com.example.coronaapps.model.ModelDataGlobal;
import com.example.coronaapps.service.ServiceGlobal;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

public class GlobalFragment extends Fragment {


    public View v;

    private ArrayList<SpinnerItem> spinnerItems;
    private SpinnerAdapter spinnerAdapter;
    //Declaring an Spinner
    private Spinner spinner;
    private List<ModelDataCountries> items = new ArrayList<>();
    TextView tvTotalConfirmed, tvTotalRecovered, tvTotalDeath, tvLastUpdate,tvGlobalSpinner;
    String[] values = {"DFT", "JPN", "ID", "RNE", "MID", "AR"};
    //An ArrayList for Spinner Items
    private ArrayList<String> CountryCode;
    String URL = "https://api.covid19api.com/summary";
    //JSON Array
    ArrayList<ModelDataCountries> countryList = new ArrayList<ModelDataCountries>();
    private JSONArray Countries;

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
        spinner = v.findViewById(R.id.spinnerGlobal);
        new ServiceGlobal().getGlobal(globalListener);
        new ServiceGlobal().getCountry(dateListener);


        new ServiceGlobal().getCountry(countryListener);
      initList();

        //untuk spinner
        Spinner spinner = (Spinner) v.findViewById(R.id.spinnerGlobal);
        spinnerAdapter = new SpinnerAdapter(v.getContext(), spinnerItems);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SpinnerItem clicked = (SpinnerItem) adapterView.getItemAtPosition(i);
                String clickName = clicked.getName();

                if (!clickName.equals("DFT"))
                    Toast.makeText(view.getContext(), clickName + " Dipilih", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return v;

    }

    private void initList() {
    spinnerItems = new ArrayList<>();
    ArrayList<ModelDataCountries> countriesList = new ArrayList<>();
    //for (short i = 0; i < values.length; i++)
    //  spinnerItems.add(new SpinnerItem(values[i], R.mipmap.ic_launcher));
       for (int i = 0; i<values.length; i++) {
        spinnerItems.add(new SpinnerItem(values[i],R.mipmap.ic_launcher));
    }
   }


    ApiListenerGlobal<ModelDataGlobal> globalListener = new ApiListenerGlobal<ModelDataGlobal>() {
        @Override
        public void onSuccess(ModelDataGlobal items) {
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

    ApiListenerGlobal<List<ModelDataCountries>> dateListener = new ApiListenerGlobal<List<ModelDataCountries>>() {
        @Override
        public void onSuccess(List<ModelDataCountries> items) {
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

    ApiListenerGlobal<List<ModelDataCountries>> countryListener = new ApiListenerGlobal<List<ModelDataCountries>>() {

        @Override
        public void onSuccess(List<ModelDataCountries> items) {

        }

        @Override
        public void onFailed(String msg) {

        }
    };

}

