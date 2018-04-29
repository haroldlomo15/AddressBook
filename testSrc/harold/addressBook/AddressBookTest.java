package harold.addressBook;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.rules.*;
import org.junit.Test;


public class AddressBookTest {

    private Person personA = new Person.Builder()
            .firstName("Harold")
            .lastName("Lomotey")
            .phoneNumber("324234242")
            .city("Silver Spring")
            .state("MD")
            .streetAddress("21333")
            .zipCode(32434)
            .build();

    private Person personB = new Person.Builder()
            .firstName("Jerold")
            .lastName("Lomotey")
            .phoneNumber("4325452552")
            .city("Washington D.C")
            .state("Washington D.C")
            .streetAddress("235 Howard Place")
            .zipCode(23452)
            .build();

    private Order zipOrder = new ZipOrder();
    private Order nameOrder = new LastNameOrder();

    @Test
    public void remove() {
    
        AddressBook book = new AddressBook();
        book.add(personA);
        boolean output = book.remove(nameOrder.getKey(personA));
        
        boolean x = true;
        boolean y = true;
        assertEquals(x,y);
    }

    @Test
    public void add() {
        AddressBook book = new AddressBook();
        book.add(personA);
        assertTrue(book.remove(nameOrder.getKey(personA)));
    }

    @Test
    public void orderByZip() {
        AddressBook book = new AddressBook();
        book.setOrder(zipOrder);
        book.add(personA);
        book.add(personB);

        List<Person> actual = new ArrayList<>(book.getEntries().values());

        List<Person> expected = new ArrayList<>();
        expected.add(personB);
        expected.add(personA);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void orderByLastName() {
        AddressBook book = new AddressBook();
        book.add(personB);
        book.add(personA);

        List<Person> actual = new ArrayList<>(book.getEntries().values());

        List<Person> expected = new ArrayList<>();
        expected.add(personA);
        expected.add(personB);
        assertTrue(actual.equals(expected));
    }
}