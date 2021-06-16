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
public class ComputerPlayerTestWhenGetTotal {


	/**
	 * Test the computerPlayer's subclass getTotal() method.
	 */
	@Test
	public void testGetTotalFromNewPlayerWillReturnTotal0() {
		ComputerPlayer autoPlayer = new ComputerPlayer();

		assertEquals(0, autoPlayer.getTotal());
	}
	
	/**
	 * Test the computerPlayer's subclass inherited getTotal() method.
	 */
	@Test
	public void testGetTotalOf100WillGetTotalOf100() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		autoPlayer.setTotal(100);
		assertEquals(100, autoPlayer.getTotal());
	}

}
