package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
=======
import android.view.Gravity;
import android.widget.Button;
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
<<<<<<< HEAD
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
=======
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private TextView tvWelcomeUser;
<<<<<<< HEAD
=======
    private Button btnLogout;
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ListView lvCategoryDrawer;
    private List<Category> categoryList;
<<<<<<< HEAD
    private CategoryAdapter categoryAdapter;

    private RecyclerView rvProducts;
    private List<Product> productList;
    private ProductAdapter productAdapter;

    private EditText etSearch;
    private ImageView btnMenu;
    private MaterialButton btnDrawerLogout;
    private ImageView btnCartTop;
=======
    private CategoryAdapter adapter;
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        setupCategoryList();
<<<<<<< HEAD
        setupProductList();
        setupSearch();

        // Cấu hình Toolbar
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }

        btnMenu.setOnClickListener(v -> {
=======

        // Cấu hình Toolbar làm nút mở Drawer
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> {
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
            drawerLayout.openDrawer(GravityCompat.START);
        });

        // Lấy tên user từ Intent (nếu có)
        String username = getIntent().getStringExtra("USERNAME");
        if (username != null && !username.isEmpty()) {
            tvWelcomeUser.setText("Welcome Back, " + username + "!");
        }

<<<<<<< HEAD
        btnDrawerLogout.setOnClickListener(v -> {
=======
        btnLogout.setOnClickListener(v -> {
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
<<<<<<< HEAD

        // Mở trang giỏ hàng khi bấm vào nút Cart
        btnCartTop.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CartActivity.class);
            startActivity(intent);
        });
=======
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
    }

    private void initViews() {
        tvWelcomeUser = findViewById(R.id.tvWelcomeUser);
<<<<<<< HEAD
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        lvCategoryDrawer = findViewById(R.id.lvCategoryDrawer);
        rvProducts = findViewById(R.id.rvProducts);
        etSearch = findViewById(R.id.etSearch);
        btnMenu = findViewById(R.id.btnMenu);
        btnDrawerLogout = findViewById(R.id.btnDrawerLogout);
        btnCartTop = findViewById(R.id.btnCartTop);
    }

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (productAdapter != null) {
                    productAdapter.filter(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
=======
        btnLogout = findViewById(R.id.btnLogout);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        lvCategoryDrawer = findViewById(R.id.lvCategoryDrawer);
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
    }

    private void setupCategoryList() {
        categoryList = new ArrayList<>();
        categoryList.add(new Category("Điện thoại", android.R.drawable.ic_menu_call));
        categoryList.add(new Category("Laptop", android.R.drawable.ic_menu_view));
        categoryList.add(new Category("Liên hệ", android.R.drawable.ic_menu_help));
        categoryList.add(new Category("Thông tin", android.R.drawable.ic_menu_info_details));

<<<<<<< HEAD
        categoryAdapter = new CategoryAdapter(this, R.layout.item_category, categoryList);
        lvCategoryDrawer.setAdapter(categoryAdapter);
        
=======
        adapter = new CategoryAdapter(this, R.layout.item_category, categoryList);
        lvCategoryDrawer.setAdapter(adapter);
        
        // Đóng drawer khi chọn item (tùy chọn)
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
        lvCategoryDrawer.setOnItemClickListener((parent, view, position, id) -> {
            drawerLayout.closeDrawer(GravityCompat.START);
        });
    }
<<<<<<< HEAD

    private void setupProductList() {
        productList = new ArrayList<>();
        productList.add(new Product("iPhone 15 Pro Max", 1299.0, R.drawable.baseline_image_24));
        productList.add(new Product("Samsung Galaxy S24 Ultra", 1199.0, R.drawable.baseline_image_24));
        productList.add(new Product("MacBook Pro M3", 1999.0, R.drawable.baseline_image_24));
        productList.add(new Product("Sony WH-1000XM5", 349.0, R.drawable.baseline_image_24));
        productList.add(new Product("iPad Pro 12.9", 1099.0, R.drawable.baseline_image_24));
        productList.add(new Product("Apple Watch Series 9", 399.0, R.drawable.baseline_image_24));

        productAdapter = new ProductAdapter(productList);
        rvProducts.setLayoutManager(new GridLayoutManager(this, 2));
        rvProducts.setAdapter(productAdapter);
    }
=======
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
}