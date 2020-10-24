import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBookManager addressBookManager = new AddressBookManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Choose:\n 1.Add person\n 2.Edit person");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addressBookManager.createPerson();
                    break;

                case 2:
                    addressBookManager.editPerson();
                    break;

                default:
                    System.out.println("Invalid input");

            }

        }

    }

}
