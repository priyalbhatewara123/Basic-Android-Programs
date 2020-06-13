package com.example.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gmaiillll extends AppCompatActivity {
    Button bu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmaiillll);
        bu = findViewById(R.id.but);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"priyalbhatewara2000@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "welcome");
                i.setType("message/rfc822");
                startActivity(Intent.createChooser(i,"Choose an Email client"));
            }
        });

    }
}
