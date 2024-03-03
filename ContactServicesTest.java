package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import contact.Contact;
import contact.ContactService;

class ContactServicesTest {

	@Test
	void testContactServicesClass() {
		Contact contact = new Contact("1234", "Shayla", "Vincent", "6031234567", "429");
		assertTrue(ContactService.addContact(contact));

	}
	@Test
	void testContactServiceDeletion() {
		Contact contact = new Contact("1234", "Shayla", "Vincent", "6031234567", "429");
		ContactService.addContact(contact);
		assertTrue(ContactService.deleteContact(contact));
	}
	@Test
	void testContactServiceUpdates() {
		Contact contact = new Contact("1234", "Shayla", "Vincent", "6031234567", "429");
		ContactService.addContact(contact);
		assertTrue(ContactService.updateContact(contact));
	}

}
