package com.example.projetolittleleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

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

        edt_Compra= findViewById(R.id.edt_Compra);

        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        String dateString = sdf.format(date);
        edt_Compra.setText(dateString);

    }
}
