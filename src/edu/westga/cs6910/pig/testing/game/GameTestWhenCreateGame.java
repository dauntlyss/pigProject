package edu.westga.cs6910.pig.testing.game;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests to confirm Computer Player subclass is working correctly.
 * 
 * @author Alyssa Harris
 * @version 06-15-21
 */
public class GameTestWhenCreateGame {

	/**
	 * Test method for game constructor method.
	 */
	@Test
	public void testGameWithValidInputCreatesNewGame() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		Game pigGame = new Game(realHumanPlayer, autoPlayer);
		assertEquals("Goal Score: 20\r\n" 
				+ "Alyssa: 0\r\n" + "Simple computer: 0", pigGame.toString());
	}
	
	/**
	 * Test method for game constructor method error handling.
	 */
	@Test
	public void testGameWithInvalidHumanThrowsProperError() {
		try {
			ComputerPlayer autoPlayer = new ComputerPlayer();
			Game pigGame = new Game(null, autoPlayer);
	        pigGame.toString();     
	        fail();
	    } catch (IllegalArgumentException ex) {
	        assertEquals("Invalid Human Player.", ex.getMessage());
	    }
	}
	
	/**
	 * Test method for game constructor method error handling.
	 */
	@Test
	public void testGameWithInvalidComputerThrowsProperError() {
		try {
			HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
			Game pigGame = new Game(realHumanPlayer, null);
	        pigGame.toString();     
	        fail();
	    } catch (IllegalArgumentException ex) {
	        assertEquals("Invalid Computer Player.", ex.getMessage());
	    }
	}

}
