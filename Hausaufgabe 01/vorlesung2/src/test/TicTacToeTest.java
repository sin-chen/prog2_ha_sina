package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TicTacToeTest {
	
	
	

	@ParameterizedTest
	@MethodSource
	void test(char symbol, int[] col, int[] row) {
		TicTacToe ttt = new TicTacToe();
		for(int i = 0; i < col.length; i++) {
			assertTrue(ttt.setSymbol(symbol, col[i], row[i]));
		}
		assertTrue(ttt.checkWinConditions(symbol));
		
	}
	
	static Stream<Arguments> test(){
		return Stream.of(Arguments.of(TicTacToe.X, Arrays.asList(0,0,0)));
	}

}
