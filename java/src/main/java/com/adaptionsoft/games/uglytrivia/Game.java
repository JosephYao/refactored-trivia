package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    ArrayList<String> players = new ArrayList<String>();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];
    
    LinkedList<String> popQuestions = new LinkedList<String>();
    LinkedList<String> scienceQuestions = new LinkedList<String>();
    LinkedList<String> sportsQuestions = new LinkedList<String>();
    LinkedList<String> rockQuestions = new LinkedList<String>();
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    
    public  Game(){
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

	public void add(String playerName) {
	    players.add(playerName);
	    
	    int playerIndex = players.size() - 1;
	    
		initializePlayerStatus(playerIndex);
	    
	    addMessageOutput(playerName, playerIndex + 1);
	}

	private void addMessageOutput(String playerName, int playerIndex) {
		System.out.println(playerName + " was added");
	    System.out.println("They are player number " + playerIndex);
	}

	private void initializePlayerStatus(int playerIndex) {
		places[playerIndex] = 0;
	    purses[playerIndex] = 0;
	    inPenaltyBox[playerIndex] = false;
	}
	
	public void roll(int roll) {
		System.out.println(players.get(currentPlayer) + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		internalRoll(roll);
		
	}

	protected void internalRoll(int roll) {
		if (isCurrentPlayerInPenaltyBox()) {
			internalRollWhenInPenaltyBox(roll);
			
		} else {
		
			internalRollWhenNotInPenaltyBox(roll);
		}
	}

	protected boolean isCurrentPlayerInPenaltyBox() {
		return inPenaltyBox[currentPlayer];
	}

	void internalRollWhenInPenaltyBox(int roll) {
		if (roll % 2 != 0) {
			isGettingOutOfPenaltyBox = true;
			
			System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
			internalRollWhenNotInPenaltyBox(roll);
		} else {
			System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
			isGettingOutOfPenaltyBox = false;
			}
	}

	void internalRollWhenNotInPenaltyBox(int roll) {
		places[currentPlayer] = getCurrentPlayerPlace() + roll;
		if (getCurrentPlayerPlace() > 11) places[currentPlayer] = getCurrentPlayerPlace() - 12;
		
		System.out.println(players.get(currentPlayer) 
				+ "'s new location is " 
				+ getCurrentPlayerPlace());
		System.out.println("The category is " + currentCategory());
		askQuestion();
	}

	void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(rockQuestions.removeFirst());		
	}
		
	String currentCategory() {
		switch (getCurrentPlayerPlace()) {
		case 0:
		case 4:
		case 8:
			return "Pop";
		case 1:
		case 5:
		case 9:
			return "Science";
		case 2:
		case 6:
		case 10:
			return "Sports";
		default:
			return "Rock";
		}
	}

	protected int getCurrentPlayerPlace() {
		return places[currentPlayer];
	}

	public boolean wasCorrectlyAnswered() {
		if (isCurrentPlayerInPenaltyBox()){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				purses[currentPlayer]++;
				System.out.println(players.get(currentPlayer) 
						+ " now has "
						+ purses[currentPlayer]
						+ " Gold Coins.");
				
				boolean winner = didPlayerWin();
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				
				return winner;
			} else {
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
			}
			
			
			
		} else {
		
			System.out.println("Answer was corrent!!!!");
			purses[currentPlayer]++;
			System.out.println(players.get(currentPlayer) 
					+ " now has "
					+ purses[currentPlayer]
					+ " Gold Coins.");
			
			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;
			
			return winner;
		}
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;
		
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}


	private boolean didPlayerWin() {
		return !(purses[currentPlayer] == 6);
	}
}
