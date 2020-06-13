package com.example.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class radioooo extends AppCompatActivity {
    RadioGroup r_g;
    RadioButton ma , fe ;
    Button b_u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radioooo);
        r_g = findViewById(R.id.rg);
        ma = findViewById(R.id.male);
        fe = findViewById(R.id.female);
        b_u = findViewById(R.id.bu);

        b_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sid = r_g.getCheckedRadioButtonId();


                Toast.makeText(radioooo.this, " "+sid, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
