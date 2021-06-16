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
public class ComputerPlayerTestWhenGetName {

	/**
	 * Test method for Computer Player's getName() method.
	 */
	@Test
	public void testGetNameWhenNewComputerPlayer() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		assertEquals("Simple computer", autoPlayer.getName());
	}

}
