package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestGameRollWhenNotInPenaltyBox {

	private static final int ANY_ROLL = 1;
	private MockGame mockGame;
	private MockGameQuestions mockGameQuestions;
	private MockGamePlayers mockGamePlayers;

	private class MockGameQuestions extends GameQuestions {
		
		private boolean askQuestionIsCalled;
		private int askQuestionParameterCurrentPlayerPlace;

		public void askQuestion(int currentPlayerPlace) {
			askQuestionIsCalled = true;
			askQuestionParameterCurrentPlayerPlace = currentPlayerPlace;
		}
		
	}
	
	private class MockGame extends Game {
		
		private boolean rollWhenNotInPenaltyBoxOutputMessageIsCalled;

		public MockGame(GameQuestions gameQuestions,
				GamePlayers gamePlayers) {
			super(gameQuestions, gamePlayers);
		}

		protected void rollWhenNotInPenaltyBoxOutputMessage() {
			rollWhenNotInPenaltyBoxOutputMessageIsCalled = true;
		}
		
	}
	
	private class MockGamePlayers extends GamePlayers {
		
		private static final int ANY_CURRENT_PLAYER_PLACE = 100;
		private boolean setCurrentPlayerPlaceIsCalled;
		private int setCurrentPlayerPlaceParameterRoll;

		public void setCurrentPlayerPlace(int roll) {
			setCurrentPlayerPlaceIsCalled = true;
			setCurrentPlayerPlaceParameterRoll = roll;
		}
		
		public int getCurrentPlayerPlace() {
			return ANY_CURRENT_PLAYER_PLACE;
		}
		
	}
	
	@Before public void createStubGameQuestionsAndGameAndThenAddOnePlayer() {
		mockGameQuestions = new MockGameQuestions();
		mockGamePlayers = new MockGamePlayers();
		mockGame = new MockGame(mockGameQuestions, mockGamePlayers);
	}

	@Test public void setCurrentPlayerPlace_Is_Called_With_Correct_Parameter() {
		mockGame.rollWhenNotInPenaltyBox(ANY_ROLL);
		
		assertTrue(mockGamePlayers.setCurrentPlayerPlaceIsCalled);
		assertEquals(ANY_ROLL, mockGamePlayers.setCurrentPlayerPlaceParameterRoll);
	}
	
	@Test public void rollWhenNotInPenaltyBoxOutputMessage_Is_Called() {
		mockGame.rollWhenNotInPenaltyBox(ANY_ROLL);
		
		assertTrue(mockGame.rollWhenNotInPenaltyBoxOutputMessageIsCalled);
	}
	
	@Test public void askQuestion_Is_Called_With_Correct_Parameter() {
		mockGame.rollWhenNotInPenaltyBox(ANY_ROLL);
		
		assertTrue(mockGameQuestions.askQuestionIsCalled);
		assertEquals(MockGamePlayers.ANY_CURRENT_PLAYER_PLACE, mockGameQuestions.askQuestionParameterCurrentPlayerPlace);
	}
	
}
