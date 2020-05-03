package datastructures;

import java.util.HashSet;
import java.util.Iterator;

public class MySet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> names = new HashSet<>();

		names.add("Wolverine");
		names.add("Don");
		names.add("Anja");
		
//		for(String name: names) {
//			System.out.println(name);
//			if(names.equals("Don")) {
//				names.remove(name);
//			}
//		}
		
		Iterator<String> iterator = names.iterator();
		while(iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
			if(name.contentEquals("Don")) {
				iterator.remove();
			}
		}
		System.out.println(names.size());
	}

}
