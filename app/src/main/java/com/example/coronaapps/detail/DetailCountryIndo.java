package com.example.coronaapps.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.coronaapps.R;

public class DetailCountryIndo extends AppCompatActivity {


    String country = "Indonesia";
    TextView textCountry;
    Button[] btn = new Button[3];
    int[] btnID = {R.id.btnCall,R.id.btnSms, R.id.btnMoreInfo};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_country_indo);

        textCountry = findViewById(R.id.dt_country);
        textCountry.setText(country);
        for(char i = 0; i < btn.length; i++)
        {
            btn[i] = new Button(this);
            btn[i] = findViewById(btnID[i]);
            btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId())
                    {
                        case R.id.btnCall:
                            btnCall();
                            break;

                        case R.id.btnSms:
                            btnSms();
                            break;

                        case R.id.btnMoreInfo:
                            btnWeb();
                            break;
                    }
                }
            });
        }
    }

    private void btnCall() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "117"));
        startActivity(intent);
    }

    private void btnSms() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:117"));
        intent.putExtra("sms_body", "Help!");
        startActivity(intent);
    }

    private void btnWeb()
    {
        Intent intentWeb = new Intent(Intent.ACTION_VIEW);
        intentWeb.setData(Uri.parse("https://www.covid19.go.id/"));
        startActivity(intentWeb);
    }
}