package com.example.first;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class sv extends AppCompatActivity {
    ListView lvv;
    ArrayList<String> mylist;
    ArrayAdapter<String> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv);
        lvv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        mylist.add("apple");
        mylist.add("mango");
        mylist.add("avacado");
        mylist.add("apricot");

        ad = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mylist);
        lvv.setAdapter(ad);//adapter is set on listview


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.svmenu,menu);
        MenuItem searchviewItem=menu.findItem(R.id.search_bar);
        SearchView searchView= (SearchView)MenuItemCompat.getActionView(searchviewItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(mylist.contains(query)){
                    ad.getFilter().filter(query);
                }
                else {
                    Toast.makeText(sv.this, "No such thing found", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ad.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
