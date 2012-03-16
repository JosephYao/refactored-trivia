package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class TestGameCurrentCategory extends Game {

	private int currentPlayerPlace;
	private TestGameCurrentCategory game;

	@Before public void createTestGameCurrentCategory() {
		game = new TestGameCurrentCategory();
	}

	@Test public void current_Category_Returns_Pop() {
		game.setSpyCurrentPlayerPlace(0);
		assertEquals("Pop", game.currentCategory());
		game.setSpyCurrentPlayerPlace(4);
		assertEquals("Pop", game.currentCategory());
		game.setSpyCurrentPlayerPlace(8);
		assertEquals("Pop", game.currentCategory());
	}

	@Test public void current_Category_Returns_Science() {
		game.setSpyCurrentPlayerPlace(1);
		assertEquals("Science", game.currentCategory());
		game.setSpyCurrentPlayerPlace(5);
		assertEquals("Science", game.currentCategory());
		game.setSpyCurrentPlayerPlace(9);
		assertEquals("Science", game.currentCategory());
	}

	@Test public void current_Category_Returns_Sports() {
		game.setSpyCurrentPlayerPlace(2);
		assertEquals("Sports", game.currentCategory());
		game.setSpyCurrentPlayerPlace(6);
		assertEquals("Sports", game.currentCategory());
		game.setSpyCurrentPlayerPlace(10);
		assertEquals("Sports", game.currentCategory());
	}

	@Test public void current_Category_Returns_Rock() {
		game.setSpyCurrentPlayerPlace(3);
		assertEquals("Rock", game.currentCategory());
		game.setSpyCurrentPlayerPlace(7);
		assertEquals("Rock", game.currentCategory());
		game.setSpyCurrentPlayerPlace(11);
		assertEquals("Rock", game.currentCategory());
	}

	public void setSpyCurrentPlayerPlace(int spyCurrentPlayerPlace) {
		currentPlayerPlace = spyCurrentPlayerPlace;
	}
	
	protected int getCurrentPlayerPlace() {
		return currentPlayerPlace;
	}
	
}
