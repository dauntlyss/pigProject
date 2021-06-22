package edu.westga.cs6910.pig.model.strategies;

/**
 * Implements the random game play strategy
 * 
 * @author Alyssa Harris
 * @version 6-20-2021
 *
 */
public class GreedyStrategy implements PigStrategy {

	@Override
	public boolean rollAgain(int totalRollsThisTurn, int numberOfPointsThisTurn, int pointsNeededToWin) {
		return !(totalRollsThisTurn > 3 || numberOfPointsThisTurn > 20 || pointsNeededToWin <= 0);
	}

}
