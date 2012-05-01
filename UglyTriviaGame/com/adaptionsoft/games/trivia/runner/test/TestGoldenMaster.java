package com.adaptionsoft.games.trivia.runner.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

import com.adaptionsoft.games.trivia.runner.GoldenMaster;


public class TestGoldenMaster {

	private GoldenMaster goldenMaster = new GoldenMaster(new NullGameRunner(), "C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Golden Master\\");

	@Test public void generate_Log_File() throws IOException {
		generateLogFile(1);
		
		assertFileExists(1);
	}

	@Test public void remove_Old_Log_File_With_Same_Name_And_Then_Generate() throws IOException {
		generateLogFile(1);
		generateLogFile(1);
		
		assertFileExists(1);
	}
	
	@Test public void generate_Another_Log_File() throws IOException {
		generateLogFile(2);
		
		assertFileExists(2);
	}
	
	@After public void removeFiles() {
		File goldenMasterFolder = new File("C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Golden Master\\");
		for (File log : goldenMasterFolder.listFiles())
			log.delete();
	}
	
	private void generateLogFile(int seed) throws IOException {
		goldenMaster.generateLog(seed);
	}
	
	private void assertFileExists(int seed) {
		assertTrue(new File("C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Golden Master\\" + seed + ".log").exists());
	}

}
