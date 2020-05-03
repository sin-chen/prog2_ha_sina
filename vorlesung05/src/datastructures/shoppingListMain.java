package datastructures;

import java.util.HashMap;
import java.util.Set;

public class shoppingListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> goodies = new HashMap<String, String>();
		
		goodies.put("Banenen","zwei");
		goodies.put("Milch","2 Liter");
		goodies.put("Mehl","500g");
		
		Set<String> goodieName = goodies.keySet();
		
		for(String name: goodieName) {
			System.out.println(name + ":" + goodies.get(name));
		}
		

	}

}
