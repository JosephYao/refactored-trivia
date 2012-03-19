package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class TestGameRollPenaltyBox extends Game {

	private static final int ROLL_GET_OUT_OF_PENALTY_BOX = 2;
	private static final int ROLL_NOT_GET_OUT_OF_PENALTY_BOX = 1;
	private boolean isCurrentPlayerInPenaltyBox;
	private boolean internalRollWhenNotInPenaltyBoxIsCalled;
	private TestGameRollPenaltyBox game;
	private int internalRollWhenNotInPenaltyBoxParameterRoll;

	@Before public void createGameAndAddPlayer() {
		game = new TestGameRollPenaltyBox();
		game.add("Player1");
	}
	
	@Test public void current_Player_In_Penalty_Box_And_Is_Not_Get_Out_Of_Penalty_Box() {
		game.setIsCurrentPlayerInPenaltyBox(true);
		gameRollNotGettingOutOfPenaltyBox();
		
		assertFalse(game.internalRollWhenNotInPenaltyBoxIsCalled);
	}

	@Test public void current_Player_In_Penalty_Box_And_Is_Get_Out_Of_Penalty_Box() {
		game.setIsCurrentPlayerInPenaltyBox(true);
		gameRollGettingOutOfPenaltyBox();
		
		assertInternalRollWhenNotInPenaltyBoxIsCalledWithCorrectParameter(ROLL_NOT_GET_OUT_OF_PENALTY_BOX);
	}

	@Test public void current_Player_Not_In_Penalty_Box_And_Is_Not_Get_Out_Of_Penalty_Box() {
		game.setIsCurrentPlayerInPenaltyBox(false);
		gameRollNotGettingOutOfPenaltyBox();
		
		assertInternalRollWhenNotInPenaltyBoxIsCalledWithCorrectParameter(ROLL_GET_OUT_OF_PENALTY_BOX);
	}
	
	@Test public void current_Player_Not_In_Penalty_Box_And_Is_Get_Out_Of_Penalty_Box() {
		game.setIsCurrentPlayerInPenaltyBox(false);
		gameRollGettingOutOfPenaltyBox();
		
		assertInternalRollWhenNotInPenaltyBoxIsCalledWithCorrectParameter(ROLL_NOT_GET_OUT_OF_PENALTY_BOX);
	}
	
	protected void rollWhenNotInPenaltyBox(int roll) {
		internalRollWhenNotInPenaltyBoxIsCalled = true;
		internalRollWhenNotInPenaltyBoxParameterRoll = roll;
	}
	
	private void assertInternalRollWhenNotInPenaltyBoxIsCalledWithCorrectParameter(int parameterRoll) {
		assertTrue(game.internalRollWhenNotInPenaltyBoxIsCalled);
		assertEquals(parameterRoll, game.internalRollWhenNotInPenaltyBoxParameterRoll);
	}

	private void gameRollNotGettingOutOfPenaltyBox() {
		game.roll(2);
	}

	private void gameRollGettingOutOfPenaltyBox() {
		game.roll(1);
	}

	private void setIsCurrentPlayerInPenaltyBox(boolean value) {
		isCurrentPlayerInPenaltyBox = value;
	}
	
	protected boolean isCurrentPlayerInPenaltyBox() {
		return isCurrentPlayerInPenaltyBox;
	}
	
}
