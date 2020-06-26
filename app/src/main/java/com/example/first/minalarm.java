package com.example.first;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class minalarm extends AppCompatActivity {
    Button b;
    EditText t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minalarm);
        b = findViewById(R.id.abt);
        t = findViewById(R.id.aet);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alarm();
            }

        });
    }

    private void alarm() {
        int i = Integer.parseInt(t.getText().toString());
        Intent it = new Intent(this,brdcst.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,234,it,0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),pendingIntent);
        Toast.makeText(this, "Alarm set for "+i+" sec", Toast.LENGTH_SHORT).show();
    }
}
