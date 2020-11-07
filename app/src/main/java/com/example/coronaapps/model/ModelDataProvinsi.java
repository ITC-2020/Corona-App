package com.example.coronaapps.model;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;

public class ModelDataProvinsi {
    @SerializedName("positif")
    private int Positif;

    @SerializedName("dirawat")
    private int Dirawat;

    @SerializedName("sembuh")
    private int Sembuh;

    @SerializedName("meninggal")
    private int Meninggal;

    @SerializedName("lastUpdate")
    private String Update;

    public int getPositif() {
        return Positif;
    }

    public void setPositif(int positif) {
        Positif = positif;
    }

    public int getDirawat() {
        return Dirawat;
    }

    public void setDirawat(int dirawat) {
        Dirawat = dirawat;
    }

    public int getSembuh() {
        return Sembuh;
    }

    public void setSembuh(int sembuh) {
        Sembuh = sembuh;
    }

    public int getMeninggal() {
        return Meninggal;
    }

    public void setMeninggal(int meninggal) {
        Meninggal = meninggal;
    }

    public String getUpdate() {
        return Update;
    }

    public void setUpdate(String update) {
        Update = update;
    }

    @NonNull
    @Override
    public String toString() {
        return
                "CountriesItem{" +
                        "positif = '" + Positif + '\'' +
                        ",dirawat = '" + Dirawat + '\'' +
                        ",sembuh = '" + Sembuh + '\'' +
                        ",meninggal = '" + Meninggal + '\'' +
                        ",lastUpdate = '" + Update + '\'' +
                        "}";

    }
}
