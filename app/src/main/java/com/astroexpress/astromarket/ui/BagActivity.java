package com.astroexpress.astromarket.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.astroexpress.astromarket.R;
import com.astroexpress.astromarket.adapter.BagAdapter;
import com.astroexpress.astromarket.adapter.BottomSheetAdapter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BagActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Toolbar toolbar;
    ImageButton imageButton;
    ScrollView scrollView;
    ScrollView scrollView1;
    //for button
    ImageButton button;
    AppCompatButton appCompatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag_main);
        toolbar=findViewById(R.id.toolbar_bag);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());
        recyclerView=findViewById(R.id.recyclerview_bag);
        BagAdapter bagadapter=new BagAdapter(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(bagadapter);
        imageButton=findViewById(R.id.btn_edit_address);
        scrollView=findViewById(R.id.scrollview_bag);
        scrollView1=findViewById(R.id.scrollview1_bag);

        // for button
        button= findViewById(R.id.btn_edit_address);
        appCompatButton = findViewById(R.id.btn_bag);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    showBottomSheetDialog();

            }
        });

        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CompleteSuccessActivity.class));
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bag, menu);
        return true;
    }

    private void showBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        bottomSheetDialog.setContentView(R.layout.activity_bottom_sheet);

        RecyclerView recyclerView = bottomSheetDialog.findViewById(R.id.recyclerview_edit_address);


        BottomSheetAdapter editAddress_adapter=new BottomSheetAdapter(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(editAddress_adapter);

        Button nbutton = bottomSheetDialog.findViewById(R.id.addnew);

        ConstraintLayout linearLayout = bottomSheetDialog.findViewById(R.id.form);

        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nbutton.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
            }
        });

        ImageView imageView = bottomSheetDialog.findViewById(R.id.cross);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

        Dialog dialog = new Dialog(getApplicationContext());
        if (dialog == bottomSheetDialog){

        }

//        bottomSheetDialog.getBehavior().getState() = BottomSheetBehavior.STATE_EXPANDED;
        BottomSheetBehavior behavior = bottomSheetDialog.getBehavior();

//        ScrollView scrollView =bottomSheetDialog.findViewById(R.id.scroll1);

        bottomSheetDialog.getBehavior().addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING){
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });


//        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
//            @Override
//            public void onScrollChanged() {
//                if (scrollView.getScrollY()==0 && bottomSheetDialog.getBehavior().getState() == BottomSheetBehavior.STATE_EXPANDED){
//                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//                }
//            }
//        });

        bottomSheetDialog.show();

    }
}