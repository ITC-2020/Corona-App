package com.example.coronaapps.model;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ModelResponse {

    @SerializedName("Global")
    private ModelDataGlobal global;

    @SerializedName("Date")
    private String date;


    public void setGlobal(ModelDataGlobal global){
        this.global = global;
    }

    public ModelDataGlobal getGlobal(){
        return global;
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
