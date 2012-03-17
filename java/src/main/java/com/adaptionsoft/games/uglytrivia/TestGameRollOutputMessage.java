package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;


public class TestGameRollOutputMessage extends Game {

	@Test public void roll_Output_Message_At_Beginning() throws IOException {
		Game game = new TestGameRollOutputMessage();
		game.add("Player1");

		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.roll(1);
		
		assertEquals("Player1 is the current player" + AllTestsHelper.LINE_SEPARATOR +
					"They have rolled a 1" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
	protected void internalRollWhenInPenaltyBox(int roll) {
		
	}
	
	protected void rollWhenNotInPenaltyBox(int roll) {
		
	}
	
}
