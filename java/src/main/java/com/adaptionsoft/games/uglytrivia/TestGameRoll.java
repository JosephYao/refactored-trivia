package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class TestGameRoll extends Game {

	private static final int ROLL_NOT_GET_OUT_OF_PENALTY_BOX = 2;
	private static final int ROLL_GET_OUT_OF_PENALTY_BOX = 1;
	private MockGame mockGame;
	private StubGamePlayers stubGamePlayers;

	private class MockGame extends Game {
		private boolean rollWhenNotInPenaltyBoxIsCalled;
		private int rollWhenNotInPenaltyBoxParameterRoll;

		public MockGame(GameQuestions gameQuestions, GamePlayers gamePlayers) {
			super(gameQuestions, gamePlayers);
		}
		
		protected void rollWhenNotInPenaltyBox(int roll) {
			rollWhenNotInPenaltyBoxIsCalled = true;
			rollWhenNotInPenaltyBoxParameterRoll = roll;
		}
	}
	
	private class StubGamePlayers extends GamePlayers {
		
		private boolean isCurrentPlayerInPenaltyBox;

		public boolean isCurrentPlayerInPenaltyBox() {
			return isCurrentPlayerInPenaltyBox;
		}

		public void setIsCurrentPlayerInPenaltyBox(boolean value) {
			isCurrentPlayerInPenaltyBox = value;
		}
		
	}
	
	@Before public void createGameAndAddPlayer() {
		stubGamePlayers = new StubGamePlayers();
		mockGame = new MockGame(new GameQuestions(), stubGamePlayers);
		mockGame.add("Player1");
	}
	
	@Test public void current_Player_In_Penalty_Box_And_Is_Not_Get_Out_Of_Penalty_Box() {
		stubGamePlayers.setIsCurrentPlayerInPenaltyBox(true);
		mockGame.roll(ROLL_NOT_GET_OUT_OF_PENALTY_BOX);
		
		assertFalse(mockGame.rollWhenNotInPenaltyBoxIsCalled);
	}

	@Test public void current_Player_In_Penalty_Box_And_Is_Get_Out_Of_Penalty_Box() {
		stubGamePlayers.setIsCurrentPlayerInPenaltyBox(true);
		mockGame.roll(ROLL_GET_OUT_OF_PENALTY_BOX);
		
		assertRollWhenNotInPenaltyBoxIsCalledWithCorrectParameter(ROLL_GET_OUT_OF_PENALTY_BOX);
	}

	@Test public void current_Player_Not_In_Penalty_Box_And_Is_Not_Get_Out_Of_Penalty_Box() {
		stubGamePlayers.setIsCurrentPlayerInPenaltyBox(false);
		mockGame.roll(ROLL_NOT_GET_OUT_OF_PENALTY_BOX);
		
		assertRollWhenNotInPenaltyBoxIsCalledWithCorrectParameter(ROLL_NOT_GET_OUT_OF_PENALTY_BOX);
	}
	
	@Test public void current_Player_Not_In_Penalty_Box_And_Is_Get_Out_Of_Penalty_Box() {
		stubGamePlayers.setIsCurrentPlayerInPenaltyBox(false);
		mockGame.roll(ROLL_GET_OUT_OF_PENALTY_BOX);
		
		assertRollWhenNotInPenaltyBoxIsCalledWithCorrectParameter(ROLL_GET_OUT_OF_PENALTY_BOX);
	}
	
	private void assertRollWhenNotInPenaltyBoxIsCalledWithCorrectParameter(int parameterRoll) {
		assertTrue(mockGame.rollWhenNotInPenaltyBoxIsCalled);
		assertEquals(parameterRoll, mockGame.rollWhenNotInPenaltyBoxParameterRoll);
	}

}
