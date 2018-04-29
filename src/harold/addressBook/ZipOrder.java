package harold.addressBook;

import java.util.Map;
import java.util.TreeMap;

public class ZipOrder implements Order{

    @Override
    public String getKey(Person person){
        return Integer.toString(person.getZipCode());
    }

    @Override
    public Map<String, Person> sort(Map<String, Person> people) {
        Map<String, Person> zipSorted = new TreeMap<>();
        people.forEach((String key, Person person)
                -> zipSorted.put(getKey(person), person));
        return zipSorted;
    }
}