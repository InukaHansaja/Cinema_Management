import java.util.InputMismatchException;
import java.util.Scanner;

public class CinemaManagement {

    public static int[][] seats = new int[3][16];
    private static Ticket[] tickets = new Ticket[48];
    private static int ticketCount = 0;

    public static void main(String[] args) {
        seats[0]=new int[16];
        seats[1]=new int[16];
        seats[2]=new int[16];
        System.out.println("Welcome to The London Lumiere");
        displayMenu(seats);
    }

    public static void displayMenu(int[][] seats) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("-                  Menu Option                   -");
            System.out.println("--------------------------------------------------");
            System.out.println("1. Buy Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Print Seating Area");
            System.out.println("4. Find First Available Seat");
            System.out.println("5. Print Tickets Info");
            System.out.println("6. Search Ticket");
            System.out.println("7. Sort Tickets");
            System.out.println("8. Exit");
            System.out.println("--------------------------------------------------");
            System.out.print("Select an option: ");
            int option;
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeber between 1-8.");
                scanner.next(); // Clear the scanner buffer
                continue; // Restart the loop to prompt the user again
            }

            switch (option) {
                case 1:
                    buyTicket(seats, scanner);
                    break;
                case 2:
                    cancelTicket(seats, scanner);
                    break;
                case 3:
                    printSeatingArea(seats);
                    break;
                case 4:
                    findFirstAvailable(seats);
                    break;
                case 5:
                    printTicketsInfo();
                    break;
                case 6:
                    searchTicket();
                    break;
                case 7:
                    sortTickets();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please enter a between 1-8.");
            }
        }
    }

    public static void buyTicket(int[][] seats, Scanner scanner) {
        System.out.print("Enter row number (1-3): ");
        char rowNumber  = scanner.next().charAt(0);
        if (rowNumber < '1' || rowNumber > '3' ) {
            System.out.println("Invalid row number. Please try again.");
        return;
        }
        System.out.print("Enter seat number (1-16): ");
        int seatNumber = scanner.nextInt();

        char row = 0;
        char seat = 0;
        if (row >= 0 && row < seats.length && seat >= 0 && seat < seats[0].length) {
            if (seats[row][seat] == 0) {
                System.out.print("Enter name: ");
                String name = scanner.next();
                System.out.print("Enter surname: ");
                String surname = scanner.next();
                System.out.print("Enter email: ");
                String email = scanner.next();
                Person person = new Person(name, surname, email);
                double price = calculatePrice(row);
                Ticket ticket = new Ticket((char) row, seat, (int) price, person);
                tickets[ticketCount++] = ticket;
                seats[row][seat] = 1;
                Ticket.printTicketInfo();
                System.out.println("The seat has been booked.");
            } else {
                System.out.println("This seat is not available.");
            }
        } else {
            System.out.println("Invalid seat number. Please try again.");
        }
        return;
    }

    public static void cancelTicket(int[][] seats, Scanner scanner) {
        System.out.print("Enter row number: ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter seat number: ");
        int seat = scanner.nextInt() - 1;

        if (row >= 0 && row < seats.length && seat >= 0 && seat < seats[0].length) {
            if (seats[row][seat] == 1) {
                seats[row][seat] = 0;
                removeTicket(row, seat);
                System.out.println("The seat has been cancelled.");
            } else {
                System.out.println("This seat is already available.");
            }
        } else {
            System.out.println("Invalid seat number.");
        }
    }

    public static int calculatePrice(int row) {
        int seatPrice = 0;
//SEAT prices
        if (row >= 0 && row < 1) {
            seatPrice = 12;
        } else if (row >= 1 && row < 2) {
            seatPrice = 10;
        } else if (row >= 2 && row < 3) {
            seatPrice = 8;
        }
        return seatPrice;
    }

    public static void removeTicket(int row, int seat) {
        for (int i = 0; i < ticketCount; i++) {
        }
    }

    public static void printSeatingArea(int[][] seats) {
        System.out.println("Seating Area:");
            System.out.println("       ****************");
            System.out.println("       *    SCREEN    *");
            System.out.println("       ****************");
        for (int[] seat : seats) {
            for (int j = 0; j < seat.length; j++) {
                if (seat[j] == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println("Available Seats Are Represented By : 'O'");

        System.out.println("Booked Seats Are Represented By : 'X'");
    }

    public static void findFirstAvailable(int[][] seats) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    System.out.println("First available seat is at row " + (i + 1) + ", seat " + (j + 1));
                    return;
                }
            }
        }
        System.out.println("No available seats.");
    }

    public static void printTicketsInfo() {
        double total = 0;
        System.out.println("Tickets Information:");
        for (int i = 0; i < ticketCount; i++) {
            total += tickets[i].getPrice();
        }
        System.out.println("Total price of tickets sold: £" + total);
    }

    public static void searchTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter row number: ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter seat number: ");
        int seat = scanner.nextInt() - 1;

        for (int i = 0; i < ticketCount; i++) {
        }
        System.out.println("This seat is available.");
    }

    public static void sortTickets() {
        // Implementing a simple bubble sort for demonstration
        for (int i = 0; i < ticketCount - 1; i++) {
            for (int j = 0; j < ticketCount - i - 1; j++) {
                if (tickets[j].getPrice() > tickets[j + 1].getPrice()) {
                    Ticket temp = tickets[j];
                    tickets[j] = tickets[j + 1];
                    tickets[j + 1] = temp;
                }
            }
        }
        System.out.println("Tickets sorted by price:");
        for (int i = 0; i < ticketCount; i++) {
            tickets[i].printTicketInfo();
        }
    }
}
