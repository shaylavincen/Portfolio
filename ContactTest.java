package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	@Test
	public void testContact() {
		Contact contact = new Contact("1234", "Shayla", "Vincent", "6031234567", "429");
		assertTrue(contact.getContactID().equals("1234"));
		assertTrue(contact.getFirstName().equals("Shayla"));
		assertTrue(contact.getLastName().equals("Vincent"));
		assertTrue(contact.getPhone().equals("6031234567"));
		assertTrue(contact.getAddress().equals("429"));
	}
	
	@Test
	public void testContactTooLong() {
		//ID is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891909090", "Shayla", "Vincent", "6031234567", "429");
		
		});
	}
	
	@Test
	public void testContactNull() {
		// ID is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Shayla", "Vincent", "6031234567", "429");
		
		});
	}
	
	@Test
	public void testFirstNameTooLong() {
		//first name is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Shaylavincent", "Vincent", "6031234567", "429");
		});
	}
	
	@Test
	public void testFirstNameNull() {
		//first name is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", null, "Vincent", "6031234567", "429");
		
		});
	}
	
	@Test
	public void testLastNameTooLong() {
		//last name is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Shayla", "ShaylaVincent", "6031234567", "429");
		});
	}
	
	@Test
	public void testLastNameNull() {
		//last name is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Shayla", null, "6031234567", "429");
		});
	}
	
	@Test
	public void testPhoneTooLong() {
		//phone is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Shayla", "Vincent", "60312345679090", "429");
		});
	}
	
	@Test
	public void testPhoneNull() {
		//phone is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Shayla", "Vincent", null, "429");
		});
	}
	
	@Test
	public void testAddressTooLong(){
		//address is too long
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Shayla", "Vincent", "6031234567", "12345678910111213141511718192021");
		});
	}
	
	@Test
	public void testAddressNull() {
		//address is null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234", "Shayla", "Vincent", "6031234567", null);
		});
	}
}

