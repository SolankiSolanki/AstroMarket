package com.astroexpress.astromarket.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.astroexpress.astromarket.R;
import com.astroexpress.astromarket.adapter.ProductListAdapter;
import com.astroexpress.astromarket.model.ProductListModel;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {
     RecyclerView recyclerView;
     Toolbar toolbar;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_main);

        String title = getIntent().getStringExtra("title");

        setSupportActionBar(toolbar);
        toolbar=findViewById(R.id.toolbar_product_list);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.left_back);
        getSupportActionBar().setTitle(title);

        Spinner spinCountry;

        spinCountry= (Spinner) findViewById(R.id.spinSort);//fetch the spinner from layout file

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources()
                .getStringArray(R.array.array_sort));//setting the country_array to spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinCountry.setAdapter(adapter);
//if you want to set any action you can do in this listener
        spinCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
//                   View v = spinCountry.getSelectedView();
//                ((TextView)v).setTextColor(getResources().getColor(R.color.DarkBlue));
                ((TextView) arg0.getChildAt(0)).setTextColor(getResources().getColor(R.color.DarkBlue));

                if(position == 0){


                }

                if (position == 1){


                }
                Toast.makeText(getApplicationContext(),"click on:" +spinCountry.getItemAtPosition(position) , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        toolbar.setNavigationOnClickListener(view -> onBackPressed());
        recyclerView=findViewById(R.id.recyclerview_product_list);
        List<ProductListModel> order=new ArrayList<>();
        order.add(new ProductListModel("Original South Sea Pearl 15.59 Carat (17.25 Ratti)",R.drawable.originalsouthseapearl,"16% "," 25,900","1500"));
        order.add(new ProductListModel("Original South Sea Pearl 15.59 Carat (17.25 Ratti)",R.drawable.braclet,"16% "," 25,900","1000"));
        order.add(new ProductListModel("Original South Sea Pearl 15.59 Carat (17.25 Ratti)",R.drawable.braclet,"16% "," 25,900","1500"));
        order.add(new ProductListModel("Original South Sea Pearl 15.59 Carat (17.25 Ratti)",R.drawable.braclet,"16% "," 25,900","1800"));
        order.add(new ProductListModel("Original South Sea Pearl 15.59 Carat (17.25 Ratti)",R.drawable.originalsouthseapearl,"16% "," 25,900","2000"));
        order.add(new ProductListModel("Original South Sea Pearl 15.59 Carat (17.25 Ratti)",R.drawable.originalsouthseapearl,"16% "," 25,900","2200"));
        order.add(new ProductListModel("Original South Sea Pearl 15.59 Carat (17.25 Ratti)",R.drawable.braclet,"16% "," 25,900","800"));
        order.add(new ProductListModel("Original South Sea Pearl 15.59 Carat (17.25 Ratti)",R.drawable.originalsouthseapearl,"16% "," 25,900","2500"));
        ProductListAdapter product_list_adapter=new ProductListAdapter(getApplicationContext(),order);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(product_list_adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}