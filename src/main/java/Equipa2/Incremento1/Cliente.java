package Equipa2.Incremento1;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;

/**
 * A classe Cliente representa um utilizador que é um cliente com uma forma de pagamento e uma lista de solicitações.
 */
@Entity
@Table(name = "Cliente")
public class Cliente extends Utilizador {
	
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Solicitacao> solicitacoes;

    @Column(name = "forma_de_pagamento")
    @Enumerated(EnumType.STRING)
    private MetodoPagamento formaDePagamento;
    
    /**
     * Construtor que inicializa um cliente com os dados fornecidos.
     *
     * @param nome o nome do cliente
     * @param email o email do cliente
     * @param password a palavra-passe do cliente
     * @param morada a morada do cliente
     * @param formaDePagamento a forma de pagamento do cliente
     */
    public Cliente(String nome, String email, String password, String morada, UserType userType, MetodoPagamento formaDePagamento) {
        super(nome, email, password, morada, userType);
        this.formaDePagamento = formaDePagamento;
        solicitacoes = new ArrayList<Solicitacao>();
    }

    /**
     * Construtor padrão que inicializa um cliente com valores padrão.
     */
    public Cliente(){}

    /**
     * Obtém a lista de solicitações do cliente.
     *
     * @return a lista de solicitações
     */
    public List<Solicitacao> getSolicitacoes(){
        return solicitacoes;
    }

    /**
     * Obtém a forma de pagamento do cliente.
     *
     * @return a forma de pagamento
     */
    public MetodoPagamento getFormaDePagamento() {
        return formaDePagamento;
    }
     
    /**
     * Define a forma de pagamento do cliente.
     *
     * @param formaDePagamento a nova forma de pagamento
     */
    public void setFormaDePagamento(MetodoPagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    /**
     * Retorna uma representação em string do cliente.
     *
     * @return uma string que representa o cliente
     */
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Forma de pagamento: " + formaDePagamento;
    }
}