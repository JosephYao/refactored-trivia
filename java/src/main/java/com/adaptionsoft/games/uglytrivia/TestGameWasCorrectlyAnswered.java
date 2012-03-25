package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class TestGameWasCorrectlyAnswered extends Game {

	private boolean isCurrentPlayerInPenaltyBox;
	private boolean wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBoxIsCalled;
	private TestGameWasCorrectlyAnswered game;
	private boolean isGettingOutOfPenaltyBoxFlag;

	@Before public void createGameAndAddPlayer() {
		game = new TestGameWasCorrectlyAnswered();
		game.add("Player1");
		game.add("Player2");
		game.add("Player3");
		game.setIsCurrentPlayerInPenaltyBox(true);
	}
	
	@Test public void is_Getting_Out_Of_Penalty_Box() {
		game.setIsGettingOutOfPenaltyBoxFlag(true);
		
		game.wasCorrectlyAnswered();
		
		assertTrue(game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBoxIsCalled);
	}

	@Test public void current_Player_Move_To_Next_Player() {
		game.setIsGettingOutOfPenaltyBoxFlag(false);
		
		game.wasCorrectlyAnswered();
		
		assertEquals(1, game.currentPlayer);
	}
	
	@Test public void called_Three_Times_Current_Player_Back_To_First() {
		game.setIsGettingOutOfPenaltyBoxFlag(false);

		game.wasCorrectlyAnswered();
		game.wasCorrectlyAnswered();
		game.wasCorrectlyAnswered();
		
		assertEquals(0, game.currentPlayer);
	}
	
	@Test public void always_Return_True() {
		game.setIsGettingOutOfPenaltyBoxFlag(false);

		assertTrue(game.wasCorrectlyAnswered());
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
	
	protected boolean wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox() {
		wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBoxIsCalled = true;
		return true;
	}
	
	protected boolean isGettingOutOfPenaltyBox() {
		return isGettingOutOfPenaltyBoxFlag;
	}
	
	private void setIsGettingOutOfPenaltyBoxFlag(boolean value) {
		isGettingOutOfPenaltyBoxFlag = value;
	}
	
}
