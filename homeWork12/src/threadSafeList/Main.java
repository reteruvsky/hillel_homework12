package threadSafeList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(new ThreadListAdd(0, "String"));
        Thread two = new Thread(new ThreadListRemove(2));
        Thread three = new Thread(new ThreadListGet(5));

        one.start();
        one.join();

        two.start();
        two.join();

        three.start();
        three.join();
    }
}
