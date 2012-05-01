package com.adaptionsoft.games.uglytrivia.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.adaptionsoft.games.uglytrivia.GameQuestions;

public class TestGameQuestionsSizeOfQuestion {

	GameQuestions gameQuestions = new GameQuestions();
	
	@Test public void pop_Question_Size_Reduced() {
		gameQuestions.askQuestion(0);
		assertQuestionSizeReducedByNumber(gameQuestions.getPopQuestions(), 1);
		gameQuestions.askQuestion(0);
		assertQuestionSizeReducedByNumber(gameQuestions.getPopQuestions(), 2);
	}
	
	@Test public void science_Question_Size_Reduced() {
		gameQuestions.askQuestion(1);
		assertQuestionSizeReducedByNumber(gameQuestions.getScienceQuestions(), 1);
		gameQuestions.askQuestion(1);
		assertQuestionSizeReducedByNumber(gameQuestions.getScienceQuestions(), 2);
	}
	
	@Test public void sports_Question_Size_Reduced() {
		gameQuestions.askQuestion(2);
		assertQuestionSizeReducedByNumber(gameQuestions.getSportsQuestions(), 1);
		gameQuestions.askQuestion(2);
		assertQuestionSizeReducedByNumber(gameQuestions.getSportsQuestions(), 2);
	}
	
	@Test public void rock_Question_Size_Reduced() {
		gameQuestions.askQuestion(3);
		assertQuestionSizeReducedByNumber(gameQuestions.getRockQuestions(), 1);
		gameQuestions.askQuestion(3);
		assertQuestionSizeReducedByNumber(gameQuestions.getRockQuestions(), 2);
	}
	
	private void assertQuestionSizeReducedByNumber(List<String> expectedQuestionList, int expectedReducedNumber) {
		assertEquals(AllTestsHelper.TOTAL_QUESTIONS - expectedReducedNumber, expectedQuestionList.size());
	}

}
