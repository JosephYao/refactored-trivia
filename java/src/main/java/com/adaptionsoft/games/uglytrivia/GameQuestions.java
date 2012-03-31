package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class GameQuestions {

    LinkedList<String> popQuestions = new LinkedList<String>();
    LinkedList<String> scienceQuestions = new LinkedList<String>();
    LinkedList<String> sportsQuestions = new LinkedList<String>();
    LinkedList<String> rockQuestions = new LinkedList<String>();

    public GameQuestions() {
    	for (int i = 0; i < 50; i++) {
			initializeQuestions(i);
    	}
    }

	private void initializeQuestions(int i) {
		popQuestions.addLast("Pop Question " + i);
		scienceQuestions.addLast(("Science Question " + i));
		sportsQuestions.addLast(("Sports Question " + i));
		rockQuestions.addLast(("Rock Question " + i));
	}

	public void askQuestion(int currentPlayerPlace) {
		if (currentCategory(currentPlayerPlace) == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory(currentPlayerPlace) == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory(currentPlayerPlace) == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory(currentPlayerPlace) == "Rock")
			System.out.println(rockQuestions.removeFirst());		
	}
	
	private static final String[] CATEGORIES = 
		new String[]{"Pop", "Science", "Sports", "Rock", "Pop", "Science", "Sports", "Rock", "Pop", "Science", "Sports", "Rock"};
	
	public String currentCategory(int currentPlayerPlace) {
		return CATEGORIES[currentPlayerPlace];
	}

}
