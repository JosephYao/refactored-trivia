package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class TestGameWasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox extends Game {

	private boolean isGettingOutOfPenaltyBoxFlag;
	private TestGameWasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox game;
	private boolean wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_IsCalled;

	@Before public void createGameAndAddPlayer() {
		game = new TestGameWasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox();
		game.add("Player1");
		game.add("Player2");
		game.add("Player3");
	}
	
	@Test public void is_Getting_Out_Of_Penalty_Box() {
		game.setIsGettingOutOfPenaltyBoxFlag(true);
		
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox();
		
		assertTrue(game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_IsCalled);
	}

	@Test public void current_Player_Move_To_Next_Player() {
		game.setIsGettingOutOfPenaltyBoxFlag(false);
		
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox();
		
		assertEquals(1, game.currentPlayer);
	}
	
	@Test public void called_Three_Times_Current_Player_Back_To_First() {
		game.setIsGettingOutOfPenaltyBoxFlag(false);

		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox();
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox();
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox();
		
		assertEquals(0, game.currentPlayer);
	}
	
	@Test public void always_Return_True() {
		game.setIsGettingOutOfPenaltyBoxFlag(false);

		assertTrue(game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox());
	}
	
	protected boolean isGettingOutOfPenaltyBox() {
		return isGettingOutOfPenaltyBoxFlag;
	}
	
	private void setIsGettingOutOfPenaltyBoxFlag(boolean value) {
		isGettingOutOfPenaltyBoxFlag = value;
	}
	
	protected boolean wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox() {
		wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_IsCalled = true;
		return true;
	}
	
}
