package edu.westga.cs6910.pig.testing.greedystrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.GreedyStrategy;

/**
 * Tests to confirm Greedy Strategy subclass is working correctly.
 * 
 * @author Alyssa Harris
 * @version 06-20-21
 */
public class GreedyStrategyWhenEmployGreedyStrategy {

	/**
	 * Test method for GreedyStrategy's rollAgain(int, int, int) method.
	 */
	@Test
	public void testRollAgainWillRollAgainIfTotalRollsIsLessThan3() {
		GreedyStrategy winningStrategy = new GreedyStrategy();
		boolean shouldRoll = winningStrategy.rollAgain(2, 0, 20);
		assertEquals(true, shouldRoll);
	}
	
	/**
	 * Test method for GreedyStrategy's rollAgain(int, int, int) method.
	 */
	@Test
	public void testRollAgainNotWillRollAgainIfTotalRollsIsMoreThan3() {
		GreedyStrategy winningStrategy = new GreedyStrategy();
		boolean shouldRoll = winningStrategy.rollAgain(4, 0, 20);
		assertEquals(false, shouldRoll);
	}
	
	/**
	 * Test method for GreedyStrategy's rollAgain(int, int, int) method.
	 */
	@Test
	public void testRollAgainWillRollAgainIfNumberOfPointsThisTurnIsLessThan20() {
		GreedyStrategy winningStrategy = new GreedyStrategy();
		boolean shouldRoll = winningStrategy.rollAgain(0, 4, 20);
		assertEquals(true, shouldRoll);
	}
	
	/**
	 * Test method for GreedyStrategy's rollAgain(int, int, int) method.
	 */
	@Test
	public void testRollAgainWillNotRollAgainIfNumberOfPointsThisTurnIsMoreThan20() {
		GreedyStrategy winningStrategy = new GreedyStrategy();
		boolean shouldRoll = winningStrategy.rollAgain(0, 21, 20);
		assertEquals(false, shouldRoll);
	}
	
	/**
	 * Test method for GreedyStrategy's rollAgain(int, int, int) method.
	 */
	@Test
	public void testRollAgainWillNotRollAgainIfPointsNeededToWinIs0() {
		GreedyStrategy winningStrategy = new GreedyStrategy();
		boolean shouldRoll = winningStrategy.rollAgain(0, 0, 0);
		assertEquals(false, shouldRoll);
	}

	/**
	 * Test method for GreedyStrategy's rollAgain(int, int, int) method.
	 */
	@Test
	public void testRollAgainWillNotRollAgainIfPointsNeededToWinIsMoreThan0() {
		GreedyStrategy winningStrategy = new GreedyStrategy();
		boolean shouldRoll = winningStrategy.rollAgain(0, 21, 20);
		assertEquals(false, shouldRoll);
	}

}
