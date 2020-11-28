package com.example.coronaapps.service;

import com.example.coronaapps.model.ModelDataGlobal1;
import com.example.coronaapps.model.ModelResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiGlobal {
    static final String URL_BASE = "https://api.covid19api.com/";

    @GET("summary")
    Call<ModelResponse> getCorona();

}
