package rmiTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class RmiClient {
    public static void main(String args[]) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Task task = new Task();
        int countOperand = 1;


        task.firstOperand = getOpand(bufferedReader, countOperand++);

        task.secondOperand = getOpand(bufferedReader, countOperand++);


        String resultString = new String();
        while (true) {
            System.out.println("Введите 1 из допустимых символов (+,-,*,/)");
            task.typeOfOperation = bufferedReader.readLine();


            RmiServerIntf obj = (RmiServerIntf) Naming.lookup("//localhost/RmiServer");


            resultString = obj.executeTask(task);
            if (!"Введите 1 из арифметических операторов (+,-,*,/)".equals(resultString)) {
                System.out.println("Ответ на ваш запрос: " + resultString);
                break;
            }

        }

    }

    private static double getOpand(BufferedReader bufferedReader, int countOperand) throws IOException {

        double temp;
        while (true) {
            try {
                System.out.println("введите " + countOperand + " операнд");
                temp = Double.parseDouble(bufferedReader.readLine());

                break;
            } catch (NumberFormatException e) {

                System.out.println("В качестве операндов принимаются лишь Вещественные Цифвры");
            }

        }
        return temp;

    }
}