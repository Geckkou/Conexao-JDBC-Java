/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Alexandre
 */
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
    }

    @Test
    @Ignore
    public void create() {
        
        Cliente cli = new Cliente("Teste","teste@hotmail.com");
        ClienteDAO clienteDAO = new ClienteDAO();
        
        if(clienteDAO.create(cli)){
            System.out.println("Salvo com sucesso");
        }else{
            fail("Erro ao salvar");
        }
        
    }
    
    @Test
    @Ignore
    public void findAll(){
        
        ClienteDAO dao = new ClienteDAO();
        
        for(Cliente c : dao.read()){
             System.out.println("Nome: " +c.getNome());
             System.out.println("E-mail: " +c.getEmail());
        }
               
    }
    
    @Test
    @Ignore
    public void atualizar(){
        Cliente c = new Cliente("teste", "teste@gmail.com");
        c.setId(1);
        ClienteDAO dao = new ClienteDAO();
        
        if(dao.update(c)){
            System.out.println("Atualizado com sucesso");
        }else{
            fail("Erro ao atualizar");
        }
        
    }
    
    @Test
    public void excluir(){
        Cliente c = new Cliente();
        c.setId(1);
        ClienteDAO dao = new ClienteDAO();
        
        if(dao.delete(c)){
            System.out.println("Deletado com sucesso");
        }else{
            fail("Erro ou deletar");
        }
    }
    
}
