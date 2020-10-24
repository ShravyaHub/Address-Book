import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookManager implements IAddressBook{

    String firstName, lastName, address, city, state, zip, phoneNumber;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Person> contacts = new ArrayList<>();

    @Override
    public void createPerson() {
        System.out.println("Enter first name: ");
        firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        lastName = scanner.nextLine();
        System.out.println("Enter address : ");
        address = scanner.nextLine();
        System.out.println("Enter city: ");
        city = scanner.nextLine();
        System.out.println("Enter state: ");
        state = scanner.nextLine();
        System.out.println("Enter zip: ");
        zip = scanner.nextLine();
        System.out.println("Enter phone number: ");
        phoneNumber = scanner.nextLine();
        Person person = new Person(firstName, lastName, address, city, state, zip, phoneNumber);
        contacts.add(person);
        System.out.println("Contact added: " + person.firstName + " " + person.lastName);
    }

    public void editPerson() {
        boolean personExists = false;
        System.out.print("Enter first name: ");
        firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        lastName = scanner.nextLine();

        for (Person person : contacts) {

            if (firstName.equals(person.firstName) && lastName.equals(person.lastName)) {

                personExists = true;
                System.out.println("Edit:\n 1.Address\n 2.City\n 3.State\n 4.Zip\n 5.Phone number ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        System.out.println("Enter new address: ");
                        address = scanner.nextLine();
                        person.address = address;
                        System.out.println("Contact updated");
                        break;

                    case 2:
                        System.out.println("Enter new city: ");
                        city = scanner.nextLine();
                        person.city = city;
                        System.out.println("Contact updated");
                        break;

                    case 3:
                        System.out.println("Enter new state: ");
                        state = scanner.nextLine();
                        person.state = state;
                        System.out.println("Contact updated");
                        break;

                    case 4:
                        System.out.println("Enter new zip: ");
                        zip = scanner.nextLine();
                        person.zip = zip;
                        System.out.println("Contact updated");
                        break;

                    case 5:
                        System.out.println("Enter new phone number: ");
                        phoneNumber = scanner.nextLine();
                        person.phoneNumber = phoneNumber;
                        System.out.println("Contact updated");
                        break;

                    default:
                        System.out.println("Invalid input");

                }

            }

        }

        if(!personExists) {
            System.out.println("Contact " + firstName + " " + lastName + " does not exist");
        }

    }

}
