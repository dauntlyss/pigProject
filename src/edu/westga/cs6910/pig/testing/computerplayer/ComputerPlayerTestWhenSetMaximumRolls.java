package edu.westga.cs6910.pig.testing.computerplayer;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;

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
			ComputerPlayer autoPlayer = new ComputerPlayer();
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
			ComputerPlayer autoPlayer = new ComputerPlayer();
	        autoPlayer.setMaximumRolls(-4);
	             
	        fail();
	    } catch (IllegalArgumentException ex) {
	        assertEquals("Invalid number of rolls.", ex.getMessage());
	    }
	}

}
