package Equipa2.Incremento1;

import java.util.UUID;

public class MenuTeste {
    public static void main(String[] args){
        Gere gere = new Gere();

        // Cliente cliente = new Cliente("Alykhan", "alyjamal77@gmail.com", "aly", "boavista", "mbway");
        Profissional pro = new Profissional("Divaldo", "divaldodias@gmail.com", "divas", "lousada", "Pintura", 3, 15);

        // gere.registarCliente(cliente);
        gere.registarProfissional(pro);

        gere.adicionarServico(pro, "Pintura", "Pintura em casas (somente parte interna)", "15:30 28-10-2024");

        System.out.println(pro.getServicos().getLast().getDescricao());

        // gere.solicitarServico(cliente, pro, cliente.getMorada(), "15:30 28-10-2024");
        // gere.imprimirTodasSolicitacao();

        // UUID idUltima = gere.ultimaSolicitacao().getId();
        // System.out.println(idUltima);
        // gere.cancelarSolicitacao(idUltima);
        // gere.imprimirTodasSolicitacao();
    }
}
