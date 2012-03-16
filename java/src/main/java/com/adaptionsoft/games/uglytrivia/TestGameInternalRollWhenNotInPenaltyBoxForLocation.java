package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class TestGameInternalRollWhenNotInPenaltyBoxForLocation {

	private Game game;

	@Before public void createGameAndAddPlayer() {
		game = new Game();
		game.add("Player1");
	}
	
	@Test public void current_Player_Places_When_Roll_1() {
		game.internalRollWhenNotInPenaltyBox(1);
		
		assertEquals(1, game.places[game.currentPlayer]);
	}

	@Test public void current_Player_Places_When_Roll_11() {
		game.internalRollWhenNotInPenaltyBox(11);
		
		assertEquals(11, game.places[game.currentPlayer]);
	}
	
	@Test public void current_Player_Places_When_Roll_5_Then_6() {
		game.internalRollWhenNotInPenaltyBox(5);
		game.internalRollWhenNotInPenaltyBox(6);
		
		assertEquals(11, game.places[game.currentPlayer]);
	}
	
	@Test public void current_Player_Places_When_Roll_12() {
		game.internalRollWhenNotInPenaltyBox(12);
		
		assertEquals(0, game.places[game.currentPlayer]);
	}
	
	@Test public void current_Player_Places_When_Roll_6_Then_6() {
		game.internalRollWhenNotInPenaltyBox(6);
		game.internalRollWhenNotInPenaltyBox(6);
		
		assertEquals(0, game.places[game.currentPlayer]);
	}
	
}
