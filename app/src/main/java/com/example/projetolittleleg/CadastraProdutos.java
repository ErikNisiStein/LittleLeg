package com.example.projetolittleleg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
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

    Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_produtos);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                if (sp.getSelectedItem().equals(" Pendente ")) {
                    status = Produto.STATUS_ATIVO;
                } else if (sp.getSelectedItem().equals(" Pago ")) {
                    status = Produto.STATUS_ARQUIVADO;
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

        dataCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CadastraProdutos.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, month);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        dataCompra.setText(dayOfMonth + "/" + month + "/" + year);
                    }
                }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        dataPag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CadastraProdutos.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, month);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        dataPag.setText(dayOfMonth + "/" + month + "/" + year);
                    }
                }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
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
