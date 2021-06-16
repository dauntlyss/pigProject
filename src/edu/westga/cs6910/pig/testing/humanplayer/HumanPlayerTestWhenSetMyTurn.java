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
public class HumanPlayerTestWhenSetMyTurn {

	/**
	 * Test the HumanPlayer's subclass setIsMyTurn() method.
	 */
	@Test
	public void testSetIsMyTurnToTrueForNewPlayerReturnsTrue() {
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		realHumanPlayer.setMyTurn(true);
		assertEquals(true, realHumanPlayer.getIsMyTurn());
	}
	
	/**
	 * Test the HumanPlayer's subclass setIsMyTurn() method.
	 */
	@Test
	public void testSetIsMyTurnToFalseFromTrueForHumanPlayerReturnsFalse() {
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		realHumanPlayer.setMyTurn(true);
		realHumanPlayer.setMyTurn(false);
		assertEquals(false, realHumanPlayer.getIsMyTurn());
	}

}
