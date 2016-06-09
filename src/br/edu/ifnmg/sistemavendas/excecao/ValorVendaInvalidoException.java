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
public class ValorVendaInvalidoException extends SistemaVendaException{
    
    public ValorVendaInvalidoException(){
        super("Valor de venda inválido!\nInforme um valor maior que zero.");
    }
}
