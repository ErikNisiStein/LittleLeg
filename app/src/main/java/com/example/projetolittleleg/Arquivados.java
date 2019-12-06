package com.example.projetolittleleg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class Arquivados extends AppCompatActivity {

    Adaptador adap;
    ListView listaProdutos;
    ArrayList<Produto> dadosBanco;
    ArrayList<Produto> selecionados;
    DAO dao;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.deletar:
                deletar();
                break;

                default: return false;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_arquivar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        dadosBanco = dao.obterListaProdutos(Produto.STATUS_ARQUIVADO);
        adap.notifyDataSetChanged();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new DAO(getApplicationContext());

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dadosBanco = dao.obterListaProdutos(Produto.STATUS_ARQUIVADO);
        adap = new Adaptador(this, dadosBanco, null, this);

        listaProdutos = findViewById(R.id.listViewMain);
        listaProdutos.setAdapter(adap);

        selecionados = new ArrayList<>();
    }

    public void selecionParaRemocao(Produto prod){
        selecionados.add(prod);
    }

    public void removerSelecao(Produto prod){
        selecionados.remove(prod);
    }

    public void deletar() {
        if (selecionados.size() > 0) {
            for (Produto prod : selecionados) {
                dao.removerProduto(prod);
            }
            selecionados.clear();
            dadosBanco = dao.obterListaProdutos(Produto.STATUS_ARQUIVADO);
            adap.notifyDataSetChanged();
        }
    }
}
