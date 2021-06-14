package edu.westga.cs6910.pig.testing.die;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * Tests to confirm Die class is working correctly.
 * 
 * @author Alyssa Harris
 * @version 06-14-21
 */
public class DieTestWhenDieIsRolled {

	/**
	 * Tests the Die class's roll() method to confirm that it never
	 * produces number less than 1 or greater than 6
	 */
	@Test
	public void testRoll() {
		Die testDie = new Die();
	    for (int count = 0; count < 10000; count++) {
	    	testDie.roll();
	    	if (testDie.getNumberOfPips() < 1 || testDie.getNumberOfPips() > 6) {
	    		fail("Rolled a die with value: "  + testDie.getNumberOfPips());
	    	}
	    }
	}

}
