package com.example.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class in2 extends AppCompatActivity {
    TextView t_1;
    Button b_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in2);
        t_1 = findViewById(R.id.t1);
        b_1 = findViewById(R.id.b1);
//        b_1.setOnClickListener(new View.OnClickListener()
//        {
//            public void onClick(View v){
//                Intent i = getIntent();
//                String msg = i.getStringExtra("text");
//                t_1.setText(msg);
//            }
//        });
        Intent i = getIntent();
        String msg = i.getStringExtra("text");
        t_1.setText(msg);
    }
}
