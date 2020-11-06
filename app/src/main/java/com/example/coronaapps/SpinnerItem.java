package com.example.coronaapps;

import com.google.gson.annotations.SerializedName;

public class SpinnerItem {
    private int img;
    private String name;

    public SpinnerItem(String name, int img)
    {
        this.name = name;
        this.img = img;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @SerializedName("CountryCode")
    private String countryCode;

   public String getName() {
    return name;
   }

   public void setName(String name) {
      this.name = name;
  }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
