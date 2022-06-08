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
import com.astroexpress.astromarket.databinding.ProductListBinding;
import com.astroexpress.astromarket.model.ProductListModel;
import com.astroexpress.astromarket.ui.ProductPageMainActivity;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    Context context;
    private List<ProductListModel> itemList;


    public ProductListAdapter(Context context, List<ProductListModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.product_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.illuminatedtarotProductListImg.setImageResource(itemList.get(position).getImageUrl_order_list());
        holder.binding.textProductListItem.setText(itemList.get(position).getTitle_order_list());
        holder.binding.rupeeText2ProductListItem.setText("₹"+itemList.get(position).getTitle_rupee_order_list());
        holder.binding.strikeText3ProductListItem.setText("₹"+itemList.get(position).getTitle_strik_order_list());
        holder.binding.strikeText3ProductListItem.setPaintFlags(holder.binding.strikeText3ProductListItem.getPaintFlags()|Paint.STRIKE_THRU_TEXT_FLAG);
        holder.binding.text16ProductListItem.setText(itemList.get(position).getTitle_16_order_list());


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
        ProductListBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ProductListBinding.bind(itemView);
        }
    }
}
