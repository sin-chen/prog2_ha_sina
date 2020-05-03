package datastructures;

import java.util.HashMap;
import java.util.Set;

public class MyMap {

	public static void main(String[] args) {
		HashMap<String, Integer> books = new HashMap<>();
		books.put("Harry Potter - 1", 2);
		books.put("Spongebob Manga", 10);
		books.put("Dolly&Dot", 1);
		books.put("The Witcher", 100);
		books.put("Warcraft 3", 21);
		books.put("DonDonDon4", 222);
		books.put("DonDonDon4", books.get("DonDonDon4") + 222);
		
		Set<String> bookname = books.keySet();
		for(String name : bookname){
			System.out.println(name + " : " + books.get(name));
			
		}
		
	}
}
