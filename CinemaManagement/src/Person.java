public class Person {
    private static String name;
    private static String surname;
    private static String email;

    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public static String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public static String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public static String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public void printPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
    }
}
