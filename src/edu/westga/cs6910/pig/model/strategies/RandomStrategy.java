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
		System.out.print("\nNUMBER:" + number + "\n");
		
		if (pointsNeededToWin <= 0) {
			System.out.print("PN2W < 0");
			return false;
		} else if (numberOfPointsThisTurn >= 20) {
			System.out.print("Points > 20");
			return false;
		} else if (number < 5) {
			System.out.print("Number < 3");
			return false;
		}
		return true;
	}

}
