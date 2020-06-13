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
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ssmmss extends AppCompatActivity {
    EditText t_o, mes;
    Button se;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssmmss);
        t_o = findViewById(R.id.to);
        mes = findViewById(R.id.message);
        se = findViewById(R.id.send);
        se.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkForSmsPermission();
//                try {
//                    Intent i = new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse("smsto:"));
//                    i.setType("vnd.android-dir/mms-sms");
//                    i.putExtra("address", new String(t_o.getText().toString()));
//                    i.putExtra("sms_body", mes.getText().toString());
//                    //startActivity(Intent.createChooser(i, "Send sms via:"));
//                    startActivity(i);
//                } catch (Exception e) {
//                    Toast.makeText(ssmmss.this, "SMS failed to send , please try again.", Toast.LENGTH_SHORT).show();
//                }
            }
        }
        );
    }


    private void checkForSmsPermission() {
        if (ActivityCompat.checkSelfPermission(ssmmss.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ssmmss.this, new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        } else {
            enableSmsButton();
        }
    }

    private void enableSmsButton() {
        try {
            SmsManager smgr = SmsManager.getDefault();
            smgr.sendTextMessage(t_o.getText().toString(), null, mes.getText().toString(), null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS Failed to Send,Please try again", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (permissions[0].equalsIgnoreCase(Manifest.permission.SEND_SMS) && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    enableSmsButton();

                } else {
                    Toast.makeText(ssmmss.this, "Sorry", Toast.LENGTH_SHORT).show();
                }
            }
        }
   }
}





