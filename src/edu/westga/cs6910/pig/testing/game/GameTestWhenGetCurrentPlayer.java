package edu.westga.cs6910.pig.testing.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.ComputerPlayer;
import edu.westga.cs6910.pig.model.Game;
import edu.westga.cs6910.pig.model.HumanPlayer;
import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;
import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * Tests to confirm Computer Player subclass is working correctly.
 * 
 * @author Alyssa Harris
 * @version 06-15-21
 */
public class GameTestWhenGetCurrentPlayer {

	/**
	 * Test method for Game's getCurrentPlayer().
	 */
	@Test
	public void testGetCurrentPlayerWillReturnNullBeforeGameStarts() {
		PigStrategy someStrategy = new CautiousStrategy();
		ComputerPlayer autoPlayer = new ComputerPlayer(someStrategy);
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		Game pigGame = new Game(realHumanPlayer, autoPlayer);
		assertEquals(null, pigGame.getCurrentPlayer());
	}
	
	/**
	 * Test method for Game's getCurrentPlayer().
	 */
	@Test
	public void testGetCurrentPlayerWillReturnCurrentFirstPlayerAfterGameStarts() {
		PigStrategy someStrategy = new CautiousStrategy();
		ComputerPlayer autoPlayer = new ComputerPlayer(someStrategy);
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		Game pigGame = new Game(realHumanPlayer, autoPlayer);
		pigGame.startNewGame(autoPlayer);
		assertEquals(autoPlayer, pigGame.getCurrentPlayer());
	}
	
	/**
	 * Test method for Game's getCurrentPlayer().
	 */
	@Test
	public void testGetCurrentPlayerWillReturnCurrentFirstPlayerHumanAfterGameStarts() {
		PigStrategy someStrategy = new CautiousStrategy();
		ComputerPlayer autoPlayer = new ComputerPlayer(someStrategy);
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		Game pigGame = new Game(realHumanPlayer, autoPlayer);
		pigGame.startNewGame(realHumanPlayer);
		assertEquals(realHumanPlayer, pigGame.getCurrentPlayer());
	}

}
