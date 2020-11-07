package com.example.coronaapps.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.coronaapps.R;
import com.example.coronaapps.detail.DetailProvince;
import com.example.coronaapps.model.Indonesia;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IndoAdapter extends RecyclerView.Adapter<IndoAdapter.ViewHolder> {

    private ArrayList<Indonesia> listIndo = new ArrayList<>();

    public void setProvince(ArrayList<Indonesia> listIndo) {
        this.listIndo.clear();
        this.listIndo.addAll(listIndo);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.indonesia_spinner_row, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind(listIndo.get(position));
    }

    @Override
    public int getItemCount() {
        return listIndo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvProvince;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProvince = itemView.findViewById(R.id.tvProvince);
        }

        public void bind(Indonesia indonesia) {
            tvProvince.setText(indonesia.getProvinsi());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DetailProvince.class);
                    intent.putExtra(DetailProvince.EXTRA_PARCEL, indonesia);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
