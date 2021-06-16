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
public class HumanPlayerTestWhenSetTotal {

	/**
	 * Test the HumanPlayer's subclass setTotal() method.
	 */
	@Test
	public void testSetTotalTo10WillSetTotalTo10() {
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		realHumanPlayer.setTotal(10);
		
		assertEquals(10, realHumanPlayer.getTotal());
	}
	
	/**
	 * Test the HUmanPlayer's subclass setTotal() method.
	 */
	@Test
	public void testSetTotalTo1WillSetTotalTo1() {
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		realHumanPlayer.setTotal(1);
		assertEquals(1, realHumanPlayer.getTotal());
	}

}
