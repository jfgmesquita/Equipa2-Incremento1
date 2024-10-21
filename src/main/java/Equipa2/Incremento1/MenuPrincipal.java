package Equipa2.Incremento1;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gere gere = new Gere();

        System.out.println("Bem-vindo à aplicação All Around: Pede um Serviço!");
        
        int opcao = -1;
        while(opcao != 0) {
            System.out.println("--------------------");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Registar");
            System.out.println("2 - Iniciar sessão");
            System.out.println("0 - Sair");
            System.out.println("--------------------");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                scanner.nextLine();   
            }

            switch(opcao) {
                case 0:
                    System.out.println("A sair...");
                    break;

                case 1:
                    int opcaoRegisto = -1;
                    while(opcaoRegisto != 0) {
                        System.out.println("--------------------");
                        System.out.println("Escolha o tipo de registo:");
                        System.out.println("1 - Registar Cliente");
                        System.out.println("2 - Registar Profissional");
                        System.out.println("0 - Voltar");
                        System.out.println("--------------------");
                        try {
                            opcaoRegisto = scanner.nextInt();
                            scanner.nextLine();
                        } catch (Exception e) {
                            scanner.nextLine();   
                        }

                        switch(opcaoRegisto) {
                            case 0:
                                System.out.println("A voltar...");
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

                                MetodoPagamento metodoPagamentoC = null;
                                do {
                                    System.out.println("Escolha um método de pagamento:");
                                    MetodoPagamento[] metodos = MetodoPagamento.values();
                                    for (int i = 0; i < metodos.length; i++) {
                                        System.out.println((i + 1) + " - " + metodos[i]);
                                    }
                                    int escolha = scanner.nextInt();
                                    scanner.nextLine();
                                    if (escolha > 0 && escolha <= metodos.length) {
                                        metodoPagamentoC = metodos[escolha - 1];
                                    } else {
                                        System.out.println("Opção inválida.");
                                    }
                                } while (metodoPagamentoC == null);

                                Cliente cliente = new Cliente(nome, email, password, morada, metodoPagamentoC);
                                gere.registarCliente(cliente);
                                System.out.println("Cliente registado com sucesso.");
                                break;

                            case 2:
                                String nomep;
                                do {
                                    System.out.print("Nome:");
                                    nomep = scanner.nextLine();
                                } while(nomep.isEmpty());

                                String emailp;
                                do {
                                    System.out.print("Email:");
                                    emailp = scanner.nextLine();
                                } while(!emailp.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"));

                                String passwordp;
                                do {
                                    System.out.print("Password com, pelos menos, 8 caracteres, 1 letra maiúscula e 1 carácter especial:");
                                    passwordp = scanner.nextLine();
                                } while(passwordp.length() < 8 || !passwordp.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*]).+$"));

                                String moradap;
                                do {
                                    System.out.print("Morada:");
                                    moradap = scanner.nextLine();
                                } while(moradap.isEmpty());
                                
                                String especialidade;
                                do {
                                    System.out.print("Especialidade:");
                                    especialidade = scanner.nextLine();
                                } while(especialidade.isEmpty());
                                
                                int experiencia = -1;
                                do {
                                    System.out.print("Experiência em anos:");
                                    try {
                                        experiencia = scanner.nextInt();
                                        scanner.nextLine();
                                    } catch (Exception e) {
                                        scanner.nextLine();
                                        experiencia = -1;
                                        System.out.println("Valor inválido.");
                                    }
                                } while(experiencia < 0);

                                MetodoPagamento metodoPagamentoProf = null;
                                do {
                                    System.out.println("Escolha um método de pagamento:");
                                    MetodoPagamento[] metodos = MetodoPagamento.values();
                                    for (int i = 0; i < metodos.length; i++) {
                                        System.out.println((i + 1) + " - " + metodos[i]);
                                    }
                                    int escolha = scanner.nextInt();
                                    scanner.nextLine();
                                    if (escolha > 0 && escolha <= metodos.length) {
                                        metodoPagamentoProf = metodos[escolha - 1];
                                    } else {
                                        System.out.println("Opção inválida.");
                                    }
                                } while (metodoPagamentoProf == null);

                                Profissional profissional = new Profissional(nomep, emailp, passwordp, moradap, especialidade, experiencia, metodoPagamentoProf);
                                gere.registarProfissional(profissional);
                                System.out.println("Profissional registado com sucesso.");
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                    }
                    break;

                case 2:
                    int opcaoSessao = -1;
                    while(opcaoSessao != 0) {
                        System.out.println("--------------------");
                        System.out.println("1 - Iniciar sessão como Cliente");
                        System.out.println("2 - Iniciar sessão como Profissional");
                        System.out.println("3 - Iniciar sessão como Administrador");
                        System.out.println("0 - Voltar");
                        System.out.println("--------------------");
                        try {
                            opcaoSessao = scanner.nextInt();
                            scanner.nextLine();
                        } catch (Exception e) {
                            scanner.nextLine();   
                        }

                        switch(opcaoSessao) {
                            case 0:
                                System.out.println("A voltar...");
                                break;

                            case 1:
                                if(gere.getClientes().isEmpty()) {
                                    System.out.println("Não existem clientes registados.");
                                } else {
                                    String email;
                                    do {
                                        System.out.println("Email:");
                                        email = scanner.nextLine();
                                    } while(email.isEmpty());

                                    String password;
                                    do {
                                        System.out.println("Password:");
                                        password = scanner.nextLine();
                                    } while(password.isEmpty());

                                    Cliente cliente = gere.iniciarSessaoCliente(email, password);
                                    if(cliente != null) {
                                        System.out.println("Sessão iniciada com sucesso.");
                                        MenuCliente.main(cliente, gere);
                                    } else {
                                        System.out.println("Email ou password incorretos.");
                                    }
                                }
                                break;

                            case 2:
                                if(gere.getProfissionais().isEmpty()) {
                                    System.out.println("Não existem profissionais registados.");
                                } else {
                                    String emailp;
                                    do {
                                        System.out.println("Email:");
                                        emailp = scanner.nextLine();
                                    } while(emailp.isEmpty());

                                    String passwordp;
                                    do {
                                        System.out.println("Password:");
                                        passwordp = scanner.nextLine();
                                    } while(passwordp.isEmpty());

                                    Profissional profissional = gere.iniciarSessaoProfissional(emailp, passwordp);
                                    if(profissional != null) {
                                        System.out.println("Sessão iniciada com sucesso.");
                                        MenuProfissional.main(profissional, gere);
                                    } else {
                                        System.out.println("Email ou password incorretos.");
                                    }
                                }
                                break;

                            case 3:
                                if(gere.getAdmins().isEmpty()) {
                                    System.out.println("Não existem administradores registados.");
                                } else {
                                    String emaila;
                                    do {
                                        System.out.println("Email:");
                                        emaila = scanner.nextLine();
                                    } while(emaila.isEmpty());

                                    String passworda;
                                    do {
                                        System.out.println("Password:");
                                        passworda = scanner.nextLine();
                                    } while(passworda.isEmpty());

                                    String codigo;
                                    do {
                                        System.out.println("Código:");
                                        codigo = scanner.nextLine();
                                    } while(codigo.isEmpty());
                                    
                                    // Admin admin = gere.iniciarSessaoAdmin(emaila, passworda, codigo);
                                    // if(admin != null) {
                                    //     System.out.println("Sessão iniciada com sucesso.");
                                    //     gere.menuAdministrador(admin); // Falta criar menu de administrador
                                    // } else {
                                    //     System.out.println("Email ou password incorretos.");
                                    // }
                                }
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                    }
                    break;
                
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        scanner.close();
    }
}