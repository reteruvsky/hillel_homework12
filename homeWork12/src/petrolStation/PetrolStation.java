package petrolStation;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PetrolStation {
    AtomicInteger amount = new AtomicInteger(10000);
    public static ExecutorService executor = Executors.newFixedThreadPool(3);

    public synchronized void doRefuel(float requestedFuel) {
        executor.execute(() -> {
            try {
                Thread.sleep(3000 + new Random().nextInt(7000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (amount.floatValue() >= requestedFuel) {
                fuelSubtraction(amount, requestedFuel);
            } else {
                System.out.println("Sorry! We are out of fuel. Current fuel is: " + amount);
            }
        });
    }

    public static synchronized void fuelSubtraction(AtomicInteger amount, float requestedFuel) {
        amount.addAndGet((int) -requestedFuel);
    }
}


