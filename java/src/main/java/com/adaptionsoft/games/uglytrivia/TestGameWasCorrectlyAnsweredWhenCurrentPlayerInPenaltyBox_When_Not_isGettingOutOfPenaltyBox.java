package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class TestGameWasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_Not_isGettingOutOfPenaltyBox {

	Game game;
	
	@Before public void createGameAndPlayers() {
		game = new Game();
		game.add("Player1");
		game.add("Player2");
		game.add("Player3");
	}
	
	@Test public void current_Player_Move_To_Next_Player() {
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_Not_isGettingOutOfPenaltyBox();
		
		assertEquals(1, game.currentPlayer);
	}

	@Test public void called_Three_Times_Current_Player_Back_To_First() {
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_Not_isGettingOutOfPenaltyBox();
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_Not_isGettingOutOfPenaltyBox();
		game.wasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_Not_isGettingOutOfPenaltyBox();
		
		assertEquals(0, game.currentPlayer);
	}
	
	@Test public void always_Return_True() {
		assertTrue(game.wrongAnswer());
	}
	
}
