package com.example.coronaapps.model;
import com.google.gson.annotations.SerializedName;

public class ModelDataGlobal {

    @SerializedName("TotalRecovered")
    private int totalRecovered;

    @SerializedName("TotalConfirmed")
    private int totalConfirmed;

    @SerializedName("TotalDeaths")
    private int totalDeaths;


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


    public void setTotalDeaths(int totalDeaths){
        this.totalDeaths = totalDeaths;
    }

    public int getTotalDeaths(){
        return totalDeaths;
    }

    @Override
    public String toString(){
        return
                "Global{" +
                        "totalRecovered = '" + totalRecovered + '\'' +
                        ",totalConfirmed = '" + totalConfirmed + '\'' +
                        ",totalDeaths = '" + totalDeaths + '\'' +
                        "}";
    }


}
