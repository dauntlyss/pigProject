package edu.westga.cs6910.pig.testing.dicepair;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.DicePair;

/**
 * Tests to confirm DicePair class is working correctly.
 * 
 * @author Alyssa Harris
 * @version 06-14-21
 */
public class DicePairTestWhenGetDie1Value {

	/**
	 * Tests the DicePair class's getDie1Value() method to confirm that it
	 * displays the expected value.
	 */
	@Test
	public void testGetDie1Value() {
		DicePair newDicePair = new DicePair();
		assertEquals(1, newDicePair.getDie1Value());
	}

}
