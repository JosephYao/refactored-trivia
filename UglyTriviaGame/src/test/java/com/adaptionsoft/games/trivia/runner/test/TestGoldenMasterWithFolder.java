package com.adaptionsoft.games.trivia.runner.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

import com.adaptionsoft.games.trivia.runner.GoldenMaster;

public class TestGoldenMasterWithFolder {

	@Test public void generate_Log_Under_Predefined_Folder() throws IOException {
		GoldenMaster goldenMaster = new GoldenMaster(new NullGameRunner(), "C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Result\\");
		goldenMaster.generateLog(1);
		
		assertTrue(new File("C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Result\\1.log").exists());
	}
	
	@After public void removeFiles() {
		File resultFolder = new File("C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Result\\");
		for (File log : resultFolder.listFiles())
			log.delete();
	}
	
}
