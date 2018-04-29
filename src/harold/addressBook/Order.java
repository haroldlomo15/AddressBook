package harold.addressBook;
import java.util.Map;


public interface Order {
	 Map<String, Person> sort(Map<String, Person> person);
	   String getKey(Person person);
}
