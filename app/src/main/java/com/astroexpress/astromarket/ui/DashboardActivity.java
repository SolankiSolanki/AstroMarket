package com.astroexpress.astromarket.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.astroexpress.astromarket.PopupLayout;
import com.astroexpress.astromarket.R;
import com.astroexpress.astromarket.adapter.BannerAdapter;
import com.astroexpress.astromarket.adapter.GemstoneAdapter;
import com.astroexpress.astromarket.adapter.ProductItemAdapter;
import com.astroexpress.astromarket.adapter.RecentViewItemAdapter;
import com.astroexpress.astromarket.adapter.TrendingWearsAdapter;
import com.astroexpress.astromarket.databinding.ActivityDashboardBinding;
import com.astroexpress.astromarket.model.BannerModel;
import com.astroexpress.astromarket.model.GemstoneModel;
import com.astroexpress.astromarket.model.ProductItem_Model;
import com.astroexpress.astromarket.model.RecentViewItemModel;
import com.astroexpress.astromarket.model.TrendingWearsModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //for toolbar activity open
    Toolbar toolbar;

    ActivityDashboardBinding binding;
    // for nav drawer
    public ActionBarDrawerToggle actionBarDrawerToggle;

    List<BannerModel> bannerModels;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 1000;
    final long PERIOD_MS = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.nav.setNavigationItemSelectedListener(this);


        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }

        });


        //productitem
        List<ProductItem_Model> itemList = new ArrayList<>();
        itemList.add(new ProductItem_Model("Gemstone", R.drawable.gemstone));
        itemList.add(new ProductItem_Model("Evil Eye", R.drawable.evileye));
        itemList.add(new ProductItem_Model("Bracelet", R.drawable.braclet));

        itemList.add(new ProductItem_Model("Gemstone", R.drawable.gemstone));
        itemList.add(new ProductItem_Model("Evil Eye", R.drawable.evileye));
        itemList.add(new ProductItem_Model("Bracelet", R.drawable.braclet));
        ProductItemAdapter productitemadapter = new ProductItemAdapter(getApplicationContext(), itemList);
        binding.categoryView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.categoryView.setAdapter(productitemadapter);


        //for viewpager
        bannerModels = new ArrayList<>();
        bannerModels.add(new BannerModel("https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dmlld3xlbnwwfHwwfHw%3D&w=1000&q=80"));
        bannerModels.add(new BannerModel("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"));
        bannerModels.add(new BannerModel("https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dmlld3xlbnwwfHwwfHw%3D&w=1000&q=80"));
        bannerModels.add(new BannerModel("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"));
        bannerModels.add(new BannerModel("https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8dmlld3xlbnwwfHwwfHw%3D&w=1000&q=80"));
        bannerModels.add(new BannerModel("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"));

        BannerAdapter bannerAdapter = new BannerAdapter(getApplicationContext(), bannerModels);
        binding.bannerView.setClipToPadding(true);
//        binding.bannerView.setPadding(50,0,50,0);
        binding.bannerView.setAdapter(bannerAdapter);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == bannerModels.size()) {
                    currentPage = 0;
                }
                binding.bannerView.setCurrentItem(currentPage++, false);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
        binding.tabLayout.setupWithViewPager(binding.bannerView, true);


        //recentview item recycle view
        List<RecentViewItemModel> itemListrecentview = new ArrayList<>();
        itemListrecentview.add(new RecentViewItemModel("16", "Evil Eye for Relationship", "1250", "1500", R.drawable.evileyforrelationship));
        itemListrecentview.add(new RecentViewItemModel("16", "Natural Australian Fire...\n", "1250", "1600", R.drawable.gemstone3));
        itemListrecentview.add(new RecentViewItemModel("16", "12.43 Ratti Natural Amet..", "1250", "1700", R.drawable.gemstone1));

        itemListrecentview.add(new RecentViewItemModel("16", "Evil Eye for Relationship", "1250", "1500", R.drawable.evileyforrelationship));
        itemListrecentview.add(new RecentViewItemModel("16", "Natural Australian Fire...\n", "1250", "1600", R.drawable.gemstone3));
        itemListrecentview.add(new RecentViewItemModel("16", "12.43 Ratti Natural Amet..", "1250", "1700", R.drawable.gemstone1));
        RecentViewItemAdapter recentviewitemadapter = new RecentViewItemAdapter(getApplicationContext(), itemListrecentview);
        binding.recentview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.recentview.setAdapter(recentviewitemadapter);
        //gemstone recycle view
        List<GemstoneModel> gemstones_item = new ArrayList<>();
        gemstones_item.add(new GemstoneModel("12.43 Ratti Natural Amet...", R.drawable.gemstone1, "16", "1250", "1500"));
        gemstones_item.add(new GemstoneModel("Natural Aquamarine G...", R.drawable.gemstone2, "16", "1250", "1500"));
        gemstones_item.add(new GemstoneModel("Natural Australian Fire...", R.drawable.gemstone3, "16", "1250", "1500"));

        gemstones_item.add(new GemstoneModel("12.43 Ratti Natural Amet...", R.drawable.gemstone1, "16", "1250", "1500"));
        gemstones_item.add(new GemstoneModel("Natural Aquamarine G...", R.drawable.gemstone2, "16", "1250", "1500"));
        gemstones_item.add(new GemstoneModel("Natural Australian Fire...", R.drawable.gemstone3, "16", "1250", "1500"));
        GemstoneAdapter gemstone = new GemstoneAdapter(getApplicationContext(), gemstones_item);
        binding.GemstoneRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.GemstoneRecyclerview.setAdapter(gemstone);
        //trendingwears recycle view
        List<TrendingWearsModel> trendingWears_item = new ArrayList<>();
        trendingWears_item.add(new TrendingWearsModel("16", "Natural Smoky Quartz...", "1250", "1500", R.drawable.wear1));
        trendingWears_item.add(new TrendingWearsModel("16", "Original Pearls Stretch...", "1250", "1500", R.drawable.wear2));
        trendingWears_item.add(new TrendingWearsModel("16", "Natural Amethyst Tum...", "1250", "1500", R.drawable.wear3));

        trendingWears_item.add(new TrendingWearsModel("16", "Natural Smoky Quartz...", "1250", "1500", R.drawable.wear1));
        trendingWears_item.add(new TrendingWearsModel("16", "Original Pearls Stretch...", "1250", "1500", R.drawable.wear2));
        trendingWears_item.add(new TrendingWearsModel("16", "Natural Amethyst Tum...", "1250", "1500", R.drawable.wear3));

        TrendingWearsAdapter trendingWearsadapter = new TrendingWearsAdapter(getApplicationContext(), trendingWears_item);
        binding.TrendingWearsRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.TrendingWearsRecyclerview.setAdapter(trendingWearsadapter);
    /*    //to go secondactivity
        toolbar_dashbord.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.wishlist) {
                    Intent intent=new Intent(DashboardActivity.this, BagMainActivity.class);
                    startActivity(intent);

                } else if (item.getItemId() == R.id.order) {
                    Intent intent=new Intent(DashboardActivity.this, ProductPageMainActivity.class);
                    startActivity(intent);

                } else {

                }

                return false;
            }
        });
*/

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout,binding.toolbar, R.string.nav_open, R.string.nav_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_menu_button);
        actionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawerLayout.openDrawer(GravityCompat.START);
            }
        });
//        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();

        binding.nav.getHeaderView(0).findViewById(R.id.close_nav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
  // for toolbar activity open
        /*toolbar.setOnMenuItemClickListener(menuItem -> {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.wishlist) {
                Intent intent=new Intent(DashboardActivity.this, WishlistActivity.class);
                startActivity(intent);
                return true;
            }
            else {

                return false;
            }
        });*/

        binding.imageTarot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ProductPageMainActivity.class));
            }
        });

        binding.imageEvil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ProductPageMainActivity.class));
            }
        });

        binding.imageRudra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ProductPageMainActivity.class));
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.order:
                startActivity(new Intent(getApplicationContext(), BagActivity.class));
                return true;
            case R.id.wishlist:
                startActivity(new Intent(getApplicationContext(), WishlistActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_orders:
                startActivity(new Intent(getApplicationContext(), OrderActivity.class));
                break;

            case R.id.nav_home:
                startActivity(new Intent(getApplicationContext(), CompleteSuccessActivity.class));
                break;

            case R.id.nav_wallet:
                startActivity(new Intent(getApplicationContext(), ProductListActivity.class));
                break;

            case R.id.nav_following:
                startActivity(new Intent(getApplicationContext(), RecentActivity.class));
                break;

            case R.id.nav_chat:
                startActivity(new Intent(getApplicationContext(), Category_MainActivity.class));
                break;

//            case R.id.nav_call:
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                break;

            case R.id.nav_notifications:
                startActivity(new Intent(getApplicationContext(), PopupLayout.class));
                break;

            case R.id.nav_profiles:
                startActivity(new Intent(getApplicationContext(), ProductPageMainActivity.class));
                break;

            default:
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                return false;
        }
       binding.drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        finish();
    }
}