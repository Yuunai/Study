package pl.krystianminta.vehicle;

public class Truck implements Vehicle {

    public static final int PRICE = 2000;

    public Truck() throws InterruptedException {
        System.out.println("Truck creation in progress...");
        Thread.sleep(15000);
        System.out.println("Vroom, vroom! Truck production done.");
    }

    public int getPrice() {
        return PRICE;
    }

}
