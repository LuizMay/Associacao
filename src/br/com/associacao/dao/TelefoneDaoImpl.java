/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Telefone;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Silvio
 */
public class TelefoneDaoImpl implements Serializable{
    
    private PreparedStatement preparando;
    
    public void salvarProfessor(List<Telefone> telefones, int chaveEstrangeira, Connection conn) 
                                                                                throws SQLException{
        String sql = "INSERT INTO telefone(tipo, numero, operadora, idProfessor) "
                + "values(?, ?, ?, ?)";
        
        for (Telefone telefone : telefones) {
            salvar(telefone, sql, conn, chaveEstrangeira);
        }
        
    }
    
    private void salvar(Telefone telefone, String sql, Connection connection, int id){
        try {
            preparando = connection.prepareStatement(sql);
            preparando.setString(1, telefone.getTipo());
            preparando.setString(2, telefone.getNumero());
            preparando.setString(3, telefone.getOperadora());
            preparando.setInt(4, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao gravar telefone " + e.getMessage());
        }
    }
    
}
