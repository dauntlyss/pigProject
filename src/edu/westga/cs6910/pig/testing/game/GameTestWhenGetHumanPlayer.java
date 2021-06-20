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
public class GameTestWhenGetHumanPlayer {

	/**
	 * Test method for Game's getHumanPlayer() method.
	 */
	@Test
	public void testGetHumanPlayerWillGetHumanPlayer() {
		PigStrategy someStrategy = new CautiousStrategy();
		ComputerPlayer autoPlayer = new ComputerPlayer(someStrategy);
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		Game pigGame = new Game(realHumanPlayer, autoPlayer);
		assertEquals(realHumanPlayer, pigGame.getHumanPlayer());
	}

}
