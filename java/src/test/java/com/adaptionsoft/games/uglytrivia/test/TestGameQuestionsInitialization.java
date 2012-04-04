package com.adaptionsoft.games.uglytrivia.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.AllTestsHelper;
import com.adaptionsoft.games.uglytrivia.GameQuestions;


public class TestGameQuestionsInitialization {

	GameQuestions gameQuestions = new GameQuestions();
	
	@Test public void questions_Size() {
		assertEquals(AllTestsHelper.TOTAL_QUESTIONS, gameQuestions.getPopQuestions().size());
		assertEquals(AllTestsHelper.TOTAL_QUESTIONS, gameQuestions.getScienceQuestions().size());
		assertEquals(AllTestsHelper.TOTAL_QUESTIONS, gameQuestions.getSportsQuestions().size());
		assertEquals(AllTestsHelper.TOTAL_QUESTIONS, gameQuestions.getRockQuestions().size());
	}
	
	@Test public void first_Question() {
		assertEquals("Pop Question 0", gameQuestions.getPopQuestions().getFirst());
		assertEquals("Science Question 0", gameQuestions.getScienceQuestions().getFirst());
		assertEquals("Sports Question 0", gameQuestions.getSportsQuestions().getFirst());
		assertEquals("Rock Question 0", gameQuestions.getRockQuestions().getFirst());
	}
	
	@Test public void last_Question() {
		assertEquals("Pop Question 49", gameQuestions.getPopQuestions().getLast());
		assertEquals("Science Question 49", gameQuestions.getScienceQuestions().getLast());
		assertEquals("Sports Question 49", gameQuestions.getSportsQuestions().getLast());
		assertEquals("Rock Question 49", gameQuestions.getRockQuestions().getLast());
	}
	
}
