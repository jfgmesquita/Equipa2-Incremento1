package Equipa2.Incremento1;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Avaliacao implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int valor;
	
	@ManyToOne
	@JoinColumn(name = "profissional_id")
	private Profissional profissional;
	
	private String descricao;
	private String data;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_solicitacao", referencedColumnName = "id")
	private Solicitacao servico;
	
public Avaliacao(int valor, String descricao, Solicitacao servico) {
	this.valor = valor;
	this.descricao = descricao;
	this.servico = servico;
	data = "hoje";
}
public Avaliacao() {}

//Getters e Setters
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getValor() {
	return valor;
}
public void setValor(int valor) {
	this.valor = valor;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public Solicitacao getServico() {
	return servico;
}
public void setServico(Solicitacao servico) {
	this.servico = servico;
}


}
