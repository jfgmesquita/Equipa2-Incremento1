package Equipa2.Incremento1;

import java.util.UUID;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe para representar a Solitação do serviço.
 */
//@Getter
//@Setter
@Entity
@Table(name = "Solicitação de Serviço")
public class Solicitacao {
	@Id
	private UUID id;
	@Enumerated(EnumType.STRING)
	@Column(name = "Status", nullable = false)
	private StatusServico status;
	@ManyToOne
	@Column(name = "Cliente", nullable = false)
	private Cliente cliente;
	@ManyToOne
	@Column(name = "Profissional", nullable = false)
	private Profissional profissional;
	@Column(name = "Endereço", nullable = false)
	private String endereco;
	@OneToOne
	@Column(name = "Pagamento", nullable = false)
	private Pagamento pagamento;
	@Column(name = "Data", nullable = false)
	private LocalDateTime data;
  
  /**
   * Construtor que inicializa uma nova solicitação de serviço com os dados fornecidos.
   * 
   * @param id              Identificador da solicitação
   * @param cliente		    Cliente que solicitou.
   * @param profissional    Profissional que aceitou o pedido.
   * @param endereco		Endereço do local.
   * @param pagamento		Informações de pagamento.
   * @param data			Data e horas
   */
  public Solicitacao(Cliente cliente, Profissional profissional, String endereco, Pagamento pagamento, String data) {
	id = UUID.randomUUID();
	this.cliente = cliente;
    this.profissional = profissional;
    this.endereco = endereco;
    this.pagamento = pagamento;
    status = StatusServico.PENDENTE;

    //exemplo do formato da string: "15:30 28-10-2024"
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
    //transforma a string em um objeto do tipo LocalDateTime
    this.data = LocalDateTime.parse(data, dtf);
  }

  /**
   * Construtor vazio para a classe Solicitacao.
   */
  public Solicitacao() {
  }
  
  @Id
  @Column(name = "solicitacao_id")
  @GeneratedValue(strategy = GenerationType.UUID)
  public UUID getId() {
	  return id;
  }

public StatusServico getStatus() {
	return status;
}

public void setStatus(StatusServico status) {
	this.status = status;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public Profissional getProfissional() {
	return profissional;
}

public void setProfissional(Profissional profissional) {
	this.profissional = profissional;
}

public String getEndereco() {
	return endereco;
}

public void setEndereco(String endereco) {
	this.endereco = endereco;
}

public Pagamento getPagamento() {
	return pagamento;
}

public void setPagamento(Pagamento pagamento) {
	this.pagamento = pagamento;
}

public LocalDateTime getData() {
	return data;
}

public void setData(LocalDateTime data) {
	this.data = data;
}
@Id
public void setId(UUID id) {
	this.id = id;
}
  
}
