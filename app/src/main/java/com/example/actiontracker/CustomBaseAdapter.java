package com.example.actiontracker;

import android.app.usage.UsageStats;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomBaseAdapter extends BaseAdapter {


    Context context;
    List<UsageStats> usageStats;
    LayoutInflater layoutInflater;

    UsageTracker usageTracker = new UsageTracker();

    public CustomBaseAdapter(Context ctx, List<UsageStats> usageStats) {
        this.context = ctx;
        this.usageStats = usageStats;
        this.layoutInflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return usageStats.size();
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

        TextView text_view_name = (TextView) view.findViewById(R.id.name_text_view);
        TextView text_view_time = (TextView) view.findViewById(R.id.time_text_view);

        text_view_name.setText(usageStats.get(i).getPackageName());
        text_view_time.setText("Last time used: " + usageTracker.getDateTimeFromEpochMillis(usageStats.get(i).getLastTimeUsed()));

        return view;
    }
}
