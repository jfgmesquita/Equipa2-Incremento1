package Equipa2.Incremento1;

import jakarta.persistence.*;

@Entity
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double valor;
	private String origem;
	private String destino;
	
	@Enumerated(EnumType.STRING)
	private MetodoPagamento metodo;
	
	@Enumerated(EnumType.STRING)
	private StatusPagamento status;
	
    public Pagamento(double valor, Cliente origem, Profissional destino, MetodoPagamento metodo) {
        this.valor = valor;
        this.origem = origem.getNome();
        this.destino = destino.getNome();
        this.metodo = metodo;
        status = StatusPagamento.PENDENTE;
        
    }
    public Pagamento() {}

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Enumerated(EnumType.STRING)
    public MetodoPagamento getMetodo() {
        return metodo;
    }

    public void setMetodo(MetodoPagamento metodo) {
        this.metodo = metodo;
    }

    @Enumerated(EnumType.STRING)
    public StatusPagamento getStatus() {
        return status;
    }
    
    public void setStatus(StatusPagamento status) {
        this.status = status;
    }
}