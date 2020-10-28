package com.example.first;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class JustJava extends AppCompatActivity {
    TextView quantity_textView , price_textView ;
    Button inc , dec;
    CheckBox whippedCream , chocolate;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_java);
        quantity_textView = findViewById(R.id.quantity_text_view);  //casting is not required now
        price_textView = findViewById(R.id.price_text_view);
        inc = findViewById(R.id.inc_button);
        dec = findViewById(R.id.dec_button);
        whippedCream = findViewById(R.id.whippedCream);
        chocolate = findViewById(R.id.chocolate);
        name = findViewById(R.id.name_field);
    }

    //global variable
    int noOfCoffees = 0;
    public void submitOrder(View view) {
        int totalPrice = calculatePrice();
        String priceMessage = "Name: " + name.getText().toString();
        priceMessage += "\nQuantity: " + noOfCoffees;
        boolean checkedState = whippedCream.isChecked();
        priceMessage += "\nAdd whipped cream? " + checkedState;
        boolean hasChocolate = chocolate.isChecked();
        priceMessage += "\nAdd chocolate? " + hasChocolate;
        priceMessage +=  "\nTotal: " + NumberFormat.getCurrencyInstance().format(totalPrice);
        priceMessage += "\n\nThank You!";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));    //only email apps should handle this intent
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava order of "+ name.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT , priceMessage);
        intent.setType("message/rfc822");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void displayPrice(int number){
        price_textView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {
        noOfCoffees = noOfCoffees+1;
        quantity_textView.setText("" + noOfCoffees);
        int price = calculatePrice();
        displayPrice(price);
    }

    public void decrement(View view) {
        if(noOfCoffees > 0){
            noOfCoffees = noOfCoffees-1;
            quantity_textView.setText("" + noOfCoffees);
            int price = calculatePrice();
            displayPrice(price);
        }
    }

    private int calculatePrice(){
        int price = noOfCoffees*5;
        if(whippedCream.isChecked())
            price += noOfCoffees*1;
        if(chocolate.isChecked())
            price += noOfCoffees*2;

        return price;
    }
}