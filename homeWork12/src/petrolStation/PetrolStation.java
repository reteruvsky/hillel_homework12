package petrolStation;

import java.util.concurrent.Semaphore;

public class PetrolStation {
    public static volatile double amount = 10000;
    private static volatile Boolean mutex = true;

    public void doRefuel(float requestFuel) throws InterruptedException {
        synchronized (mutex) {
            if (amount >= requestFuel) {
                Thread.sleep(5000);
                amount -= requestFuel;
            } else {
                System.out.println("Sorry! We are out of fuel.");
            }
        }

        System.out.println(amount);
    }
}

class PetrolThread implements Runnable {
    PetrolStation petrol;
    Semaphore semaphore;
    float requestFuel;

    PetrolThread(PetrolStation petrol, Semaphore semaphore, float requestFuel) {
        this.petrol = petrol;
        this.semaphore = semaphore;
        this.requestFuel = requestFuel;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            petrol.doRefuel(requestFuel);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore.release();
    }
}
