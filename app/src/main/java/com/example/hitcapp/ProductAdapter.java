package com.example.hitcapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
<<<<<<< HEAD
import android.widget.Toast;
=======
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;
    private List<Product> productListFull; // Danh sách gốc để lọc

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
        this.productListFull = new ArrayList<>(productList);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.tvProductName.setText(product.getName());
        holder.tvProductPrice.setText("$" + product.getPrice());
        holder.imgProduct.setImageResource(product.getImageResource());

<<<<<<< HEAD
        // Xử lý khi click vào item để xem chi tiết
=======
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ProductDetailActivity.class);
            intent.putExtra("product_name", product.getName());
            intent.putExtra("product_price", product.getPrice());
            intent.putExtra("product_image", product.getImageResource());
            v.getContext().startActivity(intent);
        });
<<<<<<< HEAD

        // Xử lý khi click vào nút "Add to Cart"
        holder.btnAddToCart.setOnClickListener(v -> {
            CartManager.getInstance().addProduct(product);
            Toast.makeText(v.getContext(), "Đã thêm " + product.getName() + " vào giỏ hàng", Toast.LENGTH_SHORT).show();
        });
=======
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    // Hàm lọc sản phẩm
    public void filter(String text) {
        productList.clear();
        if (text.isEmpty()) {
            productList.addAll(productListFull);
        } else {
            text = text.toLowerCase();
            for (Product item : productListFull) {
                if (item.getName().toLowerCase().contains(text)) {
                    productList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView tvProductName, tvProductPrice;
<<<<<<< HEAD
        View btnAddToCart;
=======
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
<<<<<<< HEAD
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
        }
    }
}
=======
        }
    }
}
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
