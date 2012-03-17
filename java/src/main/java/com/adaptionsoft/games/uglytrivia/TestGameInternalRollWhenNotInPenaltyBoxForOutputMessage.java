package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;


public class TestGameInternalRollWhenNotInPenaltyBoxForOutputMessage extends Game {

	@Test public void current_Player_New_Location_Output_Message() throws IOException {
		Game game = new TestGameInternalRollWhenNotInPenaltyBoxForOutputMessage();
		game.add("Player1");
		
		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.rollWhenNotInPenaltyBox(1);
		
		assertEquals("Player1's new location is 1" + AllTestsHelper.LINE_SEPARATOR +
					"The category is Category1" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
	protected String currentCategory() {
		return "Category1";
	}
	
	protected void askQuestion() {
		
	}
	
}
