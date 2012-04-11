package com.adaptionsoft.games.uglytrivia;

public class Game {
    boolean isGettingOutOfPenaltyBox;
    
    GameQuestions questions;
    GamePlayers gamePlayers;
    
    public Game() {
    	this(new GameQuestions(), new GamePlayers());
    }
    
    public Game(GameQuestions theQuestions, GamePlayers thePlayers) {
    	questions = theQuestions;
    	gamePlayers = thePlayers;
    }

	public void add(String playerName) {
		gamePlayers.add(playerName);
	}

	public void roll(int roll) {
		rollOutputMessage(roll);
		
		if (!gamePlayers.isCurrentPlayerInPenaltyBox() || isGettingOutOfPenaltyBox(roll)) {
			rollWhenNotInPenaltyBox(roll);
		}
	}

	protected void rollOutputMessage(int roll) {
		System.out.println(gamePlayers.getCurrentPlayer() + " is the current player");
		System.out.println("They have rolled a " + roll);
	}

	protected boolean isGettingOutOfPenaltyBox(int roll) {
		isGettingOutOfPenaltyBox = roll % 2 != 0;
		if (isGettingOutOfPenaltyBox) {
			System.out.println(gamePlayers.getCurrentPlayer() + " is getting out of the penalty box");
		} else {
			System.out.println(gamePlayers.getCurrentPlayer() + " is not getting out of the penalty box");
		}
		return isGettingOutOfPenaltyBox;
	}

	void rollWhenNotInPenaltyBox(int roll) {
		gamePlayers.setCurrentPlayerPlace(roll);
		
		rollWhenNotInPenaltyBoxOutputMessage();
		
		questions.askQuestion(gamePlayers.getCurrentPlayerPlace());
	}

	protected void rollWhenNotInPenaltyBoxOutputMessage() {
		System.out.println(gamePlayers.getCurrentPlayer() 
				+ "'s new location is " 
				+ gamePlayers.getCurrentPlayerPlace());
		System.out.println("The category is " + questions.currentCategory(gamePlayers.getCurrentPlayerPlace()));
	}

	public boolean wasCorrectlyAnswered() {
		boolean notAWinner = true;
		
		if (!gamePlayers.isCurrentPlayerInPenaltyBox() || isGettingOutOfPenaltyBox()) {
			gamePlayers.currentPlayerPursesIncreasedByOne();

			wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBoxOutputMessage();
			
			notAWinner = gamePlayers.isCurrentPlayerNotWin();
		}
		
		gamePlayers.currentPlayerMoveToNext();

		return notAWinner;
	}

	private void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBoxOutputMessage() {
		System.out.println("Answer was correct!!!!");
		System.out.println(gamePlayers.getCurrentPlayer() 
				+ " now has "
				+ gamePlayers.getCurrentPlayerPurses()
				+ " Gold Coins.");
	}

	protected boolean isGettingOutOfPenaltyBox() {
		return isGettingOutOfPenaltyBox;
	}
	
	public boolean wrongAnswer(){
		wrongAnswerOutputMessage();

		gamePlayers.currentPlayerGoIntoPenaltyBox();
		
		gamePlayers.currentPlayerMoveToNext();

		return true;
	}

	private void wrongAnswerOutputMessage() {
		System.out.println("Question was incorrectly answered");
		System.out.println(gamePlayers.getCurrentPlayer()+ " was sent to the penalty box");
	}
}
