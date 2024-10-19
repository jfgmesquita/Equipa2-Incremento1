package Equipa2.Incremento1;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Gere {
    private List<Cliente> clientes;
    private List<Profissional> profissionais;
    private List<Solicitacao> solicitacoes;
    List<String> servicos = new ArrayList<>(){{
        add("Limpeza");
        add("Pintura");
    }};

    public Gere(){
        clientes = new ArrayList<>();
        profissionais = new ArrayList<>();
        solicitacoes = new ArrayList<>();
    }

    public void registarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void registarProfissional(Profissional pro){
        profissionais.add(pro);
    }

    public Cliente pesquisarCliente(UUID id){
        for(Cliente cli : clientes){
            if(cli.getId().equals(id)){
                return cli;
            }
        }
        return null;
    }

    public Profissional pesquisarProfissional(UUID id){
        for(Profissional pro : profissionais){
            if(pro.getId().equals(id)){
                return pro;
            }
        }

        return null;
    }

    public Solicitacao ultimaSolicitacao(){
        return solicitacoes.getLast();
    }

    public void consultarServicosDisponiveis(){
        for(String serv : servicos){
            System.out.println((servicos.indexOf(serv) + 1) + ") " + serv);
        }
    }

    public List<Servico> consultarProfissionalPorServico(String servico){
        List<Servico> lista = new ArrayList<>();
        for(Profissional pro : profissionais){
            for(Servico serv : pro.getServicos()){
                if(serv.getTitulo().equals(servico)){
                    lista.add(serv);
                }
            }
        }

        return lista;
    }

    //Métodos de clientes

    public void solicitarServico(Cliente cliente, Profissional profissional, LocalDateTime data){
        Solicitacao newSol = new Solicitacao();
        newSol.setCliente(cliente);
        newSol.setProfissional(profissional);
        newSol.setMorada(cliente.getMorada());
        newSol.setData(data);
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

    // Métodos de profissional
    public void adicionarServico(Profissional pro, String titulo, String descricao, Double valorHora, LocalDateTime data){
        Servico newServico = new Servico();
        newServico.setTitulo(titulo);
        newServico.setDescricao(descricao);
        newServico.setValorHora(valorHora);
        newServico.setData(data);

        pro.getServicos().add(newServico);
        newServico.setProfissional(pro);
    }

    public void consultarSoliticacoes(){
        if(solicitacoes.isEmpty()){
            System.out.println("Não existem solicitações registadas");
        } else{
            System.out.println("-".repeat(120));
            for(Solicitacao sol : solicitacoes){
                System.out.println("\n" + sol.toString() + "\n---------------------\n");
            }
        }
    }

    public void consultarSoliticacoes(Cliente cliente){
        if(cliente.getSolicitacoes().isEmpty()){
            System.out.println("Este cliente não possui solicitações");
        } else{
            for(Solicitacao sol : cliente.getSolicitacoes()){
                System.out.println("\n" + sol.toString() + "\n---------------------\n");
            }
        }
    }

    public void consultarSoliticacoes(Profissional pro){
        if(pro.getSolicitacoes().isEmpty()){
            System.out.println("Este cliente não possui solicitações");
        } else{
            for(Solicitacao sol : pro.getSolicitacoes()){
                System.out.println("\n" + sol.toString() + "\n---------------------\n");
            }
        }
    }
}
