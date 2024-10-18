package com.example.proiectfinal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public ImageAdapter(Context c) {
        mContext = c;
    }
    public int getCount() {
        return ImagineMica.length;
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }
    // crearea unui nou ImageView pentru fiecare item la care face referire Adaptorul
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(15, 8, 8, 10);
        imageView.setImageResource(ImagineMica[position]);
        return imageView;

    }
    // adaugarea imaginilor in arraylist
    public Integer[] ImagineMica = {
            R.drawable.vin0, R.drawable.vin1,
            R.drawable.vin2, R.drawable.vin3,
            R.drawable.vin4,R.drawable.vin5

    };
}
