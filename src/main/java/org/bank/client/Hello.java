package org.bank.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String sayHelloClient() throws RemoteException;
    String sayHelloModel() throws RemoteException;

    String userLogin(int id) throws RemoteException;
}
