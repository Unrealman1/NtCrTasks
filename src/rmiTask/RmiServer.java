package rmiTask;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer extends UnicastRemoteObject implements RmiServerIntf {


    public RmiServer() throws RemoteException {
        super(0);    // required to avoid the 'rmic' step, see below on wiki
    }

    public String executeTask(Task task) {
        String result;

        switch (task.typeOfOperation) {
            case "+":
                result =task.firstOperand+ task.secondOperand+ "";
                break;
            case "*":
                result =task.firstOperand* task.secondOperand+ "";
                break;
            case "/":
                result =task.firstOperand/ task.secondOperand+ "";
                break;
            case "-":
                result =task.firstOperand- task.secondOperand+ "";
                break;
            default:
                result = "Введите 1 из арифметических операторов (+,-,*,/)";
                break;

        }
        return result;
    }

    public static void main(String args[]) throws Exception {
        System.out.println("RMI server started");

        try { //special exception handler for registry creation
            LocateRegistry.createRegistry(1099);
            System.out.println("java RMI registry created.");
        } catch (RemoteException e) {
            //do nothing, error means registry already exists
            System.out.println("java RMI registry already exists.");
        }

        //Instantiate RmiServer

        RmiServer obj = new RmiServer();

        // Bind this object instance to the name "RmiServer"
        Naming.rebind("//localhost/RmiServer", obj);
        System.out.println("PeerServer bound in registry");
    }
}