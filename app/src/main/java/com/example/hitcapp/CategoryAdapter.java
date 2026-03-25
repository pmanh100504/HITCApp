package com.example.hitcapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, int layout, List<Category> categoryList) {
        this.context = context;
        this.layout = layout;
        this.categoryList = categoryList;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.tvName = convertView.findViewById(R.id.tvCategoryName);
            holder.imgLogo = convertView.findViewById(R.id.imgCategory);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Category category = categoryList.get(position);
        holder.tvName.setText(category.getName());
        holder.imgLogo.setImageResource(category.getImageResId());

        return convertView;
    }

    private class ViewHolder {
        TextView tvName;
        ImageView imgLogo;
    }
}