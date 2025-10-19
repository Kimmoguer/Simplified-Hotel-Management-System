// HotelService.java (Interface)
interface HotelService {
    void performService(); // Common method (can be overridden differently per service)
}

// Valet.java
class Valet implements HotelService {
    @Override
    public void performService() {
        System.out.println("Valet is ready to pick up or park a vehicle.");
    }

    public void pickUpVehicle(String plateNumber) {
        System.out.println("Valet is picking up vehicle with plate number: " + plateNumber);
    }
}

// HouseKeeping.java
class HouseKeeping implements HotelService {
    @Override
    public void performService() {
        System.out.println("Housekeeping is ready for room cleaning.");
    }

    public void cleanRoom(int roomNumber) {
        System.out.println("Housekeeping is cleaning room number: " + roomNumber);
    }
}

// Cart.java
class Cart implements HotelService {
    @Override
    public void performService() {
        System.out.println("Cart service is ready to deliver luggage carts.");
    }

    public void requestCart(int numberOfCarts) {
        System.out.println("Delivering " + numberOfCarts + " luggage cart(s) to the guest.");
    }
}

// FrontDesk.java (Facade)
class FrontDesk {
    private final Valet valet;
    private final HouseKeeping housekeeping;
    private final Cart cart;

    public FrontDesk() {
        this.valet = new Valet();
        this.housekeeping = new HouseKeeping();
        this.cart = new Cart();
    }

    public void requestValetService(String plateNumber) {
        System.out.println("\n[FrontDesk] Processing valet request...");
        valet.performService();
        valet.pickUpVehicle(plateNumber);
    }

    public void requestRoomCleaning(int roomNumber) {
        System.out.println("\n[FrontDesk] Processing housekeeping request...");
        housekeeping.performService();
        housekeeping.cleanRoom(roomNumber);
    }

    public void requestLuggageCart(int numberOfCarts) {
        System.out.println("\n[FrontDesk] Processing luggage cart request...");
        cart.performService();
        cart.requestCart(numberOfCarts);
    }
}

// HotelApp.java (Client)
public class HotelApp {
    public static void main(String[] args) {
        FrontDesk frontDesk = new FrontDesk();

        System.out.println("=== Welcome to the Hotel Management System ===");

        // Client interacts only with FrontDesk
        frontDesk.requestValetService("ABC-123");
        frontDesk.requestRoomCleaning(405);
        frontDesk.requestLuggageCart(2);

        System.out.println("\n=== Thank you for using HotelApp! ===");
    }
}
