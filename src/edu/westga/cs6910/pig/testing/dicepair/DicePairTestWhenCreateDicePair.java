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
public class DicePairTestWhenCreateDicePair {

	/**
	 * Tests the DicePair class's constructor to confirm that it 
	 * creates dicePair as expected.
	 */
	@Test
	public void testDicePairConstructorCreatesNewDicePair() {
		DicePair newDicePair = new DicePair();
		assertEquals("pips: 1, 1", newDicePair.toString());
	}

}
