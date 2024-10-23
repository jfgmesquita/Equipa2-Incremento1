package Equipa2.Incremento1;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * A classe Profissional representa um utilizador que é um profissional com especialidade, experiência e valor por hora.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
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
    public Profissional(String nome, String email, String password, String morada, UserType userType, String especialidade, int experiencia, MetodoPagamento metPag) {
        super(nome, email, password, morada, userType);
        this.especialidade = especialidade;
        this.experiencia = experiencia;
        this.metPag = metPag;
        servicos = new ArrayList<>();
        solicitacoes = new ArrayList<>();
        avaliacoes = new ArrayList<>();
    }
}
