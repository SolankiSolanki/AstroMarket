package com.astroexpress.astromarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astroexpress.astromarket.R;
import com.astroexpress.astromarket.databinding.BagRecycleerviewBinding;

public class BagAdapter extends RecyclerView.Adapter<BagAdapter.Viewholder> {

    Context context;

    public BagAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.bag_recycleerview,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        BagRecycleerviewBinding binding;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            binding= BagRecycleerviewBinding.bind(itemView);
        }
    }
}
