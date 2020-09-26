package com.example.coronaapps;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GlobalFragment extends Fragment {


    public GlobalFragment() {
        // Required empty public constructor
    }

    private ArrayList<SpinnerItem> spinnerItems;
    private SpinnerAdapter spinnerAdapter;
    String[] values = {"DFT", "JPN","IND","RNE","MID"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_global, container, false);
        initList();
        Spinner spinner = (Spinner) view.findViewById(R.id.spinnerGlobal);
        spinnerAdapter = new SpinnerAdapter(view.getContext(), spinnerItems);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SpinnerItem clicked = (SpinnerItem) adapterView.getItemAtPosition(i);
                String clickName = clicked.getName();
                if(!clickName.equals("DFT"))
                    Toast.makeText(view.getContext(),clickName + " Dipilih", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;

    }

    private void initList() {
        spinnerItems = new ArrayList<>();
        for(short i = 0; i < values.length; i++)
            spinnerItems.add(new SpinnerItem(values[i], R.mipmap.ic_launcher));
    }

}
