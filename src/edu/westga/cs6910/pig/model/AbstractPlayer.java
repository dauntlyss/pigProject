package edu.westga.cs6910.pig.model;

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
	private String name;
	
	/**
	 * Constructor used to create a human Player. 
	 * @param name	Name of player
	 * 
	 * @requires	name != null
	 * @ensure		name().equals(name) && getTotal() == 0
	 */
	public AbstractPlayer(String name) {
		this.name = name;
		this.thePair = new DicePair();
	}
	
	/**
	 * Constructor used to create a computer Player. 
	 * 
	 * @requires	name != null
	 * @ensure		name().equals(name) && getTotal() == 0
	 */
	public AbstractPlayer() {
		this.name = NAME;
		this.thePair = new DicePair();
	}
	
	/**
	 * Returns Dice Pair
	 * @return the thePair
	 */
	public DicePair getThePair() {
		return this.thePair;
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
	 * Processes turns
	 * 
	 * @param computerTurn true if is computer turn / false if not
	 */
	public void processTurn(boolean computerTurn) {
		this.getThePair().rollDice();
		
		int die1Value = this.getThePair().getDie1Value();
		int die2Value = this.getThePair().getDie2Value();
		if (die1Value == 1 || die2Value == 1) {
			this.total -= this.turnTotal;
			this.isMyTurn = false;
		} else {
			this.turnTotal += die1Value + die2Value;
			this.total += die1Value + die2Value;
			this.isMyTurn = true;
		}
	}
}
