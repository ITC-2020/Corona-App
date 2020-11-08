package com.example.coronaapps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coronaapps.R;

public class DetailCountry extends AppCompatActivity {

    Button btn;
    TextView textCountry;
    DataDummy dataDummy = new DataDummy();
    String country = "Singapore";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_country);
        //Intent intent = getIntent();
        //country = intent.getStringExtra("country");
        btn = findViewById(R.id.btnMoreInfo);
        textCountry = findViewById(R.id.dt_country);
        textCountry.setText(country);
        Intent intentWeb = new Intent(Intent.ACTION_VIEW);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentWeb.setData(Uri.parse(dataDummy.getUrl(country)));
                startActivity(intentWeb);
            }
        });
    }
}