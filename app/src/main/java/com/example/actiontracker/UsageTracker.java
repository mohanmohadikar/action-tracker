package com.example.actiontracker;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class UsageTracker {
    public List<UsageStats> getUsageTracker(Context context) {

        final UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService(Context.USAGE_STATS_SERVICE);


        long endTime = System.currentTimeMillis();
        long startTime = addRemoveDaysInMillis(endTime, -365);


        final List<UsageStats> usageStatsList = usageStatsManager.queryUsageStats(
                UsageStatsManager.INTERVAL_YEARLY,
                startTime,
                endTime
        );

        return usageStatsList;
    }

    public long addRemoveDaysInMillis(long time, long days) {
        return time + (days * 24 * 60 * 60 * 1000);
    }

    public String getDateTimeFromEpochMillis(long millis) {
        Instant instant = Instant.ofEpochMilli(millis);

        ZoneId zoneId = ZoneId.of(TimeZone.getDefault().getID());
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);

        return zdt.format(getZDTFormatter());
    }

    public long convertMillisToSeconds(long time) {
        return (time * 1000);
    }

    public List<UsageStats> getFilteredList(List<UsageStats> usageStatsList) {
        return usageStatsList.stream().filter(usageStat -> usageStat.getLastTimeUsed() > 0)
                .collect(Collectors.toList());
    }

    public List<UsageStats> sortList(List<UsageStats> usageStatsList) {
        Collections.sort(usageStatsList, (a, b) -> Math.toIntExact(b.getLastTimeUsed() - a.getLastTimeUsed()));

        return usageStatsList;
    }

    public DateTimeFormatter getZDTFormatter() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("MMM dd yyyy - HH:mm:ss z");

        return formatter;
    }

}
