import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ReservationSystem {
    private static Map<String, String> userCredentials = new HashMap<>();
    private static Map<String, String> reservations = new HashMap<>();

    public static void main(String[] args) {
        initializeUsers();

        Scanner scanner = new Scanner(System.in);

        // Login page
        System.out.println("Welcome to Reservation System");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (login(username, password)) {
            System.out.println("Login successful!");

            // Reservation or Cancellation
            System.out.println("Choose an option:");
            System.out.println("1. Make a reservation");
            System.out.println("2. Cancel a reservation");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    makeReservation(username, scanner);
                    break;
                case 2:
                    cancelReservation(username, scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Exiting...");
            }
        } else {
            System.out.println("Invalid username or password. Exiting...");
        }
    }

    private static void initializeUsers() {
        // Adding some user credentials (username, password)
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        // You can add more users here...
    }

    private static boolean login(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

    private static void makeReservation(String username, Scanner scanner) {
        System.out.print("Enter reservation details: ");
        String reservationDetails = scanner.next();

        reservations.put(username, reservationDetails);
        System.out.println("Reservation made successfully for " + username + ": " + reservationDetails);
    }

    private static void cancelReservation(String username, Scanner scanner) {
        if (reservations.containsKey(username)) {
            System.out.println("Your current reservation: " + reservations.get(username));
            System.out.println("Do you want to cancel this reservation? (yes/no)");
            String response = scanner.next();
            if (response.equalsIgnoreCase("yes")) {
                reservations.remove(username);
                System.out.println("Reservation canceled successfully for " + username);
            } else {
                System.out.println("Reservation not canceled.");
            }
        } else {
            System.out.println("No reservation found for " + username);
        }
    }
}
