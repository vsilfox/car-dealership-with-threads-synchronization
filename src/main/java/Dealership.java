import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private static final int TIME_OF_TAKING_DELIVERY = 2000;
    private final List<Car> cars;

    public Dealership() {
        this.cars = new ArrayList<>();
    }

    public synchronized void takeCarDelivery(Car car) {
        System.out.println("Dealer is taking a delivery...");
        try {
            Thread.sleep(TIME_OF_TAKING_DELIVERY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cars.add(car);
        System.out.println("A new car is in the dealership!");
        notify();
    }

    public synchronized Car sellCar() {
        while (cars.size() == 0) {
            System.out.println("There are no cars!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Selling a car...");
        return cars.remove(0);
    }
}
