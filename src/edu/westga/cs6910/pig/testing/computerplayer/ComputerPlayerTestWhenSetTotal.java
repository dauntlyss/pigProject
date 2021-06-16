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
public class ComputerPlayerTestWhenSetTotal {

	/**
	 * Test the computerPlayer's subclass setTotal() method.
	 */
	@Test
	public void testSetTotalTo10WillSetTotalTo10() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		autoPlayer.setTotal(10);
		
		assertEquals(10, autoPlayer.getTotal());
	}
	
	/**
	 * Test the computerPlayer's subclass setTotal() method.
	 */
	@Test
	public void testSetTotalTo1WillSetTotalTo1() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		autoPlayer.setTotal(1);
		assertEquals(1, autoPlayer.getTotal());
	}

}
