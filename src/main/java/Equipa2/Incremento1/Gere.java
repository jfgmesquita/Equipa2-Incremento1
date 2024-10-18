package Equipa2.Incremento1;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Gere {
    private List<Cliente> clientes;
    private List<Profissional> profissionais;
    private List<Solicitacao> solicitacoes;

    public Gere(){
        clientes = new ArrayList<>();
        profissionais = new ArrayList<>();
        solicitacoes = new ArrayList<>();
    }

    // public void registarCliente(Cliente cliente){
    //     clientes.add(cliente);
    // }

    // public void registarProfissional(Profissional pro){
    //     profissionais.add(pro);
    // }

    // public Cliente pesquisarCliente(UUID id){
    //     for(Cliente cli : clientes){
    //         if(cli.getId().equals(id)){
    //             return cli;
    //         }
    //     }
    //     return null;
    // }

    // public Profissional pesquisarProfissional(UUID id){
    //     for(Profissional pro : profissionais){
    //         if(pro.getId().equals(id)){
    //             return pro;
    //         }
    //     }

    //     return null;
    // }

    // public Solicitacao ultimaSolicitacao(){
    //     return solicitacoes.getLast();
    // }

    public void solicitarServico(Cliente cliente, Profissional profissional, String morada, String data){
        Solicitacao newSol = new Solicitacao();
        newSol.setCliente(cliente);
        newSol.setProfissional(profissional);
        newSol.setMorada(morada);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        newSol.setData(LocalDateTime.parse(data, dtf));
        newSol.setStatus(StatusServico.PENDENTE);

        solicitacoes.add(newSol);
        cliente.getSolicitacoes().add(newSol);
        profissional.getSolicitacoes().add(newSol);
    }

    public void cancelarSolicitacao(UUID idSol){
        int i = 0;
        while(idSol != solicitacoes.get(i).getId() && i < solicitacoes.size()){
            i++;
        }
        if(i < solicitacoes.size()){
            solicitacoes.get(i).setStatus(StatusServico.CANCELADO);
        } else{
            System.out.println("Esta solicitação não está registada.");
        }
    }

    // public void imprimirTodasSolicitacao(){
    //     for(Solicitacao sol : solicitacoes){
    //         System.out.println("\n" + sol.toString() + "\n---------------------\n");
    //     }
    // }
}
