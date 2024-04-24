import java.util.ArrayList;
import java.util.List;

// Class to represent a guest
class Guest {
    private int age;

    public Guest(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

// Class to represent a ticket
class Ticket {
    private List<Guest> guests;
    private int totalPrice;

    public Ticket() {
        guests = new ArrayList<>();
        totalPrice = 0;
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
        totalPrice += calculatePrice(guest);
    }

    private int calculatePrice(Guest guest) {
        int age = guest.getAge();
        if (age <= 2) {
            return 0;
        } else if (age < 18) {
            return 100;
        } else if (age < 60) {
            return 500;
        } else {
            return 300;
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<Guest> getGuests() {
        return guests;
    }
}

// Main class for ticketing software
public class ZooTicketingSystem {
    public static void main(String[] args) {
        // Creating a ticket
        Ticket ticket = new Ticket();

        // Adding guests to the ticket
        Guest guest1 = new Guest(23);
        Guest guest2 = new Guest(25);
        ticket.addGuest(guest1);
        ticket.addGuest(guest2);

        // Displaying ticket details
        System.out.println("Ticket Details:");
        List<Guest> guests = ticket.getGuests();
        for (int i = 0; i < guests.size(); i++) {
            System.out.println("Guest " + (i + 1) + " (age: " + guests.get(i).getAge() + ")");
        }

        // Displaying total price
        System.out.println("Total Price: INR " + ticket.getTotalPrice());
    }
}
