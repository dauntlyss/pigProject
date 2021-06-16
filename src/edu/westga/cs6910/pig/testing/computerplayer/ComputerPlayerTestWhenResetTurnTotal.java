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
public class ComputerPlayerTestWhenResetTurnTotal {

	/**
	 * Test the computerPlayer's subclass inherited resetTurnTotal() method.
	 */
	@Test
	public void testResetTurnTotalResetsTurnTotalForComputerPlayer() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		autoPlayer.setTurnTotal(5);
		autoPlayer.resetTurnTotal();
		
		assertEquals(0, autoPlayer.getTurnTotal());
	}
	
	/**
	 * Test the computerPlayer's subclass inherited resetTurnTotal() method.
	 */
	@Test
	public void testResetTurnTotalResetsTurnTotalTo0ForComputerPlayer() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		autoPlayer.setTurnTotal(50);
		autoPlayer.resetTurnTotal();
		
		assertEquals(0, autoPlayer.getTurnTotal());
	}

}
