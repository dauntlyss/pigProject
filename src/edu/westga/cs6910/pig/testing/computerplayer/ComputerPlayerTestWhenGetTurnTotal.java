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
public class ComputerPlayerTestWhenGetTurnTotal {

	/**
	 * Test the computerPlayer's subclass getTurnTotal() method.
	 */
	@Test
	public void testGetTurnTotalFromNewPlayerWillReturnTurnTotal0() {
		ComputerPlayer autoPlayer = new ComputerPlayer();

		assertEquals(0, autoPlayer.getTurnTotal());
	}
	
	/**
	 * Test the computerPlayer's subclass getTurnTotal() method.
	 */
	@Test
	public void testGetTurnTotalOf100WillGetTurnTotalOf100() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		autoPlayer.setTurnTotal(100);
		assertEquals(100, autoPlayer.getTurnTotal());
	}

}
