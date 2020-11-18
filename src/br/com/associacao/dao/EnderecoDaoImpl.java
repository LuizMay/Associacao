/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Silvio
 */
public class EnderecoDaoImpl {
    
    
    public void salvarCliente(Endereco endereco, Connection conexao, int chaveEstrangeira){
        String sql = "INSERT INTO endereco(logradouro, numero, bairro, cidade, estado, idCliente)"
                + " VALUES(?, ?, ?, ?, ?, ?)";
        inserirEndereco(endereco, conexao, chaveEstrangeira, sql);
    }
    
    
    private void inserirEndereco(Endereco endereco, Connection conexao, int chaveEstrangeira, String sql){
        try {
            PreparedStatement preparando = conexao.prepareStatement(sql);
            preparando.setString(1, endereco.getLogradouro());
            preparando.setString(2, endereco.getNumero());
            preparando.setString(3, endereco.getBairro());
            preparando.setString(4, endereco.getCidade());
            preparando.setString(5, endereco.getEstado());
            preparando.setInt(6, chaveEstrangeira);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar endereço " + e.getMessage());
        }
    }
    
}
