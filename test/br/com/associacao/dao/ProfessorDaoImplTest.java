/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Professor;
import br.com.associacao.entidade.Telefone;
import br.com.utilitario.UtilGerador;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Silvio
 */
public class ProfessorDaoImplTest {

    private Professor professor;
    private ProfessorDaoImpl professorDaoImpl;

    public ProfessorDaoImplTest() {
    }

    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        professor = new Professor(
                null,
                UtilGerador.gerarNome(),
                UtilGerador.gerarNumero(3) + "." + UtilGerador.gerarNumero(3) + "."
                + UtilGerador.gerarNumero(3) + "-" + UtilGerador.gerarNumero(2),
                UtilGerador.gerarNumero(6)
        );
        List<Telefone> telefones = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            telefones.add(gerarTelefone());
        }
        professor.setTelefones(telefones);
        professorDaoImpl = new ProfessorDaoImpl();
        
        professorDaoImpl.salvar(professor);
        assertNotNull(professor.getId());
    }

    private Telefone gerarTelefone() {
        Telefone tel = new Telefone(
                null,
                "Fixo",
                UtilGerador.gerarTelefoneFixo(),
                "Vivo"
        );
        return tel;
    }

}
