package com.example.coronaapps.service;

import android.widget.Toast;

import com.example.coronaapps.ApiListenerGlobal;
import com.example.coronaapps.adapter.IndoAdapter;
import com.example.coronaapps.detail.DetailProvince;
import com.example.coronaapps.model.Indonesia;
import com.example.coronaapps.model.ModelDataCountries;
import com.example.coronaapps.model.ModelDataGlobal;
import com.example.coronaapps.model.ModelDataProvinsi;
import com.example.coronaapps.model.ModelResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGlobal {

    private Retrofit retrofit = null;
    static final String URl_BASE_INDO_PROV="https://apicovid19indonesia-v2.vercel.app/api/indonesia/provinsi/";

    public ApiGlobal getAPI() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(ApiGlobal.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiGlobal.class);
    }

    public ApiGlobal getApiIndo() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(ApiGlobal.URl_BASE_INDO)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiGlobal.class);
    }

    public ApiGlobal getApiProvinsi() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(URl_BASE_INDO_PROV)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiGlobal.class);
    }

    public void getProvinsi(final ApiListenerGlobal<ModelDataProvinsi> listener) {
        getApiIndo().getProvinsi().enqueue(new Callback<ModelDataProvinsi>() {
            @Override
            public void onResponse(Call<ModelDataProvinsi> call, Response<ModelDataProvinsi> response) {
                ModelDataProvinsi data = response.body();
                if (data != null) {
                    listener.onSuccess(data);
                }
            }

            @Override
            public void onFailure(Call<ModelDataProvinsi> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    public void getAllprovinsi(final ApiListenerGlobal<ArrayList<Indonesia>> listener) {
        getApiProvinsi().getAllProvinsi().enqueue(new Callback<ArrayList<Indonesia>>() {
            @Override
            public void onResponse(Call<ArrayList<Indonesia>> call, Response<ArrayList<Indonesia>> response) {
                ArrayList<Indonesia> indonesia = response.body();
                if (indonesia != null) {
                    listener.onSuccess(indonesia);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Indonesia>> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

//    public void getDetailProvinsi(final ApiListenerGlobal<Indonesia> listener,String provinsi){
//        getApiProvinsi().getDetailProvinsi(provinsi).enqueue(new Callback<Indonesia>() {
//            @Override
//            public void onResponse(Call<Indonesia> call, Response<Indonesia> response) {
//
//                Indonesia indonesia = response.body();
//                if (indonesia != null) {
//                    listener.onSuccess(indonesia);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Indonesia> call, Throwable t) {
//                listener.onFailed(t.getMessage());
//            }
//        });
//    }

    public void getGlobal(final ApiListenerGlobal<ModelDataGlobal> listener) {
        getAPI().getCorona().enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                ModelResponse data = response.body();
                if (data != null && data.getGlobal() != null) {
                    listener.onSuccess(data.getGlobal());
                }
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    public void getCountry(final ApiListenerGlobal<List<ModelDataCountries>> listener) {
        getAPI().getCorona().enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                ModelResponse data = response.body();
                if (data != null && data.getGlobal() != null) {
                    listener.onSuccess(data.getCountries());
                }
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }


}
