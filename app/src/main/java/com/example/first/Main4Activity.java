package com.example.first;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    EditText e_t;
    Button b_t;
    RadioButton rd_1 , rd_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        e_t = findViewById(R.id.et);
        b_t = findViewById(R.id.bt);
        rd_1 = findViewById(R.id.rd1);
        rd_2 = findViewById(R.id.rd2);

        b_t.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v){
//                String url = e_t.getText().toString();
//                Intent in = new Intent(Intent.ACTION_VIEW);
//                in.setData(Uri.parse("https://"+url));
//                startActivity(in);
                Boolean cbs = rd_1.isChecked();
                Boolean cb = rd_2.isChecked();
                String a = cbs.toString();
                String b = cb.toString();
                Toast.makeText(Main4Activity.this , "one :"+a+"+two:"+b,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
