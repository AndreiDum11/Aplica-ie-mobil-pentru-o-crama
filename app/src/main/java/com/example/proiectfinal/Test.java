package com.example.proiectfinal;
import android.annotation.SuppressLint;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
public class Test extends AppCompatActivity {
    Button btnA,btnB,btnC,btnD;
    TextView textViewIntrebare;
    private IntrebariReview vectorIntrebari = new IntrebariReview();
    static int k = 0;
    private int scor = 0;
    private String rasp;
    private int nrIntrebari = vectorIntrebari.vectIntreb.length;
    private void IntrebareaActuala(int i){
        textViewIntrebare.setText(vectorIntrebari.getIntrebare(i));
        btnA.setText(vectorIntrebari.getRaspA(i));
        btnB.setText(vectorIntrebari.getRaspB(i));
        btnC.setText(vectorIntrebari.getRaspC(i));
        btnD.setText(vectorIntrebari.getRaspD(i));
        rasp = vectorIntrebari.getRaspunsCorect(i);
    }
    private void afiseazaScor(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Scorul obtinut este: " + scor + "/" + nrIntrebari)
                .setPositiveButton("Ok",(dialog,which)->{
                    Intent intent = new Intent(Test.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                })
                .setCancelable(false)
                .create()
                .show();
    }
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vinuri_activty);
        btnA = findViewById(R.id.btnRaspA);
        btnB = findViewById(R.id.btnRaspB);
        btnC = findViewById(R.id.btnRaspC);
        btnD = findViewById(R.id.btnRaspD);
        textViewIntrebare = findViewById(R.id.tvIntrebare);
        k = 0;
        IntrebareaActuala(k);
        btnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(btnA.getText()==rasp){
                    scor++;
                }
                k++;
                if(k>=vectorIntrebari.vectIntreb.length)
                    afiseazaScor();
                else
                    IntrebareaActuala(k);
            }
        });
        btnB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(btnB.getText()==rasp){
                    scor++;
                }
                k++;
                if(k>=vectorIntrebari.vectIntreb.length)
                    afiseazaScor();
                else
                    IntrebareaActuala(k);
            }
        });
        btnC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(btnC.getText()==rasp){
                    scor++;
                }
                k++;
                if(k>=vectorIntrebari.vectIntreb.length)
                    afiseazaScor();
                else
                    IntrebareaActuala(k);
            }
        });
        btnD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(btnD.getText()==rasp){
                    scor++;
                }
                k++;
                if(k>=vectorIntrebari.vectIntreb.length)
                    afiseazaScor();
                else
                    IntrebareaActuala(k);
            }
        });
    }
}
