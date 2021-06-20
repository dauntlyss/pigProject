package edu.westga.cs6910.pig.model;

import edu.westga.cs6910.pig.model.strategies.PigStrategy;

/**
 * Implements the shared code from ComputerPlayer and HumanPlayer Classes
 * 
 * @author Alyssa Harris
 * @version 06-08-21
 */
public abstract class AbstractPlayer implements Player {
	private static final String NAME = "Simple computer";
	private DicePair thePair;
	private boolean isMyTurn;
	private int total;
	private int turnTotal;
	private int maximumRolls;
	private String name;
	private PigStrategy strategy;
	
	/**
	 * Constructor used to create a human Player. 
	 * @param name	Name of player
	 * 
	 * @requires	name != null
	 * @ensure		name().equals(name) && getTotal() == 0
	 */
	public AbstractPlayer(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid name.");
		}
		
		this.name = name;
		this.thePair = new DicePair();
	}
	
	/**
	 * Constructor used to create a computer Player. 
	 * 
	 * @param someStrategy	Strategy to be used
	 * 
	 * @requires	strategy != null 
	 * @ensure		name().equals(name) && getTotal() == 0
	 */
	public AbstractPlayer(PigStrategy someStrategy) {
		if (someStrategy == null) {
			throw new IllegalArgumentException("Invalid strategy.");
		}
		this.name = NAME;
		this.thePair = new DicePair();
	
	}
	
	/**
	 * Returns a string representation of the object
	 * 
	 * @return playerInfo	Player information
	 */
	public String toString() {
		String playerInfo = "Player with name: " + this.name 
				+ ", and new dice " + this.thePair.toString();
		return playerInfo;
	}
	
	@Override
	/**
	 * @see Player#resetTurnTotal()
	 */	
	public void resetTurnTotal() {
		this.turnTotal = 0;
	}

	/**
	 * sets the total score
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * Sets the turn total
	 * @param turnTotal the turnTotal to set
	 */
	public void setTurnTotal(int turnTotal) {
		this.turnTotal = turnTotal;
	}

	@Override	
	/**
	 * @see Player#getIsMyTurn()
	 */
	public boolean getIsMyTurn() {
		return this.isMyTurn;
	}
	
	/**
	 * Sets the isMyTurn variable
	 * @param isMyTurn the isMyTurn to set
	 */
	public void setMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}

	@Override	
	/**
	 * @see Player#getName()
	 */
	public String getName() {
		return this.name;
	}
	
	@Override	
	/**
	 * @see Player#getTurnTotal()
	 */
	public int getTurnTotal() {
		return this.turnTotal;
	}
	
	@Override	
	/**
	 * @see Player#getTotal()
	 */
	public int getTotal() {
		return this.total;
	}	
	
	@Override	
	/**
	 * @see Player#getDiceValues()
	 */
	public String getDiceValues() {	
		return this.thePair.getDie1Value() + ", " + this.thePair.getDie2Value();
	}
	
	/**
	 * Implements Player's setMaximumRolls, but is not normally
	 * called by client objects.  Instead, clients usually
	 * call the 0-parameter version
	 * 
	 * @param	maximumRolls	The maximum number of times the computer
	 * 							will roll before holding
	 * @requires	maximumRolls > 0
	 * @ensure		this.maximumRolls.equals(maximumRolls) && maximumRolls > 0
	 */
	public void setMaximumRolls(int maximumRolls) {
		if (maximumRolls < 0) {
			throw new IllegalArgumentException("Invalid number of rolls.");
		}
		
		this.maximumRolls = maximumRolls;
	}

	/**
	 * Implements Player's setMaximumRolls() to set the 
	 * maximum number of rolls to 1
	 * 
	 */
	public void setMaximumRolls() {
		this.maximumRolls = 1;
	}
	
	/**
	 * Processes turns
	 * 
	 * @param computerTurn true if is computer turn / false if not
	 */
	public void processTurn(boolean computerTurn) {
		if (!computerTurn) {
			this.humanTurn();
		} else {
			this.computerTurn();
		}
	}
	
	/**
	 * Processes a human's turn
	 */
	private void humanTurn() {
		this.thePair.rollDice();
		
		int die1Value = this.thePair.getDie1Value();
		int die2Value = this.thePair.getDie2Value();
		if (die1Value == 1 || die2Value == 1) {	
			this.total -= this.turnTotal;
			this.isMyTurn = false;
		} else {
			this.turnTotal += die1Value + die2Value;
			this.total += die1Value + die2Value;
			this.isMyTurn = true;
		}
	}
	
	/**
	 * Processes a computer's turn
	 */
	private void computerTurn() {
		
		for (int count = 0; count < this.maximumRolls; count++) {
			this.thePair.rollDice();
			
			int die1Value = this.thePair.getDie1Value();
			int die2Value = this.thePair.getDie2Value();
			if (die1Value == 1 || die2Value == 1) {
				this.resetTurnTotal();
				this.total -= this.turnTotal;
				this.isMyTurn = false;
				return;
			} else {		
				this.turnTotal = die1Value + die2Value;
				this.total += die1Value + die2Value;		
			}		
		}
		this.isMyTurn = false;
	}
}
