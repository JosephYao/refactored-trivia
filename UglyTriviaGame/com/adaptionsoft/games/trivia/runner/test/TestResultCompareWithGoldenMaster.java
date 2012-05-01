package com.adaptionsoft.games.trivia.runner.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

import com.adaptionsoft.games.trivia.runner.GoldenMaster;
import com.adaptionsoft.games.trivia.runner.Result;


public class TestResultCompareWithGoldenMaster {

	@Test public void result_Compare_With_Same_Golden_Master() throws IOException {
		GoldenMaster goldenMaster = new GoldenMaster(new SpyGameRunner());
		goldenMaster.generateLog(1);
		
		GoldenMaster result = new GoldenMaster(new SpyGameRunner(), "C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Result\\");
		result.generateLog(1);
		
		assertTrue(Result.compare());
	}
	
	@Test public void result_Compare_With_Different_Golden_Master() throws IOException {
		GoldenMaster goldenMaster = new GoldenMaster(new SpyGameRunner());
		goldenMaster.generateLog(2);
		
		GoldenMaster result = new GoldenMaster(new DifferentGameRunner(), "C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Result\\");
		result.generateLog(2);
		
		assertFalse(Result.compare());
	}
	
	@After public void removeFiles() {
		File goldenMasterFolder = new File("C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Golden Master\\");
		for (File log : goldenMasterFolder.listFiles())
			log.delete();
		File resultFolder = new File("C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Result\\");
		for (File log : resultFolder.listFiles())
			log.delete();
	}
	
}
