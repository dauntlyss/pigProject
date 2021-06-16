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
public class HumanPlayerTestWhenGetTurnTotal {

	/**
	 * Test the HumanPlayer's subclass getTurnTotal() method.
	 */
	@Test
	public void testGetTurnTotalFromNewPlayerWillReturnTurnTotal0() {
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");

		assertEquals(0, realHumanPlayer.getTurnTotal());
	}
	
	/**
	 * Test the HumanPlayer's subclass getTurnTotal() method.
	 */
	@Test
	public void testGetTurnTotalOf100WillGetTurnTotalOf100() {
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		realHumanPlayer.setTurnTotal(100);
		assertEquals(100, realHumanPlayer.getTurnTotal());
	}

}
