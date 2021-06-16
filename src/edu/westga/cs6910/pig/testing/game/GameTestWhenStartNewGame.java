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
public class GameTestWhenStartNewGame {

	/**
	 * Test method for game startNewGame method.
	 */
	@Test
	public void testStartNewGameWillStartNewGameWithHumanFirst() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		Game pigGame = new Game(realHumanPlayer, autoPlayer);
		pigGame.startNewGame(realHumanPlayer);
		assertEquals(realHumanPlayer, pigGame.getCurrentPlayer());
	}
	
	/**
	 * Test method for game startNewGame method.
	 */
	@Test
	public void testStartNewGameWillStartNewGameWithComputerFirst() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		Game pigGame = new Game(realHumanPlayer, autoPlayer);
		pigGame.startNewGame(autoPlayer);
		assertEquals(autoPlayer, pigGame.getCurrentPlayer());
	}
	
	/**
	 * Test method for startNewGame method error handling.
	 */
	@Test
	public void testStartNewGameInvalidFirstPlayerThrowsProperError() {
		try {
			ComputerPlayer autoPlayer = new ComputerPlayer();
			HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
			Game pigGame = new Game(realHumanPlayer, autoPlayer);
			pigGame.startNewGame(null);   
	        fail();
	    } catch (IllegalArgumentException ex) {
	        assertEquals("Invalid First Player.", ex.getMessage());
	    }
	}

}
