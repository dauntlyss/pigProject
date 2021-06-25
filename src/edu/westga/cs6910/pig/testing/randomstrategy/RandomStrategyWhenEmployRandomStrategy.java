package edu.westga.cs6910.pig.testing.randomstrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.RandomStrategy;

/**
 * Tests to confirm Random Strategy subclass is working correctly.
 * 
 * @author Alyssa Harris
 * @version 06-20-21
 */
public class RandomStrategyWhenEmployRandomStrategy {

	/**
	 * Test method for RandomStrategy's rollAgain(int, int, int) method.
	 */
	@Test
	public void testRollAgainWillRollAgainIfNumberOfPointsThisTurnIsLessThan20() {
		RandomStrategy winningStrategy = new RandomStrategy();
		boolean shouldRoll = winningStrategy.rollAgain(0, 4, 19);
		assertEquals(false, shouldRoll);
	}
	
	/**
	 * Test method for GreedyStrategy's rollAgain(int, int, int) method.
	 */
	@Test
	public void testRollAgainWillNotRollAgainIfNumberOfPointsThisTurnIsMoreThan20() {
		RandomStrategy winningStrategy = new RandomStrategy();
		boolean shouldRoll = winningStrategy.rollAgain(0, 21, 22);
		assertEquals(false, shouldRoll);
	}
	
	/**
	 * Test method for GreedyStrategy's rollAgain(int, int, int) method.
	 */
	@Test
	public void testRollAgainWillNotRollAgainIfPointsNeededToWinIs0() {
		RandomStrategy winningStrategy = new RandomStrategy();
		boolean shouldRoll = winningStrategy.rollAgain(0, 0, 0);
		assertEquals(false, shouldRoll);
	}

	/**
	 * Test method for GreedyStrategy's rollAgain(int, int, int) method.
	 */
	@Test
	public void testRollAgainWillNotRollAgainIfPointsNeededToWinIsMoreThan0() {
		RandomStrategy winningStrategy = new RandomStrategy();
		boolean shouldRoll = winningStrategy.rollAgain(0, 20, 20);
		assertEquals(false, shouldRoll);
	}

}
