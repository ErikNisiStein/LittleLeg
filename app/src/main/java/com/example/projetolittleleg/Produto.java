package com.example.projetolittleleg;

public class Produto {
    public Integer ID;
    public String  PRODUTO;
    public String  DATAPAG;
    public String  DATACOMP;
    public String  COMPRADOR;
    public String VALOR;
    public String STATUS;

    public static final String STATUS_ATIVO = "0";
    public static final String STATUS_ARQUIVADO = "1";

    public Produto(Integer ID, String PRODUTO, String DATAPAG, String DATACOMP, String COMPRADOR, String VALOR, String STATUS) {
        this.ID = ID;
        this.PRODUTO = PRODUTO;
        this.DATAPAG = DATAPAG;
        this.DATACOMP = DATACOMP;
        this.COMPRADOR = COMPRADOR;
        this.VALOR = VALOR;
        this.STATUS = STATUS;
    }

    public Produto(String PRODUTO, String DATAPAG, String DATACOMP, String COMPRADOR, String VALOR, String STATUS) {
        this.PRODUTO = PRODUTO;
        this.DATAPAG = DATAPAG;
        this.DATACOMP = DATACOMP;
        this.COMPRADOR = COMPRADOR;
        this.VALOR = VALOR;
        this.STATUS = STATUS;
    }
}
