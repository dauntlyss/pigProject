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
public class GameTestWhenIsGameOver {

	/**
	 * Test method for Game's isGameOver() method.
	 */
	@Test
	public void testIsGameOverWillReturnTrueIfHumanScoreConditionsMet() {
		PigStrategy someStrategy = new CautiousStrategy();
		ComputerPlayer autoPlayer = new ComputerPlayer(someStrategy);
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		Game pigGame = new Game(realHumanPlayer, autoPlayer);
		pigGame.startNewGame(realHumanPlayer);
		realHumanPlayer.setTotal(20);
		assertEquals(true, pigGame.isGameOver());
	}
	
	/**
	 * Test method for Game's isGameOver() method.
	 */
	@Test
	public void testIsGameOverWillReturnTrueIfComputerScoreConditionsMet() {
		PigStrategy someStrategy = new CautiousStrategy();
		ComputerPlayer autoPlayer = new ComputerPlayer(someStrategy);
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		Game pigGame = new Game(realHumanPlayer, autoPlayer);
		pigGame.startNewGame(autoPlayer);
		autoPlayer.setTotal(20);
		assertEquals(true, pigGame.isGameOver());
	}
	
	/**
	 * Test method for Game's isGameOver() method.
	 */
	@Test
	public void testIsGameOverWillReturnFalseIfComputerScoreConditionsNotMet() {
		PigStrategy someStrategy = new CautiousStrategy();
		ComputerPlayer autoPlayer = new ComputerPlayer(someStrategy);
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		Game pigGame = new Game(realHumanPlayer, autoPlayer);
		pigGame.startNewGame(autoPlayer);
		autoPlayer.setTotal(4);
		assertEquals(false, pigGame.isGameOver());
	}
	
	/**
	 * Test method for Game's isGameOver() method.
	 */
	@Test
	public void testIsGameOverWillReturnFalseIfHumanScoreConditionsNotMet() {
		PigStrategy someStrategy = new CautiousStrategy();
		ComputerPlayer autoPlayer = new ComputerPlayer(someStrategy);
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		Game pigGame = new Game(realHumanPlayer, autoPlayer);
		pigGame.startNewGame(realHumanPlayer);
		realHumanPlayer.setTotal(15);
		assertEquals(false, pigGame.isGameOver());
	}
	
}
