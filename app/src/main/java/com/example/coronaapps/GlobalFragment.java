package com.example.coronaapps;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.coronaapps.model.ModelDataGlobal;
import com.example.coronaapps.model.ModelResponse;
import com.example.coronaapps.service.ServiceGlobal;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

public class GlobalFragment extends Fragment {


    public View v;

    public GlobalFragment() {
        // Required empty public constructor
    }

    private ArrayList<SpinnerItem> spinnerItems;
    private SpinnerAdapter spinnerAdapter;
    ProgressDialog dialog;
    TextView tvTotalConfirmed,tvTotalRecovered,tvTotalDeath,tvLastUpdate;
    String[] values = {"DFT", "JPN", "ID", "RNE", "MID","AR"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_global, container, false);
        configureImageButton();
        initList();
        //untuk tampilan jumlah data
        tvTotalConfirmed = v.findViewById(R.id.tv_TotalConfirmed);
        tvTotalDeath = v.findViewById(R.id.tv_TotalDeath);
        tvTotalRecovered = v.findViewById(R.id.tv_TotalRecovered);
        tvLastUpdate = v.findViewById(R.id.tv_LastUpdate);

        new ServiceGlobal().getGlobal(globalListener);

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

    private GlobalFragment getGlobalFragment() {
        return GlobalFragment.this;
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

    private void initList() {
        spinnerItems = new ArrayList<>();
        for (short i = 0; i < values.length; i++)
            spinnerItems.add(new SpinnerItem(values[i], R.mipmap.ic_launcher));
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



}
