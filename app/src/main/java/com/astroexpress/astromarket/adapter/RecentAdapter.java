package com.astroexpress.astromarket.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astroexpress.astromarket.R;
import com.astroexpress.astromarket.databinding.RecentBinding;
import com.astroexpress.astromarket.model.RecentModel;
import com.bumptech.glide.Glide;

import java.util.List;


public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.ViewHolder> {

    Context context;
   private List<RecentModel> itemList;
    public RecentAdapter(Context context, List<RecentModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.recent,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(itemList.get(position).getProduct_images()).into(holder.binding.illuminatedtarotRecentImg);
        holder.binding.illuminatedtarotRecentImg.setImageResource(itemList.get(position).getProduct_images());
        holder.binding.textRecentItem.setText(itemList.get(position).getProduct_offers());
        holder.binding.rupeeText2RecentItem.setText("₹"+itemList.get(position).getProduct_price());
        holder.binding.strikeText3RecentItem.setText("₹ "+itemList.get(position).getProduct_discount());
        holder.binding.strikeText3RecentItem.setPaintFlags(holder.binding.strikeText3RecentItem.getPaintFlags()|Paint.STRIKE_THRU_TEXT_FLAG);
        holder.binding.text16RecentItem.setText(itemList.get(position).getProduct_name());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecentBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= RecentBinding.bind(itemView);
        }
    }
}