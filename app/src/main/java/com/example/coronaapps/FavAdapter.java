package com.example.coronaapps;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder>  {


    ArrayList<ProvFav> provFavs;

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.listener = listener;
    }


    public interface OnItemClickListener
    {
        void onRemoveItem(int position);
        void onAddItem(int position);
    }

    public FavAdapter(ArrayList<ProvFav> provFavs)
    {
        this.provFavs = provFavs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prev_coutry_province_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(provFavs.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return provFavs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView favText;
        CircleImageView circleImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.imgItemList);
            favText = itemView.findViewById(R.id.itemText);

        }
        @SuppressLint("UseCompatLoadingForDrawables")
        public void bind(ProvFav data, OnItemClickListener onItemClickListener)
        {
            circleImageView.setImageDrawable(itemView.getResources().getDrawable(R.drawable.heartcolor));
            favText.setText(data.getData());
            circleImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            circleImageView.setImageDrawable(itemView.getResources().getDrawable(R.drawable.heartnocolor));
                            onItemClickListener.onRemoveItem(position);
                        }
                    }
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    click(data.getData());
                }
            });
        }

        public void click(String data)
        {
            Toast.makeText(itemView.getContext(), data + " Clicked!", Toast.LENGTH_SHORT).show();
        }
    }
}
