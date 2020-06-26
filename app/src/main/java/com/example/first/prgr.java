package com.example.first;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class prgr extends AppCompatActivity {
    Button b;
    ProgressDialog progressDialog;
    private Handler progressBarHandler = new Handler();
    private int jt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prgr);
        b = findViewById(R.id.pb);
    }

    public void clk(View view) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Work in progress");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgress(0);
        progressDialog.show();

        final int pt = 100;
        final Thread t = new Thread() {
            @Override
            public void run() {
//                int jt = 0;
                while (jt < pt) {
                    try {
                        sleep(200);
                        jt += 5;
//                        progressDialog.setProgress(jt);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBarHandler.post(new Runnable() {
                        public void run() {
                            progressDialog.setProgress(jt);
                        }
                    });

                }

            }
        };t.start();
    }
}



