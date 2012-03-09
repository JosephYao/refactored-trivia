package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;


public class TestGameRoll extends Game {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");

	@Test public void roll_Output_Message_At_Beginning() throws IOException {
		Game game = new TestGameRoll();
		
		game.add("Player1");

		PrintStream systemOut = System.out;
		ByteArrayOutputStream spyOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(spyOutput));
		
		game.roll(1);
		
		assertEquals("Player1 is the current player" + LINE_SEPARATOR +
					"They have rolled a 1" + LINE_SEPARATOR, spyOutput.toString());
		
		spyOutput.close();
		System.setOut(systemOut);
	}
	
	protected void internalRoll(int roll) {
		
	}
	
}
