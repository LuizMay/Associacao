/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Cliente;
import br.com.associacao.entidade.Endereco;
import br.com.utilitario.UtilGerador;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class ClienteDaoImplTest {

    private Cliente cliente;
    private ClienteDaoImpl clienteDaoImpl;

    public ClienteDaoImplTest() {
        clienteDaoImpl = new ClienteDaoImpl();
    }

    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        cliente = new Cliente(
                null,
                "Nome " + UtilGerador.gerarCaracter(10),
                UtilGerador.gerarEmail(),
                UtilGerador.gerarTelefoneFixo(),
                Double.parseDouble(UtilGerador.gerarNumero(4))
        );
        Endereco endereco = new Endereco(
                null,
                "Rua " + UtilGerador.gerarCaracter(10),
                UtilGerador.gerarNumero(3),
                "Bairro " + UtilGerador.gerarCaracter(10),
                "Cidade " + UtilGerador.gerarCaracter(10),
                "SC "
        );
        cliente.setEndereco(endereco);
        clienteDaoImpl.salvar(cliente);
    }

//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        cliente = new Cliente(
                2,
                "Nome alterado",
                UtilGerador.gerarEmail(),
                UtilGerador.gerarTelefoneFixo(),
                Double.parseDouble(UtilGerador.gerarNumero(4))
        );
        clienteDaoImpl.alterar(cliente);
    }

//    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        clienteDaoImpl.excluir(2);
    }

//    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        cliente = clienteDaoImpl.pesquisarPorId(1);
        mostrarCliente(cliente);
    }

//    @Test
    public void testPesquisarPorNome() throws Exception {
        System.out.println("pesquisarPorNome");
        List<Cliente> clientes = clienteDaoImpl.pesquisarPorNome("joão");
        for (Cliente cli : clientes) {
            mostrarCliente(cli);
        }
    }

    private void mostrarCliente(Cliente cliente) {
        System.out.println("Id: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("E-mail: " + cliente.getEmail());
        System.out.println("Salário: " + cliente.getSalario());
        System.out.println("");
    }

}
