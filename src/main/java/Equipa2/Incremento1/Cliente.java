package Equipa2.Incremento1;

import java.util.ArrayList;


public class Cliente extends Utilizador {
	// private ArrayList<Solicitacao> servicos; 
	private String formaDePagamento; // eventualmente substituir por ArrayList de formas de pagamento
	private ArrayList<Avaliacao> avaliacoes;
	
	 public Cliente(String nome, String email, String password, String morada, String formaDePagamento) {
		super(nome, email, password, morada);
		this.formaDePagamento = formaDePagamento;
		this.avaliacoes = new ArrayList<>();
	 }
	 
	
	 
	 // getters
	 public ArrayList<Avaliacao> getAvaliacoes() {
	        return avaliacoes;
	    }
	 
	 public String getFormaDePagamento() {
	        return formaDePagamento;
	    }
	 
	 // setters
	 public void setFormaDePagamento(String formaDePagamento) {
	        this.formaDePagamento = formaDePagamento;
	    }
	 
	 // método para inserir uma avaliacao na ArrayList<avaliacoes>
	 public void insertAvaliacao(Avaliacao avaliacao) {
		 avaliacoes.add(avaliacao);
	 }
	 
}
