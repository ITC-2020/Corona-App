package com.example.coronaapps;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronaapps.adapter.GlobalAdapter;
import com.example.coronaapps.model.ModelDataCountries1;
import com.example.coronaapps.service.ServiceGlobal;

import java.util.ArrayList;
import java.util.List;

public class PopUpCountries extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView textCountry;
    String date;
    GlobalAdapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       setContentView(R.layout.popup_country);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int iWidth = displayMetrics.widthPixels;
        int iHeight = displayMetrics.heightPixels;

        getWindow().setLayout((int) (iWidth * .9), (int) (iHeight * .8));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = 30;
        getWindow().setAttributes(params);
        textCountry = findViewById(R.id.itemText);
        recyclerView = findViewById(R.id.popupcountry);
        new ServiceGlobal().getCountry(countryListener);

    }

    ApiListenerGlobal<List<ModelDataCountries1>> countryListener = new ApiListenerGlobal<List<ModelDataCountries1>>() {
        @Override
        public void onSuccess(List<ModelDataCountries1> items) {

            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            adapter = new GlobalAdapter(items,date);
            recyclerView.setAdapter(adapter);

        }

        @Override
        public void onFailed(String msg) {

        }
    };
}
