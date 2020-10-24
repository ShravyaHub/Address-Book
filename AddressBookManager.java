import java.util.ArrayList;

public class AddressBookManager implements IAddressBook{

    @Override
    public void createPerson() {
        ArrayList<String> contacts = new ArrayList<>();
        contacts.add("Shravya");
        contacts.add("K");
        contacts.add("Bangalore");
        contacts.add("Bangalore");
        contacts.add("Karnataka");
        contacts.add("560062");
        contacts.add("9591266654");
    }

}
