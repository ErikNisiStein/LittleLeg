package com.example.projetolittleleg;

public class Produto {
    public Integer ID;
    public String  PRODUTO;
    public String  DATAPAG;
    public String  DATACOMP;
    public String  COMPRADOR;
    public float VALOR;
    public String STATUS;
    public int QTD;

    public Produto(Integer ID, String PRODUTO, String DATAPAG, String DATACOMP, String COMPRADOR, float VALOR, String STATUS, int QTD) {
        this.ID = ID;
        this.PRODUTO = PRODUTO;
        this.DATAPAG = DATAPAG;
        this.DATACOMP = DATACOMP;
        this.COMPRADOR = COMPRADOR;
        this.VALOR = VALOR;
        this.STATUS = STATUS;
        this.QTD = QTD;
    }

    public Produto(String PRODUTO, String DATAPAG, String DATACOMP, String COMPRADOR, float VALOR, String STATUS, int QTD) {
        this.PRODUTO = PRODUTO;
        this.DATAPAG = DATAPAG;
        this.DATACOMP = DATACOMP;
        this.COMPRADOR = COMPRADOR;
        this.VALOR = VALOR;
        this.STATUS = STATUS;
        this.QTD = QTD;
    }
}
