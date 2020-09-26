package com.example.coronaapps;

import java.util.ArrayList;
import java.util.Collections;

public class DataDummyFav {

    DataDummyFav(){ FTU(); }

    private ArrayList<String> data = new ArrayList<>();
    private String[] dataS = {"Jakarta", "Bandung", "Jogja", "Bekasi", "Bogor"};

    private void FTU()
    {
        Collections.addAll(data, dataS);
    }

    public ArrayList<String> getData() {
        return data;
    }

    public ArrayList<ProvFav> getAllDataDummy()
    {
        ArrayList<ProvFav> list = new ArrayList<>();
        for(short i = 0; i < dataS.length; i++)
        {
            ProvFav provFav = new ProvFav(getData(),i);
            list.add(provFav);
        }
        return list;
    }


}
