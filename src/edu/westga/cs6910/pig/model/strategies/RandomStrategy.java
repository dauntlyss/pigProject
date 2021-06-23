package edu.westga.cs6910.pig.model.strategies;

/**
 * Implements the random game play strategy
 * 
 * @author Alyssa Harris
 * @version 6-20-2021
 *
 */
public class RandomStrategy implements PigStrategy {

	@Override
	public boolean rollAgain(int totalRollsThisTurn, int numberOfPointsThisTurn, int pointsNeededToWin) {
		int number = (int) (Math.random() * 10);
		
		if (pointsNeededToWin <= 0) {
			return false;
		} else if (numberOfPointsThisTurn >= 20) {
			return false;
		} else if (number < 5) {
			return false;
		}
		return true;
	}

}
