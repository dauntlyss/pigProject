package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

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
		PigStrategy someStrategy = new CautiousStrategy();
		ComputerPlayer autoPlayer = new ComputerPlayer(someStrategy);

		assertEquals(0, autoPlayer.getTotal());
	}
	
	/**
	 * Test the computerPlayer's subclass inherited getTotal() method.
	 */
	@Test
	public void testGetTotalOf100WillGetTotalOf100() {
		PigStrategy someStrategy = new CautiousStrategy();
		ComputerPlayer autoPlayer = new ComputerPlayer(someStrategy);
		autoPlayer.setTotal(100);
		assertEquals(100, autoPlayer.getTotal());
	}

}
