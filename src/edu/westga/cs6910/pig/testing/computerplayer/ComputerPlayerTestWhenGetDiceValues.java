package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

/**
 * Tests to confirm Computer Player subclass is working correctly.
 * 
 * @author Alyssa Harris
 * @version 06-15-21
 */
public class ComputerPlayerTestWhenGetDiceValues {

	/**
	 * Test method for Computer Player's inherited getDiceValues() method.
	 */
	@Test
	public void testGetDiceValuesReturnsExpectedInitialValues() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		assertEquals("1, 1", autoPlayer.getDiceValues());
	}

}
