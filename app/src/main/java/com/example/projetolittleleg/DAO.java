package com.example.projetolittleleg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAO {
    BD bd;
    String[] columns = {
            BD.ID,
            BD.PRODUTO,
            BD.DATAPAG,
            BD.DATACOMP,
            BD.COMPRADOR,
            BD.VALOR,
            BD.STATUS
    };

    public DAO(Context ctx){
        this.bd= new BD(ctx);
    }

    public Produto criarProduto(Produto prod){
        ContentValues values = new ContentValues();
        SQLiteDatabase db = this.bd.getWritableDatabase();

        values.put(BD.PRODUTO, prod.PRODUTO);
        values.put(BD.DATAPAG, prod.DATAPAG);
        values.put(BD.DATACOMP, prod.DATACOMP);
        values.put(BD.COMPRADOR, prod.COMPRADOR);
        values.put(BD.VALOR, prod.VALOR);
        values.put(BD.STATUS, prod.STATUS);

        long id = db.insert(BD.TABELA, null, values);
        db.close();
        prod.ID = (int)id;

        return prod;
    }

    public void removerProduto(Produto prod){
        SQLiteDatabase db = this.bd.getWritableDatabase();
        db.delete(BD.TABELA, BD.ID + " = " + prod.ID, null);
    }

    public void alterarProduto(Produto prod){ContentValues values = new ContentValues();
        SQLiteDatabase db = this.bd.getWritableDatabase();

        values.put(BD.PRODUTO, prod.PRODUTO);
        values.put(BD.DATAPAG, prod.DATAPAG);
        values.put(BD.DATACOMP, prod.DATACOMP);
        values.put(BD.COMPRADOR, prod.COMPRADOR);
        values.put(BD.VALOR, prod.VALOR);
        values.put(BD.STATUS, prod.STATUS);

        db.update(BD.TABELA, values, BD.ID + " = " + prod.ID, null);
        db.close();
    }

    public ArrayList<Produto> obterListaProdutos(String arq_ou_nao){
        ArrayList<Produto> produtos = new ArrayList<>();
        SQLiteDatabase db = this.bd.getReadableDatabase();
        Cursor cursor = db.query(BD.TABELA, this.columns, BD.STATUS + " = " + arq_ou_nao, null, null, null, null);

        if(cursor != null && cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                Produto prod = new Produto(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
                produtos.add(prod);
            } while(cursor.moveToNext());
            cursor.close();
        }
        return produtos;
    }
}
