package com.example.coronaapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.coronaapps.detail.DetailCountry;
import com.example.coronaapps.detail.DetailCountryIndo;

public class MainActivity extends AppCompatActivity {

    Button btnFav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFav = findViewById(R.id.btnFav);
        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DetailCountryIndo.class);
                startActivity(intent);
            }
        });
    }
}