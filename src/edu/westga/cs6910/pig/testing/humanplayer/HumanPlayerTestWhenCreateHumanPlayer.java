package edu.westga.cs6910.pig.testing.humanplayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.HumanPlayer;

/**
 * Tests to confirm Human Player subclass is working correctly.
 * 
 * @author Alyssa Harris
 * @version 06-15-21
 */
public class HumanPlayerTestWhenCreateHumanPlayer {

	/**
	 * Tests the Human Player subclass's constructor to confirm that it 
	 * creates HumanPlayer as expected.
	 */
	@Test
	public void testHumanPlayerPlayerConstructorCreatesNewHumanPlayer() {
		HumanPlayer realHumanPlayer = new HumanPlayer("Alyssa");
		assertEquals("Player with name: Alyssa, and new dice pips: 1, 1", realHumanPlayer.toString());
	}

}
