package com.example.projetolittleleg;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<DAO>
{
    Context ctx;
    ArrayList<Produto> produtos;

    public Adaptador (Context ctx, ArrayList<Produto> produtos)
    {
        super(ctx, R.layout.modelo);
        this.produtos = produtos;
    }

    @Override
    public int getCount() {
        return super.getCount();
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

        return view;
    }
}
