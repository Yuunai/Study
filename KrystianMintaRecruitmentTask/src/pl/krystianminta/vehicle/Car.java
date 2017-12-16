package pl.krystianminta.vehicle;

public class Car implements Vehicle {

    public static final int PRICE = 1000;

    public Car() throws InterruptedException {
        System.out.println("Car creation in progress...");
        Thread.sleep(10000);
        System.out.println("Vroom, vroom! Car production done.");
    }

    public int getPrice() {
        return PRICE;
    }

}
