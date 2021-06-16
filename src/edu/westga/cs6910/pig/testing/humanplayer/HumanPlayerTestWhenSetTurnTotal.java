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
public class HumanPlayerTestWhenSetTurnTotal {

	/**
	 * Test the HumanPlayer's subclass setTurnTotal() method.
	 */
	@Test
	public void testSetTurnTotalTo10WillSetTurnTotalTo10() {
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		realHumanPlayer.setTurnTotal(10);
		
		assertEquals(10, realHumanPlayer.getTurnTotal());
	}
	
	/**
	 * Test the HumanPlayer's subclass setTurnTotal() method.
	 */
	@Test
	public void testSetTurnTotalTo1WillSetTurnTotalTo1() {
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		realHumanPlayer.setTurnTotal(1);
		
		assertEquals(1, realHumanPlayer.getTurnTotal());
	}

}
