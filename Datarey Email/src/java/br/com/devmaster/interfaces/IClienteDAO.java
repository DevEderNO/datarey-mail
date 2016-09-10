/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmaster.interfaces;

import br.com.devmaster.to.ClienteTO;
import java.util.ArrayList;

/**
 *
 * @author Pamella
 */
public interface IClienteDAO {
    public String incluir(ClienteTO to)throws Exception;
    public String alterar(ClienteTO to)throws Exception;
    public void excluirID(int id)throws Exception;
    public ClienteTO consultarID(int id)throws Exception;
    public ArrayList<ClienteTO> consultarTodos()throws Exception;
}
