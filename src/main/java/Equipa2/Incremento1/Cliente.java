package Equipa2.Incremento1;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

/**
 * A classe Cliente representa um cliente que herda da classe Utilizador.
 * Contém informações sobre os serviços solicitados e a forma de pagamento.
 */

@Entity
@Table(name = "Cliente")
public class Cliente extends Utilizador {
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Solicitacao> solicitacoes;
	
	@Column(name = "Forma de Pagamento")
	@Enumerated(EnumType.STRING)
    private MetodoPagamento formaDePagamento;
    
    /**
     * Construtor que inicializa um cliente com os dados fornecidos.
     *
     * @param nome Nome do cliente.
     * @param email Email do cliente.
     * @param password Senha do cliente.
     * @param morada Morada do cliente.
     * @param formaDePagamento Forma de pagamento do cliente.
     */
    public Cliente(String nome, String email, String password, String morada, MetodoPagamento formaDePagamento) {
        super(nome, email, password, morada);
        this.formaDePagamento = formaDePagamento;
        this.solicitacoes = new ArrayList<Solicitacao>();
    }
    
    /**
     * Construtor padrão para a classe Cliente.
     * Inicializa os campos servicos e formaDePagamento com valores padrão.
     */
    public Cliente() {}

    /**
     * Obtém a lista de serviços do cliente.
     *
     * @return Lista de serviços do cliente.
     */
    public List<Solicitacao> getServicos() {
        return solicitacoes;
    }

    /**
     * Obtém a forma de pagamento do cliente.
     *
     * @return Forma de pagamento do cliente.
     */
    public MetodoPagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    /**
     * Define a forma de pagamento do cliente.
     *
     * @param formaDePagamento Forma de pagamento do cliente.
     */
    public void setFormaDePagamento(MetodoPagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
    
    

	public void setServicos(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	/**
     * Retorna uma representação em string do cliente.
     *
     * @return String que representa o cliente.
     */
    @Override
	public String toString() {
		return super.toString() + "\n" +
			"Forma de pagamento: " + formaDePagamento;
	}
}