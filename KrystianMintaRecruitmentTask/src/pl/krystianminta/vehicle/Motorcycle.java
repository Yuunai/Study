package pl.krystianminta.vehicle;

public class Motorcycle implements Vehicle {

    private static final int PRICE = 600;

    public Motorcycle() throws InterruptedException {
        System.out.println("Motorcycle creation in progress...");
        Thread.sleep(5000);
        System.out.println("Vroom, vroom! Motorcycle production done.");
    }

    public int getPrice() {
        return PRICE;
    }

}
