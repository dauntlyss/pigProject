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
public class ComputerPlayerTestWhenSetIsMyTurn {

	/**
	 * Test the computerPlayer's subclass setIsMyTurn() method.
	 */
	@Test
	public void testSetIsMyTurnToTrueForNewPlayerReturnsTrue() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		autoPlayer.setMyTurn(true);
		assertEquals(true, autoPlayer.getIsMyTurn());
	}
	
	/**
	 * Test the computerPlayer's subclass setIsMyTurn() method.
	 */
	@Test
	public void testSetIsMyTurnToFalseFromTrueForComputerPlayerReturnsFalse() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		autoPlayer.setMyTurn(true);
		autoPlayer.setMyTurn(false);
		assertEquals(false, autoPlayer.getIsMyTurn());
	}

}
