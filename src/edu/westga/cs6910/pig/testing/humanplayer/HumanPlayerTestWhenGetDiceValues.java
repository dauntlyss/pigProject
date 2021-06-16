package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests to confirm Human Player subclass is working correctly.
 * 
 * @author Alyssa Harris
 * @version 06-15-21
 */
public class HumanPlayerTestWhenGetDiceValues {

	/**
	 * Test method for Human Player's inherited getDiceValues() method.
	 */
	@Test
	public void testGetDiceValuesReturnsExpectedInitialValues() {
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		assertEquals("1, 1", realHumanPlayer.getDiceValues());
	}

}
