/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import tela.EnderecoDAO;
import model.bean.Cliente;
import model.bean.Endereco;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Alexandre
 */
public class EnderecoDAOTest {
    
    public EnderecoDAOTest() {
    }

 /*   @Test
    @Ignore
    public void inserir() {
        
        Cliente c  = new Cliente();
        c.setId(2);
        
        Endereco e  = new Endereco();
        e.setLogadouro("teste");
        e.setNumero(129);
        e.setCidade("olinda");
        e.setEstado("pe");
        e.setIdcliente(c);
        
        EnderecoDAO dao = new EnderecoDAO();
                
        if(dao.create(e)){
            System.out.println("Salvo com sucesso");
        }else{
            fail("Erro ao salvar");
        }
    }
    
    @Test
    @Ignore
    public void  listar(){
        
        EnderecoDAO dao = new EnderecoDAO();
        
        for(Endereco e: dao.read())
        
            System.out.println("ID: " + e.getIdendereco()+ 
                "\n-Logadouro: " + e.getLogadouro() +
                "\n-Número: " + e.getNumero() + 
                "\n-Cidade: " + e.getCidade() +
                "\n-Estado: " + e.getEstado() + 
                "\n-Idcliente: " + e.getIdcliente().getId()); 
    }
    
    @Test
    @Ignore
    public void atualizar(){
    Cliente c  = new Cliente();
        c.setId(3);
          
        Endereco e  = new Endereco();
        e.setLogadouro("testeeee");
        e.setNumero(132);
        e.setCidade("cidadeteste");
        e.setEstado("te");
        e.setIdcliente(c);
        
        e.setIdendereco(2);
        
        EnderecoDAO dao = new EnderecoDAO();
                
        if(dao.update(e)){
            System.out.println("Atualizado com sucesso");
        }else{
            fail("Erro ao Atualizar");
        }
    }

    
    @Test
    @Ignore
    public void readForId() {
        
        EnderecoDAO dao = new EnderecoDAO();
        
        for(Endereco e: dao.readForDesc(15)){
        
            System.out.println("ID: " + e.getIdendereco()+ 
                "\n-Logadouro: " + e.getLogadouro() +
                "\n-Número: " + e.getNumero() + 
                "\n-Cidade: " + e.getCidade() +
                "\n-Estado: " + e.getEstado() + 
                "\n-Idcliente: " + e.getIdcliente().getId()); 
    }
  }*/
}

