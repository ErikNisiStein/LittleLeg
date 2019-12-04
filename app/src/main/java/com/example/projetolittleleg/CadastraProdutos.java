package com.example.projetolittleleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class CadastraProdutos extends AppCompatActivity {
    Date data = new Date();
    //campo para receber valor do spin(status)
    String status;

    //inicializa variaveis
    EditText dataCompra;
    EditText dataPag;
    EditText comprador;
    EditText valor;
    EditText produtos;

    //inicializa botão
    Button inserir;
    Button limpar;

    BD bd;
    DAO dao;
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_produtos);
        dao = new DAO(this);
        bd = new BD(this);

        //carrega campos
        dataCompra = findViewById(R.id.edt_DatComp);
        dataPag = findViewById(R.id.edt_DatPag);
        comprador = findViewById(R.id.edt_comprador);
        valor = findViewById(R.id.edt_valor);
        produtos = findViewById(R.id.edt_Produto);
        sp = (Spinner) findViewById(R.id.sp_status);

        // carega campo dataCompra com a data do SO
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        String dateString = sdf.format(date);
        dataCompra.setText(dateString);

        // carrega botoes
        inserir = findViewById(R.id.btn_inserir);
        limpar = findViewById(R.id.btn_limpar);

        // carrega spinner
        load_spinner(sp);

        //função botoes
        inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //verifica status p/ inserção
                if (sp.equals("Pendente")) {
                    status = "0";
                } else if (sp.equals("Pago")) {
                    status = "1";
                }
                //objeto Produto com campos
                final Produto prod = new Produto(produtos.getText().toString(), dataPag.getText().toString(), dataCompra.getText().toString(),
                        comprador.getText().toString(), valor.getText().toString(), status);
                dao.criarProduto(prod);
                finish();

            }
        });
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
    }

public void load_spinner(Spinner sp)
{
    String[] arraySpinner = new String[] {
            " Pendente ", " Pago "
    };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, arraySpinner);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    sp.setAdapter(adapter);
}

public void clear (){
        this.comprador.setText("");
        this.dataPag.setText("");
        this.valor.setText("");
        this.produtos.setText("");
        sp.setSelection(0);
    }


}
