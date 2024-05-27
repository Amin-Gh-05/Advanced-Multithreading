package sbu.cs.Semaphore;

import java.util.concurrent.Semaphore;

public class Controller {

    static Semaphore sem = new Semaphore(2);

    public static void main(String[] args) {
        Operator operator1 = new Operator("operator1", sem);
        Operator operator2 = new Operator("operator2", sem);
        Operator operator3 = new Operator("operator3", sem);
        Operator operator4 = new Operator("operator4", sem);
        Operator operator5 = new Operator("operator5", sem);

        operator1.start();
        operator2.start();
        operator3.start();
        operator4.start();
        operator5.start();
    }
}
