package com.example.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class wvcv extends AppCompatActivity {
    EditText et;
    WebView wv;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wvcv);
        et = findViewById(R.id.edit_text);
        wv = findViewById(R.id.web_view);
        b = findViewById(R.id.button);
        et.setBackgroundResource(R.drawable.edittxt);
        b.setBackgroundResource(R.drawable.edittxt);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url1 = et.getText().toString();
                wv.loadUrl("https://"+url1);
                wv.getSettings().setJavaScriptEnabled(true);
                wv.setWebViewClient(new WebViewClient());
            }
        });

    }
}
