package com.astroexpress.astromarket;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.astroexpress.astromarket.adapter.BannerAdapter1;
import com.astroexpress.astromarket.adapter.ProductItemAdapter;
import com.astroexpress.astromarket.adapter.ProductWithBoxAdapter;
import com.astroexpress.astromarket.model.BannerModel;
import com.astroexpress.astromarket.model.BannerModel1;
import com.astroexpress.astromarket.ui.ProductPageMainActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ProductWithBox extends AppCompatActivity {


    ViewPager viewPager;
    TabLayout tabLayout1;
    int currentPage = 0;
    ImageButton imageButton;
    ImageButton imageButton1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_with_box);

        viewPager = findViewById(R.id.banner1_view1);

        tabLayout1=findViewById(R.id.tab_layout1);
        imageButton=findViewById(R.id.btn_prev);
        imageButton1=findViewById(R.id.btn_next);
        imageView=findViewById(R.id.close_product);

        int position = getIntent().getIntExtra("position",0);

        List<BannerModel1> list = (List<BannerModel1>) getIntent().getSerializableExtra("data");

        ProductWithBoxAdapter productWithBoxAdapter = new ProductWithBoxAdapter(getApplicationContext(), list);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(0,0,90,0);
        viewPager.setAdapter(productWithBoxAdapter);
        viewPager.setCurrentItem(position);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPage == 0){
                    viewPager.setCurrentItem(list.size()-1,false);
                    currentPage = list.size()-1;
                }else {
                    currentPage--;
                    viewPager.setCurrentItem(currentPage);
                }
            }
        });
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPage == list.size()-1) {
                    viewPager.setCurrentItem(0, false);
                    currentPage=0;
                }
                else{
                    currentPage++;
                    viewPager.setCurrentItem(currentPage);
                }
            }
        });
        tabLayout1.setupWithViewPager(viewPager, true);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

//        String position = getIntent().getStringExtra("position");
//
//        Log.i("taggar", "onCreate: " + " " + position);

//        Intent intent = getIntent();
//        String str = intent.getStringExtra("message");
//        viewPager.setCurrentItem(str);

    }

}