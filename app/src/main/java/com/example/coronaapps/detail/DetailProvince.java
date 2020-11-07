package com.example.coronaapps.detail;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coronaapps.ApiListenerGlobal;
import com.example.coronaapps.R;
import com.example.coronaapps.model.Indonesia;
import com.example.coronaapps.service.ServiceGlobal;

public class DetailProvince extends AppCompatActivity {

    public static final String EXTRA_PARCEL = "extra_parcel";
    Indonesia indonesia;
    TextView tv_kasus,tv_sembuh,tv_meninggal,tv_provinsi;

    Button[] btn = new Button[2];
    int[] btnID = {R.id.btnCall,R.id.btnSms};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_province);

        if (getIntent() != null){
            indonesia = getIntent().getParcelableExtra(EXTRA_PARCEL);
        }

        tv_provinsi=findViewById(R.id.tv_provinsi_detail);
        tv_kasus=findViewById(R.id.tv_kasus_detail);
        tv_sembuh=findViewById(R.id.tv_sembuh_detail);
        tv_meninggal=findViewById(R.id.tv_kematian_detail);

        ServiceGlobal serviceGlobal= new ServiceGlobal();
        serviceGlobal.getDetailProvinsi(provinsiListener,indonesia.getProvinsi());

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

    ApiListenerGlobal<Indonesia> provinsiListener=new ApiListenerGlobal<Indonesia>() {
        @Override
        public void onSuccess(Indonesia indonesia) {
            tv_provinsi.setText(indonesia.getProvinsi());
            tv_kasus.setText(indonesia.getKasus());
            tv_meninggal.setText(indonesia.getMeninggal());
            tv_sembuh.setText(indonesia.getSembuh());
        }

        @Override
        public void onFailed(String msg) {

            Log.d("ERROR API", msg);
        }
    };

    private void btnCall() {
    }

    private void btnSms() {
    }

}