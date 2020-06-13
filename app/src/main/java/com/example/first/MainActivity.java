package com.example.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtname , edtpass ;
    Button btnsubmit;


    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtname = findViewById(R.id.edt_name);
        edtpass = findViewById(R.id.edt_pass);
        btnsubmit = findViewById(R.id.btn_submit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtname.getText().toString();
                Toast.makeText(getApplicationContext(),"Welcome "+name,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
