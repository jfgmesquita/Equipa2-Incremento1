package Equipa2.Incremento1;
import java.time.LocalDateTime;

public class Solicitacao {
	
	private Status status;
	private Cliente cliente;
	private Profissional profissional;
	private String morada;
	private Pagamento pagamento;
	private LocalDateTime data;
	
public Solicitacao(Cliente cliente, Profissional profissional, String morada, Pagamento pagamento, String data) {
	this.cliente = cliente;
	this.profissional = profissional;
	this.morada = morada;
	this.pagamento = pagamento;
	
	//exemplo de formato da string: "2019-03-27T10:15:30"
	this.data = LocalDateTime.parse(data);
}

public Status getStatus() {
	return status;
}

public void setStatus(Status status) {
	this.status = status;
}

public Cliente getCliente() {
	return cliente;
}

public Profissional getProfissional() {
	return profissional;
}

public String getMorada() {
	return morada;
}

public Pagamento getPagamento() {
	return pagamento;
}

public LocalDateTime getData() {
	return data;
}

}
