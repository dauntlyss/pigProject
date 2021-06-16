package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests to confirm Human Player subclass is working correctly.
 * 
 * @author Alyssa Harris
 * @version 06-15-21
 */
public class HumanPlayerTestWhenGetName {

	/**
	 * Test method for Human Player's getName() method.
	 */
	@Test
	public void testGetNameWhenNewHumanPlayer() {
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		assertEquals("Alyssa", realHumanPlayer.getName());
	}
	
	/**
	 * Test method for Human Player constructor method error handling.
	 */
	@Test
	public void testHumanPlayerWithInvalidHumanThrowsProperError() {
		try {
			HumanPlayer realHumanPlayer = new HumanPlayer(null);
			realHumanPlayer.getName();
	        fail();
	    } catch (IllegalArgumentException ex) {
	        assertEquals("Invalid name.", ex.getMessage());
	    }
	}

}
