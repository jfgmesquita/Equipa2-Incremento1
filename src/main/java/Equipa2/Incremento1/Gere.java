package Equipa2.Incremento1;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Gere {
    private List<Cliente> clientes;
    private List<Profissional> profissionais;
    private List<Admin> admins;
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

    public List<Cliente> getClientes(){
        return clientes;
    }

    public List<Profissional> getProfissionais(){
        return profissionais;
    }

    public List<Admin> getAdmins(){
        return admins;
    }

    public Cliente iniciarSessaoCliente(String email, String password){
        Cliente cliente = pesquisarCliente(email);
        if(cliente != null){
            if(cliente.getPassword().equals(password)){
                return cliente;
            }
        }
        return null;
    }

    public Profissional iniciarSessaoProfissional(String email, String password){
        Profissional pro = pesquisarProfissional(email);
        if(pro != null){
            if(pro.getPassword().equals(password)){
                return pro;
            }
        }
        return null;
    }

    public Admin iniciarSessaoAdmin(String email, String password, String codigo){
        Admin admin = pesquisarAdmin(email, codigo);
        if(admin != null){
            if(admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }

    public void registarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void registarProfissional(Profissional pro){
        profissionais.add(pro);
    }

    public void registarAdmin(Admin admin){
        admins.add(admin);
    }

    public Cliente pesquisarCliente(String email){
        for(Cliente cli : clientes){
            if(cli.getEmail().equals(email)){
                return cli;
            }
        }
        return null;
    }

    public Profissional pesquisarProfissional(String email){
        for(Profissional pro : profissionais){
            if(pro.getEmail().equals(email)){
                return pro;
            }
        }

        return null;
    }

    public Admin pesquisarAdmin(String email, String codigo){
        for(Admin admin : admins){
            if(admin.getEmail().equals(email) && admin.getCodigo().equals(codigo)){
                return admin;
            }
        }

        return null;
    }

    public Admin pesquisaAdminApenasEmail(String email){
        for(Admin admin : admins){
            if(admin.getEmail().equals(email)){
                return admin;
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
        newSol.setId(UUID.randomUUID());
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
            System.out.println("Não existem solicitações registadas.");
        } else{
            System.out.println("-".repeat(120));
            for(Solicitacao sol : solicitacoes){
                System.out.println("\n" + sol.toString() + "\n---------------------\n");
            }
        }
    }

    public void consultarSoliticacoes(Cliente cliente){
        if(cliente.getSolicitacoes().isEmpty()){
            System.out.println("Este cliente não possui solicitações.");
        } else{
            for(Solicitacao sol : cliente.getSolicitacoes()){
                System.out.println("\n" + sol.toString() + "\n---------------------\n");
            }
        }
    }

    public void consultarSoliticacoes(Profissional pro){
        if(pro.getSolicitacoes().isEmpty()){
            System.out.println("Este profissional não possui solicitações.");
        } else{
            for(Solicitacao sol : pro.getSolicitacoes()){
                System.out.println("\n" + sol.toString() + "\n---------------------\n");
            }
        }
    }
}
