package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;


public class TestGameIsGettingOutOfPenaltyBoxWithRollOutputMessage extends Game {

	private Game game = new Game(new GameQuestions(), new StubGamePlayers());
	private ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();

	private class StubGamePlayers extends GamePlayers {
		
		public String getCurrentPlayer() {
			return "Player1";
		}
		
	}
	
	@Test public void roll_Is_Not_Multiple_Of_2_Output_Message() throws IOException {
		game.isGettingOutOfPenaltyBox(3);
		
		assertEquals("Player1 is getting out of the penalty box" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
	}

	@Test public void roll_Is_Multiple_Of_2_Output_Message() throws IOException {
		game.isGettingOutOfPenaltyBox(2);
		
		assertEquals("Player1 is not getting out of the penalty box" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
	}
	
	@After public void restoreSystemOutAndCloseSpyOutput() throws IOException {
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
}
