package com.mohanmmohadikar.actiontracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.usage.UsageStats;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsageTracker usageTracker = new UsageTracker();

        // fetch list
        List<UsageStats> usageStatsList = usageTracker.getUsageTracker(getApplicationContext());
        // filter out list
        usageStatsList = usageTracker.getFilteredList(usageStatsList);
        // sort list
        usageStatsList = usageTracker.sortList(usageStatsList);


        ListView listView = (ListView) findViewById(R.id.custom_list_view);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(
                getApplicationContext(),
                usageStatsList
        );

        listView.setAdapter(customBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("CUSTOM_LIST_VIEW", "Item is clicked @ position :: " + i);
            }
        });

    }
}