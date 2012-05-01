package com.adaptionsoft.games.trivia.runner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Result {

	public static void main(String[] args) throws IOException {
		File resultFolder = new File("C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Result\\");
		for (File log : resultFolder.listFiles())
			log.delete();

		GoldenMaster result = new GoldenMaster(new GameRunner(), "C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Result\\");
		for (int i = 0; i < 10000; i++)
			result.generateLog(i);
		
		boolean same = true;
		for (int i = 0; i < 10000; i++) {
			boolean iSame = compare(i);
			if (!iSame) 
				println(i + ".log is not the same.");
			same &= iSame;
		}
		if (same) {
			println("All is same");
		} else {
			println("Not All is same");
		}
	}

	private static void println(String message) {
		System.out.println(message);
	}

	public static boolean compare(int seed) throws IOException {
		boolean compareResult = true;
		
		File goldenMasterFile = new File("C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Golden Master\\" + seed + ".log");
		File resultFile = new File("C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Result\\" + seed + ".log");
		compareResult &= FileUtils.contentEquals(goldenMasterFile, resultFile);
		
		return compareResult;
	}

}
