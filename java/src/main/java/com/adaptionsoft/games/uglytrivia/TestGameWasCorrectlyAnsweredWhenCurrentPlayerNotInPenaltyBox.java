package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;


public class TestGameWasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox {

	private Game game;

	@Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_Output_Message() throws IOException {
		createGameWithOnePlayer();
		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		
		assertEquals("Answer was correct!!!!" + AllTestsHelper.LINE_SEPARATOR + 
					"Player1 now has 1 Gold Coins." + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}

	@Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_Current_Player_Purses_Increased_By_One() {
		createGameWithOnePlayer();

		boolean notWin = game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		
		assertTrue(notWin);
		assertEquals(1, game.purses[0]);
	}
	
	@Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_All_Players_Purses_Increased_By_One() {
		createGameWithThreePlayers();
		
		boolean notWin = game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		assertTrue("Player1 should not win", notWin);
		assertEquals("Player1 purses should be increased by one", 1, game.purses[0]);
		
		notWin = game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		assertTrue("Player2 should not win", notWin);
		assertEquals("Player2 purses should be increased by one", 1, game.purses[1]);

		notWin = game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		assertTrue("Player3 should not win", notWin);
		assertEquals("Player3 purses should be increased by one", 1, game.purses[2]);
	}

	@Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_First_Player_Purses_Increased_Twice() {
		createGameWithThreePlayers();
		
		game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		
		boolean notWin = game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		assertTrue("Player1 should not win", notWin);
		assertEquals("Player1 purses should be increased by two", 2, game.purses[0]);
	}
	
	@Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_First_Player_Win() {
		createGameWithThreePlayers();
		
		for (int i = 0; i < 3*5; i++)
			game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		
		boolean win = !game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		assertTrue("Player1 should win", win);
		assertEquals("Player1 purses should be increased by six", 6, game.purses[0]);
	}
	
	@Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_Current_Player_Is_Second_Player() {
		createGameWithThreePlayers();
		
		game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		
		assertEquals(1, game.currentPlayer);
	}
	
	@Test public void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox_Is_Called_Three_Times_Then_Current_Player_Is_First_Player() {
		createGameWithThreePlayers();
		
		game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		game.wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox();
		
		assertEquals(0, game.currentPlayer);
	}
	
	private void createGameWithOnePlayer() {
		game = new Game();
		game.add("Player1");
	}
	
	private void createGameWithThreePlayers() {
		game = new Game();
		game.add("Player1");
		game.add("Player2");
		game.add("Player3");
	}
	
}
