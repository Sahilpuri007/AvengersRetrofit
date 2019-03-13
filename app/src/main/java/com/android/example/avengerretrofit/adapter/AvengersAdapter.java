package com.android.example.avengerretrofit.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.example.avengerretrofit.R;
import com.android.example.avengerretrofit.model.Hero;

import java.util.ArrayList;
import java.util.List;

public class AvengersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<Hero> heroArrayList;

    public AvengersAdapter(ArrayList<Hero> heroArrayList) {
        this.heroArrayList = heroArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = (View) layoutInflater.inflate(R.layout.item_hero, viewGroup, false);
        return new AvengerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        AvengerViewHolder avengerViewHolder = (AvengerViewHolder) viewHolder;
        Hero hero = heroArrayList.get(i);
        avengerViewHolder.tvName.setText(hero.getName());
        avengerViewHolder.tvRealName.setText(hero.getRealName());
    }

    @Override
    public int getItemCount() {
        return heroArrayList.size();
    }

    class AvengerViewHolder extends RecyclerView.ViewHolder{

        TextView tvName,tvRealName;
        public AvengerViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvRealName = itemView.findViewById(R.id.tvRealName);
        }
    }
}
