package com.astroexpress.astromarket.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.astroexpress.astromarket.R;

public class Category_MainActivity extends AppCompatActivity {
    ListView listView;
    TextView textView;
    ListView listView1;
    TextView textView1;
    ListView listView2;
    TextView textView2;
    ListView listView3;
    TextView textView3;
    ListView listView4;
    TextView textView4;
    ListView listView5;
    TextView textView5;
    ListView listView6;
    TextView textView6;

    //for button
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_main);
        String tutorials[] = { "South Sea Pearl", "Tahitian Black Pearl", "Keshi Pearl", "Basra Pearl",
                 "Golden Sea Pearl", "Pearl Jewellery" };


        textView=findViewById(R.id.text_edit_tarot);
        listView=findViewById(R.id.exp_list_view);
        textView1=findViewById(R.id.text1_edit_tarot);
        listView1=findViewById(R.id.exp1_list_view);
        textView2=findViewById(R.id.text2_edit_tarot);
        listView2=findViewById(R.id.exp2_list_view);
       textView3=findViewById(R.id.text2_edit_kawach);
        listView3=findViewById(R.id.exp2_list_view1);
        textView4=findViewById(R.id.text2_edit_pearls);
        listView4=findViewById(R.id.exp2_list_view2);
        textView5=findViewById(R.id.text2_edit_rudraksha);
        listView5=findViewById(R.id.exp2_list_view3);
        textView6=findViewById(R.id.text2_edit_gemstones);
        listView6=findViewById(R.id.exp2_list_view4);

        // for button
        imageButton = findViewById(R.id.back1);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

         ArrayAdapter<String> arr;
         arr = new ArrayAdapter<String>(this, R.layout.list_item, tutorials);
         listView.setAdapter(arr);
         ArrayAdapter<String> arr1;
         arr1 = new ArrayAdapter<String>(this, R.layout.list_item, tutorials);
         listView1.setAdapter(arr1);
        ArrayAdapter<String> arr2;
        arr2 = new ArrayAdapter<String>(this, R.layout.list_item, tutorials);
        listView2.setAdapter(arr2);
        ArrayAdapter<String> arr3;
        arr3 = new ArrayAdapter<String>(this, R.layout.list_item, tutorials);
        listView3.setAdapter(arr3);
        ArrayAdapter<String> arr4;
        arr4 = new ArrayAdapter<String>(this, R.layout.list_item, tutorials);
        listView4.setAdapter(arr4);
        ArrayAdapter<String> arr5;
        arr5 = new ArrayAdapter<String>(this, R.layout.list_item, tutorials);
        listView5.setAdapter(arr5);
        ArrayAdapter<String> arr6;
        arr6 = new ArrayAdapter<String>(this, R.layout.list_item, tutorials);
        listView6.setAdapter(arr6);

         textView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (listView.getVisibility() == View.GONE){
                     textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_tarot_icon, 0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0);
                     listView.setVisibility(View.VISIBLE);
                 }else {
                     textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_tarot_icon, 0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0);
                     listView.setVisibility(View.GONE);
                 }
             }
         });
         textView1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (listView1.getVisibility() == View.GONE){
                     textView1.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_crystal_bracelet, 0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0);
                     listView1.setVisibility(View.VISIBLE);
                 }else {
                     textView1.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_crystal_bracelet, 0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0);
                     listView1.setVisibility(View.GONE);
                 }
             }
         });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listView2.getVisibility() == View.GONE){
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_evil_eye_icon, 0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0);
                    listView2.setVisibility(View.VISIBLE);
                }else {
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_evil_eye_icon, 0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0);
                    listView2.setVisibility(View.GONE);
                }
            }
        });

       textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listView3.getVisibility() == View.GONE){
                    textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_kawach_icon, 0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0);
                    listView3.setVisibility(View.VISIBLE);
                }else {
                    textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_kawach_icon, 0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0);
                    listView3.setVisibility(View.GONE);
                }
            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listView4.getVisibility() == View.GONE){
                    textView4.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_pearls_icon, 0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0);
                    listView4.setVisibility(View.VISIBLE);
                }else {
                    textView4.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_pearls_icon, 0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0);
                    listView4.setVisibility(View.GONE);
                }
            }
        });

        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listView5.getVisibility() == View.GONE){
                    textView5.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_rudra_icon, 0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0);
                    listView5.setVisibility(View.VISIBLE);
                }else {
                    textView5.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_rudra_icon, 0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0);
                    listView5.setVisibility(View.GONE);
                }
            }
        });

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listView6.getVisibility() == View.GONE){
                    textView6.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_gemstone_icon, 0, R.drawable.ic_baseline_keyboard_arrow_up_24, 0);
                    listView6.setVisibility(View.VISIBLE);
                }else {
                    textView6.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_gemstone_icon, 0, R.drawable.ic_baseline_keyboard_arrow_down_24, 0);
                    listView6.setVisibility(View.GONE);
                }
            }
        });

    }
}