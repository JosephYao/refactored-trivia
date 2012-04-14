package com.adaptionsoft.games.uglytrivia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.AllTestsHelper;
import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.GamePlayers;
import com.adaptionsoft.games.uglytrivia.GameQuestions;

public class TestGameRoll extends Game {

	private static final int ROLL_NOT_GET_OUT_OF_PENALTY_BOX = 2;
	private static final int ROLL_GET_OUT_OF_PENALTY_BOX = 1;
	private Game game;
	private StubGamePlayers stubGamePlayers;
	private MockGameQuestions mockGameQuestions;
	private ByteArrayOutputStream spyOutput;

	private class StubGamePlayers extends GamePlayers {
		
		private static final String ANY_CURRENT_PLAYER = "Current Player";
		private static final int ANY_CURRENT_PLAYER_PLACE = 100;
		private boolean isCurrentPlayerInPenaltyBox;
		private int currentPlayerPlace;

		public boolean isCurrentPlayerInPenaltyBox() {
			return isCurrentPlayerInPenaltyBox;
		}

		public void setIsCurrentPlayerInPenaltyBox(boolean value) {
			isCurrentPlayerInPenaltyBox = value;
		}
		
		public boolean isGettingOutOfPenaltyBox(int roll) {
			return roll % 2 != 0;
		}
		
		public void setCurrentPlayerPlace(int roll) {
			currentPlayerPlace = ANY_CURRENT_PLAYER_PLACE;
		}
		
		public int getCurrentPlayerPlace() {
			return currentPlayerPlace;
		}
		
		public String getCurrentPlayer() {
			return ANY_CURRENT_PLAYER;
		}

	}
	
	private class MockGameQuestions extends GameQuestions {
		
		private static final String ANY_CURRENT_CATEGORY = "Current Category";
		private boolean askQuestionIsCalled;
		private int askQuestionParameterCurrentPlayerPlace;

		public String currentCategory(int currentPlayerPlace) {
			return ANY_CURRENT_CATEGORY;
		}
		
		public void askQuestion(int currentPlayerPlace) {
			askQuestionIsCalled = true;
			askQuestionParameterCurrentPlayerPlace = currentPlayerPlace;
		}
	}
	
	@Before public void createGameAndAddPlayer() {
		stubGamePlayers = new StubGamePlayers();
		mockGameQuestions = new MockGameQuestions();
		game = new Game(mockGameQuestions, stubGamePlayers);
		spyOutput = AllTestsHelper.createSpySystemOut();
	}
	
	@Test public void current_Player_In_Penalty_Box_And_Is_Not_Get_Out_Of_Penalty_Box() throws IOException {
		stubGamePlayers.setIsCurrentPlayerInPenaltyBox(true);

		game.roll(ROLL_NOT_GET_OUT_OF_PENALTY_BOX);

		assertEquals(StubGamePlayers.ANY_CURRENT_PLAYER + " is the current player" + AllTestsHelper.LINE_SEPARATOR +
				"They have rolled a " + ROLL_NOT_GET_OUT_OF_PENALTY_BOX + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		assertFalse(mockGameQuestions.askQuestionIsCalled);
	}

	@Test public void current_Player_In_Penalty_Box_And_Is_Get_Out_Of_Penalty_Box() throws IOException {
		stubGamePlayers.setIsCurrentPlayerInPenaltyBox(true);

		game.roll(ROLL_GET_OUT_OF_PENALTY_BOX);
		
		assertOutputMessageEqualsWhenNotInPenaltyBox(ROLL_GET_OUT_OF_PENALTY_BOX);
		assertAskQuestionIsCalledAsExpected();
	}

	@Test public void current_Player_Not_In_Penalty_Box_And_Is_Not_Get_Out_Of_Penalty_Box() throws IOException {
		stubGamePlayers.setIsCurrentPlayerInPenaltyBox(false);

		game.roll(ROLL_NOT_GET_OUT_OF_PENALTY_BOX);
		
		assertOutputMessageEqualsWhenNotInPenaltyBox(ROLL_NOT_GET_OUT_OF_PENALTY_BOX);
		assertAskQuestionIsCalledAsExpected();
	}
	
	@Test public void current_Player_Not_In_Penalty_Box_And_Is_Get_Out_Of_Penalty_Box() throws IOException {
		stubGamePlayers.setIsCurrentPlayerInPenaltyBox(false);

		game.roll(ROLL_GET_OUT_OF_PENALTY_BOX);
		
		assertOutputMessageEqualsWhenNotInPenaltyBox(ROLL_GET_OUT_OF_PENALTY_BOX);
		assertAskQuestionIsCalledAsExpected();
	}
	
	@After public void restoreSystemOutAndCloseSpyOutput() throws IOException {
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}

	private void assertOutputMessageEqualsWhenNotInPenaltyBox(int expectedRoll) {
		assertEquals(StubGamePlayers.ANY_CURRENT_PLAYER + " is the current player" + AllTestsHelper.LINE_SEPARATOR +
				"They have rolled a " + expectedRoll + AllTestsHelper.LINE_SEPARATOR +
				StubGamePlayers.ANY_CURRENT_PLAYER + "'s new location is " + StubGamePlayers.ANY_CURRENT_PLAYER_PLACE + AllTestsHelper.LINE_SEPARATOR +
				"The category is " + MockGameQuestions.ANY_CURRENT_CATEGORY + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
	}

	private void assertAskQuestionIsCalledAsExpected() {
		assertTrue(mockGameQuestions.askQuestionIsCalled);
		assertEquals(StubGamePlayers.ANY_CURRENT_PLAYER_PLACE, mockGameQuestions.askQuestionParameterCurrentPlayerPlace);
	}

}
