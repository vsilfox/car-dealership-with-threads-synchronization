import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static final int NUMBER_OF_CUSTOMERS = 10;
    public static final int MAX_CUSTOMERS_TIME_INTERVAL = 20000;

    public static void main(String[] args) {

        final Dealership dealership = new Dealership();
        final Thread dealerThread = new Thread(new Supplier("KIA", dealership));
        dealerThread.start();

        final ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_CUSTOMERS);
        for (int i = 0; i < NUMBER_OF_CUSTOMERS; i++) {
            executorService.submit(new Customer(dealership));
            try {
                Thread.sleep(Math.round(Math.random() * MAX_CUSTOMERS_TIME_INTERVAL));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
