/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmaster.to;

/**
 *
 * @author Suporte04
 */
public class ClienteTO {
    private int codigo;
    private String razao;
    private String fantasia;
    private String abreviatura;
    private String CNPJ;
    private String CPF;
    private String email;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String Abreviatura) {
        this.abreviatura = Abreviatura;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ClienteTO{" + "codigo=" + codigo + ","
                + " razao=" + razao + ", "
                + "fantasia=" + fantasia + ", "
                + "Abreviatura=" + abreviatura + ", "
                + "CNPJ=" + CNPJ + ", "
                + "CPF=" + CPF + ", "
                + "email=" + email + '}';
    }

    public ClienteTO() {
    }

    public ClienteTO(int codigo, String razao, String fantasia, String Abreviatura, String CNPJ, String CPF, String email) {
        this.codigo = codigo;
        this.razao = razao;
        this.fantasia = fantasia;
        this.abreviatura = Abreviatura;
        this.CNPJ = CNPJ;
        this.CPF = CPF;
        this.email = email;
    }
    
    
}
