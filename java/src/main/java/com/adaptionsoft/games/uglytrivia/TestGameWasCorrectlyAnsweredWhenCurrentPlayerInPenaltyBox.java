package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class TestGameWasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox extends Game {

	private boolean isGettingOutOfPenaltyBoxFlag;
	private boolean wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox_IsCalled;
	private boolean wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_Not_isGettingOutOfPenaltyBox_IsCalled;
	private TestGameWasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox game;

	@Before public void createGameAndAddPlayer() {
		game = new TestGameWasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox();
		game.add("Player1");
	}
	
	@Test public void is_Getting_Out_Of_Penalty_Box() {
		game.setIsGettingOutOfPenaltyBoxFlag(true);
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox();
		
		assertTrue(game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox_IsCalled);
	}

	@Test public void is_Not_Getting_Out_Of_Penalty_Box() {
		game.setIsGettingOutOfPenaltyBoxFlag(false);
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox();
		
		assertTrue(game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_Not_isGettingOutOfPenaltyBox_IsCalled);
	}
	
	protected boolean isGettingOutOfPenaltyBox() {
		return isGettingOutOfPenaltyBoxFlag;
	}
	
	private void setIsGettingOutOfPenaltyBoxFlag(boolean value) {
		isGettingOutOfPenaltyBoxFlag = value;
	}
	
	protected boolean wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox() {
		wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox_IsCalled = true;
		return true;
	}
	
	protected boolean wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_Not_isGettingOutOfPenaltyBox() {
		wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_Not_isGettingOutOfPenaltyBox_IsCalled = true;
		return true;
	}
	
}
