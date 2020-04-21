package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TestParameter {


	//Nur eine Test Annotation!
	@ParameterizedTest
	@MethodSource
	void test(int i) {
		assertEquals(2,i); //nur wenn im arg pups steht isses richtig
	}
	
	//der Test durchläuft den Stream und vergleicht
	
	/*static Stream<Integer> test() {
		return Stream.of(2,4, 5, 1);
		
	}*/
	
	//geht durch erste 100 zahlen durch die %3 ==2 sind und überprüft diese:
	//zahlen von 0 bis 68 zahl*zahl soll durch 4 teilbar sein
	static IntStream test() {
		return IntStream.range(0, 69).filter(x ->( x * x) %4 == 0);
		
	}
		
		/*Nur eine Test Annotation!
		@ParameterizedTest
		@MethodSource
		void test(String arg) {
			assertEquals("pups",arg); //nur wenn im arg pups steht isses richtig 
		
		//der Test durchläuft den Stream und vergleicht
		
		static Stream<String> test() {
			return Stream.of("test","pups", "Apple", "Pokemon"); */
		
		
		
		
	
}
