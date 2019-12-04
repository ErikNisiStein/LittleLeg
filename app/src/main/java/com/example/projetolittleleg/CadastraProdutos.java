package com.example.projetolittleleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class CadastraProdutos extends AppCompatActivity {
    Date data = new Date();
    EditText edt_Compra;

    BD bd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_produtos);

        bd = new BD(this);

        // carega campo dataCompra com a data do SO
        edt_Compra= findViewById(R.id.edt_Compra);

        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        String dateString = sdf.format(date);
        edt_Compra.setText(dateString);
        // carrega spinner
        String[] arraySpinner = new String[] {
                " Pendente ", " Pago "
        };
        Spinner sp = (Spinner) findViewById(R.id.sp_status);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
    }

}
