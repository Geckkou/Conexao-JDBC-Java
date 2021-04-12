/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Endereco;

/**
 *
 * @author Alexandre
 */
public class EnderecoDAO {
    
    private Connection con = null;
    
    EnderecoDAO(){
        con = ConnectionFactory.getConnection();
    }
    
    
    public boolean create(Endereco e){
        
        String sql = "INSERT INTO endereco(logadouro,numero,cidade,estado,idcliente)VALUES(?,?,?,?,?)";
        PreparedStatement stmt = null;
        
        try {
           stmt = con.prepareStatement(sql);
            stmt.setString(1,e.getLogadouro());
            stmt.setInt(2, e.getNumero());
            stmt.setString(3, e.getCidade());
            stmt.setString(4, e.getEstado());
            stmt.setInt(5, e.getIdcliente().getId());
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar ! "+ ex);
             return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List<Endereco> read(){
        
        String sql = "SELECT * FROM endereco e LEFT JOIN cliente c ON c.id = e.idcliente";
        PreparedStatement stmt = null;
        ResultSet rs =null;
        
        List<Endereco> enderecos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
              while(rs.next()){
                
                Endereco endereco = new Endereco();
                
                endereco.setIdendereco(rs.getInt("idendereco"));
                endereco.setLogadouro(rs.getString("logadouro"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                
                endereco.setId(rs.getInt("id"));
                endereco.setNome(rs.getString("nome"));
                endereco.setEmail(rs.getString("email"));
                
                Cliente c = new Cliente();
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                endereco.setIdcliente(c);
                
                enderecos.add(endereco);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar ! "+ ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return enderecos;
    }
   
    public boolean update(Endereco e){
        
        String sql = "UPDATE endereco SET logadouro = ? ,numero = ? ,cidade = ?,estado = ?,idcliente = ? WHERE idendereco = ?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,e.getLogadouro());
            stmt.setInt(2, e.getNumero());
            stmt.setString(3, e.getCidade());
            stmt.setString(4, e.getEstado());
            stmt.setInt(5, e.getIdcliente().getId());
            
            stmt.setInt(6, e.getIdendereco());
       
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao atualizar ! "+ ex);
             return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean delete(Endereco e){
        
        String sql = "DELETE FROM endereco WHERE idendereco = ?";
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, e.getIdendereco());
            
            stmt.executeUpdate();
            return true;
           
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao excluir ! "+ ex);
             return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
     public boolean drop(Endereco e){
        
        String sql = "TRUNCATE TABLE endereco";
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
     
     
     public List<Endereco> readForDesc(Integer desc){
        
        String sql =  "SELECT * FROM endereco e LEFT JOIN cliente c ON c.id = e.idcliente WHERE e.idcliente = ?";
        PreparedStatement stmt = null;
        ResultSet rs =null;
        
        List <Endereco> enderecos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, desc);
          
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Endereco endereco = new Endereco();
                
                endereco.setIdendereco(rs.getInt("idendereco"));
                endereco.setLogadouro(rs.getString("logadouro"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                
                endereco.setId(rs.getInt("id"));
                endereco.setNome(rs.getString("nome"));
                endereco.setEmail(rs.getString("email"));
                
                Cliente c = new Cliente();
                
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                endereco.setIdcliente(c);
                
                enderecos.add(endereco);
            }
            
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao buscar ! "+ ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return enderecos;
    }
}

