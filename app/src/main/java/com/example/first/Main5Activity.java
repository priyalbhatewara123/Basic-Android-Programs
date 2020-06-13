package com.example.first;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    private static final int REQUEST_PHONE_CALL = 1;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    EditText et_2, et_3;
    Button bt_4, bt_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        et_2 = findViewById(R.id.et2);
        et_3 = findViewById(R.id.et3);
        bt_4 = findViewById(R.id.bt4);
        bt_5 = findViewById(R.id.bt5);


        bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_2.getText().toString();
                phonecall(name);


            }


        });

        bt_5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkForSmsPermission();

            }
                                }
        );
    }

    private void checkForSmsPermission() {
        if (ActivityCompat.checkSelfPermission(Main5Activity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Main5Activity.this, new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        } else {
            enableSmsButton();
        }
    }

    private void enableSmsButton() {
        try {
            SmsManager smgr = SmsManager.getDefault();
            smgr.sendTextMessage(et_2.getText().toString(), null, et_3.getText().toString(), null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS Failed to Send,Please try again", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    enableSmsButton();

                } else {
                    Toast.makeText(Main5Activity.this, "Sorry", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            case REQUEST_PHONE_CALL:
                {
                    if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        String name = et_2.getText().toString();
                        phonecall(name);

                    }

                    else
                    {
                        Toast.makeText(Main5Activity.this, "Sorry",Toast.LENGTH_SHORT).show();
                    }
                    return;
                }
            }
        }


    private void phonecall(String name) {
        if (ContextCompat.checkSelfPermission(Main5Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Main5Activity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + name));
            startActivity(intent);
        }
    }
}



