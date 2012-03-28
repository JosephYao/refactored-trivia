package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestGameAskQuestion extends Game {

	private String currentCategory;
	private TestGameAskQuestion game;
	private ByteArrayOutputStream spyOutput;

	@Before public void createTestGameAskQuestion() {
		game = new TestGameAskQuestion();
		spyOutput = AllTestsHelper.createSpySystemOut();
	}
	
	@Test public void ask_Question_With_Current_Category_Is_Pop() throws IOException {
		game.setCurrentCategory("Pop");
		
		game.askQuestion();
		
		assertOutputEquals("Pop Question 0");
		assertQuestionSizeEquals(AllTestsHelper.TOTAL_QUESTIONS - 1, game.popQuestions);
	}

	@Test public void ask_Question_With_Current_Category_Is_Science() throws IOException {
		game.setCurrentCategory("Science");
		
		game.askQuestion();
		
		assertOutputEquals("Science Question 0");
		assertQuestionSizeEquals(AllTestsHelper.TOTAL_QUESTIONS - 1, game.scienceQuestions);
	}
	
	@Test public void ask_Question_With_Current_Category_Is_Sports() throws IOException {
		game.setCurrentCategory("Sports");
		
		game.askQuestion();
		
		assertOutputEquals("Sports Question 0");
		assertQuestionSizeEquals(AllTestsHelper.TOTAL_QUESTIONS - 1, game.sportsQuestions);
	}
	
	@Test public void ask_Question_With_Current_Category_Is_Rock() throws IOException {
		game.setCurrentCategory("Rock");
		
		game.askQuestion();
		
		assertOutputEquals("Rock Question 0");
		assertQuestionSizeEquals(AllTestsHelper.TOTAL_QUESTIONS - 1, game.rockQuestions);
	}
	
	@Test public void ask_Question_Twice_With_Current_Category_Is_Pop() throws IOException {
		game.setCurrentCategory("Pop");
		
		askQuestionThenResetSpyOutput();
		game.askQuestion();

		assertOutputEquals("Pop Question 1");
		assertQuestionSizeEquals(AllTestsHelper.TOTAL_QUESTIONS - 2, game.popQuestions);
	}

	@Test public void ask_Question_Twice_With_Current_Category_Is_Science() throws IOException {
		game.setCurrentCategory("Science");
		
		askQuestionThenResetSpyOutput();
		game.askQuestion();

		assertOutputEquals("Science Question 1");
		assertQuestionSizeEquals(AllTestsHelper.TOTAL_QUESTIONS - 2, game.scienceQuestions);
	}

	@Test public void ask_Question_Twice_With_Current_Category_Is_Sports() throws IOException {
		game.setCurrentCategory("Sports");
		
		askQuestionThenResetSpyOutput();
		game.askQuestion();
		
		assertOutputEquals("Sports Question 1");
		assertQuestionSizeEquals(AllTestsHelper.TOTAL_QUESTIONS - 2, game.sportsQuestions);
	}
	
	@Test public void ask_Question_Twice_With_Current_Category_Is_Rock() throws IOException {
		game.setCurrentCategory("Rock");
		
		askQuestionThenResetSpyOutput();
		game.askQuestion();
		
		assertOutputEquals("Rock Question 1");
		assertQuestionSizeEquals(AllTestsHelper.TOTAL_QUESTIONS - 2, game.rockQuestions);
	}
	
	@After public void restoreSystemOutAndCloseSpyOutput() throws IOException {
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}

	public void setCurrentCategory(String theCurrentCategory) {
		currentCategory = theCurrentCategory;
	}
	
	protected String currentCategory() {
		return currentCategory;
	}
	
	private void assertOutputEquals(String expectedQuestion) {
		assertEquals(expectedQuestion + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
	}

	private void assertQuestionSizeEquals(int expectedSize, LinkedList<String> expectedQuestionList) {
		assertEquals(expectedSize, expectedQuestionList.size());
	}

	private void askQuestionThenResetSpyOutput() {
		game.askQuestion();
		spyOutput.reset();
	}

}
