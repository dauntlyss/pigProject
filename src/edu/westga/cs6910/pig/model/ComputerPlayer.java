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
		super();
		if (someStrategy == null) {
			throw new IllegalArgumentException("Invalid strategy.");
		}
		this.strategy = someStrategy;
		this.setStrategy(someStrategy);
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */	
	public void takeTurn() {
		boolean computerTurn = true;
		int totalRollsThisTurn = 0;
		
		do {
			int theTotal = this.getTotal();
			int theTurnTotal = this.getTurnTotal();
			this.processTurn(computerTurn);
			totalRollsThisTurn++;
			int die1Value = this.getThePair().getDie1Value();
			int die2Value = this.getThePair().getDie2Value();
			if (die1Value == 1 || die2Value == 1) {
				this.resetTurnTotal();
				theTotal -= theTurnTotal;

			} else {		
				System.out.print(theTotal + "," + theTurnTotal);
				theTurnTotal = die1Value + die2Value;
				theTotal += die1Value + die2Value;
			}
			if (this.getDiceValues().contains("1")) {
				computerTurn = false;
				
			}
		} while (computerTurn && this.strategy.rollAgain(totalRollsThisTurn, this.getTurnTotal(), (Game.GOAL_SCORE - this.getTotal())));
				
	}
	
	/**
	 * Sets which strategy the player will use
	 * 
	 * @param someStrategy
	 * 
	 * @precondition	someStrategy != null
	 * @postcondition	specified strategy will determine how the player will play
	 */
	public void setStrategy(PigStrategy someStrategy) {
		if (someStrategy == null) {
			throw new IllegalArgumentException("Invalid strategy.");
		}
		this.strategy = someStrategy;
	}

}
