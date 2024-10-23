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

    private GereDados gereDados = new GereDados();

    List<String> servicos = new ArrayList<>(){{
        add("Limpeza");
        add("Pintura");
    }};

    public Gere(){
        clientes = gereDados.lerTodosClientes();
        profissionais = gereDados.lerTodosProfissionais();
        solicitacoes = gereDados.lerTodasSolicitacoes();
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

    public Admin iniciarSessaoAdmin(String email, String password) {
        Admin admin = pesquisaAdminApenasEmail(email);
        if (admin != null) {
            if (admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }

    public void registarCliente(Cliente cliente){
        clientes.add(cliente);
        gereDados.inserir(cliente);
    }

    public void registarProfissional(Profissional pro){
        profissionais.add(pro);
        gereDados.inserir(pro);
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

    public Admin pesquisarAdmin(UUID id){
        for(Admin admin : admins){
            if(admin.getId().equals(id)){
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

    public void consultarClientes(){
        if(clientes.isEmpty()){
            System.out.println("Não existem clientes registados.");
        } else{
            for(Cliente cli : clientes){
                System.out.println("-".repeat(20));
                System.out.println(cli.toString());
                System.out.println("-".repeat(20));
            }
        }
    }

    public void removerCliente(Cliente cliente){
        clientes.remove(cliente);
    }

    public void consultarProfissionais(){
        if(profissionais.isEmpty()){
            System.out.println("Não existem profissionais registados.");
        } else{
            for(Profissional pro : profissionais){
                System.out.println("-".repeat(20));
                System.out.println(pro.toString());
                System.out.println("-".repeat(20));
            }
        }
    }

    public void removerProfissional(Profissional pro){
        profissionais.remove(pro);
    }

    public void consultarAdmins(){
        if(admins.isEmpty()){
            System.out.println("Não existem admins registados.");
        } else{
            for(Admin admin : admins){
                System.out.println("-".repeat(20));
                System.out.println(admin.toString());
                System.out.println("-".repeat(20));
            }
        }
    }

    public void removerAdmin(Admin admin){
        admins.remove(admin);
    }

    public void consultarSolicitacoes(){
        if(solicitacoes.isEmpty()){
            System.out.println("Não existem solicitações registadas.");
        } else{
            for(Solicitacao sol : solicitacoes){
                System.out.println("-".repeat(20));
                System.out.println(sol.toString());
                System.out.println("-".repeat(20));
            }
        }
    }


    public void consultarServicosDisponiveis(){
        for(String serv : servicos){
            System.out.println((servicos.indexOf(serv) + 1) + ") " + serv);
        }
    }

    public void consultarClientes(){
        if(clientes.isEmpty()){
            System.out.println("Não existem clientes registados.");
        } else{
            for(Cliente cli : clientes){
                System.out.println("-".repeat(20));
                System.out.println(cli.toString());
                System.out.println("-".repeat(20));
            }
        }
    }
    
    public void removerCliente(Cliente cliente){
        clientes.remove(cliente);
    }
    
    public void consultarProfissionais(){
        if(profissionais.isEmpty()){
            System.out.println("Não existem profissionais registados.");
        } else{
            for(Profissional pro : profissionais){
                System.out.println("-".repeat(20));
                System.out.println(pro.toString());
                System.out.println("-".repeat(20));
            }
        }
    }
    
    public void removerProfissional(Profissional pro){
        profissionais.remove(pro);
    }

    public void consultarAdmins(){
        if(admins.isEmpty()){
            System.out.println("Não existem admins registados.");
        } else{
            for(Admin admin : admins){
                System.out.println("-".repeat(20));
                System.out.println(admin.toString());
                System.out.println("-".repeat(20));
            }
        }
    }

    public void removerAdmin(Admin admin){
        admins.remove(admin);
    }

    public void consultarSolicitacoes(){
        if(solicitacoes.isEmpty()){
            System.out.println("Não existem solicitações registadas.");
        } else{
            for(Solicitacao sol : solicitacoes){
                System.out.println("-".repeat(20));
                System.out.println(sol.toString());
                System.out.println("-".repeat(20));
            }
        }
    }

    public List<Servico> consultarProfissionalPorServico(String servico){
        List<Servico> lista = new ArrayList<>();
        for(Profissional pro : profissionais){
            for(Servico serv : gereDados.lerServicos(pro.getId())){
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

        // newSol.setCliente(cliente);
        // newSol.setProfissional(profissional);
        
        gereDados.inserirSolicitacao(cliente, profissional, newSol);

        // solicitacoes.add(newSol);
        // cliente.getSolicitacoes().add(newSol);
        // profissional.getSolicitacoes().add(newSol);
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

        // pro.getServicos().add(newServico);
        newServico.setProfissional(pro);
        gereDados.inserirServico(pro, newServico);
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
            System.out.println("Este profissional não possui solicitações");
        } else{
            for(Solicitacao sol : pro.getSolicitacoes()){
                System.out.println("\n" + sol.toString() + "\n---------------------\n");
            }
        }
    }
}