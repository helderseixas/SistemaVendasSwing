/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemavendas.negocio;

import br.edu.ifnmg.sistemavendas.entidade.Venda;
import br.edu.ifnmg.sistemavendas.persistencia.VendaDAO;
import java.sql.SQLException;

/**
 *
 * @author helder
 */
public class VendaBO {
    
    public void inserir(Venda venda) throws SQLException{
        //Colocar todas as regras de negócio - Fazer depois
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.inserir(venda);
    }
    
}
