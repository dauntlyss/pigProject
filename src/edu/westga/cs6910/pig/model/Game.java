package edu.westga.cs6910.pig.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Game represents a Pig game.
 * @author CS6910, Alyssa Harris
 * @version Summer 2021
 */
public class Game implements Observable {
	/**
	 * The goal score for the game
	 */
	public static final int GOAL_SCORE = 20;

	private ObjectProperty<Player> currentPlayerObject;	
	private HumanPlayer theHuman;
	private ComputerPlayer theComputer;

	private DicePair thePair;

	/**
	 * Creates a Pig Game with the specified Players and
	 * a pair of dice.
	 * 
	 * @param theComputer	the automated player
	 * @param theHuman		the human player
	 * 
	 * @require				theHuman != null && theComputer != null
	 * 
	 * @ensure				humanPlayer().equals(theHuman) &&
	 *         				computerPlayer.equals(theComputer)
	 */
	public Game(HumanPlayer theHuman, ComputerPlayer theComputer) {
		if (theHuman == null) {
			throw new IllegalArgumentException("Invalid Human Player.");
		}
		if (theComputer == null) {
			throw new IllegalArgumentException("Invalid Computer Player.");
		}
		this.theHuman = theHuman;
		this.theComputer = theComputer;
		
		this.currentPlayerObject = new SimpleObjectProperty<Player>();
		
		this.thePair = new DicePair();
		
	}

	/**
	 * Initializes the game for play.
	 * 
	 * @param firstPlayer 	the Player who takes the first turn
	 * 
	 * @require 			firstPlayer != null && 
	 * 						!firstPlayer.equals(secondPlayer)
	 * 
	 * @ensures 			whoseTurn().equals(firstPlayer) &&
	 * 						firstPlayer.getTotal() == 0
	 */
	public void startNewGame(Player firstPlayer) {
		if (firstPlayer == null) {
			throw new IllegalArgumentException("Invalid First Player.");
		}
		
		this.currentPlayerObject.setValue(firstPlayer); 
			
		this.thePair = new DicePair();		
	}

	/**
	 * Conducts a move in the game, allowing the appropriate Player to
	 * take a turn. Has no effect if the game is over.
	 * 
	 * @requires	!isGameOver()
	 * 
	 * @ensures		!whoseTurn().equals(whoseTurn()@prev)
	 */
	public void play() {
		
		Player currentPlayer = this.currentPlayerObject.getValue();
		this.currentPlayerObject.getValue().takeTurn();

		this.currentPlayerObject.setValue(null);
		this.currentPlayerObject.setValue(currentPlayer);
		
		if (!this.currentPlayerObject.getValue().getIsMyTurn()) {		
			this.hold();
			this.currentPlayerObject.getValue().resetTurnTotal();
		}
	}
	
	/**
	 * Notifies the game that the player is holding
	 * 
	 * @requires	!isGameOver()
	 * 
	 * @ensures		!whoseTurn().equals(whoseTurn()@prev)
	 */
	public void hold() {
		this.swapWhoseTurn();
		this.isGameOver();
	}

	/**
	 * Returns the human Player object.
	 * 
	 * @return the human Player
	 */
	public HumanPlayer getHumanPlayer() {
		return this.theHuman;
	}

	/**
	 * Returns the computer Player object.
	 * 
	 * @return the computer Player
	 */
	public ComputerPlayer getComputerPlayer() {
		return this.theComputer;
	}
	
	/**
	 * Returns the Player whose turn it is.
	 * 
	 * @return	the current Player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayerObject.getValue();
	}

	/**
	 * Return whether the game is over.
	 * 
	 * @return true iff currentPlayer.getTotal() >= GOAL_SCORE
	 */
	public boolean isGameOver() {	
		if (this.currentPlayerObject.getValue() == null) {
			return true;
		}
		
		if (this.theHuman.getTotal() >= GOAL_SCORE
				|| this.theComputer.getTotal() >= GOAL_SCORE) {
			return true;
		}
		return false;
	}
	
	/** 
	 * Returns the pair of dice being used in the game
	 * 
	 * @return	the pair of dice
	 */
	public DicePair getDicePair() {
		return this.thePair;
	}

	/**
	 * Returns a String showing the goal score, or, if
	 * the game is over, the name of the winner.
	 * 
	 * @return a String representation of this Game
	 */
	public String toString() {	
		String result = "~~ Game Info ~~\n Goal Score: " + GOAL_SCORE;
		result += System.getProperty("line.separator")
				+ this.theHuman.getName() + ": "
				+ this.theHuman.getTotal();
		result += System.getProperty("line.separator")
				+ this.theComputer.getName() + ": "
						+ this.theComputer.getTotal();

		if (this.theHuman.getTotal() >= GOAL_SCORE) {
			return result + System.getProperty("line.separator")
					+ "Game over! Winner: " + this.theHuman.getName();
		} else if (this.theComputer.getTotal() >= GOAL_SCORE) {
			return result + System.getProperty("line.separator")
					+ "Game over! Winner: " + this.theComputer.getName();
		} else {
			return result;
		}
	}
	
	/**
	 * Returns a String showing a synopsis of the roll and encouraging words
	 * or trash talk.
	 * 
	 * @return rundown	the synopsis and analysis of the game as it goes on
	 */
	public String showRundown() {
		String rundown = "";
		if (this.theComputer.getTotal() == 0 && this.theHuman.getTotal() == 0) {
			rundown = "Good luck to both players!";
		} else if (this.theComputer.getTotal() == 10) {
			rundown = this.theComputer.getName() + " is halfway to a win!";
		} else if (this.theHuman.getTotal() == 10) {
			rundown = this.theHuman.getName() + " is halfway to a win!";
		} else if ((this.theComputer.getTotal() - Game.GOAL_SCORE) == 5) {
			rundown = this.theComputer.getName() + " is almost to the goal score!";
		} else if ((this.theHuman.getTotal() - Game.GOAL_SCORE) == 5) {
			rundown = this.theHuman.getName() + " is almost to the goal score!";
		} else if ((this.theComputer.getTotal() - Game.GOAL_SCORE) == 0 || (this.theHuman.getTotal() - Game.GOAL_SCORE) == 0) {
			rundown = "Congrats, " + this.getCurrentPlayer().getName();
		}
		
		return rundown;
	}

	private void swapWhoseTurn() {
		Player currentPlayer = this.currentPlayerObject.getValue();
		if (currentPlayer == this.theHuman) {
			currentPlayer = this.theComputer;
		} else {
			currentPlayer = this.theHuman;
		}
		this.currentPlayerObject.setValue(currentPlayer);

	}

	@Override
	public void addListener(InvalidationListener theListener) {
		this.currentPlayerObject.addListener(theListener);
	}

	@Override
	public void removeListener(InvalidationListener theListener) {
		this.currentPlayerObject.removeListener(theListener);
	}
	
}
