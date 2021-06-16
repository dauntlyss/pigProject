package edu.westga.cs6910.pig.testing.game;

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
public class GameTestWhenHold {

	/**
	 * Test method for game hold() method.
	 */
	@Test
	public void testHoldWillSwitchCurrentPlayer() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		Game pigGame = new Game(realHumanPlayer, autoPlayer);
		pigGame.startNewGame(realHumanPlayer);
		pigGame.hold();
		assertEquals(autoPlayer, pigGame.getCurrentPlayer());
	}
	
	/**
	 * Test method for game hold() method.
	 */
	@Test
	public void testHoldWillSwitchCurrentPlayerMultipleTimes() {
		ComputerPlayer autoPlayer = new ComputerPlayer();
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		Game pigGame = new Game(realHumanPlayer, autoPlayer);
		pigGame.startNewGame(realHumanPlayer);
		pigGame.hold();
		pigGame.hold();
		pigGame.hold();
		assertEquals(autoPlayer, pigGame.getCurrentPlayer());
	}

}
