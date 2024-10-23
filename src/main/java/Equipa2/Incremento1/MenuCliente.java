package Equipa2.Incremento1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuCliente {
    public static void main(Cliente cliente, Gere gere) {

        Scanner input = new Scanner(System.in);

        int option;
        int optionServico;

        do {
            System.out.println("--------------------");
            System.out.println("1) Solicitar serviço");
            System.out.println("2) Consultar solicitações");
            System.out.println("3) Consultar serviços disponíveis");
            System.out.println("0) Sair");
            System.out.println("--------------------");
            option = input.nextInt();
            input.nextLine();
        } while (option < 0 || option > 3);

        while (option != 0) {

            switch (option) {
                case 1:
                    String servicoFiltro;
                    do {
                        System.out.println("Escolha o tipo de serviço que deseja:");
                        gere.consultarServicosDisponiveis();
                        optionServico = input.nextInt();
                        input.nextLine();
                    } while (optionServico < 1 || optionServico > gere.servicos.size());

                    servicoFiltro = gere.servicos.get(optionServico - 1);

                    int optionPro = 1;
                    List<Servico> listaFiltrada;
                    listaFiltrada = gere.consultarProfissionalPorServico(servicoFiltro);

                    if (listaFiltrada.isEmpty()) {
                        System.out.println("Não existem profissionais que façam esse tipo de serviço.");
                    } else {
                        do {

                            System.out.println("Escolha um profissional que satisfaça a sua necessidade:");
                            for (Servico serv : listaFiltrada) {
                                System.out.println((listaFiltrada.indexOf(serv) + 1) + ") "
                                        + serv.getProfissional().getNome() + " - " + serv.getTitulo() + "("
                                        + serv.getDescricao() + ") - " + serv.getValorHora() + " Euros");
                            }
                            optionPro = input.nextInt();
                            input.nextLine();

                        } while (optionPro < 1 || optionPro > listaFiltrada.size());

                        String stringData;
                        String stringHora;
                        String regexData = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$";
                        String regexHora = "^([01][0-9]|2[0-3]):([0-5][0-9])$";
                        Pattern pattern;
                        Matcher matcher;
                        do {
                            System.out.print("Informe a data que deseja que o serviço seja realizado (dd-MM-aaaa):");
                            stringData = input.nextLine();
                            pattern = Pattern.compile(regexData);
                            matcher = pattern.matcher(stringData);
                        } while (!matcher.matches());

                        do {
                            System.out.print("Em que horário deseja que o serviço seja realizado (HH:mm):");
                            stringHora = input.nextLine();
                            pattern = Pattern.compile(regexHora);
                            matcher = pattern.matcher(stringHora);
                        } while (!matcher.matches());

                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

                        LocalDateTime date = LocalDateTime.parse(stringData + " " + stringHora, dtf);

                        gere.solicitarServico(cliente, listaFiltrada.get(optionPro - 1).getProfissional(), date);
                    }

                    break;

                case 2:
                    gere.consultarSoliticacoes(cliente);
                    break;
                case 3:
                    do {
                        System.out.println("Escolha o tipo de serviço que deseja:");
                        gere.consultarServicosDisponiveis();
                        optionServico = input.nextInt();
                        input.nextLine();
                    } while (optionServico < 1 || optionServico > gere.servicos.size());

                    servicoFiltro = gere.servicos.get(optionServico - 1);

                    listaFiltrada = gere.consultarProfissionalPorServico(servicoFiltro);

                    if (listaFiltrada.isEmpty()) {
                        System.out.println("Não existem profissionais que façam esse tipo de serviço.");
                    } else {
                        for (Servico serv : listaFiltrada) {
                            System.out.println((listaFiltrada.indexOf(serv) + 1) + ") "
                                    + serv.getProfissional().getNome() + " - " + serv.getTitulo() + "("
                                    + serv.getDescricao() + ") - " + serv.getValorHora() + " Euros");
                        }
                    }
            }

            do {
                System.out.println("--------------------");
                System.out.println("1) Solicitar serviço");
                System.out.println("2) Consultar solicitações");
                System.out.println("3) Consultar serviços disponíveis");
                System.out.println("0) Sair");
                System.out.println("--------------------");
                option = input.nextInt();
                input.nextLine();
            } while (option < 0 || option > 3);
        }
    }
}
