package com.example.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText et_phone , et_text;
    Button btn_cancel , btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et_phone = findViewById(R.id.etPhone);
        et_text = findViewById(R.id.etText);
        btn_cancel = findViewById(R.id.btnCancel);
        btn_send = findViewById(R.id.btnSend);


    }
}
