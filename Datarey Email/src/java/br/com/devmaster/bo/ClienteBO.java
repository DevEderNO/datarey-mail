/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmaster.bo;

import br.com.devmaster.dao.ClienteDAO;
import br.com.devmaster.interfaces.IClienteDAO;
import br.com.devmaster.to.ClienteTO;
import java.util.ArrayList;

/**
 *
 * @author Pamella
 */
public class ClienteBO {
    public String incluir(ClienteTO to)throws Exception{
        String ret = consisteDados(to);
        if(ret.equals("")){
            IClienteDAO dao = (IClienteDAO) new ClienteDAO();
            dao.incluir(to);
            return "";
        }else{
            return ret;
        }
    }
    
    public String alterar(ClienteTO to) throws Exception{
        String ret = consisteDados(to);
        if (ret.equals("")){
            IClienteDAO dao = (IClienteDAO) new ClienteDAO();
            dao.alterar(to);
            return "";
        }else{
            return ret;
        }
    }
    
    public ArrayList<ClienteTO> consultaTodos()throws Exception{
        IClienteDAO dao = (IClienteDAO) new ClienteDAO();
        ArrayList clientes = dao.consultarTodos();
        return clientes;
    }
    
    public ClienteTO consultarID(int id)throws Exception{
        IClienteDAO dao = (IClienteDAO) new ClienteDAO();
        ClienteTO to = dao.consultarID(id);
        return to;
    }
    
    public void ecluirID(int id)throws Exception{
        IClienteDAO dao = (IClienteDAO) new ClienteDAO();
        dao.excluirID(id);
    }
    
    private String consisteDados(ClienteTO to){
        if(to.getRazao().equals("")){
            return "Razão Social do cliente não informada";
        }
        if(to.getFantasia().equals("")){
            return "Nome Fantadia do cliente não informada";
        }
        if(to.getAbreviatura().equals("")){
            return "Abreviatura do cliente não informada";
        }
        if(to.getCNPJ().equals("")){
            return "CNPJ do cliente não informado";
        }
        if(to.getCPF().equals("")){
            return "CPF do cliente não informado";
        }
        if(to.getEmail().equals("")){
            return "E-mail do cliente não informado";
        }
        return "";
    }
}
