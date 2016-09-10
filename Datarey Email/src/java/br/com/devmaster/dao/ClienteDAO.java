/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmaster.dao;

import br.com.devmaster.to.ClienteTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Pamella
 */
public class ClienteDAO {

    public String incluir (ClienteTO to) {
        try{
            Connection con  = new Conexao().getConexao();
            PreparedStatement ps = con.prepareStatement("INSERT INTO cliente (razao,fantasia,abreviatura,CNPJ,CPF,email) values (?,?,?,?,?,?);");
            ps.setString(1, to.getRazao());
            ps.setString(2, to.getFantasia());
            ps.setString(3, to.getAbreviatura());
            ps.setString(4, to.getCNPJ());
            ps.setString(5, to.getCPF());
            ps.setString(6, to.getEmail());
            ps.execute();
            ps.close();
            con.close();
            return "ClienteDAO cadastrado com sucesso!!";
        }catch(ClassNotFoundException | SQLException e){
            return "erro ao cadastrar ClienteDAO!!";
        }
    }
    public String alterar(ClienteTO to){
        try{
            Connection con = new Conexao().getConexao();
            PreparedStatement ps = con.prepareStatement("UPDATE CLIENTE SER razao = ?,fantasia = ?, abreviatura = ?,cnpj=?,cpf=?,email=? WHERE codigo=?;");
            ps.setString(1, to.getRazao());
            ps.setString(2, to.getFantasia());
            ps.setString(3, to.getAbreviatura());
            ps.setString(4, to.getCNPJ());
            ps.setString(5, to.getCPF());
            ps.setString(6, to.getEmail());
            ps.setInt(7, to.getCodigo());
            ps.execute();
            ps.close();
            con.close();
            return "ClienteDAO alterado com sucesso!!";
        }catch(ClassNotFoundException | SQLException e){
            return "erro ao alterar ClienteDAO!!";
        }
    }
    
    public ArrayList<ClienteTO> consultarTodos() throws Exception{
        ArrayList clientes = new ArrayList();
        Connection con = new Conexao().getConexao();
        ResultSet rs;
        PreparedStatement ps = con.prepareStatement("SELECT * FROM cliente ORDER BY razao");
        rs = ps.executeQuery();
        while(rs.next()){
            ClienteTO to = new ClienteTO();
            to.setCodigo(rs.getInt("codigo"));
            to.setRazao(rs.getString("razao"));
            to.setFantasia(rs.getString("fantasia"));
            to.setAbreviatura(rs.getString("abreviatura"));
            to.setCNPJ(rs.getString("cnpj"));
            to.setCPF(rs.getString("cpf"));
            to.setEmail(rs.getString("email"));
            clientes.add(to);
        }
        con.close();
        return clientes;
    }
    
    public ClienteTO consultaID (int id) throws Exception{
        Connection con = new Conexao().getConexao();
        ResultSet rs;
        PreparedStatement ps = con.prepareStatement("SELECT * FROM cliente WHERE codigo=?");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        ClienteTO to = new ClienteTO();
        if(rs.next()){
            to.setCodigo(rs.getInt("codigo"));
            to.setRazao(rs.getString("razao"));
            to.setFantasia(rs.getString("fantasia"));
            to.setAbreviatura(rs.getString("abreviatura"));
            to.setCNPJ(rs.getString("cnpj"));
            to.setCPF(rs.getString("cpf"));
            to.setEmail(rs.getString("email"));
        }
        con.close();
        return to;
    }
    
    public void excluirID(int id)throws Exception{
        Connection con = new Conexao().getConexao();
        PreparedStatement ps = con.prepareStatement("DELETE FROM cliente WHERE codigo=?");
        ps.setInt(1, id);
        ps.execute();
        con.close();
    }
}
