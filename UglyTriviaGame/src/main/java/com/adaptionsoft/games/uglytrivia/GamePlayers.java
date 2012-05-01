package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GamePlayers {

    private ArrayList<String> players = new ArrayList<String>();
    private int[] places = new int[6];
    private int[] purses  = new int[6];
    private boolean[] inPenaltyBox  = new boolean[6];
    private int currentPlayer = 0;
    
    private boolean isGettingOutOfPenaltyBox;

    public void add(String playerName) {
	    players.add(playerName);
	    
	    int playerIndex = players.size() - 1;
	    
		initializePlayerStatus(playerIndex);
	    
	    addOutputMessage(playerName, playerIndex + 1);
	}
    
    public List<String> getAllPlayers() {
    	return Collections.unmodifiableList(players);
    }
    
    public int[] getAllPlayerPlaces() {
    	return Arrays.copyOf(places, places.length);
    }
    
    public int[] getAllPlayerPurses() {
    	return Arrays.copyOf(purses, purses.length);
    }
    
    public boolean[] getAllPlayerInPenaltyBox() {
    	return Arrays.copyOf(inPenaltyBox, inPenaltyBox.length);
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
	
	public boolean isCurrentPlayerInPenaltyBox() {
		return inPenaltyBox[currentPlayer];
	}

	public void currentPlayerGoIntoPenaltyBox() {
		inPenaltyBox[currentPlayer] = true;
	}
	
	public String getCurrentPlayer() {
		return players.get(currentPlayer);
	}

	public void setCurrentPlayerPlace(int roll) {
		places[currentPlayer] = (places[currentPlayer] + roll) % 12;
	}

	public int getCurrentPlayerPlace() {
		return places[currentPlayer];
	}

	public void currentPlayerPurseIncreasedByOne() {
		purses[currentPlayer]++;
	}
	
	public int getCurrentPlayerPurse() {
		return purses[currentPlayer];
	}

	public void currentPlayerMoveToNext() {
		currentPlayer = (currentPlayer + 1) % players.size();
	}

	public boolean isCurrentPlayerNotWin() {
		return !(purses[currentPlayer] == 6);
	}

	public boolean isGettingOutOfPenaltyBox(int roll) {
		isGettingOutOfPenaltyBox = roll % 2 != 0;
		if (isGettingOutOfPenaltyBox) {
			System.out.println(getCurrentPlayer() + " is getting out of the penalty box");
		} else {
			System.out.println(getCurrentPlayer() + " is not getting out of the penalty box");
		}
		return isGettingOutOfPenaltyBox;
	}
	
	public boolean getIsGettingOutOfPenaltyBox() {
		return isGettingOutOfPenaltyBox;
	}

}
