package org.bank.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private Client() {}

    public void MenuExemplo(Hello stub) {

            Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner
            String opcao;

            do {
                // Exibe o menu
                System.out.println("--- Menu Principal ---");
                System.out.println("1. Realizar login");
                System.out.println("2. Opção Dois");
                System.out.println("3. Opção Três");
                System.out.println("----------------------");
                System.out.println("Digite '0' para sair.");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextLine(); // Lê a linha de entrada do usuário

                // Processa a opção
                switch (opcao.toLowerCase()) { // Converte para minúsculas para aceitar "Quit", "QUIT", etc.
                    case "1":
                        System.out.println("Realizar login: \n digite seu id");
                        opcao = scanner.nextLine();

                        stub.login();

                        break;
                    case "2":
                        System.out.println("Você escolheu a Opção Dois.");
                        // Chame seu método ou lógica para a Opção Dois aqui
                        break;
                    case "3":
                        System.out.println("Você escolheu a Opção Três.");
                        // Chame seu método ou lógica para a Opção Três aqui
                        break;
                    case "0":
                        System.out.println("Saindo do menu. Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                        break;
                }
                System.out.println(); // Pula uma linha para melhor legibilidade
            } while (!opcao.equalsIgnoreCase("0")); // Continua o loop até que a opção seja "0"

            scanner.close(); // Fecha o scanner para liberar recursos
    
    }

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            // define para o user onde o servidor de nomes esta hospedado
            Registry registry = LocateRegistry.getRegistry(host, 1099);
            Hello stub = (Hello) registry.lookup("rmi://localhost/server");

            String response = stub.sayHelloClient();

            System.out.println("response: " + response);

            Client client = new Client();

            client.MenuExemplo(stub);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }



    }
}