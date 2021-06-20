package edu.westga.cs6910.pig.model;

import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * ComputerPlayer represents a very simple automated player in the game Pig.
 * It rolls exactly 1 time and then holds.
 * 
 * @author CS6910, Alyssa Harris
 * @version Summer 2021
 */
public class ComputerPlayer extends AbstractPlayer {
	private PigStrategy strategy;
	/**
	 * Creates a new ComputerPlayer with the specified name and strategy
	 * 
	 * @param someStrategy	the strategy for the player
	 * 
	 * @precondition	someStrategy != null
	 * 
	 */
	
	public ComputerPlayer(PigStrategy someStrategy) {
		super(someStrategy);
		this.strategy = someStrategy;
		
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */	
	public void takeTurn() {
		boolean computerTurn = true;
		this.processTurn(computerTurn);		
	}

}
