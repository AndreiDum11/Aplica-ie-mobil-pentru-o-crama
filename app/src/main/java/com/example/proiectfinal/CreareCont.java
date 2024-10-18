package com.example.proiectfinal;

import android.annotation.SuppressLint;
import android.widget.CheckBox;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CreareCont extends AppCompatActivity {
    DbHelper myDb;
    Button submit;
    Button show;
    EditText nume;
    EditText parola1;
    EditText parola2;
    CheckBox varsta;

    String NumeUser,ParolaUser1,ParolaUser2;
    String VarstaUser;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creare_cont);
        nume = (EditText) findViewById(R.id.cont_nume);
        parola1 = (EditText) findViewById(R.id.cont_parola);
        parola2 = (EditText) findViewById(R.id.cont_parola2);
        varsta = (CheckBox) findViewById(R.id.checkBox_varsta);
        myDb = new DbHelper(this);
        submit = (Button) findViewById(R.id.btn_salveaza);
        //show = (Button) findViewById(R.id.btn_show);
        addData();
        //verif();
    }
    public void addData() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumeUser = nume.getText().toString().trim();
                ParolaUser1 = parola1.getText().toString().trim();
                ParolaUser2 = parola2.getText().toString().trim();

                if (ParolaUser1.equals(ParolaUser2) && varsta.isChecked()) {
                    myDb.insertData(NumeUser, ParolaUser1, VarstaUser);
                    Toast.makeText(getBaseContext(), "Cont realizat cu succes", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CreareCont.this,Log_In.class);
                    startActivity(intent);
                }else
                    Toast.makeText(getBaseContext(), "Introduceti aceeasi parola in ambele campuri", Toast.LENGTH_SHORT).show();
            }
        });
    }
        public void verif(){
           show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor myCursor = myDb.getAllData();
                StringBuffer buffer = new StringBuffer();
                if(myCursor.getCount() == 0){
                    showMessage("Err...","Nothing found.");
                    return;
            }
                while(myCursor.moveToNext())
                {
                    buffer.append("Nume :" +myCursor.getString(1)+ "\n"+
                            "Parola :" +myCursor.getString(2)+ "\n"+
                            "Varsta :" + myCursor.getString(3)+ "\n" +"\n");
                }
                showMessage("Data",buffer.toString());
            }
        });
        }
        public void showMessage(String title, String message)
        {
            AlertDialog.Builder builder = new

                    AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.show();
        }


    }
