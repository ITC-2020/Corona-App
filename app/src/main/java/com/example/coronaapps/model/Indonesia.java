package com.example.coronaapps.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Indonesia implements Parcelable {
    private String provinsi;
    private String kasus;
    private String meninggal;
    private String sembuh;

    protected Indonesia(Parcel in) {
        provinsi = in.readString();
        kasus = in.readString();
        meninggal = in.readString();
        sembuh = in.readString();
    }

    public static final Creator<Indonesia> CREATOR = new Creator<Indonesia>() {
        @Override
        public Indonesia createFromParcel(Parcel in) {
            return new Indonesia(in);
        }

        @Override
        public Indonesia[] newArray(int size) {
            return new Indonesia[size];
        }
    };

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKasus() {
        return kasus;
    }

    public void setKasus(String kasus) {
        this.kasus = kasus;
    }

    public String getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(String meninggal) {
        this.meninggal = meninggal;
    }

    public String getSembuh() {
        return sembuh;
    }

    public void setSembuh(String sembuh) {
        this.sembuh = sembuh;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(provinsi);
        parcel.writeString(kasus);
        parcel.writeString(meninggal);
        parcel.writeString(sembuh);
    }
}
