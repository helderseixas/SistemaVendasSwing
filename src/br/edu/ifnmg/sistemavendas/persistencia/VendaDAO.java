/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemavendas.persistencia;

import br.edu.ifnmg.sistemavendas.entidade.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author helder
 */
public class VendaDAO {

    private static final String INSERT = "INSERT INTO \"PUBLIC\".\"VENDA\"\n"
            + "( \"NUMERO\", \"DATA\", \"NOME_CLIENTE\", \"CPF_CLIENTE\", \"VALOR\", \"FORMA_PAGAMENTO\", \"OBSERVACAO\" )\n"
            + "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_TODOS = "SELECT NUMERO, DATA, NOME_CLIENTE, CPF_CLIENTE, VALOR, FORMA_PAGAMENTO, OBSERVACAO FROM VENDA ORDER BY DATA DESC";
    
    public void inserir(Venda venda) throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            //Recupera a conexão
            conexao = BancoDadosUtil.getConnection();
            //Cria o comando de inserir dados
            comando = conexao.prepareStatement(INSERT);
            //Atribui os parâmetros (Note que no BD o index inicia por 1)
            comando.setInt(1, venda.getNumero());
            java.sql.Date dataSql = new java.sql.Date(venda.getData().getTime());
            comando.setDate(2, dataSql);
            comando.setString(3, venda.getNomeCliente());
            comando.setString(4, venda.getCpfCliente());
            comando.setDouble(5, venda.getValor());
            comando.setString(6, venda.getFormaPagamento());
            comando.setString(7, venda.getObservacao());
            //Executa o comando
            comando.execute();
            //Persiste o comando no banco de dados
            conexao.commit();
        } catch (Exception e) {
            //Caso aconteça alguma exeção é feito um rollback para o banco de
            //dados retornar ao seu estado anterior.
            if (conexao != null) {
                conexao.rollback();
            }
            throw e;
        } finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }
    
    public List<Venda> buscarTodos() throws SQLException{
        List<Venda> listaVendas = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SELECT_TODOS);
            resultado = comando.executeQuery();
            
            while(resultado.next()){
                Venda venda = new Venda();
                
                venda.setNumero(resultado.getInt(1));
                venda.setData(resultado.getTimestamp(2));
                venda.setNomeCliente(resultado.getString(3));
                venda.setCpfCliente(resultado.getString(4));
                venda.setValor(resultado.getDouble(5));
                venda.setFormaPagamento(resultado.getString(6));
                venda.setObservacao(resultado.getString(7));
                
                listaVendas.add(venda);
            }
            
        }finally {
            //Todo objeto que referencie o banco de dados deve ser fechado
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
        
        return listaVendas;
    }

}
