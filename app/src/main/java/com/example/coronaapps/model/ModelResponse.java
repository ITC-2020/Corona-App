package com.example.coronaapps.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelResponse {

    @SerializedName("Global")
    private ModelDataGlobal1 global;

    @SerializedName("Date")
    private String date;

    @SerializedName("Countries")
    private List<ModelDataCountries1> countries;

    public void setGlobal(ModelDataGlobal1 global){
        this.global = global;
    }

    public ModelDataGlobal1 getGlobal(){
        return global;
    }

    public List<ModelDataCountries1> getCountries() {
        return countries;
    }

    public void setCountries(List<ModelDataCountries1> countries) {
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
