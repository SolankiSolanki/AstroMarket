package com.astroexpress.astromarket.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astroexpress.astromarket.R;
import com.astroexpress.astromarket.databinding.ProductitemBinding;
import com.astroexpress.astromarket.model.ProductItem_Model;
import com.astroexpress.astromarket.ui.ProductListActivity;
import com.astroexpress.astromarket.ui.ProductPageMainActivity;
import com.astroexpress.astromarket.ui.RecentActivity;

import java.io.Serializable;
import java.util.List;

public class ProductItemAdapter extends RecyclerView.Adapter<ProductItemAdapter.ViewHolder> {

    private final Context context;
    private List<ProductItem_Model> itemList;

    public ProductItemAdapter(Context context, List<ProductItem_Model> itemList) {
        this.context = context;
        this.itemList = itemList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.productitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.imgProductitem.setImageResource(itemList.get(position).getImageUrl());
        holder.binding.textProductitem.setText(itemList.get(position).getTitle());

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(context, ProductPageMainActivity.class);
//
//                intent.putExtra("position", position);
//                Log.i("TAGG", "onClick: "+position);
//
//                intent.putExtra("data", (Serializable) itemList);
//                Log.i("TAGG", "onClick: "+itemList);
//
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);


                Intent intent = new Intent(context, ProductListActivity.class);

                intent.putExtra("title", itemList.get(position).getTitle());

//                intent.putExtra("text", (Serializable) itemList);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

//                Intent intent = new Intent(context, ProductListActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ProductitemBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ProductitemBinding.bind(itemView);
        }
    }

}