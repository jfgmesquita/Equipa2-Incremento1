package Equipa2.Incremento1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe para representar a Solitação do serviço.
 */
@Getter
@Setter
public class Solicitacao {
	private StatusServico status;
	private Cliente cliente;
	private Profissional profissional;
	private String endereco;
	private Pagamento pagamento;
	private LocalDateTime data;
  
  /**
   * Construtor que inicializa uma nova solicitação de serviço com os dados fornecidos.
   * 
   * @param cliente		Cliente que solicitou.
   * @param profissional  Profissional que aceitou o pedido.
   * @param endereco		Endereço do local.
   * @param pagamento		Informações de pagamento.
   * @param data			Data e horas
   */
  public Solicitacao(Cliente cliente, Profissional profissional, String endereco, Pagamento pagamento, String data) {
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
   * Inicializa todas variáveis de objeto como null.
   */
  public Solicitacao() {
    cliente = null;
    profissional = null;
    endereco = "";
    pagamento = null;
    data = null;
  }
}
