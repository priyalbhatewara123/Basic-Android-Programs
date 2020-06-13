package com.example.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class whtsapp extends AppCompatActivity {
    Button bu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whtsapp);
        bu = findViewById(R.id.butt);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(i.EXTRA_TEXT,"Hello");
                i.setType("text/plain");
                startActivity(Intent.createChooser(i,"Choose App"));
            }
        });
    }
}
