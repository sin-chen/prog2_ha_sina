package datastructures;

import java.util.Collections;
//import java.util.ArrayList;
import java.util.LinkedList;

public class ContactMain {

	public static void main(String[] args) {

//		ArrayList<Contact> contacts = new ArrayList<>();
		LinkedList<Contact> contacts = new LinkedList<>();

		contacts.add(new Contact("Herbert", 12494));
		contacts.add(new Contact("DonDonDon", 333));
		contacts.add(new Contact("Tack", 6));
		contacts.add(new Contact("Tack", 1));



		Collections.sort(contacts);

		for (Contact contact : contacts) {
			System.out.println(contact.getName() + " : " + contact.getPhoneNumber());
		}

	}

}
