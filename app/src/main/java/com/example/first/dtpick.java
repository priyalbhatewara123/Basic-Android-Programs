package com.example.first;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class dtpick extends AppCompatActivity implements View.OnClickListener{
    EditText et;
    Button bu;
    private int ye,m,dt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dtpick);
        et = findViewById(R.id.e);
        bu = findViewById(R.id.b);
        bu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Calendar c = Calendar.getInstance();
        ye=c.get(Calendar.YEAR);
        m = c.get(Calendar.MONTH);
        dt=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                et.setText(ye+"-"+m+"-"+dt);
            }
        },ye,m,dt);

        datePickerDialog.show();

    }
}
