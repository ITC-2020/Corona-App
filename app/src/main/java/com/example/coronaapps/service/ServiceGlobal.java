package com.example.coronaapps.service;

import com.example.coronaapps.ApiListenerGlobal;
import com.example.coronaapps.model.ModelDataGlobal;
import com.example.coronaapps.model.ModelResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGlobal {

    private Retrofit retrofit = null;

    public ApiGlobal getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(ApiGlobal.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiGlobal.class);
    }

    public void  getGlobal(final ApiListenerGlobal<ModelDataGlobal> listener){
        getAPI().getCorona().enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                ModelResponse data = response.body();
                if(data!=null && data.getGlobal()!=null){
                    listener.onSuccess(data.getGlobal());
                }
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                    listener.onFailed(t.getMessage());
            }
        });
    }


}
