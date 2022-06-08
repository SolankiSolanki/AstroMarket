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
import com.astroexpress.astromarket.databinding.TrendingwearsBinding;
import com.astroexpress.astromarket.model.TrendingWearsModel;
import com.astroexpress.astromarket.ui.ProductPageMainActivity;


import java.util.List;

public class TrendingWearsAdapter extends RecyclerView.Adapter<TrendingWearsAdapter.ViewHolder>{
    Context context;
    List<TrendingWearsModel> listitem;

    public TrendingWearsAdapter(Context context, List<TrendingWearsModel> listitem) {
        this.context = context;
        this.listitem = listitem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.trendingwears,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.illuminatedtarotTrendwears.setImageResource(listitem.get(position).getImageUrl_trend());
        holder.binding.text16Trendwears.setText(listitem.get(position).getTextsixteen_trend());
        holder.binding.rupeeText2Trendwears.setText("₹"+listitem.get(position).getTextnumber_rupee());
        holder.binding.textTrendwears.setText(listitem.get(position).getTitletext());
        holder.binding.strikeText3Trendwears.setText("₹"+listitem.get(position).getTitlestrik());
        holder.binding.strikeText3Trendwears.setPaintFlags(holder.binding.strikeText3Trendwears.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);

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
        return listitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TrendingwearsBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= TrendingwearsBinding.bind(itemView);
        }
    }
}