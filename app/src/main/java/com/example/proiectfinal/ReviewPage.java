package com.example.proiectfinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ReviewPage extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_page);

        GridView gv = (GridView) findViewById(R.id.gridView);
        gv.setAdapter(new com.example.proiectfinal.ImageAdapter(this));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {

                Intent i = new Intent(getApplicationContext(),
                        com.example.proiectfinal.Test.class);
                startActivity(i);
            }
        });
    }
}