package com.astroexpress.astromarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.astroexpress.astromarket.R;
import com.astroexpress.astromarket.model.BannerModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class BannerAdapter extends PagerAdapter {
    Context context;
    List<BannerModel> bannerModels;

    public BannerAdapter(Context context, List<BannerModel> bannerModels) {
        this.context = context;
        this.bannerModels = bannerModels;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_banner_item,container,false);
        ImageView imageView = view.findViewById(R.id.banner_img);
        Glide.with(context)
                .load(bannerModels.get(position).getImageUrl())
                .centerCrop()
                .placeholder(R.drawable.img)
                .into(imageView);
            container.addView(view,0);
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
