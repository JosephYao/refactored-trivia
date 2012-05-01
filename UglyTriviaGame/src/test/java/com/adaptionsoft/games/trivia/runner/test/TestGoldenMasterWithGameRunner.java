package com.adaptionsoft.games.trivia.runner.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.After;
import org.junit.Test;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import com.adaptionsoft.games.trivia.runner.GoldenMaster;


public class TestGoldenMasterWithGameRunner {

	@Test public void write_Game_Runner_Output_To_File() throws IOException {
		GameRunner spyGameRunner = new SpyGameRunner();
		GoldenMaster goldenMaster = new GoldenMaster(spyGameRunner, "C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Golden Master\\");
		
		goldenMaster.generateLog(1);
		
		Scanner file = new Scanner(new File("C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Golden Master\\1.log"));
		assertEquals("From System.out.println", file.nextLine());
		
		file.close();
	}
	
	@After public void removeFiles() {
		File goldenMasterFolder = new File("C:\\Users\\yaoj\\Documents\\Git\\trivia\\java\\Golden Master\\");
		for (File log : goldenMasterFolder.listFiles())
			log.delete();
	}
	
}
