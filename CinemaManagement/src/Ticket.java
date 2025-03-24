import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    public static String row;
    public static int seat;
    public static double price;
    public static Person person;

    public Ticket(char row, int seat, int price, Person person) {
        this.row = String.valueOf(row);
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public static void printTicketInfo() {
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price : £ " + price);
        System.out.println("Person Information");
        person.printPersonInfo();
    }


}



