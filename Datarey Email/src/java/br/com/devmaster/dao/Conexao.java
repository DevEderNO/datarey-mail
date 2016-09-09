/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devmaster.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Suporte04
 */
public class Conexao {
    public Connection getConexao() throws ClassNotFoundException, SQLException{
        Connection con = null;
        try{
            String driver = "org.postgresql.Driver";
            String servidor = "localhost:5432";
            String conexao = "jdbc:postgresql";
            String bdNome = "datareymail";
            String usuario = "admin";
            String senha = "admin";
            Class.forName(driver);
            con = DriverManager.getConnection(conexao + "://"+servidor+"/"+bdNome,usuario,senha);
        }catch(Exception e){
            System.out.println("erro ao conectar no banco de dados");
        }
        return con;
    }
    
}
