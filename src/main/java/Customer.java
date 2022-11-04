public class Customer implements Runnable {
    private static final int TIME_OF_BUYING = 3000;
    private final Dealership dealer;

    public Customer(Dealership dealer) {
        this.dealer = dealer;
    }

    @Override
    public void run() {
        System.out.printf("Customer %s want to buy a car\n", Thread.currentThread().getName());
        try {
            Thread.sleep(TIME_OF_BUYING);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Car car = dealer.sellCar();
        System.out.printf("Customer %s got a new %s\n", Thread.currentThread().getName(), car.getName());
    }
}
