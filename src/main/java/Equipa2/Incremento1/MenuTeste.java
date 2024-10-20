package Equipa2.Incremento1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuTeste {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Gere gere = new Gere();

        Cliente cliente = new Cliente("Alykhan", "alyjamal77@gmail.com", "aly", "boavista", MetodoPagamento.MBWAY);
        Profissional pro = new Profissional("Divaldo", "divaldodias@gmail.com", "divas", "lousada", "Pintura", 3, 10, MetodoPagamento.MBWAY);
        Profissional pro2 = new Profissional("Lays", "layslimasantos@gmail.com", "linda", "studyou", "Limpeza", 1, 15, MetodoPagamento.BOLETO_BANCARIO);

        // gere.registarCliente(cliente);
        gere.registarProfissional(pro);
        gere.registarProfissional(pro2);

        // gere.adicionarServico(pro, "Pintura", "Pintura em casas (somente parte interna)", "15:30 28-10-2024");

        // System.out.println(pro.getServicos().getLast().getDescricao());

        // gere.solicitarServico(cliente, pro, cliente.getMorada(), "15:30 28-10-2024");
        // gere.imprimirTodasSolicitacao();

        // UUID idUltima = gere.ultimaSolicitacao().getId();
        // System.out.println(idUltima);
        // gere.cancelarSolicitacao(idUltima);
        // gere.imprimirTodasSolicitacao();
        
        int option;
        int optionServico;

        // ---------------------------------------------------------------------------------------------------
        // MenuProfissional

        // // // do{
        // // //     System.out.println("All Around - Profissional:");
        // // //     System.out.println("1) Adicionar serviço");
        // // //     System.out.println("2) Consultar solicitações");
        // // //     System.out.println("0) Encerrar programa");
        // // //     option = input.nextInt();
        // // //     input.nextLine();
        // // // }while(option < 0 || option > 2);

        // // // while(option != 0){

        // // //     switch(option){
        // // //         case 1:
        // // //             do{
        // // //                 System.out.println("Selecione um serviço a ser adicionado: ");
        // // //                 gere.consultarServicosDisponiveis();
        // // //                 optionServico = input.nextInt();
        // // //                 input.nextLine();
        // // //             }while(optionServico < 1 || optionServico > gere.servicos.size());

        // // //             String descricao;
        // // //             do{
        // // //                 System.out.println("Descrição do serviço: ");
        // // //                 descricao = input.nextLine();
        // // //             } while(descricao.trim().isEmpty());

        // // //             Double valorHora;
        // // //             do{
        // // //                 System.out.println("Valor da hora: ");
        // // //                 valorHora = input.nextDouble();
        // // //                 input.nextLine();
        // // //             } while(valorHora < 0);

                    gere.adicionarServico(pro, gere.servicos.get(1), "descricao", 15.0, LocalDateTime.now());
                    gere.adicionarServico(pro, gere.servicos.get(0), "descricao", 20.0, LocalDateTime.now());
                    gere.adicionarServico(pro2, gere.servicos.get(0), "descricao lays limpeza", 17.0, LocalDateTime.now());
        // // //             break;
        // // //     }

        // // //     do{
        // // //         System.out.println("All Around - Profissional:");
        // // //         System.out.println("1) Adicionar serviço");
        // // //         System.out.println("2) Consultar solicitações");
        // // //         System.out.println("0) Encerrar programa");
        // // //         option = input.nextInt();
        // // //         input.nextLine();
        // // //     }while(option < 0 || option > 2);
        // // // }

        // ---------------------------------------------------------------------------------------------------
        // MenuCliente

        do{
            System.out.println("All Around - Cliente:");
            System.out.println("1) Solicitar serviço");
            System.out.println("2) Consultar solicitações");
            System.out.println("0) Encerrar programa");
            option = input.nextInt();
            input.nextLine();
        }while(option < 0 || option > 2);

        while(option != 0){

            switch (option) {
                case 1:
                String servicoFiltro;
                    do{
                        System.out.println("Escolha o tipo de serviço que deseja:");
                        gere.consultarServicosDisponiveis();
                        optionServico = input.nextInt();
                        input.nextLine();
                    } while(option < 1 || option > gere.servicos.size());

                    servicoFiltro = gere.servicos.get(optionServico-1);

                    int optionPro;
                    List<Servico> listaFiltrada;
                    do{
                        System.out.println("Escolha um profissional que satisfaça a sua necessidade:");
                        listaFiltrada = gere.consultarProfissionalPorServico(servicoFiltro);
                        for(Servico serv : listaFiltrada){
                            System.out.println((listaFiltrada.indexOf(serv)+1) + ") " + serv.getProfissional().getNome() + " - " + serv.getTitulo() + "(" + serv.getDescricao() +") - " + serv.getValorHora() + '€');
                        }
                        optionPro = input.nextInt();
                        input.nextLine();
                    } while(optionPro < 1 || optionPro > listaFiltrada.size());

                    String stringData;
                    String stringHora;
                    String regexData = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$";
                    String regexHora = "^([01][0-9]|2[0-3]):([0-5][0-9])$";
                    Pattern pattern;
                    Matcher matcher;
                    do{
                        System.out.print("Informe a data que deseja que o serviço seja realizado (dd-MM-aaaa):");
                        stringData = input.nextLine();
                        pattern = Pattern.compile(regexData);
                        matcher = pattern.matcher(stringData);
                    }while(!matcher.matches());

                    do {
                        System.out.println("Qual horário deseja que o serviço seja realizado (HH:mm): ");
                        stringHora = input.nextLine();
                        pattern = Pattern.compile(regexHora);
                        matcher = pattern.matcher(stringHora);
                    } while(!matcher.matches());

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

                    LocalDateTime date = LocalDateTime.parse(stringData + " " + stringHora, dtf);

                    gere.solicitarServico(cliente, listaFiltrada.get(optionPro-1).getProfissional(), date);
                    break;
            
                case 2:
                    gere.consultarSoliticacoes(cliente);
                    break;
            }



            do{
                System.out.println("All Around - Cliente:");
                System.out.println("1) Solicitar serviço");
                System.out.println("2) Consultar solicitações");
                System.out.println("0) Encerrar programa");
                option = input.nextInt();
                input.nextLine();
            }while(option < 0 || option > 2);
        }




        System.out.println(cliente.getSolicitacoes().getLast());
        System.out.println(pro.getSolicitacoes().getLast());
        input.close();
    }
}
