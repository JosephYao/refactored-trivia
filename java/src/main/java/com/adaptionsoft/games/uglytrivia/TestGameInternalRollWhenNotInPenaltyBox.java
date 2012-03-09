package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestGameInternalRollWhenNotInPenaltyBox {

	@Test public void current_Player_Places_When_Roll_1() {
		Game game = new Game();
		
		game.add("Player1");
		game.internalRollWhenNotInPenaltyBox(1);
		
		assertEquals(1, game.places[game.currentPlayer]);
	}
	
}
