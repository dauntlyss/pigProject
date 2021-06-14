package edu.westga.cs6910.pig.testing.die;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.Die;

/**
 * Tests to confirm Die class is working correctly.
 * 
 * @author Alyssa Harris
 * @version 06-14-21
 */
public class DieTestWhenGetPips {

	/**
	 * Tests the Die class's getNumberOfPips() method to confirm that it creates
	 * expected number of pips.
	 */
	@Test
	public void testWithNewDieShouldHave1Pip() {
	    Die newDie = new Die();
	    assertEquals(1, newDie.getNumberOfPips());
	}

}
