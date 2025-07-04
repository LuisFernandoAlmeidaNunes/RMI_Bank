package org.bank.client;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {

    public Server() {}

    /* ======================== Funcoes implementadas pelo servidor ======================== */

    public String sayHelloClient() {
        System.out.println("Cliente atendido");
        return "Cliente Conectado";
    }

    public String sayHelloModel() {
        System.out.println("Model atendido");
        return "Hi Lorena";
    }

    public String userLogin(int id) {
        System.out.println("Model atendido");
        return "Hi Lorena";
    }

    public static void main(String args[]) {
        System.setProperty("java.rmi.server.hostname", "127.0.0.1");

        try {
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("rmi://localhost/server", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}