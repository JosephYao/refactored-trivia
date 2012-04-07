package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;


public class TestGameRollOutputMessage {

	private class StubGamePlayers extends GamePlayers {
		
		public String getCurrentPlayer() {
			return "Player1";
		}
		
	}
	
	@Test public void output_Message() throws IOException {
		Game game = new Game(new GameQuestions(), new StubGamePlayers());

		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.rollOutputMessage(1);
		
		assertEquals("Player1 is the current player" + AllTestsHelper.LINE_SEPARATOR +
					"They have rolled a 1" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
}
