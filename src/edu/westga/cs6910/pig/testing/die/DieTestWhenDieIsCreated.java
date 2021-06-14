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
public class DieTestWhenDieIsCreated {

	/**
	 * Tests the Die class's constructor and toString method to confirm that it creates
	 * die as expected.
	 */
	@Test
	public void testShouldProduceDieWith1Pip() {
	    Die newDie = new Die();
	    assertEquals("pips: 1", newDie.toString());
	}

}
