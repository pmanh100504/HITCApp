package com.example.hitcapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Toolbar toolbar = findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        ImageView imgProductDetail = findViewById(R.id.imgProductDetail);
        TextView tvProductNameDetail = findViewById(R.id.tvProductNameDetail);
        TextView tvProductPriceDetail = findViewById(R.id.tvProductPriceDetail);
        ExtendedFloatingActionButton fabAddToCart = findViewById(R.id.fabAddToCart);

        // Nhận dữ liệu từ Intent
        String name = getIntent().getStringExtra("product_name");
        double price = getIntent().getDoubleExtra("product_price", 0.0);
        int image = getIntent().getIntExtra("product_image", R.drawable.baseline_image_24);

        tvProductNameDetail.setText(name);
        tvProductPriceDetail.setText("$" + price);
        imgProductDetail.setImageResource(image);

        // Xử lý thêm vào giỏ hàng
        fabAddToCart.setOnClickListener(v -> {
            Product currentProduct = new Product(name, price, image);
            CartManager.getInstance().addProduct(currentProduct);
            Toast.makeText(this, "Đã thêm " + name + " vào giỏ hàng", Toast.LENGTH_SHORT).show();
        });
    }
}
