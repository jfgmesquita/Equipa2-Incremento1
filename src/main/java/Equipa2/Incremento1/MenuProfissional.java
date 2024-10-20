package Equipa2.Incremento1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuProfissional {
    public static void main(Profissional pro, Gere gere){

        Scanner input = new Scanner(System.in);

        int option;
        int optionServico;

        do{
            System.out.println("--------------------");
            System.out.println("1) Adicionar serviço");
            System.out.println("2) Consultar solicitações");
            System.out.println("0) Logout");
            System.out.println("--------------------");
            option = input.nextInt();
            input.nextLine();
        }while(option < 0 || option > 2);

        while(option != 0){

            switch(option){
                case 1:
                    do{
                        System.out.println("Selecione um serviço a ser adicionado: ");
                        gere.consultarServicosDisponiveis();
                        optionServico = input.nextInt();
                        input.nextLine();
                    }while(optionServico < 1 || optionServico > gere.servicos.size());

                    String descricao;
                    do{
                        System.out.println("Descrição do serviço: ");
                        descricao = input.nextLine();
                    } while(descricao.trim().isEmpty());

                    Double valorHora;
                    do{
                        System.out.println("Valor da hora: ");
                        valorHora = input.nextDouble();
                        input.nextLine();
                    } while(valorHora < 0);

                    gere.adicionarServico(pro, gere.servicos.get(optionServico-1), descricao, valorHora, LocalDateTime.now());
                    break;
                case 2:
                gere.consultarSoliticacoes(pro);
                break;
            }

            do{
                System.out.println("--------------------");
                System.out.println("1) Adicionar serviço");
                System.out.println("2) Consultar solicitações");
                System.out.println("0) Logout");
                System.out.println("--------------------");
                option = input.nextInt();
                input.nextLine();
            }while(option < 0 || option > 2);
        }
    }
}
