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
public class ComputerPlayerTestWhenCreateComputerPlayer {

	/**
	 * Tests the Computer Player subclass's constructor to confirm that it 
	 * creates ComputerPlayer as expected.
	 */
	@Test
	public void testComputerPlayerConstructorCreatesNewComputerPlayer() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		assertEquals("Player with name: Simple computer, and new dice pips: 1, 1", autoPlayer.toString());
	}

}
