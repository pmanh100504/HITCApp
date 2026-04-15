package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private TextView tvWelcomeUser;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ListView lvCategoryDrawer;
    private List<Category> categoryList;
    private CategoryAdapter categoryAdapter;

    private RecyclerView rvProducts;
    private List<Product> productList;
    private ProductAdapter productAdapter;

    private EditText etSearch;
    private ImageView btnMenu;
    private MaterialButton btnDrawerLogout;
    private ImageView btnCartTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
        setupCategoryList();
        setupProductList();
        setupSearch();

        // Cấu hình Toolbar
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }

        // Mở menu khi bấm vào icon menu trên toolbar
        btnMenu.setOnClickListener(v -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        // Hiển thị tên người dùng nếu có
        String username = getIntent().getStringExtra("USERNAME");
        if (username != null && !username.isEmpty()) {
            tvWelcomeUser.setText("Welcome Back, " + username + "!");
        }

        // Xử lý nút Đăng xuất trong Drawer
        btnDrawerLogout.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        // Mở giỏ hàng
        btnCartTop.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }

    private void initViews() {
        tvWelcomeUser = findViewById(R.id.tvWelcomeUser);
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
    }

    private void setupCategoryList() {
        categoryList = new ArrayList<>();
        categoryList.add(new Category("Điện thoại", android.R.drawable.ic_menu_call));
        categoryList.add(new Category("Laptop", android.R.drawable.ic_menu_view));
        categoryList.add(new Category("Liên hệ", android.R.drawable.ic_menu_help));
        categoryList.add(new Category("Thông tin", android.R.drawable.ic_menu_info_details));

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
        productList.add(new Product("Apple Watch Series 9", 399.0, R.drawable.baseline_image_24));

        productAdapter = new ProductAdapter(productList);
        rvProducts.setLayoutManager(new GridLayoutManager(this, 2));
        rvProducts.setAdapter(productAdapter);
    }
}
