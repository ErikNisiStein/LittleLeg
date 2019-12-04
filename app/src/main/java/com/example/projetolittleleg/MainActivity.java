package com.example.projetolittleleg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    DAO dao;
    Adaptador adap;
    ListView listaProdutos;
    ArrayList<Produto> dadosBanco;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        dadosBanco = dao.obterListaProdutos(Produto.STATUS_ATIVO);
        adap.produtos = dadosBanco;
        adap.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao = new DAO(getApplicationContext());

        //dadosBanco = dao.obterListaProdutos(Produto.STATUS_ATIVO);
        adap = new Adaptador(this, dadosBanco);

        listaProdutos = findViewById(R.id.listViewMain);
        listaProdutos.setAdapter(adap);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId()==R.id.add)
        {
            Intent intent = new Intent(this,CadastraProdutos.class);
            startActivity(intent);
        }
        else if (item.getItemId()==R.id.arquivados)
        {
            Intent intent = new Intent(this, Arquivados.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.arquivar)
        {
            Intent intent = new Intent();
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
