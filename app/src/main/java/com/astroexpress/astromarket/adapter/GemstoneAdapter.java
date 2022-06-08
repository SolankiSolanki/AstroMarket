package com.astroexpress.astromarket.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astroexpress.astromarket.R;
import com.astroexpress.astromarket.databinding.GemstoneBinding;
import com.astroexpress.astromarket.model.GemstoneModel;
import com.astroexpress.astromarket.ui.ProductPageMainActivity;


import java.util.List;

public class GemstoneAdapter extends RecyclerView.Adapter<GemstoneAdapter.ViewHolder> {
    Context context;
    private List<GemstoneModel> itemList;


    public GemstoneAdapter(Context context, List<GemstoneModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.gemstone,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.illuminatedtarotImgGemstone.setImageResource(itemList.get(position).getImageUrl());
        holder.binding.textGemstone.setText(itemList.get(position).getTitle());
        holder.binding.text16Gemstone.setText(itemList.get(position).getTitle_16());
        holder.binding.rupeeText2Gemstone.setText("₹"+itemList.get(position).getTitle_rupee());
        holder.binding.strikeText3Gemstone.setText("₹"+itemList.get(position).getTitle_strike());
        holder.binding.strikeText3Gemstone.setPaintFlags(holder.binding.strikeText3Gemstone.getPaintFlags()|Paint.STRIKE_THRU_TEXT_FLAG);

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductPageMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        GemstoneBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= GemstoneBinding.bind(itemView);
        }
    }
}
