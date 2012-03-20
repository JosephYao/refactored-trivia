package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class TestGameWrongAnswer {

	Game game;

	@Before public void createGameAndPlayers() {
		game = new Game();
		game.add("Player1");
		game.add("Player2");
		game.add("Player3");
	}
	
	@Test public void wrongAnswer_Output_Message() throws IOException {
		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.wrongAnswer();
		
		assertEquals("Question was incorrectly answered" + AllTestsHelper.LINE_SEPARATOR +
					"Player1 was sent to the penalty box" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
	@Test public void wrongAnswer_First_Player_In_Penalty_Box() {
		game.wrongAnswer();
		
		assertTrue(game.inPenaltyBox[0]);
	}
	
	@Test public void wrongAnswer_Current_Player_Move_Next_Player() {
		game.wrongAnswer();
		
		assertEquals(1, game.currentPlayer);
	}

	@Test public void wrongAnswer_Twice_First_And_Second_Player_In_Penalty_Box() {
		game.wrongAnswer();
		game.wrongAnswer();
		
		assertTrue(game.inPenaltyBox[0]);
		assertTrue(game.inPenaltyBox[1]);
	}
	
	@Test public void wrongAnswer_Three_Times_Current_Player_Back_To_First() {
		game.wrongAnswer();
		game.wrongAnswer();
		game.wrongAnswer();
		
		assertEquals(0, game.currentPlayer);
	}
	
	@Test public void wrongAnswer_Always_Return_True() {
		assertTrue(game.wrongAnswer());
	}
	
}
