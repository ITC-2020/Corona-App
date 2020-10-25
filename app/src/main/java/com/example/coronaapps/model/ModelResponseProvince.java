package com.example.coronaapps.model;

import com.google.gson.annotations.SerializedName;

public class ModelResponseProvince {
    @SerializedName("provinsi")
    private ModelDataProvince provinsi;

    @SerializedName("Date")
    private String date;

    public ModelDataProvince getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(ModelDataProvince provinsi) {
        this.provinsi = provinsi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return
                "CoronaResponse{" +
                        "provinsi = '" + provinsi + '\'' +
                        ",date = '" + date + '\'' +
                        "}";
    }
}
