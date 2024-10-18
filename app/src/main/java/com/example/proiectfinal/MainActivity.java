package com.example.proiectfinal;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.Intent;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel>slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.poza_slide1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.poza_slide2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.poza_slide3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.poza_slide4, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.acasa) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.despre) {
            Intent intent = new Intent(MainActivity.this, DespreNoi.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.vinuri) {
            Intent intent = new Intent(MainActivity.this, Vinuri.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.contact) {
            Intent intent = new Intent(MainActivity.this, Contact.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.Log) {
            Intent intent = new Intent(MainActivity.this, Log_In.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }
}


