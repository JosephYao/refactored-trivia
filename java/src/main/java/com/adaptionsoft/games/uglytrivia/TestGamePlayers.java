package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;


public class TestGamePlayers {

	GamePlayers gamePlayers = new GamePlayers();

	@Test public void player_Name_Added() {
		gamePlayers.add("Player1");
		assertTrue(gamePlayers.players.contains("Player1"));
		gamePlayers.add("Player2");
		assertTrue(gamePlayers.players.contains("Player2"));
	}
	
	@Test public void player_Status_Initialized() {
		gamePlayers.add("Player1");
		assertEquals(0, gamePlayers.places[0]);
		assertEquals(0, gamePlayers.purses[0]);
		assertFalse(gamePlayers.inPenaltyBox[0]);
	}
	
	@Test public void output_Message() throws IOException {
		ByteArrayOutputStream spyOutput = AllTestsHelper.createSpySystemOut();
		
		gamePlayers.add("Player1");
		assertEquals("Player1 was added" + AllTestsHelper.LINE_SEPARATOR + 
				"They are player number 1" + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
		
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
	@Test public void current_Player_Go_Into_Penalty_Box() {
		gamePlayers.add("Player1");
		gamePlayers.currentPlayerGoIntoPenaltyBox();
		assertTrue(gamePlayers.isCurrentPlayerInPenaltyBox());
	}
	
	@Test public void get_Current_Player() {
		gamePlayers.add("Player1");
		assertEquals("Player1", gamePlayers.getCurrentPlayer());
	}
	
	@Test public void current_Player_Places_When_Roll_1() {
		gamePlayers.setCurrentPlayerPlace(1);
		
		assertEquals(1, gamePlayers.getCurrentPlayerPlace());
	}

	@Test public void current_Player_Places_When_Roll_11() {
		gamePlayers.setCurrentPlayerPlace(11);
		
		assertEquals(11, gamePlayers.getCurrentPlayerPlace());
	}
	
	@Test public void current_Player_Places_When_Roll_5_Then_6() {
		gamePlayers.setCurrentPlayerPlace(5);
		gamePlayers.setCurrentPlayerPlace(6);
		
		assertEquals(11, gamePlayers.getCurrentPlayerPlace());
	}
	
	@Test public void current_Player_Places_When_Roll_12() {
		gamePlayers.setCurrentPlayerPlace(12);
		
		assertEquals(0, gamePlayers.getCurrentPlayerPlace());
	}
	
	@Test public void current_Player_Places_When_Roll_6_Then_6() {
		gamePlayers.setCurrentPlayerPlace(6);
		gamePlayers.setCurrentPlayerPlace(6);
		
		assertEquals(0, gamePlayers.getCurrentPlayerPlace());
	}
	
	@Test public void current_Player_Purses_Increased_By_One() {
		gamePlayers.add("Player1");
		gamePlayers.currentPlayerPursesIncreasedByOne();
		assertEquals(1, gamePlayers.getCurrentPlayerPurses());
	}
	
	@Test public void current_Player_Move_Next_Player() {
		gamePlayers.add("Player1");
		gamePlayers.add("Player2");
		
		gamePlayers.currentPlayerMoveToNext();
		
		assertEquals("Player2", gamePlayers.getCurrentPlayer());
	}

	@Test public void current_Player_Back_To_First() {
		gamePlayers.add("Player1");
		gamePlayers.add("Player2");
		gamePlayers.add("Player3");
		
		gamePlayers.currentPlayerMoveToNext();
		gamePlayers.currentPlayerMoveToNext();
		gamePlayers.currentPlayerMoveToNext();
		
		assertEquals("Player1", gamePlayers.getCurrentPlayer());
	}
	
	@Test public void player_Not_Win() {
		gamePlayers.add("Player1");
		
		for (int i = 0; i < 5; i++) {
			gamePlayers.currentPlayerPursesIncreasedByOne();
			assertTrue(gamePlayers.isCurrentPlayerNotWin());
		}
	}
	
	@Test public void player_Win() {
		gamePlayers.add("Player1");
		
		for (int i = 0; i < 6; i++) {
			gamePlayers.currentPlayerPursesIncreasedByOne();
		}
		
		assertFalse(gamePlayers.isCurrentPlayerNotWin());
	}
	
}
