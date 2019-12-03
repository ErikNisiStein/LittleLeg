package com.example.projetolittleleg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BD extends SQLiteOpenHelper{
    private SQLiteDatabase db;
    static  final  String  NOME_BANCO  =  " littleleg " ;
    static  final  String  TABELA  =  " produtos " ;
    static  final  String  ID  =  " id " ;
    static  final  String  PRODUTO  =  " produto " ;
    static  final  String  DATAPAG  =  " dataPag " ;
    static  final  String  DATACOMP =  " dataComp " ;
    static  final  String  COMPRADOR  =  " comprador " ;
    static  final  String  VALOR = "valor";
    static  final  String STATUS= "status";
    static  final  String QTD= "qtd";

    static  final  int  VERSAO  = 1  ;

    public BD (Context context ) {
            super (context, NOME_BANCO, null, VERSAO);
        }

    public void onCreate(SQLiteDatabase db){
        db.execSQL ( " CREATE TABLE "  +  TABELA  +  " ( "  +
                ID  +  " PRIMARY KEY AUTOINCREMENT, "  +
                PRODUTO  +  " TEXT, "  +
                DATAPAG  +  " TEXT, " +
                DATACOMP + " TEXT, " +
                COMPRADOR + " TEXT, " +
                VALOR + " TEXT, " +
                STATUS + " TEXT, " +
                QTD + " INTEGER " +
                " ) " );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA );
        onCreate(db);
    }
}
