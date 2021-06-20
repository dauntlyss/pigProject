package edu.westga.cs6910.pig.model.strategies;

/**
 * Defines the common interface for all the game play algorithms for Pig
 * 
 * @author Alyssa Harris
 * @version 6-20-2021
 */
public interface PigStrategy {
	/**
	 * Returns whether the player should roll again
	 * 
	 * @param totalRollsThisTurn		The number of rolls already taken this turn
	 * @param numberOfPointsThisTurn	The number of points rolled so far this turn
	 * @param pointsNeededToWin			The difference between the total points so far and the goal score
	 * 
	 * @return True if and only if the player should roll again
	 */
	boolean rollAgain(int totalRollsThisTurn, int numberOfPointsThisTurn, int pointsNeededToWin);
}
