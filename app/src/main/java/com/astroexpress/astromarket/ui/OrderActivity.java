package com.astroexpress.astromarket.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.astroexpress.astromarket.R;
import com.astroexpress.astromarket.adapter.OrderAdapter;

public class OrderActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_main);

        toolbar_order=findViewById(R.id.toolbar_order);
        setSupportActionBar(toolbar_order);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_back);
        toolbar_order.setNavigationOnClickListener(view -> onBackPressed());
        recyclerView=findViewById(R.id.recyclerview_order);
        OrderAdapter order_adapter=new OrderAdapter(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(order_adapter);
    }

}