package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iOlaMundo  extends Remote {
    String olaMundo() throws RemoteException;
}
