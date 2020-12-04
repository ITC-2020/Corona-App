package com.example.coronaapps.detail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coronaapps.ApiListenerGlobal;
import com.example.coronaapps.R;
import com.example.coronaapps.model.ModelDataCountries;
import com.example.coronaapps.service.ServiceGlobal;

import java.util.List;

public class DetailCountry extends AppCompatActivity {

    Button btn;
    String country;
    String date;
    int deaths,recovered,cases;
    TextView textCountry,textRecovered,textDeaths,textTotalCases,textLastUpdate;
    public static final String EXTRA_DATE = "extra_date";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_country);
        Intent intent = getIntent();
        country = intent.getStringExtra("country");
        deaths = intent.getIntExtra("deaths",0);
        recovered = intent.getIntExtra("recovered",0);
        cases = intent.getIntExtra("cases",0);
        date = intent.getStringExtra("date");
        btn = findViewById(R.id.btnMoreInfo);
        textCountry = findViewById(R.id.dt_country);
        textRecovered = findViewById(R.id.tx_nmr4);
        textDeaths = findViewById(R.id.tx_nmr5);
        textTotalCases = findViewById(R.id.tx_nmr6);
        textLastUpdate = findViewById(R.id.lastupdate);

        new ServiceGlobal().getCountry(countryListener);

    }
    ApiListenerGlobal<List<ModelDataCountries>> countryListener = new ApiListenerGlobal<List<ModelDataCountries>>() {

        @Override
        public void onSuccess(List<ModelDataCountries> items) {
            textCountry.setText(country);
            textDeaths.setText(String.valueOf(deaths));
            textRecovered.setText(String.valueOf(recovered));
            textTotalCases.setText(String.valueOf(cases));

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
            textLastUpdate.setText(String.valueOf(date));


            Context context = getApplicationContext();
            CharSequence text = "Country : "+country;
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            Intent intentWeb = new Intent(Intent.ACTION_VIEW);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intentWeb.setData(Uri.parse("https://www.google.com/search?q="+"Corona Update in " +country));
                    startActivity(intentWeb);
                }
            });
        }

        @Override
        public void onFailed(String msg) {

        }
    };
}