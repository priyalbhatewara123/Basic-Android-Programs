package com.example.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CourtCounter extends AppCompatActivity {
    TextView pointsA , pointsB;
    Button add3A , add2A , freeThrowA , add3B , add2B , freeThrowB;
    int points_teamA = 0;
    int points_teamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_counter);
        pointsA = findViewById(R.id.pointsA);
        pointsB = findViewById(R.id.pointsB);
        add3A = findViewById(R.id.plus3A);
        add2A = findViewById(R.id.plus2A);
        add3B = findViewById(R.id.plus3B);
        add2B = findViewById(R.id.plus2B);
        freeThrowA = findViewById(R.id.freeThrowA);
        freeThrowB = findViewById(R.id.freeThrowB);

    }

    public void add3ForA(View view) {
        points_teamA += 3;
        displayA(points_teamA);
    }

    public void add2ForA(View view) {
        points_teamA += 2;
        displayA(points_teamA);
    }

    public void freeThrowA(View view) {
        points_teamA += 1;
        displayA(points_teamA);
    }

    public void add3ForB(View view) {
        points_teamB += 3;
        displayB(points_teamB);
    }

    public void add2ForB(View view) {
        points_teamB +=2;
        displayB(points_teamB);
    }

    public void freeThrowB(View view) {
        points_teamB += 1;
        displayB(points_teamB);
    }

    public void displayA(int a){
        pointsA.setText(""+a);
    }
    public void displayB(int b){
        pointsB.setText(""+b);
    }

    public void reset(View view) {
        points_teamA = 0;
        points_teamB = 0;
        displayA(points_teamA);
        displayB(points_teamB);
    }
}