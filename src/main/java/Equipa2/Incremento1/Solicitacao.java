package Equipa2.Incremento1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Classe para representar a Solitação do serviço.
 */
@Getter
@Setter
@ToString
public class Solicitacao {
  private UUID id;
	private StatusServico status;
	private Cliente cliente;
	private Profissional profissional;
	private String morada;
	private LocalDateTime data;
  
  /**
   * Construtor que inicializa uma nova solicitação de serviço com os dados fornecidos.
   * 
   * @param cliente		Cliente que solicitou.
   * @param profissional  Profissional que aceitou o pedido.
   * @param morada		Endereço do local.
   * @param pagamento		Informações de pagamento.
   * @param data			Data e horas
   */
  public Solicitacao(Cliente cliente, Profissional profissional, String morada, String data) {
    id = UUID.randomUUID();
    this.cliente = cliente;
    this.profissional = profissional;
    this.morada = morada;
    status = StatusServico.PENDENTE;

    //exemplo do formato da string: "15:30 28-10-2024"
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
    //transforma a string em um objeto do tipo LocalDateTime
    this.data = LocalDateTime.parse(data, dtf);
  }

  /**
   * Construtor vazio para a classe Solicitacao.
   * Inicializa todas variáveis de objeto como null.
   */
  public Solicitacao() {
    id = UUID.randomUUID();
    cliente = null;
    profissional = null;
    morada = "";
    data = null;
  }

}
