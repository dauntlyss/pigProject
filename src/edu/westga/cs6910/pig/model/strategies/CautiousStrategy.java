package edu.westga.cs6910.pig.model.strategies;

/**
 * Implements the most cautious game play strategy
 * 
 * @author Alyssa Harris
 * @version 6-20-2021
 *
 */
public class CautiousStrategy implements PigStrategy {

	@Override
	public boolean rollAgain(int totalRollsThisTurn, int numberOfPointsThisTurn, int pointsNeededToWin) {
		return false;
	}

}
