package Equipa2.Incremento1;

import java.util.ArrayList;

/**
 * A classe Cliente representa um cliente que herda da classe Utilizador.
 * Contém informações sobre os serviços solicitados e a forma de pagamento.
 */
public class Cliente extends Utilizador {
    private ArrayList<Solicitacao> servicos; 
    private String formaDePagamento;
    
    /**
     * Construtor que inicializa um cliente com os dados fornecidos.
     *
     * @param nome Nome do cliente.
     * @param email Email do cliente.
     * @param password Senha do cliente.
     * @param morada Morada do cliente.
     * @param formaDePagamento Forma de pagamento do cliente.
     */
    public Cliente(String nome, String email, String password, String morada, String formaDePagamento) {
        super(nome, email, password, morada);
        this.formaDePagamento = formaDePagamento;
        servicos = new ArrayList<Solicitacao>();
    }
    
    /**
     * Construtor padrão para a classe Cliente.
     * Inicializa os campos servicos e formaDePagamento com valores padrão.
     */
    public Cliente() {
        super();
        this.formaDePagamento = "";
        this.servicos = new ArrayList<Solicitacao>();
    }

    /**
     * Obtém a lista de serviços do cliente.
     *
     * @return Lista de serviços do cliente.
     */
    public ArrayList<Solicitacao> getServicos() {
        return servicos;
    }

    /**
     * Obtém a forma de pagamento do cliente.
     *
     * @return Forma de pagamento do cliente.
     */
    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    /**
     * Define a forma de pagamento do cliente.
     *
     * @param formaDePagamento Forma de pagamento do cliente.
     */
    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
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
