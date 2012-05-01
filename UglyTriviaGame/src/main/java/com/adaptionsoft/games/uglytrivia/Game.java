package com.adaptionsoft.games.uglytrivia;

public class Game {
    private GameQuestions questions;
    private GamePlayers players;
    
    public Game() {
    	this(new GameQuestions(), new GamePlayers());
    }
    
    public Game(GameQuestions theQuestions, GamePlayers thePlayers) {
    	questions = theQuestions;
    	players = thePlayers;
    }

	public void add(String playerName) {
		players.add(playerName);
	}

	public void roll(int roll) {
		rollOutputMessage(roll);
		
		if (!players.isCurrentPlayerInPenaltyBox() || players.isGettingOutOfPenaltyBox(roll)) {
			rollWhenNotInPenaltyBox(roll);
		}
	}

	private void rollOutputMessage(int roll) {
		System.out.println(players.getCurrentPlayer() + " is the current player");
		System.out.println("They have rolled a " + roll);
	}
	
	private void rollWhenNotInPenaltyBox(int roll) {
		players.setCurrentPlayerPlace(roll);
		
		rollWhenNotInPenaltyBoxOutputMessage();
		
		questions.askQuestion(players.getCurrentPlayerPlace());
	}

	private void rollWhenNotInPenaltyBoxOutputMessage() {
		System.out.println(players.getCurrentPlayer() 
				+ "'s new location is " 
				+ players.getCurrentPlayerPlace());
		System.out.println("The category is " + questions.currentCategory(players.getCurrentPlayerPlace()));
	}

	public boolean wasCorrectlyAnswered() {
		boolean notAWinner = true;
		
		if (!players.isCurrentPlayerInPenaltyBox() || players.getIsGettingOutOfPenaltyBox()) {
			players.currentPlayerPurseIncreasedByOne();

			wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBoxOutputMessage();
			
			notAWinner = players.isCurrentPlayerNotWin();
		}
		
		players.currentPlayerMoveToNext();

		return notAWinner;
	}

	private void wasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBoxOutputMessage() {
		System.out.println("Answer was correct!!!!");
		System.out.println(players.getCurrentPlayer() 
				+ " now has "
				+ players.getCurrentPlayerPurse()
				+ " Gold Coins.");
	}

	public boolean wrongAnswer(){
		wrongAnswerOutputMessage();

		players.currentPlayerGoIntoPenaltyBox();
		
		players.currentPlayerMoveToNext();

		return true;
	}

	private void wrongAnswerOutputMessage() {
		System.out.println("Question was incorrectly answered");
		System.out.println(players.getCurrentPlayer()+ " was sent to the penalty box");
	}
	
}
