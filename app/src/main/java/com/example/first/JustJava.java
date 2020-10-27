package com.example.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class JustJava extends AppCompatActivity {
    TextView quantity_textView , price_textView , placeOrder;
    Button inc , dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_java);
        quantity_textView = findViewById(R.id.quantity_text_view);
        price_textView = findViewById(R.id.price_text_view);
        inc = findViewById(R.id.inc_button);
        dec = findViewById(R.id.dec_button);
        placeOrder = findViewById(R.id.placeOrder);
    }

    //global variable
    int noOfCoffees = 0;
    public void submitOrder(View view) {
        placeOrder.setText("Thank You!");
    }

    public void displayPrice(int number){
        price_textView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {
        noOfCoffees = noOfCoffees+1;
        quantity_textView.setText("" + noOfCoffees);
        displayPrice(noOfCoffees*5);
    }

    public void decrement(View view) {
        noOfCoffees = noOfCoffees-1;
        quantity_textView.setText("" + noOfCoffees);
        displayPrice(noOfCoffees*5);
    }
}