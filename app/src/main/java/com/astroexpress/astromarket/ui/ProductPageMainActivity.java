package com.astroexpress.astromarket.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.astroexpress.astromarket.ProductWithBox;
import com.astroexpress.astromarket.R;
import com.astroexpress.astromarket.adapter.BannerAdapter1;
import com.astroexpress.astromarket.model.BannerModel1;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class ProductPageMainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPager;
    List<BannerModel1> bannerModels1;
    TabLayout tabLayout1;
    int currentPage = 0;
    ImageButton imageButton;
    ImageButton imageButton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page_main);
        toolbar=findViewById(R.id.tool_product);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        viewPager=findViewById(R.id.banner1_view);
        tabLayout1=findViewById(R.id.tab_layout1);
        imageButton=findViewById(R.id.btn_product);
        imageButton1=findViewById(R.id.btn1_product);

//        int position = getIntent().getIntExtra("position", 0);
//
//        List<BannerModel1> list = (List<BannerModel1>) getIntent().getSerializableExtra("data");


        bannerModels1 = new ArrayList<>();
        bannerModels1.add(new BannerModel1( R.drawable.tcard1));
        bannerModels1.add(new BannerModel1(R.drawable.tcard2));
        bannerModels1.add(new BannerModel1(R.drawable.tcard3));

        BannerAdapter1 bannerAdapter1 = new BannerAdapter1(getApplicationContext(), bannerModels1);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(0,0,90,0);
        viewPager.setAdapter(bannerAdapter1);
//        viewPager.setCurrentItem(position);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (currentPage == 0){
                        viewPager.setCurrentItem(bannerModels1.size()-1,false);
                        currentPage = bannerModels1.size()-1;
                    }else {
                        currentPage--;
                        viewPager.setCurrentItem(currentPage);
                    }
                }catch (Exception e){
                    Log.e("TAGG", "onClick: ", e);
                }

            }
        });
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPage == bannerModels1.size()-1) {
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

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}