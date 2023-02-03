package petrolStation;

public class App {
    public static void main(String[] args) throws InterruptedException {
        PetrolStation petrolStation = new PetrolStation();

        petrolStation.doRefuel(10000);
        petrolStation.doRefuel(35);
        petrolStation.doRefuel(35);
        petrolStation.doRefuel(35);
        petrolStation.doRefuel(35);

        PetrolStation.executor.shutdown();

        Thread.sleep(35000);
        System.out.println("Remaining fuel at the station: " + petrolStation.amount + " liters");
    }
}
