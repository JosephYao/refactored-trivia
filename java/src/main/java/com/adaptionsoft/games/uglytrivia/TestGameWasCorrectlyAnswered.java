package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class TestGameWasCorrectlyAnswered extends Game {

	private boolean isCurrentPlayerInPenaltyBox;
	private boolean wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBoxIsCalled;
	private boolean wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBoxIsCalled;
	private TestGameWasCorrectlyAnswered game;

	@Before public void createGameAndAddPlayer() {
		game = new TestGameWasCorrectlyAnswered();
		game.add("Player1");
	}
	
	@Test public void wasCorrectlyAnswered_When_In_Penalty_Box() {
		game.setIsCurrentPlayerInPenaltyBox(true);
		
		game.wasCorrectlyAnswered();
		
		assertTrue(game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBoxIsCalled);
	}

	@Test public void wasCorrectlyAnswered_When_Not_In_Penalty_Box() {
		game.setIsCurrentPlayerInPenaltyBox(false);
		
		game.wasCorrectlyAnswered();
		
		assertTrue(game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBoxIsCalled);
	}
	
	private void setIsCurrentPlayerInPenaltyBox(boolean value) {
		isCurrentPlayerInPenaltyBox = value;
	}
	
	protected boolean isCurrentPlayerInPenaltyBox() {
		return isCurrentPlayerInPenaltyBox;
	}
	
	protected boolean wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox() {
		wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBoxIsCalled = true;
		return true;
	}
	
	protected boolean wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox() {
		wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBoxIsCalled = true;
		return true;
	}
	
}
