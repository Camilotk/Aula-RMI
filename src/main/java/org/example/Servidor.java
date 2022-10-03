package org.example;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor implements iOlaMundo{
    public static void main(String[] args) {
        try {
            Registry servidorRegistro = LocateRegistry.createRegistry(1099);
            Servidor servidor = new Servidor();
            iOlaMundo skeleton = (iOlaMundo) UnicastRemoteObject.exportObject(servidor, 0);
            servidorRegistro.rebind("olarmi", skeleton);
            System.out.println("Servidor pronto para conexões!");
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
    @Override
    public String olaMundo() throws RemoteException {
        return "Olá mundo RMI";
    }
}
