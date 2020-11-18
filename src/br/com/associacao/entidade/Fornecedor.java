/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.entidade;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Silvio
 */
public class Fornecedor implements Serializable{
    
    private Integer id;
    private String nome;
    private String cnpj;
    private String inscricaoEstadual;
    private List<Endereco> enderecos;

    public Fornecedor() {
    }

    public Fornecedor(Integer id, String nome, String cnpj, String inscricaoEstadual) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    
    
    
    
}
