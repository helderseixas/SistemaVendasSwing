/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemavendas.negocio;

import br.edu.ifnmg.sistemavendas.entidade.Venda;
import br.edu.ifnmg.sistemavendas.excecao.ValorVendaCartaoCreditoInvalidoException;
import br.edu.ifnmg.sistemavendas.excecao.ValorVendaInvalidoException;
import br.edu.ifnmg.sistemavendas.persistencia.VendaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author helder
 */
public class VendaBO {
    
    public void inserir(Venda venda) throws SQLException{
        if(venda.getValor()<=0){
            throw new ValorVendaInvalidoException();
        }
        
        if(venda.getFormaPagamento().equals("CC") &&
                venda.getValor()<50.0){
            throw new ValorVendaCartaoCreditoInvalidoException();
        }
        
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.inserir(venda);
    }
    
    public List<Venda> buscarTodos() throws SQLException{
        VendaDAO vendaDAO = new VendaDAO();
        return vendaDAO.buscarTodos();
    }
    
}
