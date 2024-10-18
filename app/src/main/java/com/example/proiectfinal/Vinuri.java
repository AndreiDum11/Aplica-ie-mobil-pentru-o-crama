package com.example.proiectfinal;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Vinuri extends AppCompatActivity {
    private ListView myListView;
    private ArrayAdapter<String> aAdapter;
    private String[] vinuri = {"Marcea Chardonnay", "Marcea Sauvignon Blanc", "Marcea Rose", "L'ATITUDE Alb",
            "Loungeitude Alb", "Loungeitude Rose Magnum"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vinuri);
        myListView = findViewById(R.id.listView);
        aAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, vinuri);
        myListView.setAdapter(aAdapter);

        myListView.setOnItemClickListener((parent, view, position, id) -> {
            listavinuri(position);
        });
    }
    private void listavinuri(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(vinuri[position]);

        builder.setMessage(obtineDetaliiVin(vinuri[position]));

        builder.setIcon(getResources().getIdentifier("vin"+position, "drawable", getPackageName()));

        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private String obtineDetaliiVin(String numeVin) {

        switch (numeVin) {
            case "Marcea Chardonnay":
                return "Chardonnay proaspăt, îmbuteliat in sticla cu închidere cu filet.\n" +
                        "Vin alb sec, cu lejeritate și arome proaspete dar și cu octuozitatea caracteristica soiului.";
            case "Marcea Sauvignon Blanc":
                return "Chardonnay – soi international de mare valoare.\n" +
                        "Vin alb sec, corpolent, onctuos, cu arome intense si complexe.";
            case "Marcea Rose":
                return "Obtinut din Pinot Noir – recoltat din centrul viticol Costesti.Vin rose demisec cu arome de flori si de fructe proaspete de primavara.";
            case "L'ATITUDE Alb":
                return "Vin alb demidulce, cu arome intense de muscat, flori de salcâm, tei, miere, soc și aciditate ridicată pentru echilibrul cu dulcele rezidual";
            case "Loungeitude Alb":
                return "Vin alb sec, cu arome discrete, aciditate și mineralitate pentru prospețime.";
            case "Loungeitude Rose Magnum":
                return "Vin rose demisec, cu ambalaj modern, sticla inscriptionata si dop din sticla. Sticla magnum 1,5 litri. Arome discrete de fructe, corp mediu si aciditate moderata.";
            default:
                return "Acest vin nu are inca o descriere";

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.acasa) {
            Intent intent = new Intent(Vinuri.this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.despre) {
            Intent intent = new Intent(Vinuri.this, DespreNoi.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.vinuri) {
            Intent intent = new Intent(Vinuri.this, Vinuri.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.contact) {
            Intent intent = new Intent(Vinuri.this, Contact.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.Log) {
            Intent intent = new Intent(Vinuri.this, Log_In.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }


}