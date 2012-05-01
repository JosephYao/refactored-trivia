package com.adaptionsoft.games.uglytrivia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.GamePlayers;
import com.adaptionsoft.games.uglytrivia.GameQuestions;


public class TestGameWrongAnswer {

	Game game;
	GamePlayers players;

	@Before public void createGameAndPlayers() {
		players = new GamePlayers();
		game = new Game(new GameQuestions(), players);
		game.add("Player1");
		game.add("Player2");
		game.add("Player3");
	}
	
	@Test public void output_Message() throws IOException {
		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		game.wrongAnswer();
		
		assertEquals("Question was incorrectly answered" + AllTestsHelper.LINE_SEPARATOR +
					"Player1 was sent to the penalty box" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
	@Test public void first_Player_In_Penalty_Box() {
		game.wrongAnswer();
		
		assertTrue(players.getAllPlayerInPenaltyBox()[0]);
	}
	
	@Test public void current_Player_Move_Next_Player() {
		game.wrongAnswer();
		
		assertEquals("Player2", players.getCurrentPlayer());
	}

	@Test public void twice_First_And_Second_Player_In_Penalty_Box() {
		game.wrongAnswer();
		game.wrongAnswer();
		
		assertTrue(players.getAllPlayerInPenaltyBox()[0]);
		assertTrue(players.getAllPlayerInPenaltyBox()[1]);
	}
	
	@Test public void three_Times_Current_Player_Back_To_First() {
		game.wrongAnswer();
		game.wrongAnswer();
		game.wrongAnswer();
		
		assertEquals("Player1", players.getCurrentPlayer());
	}
	
	@Test public void always_Return_True() {
		assertTrue(game.wrongAnswer());
	}
	
}
