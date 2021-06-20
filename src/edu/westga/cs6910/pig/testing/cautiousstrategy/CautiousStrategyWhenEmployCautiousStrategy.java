package edu.westga.cs6910.pig.testing.cautiousstrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.CautiousStrategy;

/**
 * Tests to confirm Cautious Strategy subclass is working correctly.
 * 
 * @author Alyssa Harris
 * @version 06-20-21
 */
public class CautiousStrategyWhenEmployCautiousStrategy {

	/**
	 * Test method for CautiousStrategy's rollAgain(int, int, int) method.
	 */
	@Test
	public void testRollAgainMethodWillReturnFalse() {
		CautiousStrategy winningStrategy = new CautiousStrategy();
		boolean shouldRoll = winningStrategy.rollAgain(0, 0, 20);
		assertEquals(false, shouldRoll);
	}

}
