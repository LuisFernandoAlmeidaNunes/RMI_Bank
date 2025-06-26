package org.bank.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Model {

    private Model() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            // define para o user onde o servidor de nomes esta hospedado
            Registry registry = LocateRegistry.getRegistry(host, 1099);
            Hello stub = (Hello) registry.lookup("rmi://localhost/server");
            String response = stub.sayHelloModel();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }



    }
}
