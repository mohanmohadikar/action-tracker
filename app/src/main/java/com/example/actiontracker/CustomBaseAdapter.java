package com.example.actiontracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {


    Context context;
    String[] listFruit;
    int[] listImage;
    LayoutInflater layoutInflater;

    public CustomBaseAdapter(Context ctx, String[] fruitList, int[] imageList) {
        this.context = ctx;
        this.listFruit = fruitList;
        this.listImage = imageList;
        this.layoutInflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listFruit.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.activity_custom_list_view, null);

        TextView textView = (TextView) view.findViewById(R.id.text_view);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_icon);

        textView.setText(listFruit[i]);
        imageView.setImageResource(listImage[i]);

        return view;
    }
}
