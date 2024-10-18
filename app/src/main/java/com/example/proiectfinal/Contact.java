package com.example.proiectfinal;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class Contact extends AppCompatActivity {
    private EditText Nume;
    private EditText Email;
    private EditText Subiect;
    private EditText Mesaj;
    Button Sendbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Nume = (EditText) findViewById(R.id.edit_nume);
        Email = (EditText) findViewById(R.id.edit_email);
        Subiect = (EditText) findViewById(R.id.edit_subiect);
        Mesaj = (EditText) findViewById(R.id.edit_mesaj);
        Sendbtn = (Button) findViewById(R.id.btn_send);

        Sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{"andrei.dumitrascu06@gmail.com"});
                it.putExtra(Intent.EXTRA_SUBJECT, Nume.getText().toString() + "\n" + Subiect.getText().toString());
                it.putExtra(Intent.EXTRA_TEXT, Mesaj.getText().toString());
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it, "Choose Mail App"));
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
            Intent intent = new Intent(Contact.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.despre) {
            Intent intent = new Intent(Contact.this, DespreNoi.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.vinuri) {
            Intent intent = new Intent(Contact.this, Vinuri.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.contact) {
            Intent intent = new Intent(Contact.this, Contact.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.Log) {
            Intent intent = new Intent(Contact.this, Log_In.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }


    }

}