package Equipa2.Incremento1;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;

import java.io.Serializable;
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
@Table(name = "Solicitação_de_Serviço")
@Inheritance(strategy = InheritanceType.JOINED)
public class Solicitacao implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Enumerated(EnumType.STRING)
	private StatusServico status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profissional_id")
	private Profissional profissional;
	
	@Column(name = "Endereço")
	private String endereco;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
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
  public Solicitacao(Cliente cliente, Profissional profissional, String endereco, Pagamento pagamento, LocalDateTime data) {
	  
	this.cliente = cliente;
    this.profissional = profissional;
    this.endereco = endereco;
    this.pagamento = pagamento;
    status = StatusServico.PENDENTE;
    this.data = data;
  }

  /**
   * Construtor vazio para a classe Solicitacao.
   */
  public Solicitacao() {
  }
  
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

public void setId(UUID id) {
	this.id = id;
}
  
}
