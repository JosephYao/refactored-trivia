package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;


public class TestGameInternalRollWhenInPenaltyBox extends Game {

	private boolean internalRollWhenNotInPenaltyBoxIsCalled;
	private int internalRollWhenNotInPenaltyBoxParameterRoll;

	@Test public void roll_Is_Not_Multiple_Of_2_isGettingOutOfPenaltyBox() {
		Game game = new Game();
		game.add("Player1");
		
		game.internalRollWhenInPenaltyBox(3);
		
		assertTrue(game.isGettingOutOfPenaltyBox);
	}
	
	@Test public void roll_Is_Not_Multiple_Of_2_Output_Message() throws IOException {
		Game game = new TestGameInternalRollWhenInPenaltyBox();
		game.add("Player1");
		
		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.internalRollWhenInPenaltyBox(3);
		
		assertEquals("Player1 is getting out of the penalty box" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
	@Test public void roll_Is_Not_Multiple_Of_2_internalRollWhenNotInPenaltyBox_Is_Called_Correctly() {
		TestGameInternalRollWhenInPenaltyBox game = new TestGameInternalRollWhenInPenaltyBox();
		game.add("Player1");
		
		game.internalRollWhenInPenaltyBox(3);
		
		assertTrue(game.internalRollWhenNotInPenaltyBoxIsCalled);
		assertEquals(3, game.internalRollWhenNotInPenaltyBoxParameterRoll);
	}
	
	@Test public void roll_Is_Multiple_Of_2_isGettingOutOfPenaltyBox() {
		Game game = new Game();
		game.add("Player1");
		
		game.internalRollWhenInPenaltyBox(2);
		
		assertFalse(game.isGettingOutOfPenaltyBox);
	}
	
	@Test public void roll_Is_Multiple_Of_2_Output_Message() throws IOException {
		Game game = new TestGameInternalRollWhenInPenaltyBox();
		game.add("Player1");
		
		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.internalRollWhenInPenaltyBox(2);
		
		assertEquals("Player1 is not getting out of the penalty box" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
	@Test public void roll_Is_Multiple_Of_2_internalRollWhenNotInPenaltyBox_Is_Not_Called() {
		TestGameInternalRollWhenInPenaltyBox game = new TestGameInternalRollWhenInPenaltyBox();
		game.add("Player1");
		
		game.internalRollWhenInPenaltyBox(2);
		
		assertFalse(game.internalRollWhenNotInPenaltyBoxIsCalled);
	}
	
	protected void internalRollWhenNotInPenaltyBox(int roll) {
		internalRollWhenNotInPenaltyBoxIsCalled = true;
		internalRollWhenNotInPenaltyBoxParameterRoll = roll;
	}
	
}
