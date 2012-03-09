package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;


public class TestGameAdd {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
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
		PrintStream systemOut = System.out;
		
		ByteArrayOutputStream spyOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(spyOutput));
		
		game.add("Player1");
		assertEquals("Player1 was added" + LINE_SEPARATOR + 
				"They are player number 1" + LINE_SEPARATOR, spyOutput.toString());
		
		spyOutput.close();
		System.setOut(systemOut);
	}
	
}
