package harold.addressBook;

import java.util.Map;
import java.util.TreeMap;

public class LastNameOrder implements Order {

    @Override
    public Map<String, Person> sort(Map<String, Person> people) {
        Map<String, Person> nameSorted = new TreeMap<>();
        people.forEach((String key, Person person) -> nameSorted.put(getKey(person), person));
        return nameSorted;
    }

    @Override
    public String getKey(Person person) {
        return person.getLastName() + person.getFirstName();
    }
}