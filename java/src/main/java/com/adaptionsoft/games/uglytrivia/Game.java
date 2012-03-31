package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;

public class Game {
    ArrayList<String> players = new ArrayList<String>();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    
    GameQuestions questions;
    
    public  Game(){
    	questions = new GameQuestions();
    }

	public void add(String playerName) {
	    players.add(playerName);
	    
	    int playerIndex = players.size() - 1;
	    
		initializePlayerStatus(playerIndex);
	    
	    addOutputMessage(playerName, playerIndex + 1);
	}

	private void addOutputMessage(String playerName, int playerIndex) {
		System.out.println(playerName + " was added");
	    System.out.println("They are player number " + playerIndex);
	}

	private void initializePlayerStatus(int playerIndex) {
		places[playerIndex] = 0;
	    purses[playerIndex] = 0;
	    inPenaltyBox[playerIndex] = false;
	}
	
	public void roll(int roll) {
		rollOutputMessage(roll);
		
		if (!isCurrentPlayerInPenaltyBox() || isGettingOutOfPenaltyBox(roll)) {
			rollWhenNotInPenaltyBox(roll);
		}
	}

	protected void rollOutputMessage(int roll) {
		System.out.println(players.get(currentPlayer) + " is the current player");
		System.out.println("They have rolled a " + roll);
	}

	protected boolean isCurrentPlayerInPenaltyBox() {
		return inPenaltyBox[currentPlayer];
	}

	private boolean isGettingOutOfPenaltyBox(int roll) {
		isGettingOutOfPenaltyBox = roll % 2 != 0;
		if (isGettingOutOfPenaltyBox) {
			System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
		} else {
			System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
		}
		return isGettingOutOfPenaltyBox;
	}

	void rollWhenNotInPenaltyBox(int roll) {
		setCurrentPlayerPlace(roll);
		
		rollWhenNotInPenaltyBoxOutputMessage();
		
		askQuestion();
	}

	private void rollWhenNotInPenaltyBoxOutputMessage() {
		System.out.println(players.get(currentPlayer) 
				+ "'s new location is " 
				+ getCurrentPlayerPlace());
		System.out.println("The category is " + currentCategory());
	}

	private void setCurrentPlayerPlace(int roll) {
		places[currentPlayer] = (getCurrentPlayerPlace() + roll) % 12;
	}

	void askQuestion() {
		questions.askQuestion(getCurrentPlayerPlace());		
	}
	
	protected String currentCategory() {
		return questions.currentCategory(getCurrentPlayerPlace());
	}

	protected int getCurrentPlayerPlace() {
		return places[currentPlayer];
	}

	public boolean wasCorrectlyAnswered() {
		boolean notAWinner = true;
		
		if (!isCurrentPlayerInPenaltyBox() || isGettingOutOfPenaltyBox()) {
			currentPlayerPursesIncreasedByOne();

			wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBoxOutputMessage();
			
			notAWinner = isCurrentPlayerNotWin();
		}
		
		currentPlayerMoveToNext();

		return notAWinner;
	}

	private void currentPlayerPursesIncreasedByOne() {
		purses[currentPlayer]++;
	}

	private void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBoxOutputMessage() {
		System.out.println("Answer was correct!!!!");
		System.out.println(players.get(currentPlayer) 
				+ " now has "
				+ purses[currentPlayer]
				+ " Gold Coins.");
	}

	protected boolean isGettingOutOfPenaltyBox() {
		return isGettingOutOfPenaltyBox;
	}
	
	public boolean wrongAnswer(){
		wrongAnswerOutputMessage();

		currentPlayerGoIntoPenaltyBox();
		
		currentPlayerMoveToNext();

		return true;
	}

	private void currentPlayerGoIntoPenaltyBox() {
		inPenaltyBox[currentPlayer] = true;
	}

	private void currentPlayerMoveToNext() {
		currentPlayer = (currentPlayer + 1) % players.size();
	}

	private void wrongAnswerOutputMessage() {
		System.out.println("Question was incorrectly answered");
		System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
	}

	private boolean isCurrentPlayerNotWin() {
		return !(purses[currentPlayer] == 6);
	}
}
