package com.example.coronaapps.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelResponse {

    @SerializedName("Global")
    private ModelDataGlobal global;

    @SerializedName("Date")
    private String date;

    @SerializedName("Countries")
    private List<ModelDataCountries> countries;

    public void setGlobal(ModelDataGlobal global){
        this.global = global;
    }

    public ModelDataGlobal getGlobal(){
        return global;
    }

    public List<ModelDataCountries> getCountries() {
        return countries;
    }

    public void setCountries(List<ModelDataCountries> countries) {
        this.countries = countries;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    @Override
    public String toString(){
        return
                "CoronaResponse{" +
                        "global = '" + global + '\'' +
                        ",date = '" + date + '\'' +
                        "}";
    }
}
