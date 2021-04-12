/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author Alexandre
 */
public class UsuarioDAO {
    
    private Connection con = null;
    
    public  UsuarioDAO(){
        con = ConnectionFactory.getConnection();
    }
    
  
    public boolean createLogin(Usuario user){
        String sql = "INSERT INTO usuario(login,senha)VALUES(?,?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,user.getLogin());
            stmt.setString(2, user.getSenha());
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar ! "+ ex);
             return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public boolean checkLogin(String login, String senha){
        
        String sql = "SELECT * FROM usuario WHERE login = ? and senha = ?";
        PreparedStatement stmt = null;
        ResultSet rs =null;
        boolean check = false;    
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                check = true;
            }
            
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao buscar ! "+ ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return check;
    }
    
}
