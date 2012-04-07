package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class TestGameWasCorrectlyAnswered {

	private boolean isCurrentPlayerInPenaltyBox;
	private StubGame game;

	private class StubGamePlayers extends GamePlayers {
		private boolean isGettingOutOfPenaltyBoxFlag;

		public boolean isCurrentPlayerInPenaltyBox() {
			return true;
		}

		protected boolean isGettingOutOfPenaltyBox() {
			return isGettingOutOfPenaltyBoxFlag;
		}
		
		private void setIsGettingOutOfPenaltyBoxFlag(boolean value) {
			isGettingOutOfPenaltyBoxFlag = value;
		}
		
	}
	
	private class StubGame extends Game {
		private boolean isGettingOutOfPenaltyBoxFlag;

		public StubGame(GameQuestions gameQuestions,
				GamePlayers gamePlayers) {
			super(gameQuestions, gamePlayers);
		}

		protected boolean isGettingOutOfPenaltyBox() {
			return isGettingOutOfPenaltyBoxFlag;
		}
		
		public void setIsGettingOutOfPenaltyBoxFlag(boolean value) {
			isGettingOutOfPenaltyBoxFlag = value;
		}
	}
	
	@Before public void createGameAndAddPlayer() {
		game = new StubGame(new GameQuestions(), new StubGamePlayers());
		game.add("Player1");
		game.add("Player2");
		game.add("Player3");
	}
	
	@Ignore @Test public void current_Player_Move_To_Next_Player() {
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
	
	@Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_Output_Message() throws IOException {
		game.setIsGettingOutOfPenaltyBoxFlag(true);

		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.wasCorrectlyAnswered();
		
		assertEquals("Answer was correct!!!!" + AllTestsHelper.LINE_SEPARATOR + 
					"Player1 now has 1 Gold Coins." + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}

	@Ignore @Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_Current_Player_Purses_Increased_By_One() {
		game.setIsGettingOutOfPenaltyBoxFlag(true);

		boolean notWin = game.wasCorrectlyAnswered();
		
		assertTrue(notWin);
		assertEquals(1, game.purses[0]);
	}
	
	@Ignore @Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_All_Players_Purses_Increased_By_One() {
		game.setIsGettingOutOfPenaltyBoxFlag(true);

		boolean notWin = game.wasCorrectlyAnswered();
		assertTrue("Player1 should not win", notWin);
		assertEquals("Player1 purses should be increased by one", 1, game.purses[0]);
		
		notWin = game.wasCorrectlyAnswered();
		assertTrue("Player2 should not win", notWin);
		assertEquals("Player2 purses should be increased by one", 1, game.purses[1]);

		notWin = game.wasCorrectlyAnswered();
		assertTrue("Player3 should not win", notWin);
		assertEquals("Player3 purses should be increased by one", 1, game.purses[2]);
	}

	@Ignore @Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_First_Player_Purses_Increased_Twice() {
		game.setIsGettingOutOfPenaltyBoxFlag(true);

		game.wasCorrectlyAnswered();
		game.wasCorrectlyAnswered();
		game.wasCorrectlyAnswered();
		
		boolean notWin = game.wasCorrectlyAnswered();
		assertTrue("Player1 should not win", notWin);
		assertEquals("Player1 purses should be increased by two", 2, game.purses[0]);
	}
	
	@Ignore @Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_First_Player_Win() {
		game.setIsGettingOutOfPenaltyBoxFlag(true);

		for (int i = 0; i < 3*5; i++)
			game.wasCorrectlyAnswered();
		
		boolean win = !game.wasCorrectlyAnswered();
		assertTrue("Player1 should win", win);
		assertEquals("Player1 purses should be increased by six", 6, game.purses[0]);
	}
	
	@Ignore @Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_Current_Player_Is_Second_Player() {
		game.setIsGettingOutOfPenaltyBoxFlag(true);

		game.wasCorrectlyAnswered();
		
		assertEquals(1, game.currentPlayer);
	}
	
	@Ignore @Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_Is_Called_Three_Times_Then_Current_Player_Is_First_Player() {
		game.setIsGettingOutOfPenaltyBoxFlag(true);

		game.wasCorrectlyAnswered();
		game.wasCorrectlyAnswered();
		game.wasCorrectlyAnswered();
		
		assertEquals(0, game.currentPlayer);
	}
	
}
