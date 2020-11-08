package com.example.coronaapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;

import com.example.coronaapps.adapter.IndoAdapter;
import com.example.coronaapps.model.Indonesia;
import com.example.coronaapps.service.ServiceGlobal;

import java.util.ArrayList;

public class PopActivity extends AppCompatActivity {

    private RecyclerView rvIndo;
    private IndoAdapter indoAdapter;
    private ArrayList<Indonesia> listProvince =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        //floating layout
        DisplayMetrics dm =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width= dm.widthPixels;
        int height= dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.9));

        WindowManager.LayoutParams params=getWindow().getAttributes();
        params.gravity= Gravity.CENTER;
        params.x=0;
        params.y=-20;

        getWindow().setAttributes(params);

        //Recyclerview
        indoAdapter=new IndoAdapter();
        rvIndo=findViewById(R.id.rv_province);
        rvIndo.setHasFixedSize(true);
        rvIndo.setLayoutManager(new LinearLayoutManager(this));
        rvIndo.setAdapter(indoAdapter);

        ServiceGlobal serviceGlobal=new ServiceGlobal();
        serviceGlobal.getAllprovinsi(provListener);
    }

    ApiListenerGlobal<ArrayList<Indonesia>> provListener = new ApiListenerGlobal<ArrayList<Indonesia>>() {
        @Override
        public void onSuccess(ArrayList<Indonesia> indonesia) {
            listProvince.addAll(indonesia);
            indoAdapter.setProvince(listProvince);

        }

        @Override
        public void onFailed(String msg) {
            Log.d("ERROR API", msg);
        }
    };
}