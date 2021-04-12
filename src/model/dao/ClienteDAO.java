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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;

/**
 *
 * @author Alexandre
 */
public class ClienteDAO {
    
    private Connection con = null;
    
    public ClienteDAO(){
        con = ConnectionFactory.getConnection();
    }
    
   
    public boolean create(Cliente c){
        String sql = "INSERT INTO cliente(nome,email)VALUES(?,?)";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,c.getNome());
            stmt.setString(2, c.getEmail());
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar ! "+ ex);
             return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List<Cliente> read(){
        
        String sql = "SELECT * FROM cliente";
        PreparedStatement stmt = null;
        ResultSet rs =null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
            
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao buscar ! "+ ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientes;
    }
    
    
    public boolean update(Cliente c){
        
        String sql = "UPDATE cliente SET nome = ?, email = ? WHERE id = ?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setInt(3, c.getId());
            
            stmt.executeUpdate();
            return true;
            
            
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao atualizar ! "+ ex);
             return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
     public boolean delete(Cliente c){
        
        String sql = "DELETE FROM cliente WHERE id = ?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, c.getId());
            
            stmt.executeUpdate();
            return true;
            
        
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao excluir ! "+ ex);
             return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     
     
     public boolean drop(Cliente c){
        
        String sql = "TRUNCATE TABLE cliente";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao deletar a tabela ! "+ ex);
             return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
     
     
      public List<Cliente> readForDesc(String desc){
        
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        PreparedStatement stmt = null;
        ResultSet rs =null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
            
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao buscar ! "+ ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientes;
    }
    
}
