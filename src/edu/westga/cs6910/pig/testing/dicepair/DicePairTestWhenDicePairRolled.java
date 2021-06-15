package edu.westga.cs6910.pig.testing.dicepair;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * Tests to confirm DicePair class is working correctly.
 * 
 * @author Alyssa Harris
 * @version 06-14-21
 */
public class DicePairTestWhenDicePairRolled {

	/**
	 * Tests the DicePair class's roll() method to confirm that it never
	 * produces numbers less than 1 or greater than 6
	 */
	@Test
	public void testRollDice1() {
		DicePair testPair = new DicePair();
		for (int count = 0; count < 10000; count++) {
			testPair.rollDice();
			if (testPair.getDie1Value() < 1 || testPair.getDie1Value() > 6) {
				fail("Rolled a die with value: " + testPair.getDie1Value());
			}
		}
	}
	
	/**
	 * Tests the DicePair class's roll() method to confirm that it never
	 * produces numbers less than 1 or greater than 6
	 */
	@Test
	public void testRollDice2() {
		DicePair testPair = new DicePair();
		for (int count = 0; count < 10000; count++) {
			testPair.rollDice();
			if (testPair.getDie2Value() < 1 || testPair.getDie2Value() > 6) {
				fail("Rolled a die with value: " + testPair.getDie2Value());
			}
		}
	}
	
}
