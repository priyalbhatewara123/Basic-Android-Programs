package com.example.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class in1 extends AppCompatActivity {
    EditText et_1;
    Button bt_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in1);
        et_1 = findViewById(R.id.et1);
        bt_1 = findViewById(R.id.bt1);
        bt_1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                String a = et_1.getText().toString();
                Intent i = new Intent(in1.this , in2.class);
                i.putExtra("text",a); //key value pairs
                startActivity(i);

            }
        });
    }
}
