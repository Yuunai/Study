package pl.krystianminta.factory;

import pl.krystianminta.vehicle.Car;
import pl.krystianminta.vehicle.Motorcycle;
import pl.krystianminta.vehicle.Truck;
import pl.krystianminta.vehicle.Vehicle;

import java.util.*;
import java.util.concurrent.Semaphore;

public class AbstractFactoryImpl implements AbstractFactory {

    private static final Semaphore SEMAPHORE = new Semaphore(3);
    private static volatile AbstractFactoryImpl instance = null;

    private AbstractFactoryImpl() {
    }

    public static AbstractFactoryImpl getInstance() {
        if(instance == null) {
            synchronized (AbstractFactoryImpl.class) {
                if(instance == null) {
                    instance = new AbstractFactoryImpl();
                }
            }
        }
        return instance;
    }

    public Vehicle getObject(String vehicleType) {
        try {
            switch (vehicleType.toLowerCase()) {
                case "car":
                    return new Car();

                case "truck":
                    return new Truck();

                case "motorcycle":
                    return new Motorcycle();

                default:
                    return null;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Factory made an error! Price for " + vehicleType + " will not be counted");
        }
    }

    @Override
    public List<Object> makeOrder(Queue<String> order) {

        List<Object> vehicles = new ArrayList<>();

        while(!order.isEmpty()) {
            final String vehicleType = order.poll();
            SEMAPHORE.acquireUninterruptibly();
            new Thread(() -> {
                try {
                    Vehicle vehicle = null;
                    if((vehicle = getObject(vehicleType)) != null) {
                        synchronized (vehicles) {
                            vehicles.add(vehicle);
                        }
                    } else {
                        System.out.println("Unknown vehicle type: " + vehicleType);
                    }
                    } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
                SEMAPHORE.release();
            }).start();
        }

        while(SEMAPHORE.availablePermits() != 3);

        return vehicles;
    }
}
