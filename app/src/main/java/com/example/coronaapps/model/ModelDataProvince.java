package com.example.coronaapps.model;

import com.google.gson.annotations.SerializedName;

public class ModelDataProvince {
    @SerializedName("sembuh")
    private int sembuh;

    @SerializedName("kasus")
    private int kasus;

    @SerializedName("meninggal")
    private int meninggal;

    @SerializedName("provinsi")
    private int provinsi;

    public int getSembuh() {
        return sembuh;
    }

    public void setSembuh(int sembuh) {
        this.sembuh = sembuh;
    }

    public int getKasus() {
        return kasus;
    }

    public void setKasus(int kasus) {
        this.kasus = kasus;
    }

    public int getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(int meninggal) {
        this.meninggal = meninggal;
    }

    public int getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(int provinsi) {
        this.provinsi = provinsi;
    }

    @Override
    public String toString(){
        return
                "Province{" +
                        "sembuh = '" + sembuh + '\'' +
                        ",kasus= '" + kasus + '\'' +
                        ",meninggal = '" + meninggal + '\'' +
                        "}";
    }


}
