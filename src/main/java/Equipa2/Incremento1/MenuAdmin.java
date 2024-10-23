package Equipa2.Incremento1;

import java.util.Scanner;

public class MenuAdmin {
    public static void main(Admin admin, Gere gere) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu Admin:");

        int opcao = -1;
        while(opcao != 0) {
            System.out.println("-".repeat(20));
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Registar administrador");
            System.out.println("2 - Consultar clientes");
            System.out.println("3 - Remover clientes");
            System.out.println("4 - Consultar profissionais");
            System.out.println("5 - Remover profissionais");
            System.out.println("6 - Consultar admins");
            System.out.println("7 - Remover admins");
            System.out.println("8 - Consultar Solicitações");
            System.out.println("9 - Consultar Serviços");
            System.out.println("0 - Sair");
            System.out.println("-".repeat(20));
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                scanner.nextLine();   
            }

            switch (opcao) {
                case 0:
                    System.out.println("A sair...");
                    break;

                case 1:
                    String nome;
                    do {
                        System.out.print("Nome:");
                        nome = scanner.nextLine();
                    } while(nome.isEmpty());

                    String email;
                    do {
                        System.out.print("Email:");
                        email = scanner.nextLine();
                    } while(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"));

                    String password;
                    do {
                        System.out.print("Password com, pelos menos, 8 caracteres, 1 letra maiúscula e 1 carácter especial:");
                        password = scanner.nextLine();
                    } while(password.length() < 8 || !password.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*]).+$"));

                    String morada;
                    do {
                        System.out.print("Morada:");
                        morada = scanner.nextLine();
                    } while(morada.isEmpty());

                    String codigo;
                    do {
                        System.out.print("Código de pelo menos 5 caracteres:");
                        codigo = scanner.nextLine();
                    } while(codigo.isEmpty() || codigo.length() < 5);

                    Admin novoAdmin = new Admin(nome, email, password, morada, UserType.ADMINISTRADOR, codigo);
                    gere.registarAdmin(novoAdmin);
                    System.out.println("Admin registado com sucesso!");

                case 2:
                    System.out.println("Clientes:");
                    gere.consultarClientes();
                    break;

                case 3:
                    System.out.println("Remover Cliente:");
                    String emailCliente;
                    do {
                        System.out.println("Email do cliente a remover:");
                        emailCliente = scanner.nextLine();
                    } while(!emailCliente.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"));
                    Cliente cliente = gere.pesquisarCliente(emailCliente);
                    if(cliente != null) {
                        gere.removerCliente(cliente);
                        System.out.println("Cliente removido com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Profissionais:");
                    gere.consultarProfissionais();
                    break;

                case 5:
                    System.out.println("Remover Profissional:");
                    String emailProfissional;
                    do {
                        System.out.println("Email do profissional a remover:");
                        emailProfissional = scanner.nextLine();
                    } while(!emailProfissional.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"));
                    Profissional profissional = gere.pesquisarProfissional(emailProfissional);
                    if(profissional != null) {
                        gere.removerProfissional(profissional);
                        System.out.println("Profissional removido com sucesso!");
                    } else {
                        System.out.println("Profissional não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Admins:");
                    gere.consultarAdmins();
                    break;

                case 7:
                    System.out.println("Remover Admin:");
                    String emailAdmin;
                    do {
                        System.out.println("Email do admin a remover:");
                        emailAdmin = scanner.nextLine();
                    } while(!emailAdmin.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"));
                    Admin adminARemover = gere.pesquisaAdminApenasEmail(emailAdmin);
                    if(adminARemover != null) {
                        gere.removerAdmin(adminARemover);
                        System.out.println("Admin removido com sucesso!");
                    } else {
                        System.out.println("Admin não encontrado.");
                    }
                    break;

                case 8:
                    System.out.println("Solicitações:");
                    gere.consultarSolicitacoes();
                    break;

                case 9:
                    System.out.println("Serviços:");
                    gere.consultarServicosDisponiveis();
                    break;
            }
        }
    }
}