package com.documentofiscal.documentofiscal.model;

public class DocumentoFiscal {
    private String dtEmissao;
    private String numeroNota;
    private String nmCliente;
    private String endCliente;
    private String muniUfCliente;
    private String cnpjCliente;
    private String descServicos;
    private String valor;
    private String valorEx;
    private String banco;
    private String pix;

    public String getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(String dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }

    public String getNmCliente() {
        return nmCliente;
    }

    public void setNmCliente(String nmCliente) {
        this.nmCliente = nmCliente;
    }

    public String getEndCliente() {
        return endCliente;
    }

    public void setEndCliente(String endCliente) {
        this.endCliente = endCliente;
    }

    public String getMuniUfCliente() {
        return muniUfCliente;
    }

    public void setMuniUfCliente(String muniUfCliente) {
        this.muniUfCliente = muniUfCliente;
    }

    public String getCnpjCliente() {
        return cnpjCliente;
    }

    public void setCnpjCliente(String cnpjCliente) {
        this.cnpjCliente = cnpjCliente;
    }

    public String getDescServicos() {
        return descServicos;
    }

    public void setDescServicos(String descServicos) {
        this.descServicos = descServicos;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValorEx() {
        return valorEx;
    }

    public void setValorEx(String valorEx) {
        this.valorEx = valorEx;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }

}
