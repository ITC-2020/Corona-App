package com.example.coronaapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Objects;

public class PrevCountryProvince extends AppCompatActivity {

    ArrayList<ProvFav> provFavs;
    RecyclerView recyclerView;
    FavAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prev_country_province);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarFav);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        recyclerView = findViewById(R.id.rcPC);
        DataDummyFav dataDummyFav = new DataDummyFav();
        provFavs = dataDummyFav.getAllDataDummy();
        this.adapter = new FavAdapter(provFavs);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new FavAdapter.OnItemClickListener() {
            @Override
            public void onRemoveItem(int position) {
                removeItem(position);
            }

            @Override
            public void onAddItem(int position) {
                addItem(position);
            }
        });
    }

    public void addItem(int position)
    {
        //Add Data to RcView
        //provFavs.add(new ProvFav(,position));
    }

    public void removeItem(int position)
    {
        //Remove Data to RcView
        provFavs.remove(position);
        adapter.notifyItemRemoved(position);
    }

}