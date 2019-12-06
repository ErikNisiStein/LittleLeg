package com.example.projetolittleleg;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<DAO>
{
    Context ctx;
    ArrayList<Produto> produtos;
    MainActivity activity;
    Arquivados arq;

    public Adaptador (Context ctx, ArrayList<Produto> produtos, MainActivity activity, Arquivados arq)
    {
        super(ctx, R.layout.modelo);
        this.ctx = ctx;
        this.activity = activity;
        this.produtos = produtos;
        this.arq = arq;
    }

    @Override
    public int getCount() {
        return this.produtos.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.modelo, null, true);
        final Produto produto = this.produtos.get(position);
        TextView desc = view.findViewById(R.id.descricao);
        TextView comprador = view.findViewById(R.id.comprador);
        TextView valor = view.findViewById(R.id.valor);
        TextView dEntrada = view.findViewById(R.id.dEntrada);
        TextView dSaida = view.findViewById(R.id.dSaida);
        TextView status = view.findViewById(R.id.status);
        comprador.setText(produto.COMPRADOR);
        desc.setText(produto.PRODUTO);
        valor.setText(produto.VALOR);
        dEntrada.setText(produto.DATACOMP);
        dSaida.setText(produto.DATAPAG);
        status.setText(produto.STATUS);
        CheckBox controle = view.findViewById(R.id.controle);

            controle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        if(activity != null) activity.addItemToSelection(produto);
                        if(arq != null) arq.selecionParaRemocao(produto);
                    } else {
                        if(activity != null) activity.removeItemToSelection(produto);
                        if(arq != null) arq.removerSelecao(produto);
                    }
                }
            });

        return view;
    }
}
