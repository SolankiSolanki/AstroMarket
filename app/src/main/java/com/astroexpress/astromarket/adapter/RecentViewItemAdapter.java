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
import com.astroexpress.astromarket.databinding.RecentViewitemBinding;
import com.astroexpress.astromarket.model.RecentViewItemModel;
import com.astroexpress.astromarket.ui.ProductPageMainActivity;


import java.util.List;

public class RecentViewItemAdapter extends RecyclerView.Adapter<RecentViewItemAdapter.Viewholder> {
    Context context;
    private List<RecentViewItemModel> itemList;

    public RecentViewItemAdapter(Context context, List<RecentViewItemModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recent_viewitem, parent, false);

        return new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.binding.illuminatedtarotViewItem.setImageResource(itemList.get(position).getImageUrl());
        holder.binding.text16ViewItem.setText(itemList.get(position).getTitlesixteen());
        holder.binding.textViewItem.setText(itemList.get(position).getTitletext());
        holder.binding.rupeeText2ViewItem.setText("₹"+itemList.get(position).getTitlenumber());
        holder.binding.strikeText3ViewItem.setText("₹"+itemList.get(position).getTitlestrik());
        holder.binding.strikeText3ViewItem.setPaintFlags(holder.binding.strikeText3ViewItem.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
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

    public class Viewholder extends RecyclerView.ViewHolder {
        RecentViewitemBinding binding;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            binding=RecentViewitemBinding.bind(itemView);
        }
    }
}
