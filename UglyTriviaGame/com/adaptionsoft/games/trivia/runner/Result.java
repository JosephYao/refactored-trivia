package com.adaptionsoft.games.trivia.runner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Result {

	public static void main(String[] args) throws IOException {
		GoldenMaster result = new GoldenMaster(new GameRunner(), "C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Result\\");
		for (int i = 0; i < 10000; i++)
			result.generateLog(i);
	}

	public static boolean compare() throws IOException {
		boolean compareResult = true;
		
		for (int i = 0; i < 10000; i++) {
			File goldenMasterFile = new File("C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Golden Master\\" + i + ".log");
			File resultFile = new File("C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Result\\" + i + ".log");
			compareResult &= FileUtils.contentEquals(goldenMasterFile, resultFile);
		}
		
		return compareResult;
	}

}
