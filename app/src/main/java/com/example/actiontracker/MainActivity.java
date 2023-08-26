package com.example.actiontracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    String[] fruitList = {"Apple", "Banana", "Apricot", "Avacado", "Orange", "Water Melon"};
    int[] imageList = {R.drawable.apple, R.drawable.apple, R.drawable.apple, R.drawable.apple, R.drawable.apple, R.drawable.apple};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.custom_list_view);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(
                getApplicationContext(),
                fruitList,
                imageList
        );

        listView.setAdapter(customBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("CUSTOM_LIST_VIEW", "Item is clicked @ position :: "+ i);
            }
        });

    }
}