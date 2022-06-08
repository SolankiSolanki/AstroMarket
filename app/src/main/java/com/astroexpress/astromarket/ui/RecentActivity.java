package com.astroexpress.astromarket.ui;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.astroexpress.astromarket.R;
import com.astroexpress.astromarket.adapter.RecentAdapter;
import com.astroexpress.astromarket.model.RecentModel;

import java.util.ArrayList;
import java.util.List;

public class RecentActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar_recent;
    List<RecentModel> gemstones_item;
    RecentAdapter recent_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_main);
        toolbar_recent = findViewById(R.id.toolbar_order);
        setSupportActionBar(toolbar_recent);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_back);
        toolbar_recent.setNavigationOnClickListener(view -> onBackPressed());
        recyclerView=findViewById(R.id.recyclerview_recent);
        gemstones_item=new ArrayList<>();

        gemstones_item.add(new RecentModel("Evil Eye for Relationship",R.drawable.recent," 16%"," 1250","25900"));
        gemstones_item.add(new RecentModel("Natural Australian Fire Opal - 10.85 Carat (12.00 Ratti)" ,R.drawable.sd,"16%"," 1250","25900"));
        gemstones_item.add(new RecentModel("Evil Eye for Relationship",R.drawable.ed,"16%"," 1250","25900"));
        gemstones_item.add(new RecentModel("Evil Eye for Relationship",R.drawable.as,"16%"," 1250","25900"));
        gemstones_item.add(new RecentModel("Evil Eye for Relationship",R.drawable.ed,"16%"," 1250","25900"));
        gemstones_item.add(new RecentModel("Evil Eye for Relationship",R.drawable.as,"16%"," 1250","25900"));
        recent_adapter=new RecentAdapter(getApplicationContext(),gemstones_item);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recent_adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bag, menu);
        return true;
    }
}