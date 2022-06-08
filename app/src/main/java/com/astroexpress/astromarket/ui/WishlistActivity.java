package com.astroexpress.astromarket.ui;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.astroexpress.astromarket.R;
import com.astroexpress.astromarket.adapter.WishlistAdapter;


public class WishlistActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist_main);
        toolbar=findViewById(R.id.toolbar_wishlist);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_back);
        getSupportActionBar().setTitle("Wishlist");
        toolbar.setNavigationOnClickListener(view -> onBackPressed());
        recyclerView=findViewById(R.id.recyclerview_wishlist);
        WishlistAdapter wishlist_adapter=new WishlistAdapter(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(wishlist_adapter);
//        toolbar.setOnMenuItemClickListener(menuItem -> {
//            int itemId = menuItem.getItemId();
//            if (itemId == R.id.order) {
//                Intent intent=new Intent(Wishlist_MainActivity.this,BagMainActivity.class);
//                startActivity(intent);
//                return true;
//            }
//            else {
//
//                return false;
//            }
//        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wishlist, menu);
        return true;
    }
}