public class Supplier implements Runnable {
    private static final int TIME_OF_ASSEMBLING = 5000;
    private static final int TARGET_CARS_NUMBER = 10;
    private final String name;
    private final Dealership dealership;

    public Supplier(String name, Dealership dealer) {
        this.name = name;
        this.dealership = dealer;
    }

    @Override
    public synchronized void run() {

        for (int i = 0; i < TARGET_CARS_NUMBER; i++) {
            try {
                Thread.sleep(TIME_OF_ASSEMBLING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Car car = new Car(name);
            System.out.println("Supplier assembled a new car");
            dealership.takeCarDelivery(car);
        }
    }
}
