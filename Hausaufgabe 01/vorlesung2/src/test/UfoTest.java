package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import ufogame.Ufo;

import org.junit.jupiter.api.Test;

import ufogame.Ufo;

class UfoTest {
	
	Ufo ufo;
	
	@BeforeEach //wird vor jeden Test durchgeführt
	void init() {
		System.out.println("beforeEach");
		ufo = new Ufo(100,100,50,50,3,"");
		}

	@Test
	void testMove() {
		
		System.out.println("testMove");
		//Test, ob die move Methode richtig funktioniert.
		ufo.move();
		assertEquals(ufo.getX(),103);
	}
	
	//Dummy Test
	
	@Test
	void testBla() {
		System.out.println("testBla");
		
	}
	
	//es gibt auch andere ANNOTATIONS: BeforeAll und AfterAll, und After Each

}
