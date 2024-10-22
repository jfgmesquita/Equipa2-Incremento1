package Equipa2.Incremento1;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;

/**
 * A classe Profissional representa um utilizador que é um profissional com especialidade, experiência e valor por hora.
 */
@Entity
public class Profissional extends Utilizador {

    @Column(name = "especialidade")
    private String especialidade;

    @Column(name = "experiencia")
    private int experiencia;

    @Column(name = "metodo_pagamento")
    @Enumerated(EnumType.STRING)
    private MetodoPagamento metPag;

    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL)
    private List<Servico> servicos;

    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL)
    private List<Solicitacao> solicitacoes;

    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes;

    /**
     * Construtor que inicializa um profissional com os dados fornecidos.
     *
     * @param nome o nome do profissional
     * @param email o email do profissional
     * @param password a palavra-passe do profissional
     * @param morada a morada do profissional
     * @param especialidade a especialidade do profissional
     * @param experiencia a experiência do profissional em anos
     * @param valorHora o valor cobrado por hora pelo profissional
     * @param metPag o método de pagamento que o profissional deseja receber
     */
    public Profissional(String nome, String email, String password, String morada, String especialidade, int experiencia, MetodoPagamento metPag) {
        super(nome, email, password, morada);
        this.especialidade = especialidade;
        this.experiencia = experiencia;
        this.metPag = metPag;
        servicos = new ArrayList<>();
        solicitacoes = new ArrayList<>();
        avaliacoes = new ArrayList<>();
    }

    /**
     * Construtor padrão que inicializa um profissional com valores padrão.
     */
    public Profissional(){
    }

    /**
     * Obtém a especialidade do profissional.
     *
     * @return a especialidade do profissional
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * Obtém a experiência do profissional em anos.
     *
     * @return a experiência do profissional
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * Obtém o método de pagamento que o profissional deseja receber.
     * @return metPag
     */
    public MetodoPagamento getMetPag(){
        return metPag;
    }
    
    /**
     * Obtém a lista de serviços do profissional.
     *
     * @return a lista de serviços
     */
    public List<Servico> getServicos() {
        return servicos;
    }

    /**
     * Obtém a lista de serviços do profissional.
     *
     * @return a lista de solicitacoes
     */
    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    /**
     * Obtém a lista de avaliações do profissional.
     *
     * @return a lista de avaliações
     */
    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
    
    /**
     * Define a especialidade do profissional.
     *
     * @param especialidade a nova especialidade
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    /**
     * Define a experiência do profissional em anos.
     *
     * @param experiencia a nova experiência
     */
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    
    /**
     * Define o método de pagamento que o profissional deseja receber.
     * 
     * @param metPag
     */
    public void setMetPag(MetodoPagamento metPag){
        this.metPag = metPag;
    }

    /**
     * Retorna uma representação em string do profissional.
     *
     * @return uma string que representa o profissional
     */
    public String toString() {
        return super.toString() + "\n" +
            "Especialidade: " + especialidade + "\n" +
            "Experiência: " + experiencia + " anos";
    }
}
