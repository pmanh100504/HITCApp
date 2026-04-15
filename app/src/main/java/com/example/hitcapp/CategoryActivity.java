package com.example.hitcapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView rvCategoryProducts;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        categoryName = getIntent().getStringExtra("CATEGORY_NAME");

        toolbar = findViewById(R.id.toolbarCategory);
        rvCategoryProducts = findViewById(R.id.rvCategoryProducts);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(categoryName);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        setupProductList();
    }

    private void setupProductList() {
        productList = new ArrayList<>();
        
        if (categoryName.equals("Điện thoại")) {
//            productList.add(new Product("iPhone 15 Pro Max", 1299.0, R.drawable.baseline_image_24));
//            productList.add(new Product("Samsung Galaxy S24 Ultra", 1199.0, R.drawable.baseline_image_24));
//            productList.add(new Product("Oppo Reno 11 Pro", 599.0, R.drawable.baseline_image_24));
//            productList.add(new Product("Xiaomi 14 Ultra", 999.0, R.drawable.baseline_image_24));
        } else if (categoryName.equals("Laptop")) {
//            productList.add(new Product("MacBook Pro M3", 1999.0, R.drawable.baseline_image_24));
//            productList.add(new Product("Dell XPS 13", 1299.0, R.drawable.baseline_image_24));
//            productList.add(new Product("Asus ROG Strix", 1599.0, R.drawable.baseline_image_24));
//            productList.add(new Product("HP Spectre x360", 1399.0, R.drawable.baseline_image_24));
        }

        productAdapter = new ProductAdapter(productList);
        rvCategoryProducts.setLayoutManager(new GridLayoutManager(this, 2));
        rvCategoryProducts.setAdapter(productAdapter);
    }
}