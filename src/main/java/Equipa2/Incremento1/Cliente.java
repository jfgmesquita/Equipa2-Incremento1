package Equipa2.Incremento1;

import java.util.List;
import java.util.ArrayList;

public class Cliente extends Utilizador {
	private List<Solicitacao> servicos; 
	private MetodoPagamento formaDePagamento;
	private List<Solicitacao> solicitacoes;
	
	public Cliente(String nome, String email, String password, String morada, MetodoPagamento formaDePagamento) {
		super(nome, email, password, morada);
		this.formaDePagamento = formaDePagamento;
		solicitacoes = new ArrayList<Solicitacao>();
	}

	public Cliente(){
	}

	public List<Solicitacao> getServicos(){
		return servicos;
	}

	public List<Solicitacao> getSolicitacoes(){
		return solicitacoes;
	}

	public MetodoPagamento getFormaDePagamento() {
	    return formaDePagamento;
	}

	 
	public void setFormaDePagamento(MetodoPagamento formaDePagamento) {
	        this.formaDePagamento = formaDePagamento;
	}
}