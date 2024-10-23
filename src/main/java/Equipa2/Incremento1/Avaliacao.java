package Equipa2.Incremento1;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * A classe Avaliacao representa uma avaliação feita por um cliente sobre um serviço prestado por um profissional.
 */
@Entity
public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int valor;
    
    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;
    
    private String descricao;
    private String data;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_solicitacao", referencedColumnName = "id")
    private Solicitacao servico;
    
    /**
     * Construtor que inicializa uma avaliação com os dados fornecidos.
     *
     * @param valor o valor da avaliação
     * @param descricao a descrição da avaliação
     * @param servico a solicitação de serviço associada à avaliação
     */
    public Avaliacao(int valor, String descricao, Solicitacao servico) {
        this.valor = valor;
        this.descricao = descricao;
        this.servico = servico;
        data = "Hoje";
    }

    /**
     * Construtor padrão que inicializa uma avaliação com valores padrão.
     */
    public Avaliacao() {}

    /**
     * Obtém o ID da avaliação.
     *
     * @return o ID da avaliação
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o valor da avaliação.
     *
     * @return o valor da avaliação
     */
    public int getValor() {
        return valor;
    }

    /**
     * Obtém a descrição da avaliação.
     *
     * @return a descrição da avaliação
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Obtém a data da avaliação.
     *
     * @return a data da avaliação
     */
    public String getData() {
        return data;
    }
    
    /**
     * Obtém a solicitação de serviço associada à avaliação.
     *
     * @return a solicitação de serviço
     */
    public Solicitacao getServico() {
        return servico;
    }

    /**
     * Obtém o profissional associado à avaliação.
     *
     * @return o profissional
     */
    public Profissional getProfissional() {
        return profissional;
    }

    /**
     * Define o ID da avaliação.
     *
     * @param id o novo ID da avaliação
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Define o valor da avaliação.
     *
     * @param valor o novo valor da avaliação
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Define a descrição da avaliação.
     *
     * @param descricao a nova descrição da avaliação
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Define a data da avaliação.
     *
     * @param data a nova data da avaliação
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Define o profissional associado à avaliação.
     *
     * @param profissional o novo profissional associado à avaliação
     */
    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    /**
     * Define a solicitação de serviço associada à avaliação.
     *
     * @param servico a nova solicitação de serviço associada à avaliação
     */
    public void setServico(Solicitacao servico) {
        this.servico = servico;
    }
}