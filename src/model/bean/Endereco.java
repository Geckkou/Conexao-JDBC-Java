/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Alexandre
 */
public class Endereco extends Cliente {
    
    private int idendereco;
    private String logadouro;
    private int numero;
    private String cidade;
    private String estado;
    private Cliente idcliente;

    public Endereco() {
    }

    public Endereco(String logadouro, int numero, String cidade, String estado, Cliente idcliente) {
        this.logadouro = logadouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.idcliente = idcliente;
    }
    
    

    public int getIdendereco() {
        return idendereco;
    }

    public void setIdendereco(int idendereco) {
        this.idendereco = idendereco;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }


    
}
