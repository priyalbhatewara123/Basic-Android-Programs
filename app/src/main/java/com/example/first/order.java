package com.example.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class order extends AppCompatActivity {
    CheckBox cb_1 , cb_2 , cb_3 , cb_4 , cb_5;
    Button bt_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        cb_1 = findViewById(R.id.cb1);
        cb_2 = findViewById(R.id.cb2);
        cb_3 = findViewById(R.id.cb3);
        cb_4 = findViewById(R.id.cb4);
        cb_5 = findViewById(R.id.cb5);
        bt_3 = findViewById(R.id.bt3);
        bt_3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                String msg = "Your hobbies are ";
//                StringBuilder or = new StringBuilder();
//                or.append("Items Selected");
                if(cb_1.isChecked()){
//                    or.append(("\nCoffee 80rs"));
                    msg += " Painting";
                }
                if(cb_2.isChecked()){
//                    or.append(("\nTea 40rs"));
                    msg += " Dancing";
                }
                if(cb_3.isChecked()){
//                    or.append(("\nIce Cream 100rs"));
                    msg += " cooking";
                }
                if(cb_4.isChecked()){
//                    or.append(("\nIce Cream 100rs"));
                    msg += " Singing";
                }
                if(cb_5.isChecked()){
//                    or.append(("\nIce Cream 100rs"));
                    msg += " Reading";
                }

//                or.append(("\n total ="+total_amount));
                Toast.makeText(order.this , msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
