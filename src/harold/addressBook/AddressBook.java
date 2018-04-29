package harold.addressBook;

import java.io.Serializable;
import java.util.*;

public class AddressBook implements Serializable {
    /**
     * Used to represent an address book with entries
     * stored as a treeSet. Supports basic operations
     * operations such as add, remove, and sorting by
     * certain values. Sorts entries by last name initially.
     */
    private Map<String, Person> entries;
    private Order order;

    public AddressBook(){
        entries = new TreeMap<>();
        order = new LastNameOrder();
    } 

    public AddressBook(AddressBook addressBook){
        entries = new TreeMap<>(addressBook.entries);
        order = addressBook.order;

    }
    

    public void add(Person person){
        String key = order.getKey(person);
        if (!entries.containsKey(key)){
            entries.put(key, person);
        }
    }

    public void setOrder(Order order) {
        this.order = order;
        entries = order.sort(entries);
    }

    public boolean remove(String key) { return entries.remove(key) != null; }

    public void changePhoneNumber(String key, String number){ entries.get(key).setPhoneNumber(number); }

    public void changeStreetAddress(String key, String address){ entries.get(key).setStreetAddress(address); }

    public void changeCity(String key, String city) { entries.get(key).setCity(city); }

    public void changeState(String key, String state){
        entries.get(key).setState(state);
    }

    public void changeZip(String key, int zipCode) {
        Person person = entries.remove(key);
        person.setZipCode(zipCode);
        entries.put(order.getKey(person), person);
    }

    public void printAllEntries() { entries.forEach((String key, Person entry) -> System.out.println(entry.toString())); }

    public Map<String, Person> getEntries() {
        return entries;
    }
}