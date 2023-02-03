package petrolStation;

public class App {
    public static void main(String[] args) throws InterruptedException {
        PetrolStation petrolStation = new PetrolStation();

        petrolStation.doRefuel(35);
        petrolStation.doRefuel(35);
        petrolStation.doRefuel(35);
        petrolStation.doRefuel(35);
        petrolStation.doRefuel(35);

        PetrolStation.executor.shutdown();

        Thread.sleep(12500);
        System.out.println("Remaining fuel at the station: " + petrolStation.atomicInteger + " liters");
    }
}
