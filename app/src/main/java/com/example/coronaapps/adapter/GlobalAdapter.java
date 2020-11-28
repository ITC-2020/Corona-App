package com.example.coronaapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import  com.example.coronaapps.detail.DetailCountry;
import com.example.coronaapps.R;
import com.example.coronaapps.model.ModelDataCountries1;

import java.util.List;

public class GlobalAdapter extends RecyclerView.Adapter<GlobalAdapter.ViewHolder>  {

    List<ModelDataCountries1> Items;
    String context;

    public GlobalAdapter(List<ModelDataCountries1> items, String context) {
        Items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_corona, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ModelDataCountries1 item = Items.get(position);
        holder.tvCountyName.setText(item.getCountry());
        holder.rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetailCountry.class);
                intent.putExtra("country",item.getCountry());
                intent.putExtra("cases",item.getTotalConfirmed());
                intent.putExtra("deaths",item.getTotalDeaths());
                intent.putExtra("recovered",item.getTotalRecovered());
                intent.putExtra("date",item.getDate());
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return Items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCountyName;
        RelativeLayout rv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountyName = itemView.findViewById(R.id.itemText);
            rv = itemView.findViewById(R.id.mainLayout);

        }
    }
}