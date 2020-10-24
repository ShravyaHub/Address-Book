import java.util.*;

public class AddressBookManager implements IAddressBook{

    String firstName, lastName, address, city, state, zip, phoneNumber;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Person> contacts = new ArrayList<>();
    Person person;
    boolean personExists;
    int choice;
    HashMap<Person, String> cityPersonMap = new HashMap<>();
    HashMap<Person, String> statePersonMap = new HashMap<>();
    Set<Person> keys = new HashSet<>();

    @Override
    public void createPerson() {
        personExists = false;
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
        if(contacts.size() > 0) {
            for (Person contact : contacts) {

                person = contact;

                if (firstName.equals(person.firstName) && lastName.equals(person.lastName)) {

                    System.out.println("Contact " + person.firstName + " " + person.lastName + " already exists");
                    personExists = true;
                    break;

                }

            }
        }

        if(!personExists) {
            person = new Person(firstName, lastName, address, city, state, zip, phoneNumber);
            contacts.add(person);
            cityPersonMap.put(person, city);
            statePersonMap.put(person, state);
            System.out.println("Contact added: " + person.firstName + " " + person.lastName);
        }
    }

    public void editPerson() {
        personExists = false;
        System.out.print("Enter first name: ");
        firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        lastName = scanner.nextLine();

        for (Person person : contacts) {

            if (firstName.equals(person.firstName) && lastName.equals(person.lastName)) {

                personExists = true;
                System.out.println("Edit:\n 1.Address\n 2.City\n 3.State\n 4.Zip\n 5.Phone number ");
                choice = scanner.nextInt();
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

    public void deletePerson() {
        for (int i = 0; i < contacts.size(); i++) {
            person = contacts.get(i);
            System.out.println("Enter first name: ");
            firstName = scanner.nextLine();
            System.out.println("Enter last name: ");
            lastName = scanner.nextLine();

            if (firstName.equals(person.firstName) && lastName.equals(person.lastName)) {

                contacts.remove(i);
                System.out.println("Contact deleted");

            } else {
                System.out.println("Contact does not exist");
            }

        }

    }

    public void sortAlphabetically() {

        contacts.sort(new SortByName());

        for (Person person : contacts) {

            person.display();

        }

    }

    public void sortByCityStateZip() {

        System.out.println("Sort by:\n 1.City\n 2.State\n 3.Zip ");
        choice = scanner.nextInt();

        switch(choice) {

            case 1:
                Collections.sort(contacts, new SortByCity());
                break;

            case 2:
                contacts.sort(new SortByState());
                break;

            case 3:
                contacts.sort(new SortByZip());
                break;

            default:
                System.out.println("Invalid input");

        }

        for (Person person : contacts) {

            person.display();

        }

    }

    public void viewPersonByCityOrState() {
        personExists = false;
        System.out.println("Choose:\n 1.city\n 2.State ");
        choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter first name: ");
        firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        lastName = scanner.nextLine();

        switch(choice) {

            case 1:
                System.out.println("Enter city: ");
                city = scanner.nextLine();
                for (Map.Entry<Person, String> person : cityPersonMap.entrySet()) {
                    if (Objects.equals(city, person.getValue())) {
                        keys.add(person.getKey());
                    }
                }
                for (Person personData : keys) {
                    if (firstName.equals(personData.firstName) && lastName.equals(personData.lastName) && city.equals(personData.city)) {
                        personData.display();
                        personExists = true;
                    }
                }
                if(!personExists) {
                    System.out.println("Contact does not exist");
                }
                break;

            case 2:
                System.out.println("Enter state: ");
                state = scanner.nextLine();
                for (Map.Entry<Person, String> person : statePersonMap.entrySet()) {
                    if (Objects.equals(state, person.getValue())) {
                        keys.add(person.getKey());
                    }
                }
                for (Person personData : keys) {
                    if (firstName.equals(personData.firstName) && lastName.equals(personData.lastName) && state.equals(personData.state)) {
                        personData.display();
                        personExists = true;
                    }
                }
                if(!personExists) {
                    System.out.println("Contact does not exist");
                }
                break;

            default:
                System.out.println("Invalid input");

        }

    }

    public void searchPeopleInCityOrState() {
        System.out.println("Choose:\n 1.city\n 2.State ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {

            case 1:
                System.out.println("Enter city: ");
                city = scanner.nextLine();
                viewPeople(city, cityPersonMap);
                break;

            case 2:
                System.out.println("Enter state: ");
                state = scanner.nextLine();
                viewPeople(state, statePersonMap);
                break;

            default:
                System.out.println("Invalid input");

        }
    }

    public void viewPeople(String cityOrState, HashMap<Person, String> personHashMap) {
        keys.clear();
        for (Map.Entry<Person, String> person : personHashMap.entrySet()) {
            if (Objects.equals(cityOrState, person.getValue())) {
                keys.add(person.getKey());
                person.getKey().display();
            }
        }
    }

}
