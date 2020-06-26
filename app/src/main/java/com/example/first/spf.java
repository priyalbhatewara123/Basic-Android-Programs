package com.example.first;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class spf extends AppCompatActivity {
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spf);
        e1 = findViewById(R.id.ed1);
        e2 = findViewById(R.id.ed2);


    }
    protected void onResume()
    {
        super.onResume();
        SharedPreferences s = getSharedPreferences("SF",0);
        String s1 = s.getString("name"," ");
        int a = s.getInt("password",0);
        e1.setText(s1);
        e2.setText(String.valueOf(a));
    }


    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences s = getSharedPreferences("SF",0);
        SharedPreferences.Editor me = s.edit();
        int x = Integer.parseInt(e2.getText().toString());
        me.putString("name",e1.getText().toString());
        me.putInt("password",x);
//        me.putString("password", String.valueOf(Integer.parseInt(e2.getText().toString())));
        me.commit();

    }
}
