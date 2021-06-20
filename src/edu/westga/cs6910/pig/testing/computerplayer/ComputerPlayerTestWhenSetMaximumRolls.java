package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.Assert.fail;
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
public class ComputerPlayerTestWhenSetMaximumRolls {

	/**
	 * Test method for Computer Player's setMaximumRolls(int) error handling works properly.
	 */
	@Test
	public void testSetMaximumRollsWithIntParameterThrowsProperErrorGivenInvalidInput() {
		try {
			PigStrategy someStrategy = new CautiousStrategy();
			ComputerPlayer autoPlayer = new ComputerPlayer(someStrategy);
	        autoPlayer.setMaximumRolls(-1);
	             
	        fail();
	    } catch (IllegalArgumentException ex) {
	        assertEquals("Invalid number of rolls.", ex.getMessage());
	    }
	}
	
	/**
	 * Test method for Computer Player's setMaximumRolls(int) error handling works properly.
	 */
	@Test
	public void testSetMaximumRollsWithIntParameterThrowsProperErrorGivenNegative4AsInput() {
		try {
			PigStrategy someStrategy = new CautiousStrategy();
			ComputerPlayer autoPlayer = new ComputerPlayer(someStrategy);
	        autoPlayer.setMaximumRolls(-4);
	             
	        fail();
	    } catch (IllegalArgumentException ex) {
	        assertEquals("Invalid number of rolls.", ex.getMessage());
	    }
	}

}
