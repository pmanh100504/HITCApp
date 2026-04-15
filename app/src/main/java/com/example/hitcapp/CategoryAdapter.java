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
<<<<<<< HEAD
    private final Context context;
    private final int layout;
    private final List<Category> categoryList;
=======
    private Context context;
    private int layout;
    private List<Category> categoryList;
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37

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
<<<<<<< HEAD
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layout, parent, false);
            
=======
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
            holder = new ViewHolder();
            holder.tvName = convertView.findViewById(R.id.tvCategoryName);
            holder.imgLogo = convertView.findViewById(R.id.imgCategory);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Category category = categoryList.get(position);
<<<<<<< HEAD
        if (category != null) {
            holder.tvName.setText(category.getName());
            holder.imgLogo.setImageResource(category.getImageResId());
        }
=======
        holder.tvName.setText(category.getName());
        holder.imgLogo.setImageResource(category.getImageResId());
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37

        return convertView;
    }

<<<<<<< HEAD
    private static class ViewHolder {
        TextView tvName;
        ImageView imgLogo;
    }
}
=======
    private class ViewHolder {
        TextView tvName;
        ImageView imgLogo;
    }
}
>>>>>>> ea741600f12e115c19f0f8c47620ed7245337f37
