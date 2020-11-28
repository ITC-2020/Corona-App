package com.example.coronaapps.model;

import com.google.gson.annotations.SerializedName;

public class ModelDataCountries1 {

    private int img;

        @SerializedName("TotalRecovered")
        private int totalRecovered;

        @SerializedName("TotalConfirmed")
        private int totalConfirmed;

        @SerializedName("TotalDeaths")
        private int totalDeaths;

        @SerializedName("Country")
        private String country;

        @SerializedName("CountryCode")
        private String countryCode;

        @SerializedName("Slug")
        private String slug;

        @SerializedName("Date")
        private String date;

    public ModelDataCountries1(String countryCode, int ic_launcher) {
       this.countryCode = countryCode;
       this.img = ic_launcher;

    }

    public void setTotalRecovered(int totalRecovered){
            this.totalRecovered = totalRecovered;
        }

        public int getTotalRecovered(){
            return totalRecovered;
        }

        public void setTotalConfirmed(int totalConfirmed){
            this.totalConfirmed = totalConfirmed;
        }

        public int getTotalConfirmed(){
            return totalConfirmed;
        }

        public void setCountry(String country){
            this.country = country;
        }

        public String getCountry(){
            return country;
        }

        public void setCountryCode(String countryCode){
            this.countryCode = countryCode;
        }

        public String getCountryCode(){
            return countryCode;
        }

        public void setSlug(String slug){
            this.slug = slug;
        }

        public String getSlug(){
            return slug;
        }

        public void setTotalDeaths(int totalDeaths){
            this.totalDeaths = totalDeaths;
        }

        public int getTotalDeaths(){
            return totalDeaths;
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
                    "CountriesItem{" +
                            "totalRecovered = '" + totalRecovered + '\'' +
                            ",totalConfirmed = '" + totalConfirmed + '\'' +
                            ",country = '" + country + '\'' +
                            ",countryCode = '" + countryCode + '\'' +
                            ",slug = '" + slug + '\'' +
                            ",totalDeaths = '" + totalDeaths + '\'' +
                            ",date = '" + date + '\'' +
                            "}";
        }
}

