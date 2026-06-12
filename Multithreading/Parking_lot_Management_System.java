
   class ParkingLot {
    private int availableSlots = 3;

    public synchronized void parkCar(String carName) {
        if (availableSlots > 0) {
            System.out.println(carName + " Parked");
            availableSlots--;
            System.out.println("Available Slots: " + availableSlots);
        } else {
            System.out.println("No Parking Available for " + carName);
        }
    }
}

class CarThread extends Thread {
    private ParkingLot parkingLot;
    private String carName;

    public CarThread(ParkingLot parkingLot, String carName) {
        this.parkingLot = parkingLot;
        this.carName = carName;
    }

    @Override
    public void run() {
        parkingLot.parkCar(carName);
    }
}

public class Main2 {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot();

        CarThread car1 = new CarThread(parkingLot, "Car 1");
        CarThread car2 = new CarThread(parkingLot, "Car 2");
        CarThread car3 = new CarThread(parkingLot, "Car 3");
        CarThread car4 = new CarThread(parkingLot, "Car 4");
        CarThread car5 = new CarThread(parkingLot, "Car 5");
        CarThread car6 = new CarThread(parkingLot, "Car 6");

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
    }

}
