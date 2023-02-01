package petrolStation;

import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) {
        PetrolStation petrol = new PetrolStation();
        Semaphore semaphore = new Semaphore(3, true);

        new Thread(new PetrolThread(petrol, semaphore, 50)).start();
        new Thread(new PetrolThread(petrol, semaphore, 100)).start();
        new Thread(new PetrolThread(petrol, semaphore, 150)).start();
    }
}
