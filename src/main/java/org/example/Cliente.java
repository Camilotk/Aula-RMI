package org.example;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            Registry servidorRegistro = LocateRegistry.getRegistry("127.0.0.1", 1099);
            iOlaMundo stub = (iOlaMundo) servidorRegistro.lookup("olarmi");
            System.out.println("Acessando o servidor remoto... ");
            System.out.println(stub.olaMundo());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
