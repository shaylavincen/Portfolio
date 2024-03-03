package contact;
import java.util.*;


public class ContactService {
	
	private static  List<Contact> contactList = new ArrayList<Contact>();

	public static boolean addContact(Contact additionalContact) {
		for(Contact i : contactList) {
			if(i.getContactID().equals(additionalContact.getContactID())){
				System.out.print("Contact already exists");
				return false;
			}
		}
		contactList.add(additionalContact);
		System.out.print("Successfully added contact");	
		return true;
	}
	
	public static boolean deleteContact(Contact deleteContact) {
		for(Contact i : contactList) {
			if(i.getContactID().equals(deleteContact.getContactID())) {
				contactList.remove(deleteContact);
				System.out.print("Contact has been removed");
				return true;
			}
		}
		System.out.print("Contact does not exist to be deleted");
		return false;
	}
	public static boolean updateContact(Contact updatedContact) {
		for(Contact i : contactList) {
			if(i.getContactID().equals(updatedContact.getContactID())) {
				i.setFirstName(updatedContact.getFirstName());
				i.setLastName(updatedContact.getLastName());
				i.setPhone(updatedContact.getPhone());
				i.setAddress(updatedContact.getAddress());
				System.out.print("Contact has been updated");
				return true;
			}
		}
		System.out.print("Contact does not exist");
		return false;
	}
	
	

}
