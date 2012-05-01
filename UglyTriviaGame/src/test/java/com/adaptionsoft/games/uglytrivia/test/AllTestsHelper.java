package com.adaptionsoft.games.uglytrivia.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class AllTestsHelper {

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	public static final int TOTAL_QUESTIONS = 50;
	
	private static final PrintStream systemOut = System.out;
	
	public static ByteArrayOutputStream createSpySystemOut() {
		ByteArrayOutputStream spyOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(spyOutput));
		return spyOutput;
	}
	
	public static void restoreSystemOutAndCloseSpyOutput(ByteArrayOutputStream spyOutput) throws IOException {
		spyOutput.close();
		System.setOut(systemOut);
	}
	
}
