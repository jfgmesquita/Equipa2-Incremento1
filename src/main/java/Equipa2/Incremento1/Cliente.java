package Equipa2.Incremento1;

import java.util.List;
import java.util.ArrayList;

public class Cliente extends Utilizador {
	// private ArrayList<Solicitacao> servicos; 
	private String formaDePagamento; // eventualmente substituir por ArrayList de formas de pagamento
	private List<Solicitacao> solicitacoes;
	
	public Cliente(String nome, String email, String password, String morada, String formaDePagamento) {
		super(nome, email, password, morada);
		this.formaDePagamento = formaDePagamento;
		solicitacoes = new ArrayList<Solicitacao>();
	}
	 
	 // getters
	public String getFormaDePagamento() {
	    return formaDePagamento;
	}

	public List<Solicitacao> getSolicitacoes(){
		return solicitacoes;
	}
	 
	 // setters
	public void setFormaDePagamento(String formaDePagamento) {
	        this.formaDePagamento = formaDePagamento;
	}
	 
}