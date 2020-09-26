package com.example.coronaapps;

import java.util.ArrayList;

public class ProvFav {

    private String data;
    public ProvFav(ArrayList<String> data, int position)
    {
        this.data = data.get(position);
    }

    public String getData()
    {
        return this.data;
    }
}
