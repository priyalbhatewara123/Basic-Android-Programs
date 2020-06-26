package com.example.first;

import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class minnibrow extends AppCompatActivity {
    EditText e;
    Button bt;
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minnibrow);
        e = findViewById(R.id.edtxt);
        bt = findViewById(R.id.b);
        wv = findViewById(R.id.web);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url1 = e.getText().toString();
                wv.loadUrl("https://"+url1);
                wv.getSettings().setJavaScriptEnabled(true);
                wv.setWebViewClient(new WebViewClient());

            }
        });
    }
}
