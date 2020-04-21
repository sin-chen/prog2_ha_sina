package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void test() {
		
		Person person = new Person("David","Doof");

		String firstName = "Tim";
		
		//assertEquals(person.getFirstName(),firstName); //cool Fehlermeldung!
		
		person.setFirstName(firstName);
		
		//assertEquals(person.getFirstName(), firstName);
		
		assertNotEquals(person.getFirstName(),"Tom");
		
		//mit strg + 7 schnell eine Zeile auskommentieren
	}

}
