package com.example.first;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;

public class spn2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner s;
    String[] color = {
            "Red" , "Orange" , "Blue" , "Green"
    };
    LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spn2);
        s = findViewById(R.id.spn);
        l = findViewById(R.id.li);
        s.setOnItemSelectedListener(this);
        ArrayAdapter a = new ArrayAdapter(this,android.R.layout.simple_list_item_1,color);
        a.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        s.setAdapter(a);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(position)
        {
            case 0:
                l.setBackgroundColor(Color.parseColor("#ff0000"));
                break;
            case 1:
                l.setBackgroundColor(Color.parseColor("#ff3300"));
                break;
            case 2:
                l.setBackgroundColor(Color.parseColor("#0000ff"));
                break;
            case 3:
                l.setBackgroundColor(Color.parseColor("#00cc00"));
                break;


        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
