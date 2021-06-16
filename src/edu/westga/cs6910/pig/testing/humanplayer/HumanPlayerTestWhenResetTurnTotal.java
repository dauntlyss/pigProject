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
public class HumanPlayerTestWhenResetTurnTotal {

	/**
	 * Test the HumanPlayer's subclass inherited resetTurnTotal() method.
	 */
	@Test
	public void testResetTurnTotalResetsTurnTotalForHumanPlayer() {
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		realHumanPlayer.setTurnTotal(5);
		realHumanPlayer.resetTurnTotal();
		
		assertEquals(0, realHumanPlayer.getTurnTotal());
	}
	
	/**
	 * Test the HumanPlayer's subclass inherited resetTurnTotal() method.
	 */
	@Test
	public void testResetTurnTotalResetsTurnTotalTo0ForHumanPlayer() {
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		realHumanPlayer.setTurnTotal(50);
		realHumanPlayer.resetTurnTotal();
		
		assertEquals(0, realHumanPlayer.getTurnTotal());
	}

}
