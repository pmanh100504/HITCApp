package com.example.hitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;

public class CheckoutActivity extends AppCompatActivity {

    private TextInputEditText etFullName, etPhone, etAddress, etNotes;
    private TextView tvSummaryTotal;
    private MaterialButton btnConfirmOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        initViews();
        setupToolbar();
        displaySummary();

        btnConfirmOrder.setOnClickListener(v -> {
            if (validateInput()) {
                // Xử lý logic đặt hàng ở đây (Gửi lên server hoặc lưu database)
                
                Toast.makeText(this, "Đặt hàng thành công! Cảm ơn bạn.", Toast.LENGTH_LONG).show();
                
                // Xóa giỏ hàng sau khi đặt thành công
                CartManager.getInstance().clearCart();
                
                // Quay về màn hình chính
                Intent intent = new Intent(this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        etFullName = findViewById(R.id.etFullName);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        etNotes = findViewById(R.id.etNotes);
        tvSummaryTotal = findViewById(R.id.tvSummaryTotal);
        btnConfirmOrder = findViewById(R.id.btnConfirmOrder);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbarCheckout);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());
    }

    private void displaySummary() {
        double total = CartManager.getInstance().getTotalPrice();
        java.text.NumberFormat formatter = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("vi", "VN"));
        tvSummaryTotal.setText(formatter.format(total));
    }

    private boolean validateInput() {
        if (etFullName.getText().toString().trim().isEmpty()) {
            etFullName.setError("Vui lòng nhập họ tên");
            return false;
        }
        if (etPhone.getText().toString().trim().isEmpty()) {
            etPhone.setError("Vui lòng nhập số điện thoại");
            return false;
        }
        if (etAddress.getText().toString().trim().isEmpty()) {
            etAddress.setError("Vui lòng nhập địa chỉ");
            return false;
        }
        return true;
    }
}
