package com.example.first;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class currenttime extends AppCompatActivity {
    SwipeRefreshLayout swipeRefreshLayout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currenttime);
        swipeRefreshLayout = findViewById(R.id.rl);
        textView = findViewById(R.id.tv1);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
//                textView.setText("Current Date and Time is:\n" +currentDateTimeString);
                Calendar cal = Calendar.getInstance();
                String time = ""+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
                textView.setText("The Current time is:\n"+time);
                swipeRefreshLayout.setRefreshing(false);
            }
        });




    }
}
