package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

public class TestGameQuestionsSizeOfQuestion {

	GameQuestions gameQuestions = new GameQuestions();

	@Test public void pop_Question_Size_Reduced() {
		gameQuestions.askQuestion(0);
		assertQuestionSizeReducedByNumber(gameQuestions.popQuestions, 1);
		gameQuestions.askQuestion(0);
		assertQuestionSizeReducedByNumber(gameQuestions.popQuestions, 2);
	}
	
	@Test public void science_Question_Size_Reduced() {
		gameQuestions.askQuestion(1);
		assertQuestionSizeReducedByNumber(gameQuestions.scienceQuestions, 1);
		gameQuestions.askQuestion(1);
		assertQuestionSizeReducedByNumber(gameQuestions.scienceQuestions, 2);
	}
	
	@Test public void sports_Question_Size_Reduced() {
		gameQuestions.askQuestion(2);
		assertQuestionSizeReducedByNumber(gameQuestions.sportsQuestions, 1);
		gameQuestions.askQuestion(2);
		assertQuestionSizeReducedByNumber(gameQuestions.sportsQuestions, 2);
	}
	
	@Test public void rock_Question_Size_Reduced() {
		gameQuestions.askQuestion(3);
		assertQuestionSizeReducedByNumber(gameQuestions.rockQuestions, 1);
		gameQuestions.askQuestion(3);
		assertQuestionSizeReducedByNumber(gameQuestions.rockQuestions, 2);
	}
	
	private void assertQuestionSizeReducedByNumber(LinkedList<String> expectedQuestionList, int expectedReducedNumber) {
		assertEquals(AllTestsHelper.TOTAL_QUESTIONS - expectedReducedNumber, expectedQuestionList.size());
	}

}
