package com.example.hitcapp;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.Locale;

public class CartActivity extends AppCompatActivity implements CartAdapter.OnCartChangeListener {

    private RecyclerView rvCart;
    private CartAdapter cartAdapter;
    private TextView tvTotalPrice, tvEmptyCart;
    private MaterialButton btnCheckOut;
    private View layoutCheckout;
=======
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CartActivity extends AppCompatActivity {
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

<<<<<<< HEAD
        initViews();
        setupToolbar();
        setupRecyclerView();
        updateUI();

        btnCheckOut.setOnClickListener(v -> {
            Intent intent = new Intent(this, CheckoutActivity.class);
            startActivity(intent);
        });
    }

    private void initViews() {
        rvCart = findViewById(R.id.rvCart);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        tvEmptyCart = findViewById(R.id.tvEmptyCart);
        btnCheckOut = findViewById(R.id.btnCheckOut);
        layoutCheckout = findViewById(R.id.layoutCheckout);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbarCart);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());
    }

    private void setupRecyclerView() {
        cartAdapter = new CartAdapter(CartManager.getInstance().getCartItems(), this);
        rvCart.setLayoutManager(new LinearLayoutManager(this));
        rvCart.setAdapter(cartAdapter);
    }

    private void updateUI() {
        double total = CartManager.getInstance().getTotalPrice();
        tvTotalPrice.setText(String.format(Locale.US, "$%.2f", total));

        if (CartManager.getInstance().getCartItems().isEmpty()) {
            tvEmptyCart.setVisibility(View.VISIBLE);
            layoutCheckout.setVisibility(View.GONE);
            rvCart.setVisibility(View.GONE);
        } else {
            tvEmptyCart.setVisibility(View.GONE);
            layoutCheckout.setVisibility(View.VISIBLE);
            rvCart.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onQuantityChanged() {
        updateUI();
    }
}
=======
        Toolbar toolbar = findViewById(R.id.toolbarCart);
        setSupportActionBar(toolbar);
        
        toolbar.setNavigationOnClickListener(v -> finish());
    }
}
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
