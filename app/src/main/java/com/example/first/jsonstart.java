package com.example.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class jsonstart extends AppCompatActivity {
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonstart);
        t = findViewById(R.id.tv);

        String jstr = "{\"Student\":[{\"id\":\"1\",\"name\":\"Aman Saini\"},{\"id\":\"2\",\"name\":\"Vikram\"}]}";
        String jdata ="";
        try {
            JSONObject jsonObject=new JSONObject(jstr);
            JSONArray jsonArray=jsonObject.optJSONArray("Student");

            for (int z=0;z<jsonArray.length();z++)
            {
                JSONObject jsonObject1=jsonArray.optJSONObject(z);
                int id=Integer.parseInt(jsonObject1.optString("id").toString());
                String name=jsonObject1.optString("name").toString();
                jdata+="record"+z+":\n id="+id+"\n name="+name+"\n";
                t.setText(jdata);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
