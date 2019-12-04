package com.example.projetolittleleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;

public class Arquivados extends AppCompatActivity {

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
        adap.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DAO dao = new DAO(getApplicationContext());

        dadosBanco = dao.obterListaProdutos(Produto.STATUS_ARQUIVADO);
        adap = new Adaptador(this, dadosBanco);

        listaProdutos = findViewById(R.id.listViewMain);
        listaProdutos.setAdapter(adap);
    }
}
