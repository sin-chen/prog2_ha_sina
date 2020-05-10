package datastructures;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Account> accounts = new HashSet<Account>();
		
		Account acc1 = new Account("Birte",99999);
		Account acc2 = new Account("Bienchen",8888);
		Account acc3 = new Account("Jessie",55555);
		Account acc4 = new Account("Aerith",80085);
		
		accounts.add(acc1);
		accounts.add(acc2);
		accounts.add(acc3);
		accounts.add(acc4);
		
		Scanner scan = new Scanner(System.in);
		
		try {
			//TODO wenn du z.B. Birte mit 99999 noch mal anlegen willst, funktioniert das. Das sollte es aber nicht. 
			//TODO es wird der hashcode des Objekts geprüft und wenn du die hashCode Methode nicht überschreibst, 
			//dann nimmt er die einzigartige Objektreferenz als hashCode
			Account acc5 = new Account(scan.nextLine(),scan.nextInt());
			accounts.add(acc5);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for( Account a: accounts) {
			System.out.println("Accountname: " + a.getUserName());
			System.out.println("Nummer: " + a.getPhoneNumber() + "\n");
		}
		
		//TODO schliess den scanner
	}

}
