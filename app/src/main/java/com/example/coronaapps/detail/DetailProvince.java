package com.example.coronaapps.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coronaapps.R;

public class DetailProvince extends AppCompatActivity {

    Button[] btn = new Button[2];
    int[] btnID = {R.id.btnCall,R.id.btnSms};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_province);
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
                    }
                }
            });
        }
    }

    private void btnCall() {
    }

    private void btnSms() {
    }

}