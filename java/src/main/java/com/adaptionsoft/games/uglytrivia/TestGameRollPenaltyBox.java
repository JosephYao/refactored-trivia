package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class TestGameRollPenaltyBox extends Game {

	private boolean isCurrentPlayerInPenaltyBox;
	private boolean internalRollWhenInPenaltyBoxIsCalled;
	private boolean internalRollWhenNotInPenaltyBoxIsCalled;
	private TestGameRollPenaltyBox game;
	private int internalRollWhenInPenaltyBoxParameterRoll;
	private int internalRollWhenNotInPenaltyBoxParameterRoll;

	@Before public void createGameAndAddPlayer() {
		game = new TestGameRollPenaltyBox();
		game.add("Player1");
	}
	
	@Ignore @Test public void current_Player_In_Penalty_Box() {
		game.setIsCurrentPlayerInPenaltyBox(true);
		game.roll(1);
		
		assertTrue(game.internalRollWhenInPenaltyBoxIsCalled);
		assertEquals(1, game.internalRollWhenInPenaltyBoxParameterRoll);
		assertFalse(game.internalRollWhenNotInPenaltyBoxIsCalled);
	}

	@Test public void current_Player_Not_In_Penalty_Box() {
		game.setIsCurrentPlayerInPenaltyBox(false);
		game.roll(1);
		
		assertTrue(game.internalRollWhenNotInPenaltyBoxIsCalled);
		assertEquals(1, game.internalRollWhenNotInPenaltyBoxParameterRoll);
		assertFalse(game.internalRollWhenInPenaltyBoxIsCalled);
	}
	
	protected void rollWhenNotInPenaltyBox(int roll) {
		internalRollWhenNotInPenaltyBoxIsCalled = true;
		internalRollWhenNotInPenaltyBoxParameterRoll = roll;
	}
	
	private void setIsCurrentPlayerInPenaltyBox(boolean value) {
		isCurrentPlayerInPenaltyBox = value;
	}
	
	protected boolean isCurrentPlayerInPenaltyBox() {
		return isCurrentPlayerInPenaltyBox;
	}
	
}
