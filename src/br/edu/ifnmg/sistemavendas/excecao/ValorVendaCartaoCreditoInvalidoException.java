/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.sistemavendas.excecao;

/**
 *
 * @author helder
 */
public class ValorVendaCartaoCreditoInvalidoException extends SistemaVendaException{

    public ValorVendaCartaoCreditoInvalidoException(){
        super("Valor da venda no cartão de crédito está inválido.\n"
                + "Vendas no cartão de crédito deve a partir de R$ 50,00.");
    }
}
