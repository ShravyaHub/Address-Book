import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBookManager addressBookManager = new AddressBookManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Choose:\n " +
                    "1.Add person\n " +
                    "2.Edit person\n " +
                    "3.Delete person\n " +
                    "4.Sort address book alphabetically\n " +
                    "5.Sort address book by city, state or zip");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addressBookManager.createPerson();
                    break;

                case 2:
                    addressBookManager.editPerson();
                    break;

                case 3:
                    addressBookManager.deletePerson();
                    break;

                case 4:
                    addressBookManager.sortAlphabetically();
                    break;

                case 5:
                    addressBookManager.sortByCityStateZip();
                    break;

                default:
                    System.out.println("Invalid input");

            }

        }

    }

}
