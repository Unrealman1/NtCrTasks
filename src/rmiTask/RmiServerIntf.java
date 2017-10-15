package rmiTask;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiServerIntf extends Remote {


    String executeTask(Task task) throws RemoteException;
}