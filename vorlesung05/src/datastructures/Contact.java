package datastructures;

import java.io.Serializable;

public class Contact implements Comparable<Contact>, Serializable{

	private String name;
	private int phoneNumber;
	
	private static final long serialVersionUID = 1L;

	public Contact(String name, int phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhonenNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int compareTo(Contact other) {
		//nur fürn ranking
		if(name.equals("Tack")) {
			return -1;
		}
		else if(name.equals("Hitler")) {
			return 1;
		}
		else if(name.equals("SexieJessie")) {
			return 1;
		}
		
		//Wenn der Name nicht gleich ist, wird alphabetisch sortiert.
		// ist der Name gleich, wird nach der Nummer sortiert. (if bedingung)w
		
		int val = name.compareTo(other.name);
		if(val == 0) {
			//TODO dann vergleiche nummer
			if(phoneNumber < other.phoneNumber) {
				return -1;
			} else if (phoneNumber > other.phoneNumber) {
				return 1;
			}
			
		}
		return val;
	}

}
