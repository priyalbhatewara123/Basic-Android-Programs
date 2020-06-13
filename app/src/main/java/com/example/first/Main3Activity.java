package com.example.first;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    Button bt_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bt_2 = findViewById(R.id.bt2);
        bt_2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                Intent in = new Intent(Intent.ACTION_VIEW);
                in.setData(Uri.parse("https://www.google.com/"));
                startActivity(in);

            }
        });

    }
}
