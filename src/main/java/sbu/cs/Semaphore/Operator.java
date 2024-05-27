package sbu.cs.Semaphore;

import java.time.LocalTime;
import java.util.concurrent.Semaphore;

public class Operator extends Thread {

    Semaphore semaphore;
    public Operator(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10; i++)
        {
            // critical section - a Maximum of 2 operators can access the resource concurrently
            Resource.accessResource();
            System.out.println(Thread.currentThread().getName() + " " + LocalTime.now());
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        semaphore.release();
    }
}
