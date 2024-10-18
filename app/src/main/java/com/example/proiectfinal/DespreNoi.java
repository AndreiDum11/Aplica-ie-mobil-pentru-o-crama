package com.example.proiectfinal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
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

public class DespreNoi extends AppCompatActivity {
    ImageView imageView;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despre_noi);
        WebView webView = findViewById(R.id.webView);
        String videoId = "GrL_HV_-dxI"; // ID-ul videoclipului

        String videoUrl = "https://www.youtube.com/embed/" + videoId;
        String html = "<html><body><iframe width=\"100%\" height=\"100%\" src=\"" + videoUrl + "\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(html, "text/html", "utf-8");
        imageView = findViewById(R.id.imageView2);
        String imageUrl = "https://yurta.ro/wp-content/uploads/2020/03/szolos-poszt.jpg";
        Picasso.get().load(imageUrl).into(imageView);

        btn = (Button)findViewById(R.id.btn_cauta);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage("https://marcea.ro/");
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.acasa) {
            Intent intent = new Intent(DespreNoi.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.despre) {
            Intent intent = new Intent(DespreNoi.this, DespreNoi.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.vinuri) {
            Intent intent = new Intent(DespreNoi.this, Vinuri.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.contact) {
            Intent intent = new Intent(DespreNoi.this, Contact.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.Log) {
            Intent intent = new Intent(DespreNoi.this, Log_In.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }
    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}