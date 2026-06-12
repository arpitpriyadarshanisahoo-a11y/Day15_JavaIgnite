class Theater {
    private int totalSeats = 5;

    public synchronized void bookSeat(int seats) {
        if (totalSeats >= seats) {
            System.out.println(Thread.currentThread().getName() + " Booking Successful");
            totalSeats = totalSeats - seats;
            System.out.println("Remaining Seats = " + totalSeats);
        } else {
            System.out.println(Thread.currentThread().getName() + " Booking Failed");
        }
    }
}

class BookingThread extends Thread {
    private Theater theater;
    private int seatsRequired;

    public BookingThread(Theater theater, int seatsRequired, String threadName) {
        this.theater = theater;
        this.seatsRequired = seatsRequired;
        setName(threadName);
    }

    @Override
    public void run() {
        theater.bookSeat(seatsRequired);
    }
}


public class Main3 {
	public static void main(String[] args) {

        Theater theater = new Theater();

        BookingThread t1 = new BookingThread(theater, 2, "Thread1");
        BookingThread t2 = new BookingThread(theater, 2, "Thread2");
        BookingThread t3 = new BookingThread(theater, 2, "Thread3");

        t1.start();
        t2.start();
        t3.start();
    }

}
