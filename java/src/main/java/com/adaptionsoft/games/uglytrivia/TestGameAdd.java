package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;


public class TestGameAdd {

	Game game = new Game();

	@Test public void player_Name_Added() {
		game.add("Player1");
		assertTrue(game.players.contains("Player1"));
		game.add("Player2");
		assertTrue(game.players.contains("Player2"));
	}
	
	@Test public void player_Status_Initialized() {
		game.add("Player1");
		assertEquals(0, game.places[0]);
		assertEquals(0, game.purses[0]);
		assertFalse(game.inPenaltyBox[0]);
	}
	
	@Test public void output_Message() throws IOException {
		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.add("Player1");
		assertEquals("Player1 was added" + AllTestsHelper.LINE_SEPARATOR + 
				"They are player number 1" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
}
