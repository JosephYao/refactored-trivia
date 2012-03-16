package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestGameInitialization {

	Game game = new Game();

	@Test public void questions_Size() {
		assertEquals(AllTestsHelper.TOTAL_QUESTIONS, game.popQuestions.size());
		assertEquals(AllTestsHelper.TOTAL_QUESTIONS, game.scienceQuestions.size());
		assertEquals(AllTestsHelper.TOTAL_QUESTIONS, game.sportsQuestions.size());
		assertEquals(AllTestsHelper.TOTAL_QUESTIONS, game.rockQuestions.size());
	}
	
	@Test public void first_Question() {
		assertEquals("Pop Question 0", game.popQuestions.getFirst());
		assertEquals("Science Question 0", game.scienceQuestions.getFirst());
		assertEquals("Sports Question 0", game.sportsQuestions.getFirst());
		assertEquals("Rock Question 0", game.rockQuestions.getFirst());
	}
	
	@Test public void last_Question() {
		assertEquals("Pop Question 49", game.popQuestions.getLast());
		assertEquals("Science Question 49", game.scienceQuestions.getLast());
		assertEquals("Sports Question 49", game.sportsQuestions.getLast());
		assertEquals("Rock Question 49", game.rockQuestions.getLast());
	}
	
}
