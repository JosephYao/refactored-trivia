package com.adaptionsoft.games.uglytrivia.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.adaptionsoft.games.uglytrivia.GameQuestions;

@RunWith(Parameterized.class)
public class TestGameQuestionsCurrentCategory {

	private int currentPlayerPlace;
	private String expectedCategory;

	@Parameterized.Parameters
	public static Collection<Object[]> currentPlayerPlacesAndExpectedCategories() {
		return Arrays.asList(new Object[][]{
				{0, "Pop"}, {4, "Pop"}, {8, "Pop"},
				{1, "Science"}, {5, "Science"}, {9, "Science"},
				{2, "Sports"}, {6, "Sports"}, {10, "Sports"},
				{3, "Rock"}, {7, "Rock"}, {11, "Rock"}});
	}
	
	public TestGameQuestionsCurrentCategory(int theCurrentPlayerPlace, String theExpectedCategory) {
		currentPlayerPlace = theCurrentPlayerPlace;
		expectedCategory = theExpectedCategory;
	}
	
	@Test public void pop_Category() {
		GameQuestions questions = new GameQuestions();
		assertEquals(expectedCategory, questions.currentCategory(currentPlayerPlace));
	}
	
}
