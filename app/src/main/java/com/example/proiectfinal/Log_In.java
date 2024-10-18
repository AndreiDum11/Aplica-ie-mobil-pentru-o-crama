package com.example.proiectfinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Log_In extends AppCompatActivity {
    DbHelper myDb;
    EditText verif_name;
    EditText verif_password;
    Button submit_btn,creare_btn;
    String name,password;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        myDb = new DbHelper(this);
        verif_name = (EditText) findViewById(R.id.editText_nume);
        verif_password = (EditText) findViewById(R.id.editText_parola);
        submit_btn = (Button) findViewById(R.id.btn_submit);
        creare_btn = (Button) findViewById(R.id.btn_creare);
        logIn();
        createAccount();
    }
    public void logIn() {
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = verif_name.getText().toString();
                String password = verif_password.getText().toString();
                myDb = new DbHelper(Log_In.this);
                boolean isValidCredentials = myDb.checkUserCredentials(name,password);
                if(isValidCredentials){
                    Intent intent = new Intent(Log_In.this,ReviewPage.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getBaseContext(),"Eroare de conectare",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void createAccount() {
        creare_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Log_In.this,CreareCont.class);
                startActivity(intent);
            }
        });
    }
}