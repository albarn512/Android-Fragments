package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CartDetail extends AppCompatActivity {
    ImageView ivDetail;
    TextView tvDJudul, tvDDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_detail);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        ivDetail = findViewById(R.id.iv_detail);
        tvDDesc = findViewById(R.id.tv_deskripsi);
        tvDJudul = findViewById(R.id.tv_detailjudul);

        getIncomingIntent();
    }

    private  void  getIncomingIntent(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int getImg = bundle.getInt("img_url");
            String getTitle = bundle.getString("title");
            String getDetail = bundle.getString("detail");

            tvDJudul.setText(getTitle);
            tvDDesc.setText(getDetail);
            ivDetail.setImageResource(getImg);

        }else{
            Toast.makeText(this, "Data tidak ditemukan",Toast.LENGTH_SHORT).show();
        }

    }
}
