package harold.addressBook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class addressDirectoryTest {

	@Test
	
	
	void testAddEntry(String name, String address) {
		//String name, address;
		addressDirectory testAddEntry = new addressDirectory(name, address);
		String output = testAddEntry.getAddress(name);
		assertEquals("Harold", output);
	}

}
