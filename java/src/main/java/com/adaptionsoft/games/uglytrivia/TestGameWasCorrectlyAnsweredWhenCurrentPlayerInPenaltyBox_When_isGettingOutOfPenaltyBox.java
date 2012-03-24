package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;


public class TestGameWasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox extends Game {

	private TestGameWasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox game;

	@Test public void output_Message() throws IOException {
		createGameAndAddOnePlayer();
		
		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		
		assertEquals("Answer was correct!!!!" + AllTestsHelper.LINE_SEPARATOR +
					"Player1 now has 1 Gold Coins." + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}

	@Test public void current_Player_Purses_Increased_By_One() {
		createGameAndAddOnePlayer();
		
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		
		assertEquals(1, game.purses[0]);
	}
	
	@Test public void all_Players_Purses_Increased_By_One() {
		createGameAndAddThreePlayers();
		
		boolean notWin = game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		assertTrue("Player1 should not win", notWin);
		assertEquals("Player1 purses should be increased by one", 1, game.purses[0]);
		
		notWin = game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		assertTrue("Player2 should not win", notWin);
		assertEquals("Player2 purses should be increased by one", 1, game.purses[1]);

		notWin = game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		assertTrue("Player3 should not win", notWin);
		assertEquals("Player3 purses should be increased by one", 1, game.purses[2]);
	}

	@Test public void first_Player_Purses_Increased_Twice() {
		createGameAndAddThreePlayers();
		
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		
		boolean notWin = game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		assertTrue("Player1 should not win", notWin);
		assertEquals("Player1 purses should be increased by two", 2, game.purses[0]);
	}
	
	@Test public void first_Player_Win() {
		createGameAndAddThreePlayers();
		
		for (int i = 0; i < 3*5; i++)
			game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		
		boolean win = !game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		assertTrue("Player1 should win", win);
		assertEquals("Player1 purses should be increased by six", 6, game.purses[0]);
	}
	
	@Test public void current_Player_Is_Second_Player() {
		createGameAndAddThreePlayers();
		
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		
		assertEquals(1, game.currentPlayer);
	}
	
	@Test public void is_Called_Three_Times_Then_Current_Player_Is_First_Player() {
		createGameAndAddThreePlayers();
		
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		
		assertEquals(0, game.currentPlayer);
	}
	
	private void createGameAndAddOnePlayer() {
		game = new TestGameWasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		game.add("Player1");
	}
	
	private void createGameAndAddThreePlayers() {
		game = new TestGameWasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_isGettingOutOfPenaltyBox();
		game.add("Player1");
		game.add("Player2");
		game.add("Player3");
	}

}
