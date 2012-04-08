package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;


public class TestGameRollWhenNotInPenaltyBoxOutputMessage {

	private class StubGamePlayers extends GamePlayers {
		
		public String getCurrentPlayer() {
			return "Player1";
		}
		
		public int getCurrentPlayerPlace() {
			return 1;
		}
		
	}
	
	private class StubGameQuestions extends GameQuestions {
		
		public String currentCategory(int currentPlayerPlace) {
			return "Category1";
		}
		
	}
	
	@Test public void output_Message() throws IOException {
		Game game = new Game(new StubGameQuestions(), new StubGamePlayers());
		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.rollWhenNotInPenaltyBoxOutputMessage();
		
		assertEquals("Player1's new location is 1" + AllTestsHelper.LINE_SEPARATOR +
					"The category is Category1" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
}
