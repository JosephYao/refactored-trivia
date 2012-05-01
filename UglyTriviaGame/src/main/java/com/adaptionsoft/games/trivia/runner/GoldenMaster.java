package com.adaptionsoft.games.trivia.runner;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class GoldenMaster {

	private GameRunner gameRunner;
	private String folder;

	public GoldenMaster(GameRunner aGameRunner, String aFolder) {
		gameRunner = aGameRunner;
		folder = aFolder;
	}

	public void generateLog(int seed) throws IOException {
		File log = new File(folder + seed + ".log");
		log.createNewFile();
		
		PrintStream systemOut = System.out;
		PrintStream logSystemOut = new PrintStream(log);
		System.setOut(logSystemOut);
		
		gameRunner.run(new String[]{String.valueOf(seed)});

		logSystemOut.close();
		System.setOut(systemOut);
	}
	
	public static void main(String[] args) throws IOException {
		GoldenMaster goldenMaster = new GoldenMaster(new GameRunner(), "C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Golden Master\\");
		for (int i = 0; i < 10000; i++)
			goldenMaster.generateLog(i);
	}

}
