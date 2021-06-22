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
		System.out.print("Rolling");
		if (pointsNeededToWin <= 0) {
			System.out.print("PN2W < 0");
			return false;
		} else if (numberOfPointsThisTurn >= 20) {
			System.out.print("Points > 20");
			return false;
		} else if (totalRollsThisTurn > 2) {
			System.out.print("Turns > 3");
			return false;
		}
		return true;
//		do {
//			return true;
//		} while (numberOfPointsThisTurn < 20 || pointsNeededToWin > 0);
//		return !(totalRollsThisTurn > 3 || numberOfPointsThisTurn >= 20 || pointsNeededToWin <= 0);
	}

}
