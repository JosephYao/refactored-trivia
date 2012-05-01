package com.adaptionsoft.games.uglytrivia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.GamePlayers;
import com.adaptionsoft.games.uglytrivia.GameQuestions;


public class TestGameAdd {

	private class MockGamePlayers extends GamePlayers {
		
		private boolean addIsCalled;
		private String playerNamePassed;

		public void add(String playerName) {
			addIsCalled = true;
			playerNamePassed = playerName;
		}
	}
	
	@Test public void gamePlayers_Add_Is_Called() {
		MockGamePlayers mockGamePlayers = new MockGamePlayers();
		Game game = new Game(new GameQuestions(), mockGamePlayers);
		game.add("Player1");
		assertTrue(mockGamePlayers.addIsCalled);
		assertEquals("Player1", mockGamePlayers.playerNamePassed);
	}
	
}
