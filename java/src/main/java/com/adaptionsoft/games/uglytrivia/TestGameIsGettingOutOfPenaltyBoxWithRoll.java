package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;


public class TestGameIsGettingOutOfPenaltyBoxWithRoll extends Game {

	private Game game = new Game(new GameQuestions(), new StubGamePlayers());

	private class StubGamePlayers extends GamePlayers {
		
		public String getCurrentPlayer() {
			return "Player1";
		}
		
	}
	
	@Test public void roll_Is_Not_Multiple_Of_2_isGettingOutOfPenaltyBox() {
		game.isGettingOutOfPenaltyBox(3);
		
		assertTrue(game.isGettingOutOfPenaltyBox);
	}
	
	@Test public void roll_Is_Not_Multiple_Of_2_Output_Message() throws IOException {
		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.isGettingOutOfPenaltyBox(3);
		
		assertEquals("Player1 is getting out of the penalty box" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
	@Test public void roll_Is_Multiple_Of_2_isGettingOutOfPenaltyBox() {
		game.isGettingOutOfPenaltyBox(2);
		
		assertFalse(game.isGettingOutOfPenaltyBox);
	}
	
	@Test public void roll_Is_Multiple_Of_2_Output_Message() throws IOException {
		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.isGettingOutOfPenaltyBox(2);
		
		assertEquals("Player1 is not getting out of the penalty box" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
}
