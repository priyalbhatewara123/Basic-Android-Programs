package com.example.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class pop extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        b = findViewById(R.id.buu);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(pop.this, b);
                popupMenu.getMenuInflater().inflate(R.menu.pmenu,popupMenu.getMenu() );
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(pop.this,item.getTitle(),Toast.LENGTH_LONG).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}
