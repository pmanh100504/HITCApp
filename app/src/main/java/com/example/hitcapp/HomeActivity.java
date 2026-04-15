package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
=======
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
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
<<<<<<< HEAD
=======
=======
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private TextView tvWelcomeUser;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
    private Button btnLogout;
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ListView lvCategoryDrawer;
    private List<Category> categoryList;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
    private CategoryAdapter categoryAdapter;

    private RecyclerView rvProducts;
    private List<Product> productList;
    private ProductAdapter productAdapter;

    private EditText etSearch;
    private ImageView btnMenu;
    private MaterialButton btnDrawerLogout;
    private ImageView btnCartTop;
<<<<<<< HEAD
=======
=======
    private CategoryAdapter adapter;
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        setupCategoryList();
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
        setupProductList();
        setupSearch();

        // Cấu hình Toolbar
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }

<<<<<<< HEAD
        // Mở menu khi bấm vào icon menu trên toolbar
        btnMenu.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        // Hiển thị tên người dùng nếu có
=======
        btnMenu.setOnClickListener(v -> {
=======

        // Cấu hình Toolbar làm nút mở Drawer
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> {
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
            drawerLayout.openDrawer(GravityCompat.START);
        });

        // Lấy tên user từ Intent (nếu có)
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
        String username = getIntent().getStringExtra("USERNAME");
        if (username != null && !username.isEmpty()) {
            tvWelcomeUser.setText("Welcome Back, " + username + "!");
        }

<<<<<<< HEAD
        // Xử lý nút Đăng xuất trong Drawer
        btnDrawerLogout.setOnClickListener(v -> {
=======
<<<<<<< HEAD
        btnDrawerLogout.setOnClickListener(v -> {
=======
        btnLogout.setOnClickListener(v -> {
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
<<<<<<< HEAD

        // Mở giỏ hàng
=======
<<<<<<< HEAD

        // Mở trang giỏ hàng khi bấm vào nút Cart
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
        btnCartTop.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CartActivity.class);
            startActivity(intent);
        });
<<<<<<< HEAD
=======
=======
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
    }

    private void initViews() {
        tvWelcomeUser = findViewById(R.id.tvWelcomeUser);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
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
<<<<<<< HEAD
=======
=======
        btnLogout = findViewById(R.id.btnLogout);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        lvCategoryDrawer = findViewById(R.id.lvCategoryDrawer);
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
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
        
        lvCategoryDrawer.setOnItemClickListener((parent, view, position, id) -> {
            drawerLayout.closeDrawer(GravityCompat.START);
            Category selectedCategory = categoryList.get(position);
            String name = selectedCategory.getName();
            
            if (name.equals("Điện thoại") || name.equals("Laptop")) {
                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                intent.putExtra("CATEGORY_NAME", name);
                startActivity(intent);
            }
        });
    }

    private void setupProductList() {
        productList = new ArrayList<>();
//        // Lưu ý: Đảm bảo các drawable này có tồn tại trong thư mục res/drawable
//        productList.add(new Product("iPhone 15 Pro Max", 1299.0, R.drawable.baseline_image_24));
//        productList.add(new Product("Samsung Galaxy S24 Ultra", 1199.0, R.drawable.baseline_image_24));
//        productList.add(new Product("MacBook Pro M3", 1999.0, R.drawable.baseline_image_24));
//        productList.add(new Product("Sony WH-1000XM5", 349.0, R.drawable.baseline_image_24));
//        productList.add(new Product("iPad Pro 12.9", 1099.0, R.drawable.baseline_image_24));
=======
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
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
        productList.add(new Product("Apple Watch Series 9", 399.0, R.drawable.baseline_image_24));

        productAdapter = new ProductAdapter(productList);
        rvProducts.setLayoutManager(new GridLayoutManager(this, 2));
        rvProducts.setAdapter(productAdapter);
    }
<<<<<<< HEAD
}
=======
=======
>>>>>>> f9bed0332c84ce794b98567432af0edc3024df0c
}
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
