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
public class ComputerPlayerTestWhenSetTurnTotal {

	/**
	 * Test the computerPlayer's subclass setTurnTotal() method.
	 */
	@Test
	public void testSetTurnTotalTo10WillSetTurnTotalTo10() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		autoPlayer.setTurnTotal(10);
		
		assertEquals(10, autoPlayer.getTurnTotal());
	}
	
	/**
	 * Test the computerPlayer's subclass setTurnTotal() method.
	 */
	@Test
	public void testSetTurnTotalTo1WillSetTurnTotalTo1() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		autoPlayer.setTurnTotal(1);
		assertEquals(1, autoPlayer.getTurnTotal());
	}

}
