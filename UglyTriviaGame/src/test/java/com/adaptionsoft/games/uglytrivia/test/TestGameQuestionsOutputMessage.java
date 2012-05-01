package com.adaptionsoft.games.uglytrivia.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.adaptionsoft.games.uglytrivia.GameQuestions;

@RunWith(Parameterized.class)
public class TestGameQuestionsOutputMessage {

	private GameQuestions gameQuestions = new GameQuestions();
	private ByteArrayOutputStream spyOutput;
	private int currentPlayerPlace;
	private String expectedOutputMessage;

	@Parameterized.Parameters
	public static Collection<Object[]> currentPlayerPlacesAndExpectedOutputMessage() {
		return Arrays.asList(new Object[][]{
				{0, "Pop Question"},{4, "Pop Question"},{8, "Pop Question"},
				{1, "Science Question"},{5, "Science Question"},{9, "Science Question"},
				{2, "Sports Question"},{6, "Sports Question"},{10, "Sports Question"},
				{3, "Rock Question"},{7, "Rock Question"},{11, "Rock Question"}});
	}
	
	public TestGameQuestionsOutputMessage(int theCurrentPlayerPlace, String theExpectedOutputMessage) {
		currentPlayerPlace = theCurrentPlayerPlace;
		expectedOutputMessage = theExpectedOutputMessage;
	}
	
	@Test public void question_Output_Message() throws IOException {
		setSpyOutputAndThenAskQuestion();
		assertOutputEquals(expectedOutputMessage, 0);
	}

	@Test public void question_Output_Message_Twice() {
		gameQuestions.askQuestion(currentPlayerPlace);
		setSpyOutputAndThenAskQuestion();
		assertOutputEquals(expectedOutputMessage, 1);
	}
	
	@Test public void question_Output_Message_Three_Times() {
		gameQuestions.askQuestion(currentPlayerPlace);
		gameQuestions.askQuestion(currentPlayerPlace);
		setSpyOutputAndThenAskQuestion();
		assertOutputEquals(expectedOutputMessage, 2);
	}
	
	@After public void restoreSystemOutAndCloseSpyOutput() throws IOException {
		AllTestsHelper.restoreSystemOutAndCloseSpyOutput(spyOutput);
	}
	
	private void setSpyOutputAndThenAskQuestion() {
		spyOutput = AllTestsHelper.createSpySystemOut();
		gameQuestions.askQuestion(currentPlayerPlace);
	}
	
	private void assertOutputEquals(String expectedQuestion, int expectedQuestionId) {
		assertEquals(expectedQuestion + " " + expectedQuestionId + AllTestsHelper.LINE_SEPARATOR, spyOutput.toString());
	}

}
