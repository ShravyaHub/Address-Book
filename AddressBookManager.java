import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookManager implements IAddressBook{

    @Override
    public void createPerson() {
        ArrayList<Person> contacts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter address : ");
        String address = scanner.nextLine();
        System.out.println("Enter city: ");
        String city = scanner.nextLine();
        System.out.println("Enter state: ");
        String state = scanner.nextLine();
        System.out.println("Enter zip: ");
        String zip = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        Person person = new Person(firstName, lastName, address, city, state, zip, phoneNumber);
        contacts.add(person);
        System.out.println("Contact added: " + person.firstName + " " + person.lastName);
    }

}
