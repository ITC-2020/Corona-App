package com.example.coronaapps.service;

import com.example.coronaapps.model.Indonesia;
import com.example.coronaapps.model.ModelDataGlobal;
import com.example.coronaapps.model.ModelDataProvinsi;
import com.example.coronaapps.model.ModelResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiGlobal {
    static final String URL_BASE = "https://api.covid19api.com/";
    static final String URl_BASE_INDO="https://apicovid19indonesia-v2.vercel.app/api/";


    @GET("summary")
    Call<ModelResponse> getCorona();

    @GET("indonesia")
    Call<ModelDataProvinsi> getProvinsi();

    @GET("more")
    Call<ArrayList<Indonesia>> getAllProvinsi();

    @GET("more/{provinsi}")
    Call<Indonesia> getDetailProvinsi(@Path("provinsi") String username);

}
