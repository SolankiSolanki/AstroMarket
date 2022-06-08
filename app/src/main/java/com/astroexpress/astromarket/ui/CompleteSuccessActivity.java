package com.astroexpress.astromarket.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.astroexpress.astromarket.R;

public class CompleteSuccessActivity extends AppCompatActivity {
    TextView textView;
    TextView textView_thanku;
    //for botton
    TextView textView_goto;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_success_main);
         textView = findViewById(R.id.text_complete_download);
        SpannableString content = new SpannableString("Download Invoice");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);
        textView_thanku=findViewById(R.id.text_complete_thanku);
        textView_thanku.setText(getResources().getString(R.string.sample_string));
        textView_goto=findViewById(R.id.text_goto);
        SpannableString content_goto = new SpannableString("Go to Home");
        content_goto.setSpan(new UnderlineSpan(), 0, content_goto.length(), 0);
        textView_goto.setText(content_goto);

        textView1 = findViewById(R.id.text_complete_download);
        textView2 = findViewById(R.id.order1);
        textView3 = findViewById(R.id.evil1);
        imageButton = findViewById(R.id.back_success);
        imageButton.setOnClickListener(view -> onBackPressed());

        textView_goto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
            }
        });

        // for button
    /*    textView_goto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Order_MainActivity.class);
                startActivity(intent);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProductList_MainActivity.class);
                startActivity(intent);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Recent_MainActivity.class);
                startActivity(intent);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Wishlist_MainActivity.class);
                startActivity(intent);
            }
        }); */
    }
}