package Equipa2.Incremento1;


public class Cliente extends Utilizador {
	// private ArrayList<Solicitacao> servicos; 
	private String formaDePagamento; // eventualmente substituir por ArrayList de formas de pagamento
	
	 public Cliente(String nome, String email, String password, String morada, String formaDePagamento) {
		super(nome, email, password, morada);
		this.formaDePagamento = formaDePagamento;
	 }
	 
	
	 
	 // getters
	 public String getFormaDePagamento() {
	        return formaDePagamento;
	    }
	 
	 // setters
	 public void setFormaDePagamento(String formaDePagamento) {
	        this.formaDePagamento = formaDePagamento;
	    }
	 
}
