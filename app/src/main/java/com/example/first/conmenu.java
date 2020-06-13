package com.example.first;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class conmenu extends AppCompatActivity {
    ListView l_v;
    String contacts[] = {"Priyal", "Rewangi", "Khushi", "Aditi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conmenu);
        l_v = findViewById(R.id.lv);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1,android.R.id.text1,contacts);
        l_v.setAdapter(adapter);

        registerForContextMenu(l_v);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.conmenu, menu);
        menu.setHeaderIcon(R.drawable.ic_call_black_24dp);
        menu.setHeaderTitle("contact via");

    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.call)
        {
            Toast.makeText(this, "CALL", Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.sms)
        {
            Toast.makeText(this, "SMS", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "nothing", Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);

    }



}
