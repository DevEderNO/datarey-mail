/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmaster.controller;

import br.com.devmaster.bo.ClienteBO;
import br.com.devmaster.to.ClienteTO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Pamella
 */
@ManagedBean
@SessionScoped
public class CtrlCliente implements Serializable{
    private ClienteTO to;
    private List<ClienteTO> clientes;
    private int operacao;
    private String labelBotao;

    
    public CtrlCliente(){
        to = new ClienteTO();
        setLabelBotao("Incluir");
        operacao =1;
    }
    
    public void incluir(){
        String ret = "";
        try{
            ClienteBO bo = new ClienteBO();
            ret = bo.incluir(to);
            limpaTela();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente incluído com sucesso!","Atenção"));
        }catch(Exception e ){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Atenção"));
        }
    }
    
    public void alterar(){
        String ret = "";
        try{
            ClienteBO bo = new ClienteBO();
            ret = bo.alterar(to);
        }catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), "Atenção"));
        }
    }
    
    public String consultarTodos(){
        ClienteBO bo = new ClienteBO();
        try{
            clientes = bo.consultaTodos();
        }catch(Exception ex){
        }
        return "consulta";
    }
    
    public String excluir(){
        ClienteBO bo = new ClienteBO();
        try{
            bo.ecluirID(to.getCodigo());
            clientes = bo.consultaTodos();
            limpaTela();
        }catch(Exception ex){
        }
        return"consulta";
    }
    
    public String index(){
        return "/index";
    }
    
    public String editar(){
        operacao = 2;
        setLabelBotao("Editar");
        return "index";
    }
    
    public String voltar(){
        limpaTela();
        return "index";
    }
    
    public String manter(){
        if (operacao==1){
            incluir();
            return "index";
        }else{
            alterar();
            return "consulta";
        }
    }
    
    private void limpaTela(){
        to = null;
        to = new ClienteTO();
        setLabelBotao("Incluir");
        operacao=1;
    }
    
    public ClienteTO getTo() {
        return to;
    }

    public void setTo(ClienteTO to) {
        this.to = to;
    }

    public List<ClienteTO> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteTO> clientes) {
        this.clientes = clientes;
    }

    public int getOpperacao() {
        return operacao;
    }

    public void setOpperacao(int opperacao) {
        this.operacao = opperacao;
    }

    public String getLabelBotao() {
        return labelBotao;
    }

    public void setLabelBotao(String labelBotao) {
        this.labelBotao = labelBotao;
    }
    
    
}
