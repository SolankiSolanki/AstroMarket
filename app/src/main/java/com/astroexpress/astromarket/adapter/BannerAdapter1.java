package com.astroexpress.astromarket.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.astroexpress.astromarket.ProductWithBox;
import com.astroexpress.astromarket.R;
import com.astroexpress.astromarket.model.BannerModel1;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BannerAdapter1 extends PagerAdapter {
    Context context;
    List<BannerModel1> bannerModels;

    public BannerAdapter1(Context context, List<BannerModel1> bannerModels) {
        this.context = context;
        this.bannerModels = bannerModels;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.single1_banner,container,false);
        ImageView imageView = view.findViewById(R.id.banner1_img);
        Glide.with(context).load(bannerModels.get(position).getImg()).centerCrop().placeholder(R.drawable.img)
                .into(imageView);
        container.addView(view,0);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ProductWithBox.class);

                intent.putExtra("position",position);
                    intent.putExtra("data", (Serializable) bannerModels);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

            }
        });

        return view;
    }

    @Override
    public int getCount() {
        return bannerModels.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}