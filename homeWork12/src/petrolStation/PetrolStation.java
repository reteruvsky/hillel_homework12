package petrolStation;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PetrolStation {
    public static volatile float amount = 10000;
    AtomicInteger atomicInteger = new AtomicInteger(10000);
    private static volatile Boolean mutex = true;
    public static ExecutorService executor = Executors.newFixedThreadPool(3);

    public void doRefuel(float requestedFuel)  {
        synchronized (mutex) {
            executor.execute(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atomicInteger.addAndGet((int) -requestedFuel);
            });
        }
    }
}


