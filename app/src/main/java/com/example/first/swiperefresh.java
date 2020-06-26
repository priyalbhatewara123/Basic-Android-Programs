package com.example.first;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class swiperefresh extends AppCompatActivity {
    private SwipeRefreshLayout refreshlayout;
    private ListView listView;
    private TextView textView;
    private List list;
    private int refresh_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiperefresh);
        refreshlayout = findViewById(R.id.swipe_refresh);
        listView = findViewById(R.id.list_view);
        textView = findViewById(R.id.txt_view);
        textView.setText("Swipe to refresh");
        refreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItems();
            }
        });

    }

    private void refreshItems() {
        switch (refresh_count){
            case 0:
                list = Arrays.asList(getResources().getStringArray(R.array.Hobbies));
                textView.setText("List of Hobbies");
                break;
            case 1:
                list = Arrays.asList(getResources().getStringArray(R.array.Fruits));
                textView.setText("List of Fruits");
                break;
            case 2:
                list = Arrays.asList(getResources().getStringArray(R.array.Vegetables));
                textView.setText("List of Vegetables");
                break;
        }
        refresh_count++;
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1,list);
        listView.setAdapter(adapter);
        if (refresh_count>2){
            refresh_count = 0;
        }
        refreshlayout.setRefreshing(false);
    }
}
